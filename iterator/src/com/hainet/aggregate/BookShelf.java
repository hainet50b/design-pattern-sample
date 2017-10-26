package com.hainet.aggregate;

import com.hainet.element.Book;
import com.hainet.iterator.ConcreteIterator;
import com.hainet.iterator.Iterator;

// Concrete Aggregate Role
public class BookShelf implements Aggregate {

    private Book[] books;
    private int index = 0;

    public BookShelf(final int size) {
        this.books = new Book[size];
    }

    public int size() {
        return index;
    }

    public Book get(final int index) {
        return books[index];
    }

    public void add(final Book book) {
        books[index++] = book;
    }

    public void pop() {
        books[--index] = null;
    }

    public boolean contains(final Book book) {
        for (int i=0; i<books.length; i++) {
            if (books[i] == book) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator<>(this);
    }
}