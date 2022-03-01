package com.api.digitalbank.controllers;

import com.api.digitalbank.dto.BankDto;
import com.api.digitalbank.models.BankModel;
import com.api.digitalbank.services.BankService;
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
@RequestMapping("/bank")
public class BankController {

    final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    public ResponseEntity<Object> saveBank(@RequestBody @Valid BankDto bankDto) {
        if (bankService.existsByBankName(bankDto.getBankName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Bank is already registered!");
        }

        var bankModel = new BankModel();
        BeanUtils.copyProperties(bankDto, bankModel);
        // reminder //
        return ResponseEntity.status(HttpStatus.CREATED).body(bankService.save(bankModel));
    }

    @GetMapping
    public ResponseEntity<Page<BankModel>> getAllBanks(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(bankService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneBank(@PathVariable(value = "id") UUID id) {
        Optional<BankModel> bankModelOptional = bankService.findById(id);
        if (!bankModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bankModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBank(@PathVariable(value = "id") UUID id) {
        Optional<BankModel> bankModelOptional = bankService.findById(id);
        if (!bankModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank not found");
        }
        bankService.delete(bankModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Bank deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBank(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Valid BankDto bankDto) {
        Optional<BankModel> bankModelOptional = bankService.findById(id);
        if (!bankModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank not found.");
        }

        var bankModel = new BankModel();
        BeanUtils.copyProperties(bankDto, bankModel);
        bankModel.setId(bankModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(bankService.save(bankModel));
    }


}
