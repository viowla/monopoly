package com.example.monopoly.controllers;


import com.example.monopoly.models.roles.Player;
import com.example.monopoly.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/")
    public Player getAllPlayers(){}

}
