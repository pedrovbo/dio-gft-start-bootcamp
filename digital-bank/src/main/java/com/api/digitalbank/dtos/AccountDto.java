package com.api.digitalbank.dtos;

import javax.validation.constraints.NotBlank;

public class AccountDto {

    @NotBlank
    private int agency;
    @NotBlank
    private int accountNumber;
    @NotBlank
    private double balance;

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
