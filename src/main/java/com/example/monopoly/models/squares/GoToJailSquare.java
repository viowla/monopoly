package com.example.monopoly.models.squares;

import com.example.monopoly.models.roles.Observer;
import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Player;

public class GoToJailSquare extends Square {
    public GoToJailSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        Observer.print(player, player.getUsername() + " has go to Jail");
        board.movePlayer(player, -board.getTotalSquare() / 2, false);
    }
}
