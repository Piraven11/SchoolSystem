package org.piraven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CourseTest {

    private static Department dept = new Department("Computer Science");
    private static Address address = new Address(69, "Sigma", "Ligma", Address.Province.AB, "J3H2B1");
    private static Student s1 = new Student("", Student.Gender.MALE, address, dept);
    private static Student s2 = new Student("Bob Johnson", Student.Gender.MALE, address, dept);

    @Test
    @DisplayName("Weight -> True")
    void TestIsAssignmentWeightValid1() {
        Course course1 = new Course("Program",2.6,dept);
        course1.addAssignment("String",50, 100);
        course1.addAssignment("Unit Testing",40, 100);
        course1.addAssignment("Helper Method",10, 100);

        boolean expected = true;
        boolean actual = course1.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Weight -> false")
    void TestIsAssignmentWeightValid2() {
        Course course1 = new Course("Discrete",2.6,dept);
        course1.addAssignment("A1",50, 100);
        course1.addAssignment("A2",40, 100);
        course1.addAssignment("A3",5, 100);

        boolean expected = false;
        boolean actual = course1.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Weight -> false")
    void TestIsAssignmentWeightValid3() {
        Course course1 = new Course("Linear",2.6,dept);

        boolean expected = false;
        boolean actual = course1.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("register student to a non registered course -> true")
    void TestRegisterStudent1() {
        Course course = new Course("Linear", 3.0, dept);
        course.setRegisteredStudents(new ArrayList<>());

        boolean expected = true;
        boolean actual = course.registerStudent(s1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("register student to a registered course -> false")
    void TestRegisterStudent2() {
        Course course = new Course("Linear", 3.0, dept);
        course.setRegisteredStudents(new ArrayList<>());

        course.registerStudent(s2);

        boolean expected = false;
        boolean actual = course.registerStudent(s2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("register student to a registered course -> false")
    void TestRegisterStudent3() {
        Course course = new Course("Linear", 3.0, dept);
        course.setRegisteredStudents(new ArrayList<>());

        course.registerStudent(s1);
        course.registerStudent(s2);

        boolean expected = false ;
        boolean actual = course.registerStudent(s1) &&  course.registerStudent(s2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("student1 average -> {82}")
    void TestCalcStudentsAverage1() {
        Course course = new Course("Linear", 3.0, dept);
        course.setRegisteredStudents(new ArrayList<>());
        course.setFinalScores(new ArrayList<>());

        course.addAssignment("A1", 10.0, 100);
        course.addAssignment("A2", 30.0, 100);
        course.addAssignment("A3", 60.0, 100);

        course.registerStudent(s1);

        course.getAssignments().get(0).getScores().set(0, 56);
        course.getAssignments().get(1).getScores().set(0, 77);
        course.getAssignments().get(2).getScores().set(0, 88);

        int[] expected = {82};
        int[] actual = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("student1 and student2 average -> {81, 85}")
    void TestCalcStudentsAverage2() {
        Course course = new Course("Linear", 3.0, dept);
        course.setRegisteredStudents(new ArrayList<>());
        course.setFinalScores(new ArrayList<>());

        course.addAssignment("A1", 20.0, 100);
        course.addAssignment("A2", 50.0, 100);
        course.addAssignment("A3", 30.0, 100);

        course.registerStudent(s1);
        course.registerStudent(s2);

        course.getAssignments().get(0).getScores().set(0, 100);
        course.getAssignments().get(1).getScores().set(0, 69);
        course.getAssignments().get(2).getScores().set(0, 89);
        course.getAssignments().get(0).getScores().set(1, 67);
        course.getAssignments().get(1).getScores().set(1, 89);
        course.getAssignments().get(2).getScores().set(1, 90);

        int[] expected = {81, 85};
        int[] actual = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("student2 average -> {71}")
    void TestCalcStudentsAverage3() {
        Course course = new Course("Linear", 3.0, dept);
        course.setRegisteredStudents(new ArrayList<>());
        course.setFinalScores(new ArrayList<>());

        course.addAssignment("A1", 12.0, 100);
        course.addAssignment("A2", 21.0, 100);
        course.addAssignment("A3", 67.0, 100);

        course.registerStudent(s2);

        course.getAssignments().get(0).getScores().set(0, 67);
        course.getAssignments().get(1).getScores().set(0, 91);
        course.getAssignments().get(2).getScores().set(0, 65);

        int[] expected = {71};
        int[] actual = course.calcStudentsAverage();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("add an assignment -> true")
    void TestAddAssignment1() {
        Course course = new Course("Discrete", 3.0, dept);
        course.setAssignments(new ArrayList<>());

        boolean expected = true;
        boolean actual = course.addAssignment("A1", 10.0, 100);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("add an assignment that already exist -> false")
    void TestAddAssignment2() {
        Course course = new Course("Discrete", 3.0, dept);
        course.setAssignments(new ArrayList<>());
        course.addAssignment("A1", 10.0, 100);

        boolean expected = false;
        boolean actual  = course.addAssignment("a1", 10.0, 100);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("add an assignment -> true")
    void TestAddAssignment3() {
        Course course = new Course("Discrete", 3.0, dept);
        course.setAssignments(new ArrayList<>());
        course.addAssignment("A1", 10.0, 100);

        boolean expected = true;
        boolean actual = course.addAssignment("B3", 30.0, 100);

        Assertions.assertEquals(expected, actual);
    }
}