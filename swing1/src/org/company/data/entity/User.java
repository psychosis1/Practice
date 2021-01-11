package org.company.data.entity;

import org.company.data.SexEnum;

public class User {
    private int id;
    private String login;
    private String password;
    private SexEnum sexEnum;
    private int age;
    private String job;
    private String note;

    public User(String login, String password, SexEnum sexEnum, int age, String job) {
        this.login = login;
        this.password = password;
        this.sexEnum = sexEnum;
        this.age = age;
        this.job = job;
    }

    public User(int id, String login, String password, SexEnum sexEnum, int age, String job) {
        this(login, password, sexEnum, age, job);
        this.id = id;
    }

    public User(int id, String login, String password, SexEnum sexEnum, int age, String job, String note) {
        this(login, password, sexEnum, age, job);
        this.id = id;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SexEnum getSexEnum() {
        return sexEnum;
    }

    public void setSexEnum(SexEnum sexEnum) {
        this.sexEnum = sexEnum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
