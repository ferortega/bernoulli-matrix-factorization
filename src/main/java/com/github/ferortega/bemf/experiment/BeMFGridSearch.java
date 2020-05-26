package com.github.ferortega.bemf.experiment;

import com.github.ferortega.bemf.recommender.BeMF;
import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.qualityMeasure.prediction.MAE;
import es.upm.etsisi.cf4j.util.optimization.GridSearch;
import es.upm.etsisi.cf4j.util.optimization.ParamsGrid;
import es.upm.etsisi.cf4j.util.Range;

import java.io.IOException;

public class BeMFGridSearch {

    private final static int TOP_N = 25;

    public static void main(String[] args) throws IOException {
        DataModel datamodel = Settings.DATAMODEL;

        ParamsGrid paramsGrid = new ParamsGrid();

        paramsGrid.addParam("numFactors", new int[]{2, 4, 6, 8});
        paramsGrid.addParam("learningRate", Range.ofDoubles(0.002, 0.002, 10));
        paramsGrid.addParam("regularization", Range.ofDoubles(0.01, 0.01, 20));
        paramsGrid.addParam("numIters", new int[]{50, 75, 100});

        paramsGrid.addFixedParam("ratings", Settings.RATINGS);
        paramsGrid.addFixedParam("seed", Settings.RANDOM_SEED);

        GridSearch gridSearch = new GridSearch(datamodel, paramsGrid, BeMF.class, MAE.class);
        gridSearch.fit();
        gridSearch.printResults(TOP_N);
    }
}
