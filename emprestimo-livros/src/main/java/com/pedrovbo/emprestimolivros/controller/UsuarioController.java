package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.dto.UsuarioDto;
import com.pedrovbo.emprestimolivros.model.Usuario;
import com.pedrovbo.emprestimolivros.service.UsuarioServiceImpl;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<Page<Usuario>> getAllUsers(@PageableDefault(
            sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UsuarioDto usuarioDto){
        //TODO: Implementar validação de existência
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServiceImpl.save(usuario));
    }


}
