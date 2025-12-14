package org.piraven;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    public ArrayList<Student> registeredStudents;

    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = "C" + "-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }
}
