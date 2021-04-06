package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.clientMenu.CRSApplication;
import com.flipkart.constant.SqlQueries;
import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminDao implements AdminDaoInterface{


    private static Logger logger = Logger.getLogger(CRSApplication.class);
    static Scanner scanner = new Scanner(System.in);

    PreparedStatement stmt;
    Connection conn;
    public AdminDao() {
        conn = DBUtils.getConnection();
        PreparedStatement stmt = null;

    }


    @Override
    public List<Student> viewApprovalPendingRegistration() {


        try {
            ResultSet rs = null;
            System.out.println("Creating statement...");

            stmt = conn.prepareStatement(SqlQueries.CHECK_PROF_ALLOTTED); // courseAlreadyAssigned
//            stmt.setString(1, courseId);
            rs = stmt.executeQuery();
//            logger.info("course added succesfully....");
            rs.next();
            Student student= new Student();
            while (rs.next()){


            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void approveStudentRegistration(String studentId) {



    }

    @Override
    public void addCourses(Course course) {





    }

    @Override
    public List<Grade> generateReportCard(String studentId) {

//        StudentDaoInterface studentDaoInterface = new
        return null;
    }
}
