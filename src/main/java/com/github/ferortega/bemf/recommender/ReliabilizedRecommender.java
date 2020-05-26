package com.github.ferortega.bemf.recommender;

import es.upm.etsisi.cf4j.data.Item;
import es.upm.etsisi.cf4j.data.User;
import es.upm.etsisi.cf4j.recommender.Recommender;
import es.upm.etsisi.cf4j.util.Maths;
import es.upm.etsisi.cf4j.util.process.Parallelizer;
import es.upm.etsisi.cf4j.util.process.Partible;

import java.util.Random;

/**
 * Implements Zhu,  F.  Ortega,  J.  Bobadilla,  A.  Gutíerrez,   Assigning  reliability  values  to  recommendations
 * using matrix factorization,  Journal of computational science 26 (2018) 165–177
 */
public class ReliabilizedRecommender extends Recommender implements PredictionReliabilityRecommender {

    private Recommender recommender;

    private int numFactors;
    private int numIters;

    private double learningRate;
    private double regularization;

    private double[][] P;
    private double[][] Q;

    public ReliabilizedRecommender(Recommender recommender, int numFactors, int numIters, double learningRate, double regularization, long seed) {
        super(recommender.getDataModel());
        this.recommender = recommender;
        this.numFactors = numFactors;
        this.numIters = numIters;
        this.learningRate = learningRate;
        this.regularization = regularization;

        int numUsers = super.datamodel.getNumberOfUsers();
        int numItems = super.datamodel.getNumberOfItems();

        Random rand = new Random(seed);

        this.P = new double[numUsers][numFactors];
        for (int userIndex = 0; userIndex < numUsers; userIndex++) {
            for (int k = 0; k < numFactors; k++) {
                this.P[userIndex][k] = rand.nextDouble();
            }
        }

        this.Q = new double[numItems][numFactors];
        for (int itemIndex = 0; itemIndex < numItems; itemIndex++) {
            for (int k = 0; k < numFactors; k++) {
                this.Q[itemIndex][k] = rand.nextDouble();
            }
        }
    }

    @Override
    public void fit() {
        System.out.println("\nFitting " + this.toString());

        for (int iter = 1; iter <= this.numIters; iter++) {
            Parallelizer.exec(super.datamodel.getUsers(), new UpdateUsersFactors());
            Parallelizer.exec(super.datamodel.getItems(), new UpdateItemsFactors());
        }
    }

    @Override
    public double predict(int userIndex, int itemIndex) {
        return this.recommender.predict(userIndex, itemIndex);
    }

    @Override
    public double getPredictionReliability(int userIndex, int itemIndex) {
        double[] pu = this.P[userIndex];
        double[] qi = this.Q[itemIndex];

        double dot = Maths.dotProduct(pu, qi);
        double reliability = 1 - dot;

        return Math.max(0, Math.min(1, reliability));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("ReliabilizedRecommender(")
                .append("numFactors=").append(this.numFactors)
                .append("; ")
                .append("numIters=").append(this.numIters)
                .append("; ")
                .append("learningRate=").append(this.learningRate)
                .append("; ")
                .append("regularization=").append(this.regularization)
                .append(")");
        return str.toString();
    }

    private class UpdateUsersFactors implements Partible<User> {

        @Override
        public void beforeRun() { }

        @Override
        public void run(User user) {
            int userIndex = user.getUserIndex();

            for (int pos = 0; pos < user.getNumberOfRatings(); pos++) {
                int itemIndex = user.getItemAt(pos);

                // Get rating prediction error
                double prediction = ReliabilizedRecommender.this.predict(userIndex, itemIndex);
                double rating = user.getRatingAt(pos);

                double predictionError = Math.abs(prediction - rating);
                double maxPredictionError = datamodel.getMaxRating() - datamodel.getMinRating();
                double normalizedPredictionError = predictionError / maxPredictionError;

                // Get reliability error
                double reliability = ReliabilizedRecommender.this.getPredictionReliability(userIndex, itemIndex);
                double reliabilityError = normalizedPredictionError - (1.0 - reliability);

                // Update latent factors
                for (int k = 0; k < numFactors; k++)	{
                    P[userIndex][k] += learningRate * (reliabilityError * Q[itemIndex][k] - regularization * P[userIndex][k]);
                }
            }
        }

        @Override
        public void afterRun() { }
    }

    private class UpdateItemsFactors implements Partible<Item> {

        @Override
        public void beforeRun() { }

        @Override
        public void run(Item item) {
            int itemIndex = item.getItemIndex();

            for (int pos = 0; pos < item.getNumberOfRatings(); pos++) {
                int userIndex = item.getUserAt(pos);

                // Get rating prediction error
                double prediction = ReliabilizedRecommender.this.predict(userIndex, itemIndex);
                double rating = item.getRatingAt(pos);

                double predictionError = Math.abs(prediction - rating);
                double maxPredictionError = datamodel.getMaxRating() - datamodel.getMinRating();
                double normalizedPredictionError = predictionError / maxPredictionError;

                // Get reliability error
                double reliability = ReliabilizedRecommender.this.getPredictionReliability(userIndex, itemIndex);
                double reliabilityError = normalizedPredictionError - (1.0 - reliability);

                // Update latent factors
                for (int k = 0; k < numFactors; k++) {
                    Q[itemIndex][k] += learningRate * (reliabilityError * P[userIndex][k] - learningRate * Q[itemIndex][k]);
                }
            }
        }

        @Override
        public void afterRun() { }
    }
}
