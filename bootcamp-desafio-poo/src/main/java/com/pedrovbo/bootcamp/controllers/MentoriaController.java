package com.pedrovbo.bootcamp.controllers;


import com.pedrovbo.bootcamp.dtos.DevDto;
import com.pedrovbo.bootcamp.dtos.MentoriaDto;

import com.pedrovbo.bootcamp.model.Bootcamp;
import com.pedrovbo.bootcamp.model.Dev;
import com.pedrovbo.bootcamp.model.Mentoria;
import com.pedrovbo.bootcamp.services.MentoriaService;
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
@RequestMapping("/mentoria")
public class MentoriaController {

    final MentoriaService mentoriaService;


    public MentoriaController(MentoriaService mentoriaService) {
        this.mentoriaService = mentoriaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveMentoria(@RequestBody @Valid MentoriaDto mentoriaDto){
        var mentoria = new Mentoria();
        BeanUtils.copyProperties(mentoriaDto, mentoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(mentoriaService.save(mentoria));
    }

    @GetMapping
    public ResponseEntity<Page<Mentoria>> getAllMentorias(@PageableDefault(
            page = 0,
            size = 10,
            sort = "id",
            direction = Sort.Direction.ASC ) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(mentoriaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMentoria(@PathVariable(value = "id") Long id){
        Optional<Mentoria> mentoriaOptional = mentoriaService.findById(id);
        if(!mentoriaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mentoria não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(mentoriaOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMentoria(@PathVariable(value = "id") Long id){
        Optional<Mentoria> mentoriaOptional = mentoriaService.findById(id);
        if (!mentoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mentoria não encontrada.");
        }
        mentoriaService.delete(mentoriaOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Mentoria deletada com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMentoria(@PathVariable(value = "id") Long id,
                                            @RequestBody @Valid MentoriaDto mentoriaDto) {
        Optional<Mentoria> mentoriaOptional = mentoriaService.findById(id);
        if (!mentoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mentoria não encontrada.");
        }

        var mentoria = new Mentoria();
        BeanUtils.copyProperties(mentoriaDto, mentoria);
        mentoria.setId(mentoriaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(mentoriaService.save(mentoria));
    }


}
