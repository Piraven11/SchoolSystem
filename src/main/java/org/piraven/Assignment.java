package org.piraven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;

    private static int nextId = 1;

    public void calcAssignmentAvg() {
        if (scores.isEmpty()) {
            double avg = 0;
        }

        double sum = 0;

        for (int score : scores) {
            sum += score;
        }

        double avg = sum / scores.size();
    }

    public void generateRandomScores() {
        Random random = new Random();

        int randomNum = random.nextInt(0, 10 + 1);
        int randomScore;

        if (randomNum == 0) {
            randomScore = random.nextInt(0, 60 + 1);
        } else if (randomNum == 1 || randomNum == 2) {
            randomScore = random.nextInt(60, 70 + 1);
        } else if (randomNum == 3 || randomNum == 4) {
            randomScore = random.nextInt(70, 80 + 1);
        } else if (randomNum == 5 || randomNum == 6 || randomNum == 7 || randomNum == 8) {
            randomScore = random.nextInt(80, 90 + 1);
        } else {
            randomScore = random.nextInt(90, 100 + 1);
        }

        scores.add(randomScore);
    }

    public Assignment(String assignmentId, String assignmentName, double weight) {
        this.assignmentId = String.format("%05d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + String.format("%05d" + nextId++) + '\'' +
                ", assignmentName=" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
