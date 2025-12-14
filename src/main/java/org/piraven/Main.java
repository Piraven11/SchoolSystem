package org.piraven;

public class Main {
    public static void main(String[] args) {
        Department department = new Department("lol is");
        System.out.println(department);

        Course course = new Course("Lol", 2.5, department);
        System.out.println(course);
    }
}