package com.example.monopoly.controllers;


import com.example.monopoly.models.Board;
import com.example.monopoly.models.Dice;
import com.example.monopoly.models.roles.Player;
import org.springframework.web.bind.annotation.GetMapping;

public class MonopolyController {

    Dice die = new Dice();
    Board board;

    // red methods are lombok getter/setter methods

    public MonopolyController(int totalPlayer) {
        board = new Board(totalPlayer);
    }

    @GetMapping("/start")
    public void startGame() {
        System.out.println("Game start!");
        System.out.println("========");
        while (!isGameEnd() && !board.hasWinner()){
            if(!board.getCurrentPlayer().isBrokeOut()){
                int face = board.getCurrentPlayer().tossDie(die);
                board.movePlayer(board.getCurrentPlayer(), face);
            }
            board.nextTurn();
        }
        System.out.println("========");
        if(board.hasWinner()){
            System.out.println(board.getWinner().getName() + " is won by don't brokeout!");
        }else{
            System.out.println(board.getMaxMoneyPlayer().getName() + " is won by have most money!");
        }
        System.out.println("Game over!");
    }

    @GetMapping("/end")
    public boolean isGameEnd() {
        for(Player player:board.getPlayers()){
            if(player.getTotalWalk() < 20){ return false; }
        }
        return true;
    }
}
