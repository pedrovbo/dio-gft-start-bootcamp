package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Book;
import com.pedrovbo.emprestimolivros.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Transactional
    public Book save(Book book){
        return bookRepository.save(book);
    }

    public Page<Book> findAll(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }

    @Transactional
    public void delete(Book book){
        bookRepository.delete(book);
    }
}
