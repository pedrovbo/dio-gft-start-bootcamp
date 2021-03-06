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
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneBootcamp(@PathVariable(value = "id") Long id){
        Optional<Bootcamp> bootcampOptional = bootcampService.findById(id);
        if(!bootcampOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bootcamp não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bootcampOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBootcamp(@PathVariable(value = "id") Long id){
        Optional<Bootcamp> bootcampOptional = bootcampService.findById(id);
        if (!bootcampOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bootcamp não encontrado.");
        }
        bootcampService.delete(bootcampOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Bootcamp deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBootcamp(@PathVariable(value = "id") Long id,
                                            @RequestBody @Valid BootcampDto bootcampDto) {
        Optional<Bootcamp> bootcampOptional = bootcampService.findById(id);
        if (!bootcampOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bootcamp não encontrado.");
        }

        var bootcamp = new Bootcamp();
        BeanUtils.copyProperties(bootcampDto, bootcamp);
        bootcamp.setId(bootcampOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(bootcampService.save(bootcamp));
    }




}
