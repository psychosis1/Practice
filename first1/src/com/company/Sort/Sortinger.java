package com.company.Sort;

public abstract class Sortinger {
    abstract void sort(int[] array);
    void sortWithTime(int[] array){
        long time = System.currentTimeMillis();
        sort(array);
        long after = System.currentTimeMillis();
        System.out.println(after-time);
    }
}
