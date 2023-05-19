package com.glc.bookapi;



import java.util.Collection;

public interface IBook<T> {
    public void saveBook(T t);

    public Collection<Book> viewAllBook();

    public void deleteBook(int id);

    public void updateBook(T t);

}
