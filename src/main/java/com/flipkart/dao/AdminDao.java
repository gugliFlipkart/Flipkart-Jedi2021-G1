package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.clientMenu.CRSApplication;
import com.flipkart.constant.SqlQueries;
import com.flipkart.exception.CourseAlreadyPresentInCatalogueException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorAlreadyAssignedException;
import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    /**
     * singleton class
     */
    private static volatile AdminDao instance = null;
    public static AdminDao getInstance() {
        if (instance == null) {
            synchronized (AdminDao.class) {
                instance = new AdminDao();
            }
        }
        return instance;
    }



    /**
     * Method to approve student registration by admin
     * @param studentId
     */
    @Override
    public void approveStudentRegistration(String studentId) {
        try {
            ResultSet rs = null;
            stmt = conn.prepareStatement(SqlQueries.APPROVE_STUDENT_QUERY);




        } catch(SQLException throwables){
            throwables.printStackTrace();
        }



    }


    /**
     * Method used to add course in course catalogue by admin
     * @param course
     */
    @Override
    public void addCourses(Course course) {

        int checkIfCourseAlreadyAdded = 0;
       try {
           stmt = conn.prepareStatement(SqlQueries.CHECK_IF_COURSE_EXISTS); // courseAlreadyAssigned
           stmt.setString(1, course.getCourseId());
           ResultSet rs = stmt.executeQuery();

           rs.next();
           checkIfCourseAlreadyAdded = rs.getInt(1);


           if (checkIfCourseAlreadyAdded > 0)
               throw new CourseAlreadyPresentInCatalogueException(course.getCourseId());
           else {
               try {

                   stmt = conn.prepareStatement(SqlQueries.ADD_COURSE_QUERY);
                   stmt.setString(1, course.getCourseId());
                   stmt.setString(2, course.getProfId());
                   stmt.setString(3, course.getCourseName());
                   stmt.setString(4, course.getCourseFee());
                   stmt.executeUpdate();
                   logger.info("The following code has been added to the Course Catalogue! ");
                   logger.info(course.toString());


               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
       }
       catch (Exception ex) {
           ex.printStackTrace();
       }



    }

    /**
     * Method to remove a course from course catalogue by admin
     * @param courseId
     */

    @Override
    public void dropCourses(String courseId) {


        int checkIfCoursePresent = 1;
        try {
            stmt = conn.prepareStatement(SqlQueries.CHECK_IF_COURSE_EXISTS); // courseAlreadyAssigned
            stmt.setString(1, courseId);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            checkIfCoursePresent = rs.getInt(1);


            if (checkIfCoursePresent > 0) {

                try {

                    stmt = conn.prepareStatement(SqlQueries.DELETE_COURSE_QUERY);
                    stmt.setString(1, courseId);

                    logger.info(courseId + " has been removed from the Course Catalogue!");
                    stmt.executeUpdate();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } else {
                throw new CourseNotFoundException(courseId);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (CourseNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to generate given Student's Report Card
     * @param studentId
     * @return
     */

        @Override
    public List<Grade> generateReportCard(String studentId) {


        List<Grade> gradeList = new ArrayList<>();



        try {
            System.out.println("Creating statement...");
            stmt = conn.prepareStatement(SqlQueries.VIEW_GRADE);
            stmt.setString(1,studentId);
            ResultSet rs = stmt.executeQuery();


            while(rs.next()){
                String courseId = rs.getString("courseId");
                String courseName = rs.getString("courseName");
                String gradeObtained = rs.getString("grade");

                Grade grade = new Grade();
                grade.setCourseId(courseId);
                grade.setCourseName(courseName);
                grade.setGradeObtained(gradeObtained);

                gradeList.add(grade);


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

        return gradeList;


    }
}
