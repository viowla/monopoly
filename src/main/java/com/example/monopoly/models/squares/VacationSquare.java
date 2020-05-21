package com.example.monopoly.models.squares;


import com.example.monopoly.models.roles.Observer;
import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Player;

import java.util.Random;

public class VacationSquare extends Square {
    public VacationSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        Random rand = new Random();
        Square square = board.movePlayer(player, rand.nextInt(board.getTotalSquare()), false);
        Observer.print(player, player.getUsername() + " has go to vacation at " + square.getName());
    }
}
