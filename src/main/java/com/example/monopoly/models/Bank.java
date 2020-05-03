package com.example.monopoly.models;

import lombok.Getter;

@Getter
public class Bank {
    int money;

    public Bank() {
        this(0);
    }

    public Bank(int money) {
        this.money = money;
    }


}
