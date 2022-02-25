package com.pedrovbo.emprestimolivros.controller;

import com.pedrovbo.emprestimolivros.dto.LoanDto;
import com.pedrovbo.emprestimolivros.model.Loan;
import com.pedrovbo.emprestimolivros.service.LoanServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


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

    @GetMapping
    public ResponseEntity<Page<Loan>> getAllLoans(@PageableDefault(
            sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(loanServiceImpl.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>getOneLoan(@PathVariable(value="id") Long id){
        Optional<Loan> loanOptional = loanServiceImpl.findById(id);
        if(!loanOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loan not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(loanOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteLoan(@PathVariable(value = "id") Long id){
        Optional<Loan> loanOptional = loanServiceImpl.findById(id);
        if(!loanOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loan not found.");
        }
        loanServiceImpl.delete(loanOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Loan deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object>updateLoan(@PathVariable(value = "id") Long id,
                                            @RequestBody @Valid LoanDto loanDto){
        Optional<Loan> loanOptional = loanServiceImpl.findById(id);
        if(!loanOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loan not found.");
        }
        var loan = new Loan();
        BeanUtils.copyProperties(loanDto, loan);
        loan.setId(loanOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(loanServiceImpl.save(loan));
    }



}
