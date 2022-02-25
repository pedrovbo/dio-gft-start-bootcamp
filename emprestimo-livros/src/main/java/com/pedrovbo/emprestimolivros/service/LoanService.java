package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Loan;

import java.util.List;

public interface LoanService {

    Loan makeLoan(Loan loan);
    List<Loan> getAllLoans();
}
