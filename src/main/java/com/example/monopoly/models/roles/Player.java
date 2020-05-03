package com.example.monopoly.models.roles;

import com.example.monopoly.models.Bank;
import com.example.monopoly.models.Dice;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
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

    /*public int getTotalWalk() {
        return totalWalk;
    }*/

    public int tossDie(Dice die) {
        int face = die.getFace();
        Observer.print(this, getName() + " toss a die... Face is " + face);
        return face;
    }

   /* public int getCurrentPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }*/

    /*public void nextTurn() {
        totalWalk++;
    }

    public String getName() {
        return name;
    }

    public Bank getMoney() {
        return money;
    }

    public Long getID() {
        return id;
    }

    public void setBrokeOut(boolean brokeout) {
        this.brokeout = brokeout;
    }

    public boolean isBrokeOut() {
        return brokeout;
    }*/
}
