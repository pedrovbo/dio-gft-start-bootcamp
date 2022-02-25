package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.dto.LoanDto;
import com.pedrovbo.emprestimolivros.model.Loan;
import com.pedrovbo.emprestimolivros.service.LoanServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    LoanServiceImpl loanServiceImpl;

    @PostMapping
    public ResponseEntity<Object> addLoan(@RequestBody @Valid LoanDto loanDto) {
        // TODO: Fazer validação para verificar se já existe um emprestimo semelhante
        var loan = new Loan();
        BeanUtils.copyProperties(loanDto, loan);
        // reminder //
        return ResponseEntity.status(HttpStatus.CREATED).body(loanServiceImpl.save(loan));
    }



}
