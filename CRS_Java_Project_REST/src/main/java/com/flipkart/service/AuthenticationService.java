package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.dao.AuthenticationDao;

public class AuthenticationService implements AuthenticationServiceInterface{

    /**
     * this method communicates with the dao layer
     * @param userId
     * @param password
     * @return
     */
    @Override
    public String  validateCredentials(String userId, String password) {


        AuthenticationDao authenticationDao = new AuthenticationDao();

        return authenticationDao.validateCredentials(userId, password) ;

    }
}
