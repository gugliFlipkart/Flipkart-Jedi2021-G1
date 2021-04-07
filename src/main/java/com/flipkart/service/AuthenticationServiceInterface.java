package com.flipkart.service;

import com.flipkart.bean.Student;

/***
 * Interface for Authentication service
 */

public interface AuthenticationServiceInterface {

    public String validateCredentials(String userId, String password);

}
