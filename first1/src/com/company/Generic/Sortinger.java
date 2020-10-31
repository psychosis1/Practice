package com.company.Generic;

public abstract class Sortinger<T extends Comparable> {
    abstract void sort(T[] array);

    void sortWithTime(T[] array) {
        long time = System.currentTimeMillis();
        sort(array);
        long after = System.currentTimeMillis();
        System.out.println(after - time);
    }
}
