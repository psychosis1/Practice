package com.company.Map;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer,Book> books;

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Book> books) {
        this.books = books;
    }

    public Library(Map<Integer, Book> books) {
        this.books = books;
    }

    public Library() {
        this.books = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
