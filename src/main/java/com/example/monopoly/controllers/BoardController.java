package com.example.monopoly.controllers;

import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Player;
import com.example.monopoly.repositories.BoardRepository;
import com.example.monopoly.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private PlayerRepository playerRepository;

    Board board = new Board((int) playerRepository.count());

    @GetMapping("/winner")
    public Player getWinner(){
        return board.getWinner();
    }

    @GetMapping("/max_money")
    public Player getMaxMoneyPlayer() {
        return board.getMaxMoneyPlayer();
    }

    @GetMapping("/position")
    public int position(@RequestBody int position){
        return board.normalizePosition(position);
    }

}
