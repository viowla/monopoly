package com.example.monopoly.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    @Getter
    private String message;

}
