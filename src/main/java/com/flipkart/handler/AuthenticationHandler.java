package com.flipkart.handler;

import com.flipkart.bean.Student;
import com.flipkart.service.AuthenticationService;
import com.flipkart.service.AuthenticationServiceInterface;

/**
 * authentication handler
 */

public class AuthenticationHandler {

    public String callAuthService(String userId, String password){
        AuthenticationServiceInterface authenticationServiceInterface  = new AuthenticationService();
        return authenticationServiceInterface.validateCredentials(userId, password);


    }


}
