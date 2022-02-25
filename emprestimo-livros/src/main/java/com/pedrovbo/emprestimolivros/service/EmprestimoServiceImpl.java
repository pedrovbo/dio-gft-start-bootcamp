package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Emprestimo;
import com.pedrovbo.emprestimolivros.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Override
    public Emprestimo criarEmprestimo(Emprestimo emprestimo) {
        return null;
    }

    @Override
    public List<Emprestimo> retornarTodosEmprestimos() {
        return null;
    }

    @Transactional
    public Emprestimo save(Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }

    public Page<Emprestimo> findAll(Pageable pageable){
        return emprestimoRepository.findAll(pageable);
    }

    public Optional<Emprestimo> findById(Long id){
        return emprestimoRepository.findById(id);
    }

    @Transactional
    public void delete(Emprestimo emprestimo){
        emprestimoRepository.delete(emprestimo);
    }



}
