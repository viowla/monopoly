package com.example.monopoly.models.roles;

import com.example.monopoly.models.Bank;
import com.example.monopoly.models.Dice;
import com.example.monopoly.models.roles.Observer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode
public class Player {
    int totalWalk = 0;
    int position = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    boolean brokeout = false;
    Bank money = new Bank(5000);

    public Player(Long id, String name) {
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
