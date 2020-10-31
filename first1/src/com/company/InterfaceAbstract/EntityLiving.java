package com.company.InterfaceAbstract;

public abstract class EntityLiving {
    static int idCounter=0;
    int id;
    String name;
    abstract String getType();

    public EntityLiving(String name) {
        this.name = name;
        this.id = ++idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
