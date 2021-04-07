package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.clientMenu.CRSApplication;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.SqlQueries;
import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Scanner;

public class PaymentDao implements PaymentDaoInterface {

    private static Logger logger = Logger.getLogger(PaymentDao.class);
    static Scanner scanner = new Scanner(System.in);

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/CRS";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn;

    @Override
    public void make_payment(String studentId, ModeOfPayment modeOfPayment, double amt) throws ClassNotFoundException, SQLException {
        //conn = DBUtils.getConnection();
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement stmt = null;

        try {
            System.out.println("Creating statement...");
            stmt = conn.prepareStatement(SqlQueries.INSERT_PAYMENT);
            stmt.setString(1,studentId);
            stmt.setString(2,modeOfPayment.toString());
            stmt.setDouble(3,amt);


            int rs = stmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }
}
