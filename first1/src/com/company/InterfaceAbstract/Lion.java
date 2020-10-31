package com.company.InterfaceAbstract;

public class Lion extends Predator implements SoundEntity{
    @Override
    public String toString() {
        return "Lion{" +
                "canPet=" + canPet +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Lion(String name) {
        super(name);
    }

    @Override
    String getType() {
        return "Лев";
    }

    @Override
    public String getSound() {
        return "Рарррр";
    }
}
