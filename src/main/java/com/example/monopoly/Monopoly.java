package com.example.monopoly;

import com.example.monopoly.controllers.MonopolyController;

import java.util.Scanner;

public class Monopoly {

    public static void main(String[] args) {
        System.out.println("\tMonopoly\n");
        Scanner scanner = new Scanner(System.in);
        int totalPlayer = 0;
        while (totalPlayer < 2 || totalPlayer > 8) {
            try {
                System.out.println("How many people are playing?");
                System.out.print("Players (2 - 8): ");
                totalPlayer = scanner.nextInt();
            }
            catch(Exception e) {
                System.err.println("Error: Number too large.");
                continue;
            }
            if(totalPlayer > 8) {
                System.err.println("Error: Invalid player count.");
            }
        }
        scanner.close();
        MonopolyController game = new MonopolyController(totalPlayer);
        game.startGame();
    }


}
