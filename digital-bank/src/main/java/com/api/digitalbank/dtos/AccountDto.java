package com.api.digitalbank.dtos;

import javax.validation.constraints.*;

public class AccountDto {

    //TODO: Verificar questão da validação de campos para criação de conta, não permitir valores nulos, em branco ou vazios


    private int agency;
    private int accountNumber;
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
