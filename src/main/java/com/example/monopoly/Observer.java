package com.example.monopoly;

import com.example.monopoly.models.Player;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;


public class Observer {
    @Builder
    public static void print(Player player, String msg) {
        System.out.println("[Turn " + (player.getTotalWalk()+ 1) + "] [" + player.getCurrentPosition() + "] [$" + player.getMoney() + "] " + msg);
    }
}
