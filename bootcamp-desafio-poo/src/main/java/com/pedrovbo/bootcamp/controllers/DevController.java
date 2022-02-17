package com.pedrovbo.bootcamp.controllers;

import com.pedrovbo.bootcamp.dtos.DevDto;
import com.pedrovbo.bootcamp.model.Dev;
import com.pedrovbo.bootcamp.services.DevService;
import org.springframework.beans.BeanUtils;
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
}
