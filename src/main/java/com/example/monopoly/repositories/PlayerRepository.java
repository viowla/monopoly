package com.example.monopoly.repositories;

import com.example.monopoly.models.Player;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Override
    List<Player> findAll();

    @Override
    <S extends Player> List<S> saveAll(Iterable<S> iterable);

    @Override
    <S extends Player> S saveAndFlush(S s);

    @Override
    <S extends Player> S save(S s);

    @Override
    Optional<Player> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();

    @Override
    <S extends Player> long count(Example<S> example);

    @Override
    <S extends Player> boolean exists(Example<S> example);


}
