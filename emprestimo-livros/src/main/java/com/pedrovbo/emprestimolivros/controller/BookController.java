package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.dto.BookDto;
import com.pedrovbo.emprestimolivros.model.Book;
import com.pedrovbo.emprestimolivros.model.User;
import com.pedrovbo.emprestimolivros.service.BookServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<Page<Book>> getAllBooks(@PageableDefault(
            sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(bookServiceImpl.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>getOneBook(@PathVariable(value="id") Long id){
        Optional<Book> bookOptional = bookServiceImpl.findById(id);
        if(!bookOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteBook(@PathVariable(value = "id") Long id){
        Optional<Book> bookOptional = bookServiceImpl.findById(id);
        if(!bookOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
        bookServiceImpl.delete(bookOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object>updateBook(@PathVariable(value = "id") Long id,
                                            @RequestBody @Valid BookDto bookDto){
        Optional<Book> bookOptional = bookServiceImpl.findById(id);
        if(!bookOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
        var book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        book.setId(bookOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(bookServiceImpl.save(book));
    }

}
