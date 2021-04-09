package com.flipkart.service;

import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoService;

import java.sql.SQLException;

public class RegistrationSevice implements RegistrationInterface {

    RegistrationDaoInterface registrationDaoInterface = new RegistrationDaoService();

    @Override
    public double calculateFee(String studentId) throws SQLException {
        return registrationDaoInterface.calculateFee(studentId);
    }
}
