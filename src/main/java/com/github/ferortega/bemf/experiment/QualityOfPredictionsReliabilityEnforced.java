package com.github.ferortega.bemf.experiment;

import com.github.ferortega.bemf.qualityMeasure.Prediction;
import com.github.ferortega.bemf.recommender.BNMF;
import com.github.ferortega.bemf.recommender.BeMF;
import com.github.ferortega.bemf.recommender.ReliabilizedRecommender;
import com.github.ferortega.bemf.recommender.URP;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.util.plot.LinePlot;
import es.upm.etsisi.cf4j.util.plot.PlotSettings;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.BiasedMF;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.NMF;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.PMF;
import es.upm.etsisi.cf4j.recommender.matrixFactorization.SVDPlusPlus;

import java.io.IOException;
import java.text.DecimalFormat;

import static com.github.ferortega.bemf.experiment.Settings.*;

public class QualityOfPredictionsReliabilityEnforced {

    private static double[] RELIABILITY_THRESHOLD = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};

    public static void main(String[] args) throws IOException {

        DataModel datamodel = DATAMODEL;

        DecimalFormat df = new DecimalFormat("0.00");

        String[] values = new String[RELIABILITY_THRESHOLD.length];
        for (int i = 0; i < RELIABILITY_THRESHOLD.length; i++) {
            values[i] = df.format(RELIABILITY_THRESHOLD[i]);
        }

        LinePlot maePlot = new LinePlot(RELIABILITY_THRESHOLD, "Prediction reliability", "MAE");
        LinePlot coveragePlot = new LinePlot(RELIABILITY_THRESHOLD, "Prediction reliability", "Coverage");


        // Evaluate BeMF Recommender
        BeMF bemf = new BeMF(datamodel, BEMF_PARAMS);
        bemf.fit();

        maePlot.addSeries("BeMF");
        coveragePlot.addSeries("BeMF");

        for (double threshold : RELIABILITY_THRESHOLD) {
            maePlot.setValue("BeMF", threshold, Prediction.reliableMae(bemf, threshold));
            coveragePlot.setValue("BeMF", threshold, Prediction.reliableCoverage(bemf, threshold));
        }


        // Evaluate PMF Recommender
        PMF pmf = new PMF(datamodel, PMF_PARAMS);
        pmf.fit();

        ReliabilizedRecommender relPmf = new ReliabilizedRecommender(pmf, REL_REC_NUM_FACTORS, REL_REC_NUM_ITERS, REL_REC_LR, REL_REC_REG, RANDOM_SEED);
        relPmf.fit();

        maePlot.addSeries("PMF*");
        coveragePlot.addSeries("PMF*");

        for (double threshold : RELIABILITY_THRESHOLD) {
            maePlot.setValue("PMF*", threshold, Prediction.reliableMae(relPmf, threshold));
            coveragePlot.setValue("PMF*", threshold, Prediction.reliableCoverage(relPmf, threshold));
        }


        // Evaluate BiasedMF Recommender
        BiasedMF biasedMF = new BiasedMF(datamodel, BIASEDMF_PARAMS);
        biasedMF.fit();

        ReliabilizedRecommender relBiaseMF = new ReliabilizedRecommender(biasedMF, REL_REC_NUM_FACTORS, REL_REC_NUM_ITERS, REL_REC_LR, REL_REC_REG, RANDOM_SEED);
        relBiaseMF.fit();

        maePlot.addSeries("BiasedMF*");
        coveragePlot.addSeries("BiasedMF*");

        for (double threshold : RELIABILITY_THRESHOLD) {
            maePlot.setValue("BiasedMF*", threshold, Prediction.reliableMae(relBiaseMF, threshold));
            coveragePlot.setValue("BiasedMF*", threshold, Prediction.reliableCoverage(relBiaseMF, threshold));
        }

        // Evaluate NMF Recommender
        NMF nmf = new NMF(datamodel, NMF_PARAMS);
        nmf.fit();

        ReliabilizedRecommender relNmf = new ReliabilizedRecommender(nmf, REL_REC_NUM_FACTORS, REL_REC_NUM_ITERS, REL_REC_LR, REL_REC_REG, RANDOM_SEED);
        relNmf.fit();

        maePlot.addSeries("NMF*");
        coveragePlot.addSeries("NMF*");

        for (double threshold : RELIABILITY_THRESHOLD) {
            maePlot.setValue("NMF*", threshold, Prediction.reliableMae(relNmf, threshold));
            coveragePlot.setValue("NMF*", threshold, Prediction.reliableCoverage(relNmf, threshold));
        }


        // Evaluate BNMF Recommender
        BNMF bnmf = new BNMF(datamodel, BNMF_PARAMS);
        bnmf.fit();

        ReliabilizedRecommender relBnmf = new ReliabilizedRecommender(bnmf, REL_REC_NUM_FACTORS, REL_REC_NUM_ITERS, REL_REC_LR, REL_REC_REG, RANDOM_SEED);
        relBnmf.fit();

        maePlot.addSeries("BNMF*");
        coveragePlot.addSeries("BNMF*");

        for (double threshold : RELIABILITY_THRESHOLD) {
            maePlot.setValue("BNMF*", threshold, Prediction.reliableMae(relBnmf, threshold));
            coveragePlot.setValue("BNMF*", threshold, Prediction.reliableCoverage(relBnmf, threshold));
        }


        // Evaluate URP Recommender
        URP urp = new URP(datamodel, URP_PARAMS);
        urp.fit();

        maePlot.addSeries("URP");
        coveragePlot.addSeries("URP");

        for (double threshold : RELIABILITY_THRESHOLD) {
            maePlot.setValue("URP", threshold, Prediction.reliableMae(urp, threshold));
            coveragePlot.setValue("URP", threshold, Prediction.reliableCoverage(urp, threshold));
        }


        // Evaluate SVD++ Recommender
        SVDPlusPlus svdpp = new SVDPlusPlus(datamodel, SVDPP_PARAMS);
        svdpp.fit();

        ReliabilizedRecommender relSvdpp = new ReliabilizedRecommender(svdpp, REL_REC_NUM_FACTORS, REL_REC_NUM_ITERS, REL_REC_LR, REL_REC_REG, RANDOM_SEED);
        relSvdpp.fit();

        maePlot.addSeries("SVD++*");
        coveragePlot.addSeries("SVD++*");

        for (double threshold : RELIABILITY_THRESHOLD) {
            maePlot.setValue("SVD++*", threshold, Prediction.reliableMae(relSvdpp, threshold));
            coveragePlot.setValue("SVD++*", threshold, Prediction.reliableCoverage(relSvdpp, threshold));
        }


        // Print results
        PlotSettings.setWidth(PLOT_WIDTH);
        PlotSettings.setHeight(PLOT_HEIGHT);

        maePlot.exportPlot("results/" + EXPORT_PREFIX + "-mae-reliabilizated.png");
        maePlot.printData();
        maePlot.exportData("results/" + EXPORT_PREFIX + "-mae-reliabilizated.csv");

        coveragePlot.exportPlot("results/" + EXPORT_PREFIX + "-coverage-reliabilizated.png");
        coveragePlot.printData();
        coveragePlot.exportData("results/" + EXPORT_PREFIX + "-coverage-reliabilizated.csv");
    }
}
