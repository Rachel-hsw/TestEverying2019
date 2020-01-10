package com.rachel.rxjava2demo.rxjava;

import java.util.List;

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name=name;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
