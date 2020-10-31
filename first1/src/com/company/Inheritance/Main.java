package com.company.Inheritance;

public class Main {
    public static void main(String[] args) {
        Human human = new Student("Гуля",20,true,2);
        Human human1 = new Teacher("Петр",40,false,"Русский язык",20);
        School building = new School("Птушкино 23",5,1,"Билдинг Скул");
        building.addHuman(human);
        building.addHuman(human1);
        building.nextYear();
        System.out.println(building);
    }
}
