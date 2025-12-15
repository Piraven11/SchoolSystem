package org.piraven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class StudentTest {

    Department dept = new Department("Math");
    Address address = new Address(67, "Victoria", "Montreal", Address.Province.PE, "B3N4Z1");

    @Test
    @DisplayName("Course register -> true")
    void TestRegisterCourse1() {
        Student student = new Student("Carl Santosh", Student.Gender.MALE, address, dept);
        Course course1 = new Course("Discrete", 3.0, dept);

        course1.addAssignment("D1", 100.0, 100);
        course1.setRegisteredStudents(new ArrayList<>());

        boolean expected1 = true;
        boolean actual1 = student.registerCourse(course1);

        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    @DisplayName("course already registered -> false")
    void testRegisterCourse2() {
        Student student = new Student("Carl Santosh", Student.Gender.FEMALE, address, dept);
        Course course1 = new Course("Discrete", 3.0, dept);

        course1.addAssignment("D1", 100.0, 100);
        course1.setRegisteredStudents(new ArrayList<>());

        student.registerCourse(course1);

        boolean expected = false;
        boolean actual = student.registerCourse(course1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("register more non registered course -> true")
    void testRegisterCourse3() {
        Student student = new Student("Carl Santosh", Student.Gender.FEMALE, address, dept);
        Course course1 = new Course("Discrete", 3.0, dept);
        Course course2 = new Course("Math", 3.0, dept);

        course1.addAssignment("D1", 100.0, 100);
        course2.addAssignment("M1", 100.0, 100);

        course1.setRegisteredStudents(new ArrayList<>());
        course2.setRegisteredStudents(new ArrayList<>());

        student.registerCourse(course1);

        boolean expected = true;
        boolean actual = student.registerCourse(course2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("remove registered course from the student's course list -> true")
    void testDropCourse1() {
        Student student = new Student("Benji", Student.Gender.MALE, address, dept);
        Course course1 = new Course("Math", 3.0, dept);
        Course course2 = new Course("Physic", 3.0, dept);

        student.registerCourse(course1);

        boolean expected1 = true;
        boolean actual1 = student.dropCourse(course1);

        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    @DisplayName("remove registered course from the student's course list -> true")
    void testDropCourse2() {
        Student student = new Student("Benji", Student.Gender.MALE, address, dept);
        Course course1 = new Course("Math", 3.0, dept);
        Course course2 = new Course("Physic", 3.0, dept);

        boolean expected1 = false;
        boolean actual1 = student.dropCourse(course1);

        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    @DisplayName("remove registered course from the student's course list -> true")
    void testDropCourse3() {
        Student student = new Student("Benji", Student.Gender.MALE, address, dept);
        Course course1 = new Course("Math", 3.0, dept);
        Course course2 = new Course("Physic", 3.0, dept);

        student.registerCourse(course1);
        student.registerCourse(course2);

        boolean expected1 = true;
        boolean actual1 = student.dropCourse(course2);

        Assertions.assertEquals(expected1, actual1);
    }
}