package com.example.monopoly.models;


import com.example.monopoly.models.roles.Player;
import com.example.monopoly.models.squares.*;

import javax.persistence.ManyToOne;
import java.util.Random;

public class Board {
    int currentTurn = 0;
    int totalPlayer = 0;
    @ManyToOne
    Player[] players;
    @ManyToOne
    Square[] squares = new Square[40];
    String[] names = new String[] { "House", "Villa", "Town", "City", "Peace", "Village", "Jade", "Soi 4", "White", "Dark" };

    public Board(int totalPlayer) {
        players = new Player[totalPlayer];
        this.totalPlayer = totalPlayer;
        for(int i = 0;i < players.length;i++){
            players[i] = new Player(i, "Player " + (i + 1));
        }
        Random rand = new Random();
        for(int i = 0;i < squares.length;i++){
            if(i == 0){
                squares[i] = new GoSquare("GO");
            }else if(i == 9){
                squares[i] = new JailSquare("Jail");
            }else if(i == 19){
                squares[i] = new VacationSquare("Vacation");
            }else if(i == 29){
                squares[i] = new GoToJailSquare("Go to Jail");
            }else{
                squares[i] = new HouseSquare(names[rand.nextInt(names.length)] + " " + names[rand.nextInt(names.length)], 400 + rand.nextInt(300));
            }
        }
    }


    public Player getMaxMoneyPlayer() {
        Player maxplayer = null;
        for(Player player:players){
            if(maxplayer == null || maxplayer.getMoney().getMoney() < player.getMoney().getMoney()){
                maxplayer = player;
            }
        }
        return maxplayer;
    }

    public Player getCurrentPlayer() {
        return players[currentTurn];
    }

    public Player[] getPlayers() {
        return players;
    }

    public void nextTurn() {
        if(++currentTurn >= players.length){
            currentTurn = 0;
        }
    }


}
