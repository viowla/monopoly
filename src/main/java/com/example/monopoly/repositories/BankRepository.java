package com.example.monopoly.repositories;

import com.example.monopoly.models.Bank;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
    @Override
    <S extends Bank> S saveAndFlush(S s);

    @Override
    <S extends Bank> S save(S s);

    @Override
    long count();

    @Override
    <S extends Bank> long count(Example<S> example);

    @Override
    <S extends Bank> boolean exists(Example<S> example);
}
