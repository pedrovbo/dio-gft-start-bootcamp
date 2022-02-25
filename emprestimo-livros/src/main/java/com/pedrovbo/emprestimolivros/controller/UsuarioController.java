package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.model.Usuario;
import com.pedrovbo.emprestimolivros.service.UsuarioService;
import com.pedrovbo.emprestimolivros.service.UsuarioServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;



    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<Page<Usuario>> getAllUsers(@PageableDefault(
            sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.findAll(pageable));
    }


}
