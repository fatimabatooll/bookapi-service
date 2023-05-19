package com.glc.bookapi;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public class BookRepository implements IBook<Book> {

    private Map<Integer, Book> repository;
    
    public BookRepository() {
        repository = new HashMap<>();
    }

    @Override
    public void saveBook(Book book) {
        repository.put(book.getId(), book);
    }

    @Override
    public Collection<Book> viewAllBook() {
        return repository.values();
    }

    @Override
    public void deleteBook(int id) {
        repository.remove(id);
    }

    @Override
    public void updateBook(Book book) {
        repository.put(book.getId(), book);
    }

}
