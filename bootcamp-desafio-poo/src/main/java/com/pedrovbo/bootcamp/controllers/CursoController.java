package com.pedrovbo.bootcamp.controllers;

import com.pedrovbo.bootcamp.dtos.CursoDto;
import com.pedrovbo.bootcamp.dtos.DevDto;
import com.pedrovbo.bootcamp.model.Curso;
import com.pedrovbo.bootcamp.model.Dev;
import com.pedrovbo.bootcamp.services.CursoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/curso")
public class CursoController {

    final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCurso(@RequestBody @Valid CursoDto cursoDto){
        var curso = new Curso();
        BeanUtils.copyProperties(cursoDto, curso);

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));
    }
}
