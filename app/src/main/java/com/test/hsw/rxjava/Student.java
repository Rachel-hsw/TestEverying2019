package com.test.hsw.rxjava;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name=name;
        courses=new ArrayList<>();
        courses.add(new Course("语文"));
        courses.add(new Course("数学"));
        courses.add(new Course("英语"));
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
