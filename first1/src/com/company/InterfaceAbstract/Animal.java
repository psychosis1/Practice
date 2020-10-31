package com.company.InterfaceAbstract;

public abstract class Animal extends EntityLiving{
    boolean canPet;

    public Animal(boolean canPet,String name) {
        super(name);
        this.canPet = canPet;
    }

    public boolean isCanPet() {
        return canPet;
    }

    public void setCanPet(boolean canPet) {
        this.canPet = canPet;
    }
}
