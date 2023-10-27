package com.challenge.PasswordGenerator.dao;

import com.challenge.PasswordGenerator.model.PasswordModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class PasswordGeneratorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void savePasswordModel(PasswordModel passwordModel) {
        entityManager.persist(passwordModel);
    }
}
