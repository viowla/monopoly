package com.example.monopoly.models.squares;

import com.example.monopoly.controllers.BoardController;
import com.example.monopoly.models.roles.Observer;
import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Player;

public class GoToJailSquare extends Square {
    public GoToJailSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, BoardController boardController) {
        Observer.print(player, player.getName() + " has go to Jail");
        boardController.movePlayer(player, -boardController.getTotalSquare() / 2, false);
    }
}
