package com.example.biologyapp;

import android.content.Context;
import java.io.*;
import java.util.*;

public class StorageManager {

    // Titles of topics
    private static final String[] TITLES = {
            "Cell Biology",
            "Genetics",
            "Evolution",
            "Ecology",
            "Human Anatomy",
            "Microbiology",
            "Biotechnology",
            "Plant Biology",
            "Immunology",
            "Biochemistry",
            "Neuroscience",
            "Molecular Biology",
            "Zoology",
            "Environmental Biology"
    };

    // Raw resource IDs (must match titles order)
    private static final int[] RAW_IDS = {
            R.raw.cell_biology,
            R.raw.genetics,
            R.raw.evolution,
            R.raw.ecology,
            R.raw.human_anatomy,
            R.raw.microbiology,
            R.raw.biotechnology,
            R.raw.plant_biology,
            R.raw.immunology,
            R.raw.biochemistry,
            R.raw.neuroscience,
            R.raw.molecular_biology,
            R.raw.zoology,
            R.raw.environmental_biology
    };


    // Return list of all topic titles
    public static List<String> getTitles(Context ctx) {
        return Arrays.asList(TITLES);
    }

    // Read full content from raw resource
    public static String getContent(Context ctx, int index) {
        StringBuilder sb = new StringBuilder();
        try (InputStream is = ctx.getResources().openRawResource(RAW_IDS[index]);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Content not found.";
        }
        return sb.toString();
    }
}
