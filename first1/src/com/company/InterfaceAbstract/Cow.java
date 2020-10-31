package com.company.InterfaceAbstract;

public class Cow extends Animal implements SoundEntity{
    @Override
    public String toString() {
        return "Cow{" +
                "canPet=" + canPet +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Cow(boolean canPet, String name) {
        super(canPet, name);
    }

    @Override
    String getType() {
        return "Корова";
    }

    @Override
    public String getSound() {
        return "Муууу";
    }
}
