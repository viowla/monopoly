package com.example.monopoly.controllers;

import com.example.monopoly.models.roles.Observer;
import com.example.monopoly.models.roles.Player;
import com.example.monopoly.models.squares.Square;

public class BoardController {

    Player[] players;
    Square[] squares = new Square[40];

    public Square movePlayer(Player player, int face) {
        return movePlayer(player, face, true);
    }

    public Square movePlayer(Player player, int face, boolean count) {
        if(player.isBrokeOut()){ return squares[player.getCurrentPosition()]; }
        int newPosition = normalizePosition(player.getCurrentPosition() + face);
        player.setPosition(newPosition);
        Observer.print(player, player.getName() + " goes to " + squares[player.getCurrentPosition()].getName());
        squares[newPosition].doAction(player, this);
        if(player.getMoney().isBrokeOut()){
            Observer.print(player, player.getName() + " has been broke out!");
            player.setBrokeOut(true);
        }else{
            if(count){
                player.nextTurn();
            }
        }
        return squares[newPosition];
    }

    public boolean hasWinner() {
        int ingame = 0;
        for(Player player:players){
            if(!player.isBrokeOut()){
                ingame++;
            }
        }
        return ingame <= 1;
    }

    public Player getWinner() {
        if(!hasWinner()){ return null; }
        for(Player player:players){
            if(!player.isBrokeOut()){ return player; }
        }
        return null;
    }

    public int normalizePosition(int position) {
        return position % squares.length;
    }

    public Player getPlayer(int id) {
        return players[id];
    }

    public int getTotalSquare() {
        return squares.length;
    }
}
