package org.company.data.entity;

import java.util.Date;

public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String Patronymic;
    private Date date;
    private Date registrationDate;
    private String Email;
    private String phone;
    private char genderCode;
    private String photoPath;

    public Client(int id, String firstName, String lastName, String patronymic, Date date, Date registrationDate, String email, String phone, char genderCode, String photoPath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Patronymic = patronymic;
        this.date = date;
        this.registrationDate = registrationDate;
        Email = email;
        this.phone = phone;
        this.genderCode = genderCode;
        this.photoPath = photoPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(char genderCode) {
        this.genderCode = genderCode;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
