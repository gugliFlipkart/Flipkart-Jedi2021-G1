package com.flipkart.dao;

import com.flipkart.bean.Notification;
import com.flipkart.constant.SqlQueries;
import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NotificationDao implements NotificationDaoInterface {

    private static Logger logger = Logger.getLogger(PaymentDao.class);
    static Scanner scanner = new Scanner(System.in);

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/CRS";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn;

    @Override
    public void sendNotification(String transactionId, String studentId, String message, double amount) throws ClassNotFoundException,SQLException {
//        conn = DBUtils.getConnection();
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement stmt = null;


        try {
            System.out.println("Creating statement...");
            stmt = conn.prepareStatement(SqlQueries.INSERT_NOTIFICATION);
            stmt.setString(1,transactionId);
            stmt.setString(2,studentId);
            stmt.setString(3,message);
            stmt.setDouble(4,amount);


            int rs = stmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
}
