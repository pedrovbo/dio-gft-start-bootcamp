package com.pedrovbo.bootcamp.controllers;

import com.pedrovbo.bootcamp.dtos.CursoDto;
import com.pedrovbo.bootcamp.dtos.DevDto;
import com.pedrovbo.bootcamp.model.Curso;
import com.pedrovbo.bootcamp.model.Dev;
import com.pedrovbo.bootcamp.model.Mentoria;
import com.pedrovbo.bootcamp.services.CursoService;
import org.springframework.beans.BeanUtils;
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

    @GetMapping
    public ResponseEntity<Page<Curso>> getAllCursos(@PageableDefault(
            page = 0,
            size = 10,
            sort = "id",
            direction = Sort.Direction.ASC ) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCurso(@PathVariable(value = "id") Long id){
        Optional<Curso> cursoOptional = cursoService.findById(id);
        if(!cursoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cursoOptional.get());
    }

}
