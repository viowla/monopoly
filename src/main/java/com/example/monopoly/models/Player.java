package com.example.monopoly.models;

import com.example.monopoly.Observer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Player {
    int totalWalk = 0;
    int position = 0;
    int id;
    String name;
    boolean brokeout = false;
    Bank money = new Bank(5000);

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int tossDie(Dice die) {
        int face = die.setDice();
        Observer.print(this, getName() + " toss a die... Face is " + face);
        return face;
    }

    public void nextTurn() {
        totalWalk++;
    }

    public boolean isBrokeOut() {
        return brokeout;
    }
}
