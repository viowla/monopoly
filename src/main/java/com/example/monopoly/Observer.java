package com.example.monopoly;

import com.example.monopoly.models.Player;

public class Observer {
    public static void print(Player player, String msg) {
        System.out.println("[Turn " + (player.getTotalWalk() + 1) + "] [" + player.getCurrentPosition() + "] [$" + player.getMoney() + "] " + msg);
    }
}
