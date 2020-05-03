package com.example.monopoly.models;

import lombok.Getter;


public class Bank {
    @Getter int money;

    public Bank() {
        this(0);
    }

    public Bank(int money) {
        this.money = money;
    }

}
