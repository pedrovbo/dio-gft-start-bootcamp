package com.api.digitalbank.dtos;

import javax.validation.constraints.NotBlank;

public class BankDto {

    @NotBlank
    private String bankName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
