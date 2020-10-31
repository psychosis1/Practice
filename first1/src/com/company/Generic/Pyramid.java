package com.company.Generic;

public class Pyramid<T extends Number & Comparable<T>> extends Sortinger<T> {
    Pyramid(T[] array) {
        sortWithTime(array);
    }

    @Override
    void sort(T[] array) {
        if (array.length == 0) return;

        // Строим кучу
        int length = array.length;
        // проходим от первого без ответвлений к корню
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);

        for (int i = length - 1; i >= 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    void heapify(T[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        // если левый дочерний больше родительского
        if (leftChild < length && array[leftChild].compareTo(array[largest]) > 0) {
            largest = leftChild;
        }

        // если правый дочерний больше родительского
        if (rightChild < length && array[rightChild].compareTo(array[largest]) > 0) {
            largest = rightChild;
        }

        // если должна произойти замена
        if (largest != i) {
            T temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }
}
