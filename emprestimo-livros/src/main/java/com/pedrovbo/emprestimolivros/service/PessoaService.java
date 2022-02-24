package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa createPessoa(Pessoa pessoa);
    List<Pessoa> getAllPessoas();

}
