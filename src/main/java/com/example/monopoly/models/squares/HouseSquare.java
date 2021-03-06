package com.example.monopoly.models.squares;

import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Observer;
import com.example.monopoly.models.roles.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class HouseSquare extends Square {
    int price;
    int owner = -1;

    public HouseSquare(String name, int price) {
        super(name);
        this.price = price;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void doAction(Player player, Board board) {
        if(owner < 0){
            Observer.print(player, player.getUsername() + ", do you want to buy " + getName() + "?");
            Random rand = new Random();
            if(rand.nextBoolean()){
                Observer.print(player, player.getUsername() + " buy " + getName() + " for " + price);
                owner = Math.toIntExact(player.getId());
                player.getMoney().substractMoney(price);
            }else{
                Observer.print(player, player.getUsername() + " don't want to buy " + getName());
            }
        }else{
            if(owner != player.getId()){
                int lost = price * 70 / 100;
                Observer.print(player, player.getUsername() + " lost " + lost + " money to " + board.getPlayer((long) owner).getUsername());
                player.getMoney().substractMoney(lost);
                board.getPlayer((long) owner).getMoney().addMoney(lost);
            }
        }
    }
}
