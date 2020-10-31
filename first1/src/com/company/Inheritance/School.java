package com.company.Inheritance;

import java.util.ArrayList;
import java.util.List;

public class School extends Building {
    private int index;
    private String title;
    private List<Teacher> teachers;
    private List<Student> students;

    public School(String address, int floorCount, int index, String title) {
        super(address, floorCount);
        this.index = index;
        this.title = title;
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addHuman(Human human) {
        if (human instanceof Student)
            students.add((Student) human);
        else teachers.add((Teacher) human);
    }

    protected void nextYear() {
        for (Human human : students) {
            human.nextYear();
        }
        for (Human human : teachers) {
            human.nextYear();
        }
    }

    @Override
    public String toString() {
        return "School{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", teachers=" + teachers +
                ", students=" + students +
                '}';
    }
}
