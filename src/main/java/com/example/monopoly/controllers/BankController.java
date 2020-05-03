package com.example.monopoly.controllers;

import com.example.monopoly.models.Bank;

public class BankController {

    Bank bankMoney;

    public void addMoney(int amount) {
        bankMoney.getMoney += amount;
    }

    public void substractMoney(int amount) {
        bankMoney.getMoney -= amount;
    }

    public boolean isBrokeOut() {
        return bankMoney.getMoney < 0;
    }
}
