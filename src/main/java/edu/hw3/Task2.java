package edu.hw3;

import java.util.ArrayList;

public class Task2 {
    public ArrayList<String> clusterize(String str) {
        ArrayList<String> clusters = new ArrayList<>();
        int lonelyBracketAmount = 0;
        StringBuilder cluster = new StringBuilder();

        for (int i = 0; i < str.length(); ++i) {
            cluster.append(str.charAt(i));

            if (str.charAt(i) == '(') {
                ++lonelyBracketAmount;
            } else if (str.charAt(i) == ')') {
                if (lonelyBracketAmount != 0) {
                    --lonelyBracketAmount;
                } else {
                    cluster.deleteCharAt(cluster.length() - 1);
                }
            } else {
                throw new IllegalStateException("Неверный символ");
            }

            if (lonelyBracketAmount == 0) {
                if (!cluster.isEmpty()) {
                    clusters.add(cluster.toString());
                    cluster = new StringBuilder();
                }
            }
        }

        return clusters;
    }
}
