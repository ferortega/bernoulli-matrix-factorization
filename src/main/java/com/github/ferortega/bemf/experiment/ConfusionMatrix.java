package com.github.ferortega.bemf.experiment;

import com.github.ferortega.bemf.recommender.BeMF;
import com.github.ferortega.bemf.recommender.ReliabilizedRecommender;
import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.TestItem;
import es.upm.etsisi.cf4j.data.TestUser;
import es.upm.etsisi.cf4j.util.Maths;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.github.ferortega.bemf.experiment.Settings.*;

public class ConfusionMatrix {

    public static void main(String[] args) throws IOException {

        DataModel datamodel = DATAMODEL;

        BeMF bemf = new BeMF(datamodel, BEMF_PARAMS);
        bemf.fit();

        File f = new File("results/" + EXPORT_PREFIX + "-confusion-matrix-data.csv");
        File parent = f.getAbsoluteFile().getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            throw new IOException("Unable to create directory " + parent);
        }

        PrintWriter writer = new PrintWriter(f);

        writer.println("rating,prediction");

        for (TestUser testUser : datamodel.getTestUsers()) {
            int userIndex = testUser.getUserIndex();

            for (int pos = 0; pos < testUser.getNumberOfTestRatings(); pos++) {
                int testItemIndex = testUser.getTestItemAt(pos);
                TestItem testItem = datamodel.getTestItem(testItemIndex);
                int itemIndex = testItem.getItemIndex();

                double rating = testUser.getTestRatingAt(pos);
                double prediction = bemf.predict(userIndex, itemIndex);

                writer.println(rating + "," + prediction);
            }
        }

        writer.close();
    }
}
