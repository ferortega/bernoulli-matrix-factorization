package com.github.ferortega.bemf.recommender;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.util.Maths;

import java.util.Map;

public class BNMF extends es.upm.etsisi.cf4j.recommender.matrixFactorization.BNMF implements RecommendationReliabilityRecommender {

    public BNMF(DataModel datamodel, int numFactors, int numIters, double alpha, double beta, long seed) {
        super(datamodel, numFactors, numIters, alpha, beta, seed);
    }

    public BNMF(DataModel dataModel, Map<String, Object> params) {
        super(dataModel, params);
    }

    @Override
    public double getRecommendationReliability(int userIndex, int itemIndex) {
        return Maths.dotProduct(super.getUserFactors(userIndex), super.getItemFactors(itemIndex));
    }
}
