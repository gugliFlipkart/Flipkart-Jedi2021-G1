package com.flipkart.dao;

public interface AuthenticationDaoInterface {

    /**
     * Interface for Validate Credentials
     * @param userId
     * @param password
     * @return
     */

    public  String validateCredentials(String userId, String password);

}
