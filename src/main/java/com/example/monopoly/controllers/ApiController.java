package com.example.monopoly.controllers;

import com.example.monopoly.services.EconomicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

    @Autowired
    private EconomicService economicService;

    @GetMapping("/divide")
    public ResponseEntity<?> divide(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(economicService.rent(a));
    }

    @GetMapping
    public ResponseEntity<?> testException() {
        return ResponseEntity.ok(economicService.testException());
    }
}
