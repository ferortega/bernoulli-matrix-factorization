package com.github.ferortega.bemf.experiment;

import es.upm.etsisi.cf4j.data.BenchmarkDataModels;
import es.upm.etsisi.cf4j.data.DataModel;

import java.util.Map;

public class Settings {

    // Global settings
    public static final long RANDOM_SEED = 43;

    public static final int PLOT_WIDTH = 950;
    public static final int PLOT_HEIGHT = 534;

    public static final int NUM_RECOMMENDATIONS = 10;

    // Dataset settings
    public static DataModel DATAMODEL = null;
    public static double[] RATINGS;
    public static double LIKE_THRESHOLD;

    public static String EXPORT_PREFIX;

    // BeMF parameters
    public static Map<String, Object> BEMF_PARAMS;

    // Baselines parameters
    public static Map<String, Object> PMF_PARAMS;
    public static Map<String, Object> BIASEDMF_PARAMS;
    public static Map<String, Object> NMF_PARAMS;
    public static Map<String, Object> BNMF_PARAMS;
    public static Map<String, Object> URP_PARAMS;
    public static Map<String, Object> SVDPP_PARAMS;

    // Reliabilized recommender parameters
    public static int REL_REC_NUM_FACTORS;
    public static int REL_REC_NUM_ITERS;
    public static double REL_REC_LR;
    public static double REL_REC_REG;


    // Uncomment this for MovieLens
    static {
        try {
            DATAMODEL = BenchmarkDataModels.MovieLens1M();
            RATINGS = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
            LIKE_THRESHOLD = 4.0;

            EXPORT_PREFIX = "ml1m";

            BEMF_PARAMS = Map.of(
                    "numFactors", 2,
                    "numIters", 100,
                    "learningRate", 0.006,
                    "regularization", 0.16,
                    "ratings", RATINGS,
                    "seed", RANDOM_SEED
            );

            PMF_PARAMS = Map.of(
                    "numFactors", 8,
                    "numIters", 50,
                    "gamma", 0.01,
                    "lambda", 0.045,
                    "seed", RANDOM_SEED
            );

            BIASEDMF_PARAMS = Map.of(
                    "numFactors", 6,
                    "numIters", 50,
                    "gamma", 0.01,
                    "lambda", 0.05,
                    "seed" , RANDOM_SEED
            );

            NMF_PARAMS = Map.of(
                    "numFactors", 2,
                    "numIters", 50,
                    "seed", RANDOM_SEED
            );

            BNMF_PARAMS = Map.of(
                    "numFactors", 10,
                    "numIters", 50,
                    "alpha", 0.6,
                    "beta", 5.0,
                    "seed", RANDOM_SEED
            );

            URP_PARAMS = Map.of(
                    "numFactors",10,
                    "numIters", 50,
                    "ratings", RATINGS,
                    "seed", RANDOM_SEED
            );

            SVDPP_PARAMS = Map.of(
                    "numFactors", 4,
                    "numIters", 50,
                    "lambda", 0.05,
                    "gamma", 0.0014,
                    "seed", RANDOM_SEED
            );

            REL_REC_NUM_FACTORS = 6;
            REL_REC_NUM_ITERS = 50;
            REL_REC_LR = 0.01;
            REL_REC_REG = 0.05;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    // Uncomment this for FilmTrust
//    static {
//        try {
//            DATAMODEL = BenchmarkDataModels.FilmTrust();
//            RATINGS = new double[]{0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0};
//            LIKE_THRESHOLD = 3.5;
//
//            EXPORT_PREFIX = "ft";
//
//            BEMF_PARAMS = Map.of(
//                    "numFactors", 2,
//                    "numIters", 75,
//                    "learningRate", 0.02,
//                    "regularization", 0.06,
//                    "ratings", RATINGS,
//                    "seed", RANDOM_SEED
//            );
//
//            PMF_PARAMS = Map.of(
//                    "numFactors", 4,
//                    "numIters", 50,
//                    "gamma", 0.015,
//                    "lambda", 0.1,
//                    "seed", RANDOM_SEED
//            );
//
//            BIASEDMF_PARAMS = Map.of(
//                    "numFactors", 2,
//                    "numIters", 50,
//                    "gamma", 0.015,
//                    "lambda", 0.1,
//                    "seed" , RANDOM_SEED
//            );
//
//            NMF_PARAMS = Map.of(
//                    "numFactors", 2,
//                    "numIters", 50,
//                    "seed", RANDOM_SEED
//            );
//
//            BNMF_PARAMS = Map.of(
//                    "numFactors", 10,
//                    "numIters", 50,
//                    "alpha", 0.4,
//                    "beta", 25.0,
//                    "seed", RANDOM_SEED
//            );
//
//            URP_PARAMS = Map.of(
//                    "numFactors",4,
//                    "numIters", 50,
//                    "ratings", RATINGS,
//                    "seed", RANDOM_SEED
//            );
//
//            SVDPP_PARAMS = Map.of(
//                    "numFactors", 2,
//                    "numIters", 50,
//                    "lambda", 0.1,
//                    "gamma", 0.0014,
//                    "seed", RANDOM_SEED
//            );
//
//            REL_REC_NUM_FACTORS = 4;
//            REL_REC_NUM_ITERS = 50;
//            REL_REC_LR = 0.01;
//            REL_REC_REG = 0.05;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


//    // Uncomment this for MyAnimeList
//    static {
//        try {
//            DATAMODEL = BenchmarkDataModels.MyAnimeList();
//            RATINGS = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
//            LIKE_THRESHOLD = 7.0;
//
//            EXPORT_PREFIX = "anime";
//
//            BEMF_PARAMS = Map.of(
//                    "numFactors", 4,
//                    "numIters", 100,
//                    "learningRate", 0.004,
//                    "regularization", 0.1,
//                    "ratings", RATINGS,
//                    "seed", RANDOM_SEED
//            );
//
//            PMF_PARAMS = Map.of(
//                    "numFactors", 10,
//                    "numIters", 50,
//                    "gamma", 0.005,
//                    "lambda", 0.085,
//                    "seed", RANDOM_SEED
//            );
//
//            BIASEDMF_PARAMS = Map.of(
//                    "numFactors", 10,
//                    "numIters", 50,
//                    "gamma", 0.01,
//                    "lambda", 0.085,
//                    "seed" , RANDOM_SEED
//            );
//
//            NMF_PARAMS = Map.of(
//                    "numFactors", 2,
//                    "numIters", 50,
//                    "seed", RANDOM_SEED
//            );
//
//            BNMF_PARAMS = Map.of(
//                    "numFactors", 4,
//                    "numIters", 50,
//                    "alpha", 0.5,
//                    "beta", 5.0,
//                    "seed", RANDOM_SEED
//            );
//
//            URP_PARAMS = Map.of(
//                    "numFactors",10,
//                    "numIters", 35,
//                    "ratings", RATINGS,
//                    "seed", RANDOM_SEED
//            );
//
//            SVDPP_PARAMS = Map.of(
//                    "numFactors", 4,
//                    "numIters", 50,
//                    "lambda", 0.02,
//                    "gamma", 0.0014,
//                    "seed", RANDOM_SEED
//            );
//
//            REL_REC_NUM_FACTORS = 8;
//            REL_REC_NUM_ITERS = 75;
//            REL_REC_LR = 0.01;
//            REL_REC_REG = 0.05;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
