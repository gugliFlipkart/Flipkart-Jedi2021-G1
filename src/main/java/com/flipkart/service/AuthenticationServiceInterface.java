package com.flipkart.service;

import com.flipkart.bean.Student;

public interface AuthenticationServiceInterface {

    public String validateCredentials(String userId, String password);

}
