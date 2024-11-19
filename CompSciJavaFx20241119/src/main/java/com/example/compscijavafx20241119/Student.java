package com.example.compscijavafx20241119;

public class Student {
    private String  name;
    private String studentClass;
    private Double grade;

    public Student(String name, String studentClass, Double grade) {
        this.name = name;
        this.studentClass = studentClass;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public Double getGrade() {
        return grade;
    }
}
