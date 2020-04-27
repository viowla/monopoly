package com.example.monopoly.models.squares;

import com.example.monopoly.Observer;
import com.example.monopoly.models.Board;
import com.example.monopoly.models.Player;
import com.example.monopoly.models.squares.Square;

public class GoToJailSquare extends Square {
    public GoToJailSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        Observer.print(player, player.getName() + " has go to Jail");
        board.movePlayer(player, -board.getTotalSquare() / 2, false);
    }
}
