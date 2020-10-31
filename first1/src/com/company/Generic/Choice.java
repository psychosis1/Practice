package com.company.Generic;

public class Choice<T extends Number & Comparable<T>> extends Sortinger<T> {
    Choice(T[] array) {
        sortWithTime(array);
    }

    @Override
    void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(min) < 0) {
                    min = array[j];
                    minId = j;
                }
            }
            T temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }
}
