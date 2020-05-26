package com.github.ferortega.bemf.qualityMeasure;

import com.github.ferortega.bemf.recommender.PredictionReliabilityRecommender;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.TestUser;
import es.upm.etsisi.cf4j.recommender.Recommender;

public class Prediction {

    public static double mae(Recommender recommender) {
        DataModel datamodel = recommender.getDataModel();

        double sum = 0;
        int count = 0;

        for (TestUser testUser : datamodel.getTestUsers()) {
            int userIndex = testUser.getUserIndex();

            for (int pos = 0; pos < testUser.getNumberOfTestRatings(); pos++) {
                int testItemIndex = testUser.getTestItemAt(pos);
                int itemIndex = datamodel.getTestItem(testItemIndex).getItemIndex();

                double rating = testUser.getTestRatingAt(pos);
                double prediction = recommender.predict(userIndex, itemIndex);

                if (!Double.isNaN(prediction)) {
                    sum += Math.abs(rating - prediction);
                    count++;
                }
            }
        }

        return sum / count;
    }

    public static double reliableMae(PredictionReliabilityRecommender recommender, double threshold) {
        DataModel datamodel = recommender.getDataModel();

        double sum = 0;
        int count = 0;

        for (TestUser testUser : datamodel.getTestUsers()) {
            int userIndex = testUser.getUserIndex();

            for (int pos = 0; pos < testUser.getNumberOfTestRatings(); pos++) {
                int testItemIndex = testUser.getTestItemAt(pos);
                int itemIndex = datamodel.getTestItem(testItemIndex).getItemIndex();

                double reliability = recommender.getPredictionReliability(userIndex, itemIndex);
                if (reliability >= threshold) {
                    double rating = testUser.getTestRatingAt(pos);
                    double prediction = recommender.predict(userIndex, itemIndex);

                    if (!Double.isNaN(prediction)) {
                        sum += Math.abs(rating - prediction);
                        count++;
                    }
                }
            }
        }

        return sum / count;
    }

    public static double reliableCoverage(PredictionReliabilityRecommender recommender, double threshold) {
        DataModel datamodel = recommender.getDataModel();

        int predictable = 0;
        int total = 0;

        for (TestUser testUser : datamodel.getTestUsers()) {
            int userIndex = testUser.getUserIndex();

            for (int pos = 0; pos < testUser.getNumberOfTestRatings(); pos++) {
                int testItemIndex = testUser.getTestItemAt(pos);
                int itemIndex = datamodel.getTestItem(testItemIndex).getItemIndex();

                double reliability = recommender.getPredictionReliability(userIndex, itemIndex);
                double prediction = recommender.predict(userIndex, itemIndex);

                if (reliability >= threshold && !Double.isNaN(prediction)) {
                    predictable++;
                }

                total++;
            }
        }

        return (double) predictable / (double) total;
    }
}
