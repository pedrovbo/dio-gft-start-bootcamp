package com.api.digitalbank.models;

import com.api.digitalbank.interfaces.IAccount;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "ACCOUNT")
public class AccountModel implements IAccount, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = false)
    private int agency;
    @Column(nullable = false, unique = false)
    private int accountNumber;
    @Column(nullable = false, unique = true)
    private double balance;

    // protected Client client;

    @Override
    public void withdraw(double value) {
        this.balance -= value;
    }

    @Override
    public void deposit(double value) {
        this.balance += value;
    }

    @Override
    public void transfer(double value, IAccount destinyAccount) {
        this.withdraw(value);
        destinyAccount.deposit(value);
    }

    @Override
    public void printExtract() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAgency() {
        return agency;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void printCommonInfo() {
        // System.out.println(String.format("Titular: %s", this.Client.getName()));
        System.out.println(String.format("Agencia: %d", this.agency));
        System.out.println(String.format("Numero: %d", this.accountNumber));
        System.out.println(String.format("Saldo: %.2f", this.balance));
    }

}
