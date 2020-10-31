package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School {
    private int index;
    private String name;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public School(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "School{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                ", students=" + students +
                '}';
    }
}
