package com.github.ferortega.bemf.recommender;

import com.github.ferortega.bemf.experiment.Settings;
import es.upm.etsisi.cf4j.data.DataModel;

import java.util.Map;

public class URP extends es.upm.etsisi.cf4j.recommender.matrixFactorization.URP implements PredictionReliabilityRecommender, RecommendationReliabilityRecommender {

    public URP(DataModel datamodel, int numFactors, double[] ratings, int numIters, long seed) {
        super(datamodel, numFactors, ratings, numIters, seed);
    }

    public URP(DataModel datamodel, Map<String, Object> params) {
        super(datamodel, params);
    }

    @Override
    public double getPredictionReliability(int userIndex, int itemIndex) {
        double prediction = this.predict(userIndex, itemIndex);
        int r = this.findRatingIndex(prediction);
        double[] pd = this.getPredictionProbabilityDistribution(userIndex, itemIndex);
        return pd[r];
    }

    @Override
    public double getRecommendationReliability(int userIndex, int itemIndex) {
        double[] pd = this.getPredictionProbabilityDistribution(userIndex, itemIndex);

        double reliability = 0;
        for (int r = 0; r < this.getRatings().length; r++) {
            double rating = this.getRatings()[r];
            if (rating >= Settings.LIKE_THRESHOLD) {
                reliability += pd[r];
            }
        }

        return reliability;
    }

    private int findRatingIndex(double rating) {
        double[] ratings = this.getRatings();
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] == rating) {
                return i;
            }
        }
        return -1;
    }
}
