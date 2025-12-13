package org.piraven;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

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

    public void generateRandomScores() {
        Random random = new Random();

        int randomValue = random.nextInt(0, 10 + 1);
        int randomScore;

        if (randomValue == 0) {
            randomScore = random.nextInt(0, 60 + 1);
        } else if (randomValue == 1 || randomValue == 2) {
            randomScore = random.nextInt(60, 70 + 1);
        } else if (randomValue == 3 || randomValue == 4) {
            randomScore = random.nextInt(70, 80 + 1);
        } else if (randomValue == 5 || randomValue == 6 || randomValue == 7 || randomValue == 8) {
            randomScore = random.nextInt(70, 80 + 1);
        } else {
            randomScore = random.nextInt(90, 100 + 1);
        }

        scores.add(randomScore);
    }

    @Override
    public String toString() {
        return "Assignment{" +
                String.format("assignmentId='" + nextId++) + '\'' +
                ", assignmentName=" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
