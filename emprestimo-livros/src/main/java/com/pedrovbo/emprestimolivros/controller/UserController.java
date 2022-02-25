package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.dto.UserDto;
import com.pedrovbo.emprestimolivros.model.User;
import com.pedrovbo.emprestimolivros.service.UserServiceImpl;
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

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody @Valid UserDto userDto){
        //TODO: Implementar validação de existência
        var user = new User();
        BeanUtils.copyProperties(userDto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImpl.save(user));
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(@PageableDefault(
            sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.findAll(pageable));
    }

}
