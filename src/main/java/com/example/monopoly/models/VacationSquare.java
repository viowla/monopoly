package com.example.monopoly.models;


import com.example.monopoly.Observer;

import java.util.Random;

public class VacationSquare extends Square {
    public VacationSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        Random rand = new Random();
        Square square = board.movePlayer(player, rand.nextInt(board.getTotalSquare()), false);
        Observer.print(player, player.getName() + " has go to vacation at " + square.getName());
    }
}
