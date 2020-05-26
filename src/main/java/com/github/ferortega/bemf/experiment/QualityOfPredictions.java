package com.github.ferortega.bemf.experiment;

import com.github.ferortega.bemf.qualityMeasure.Prediction;
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

public class QualityOfPredictions {

    private static double[] RELIABILITY_THRESHOLD = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9};

    public static void main(String[] args) throws IOException {
        DataModel datamodel = DATAMODEL;

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

        maePlot.addSeries("PMF", Prediction.mae(pmf));
        coveragePlot.addSeries("PMF", 1.0);


        // Evaluate BiasedMF Recommender
        BiasedMF biasedMF = new BiasedMF(datamodel, BIASEDMF_PARAMS);
        biasedMF.fit();

        maePlot.addSeries("BiasedMF", Prediction.mae(biasedMF));

        coveragePlot.addSeries("BiasedMF", 1.0);


        // Evaluate NMF Recommender
        NMF nmf = new NMF(datamodel, NMF_PARAMS);
        nmf.fit();

        maePlot.addSeries("NMF", Prediction.mae(nmf));
        coveragePlot.addSeries("NMF", 1.0);


        // Evaluate BNMF Recommender
        BNMF bnmf = new BNMF(datamodel, BNMF_PARAMS);
        bnmf.fit();

        maePlot.addSeries("BNMF", Prediction.mae(bnmf));
        coveragePlot.addSeries("BNMF", 1.0);


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

        maePlot.addSeries("SVD++", Prediction.mae(svdpp));
        coveragePlot.addSeries("SVD++", 1.0);


        // Print results
        PlotSettings.setWidth(PLOT_WIDTH);
        PlotSettings.setHeight(PLOT_HEIGHT);

        maePlot.exportPlot("results/" + EXPORT_PREFIX + "-mae.png");
        maePlot.printData();
        maePlot.exportData("results/" + EXPORT_PREFIX + "-mae.csv");

        coveragePlot.exportPlot("results/" + EXPORT_PREFIX + "-coverage.png");
        coveragePlot.printData();
        coveragePlot.exportData("results/" + EXPORT_PREFIX + "-coverage.csv");
    }
}
