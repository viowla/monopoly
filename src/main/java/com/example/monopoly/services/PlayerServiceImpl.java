package com.example.monopoly.services;

import com.example.monopoly.models.roles.Player;
import com.example.monopoly.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class PlayerServiceImpl implements PlayerService, UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Player> getAllUsers() {
        return playerRepository.findAll();
    }

    @Override
    public void createUser(Player user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        playerRepository.saveAndFlush(user);
    }

    @Override
    public void updateUser(Long id, Player user) {
        Player userDb = playerRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setUsername(user.getUsername());
            userDb.setPassword(user.getPassword()); // plaintext password

            Player.saveAndFlush(userDb);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player user = playerRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }
        return user;
    }
}
