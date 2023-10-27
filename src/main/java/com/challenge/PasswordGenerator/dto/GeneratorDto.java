package com.challenge.PasswordGenerator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorDto {
    private String firstLetter;
    private String secondLetter;
    private String firstNumber;
    private String secondNumber;
    private String symbol;

}
