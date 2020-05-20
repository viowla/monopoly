package com.example.monopoly.models;

import com.example.monopoly.models.roles.Observer;
import com.example.monopoly.models.roles.Player;
import com.example.monopoly.models.squares.*;
import lombok.Getter;

import java.util.Random;

public class Board {
    int currentTurn = 0;
    int totalPlayer = 0;
    @Getter
    Player[] players;
    Square[] squares = new Square[40];
    String[] names = new String[] { "House", "Villa", "Town", "City", "Peace", "Village", "Jade", "Soi 4", "White", "Dark" };

    public Board(int totalPlayer) {
        players = new Player[totalPlayer];
        this.totalPlayer = totalPlayer;
        for(int i = 0;i < players.length;i++){
            players[i] = new Player((long) i, "Player " + (i + 1));
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

    public Square movePlayer(Player player, int face) {
        return movePlayer(player, face, true);
    }

    public Square movePlayer(Player player, int face, boolean count) {
        // isBrokeOut(), getCurrentPosition(), setPosition(), getName(), getMoney(), setBrokeOut() method lombok in Player class
        if(player.isBrokeOut()){
            return squares[player.getPosition()];
        }
        int newPosition = normalizePosition(player.getPosition() + face);
        player.setPosition(newPosition);
        Observer.print(player, player.getName() + " goes to " + squares[player.getPosition()].getName());
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
            // isBrokeOut() method lombok in Player class
            if(!player.isBrokeOut()){
                ingame++;
            }
        }
        return ingame <= 1;
    }

    public Player getWinner() {
        if(!hasWinner()){ return null; }
        for(Player player:players){
            // isBrokeOut() method lombok in Player class
            if(!player.isBrokeOut()){ return player; }
        }
        return null;
    }

    public Player getMaxMoneyPlayer() {
        Player maxplayer = null;
        for(Player player:players){
            // getMoney() method lombok in Player class
            if(maxplayer == null || maxplayer.getMoney().getMoney() < player.getMoney().getMoney()){
                maxplayer = player;
            }
        }
        return maxplayer;
    }

    public int normalizePosition(int position) {

        return position % squares.length;
    }

    public Player getCurrentPlayer() {

        return players[currentTurn];
    }

   /* public Player[] getPlayers() {

        return players;
    }*/

    public void nextTurn() {
        if(++currentTurn >= players.length){
            currentTurn = 0;
        }
    }

    public Player getPlayer(Long id) {
        return players[Math.toIntExact(id)];
    }

    public int getTotalSquare() {
        return squares.length;
    }
}
