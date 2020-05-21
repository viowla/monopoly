package com.example.monopoly.controllers;

import com.example.monopoly.models.Board;
import com.example.monopoly.models.roles.Player;
import com.example.monopoly.repositories.BoardRepository;
import com.example.monopoly.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private BoardRepository boardRepository;

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

    @GetMapping("/has_winner")
    public boolean hasWinner(){
        return  boardRepository.hasWinner();
    }

    @GetMapping("/next_turn")
    public void nextTurn(){
        boardRepository.nextTurn();
    }

    @PutMapping("/")
    public Board saveChanges(@RequestBody Board board){
      return   boardRepository.saveAndFlush(board);
    }

    @DeleteMapping("/")
    public void delete(){
        boardRepository.deleteAll();
    }

}
