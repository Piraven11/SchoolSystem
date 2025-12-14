package org.piraven;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;

    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = "C" + "-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    /**
     *checks if the sum of weights of all assignments
     * of that course equals to 100%
     * @return the sum of course is equal to 100% or not
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;
        double sumOfWeights = 100;

        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return sum == sumOfWeights;
    }

    /**
     * adds a student to the student list of the course, also add a new null element
     * to each assignment of this course, and add a new null element for the finalScores
     * @param student the input student
     * @return the student is registered to the student list of teh course or not
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for  (Assignment assignment : assignments) {
            assignment.getScores().add(null);

            finalScores.add(null);
        }

        return true;
    }

    /**
     * calculates the weighted average score of a student
     * @return the weighted average score of a student
     */
    public int[] calcStudentsAverage() {
        int numberOfStudents = registeredStudents.size();

        int[] finalScoresArray = new int[numberOfStudents];

        for (int idx = 0; idx < numberOfStudents; idx++) {
            double studentWeightedAverage = 0.0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(idx);

                if (score != null) {
                    double weight = assignment.getWeight();

                    studentWeightedAverage += ((weight / 100.0) * score);
                }
            }

            int roundedStudentAverage = (int) Math.round(studentWeightedAverage);

            finalScores.add((double)roundedStudentAverage);
            finalScoresArray[idx] = roundedStudentAverage;
        }

        return finalScoresArray;
    }

    /**
     *  Adds a new assignment to the course
     * @param assignmentName the input name
     * @param weight the weight of the added assignment
     * @param maxScore the max score of the added assignment
     * @return the new assignment in the course list
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment newAssignment = new Assignment(assignmentName, weight, maxScore);
        assignments.add(newAssignment);

        for (int i = 0; i < assignments.size(); i++) {
            newAssignment.getScores().add(null);
        }

        return true;
    }

    /**
     *  generates random scores for each assignment and student,
     *  and calculates the final score for each student.
     */

    public void generatedScores() {
        Random random = new Random();

        int numOfStudents = registeredStudents.size();

        for (Assignment assignment : assignments) {
            for (int idx = 0; idx < numOfStudents; idx++) {
                int maxScore = 100;
                int randomScore = random.nextInt(maxScore);

                assignment.getScores().set(idx, randomScore);
            }
        }

        this.calcStudentsAverage();
    }

    /**
     * displays the scores of a course in a table, with the assignment averages and student weighted average
     */
    public void displayScores() {
        System.out.println("Course:" + courseName + "(" + courseId + ")" );
        System.out.println();

        System.out.printf("%-18s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("-13s", assignment.getAssignmentName());
        }

        System.out.printf("%-13s%n", "final Score");

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);

            System.out.printf("%-18s", student.getStudentName());

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.printf("%-13s", score == null ? "-" : score);
            }

            System.out.printf("%-15d%n", finalScores.get(i));
        }

        System.out.printf("%-18s", "Average");

        for (Assignment assignment : assignments) {
            int sum = 0;
            int count = 0;

            for (Integer score: assignment.getScores()) {
                if (score != null) {
                    sum += score;
                    count++;
                }
            }

            int avg = count == 0 ? 0 : Math.round(sum / count);
            System.out.printf("%-13d", avg);
        }

        System.out.println();
    }

    public String toSimplifiedString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", departmentName=" + department.getDepartmentName() +
                '}';
    }

    @Override
    public String toString() {
        String result = "Course ID: " + courseId +
                ", Name: " + courseName +
                ", Credits: " + credits +
                ", Department: " + department.getDepartmentName() +
                "\n";

        result += "Assignments: ";
        for (Assignment assign : assignments) {
            result += assign.getAssignmentName() + " (" + assign.getWeight() + "%), ";
        }
        result += "\n";

        result += "Students: ";
        for (Student student : registeredStudents) {
            result += student.getStudentId() + " - " + student.getStudentName() +
                    " (" + student.getDepartment().getDepartmentName() + "), ";
        }
        result += "\n";

        result += "Assignment weights valid: " + isAssignmentWeightValid();

        return result;
    }
}
