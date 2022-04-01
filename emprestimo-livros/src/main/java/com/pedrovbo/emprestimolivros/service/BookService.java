package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);
    List<Book> getAllBooks();
}
