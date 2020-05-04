package com.example.monopoly.controllers;


import com.example.monopoly.models.roles.Player;
import com.example.monopoly.repositories.PlayerRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @ApiOperation(response = {
            @ApiResponse(code = 404, message = "Player is not found"),
            @ApiResponse(code = 400, message = "Invalid player")
    })
    @GetMapping("/")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @ApiOperation(response = {
            @ApiResponse(code = 404, message = "Player is not found"),
            @ApiResponse(code = 400, message = "Invalid player")
    })
    @GetMapping("/{id}")
    public List<Player> findPlayerById(@PathVariable("id") Long id){
        return (List<Player>) playerRepository.findById(id).get();
    }

    @DeleteMapping("/")
    public void deleteAllPlayers(){playerRepository.deleteAll();}

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable("id") Long id){
        playerRepository.deleteById(id);
    }

    @ApiOperation(response = {
            @ApiResponse(code = 404, message = "Player is not changed"),
            @ApiResponse(code = 400, message = "Invalid player")
    })
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable("id") Long id,
                               @RequestBody Player player){
        player.setId(id);
        return  playerRepository.saveAndFlush(player);
    }

    @ApiOperation(response = {
            @ApiResponse(code = 404, message = "Player is not created"),
            @ApiResponse(code = 400, message = "Invalid player")
    })
    @PostMapping("")
    public Player createPlayer(@RequestBody Player player){
        return playerRepository.saveAndFlush(player);
    }


}
