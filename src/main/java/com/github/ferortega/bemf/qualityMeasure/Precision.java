package com.github.ferortega.bemf.qualityMeasure;

import es.upm.etsisi.cf4j.data.TestUser;
import es.upm.etsisi.cf4j.qualityMeasure.QualityMeasure;
import es.upm.etsisi.cf4j.recommender.Recommender;
import es.upm.etsisi.cf4j.util.Search;

import java.util.Arrays;

public class Precision extends QualityMeasure {

    private int numberOfRecommendations;
    private double threshold;

    public Precision(Recommender recommender, int numberOfRecommendations, double threshold) {
        super(recommender);
        this.numberOfRecommendations = numberOfRecommendations;
        this.threshold = threshold;
    }

    @Override
    protected double getScore(TestUser testUser, double[] predictions) {

        // Set to NaN predictions lower than threshold

        predictions = Arrays.stream(predictions).filter(p -> p >= this.threshold).toArray();

        // Items that has been recommended and was relevant to the active user

        int [] recommendations = Search.findTopN(predictions, this.numberOfRecommendations);

        int recommendedAndRelevant = 0, recommended = 0;

        for (int pos : recommendations) {
            if (pos == -1) break;

            double rating = testUser.getTestRatingAt(pos);
            if (rating >= this.threshold) {
                recommendedAndRelevant++;
            }

            recommended++;
        }

        return (double) recommendedAndRelevant / (double) recommended;
    }
}