package com.company.InterfaceAbstract;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Predator lion = new Lion("Мурка");
        FlyEntity butterfly = new Butterfly(false, "БабОчка");
        System.out.println(butterfly.getMaxFlyHeight());

        Animal cow = new Cow(true, "Коровка");

        Zoo zoo = new Zoo("Дурка",Arrays.asList(lion,(Animal) butterfly,cow));

        System.out.println(zoo.getAllPredators());
        System.out.println(zoo.getAllFlyAnimals());
        zoo.playAllAnimalSounds();
    }
}
