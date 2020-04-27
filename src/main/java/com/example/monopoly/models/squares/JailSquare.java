package com.example.monopoly.models.squares;

import com.example.monopoly.Observer;
import com.example.monopoly.models.Board;
import com.example.monopoly.models.Player;
import com.example.monopoly.models.squares.Square;

public class JailSquare extends Square {
    public JailSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        Observer.print(player, player.getName() + " has been Jail and lost 500 money");
        player.getMoney().substractMoney(500);
    }
}