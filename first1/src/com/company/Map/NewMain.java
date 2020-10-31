package com.company.Map;

public class NewMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book book = new Book("Приключения Гели по болотам","Геля");
        Book book1 = new Book("Дима идет домой","Дима");
        library.getBooks().put(book.getId(),book);
        library.getBooks().put(book1.getId(),book1);
        System.out.println(library);
    }
}
