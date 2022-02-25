package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.dto.BookDto;
import com.pedrovbo.emprestimolivros.model.Book;
import com.pedrovbo.emprestimolivros.service.BookServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    //TODO: Implementar consulta de livros

    //TODO: Implementar lista de livros

    @PostMapping
    public ResponseEntity<Object> addBook(@RequestBody @Valid BookDto bookDto) {
        // TODO: Fazer validação para verificar se já existe um emprestimo semelhante
        var book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        // reminder //
        return ResponseEntity.status(HttpStatus.CREATED).body(bookServiceImpl.save(book));
    }

}
