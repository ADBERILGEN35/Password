package com.challenge.PasswordGenerator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "password_model")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String generatedPassword;
}