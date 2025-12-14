package org.piraven;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Random;

@Setter
@Getter
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
            randomScore = random.nextInt(0, 60);
        } else if (randomNum == 1 || randomNum == 2) {
            randomScore = random.nextInt(60, 70);
        } else if (randomNum == 3 || randomNum == 4) {
            randomScore = random.nextInt(70, 80);
        } else if (randomNum == 5 || randomNum == 6 || randomNum == 7 || randomNum == 8) {
            randomScore = random.nextInt(80, 90);
        } else {
            randomScore = random.nextInt(90, 100 + 1);
        }

        scores.add(randomScore);
    }

    public Assignment(String assignmentId, String assignmentName, double weight) {
        this.assignmentId = String.format("%d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = String.format("%05d",  nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }
}
