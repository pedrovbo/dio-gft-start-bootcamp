package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Loan;
import com.pedrovbo.emprestimolivros.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan makeLoan(Loan loan) {
        return null;
    }

    @Override
    public List<Loan> getAllLoans() {
        return null;
    }

    @Transactional
    public Loan save(Loan loan){
        return loanRepository.save(loan);
    }

    public Page<Loan> findAll(Pageable pageable){
        return loanRepository.findAll(pageable);
    }

    public Optional<Loan> findById(Long id){
        return loanRepository.findById(id);
    }

    @Transactional
    public void delete(Loan loan){
        loanRepository.delete(loan);
    }



}
