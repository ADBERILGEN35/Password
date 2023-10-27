package com.challenge.PasswordGenerator.service;

import com.challenge.PasswordGenerator.dto.GeneratorDto;

import java.util.List;

public interface PasswordGeneratorService {
    String generatePassword(GeneratorDto generatorDto);
    List<String> getAllGeneratedPasswords();

}
