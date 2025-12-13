package org.piraven;

import java.sql.Array;
import java.util.ArrayList;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;

    private static int nextId = 1;

    public void calcAssignmentAvg() {
        double sum = 0;

        for (int score : scores) {
            sum += score;
        }

        double avg = sum / scores.size();
    }

}
