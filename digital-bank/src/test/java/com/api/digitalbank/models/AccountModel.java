package com.api.digitalbank.models;

import com.api.digitalbank.interfaces.IAccount;

import java.io.Serializable;

public class AccountModel implements IAccount, Serializable {

    @Override
    public void withdraw(double valor) {

    }

    @Override
    public void deposit(double valor) {

    }

    @Override
    public void transfer(double valor, IAccount contaDestino) {

    }

    @Override
    public void printExtract() {

    }
}
