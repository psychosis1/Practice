package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Вася",23,4);
        Student student2 = new Student("Геля",19,1);
//        System.out.println(student1+" "+student2);



        Teacher teacher1 = new Teacher("Марина","ОБЖ");
        Teacher teacher2 = new Teacher("Димон","Физкультура");
//        System.out.println(teacher1+" "+teacher2);

        School school1 = new School(1,"Васина Пупина");
        School school2 = new School(2,"Гелина Гель");
//        System.out.println(school1+" "+school2);

        school1.getTeachers().add(teacher1);
        school2.getTeachers().add(teacher2);
        school1.getStudents().add(student1);

//        school1.setStudents(new Student[]{student1,student2});
//        System.out.println(Arrays.toString(school1.getStudents()));
//
//        school2.setTeachers(new Teacher[]{teacher1,teacher2});
//        System.out.println(Arrays.toString(school2.getTeachers()));

        System.out.println(school1);
        System.out.println(school2);
    }
}
