package com.company.Sort;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array =new int[80000];
        for (int i=0;i<array.length;i++)
            array[i]=random.nextInt();
        System.out.println("Пузырек:");
        new Bubble(array.clone());
        System.out.println("Вставки:");
        new Inserts(array.clone());
        System.out.println("Выбором:");
        new Choice(array.clone());

    }
}
