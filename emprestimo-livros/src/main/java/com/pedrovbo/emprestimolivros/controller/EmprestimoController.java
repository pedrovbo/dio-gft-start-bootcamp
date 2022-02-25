package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.service.LivroService;
import com.pedrovbo.emprestimolivros.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmprestimoController {

    @Autowired
    LivroService livroService;
    @Autowired
    UsuarioService usuarioService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/consulta-livros", method = RequestMethod.GET)
    public String consultaLivros() {
        return "consulta-livros";
    }

    @RequestMapping(value = "/lista-livros", method = RequestMethod.GET)
    public String listaLivros() {
        return "lista-livros";
    }


}
