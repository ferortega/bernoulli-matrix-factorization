package com.github.ferortega.bemf.qualityMeasure;

import com.github.ferortega.bemf.recommender.RecommendationReliabilityRecommender;
import es.upm.etsisi.cf4j.data.TestItem;
import es.upm.etsisi.cf4j.data.TestUser;
import es.upm.etsisi.cf4j.qualityMeasure.QualityMeasure;
import es.upm.etsisi.cf4j.recommender.Recommender;
import es.upm.etsisi.cf4j.util.Search;

public class ReliableRecall extends QualityMeasure {

    private int numberOfRecommendations;
    private double ratingThreshold;
    private double reliabilityThreshold;

    public ReliableRecall(RecommendationReliabilityRecommender recommender, int numberOfRecommendations, double reliabilityThreshold, double ratingThreshold) {
        super((Recommender) recommender);
        this.numberOfRecommendations = numberOfRecommendations;
        this.ratingThreshold = ratingThreshold;
        this.reliabilityThreshold = reliabilityThreshold;
    }

    @Override
    protected double getScore(TestUser testUser, double[] predictions) {
        int userIndex = testUser.getUserIndex();

        double[] recomendationReliabilities = new double[testUser.getNumberOfTestRatings()];

        for (int pos = 0; pos < testUser.getNumberOfTestRatings(); pos++) {
            int testItemIndex = testUser.getTestItemAt(pos);
            TestItem testItem = super.recommender.getDataModel().getTestItem(testItemIndex);
            int itemIndex = testItem.getItemIndex();

            RecommendationReliabilityRecommender recommender = (RecommendationReliabilityRecommender) super.recommender;
            double reliability = recommender.getRecommendationReliability(userIndex, itemIndex);

            recomendationReliabilities[pos] = (reliability < this.reliabilityThreshold) ? Double.NaN : reliability;
        }

        int [] recommendations = Search.findTopN(recomendationReliabilities, this.numberOfRecommendations);

        int recommendedAndRelevant = 0;
        for (int pos : recommendations) {
            if (pos == -1) break;

            double rating = testUser.getTestRatingAt(pos);
            if (rating >= this.ratingThreshold) {
                recommendedAndRelevant++;
            }
        }

        int relevant = 0;
        for (int i = 0; i < testUser.getNumberOfTestRatings(); i++){
            double rating = testUser.getTestRatingAt(i);
            if (rating >= this.ratingThreshold) {
                relevant++;
            }
        }

        return (double) recommendedAndRelevant / (double) relevant;
    }
}