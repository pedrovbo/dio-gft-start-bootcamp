package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.model.Livro;
import com.pedrovbo.emprestimolivros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LivroController {

    @Autowired
    LivroService livroService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "greetings";
    }

    @RequestMapping(value = "/livro", method = RequestMethod.POST)
    public String addLivro(Model model, @ModelAttribute Livro livro) {
        livroService.createLivro(livro);
        model.addAttribute("livro", livroService.getAllLivros());
        return "result";
    }

}
