package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.dto.LivroDto;
import com.pedrovbo.emprestimolivros.model.Livro;
import com.pedrovbo.emprestimolivros.service.LivroServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroServiceImpl livroServiceImpl;

    //TODO: Implementar consulta de livros

    //TODO: Implementar lista de livros

    @PostMapping
    public ResponseEntity<Object> saveLivro(@RequestBody @Valid LivroDto livroDto) {
        // TODO: Fazer validação para verificar se já existe um emprestimo semelhante
        var livro = new Livro();
        BeanUtils.copyProperties(livroDto, livro);
        // reminder //
        return ResponseEntity.status(HttpStatus.CREATED).body(livroServiceImpl.save(livro));
    }

}
