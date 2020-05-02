package com.example.monopoly.models.squares;


import com.example.monopoly.controllers.BoardController;
import com.example.monopoly.models.roles.Observer;
import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Player;

import java.util.Random;

public class VacationSquare extends Square {
    public VacationSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, BoardController boardController) {
        Random rand = new Random();
        Square square = boardController.movePlayer(player, rand.nextInt(boardController.getTotalSquare()), false);
        Observer.print(player, player.getName() + " has go to vacation at " + square.getName());
    }
}
