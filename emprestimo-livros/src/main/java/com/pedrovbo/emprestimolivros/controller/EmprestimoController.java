package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.dto.EmprestimoDto;
import com.pedrovbo.emprestimolivros.model.Emprestimo;
import com.pedrovbo.emprestimolivros.service.EmprestimoService;
import com.pedrovbo.emprestimolivros.service.EmprestimoServiceImpl;
import com.pedrovbo.emprestimolivros.service.LivroService;
import com.pedrovbo.emprestimolivros.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    EmprestimoServiceImpl emprestimoServiceImpl;


 /*   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
*/
    @PostMapping
    public ResponseEntity<Object> saveEmprestimo(@RequestBody @Valid EmprestimoDto emprestimoDto) {
        // TODO: Fazer validação para verificar se já existe um emprestimo semelhante
        var emprestimo = new Emprestimo();
        BeanUtils.copyProperties(emprestimoDto, emprestimo);
        // reminder //
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoServiceImpl.save(emprestimo));
    }



}
