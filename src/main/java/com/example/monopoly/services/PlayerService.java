package com.example.monopoly.services;

import com.example.monopoly.models.roles.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getAllUsers();
    void createUser(Player user);
    void updateUser(Long id, Player user);
}
