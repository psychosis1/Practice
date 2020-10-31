package com.company.Generic;

import java.util.Arrays;

public class Inserts <T extends Number & Comparable<T>> extends Sortinger<T>{
    public Inserts(T[] array) {
        sortWithTime(array);
    }

    @Override
    void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T current = array[i];
            int j = i - 1;
            while(j >= 0 && current.compareTo(array[j]) < 0) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }
}
