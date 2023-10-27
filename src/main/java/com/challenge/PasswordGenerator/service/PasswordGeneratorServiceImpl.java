package com.challenge.PasswordGenerator.service;

import com.challenge.PasswordGenerator.dao.H2DatabaseConnection;
import com.challenge.PasswordGenerator.dao.PasswordGeneratorDao;
import com.challenge.PasswordGenerator.dto.GeneratorDto;
import com.challenge.PasswordGenerator.model.PasswordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PasswordGeneratorServiceImpl implements PasswordGeneratorService {

    private final PasswordGeneratorDao passwordGeneratorDao;
    private final H2DatabaseConnection databaseConnection;

    @Autowired
    public PasswordGeneratorServiceImpl(PasswordGeneratorDao passwordGeneratorDao, H2DatabaseConnection databaseConnection) {
        this.passwordGeneratorDao = passwordGeneratorDao;
        this.databaseConnection = databaseConnection;
    }

    @Transactional
    public String generatePassword(GeneratorDto generatorDto) {
        try (Connection connection = databaseConnection.getConnection()) {
            String firstLetter = generatorDto.getFirstLetter();
            String secondLetter = generatorDto.getSecondLetter();
            String firstNumber = generatorDto.getFirstNumber();
            String secondNumber = generatorDto.getSecondNumber();
            String symbol = generatorDto.getSymbol();
            String randomChars = generateRandomChars();
            String generatedPassword = firstLetter + secondLetter + randomChars + firstNumber + secondNumber + symbol;

            PasswordModel passwordModel = new PasswordModel();
            passwordModel.setGeneratedPassword(generatedPassword);

            passwordGeneratorDao.savePasswordModel(passwordModel);

            return generatedPassword;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Hata oluştu";
        }
    }

    private String generateRandomChars() {
        int passwordLength = 7; // Burayı 7 olarak değiştirdim, çünkü zaten 2 rakam ve 1 sembol eklemek gerekiyor.
        Random random = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String randomChars = random.ints(passwordLength, 0, chars.length())
                .mapToObj(chars::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        return randomChars;
    }

    public List<String> getAllGeneratedPasswords() {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT generatedPassword FROM PasswordModel")) {
            ResultSet resultSet = statement.executeQuery();
            List<String> generatedPasswords = new ArrayList<>();
            while (resultSet.next()) {
                generatedPasswords.add(resultSet.getString("generatedPassword"));
            }
            return generatedPasswords;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
