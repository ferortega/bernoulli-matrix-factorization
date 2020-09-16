package com.github.ferortega.bemf.experiment;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.qualityMeasure.QualityMeasure;
import es.upm.etsisi.cf4j.qualityMeasure.prediction.Coverage;
import es.upm.etsisi.cf4j.qualityMeasure.prediction.MAE;
import es.upm.etsisi.cf4j.recommender.Recommender;
import es.upm.etsisi.cf4j.recommender.knn.ItemKNN;
import es.upm.etsisi.cf4j.recommender.knn.UserKNN;
import es.upm.etsisi.cf4j.util.plot.LinePlot;

import java.io.IOException;

import static com.github.ferortega.bemf.experiment.Settings.*;

public class ComparisonWithKnn {

    public static void main (String[] args) throws IOException {

        DataModel datamodel = DATAMODEL;

        LinePlot maePlot = new LinePlot(KNN_NUMBER_OF_NEIGHBORS, "Number of neighbors", "MAE");
        LinePlot coveragePlot = new LinePlot(KNN_NUMBER_OF_NEIGHBORS, "Number of neighbors", "Coverage");


        // UserKNN

        maePlot.addSeries("UserKNN");
        coveragePlot.addSeries("UserKNN");

        for (int k : KNN_NUMBER_OF_NEIGHBORS) {
            Recommender knn = new UserKNN(datamodel, k, new es.upm.etsisi.cf4j.recommender.knn.userSimilarityMetric.JMSD(), UserKNN.AggregationApproach.WEIGHTED_MEAN);
            knn.fit();

            QualityMeasure mae = new MAE(knn);
            double maeScore = mae.getScore();
            maePlot.setValue("UserKNN", k, maeScore);

            QualityMeasure coverage = new Coverage(knn);
            double coverageScore = coverage.getScore();
            coveragePlot.setValue("UserKNN", k, coverageScore);
        }


        // ItemKNN

        maePlot.addSeries("ItemKNN");
        coveragePlot.addSeries("ItemKNN");

        for (int k : KNN_NUMBER_OF_NEIGHBORS) {
            Recommender knn = new ItemKNN(datamodel, k, new es.upm.etsisi.cf4j.recommender.knn.itemSimilarityMetric.JMSD(), ItemKNN.AggregationApproach.WEIGHTED_MEAN);
            knn.fit();

            QualityMeasure mae = new MAE(knn);
            double maeScore = mae.getScore();
            maePlot.setValue("ItemKNN", k, maeScore);

            QualityMeasure coverage = new Coverage(knn);
            double coverageScore = coverage.getScore();
            coveragePlot.setValue("ItemKNN", k, coverageScore);
        }


        // Print results
        maePlot.printData("0", "0.0000");
        maePlot.exportData("results/" + EXPORT_PREFIX + "-knn-mae.csv");

        coveragePlot.printData("0", "0.0000");
        coveragePlot.exportData("results/" + EXPORT_PREFIX + "-knn-coverage.csv");
    }
}
