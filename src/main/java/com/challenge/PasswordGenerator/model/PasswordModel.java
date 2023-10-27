package com.challenge.PasswordGenerator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PASSWORDMODEL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "GENERATEDPASSWORD")
    private String generatedPassword;
}