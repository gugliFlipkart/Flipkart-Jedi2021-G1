package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.dao.AuthenticationDao;

public class AuthenticationService implements AuthenticationServiceInterface{


    @Override
    public String  validateCredentials(String userId, String password) {

        // this will communicate with dao layer
        AuthenticationDao authenticationDao = new AuthenticationDao();

        return authenticationDao.validateCredentials(userId, password) ;
//        return null;
    }
}
