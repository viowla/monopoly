package com.example.monopoly.repositories;

import com.example.monopoly.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    public void nextTurn();

    public boolean hasWinner();


    @Override
    <S extends Board> S saveAndFlush(S s);

    @Override
    void deleteAll();
}
