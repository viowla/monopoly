package com.example.monopoly.controllers;

import com.example.monopoly.models.Bank;

public class BankController {
    Bank bank;

    // getMoney() method lombok

    public void addMoney(int amount) {
        bank.getMoney() += amount;
    }

    public void substractMoney(int amount) {
        bank.getMoney() -= amount;
    }

    public boolean isBrokeOut() {
        return bank.getMoney() < 0;
    }
}
