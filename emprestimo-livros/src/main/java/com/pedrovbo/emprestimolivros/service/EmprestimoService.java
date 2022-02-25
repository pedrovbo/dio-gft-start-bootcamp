package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Emprestimo;

import java.util.List;

public interface EmprestimoService {

    Emprestimo criarEmprestimo(Emprestimo emprestimo);
    List<Emprestimo> retornarTodosEmprestimos();
}
