package com.company.InterfaceAbstract;

public class Butterfly extends Animal implements FlyEntity {
    @Override
    public String toString() {
        return "Butterfly{" +
                "canPet=" + canPet +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Butterfly(boolean canPet, String name) {
        super(canPet, name);
    }

    @Override
    String getType() {
        return "Бабочка";
    }

    @Override
    public double getMaxFlyHeight() {
        return 100.9;
    }

    @Override
    public int getMaxFlyTime() {
        return 60;
    }
}
