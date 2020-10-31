package com.company.Generic;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] array = new Integer[80000];
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt();
        System.out.println("Вставки:");
        new Inserts<>(array.clone());
        System.out.println("Выбором:");
        new Choice<>(array.clone());
        System.out.println("Пирамидка:");
        new Pyramid<>(array.clone());
    }

}
