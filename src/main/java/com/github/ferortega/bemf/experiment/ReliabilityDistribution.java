package com.github.ferortega.bemf.experiment;

import com.github.ferortega.bemf.recommender.BeMF;
import es.upm.etsisi.cf4j.data.*;
import es.upm.etsisi.cf4j.util.plot.HistogramPlot;
import es.upm.etsisi.cf4j.util.plot.PlotSettings;

import java.io.IOException;

import static com.github.ferortega.bemf.experiment.Settings.*;

public class ReliabilityDistribution {
    
    public static void main(String[] args) throws IOException {

        DataModel datamodel = DATAMODEL;

        BeMF bemf = new BeMF(datamodel, BEMF_PARAMS);
        bemf.fit();

        PlotSettings.setWidth(PLOT_WIDTH);
        PlotSettings.setHeight(PLOT_HEIGHT);

        HistogramPlot trainingPlot = new HistogramPlot("Prediction reliability", 11);

        for(User user : datamodel.getUsers()) {
            int userIndex = user.getUserIndex();
            for (int pos = 0; pos < user.getNumberOfRatings(); pos++) {
                int itemIndex = user.getItemAt(pos);
                double reliability = bemf.getPredictionReliability(userIndex, itemIndex);
                trainingPlot.addValue(reliability);
            }
        }

        trainingPlot.draw();
        trainingPlot.exportPlot("results/" + EXPORT_PREFIX + "-training-reliability-hist.png");
        trainingPlot.printData();
        trainingPlot.exportData("results/" + EXPORT_PREFIX + "-training-reliability-hist.csv");


        HistogramPlot testPlot = new HistogramPlot("Prediction reliability", 11);

        for (TestUser testUser : datamodel.getTestUsers()) {
            int userIndex = testUser.getUserIndex();

            for (int pos = 0; pos < testUser.getNumberOfTestRatings(); pos++) {
                int testItemIndex = testUser.getTestItemAt(pos);
                TestItem testItem = datamodel.getTestItem(testItemIndex);
                int itemIndex = testItem.getItemIndex();

                double reliability = bemf.getPredictionReliability(userIndex, itemIndex);
                testPlot.addValue(reliability);
            }
        }

        testPlot.exportPlot("results/" + EXPORT_PREFIX + "-test-reliability-hist.png");
        testPlot.printData();
        testPlot.exportData("results/" + EXPORT_PREFIX + "-test-reliability-hist.csv");
    }
}
