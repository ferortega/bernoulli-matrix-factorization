package com.github.ferortega.bemf.experiment;

import com.github.ferortega.bemf.qualityMeasure.Precision;
import com.github.ferortega.bemf.qualityMeasure.Recall;
import com.github.ferortega.bemf.qualityMeasure.ReliablePrecision;
import com.github.ferortega.bemf.qualityMeasure.ReliableRecall;
import com.github.ferortega.bemf.recommender.BNMF;
import com.github.ferortega.bemf.recommender.BeMF;
import com.github.ferortega.bemf.recommender.URP;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.util.plot.LinePlot;
import es.upm.etsisi.cf4j.util.plot.PlotSettings;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.BiasedMF;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.NMF;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.PMF;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.SVDPlusPlus;

import java.io.IOException;

import static com.github.ferortega.bemf.experiment.Settings.*;

public class QualityOfRecommendations {

    private static double[] RELIABILITY_THRESHOLD = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};

    public static void main(String[] args) throws IOException {

        DataModel datamodel = DATAMODEL;

        LinePlot precisionPlot = new LinePlot(RELIABILITY_THRESHOLD, "Recommendation reliability", "Precision");
        LinePlot recallPlot = new LinePlot(RELIABILITY_THRESHOLD, "Recommendation reliability", "Recall");


        // Evaluate BeMF Recommender
        BeMF bemf = new BeMF(datamodel, BEMF_PARAMS);
        bemf.fit();

        precisionPlot.addSeries("BeMF");
        recallPlot.addSeries("BeMF");

        for (double threshold : RELIABILITY_THRESHOLD) {
            ReliablePrecision rPrecision = new ReliablePrecision(bemf, NUM_RECOMMENDATIONS, threshold, LIKE_THRESHOLD);
            double rPrecisionScore = rPrecision.getScore();
            precisionPlot.setValue("BeMF", threshold, rPrecisionScore);

            ReliableRecall rRecall = new ReliableRecall(bemf, NUM_RECOMMENDATIONS, threshold, LIKE_THRESHOLD);
            double rRecallScore = rRecall.getScore();
            recallPlot.setValue("BeMF", threshold, rRecallScore);
        }


        // Evaluate PMF Recommender
        PMF pmf = new PMF(datamodel, PMF_PARAMS);
        pmf.fit();

        Precision precision = new Precision(pmf, NUM_RECOMMENDATIONS, LIKE_THRESHOLD);
        double precisionScore = precision.getScore();
        precisionPlot.addSeries("PMF", precisionScore);

        Recall recall = new Recall(pmf, NUM_RECOMMENDATIONS, LIKE_THRESHOLD);
        double recalScore = recall.getScore();
        recallPlot.addSeries("PMF", recalScore);


        // Evaluate BiasedMF Recommender
        BiasedMF biasedMF = new BiasedMF(datamodel, BIASEDMF_PARAMS);
        biasedMF.fit();

        precision = new Precision(biasedMF, NUM_RECOMMENDATIONS, LIKE_THRESHOLD);
        precisionScore = precision.getScore();
        precisionPlot.addSeries("BiasedMF", precisionScore);

        recall = new Recall(biasedMF, NUM_RECOMMENDATIONS, LIKE_THRESHOLD);
        recalScore = recall.getScore();
        recallPlot.addSeries("BiasedMF", recalScore);


        // Evaluate NMF Recommender
        NMF nmf = new NMF(datamodel, NMF_PARAMS);
        nmf.fit();

        precision = new Precision(nmf, NUM_RECOMMENDATIONS, LIKE_THRESHOLD);
        precisionScore = precision.getScore();
        precisionPlot.addSeries("NMF", precisionScore);

        recall = new Recall(nmf, NUM_RECOMMENDATIONS, LIKE_THRESHOLD);
        recalScore = recall.getScore();
        recallPlot.addSeries("NMF", recalScore);


        // Evaluate BNMF Recommender
        BNMF bnmf = new BNMF(datamodel, BNMF_PARAMS);
        bnmf.fit();

        precisionPlot.addSeries("BNMF");
        recallPlot.addSeries("BNMF");

        for (double threshold : RELIABILITY_THRESHOLD) {
            ReliablePrecision rPrecision = new ReliablePrecision(bnmf, NUM_RECOMMENDATIONS, threshold, LIKE_THRESHOLD);
            double rPrecisionScore = rPrecision.getScore();
            precisionPlot.setValue("BNMF", threshold, rPrecisionScore);

            ReliableRecall rRecall = new ReliableRecall(bnmf, NUM_RECOMMENDATIONS, threshold, LIKE_THRESHOLD);
            double rRecallScore = rRecall.getScore();
            recallPlot.setValue("BNMF", threshold, rRecallScore);
        }


        // Evaluate URP Recommender

        URP urp = new URP(datamodel, URP_PARAMS);
        urp.fit();

        precisionPlot.addSeries("URP");
        recallPlot.addSeries("URP");

        for (double threshold : RELIABILITY_THRESHOLD) {
            ReliablePrecision rPrecision = new ReliablePrecision(urp, NUM_RECOMMENDATIONS, threshold, LIKE_THRESHOLD);
            double rPrecisionScore = rPrecision.getScore();
            precisionPlot.setValue("URP", threshold, rPrecisionScore);

            ReliableRecall rRecall = new ReliableRecall(urp, NUM_RECOMMENDATIONS, threshold, LIKE_THRESHOLD);
            double rRecallScore = rRecall.getScore();
            recallPlot.setValue("URP", threshold, rRecallScore);
        }


        // Evaluate SVD++ Recommender
        SVDPlusPlus svdpp = new SVDPlusPlus(datamodel, SVDPP_PARAMS);
        svdpp.fit();

        precision = new Precision(svdpp, NUM_RECOMMENDATIONS, LIKE_THRESHOLD);
        precisionScore = precision.getScore();
        precisionPlot.addSeries("SVD++", precisionScore);

        recall = new Recall(svdpp, NUM_RECOMMENDATIONS, LIKE_THRESHOLD);
        recalScore = recall.getScore();
        recallPlot.addSeries("SVD++", recalScore);


        // Print results
        PlotSettings.setWidth(PLOT_WIDTH);
        PlotSettings.setHeight(PLOT_HEIGHT);

        precisionPlot.exportPlot("results/" + EXPORT_PREFIX + "-precision.png");
        precisionPlot.printData();
        precisionPlot.exportData("results/" + EXPORT_PREFIX + "-precision.csv");

        recallPlot.exportPlot("results/" + EXPORT_PREFIX + "-recall.png");
        recallPlot.printData();
        recallPlot.exportData("results/" + EXPORT_PREFIX + "-recall.csv");
    }
}
