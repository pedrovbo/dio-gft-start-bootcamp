package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.model.Livro;
import com.pedrovbo.emprestimolivros.model.Pessoa;
import com.pedrovbo.emprestimolivros.service.LivroService;
import com.pedrovbo.emprestimolivros.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmprestimoController {

    @Autowired
    LivroService livroService;
    @Autowired
    PessoaService pessoaService;


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


    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("livro", new Pessoa());
        return "greetings";
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public String addPessoa(Model model, @ModelAttribute Pessoa pessoa) {
        pessoaService.createPessoa(pessoa);
        model.addAttribute("pessoa", pessoaService.getAllPessoas());
        return "result";
    }*/

}
