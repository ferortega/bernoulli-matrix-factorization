package com.github.ferortega.bemf.experiment;

import com.github.ferortega.bemf.recommender.BeMF;
import com.github.ferortega.bemf.recommender.ReliabilizedRecommender;
import es.upm.etsisi.cf4j.data.*;
import es.upm.etsisi.cf4j.util.Maths;

import java.util.ArrayList;
import java.util.List;

import static com.github.ferortega.bemf.experiment.Settings.*;

public class ReliabilityPredictionImprovement {

    public static void main(String[] args) {

        DataModel datamodel = DATAMODEL;

        List<Double> errors = new ArrayList<>();
        List<Double> modelReliabilities = new ArrayList<>();
        List<Double> enforcedReliabilities = new ArrayList<>();

        BeMF bemf = new BeMF(datamodel, BEMF_PARAMS);
        bemf.fit();

        ReliabilizedRecommender relBemf = new ReliabilizedRecommender(bemf, REL_REC_NUM_FACTORS, REL_REC_NUM_ITERS, REL_REC_LR, REL_REC_REG, RANDOM_SEED);
        relBemf.fit();

        for (TestUser testUser : datamodel.getTestUsers()) {
            int userIndex = testUser.getUserIndex();

            for (int pos = 0; pos < testUser.getNumberOfTestRatings(); pos++) {
                int testItemIndex = testUser.getTestItemAt(pos);
                TestItem testItem = datamodel.getTestItem(testItemIndex);
                int itemIndex = testItem.getItemIndex();

                double rating = testUser.getTestRatingAt(pos);
                double prediction = bemf.predict(userIndex, itemIndex);
                double error = Math.abs(rating - prediction);
                errors.add(error);

                double bemfReliabity = bemf.getPredictionReliability(userIndex, itemIndex);
                modelReliabilities.add(bemfReliabity);

                double enforcedReliability = relBemf.getPredictionReliability(userIndex, itemIndex);
                enforcedReliabilities.add(enforcedReliability);
            }
        }

        System.out.println("BeMF RPI (native): " + getRPI(errors.stream().mapToDouble(Double::doubleValue).toArray(), modelReliabilities.stream().mapToDouble(Double::doubleValue).toArray()));
        System.out.println("BeMF RPI (enforced): " + getRPI(errors.stream().mapToDouble(Double::doubleValue).toArray(), enforcedReliabilities.stream().mapToDouble(Double::doubleValue).toArray()));
    }

    private static double getRPI(double[] errors, double[] reliabilities) {
        double errorsAvg = Maths.arrayAverage(errors);
        double errorsStd = Maths.arrayStandardDeviation(errors);

        double reliabilitiesAvg = Maths.arrayAverage(reliabilities);
        double reliabilitiesStd = Maths.arrayAverage(reliabilities);

        double sum = 0;
        for (int i = 0; i < errors.length; i++) {
            sum += errors[i] * (errors[i] - errorsAvg) * (reliabilitiesAvg - reliabilities[i]);
        }

        return sum / (errors.length * errorsStd * reliabilitiesStd * errorsAvg);
    }
}
