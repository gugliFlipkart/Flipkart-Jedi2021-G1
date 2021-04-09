package com.flipkart.dao;

import com.flipkart.bean.Student;
import com.flipkart.constant.SqlQueries;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class AuthenticationDao implements AuthenticationDaoInterface {


    /**
     * singleton
     */
    private static volatile AuthenticationDao instance = null;
    public static AuthenticationDao getInstance() {
        if (instance == null) {
            synchronized (AuthenticationDao.class) {
                instance = new AuthenticationDao();
            }
        }
        return instance;
    }

    /**
     * Method to validate given user's credentials
     * @param userId
     * @param password
     * @return
     */


    public String validateCredentials(String userId, String password){
        Connection conn = null;
        conn = DBUtils.getConnection();
        PreparedStatement stmt = null;

        //Todo prepare stmt and verify from db

        try {
            System.out.println("Creating statement...");

            stmt = conn.prepareStatement(SqlQueries.AUTHENTICATE_CREDS);
            stmt.setString(1,userId);
            stmt.setString(2,password);

            ResultSet rs = stmt.executeQuery();


            while(rs.next()){
                String userTypeDb = rs.getString("userType");
                return userTypeDb;



            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return  null;
    }





}
