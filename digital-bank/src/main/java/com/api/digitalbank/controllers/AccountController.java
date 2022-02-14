package com.api.digitalbank.controllers;

import com.api.digitalbank.dtos.AccountDto;
import com.api.digitalbank.dtos.BankDto;
import com.api.digitalbank.models.AccountModel;
import com.api.digitalbank.models.BankModel;
import com.api.digitalbank.services.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/account")
public class AccountController {

    final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAccount(@RequestBody @Valid AccountDto accountDto) {
        if (accountService.existsByAccountNumber(accountDto.getAccountNumber())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Account number is already registered!");
        }
        var accountModel = new AccountModel();
        BeanUtils.copyProperties(accountDto, accountModel);
        // reminder //
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(accountModel));
    }

    @GetMapping
    public ResponseEntity<Page<AccountModel>> getAllAccounts(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAccount(@PathVariable(value = "id") UUID id) {
        Optional<AccountModel> accountModelOptional = accountService.findById(id);
        if (!accountModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable(value = "id") UUID id) {
        Optional<AccountModel> accountModelOptional = accountService.findById(id);
        if (!accountModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }
        accountService.delete(accountModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Account deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAccount(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Valid AccountDto accountDto) {
        Optional<AccountModel> accountModelOptional = accountService.findById(id);
        if (!accountModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found.");
        }

        var accountModel = new AccountModel();
        BeanUtils.copyProperties(accountDto, accountModel);
        accountModel.setId(accountModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(accountService.save(accountModel));
    }

}
