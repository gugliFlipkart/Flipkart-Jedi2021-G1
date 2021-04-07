package com.flipkart.dao;

import java.sql.SQLException;

public interface RegistrationDaoInterface {
    public double calculateFee(String studentId) throws SQLException;
}
