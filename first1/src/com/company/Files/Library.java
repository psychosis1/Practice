package com.company.Files;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    String title;
    List<Book> bookList = new ArrayList<>();
    File file = new File("libraries");

    public Library(String title, List<Book> bookList) {
        this.title = title;
        this.bookList = bookList;
    }

    public Library() throws IOException {
        this.load();
    }

    void save() throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(title);
            bufferedWriter.newLine();
            for (Book book : bookList) {
                bufferedWriter.write(book.id + ";" + book.title + ";" + book.author);
                bufferedWriter.newLine();
            }
        }
    }

    void load() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(";");
                if (strings.length>1)
                    this.bookList.add(new Book(Integer.parseInt(strings[0]),strings[1],strings[2]));
            }
        }
    }

}
