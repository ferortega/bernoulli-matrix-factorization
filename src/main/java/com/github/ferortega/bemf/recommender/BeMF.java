package com.github.ferortega.bemf.recommender;

import com.github.ferortega.bemf.experiment.Settings;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.Item;
import es.upm.etsisi.cf4j.data.User;
import es.upm.etsisi.cf4j.recommender.Recommender;
import es.upm.etsisi.cf4j.util.Maths;
import es.upm.etsisi.cf4j.util.process.Parallelizer;
import es.upm.etsisi.cf4j.util.process.Partible;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class BeMF extends Recommender implements PredictionReliabilityRecommender, RecommendationReliabilityRecommender {

    private int numFactors;

    private int numIters;

    private double learningRate;

    private double regularization;

    private double[] ratings;

    private double[][][] U;

    private double[][][] V;

    public BeMF(DataModel datamodel, Map<String, Object> params) {
        this(
                datamodel,
                (int) params.get("numFactors"),
                (int) params.get("numIters"),
                (double) params.get("learningRate"),
                (double) params.get("regularization"),
                (double[]) params.get("ratings"),
                params.containsKey("seed") ? (long) params.get("seed") : System.currentTimeMillis()
        );
    }

    public BeMF(DataModel datamodel, int numFactors, int numIters, double learningRate, double regularization, double[] ratings, long seed) {
        super(datamodel);

        this.numFactors = numFactors;
        this.numIters = numIters;
        this.learningRate = learningRate;
        this.regularization = regularization;
        this.ratings = ratings;

        Random rand = new Random(seed);

        this.U = new double[ratings.length][datamodel.getNumberOfUsers()][numFactors];
        for (int r = 0; r < ratings.length; r++) {
            for (int u = 0; u < datamodel.getNumberOfUsers(); u++) {
                for (int k = 0; k < numFactors; k++) {
                    this.U[r][u][k] = rand.nextDouble();
                }
            }
        }


        this.V = new double[ratings.length][datamodel.getNumberOfItems()][numFactors];
        for (int r = 0; r < ratings.length; r++) {
            for (int i = 0; i < datamodel.getNumberOfItems(); i++) {
                for (int k = 0; k < numFactors; k++) {
                    this.V[r][i][k] = rand.nextDouble();
                }
            }
        }
    }

    public int getNumFactors() {
        return numFactors;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public double getRegularization() {
        return regularization;
    }

    public double[] getRatings() {
        return ratings;
    }

    @Override
    public void fit() {
        System.out.println("\nFitting " + this.toString());

        for (int iter = 1; iter <= this.numIters; iter++) {
            for (int r = 0; r < this.ratings.length; r++) {
                Parallelizer.exec(this.datamodel.getUsers(), new UpdateUsersFactors(U[r], V[r], ratings[r]));
                Parallelizer.exec(this.datamodel.getItems(), new UpdateItemsFactors(U[r], V[r], ratings[r]));
            }

            if ((iter % 10) == 0) System.out.print(".");
            if ((iter % 100) == 0) System.out.println(iter + " iterations");
        }
    }

    @Override
    public double predict(int userIndex, int itemIndex) {
        double max = this.getProbability(userIndex, itemIndex, 0);
        int index = 0;

        for (int r = 1; r < this.ratings.length; r++) {
            double prob = this.getProbability(userIndex, itemIndex, r);
            if (max < prob) {
                max = prob;
                index = r;
            }
        }

        return this.ratings[index];
    }

    private double getProbability(int userIndex, int itemIndex, int r) {
        double dot = Maths.logistic(Maths.dotProduct(this.U[r][userIndex], this.V[r][itemIndex]));

        double sum = 0;
        for (int i = 0; i < this.ratings.length; i++) {
            sum += Maths.logistic(Maths.dotProduct(this.U[i][userIndex], this.V[i][itemIndex]));
        }

        return dot / sum;
    }

    @Override
    public double getPredictionReliability(int userIndex, int itemIndex) {
        double prediction = this.predict(userIndex, itemIndex);

        int r = 0;
        while (this.ratings[r] != prediction) {
            r++;
        }

        return this.getProbability(userIndex, itemIndex, r);
    }

    @Override
    public double getRecommendationReliability(int userIndex, int itemIndex) {
        double reliability = 0;
        for (int r = 0; r < this.ratings.length; r++) {
            double rating = this.ratings[r];
            if (rating >= Settings.LIKE_THRESHOLD) {
                reliability += this.getProbability(userIndex, itemIndex, r);
            }
        }
        return reliability;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("BeMF(")
                .append("numFactors=").append(this.numFactors)
                .append("; ")
                .append("numIters=").append(this.numIters)
                .append("; ")
                .append("learningRate=").append(this.learningRate)
                .append("; ")
                .append("regularization=").append(this.regularization)
                .append("; ")
                .append("ratings=").append(Arrays.toString(this.ratings))
                .append(")");
        return str.toString();
    }

    /**
     * Auxiliary inner class to parallelize user factors computation
     */
    private class UpdateUsersFactors implements Partible<User> {

        private double rating;

        private double[][] U;

        private double[][] V;

        public UpdateUsersFactors(double[][] U, double[][] V, double rating) {
            this.U = U;
            this.V = V;
            this.rating = rating;
        }

        @Override
        public void beforeRun() { }

        @Override
        public void run(User user) {
            int userIndex = user.getUserIndex();

            double[] gradient = new double[numFactors];

            for (int pos = 0; pos < user.getNumberOfRatings(); pos++) {
                boolean oneHot = user.getRatingAt(pos) == rating;

                int itemIndex = user.getItemAt(pos);
                double dot = Maths.dotProduct(U[userIndex], V[itemIndex]);

                for (int k = 0; k < numFactors; k++) {
                    if (oneHot) {
                        gradient[k] += (1 - Maths.logistic(dot)) * V[itemIndex][k];
                    } else {
                        gradient[k] -= Maths.logistic(dot) * V[itemIndex][k];
                    }
                }
            }

            for (int k = 0; k < numFactors; k++) {
                U[userIndex][k] += learningRate * (gradient[k] - regularization * U[userIndex][k]);
            }
        }

        @Override
        public void afterRun() { }
    }

    /**
     * Auxiliary inner class to parallelize item factors computation
     */
    private class UpdateItemsFactors implements Partible<Item> {

        private double rating;

        private double[][] U;

        private double[][] V;

        public UpdateItemsFactors(double[][] U, double[][] V, double rating) {
            this.U = U;
            this.V = V;
            this.rating = rating;
        }

        @Override
        public void beforeRun() { }

        @Override
        public void run(Item item) {
            int itemIndex = item.getItemIndex();

            double[] gradient = new double[numFactors];

            for (int pos = 0; pos < item.getNumberOfRatings(); pos++) {
                boolean oneHot = item.getRatingAt(pos) == rating;

                int userIndex = item.getUserAt(pos);
                double dot = Maths.dotProduct(U[userIndex], V[itemIndex]);

                for (int k = 0; k < numFactors; k++) {
                    if (oneHot) {
                        gradient[k] += (1 - Maths.logistic(dot)) * U[userIndex][k];
                    } else {
                        gradient[k] -= Maths.logistic(dot) * U[userIndex][k];
                    }
                }
            }

            for (int k = 0; k < numFactors; k++) {
                V[itemIndex][k] += learningRate * (gradient[k] - regularization * V[itemIndex][k]);
            }
        }

        @Override
        public void afterRun() { }
    }
}
