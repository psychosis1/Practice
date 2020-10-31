package com.company.Files;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Library library = new Library("Начало", Arrays.asList(new Book(1,"Хоббит","Бильбо"),new Book(2,"Властелин","Наташа")));
        library.save();

        Library library1 = new Library();
        System.out.println(library1.bookList);
    }
}
