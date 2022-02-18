package com.pedrovbo.bootcamp.controllers;

import com.pedrovbo.bootcamp.dtos.DevDto;
import com.pedrovbo.bootcamp.model.Dev;
import com.pedrovbo.bootcamp.model.Mentoria;
import com.pedrovbo.bootcamp.services.DevService;
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
@RequestMapping("/dev")
public class DevController {

    final DevService devService;

    public DevController(DevService devService) {
        this.devService = devService;
    }

    @PostMapping
    public ResponseEntity<Object> saveDev(@RequestBody @Valid DevDto devDto){
        var dev = new Dev();
        BeanUtils.copyProperties(devDto, dev);

        return ResponseEntity.status(HttpStatus.CREATED).body(devService.save(dev));
    }

    @GetMapping
    public ResponseEntity<Page<Dev>> getAllDevs(@PageableDefault(
            page = 0,
            size = 10,
            sort = "id",
            direction = Sort.Direction.ASC ) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(devService.findAll(pageable));
    }
}