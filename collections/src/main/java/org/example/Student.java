package org.example;

import java.util.*;

public class Student {

    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>(grades);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        return grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public void promoteToNextCourse() {
        if (getAverageGrade() >= 3) {
            course++;
        }
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public static void removeUnderperformingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void promoteEligibleStudents(Set<Student> students) {
        students.forEach(Student::promoteToNextCourse);
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }
}
