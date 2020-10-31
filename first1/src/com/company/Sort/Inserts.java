package com.company.Sort;

public class Inserts extends Sortinger{

    public Inserts(int[] array) {
        sortWithTime(array);
    }

    @Override
    void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }
}
