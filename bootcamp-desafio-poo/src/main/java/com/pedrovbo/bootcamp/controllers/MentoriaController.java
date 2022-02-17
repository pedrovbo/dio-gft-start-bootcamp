package com.pedrovbo.bootcamp.controllers;

import com.pedrovbo.bootcamp.dtos.DevDto;
import com.pedrovbo.bootcamp.dtos.MentoriaDto;
import com.pedrovbo.bootcamp.model.Dev;
import com.pedrovbo.bootcamp.model.Mentoria;
import com.pedrovbo.bootcamp.services.MentoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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


}
