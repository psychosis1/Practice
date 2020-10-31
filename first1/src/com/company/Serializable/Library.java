package com.company.Serializable;

import java.io.*;
import java.util.List;

public class Library implements Externalizable {
    String title;
    List<Book> bookList;

    public Library(String title, List<Book> bookList) {
        this.title = title;
        this.bookList = bookList;
    }
    public Library(){}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeObject(bookList);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        bookList = (List<Book>) in.readObject();
    }

    public static void save(String path, Library library) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(library);
        objectOutputStream.close();
    }

    public static Library load(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        return (Library) objectInputStream.readObject();
    }

    @Override
    public String toString() {
        return "Library{" +
                "title='" + title + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
