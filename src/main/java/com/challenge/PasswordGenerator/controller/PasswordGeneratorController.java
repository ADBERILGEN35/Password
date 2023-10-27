package com.challenge.PasswordGenerator.controller;

import com.challenge.PasswordGenerator.dto.GeneratorDto;
import com.challenge.PasswordGenerator.service.PasswordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/password")
public class PasswordGeneratorController {

    private final PasswordGeneratorService passwordGeneratorService;

    @Autowired
    public PasswordGeneratorController(PasswordGeneratorService passwordGeneratorService) {
        this.passwordGeneratorService = passwordGeneratorService;
    }

    @PostMapping("/generate")
    public String generatePassword(@RequestBody GeneratorDto generatorDto) {
        String generatedPassword = passwordGeneratorService.generatePassword(generatorDto);
        return "Generated Password: " + generatedPassword;
    }

    @GetMapping("/passwords")
    public void listGeneratedPasswords() {
        List<String> generatedPasswords = passwordGeneratorService.getAllGeneratedPasswords();
        generatedPasswords.stream().forEach(System.out::println);
    }

}
