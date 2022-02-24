package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Pessoa;
import com.pedrovbo.emprestimolivros.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa createPessoa(Pessoa pessoa) {
        return null;
    }

    @Override
    public List<Pessoa> getAllPessoas() {
        return null;
    }

}
