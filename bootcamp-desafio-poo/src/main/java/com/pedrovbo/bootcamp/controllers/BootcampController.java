package com.pedrovbo.bootcamp.controllers;

import com.pedrovbo.bootcamp.dtos.BootcampDto;
import com.pedrovbo.bootcamp.dtos.DevDto;
import com.pedrovbo.bootcamp.model.Bootcamp;
import com.pedrovbo.bootcamp.model.Dev;
import com.pedrovbo.bootcamp.model.Mentoria;
import com.pedrovbo.bootcamp.services.BootcampService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/bootcamp")
public class BootcampController {

    final BootcampService bootcampService;

    public BootcampController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @PostMapping
    public ResponseEntity<Object> saveBootcamp(@RequestBody @Valid BootcampDto bootcampDto){
        var bootcamp = new Bootcamp();
        BeanUtils.copyProperties(bootcampDto, bootcamp);

        return ResponseEntity.status(HttpStatus.CREATED).body(bootcampService.save(bootcamp));
    }
    @GetMapping
    public ResponseEntity<Page<Bootcamp>> getAllBootcamps(@PageableDefault(
            page = 0,
            size = 10,
            sort = "id",
            direction = Sort.Direction.ASC ) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(bootcampService.findAll(pageable));
    }


}
