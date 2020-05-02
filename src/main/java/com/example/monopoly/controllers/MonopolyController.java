package com.example.monopoly.controllers;

import com.example.monopoly.models.Board;
import com.example.monopoly.models.Dice;
import com.example.monopoly.models.roles.Player;;

public class MonopolyController {
    Board board;
    Dice die = new Dice();
    BoardController boardController;

    public MonopolyController(int totalPlayer) {
        board = new Board(totalPlayer);
    }


    public void startGame() {
        System.out.println("Game start!");
        System.out.println("------------------------------");
        while (!isGameEnd() && !boardController.hasWinner()){
            if(!board.getCurrentPlayer().isBrokeOut()){
                int face = board.getCurrentPlayer().tossDie(die);
                boardController.movePlayer(board.getCurrentPlayer(), face);
            }
            board.nextTurn();
        }
        System.out.println("--------------------------------");
        if(boardController.hasWinner()){
            System.out.println(boardController.getWinner().getName() + " is won by don't brokeout!");
        }else{
            System.out.println(board.getMaxMoneyPlayer().getName() + " is won by have most money!");
        }
        System.out.println("Game over!");
    }

    public boolean isGameEnd() {
        for(Player player:board.getPlayers()){
            if(player.getTotalWalk() < 20){ return false; }
        }
        return true;
    }
}
