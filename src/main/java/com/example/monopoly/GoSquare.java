package com.example.monopoly;

public class GoSquare extends Square {
    public GoSquare(String name) {
        super(name);
    }

    @Override
    public void doAction(Player player, Board board) {
        Observer.print(player, player.getName() + " is at Go... Giving 1000 money");
        player.getMoney().addMoney(1000);
    }
}
