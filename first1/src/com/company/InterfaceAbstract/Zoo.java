package com.company.InterfaceAbstract;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    String title;
    List<Animal> animals;

    public Zoo(String title, List<Animal> animals) {
        this.title = title;
        this.animals = animals;
    }


    List<Predator> getAllPredators() {
        List<Predator> list = new ArrayList<>();
        for (Animal animal:animals){
            if (animal instanceof Predator){
                list.add((Predator) animal);
            }
        }
        return list;
    }

    List<FlyEntity> getAllFlyAnimals() {
        List<FlyEntity> list = new ArrayList<>();
        for (Animal animal:animals){
            if (animal instanceof FlyEntity){
                list.add((FlyEntity) animal);
            }
        }
        return list;
    }

    void playAllAnimalSounds(){
        for (Animal animal: animals){
            if (animal instanceof SoundEntity){
                System.out.println(((SoundEntity) animal).getSound());
            }
        }
    }
}
