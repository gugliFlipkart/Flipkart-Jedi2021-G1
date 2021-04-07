package com.flipkart.dao;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.clientMenu.CRSApplication;
import com.flipkart.constant.SqlQueries;
import com.flipkart.exception.CourseCapacityReached;
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

public class ProfessorDao implements ProfessorDaoInterface{

    private static Logger logger = Logger.getLogger(CRSApplication.class);
    static Scanner scanner = new Scanner(System.in);

    PreparedStatement stmt;
    Connection conn;
    public ProfessorDao() {
        conn = DBUtils.getConnection();
        PreparedStatement stmt = null;

    }


    /**
     * singleton
     */
    private static volatile ProfessorDao instance = null;
    public static ProfessorDao getInstance() {
        if (instance == null) {
            synchronized (ProfessorDao.class) {
                instance = new ProfessorDao();
            }
        }
        return instance;
    }


    /**
     * Method used to add courses to teach by professor
     * @param professorId
     * @param courseId
     */
    public void addCoursesToTeach(String professorId,String courseId) {
//        professorDao

        int courseAlreadyAssigned = 0; // if >10 display msg
        int courseAlreadyAdded = 0;


        try {
            ResultSet rs = null;
            System.out.println("Creating statement...");

            stmt = conn.prepareStatement(SqlQueries.CHECK_PROF_ALLOTTED); // courseAlreadyAssigned
            stmt.setString(1,courseId);
            rs = stmt.executeQuery();
//            logger.info("course added succesfully....");
            rs.next();
            courseAlreadyAssigned = rs.getInt(1);


            if ( courseAlreadyAssigned > 0)
                //add
                throw new ProfessorAlreadyAssignedException();


            else{
                //execute insert query

                try {
                    System.out.println("Adding Course...");
                    stmt = conn.prepareStatement(SqlQueries.ADD_COURSE_TO_TEACH_PROFESSOR);
                    stmt.setString(2,professorId);
                    stmt.setString(1,courseId);


                    System.out.println(stmt.executeUpdate());
                    logger.info("course added succesfully....");
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                    //course if not present in catalogue than throws err

                }

            }




        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ProfessorAlreadyAssignedException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("got exception ========"+e.getMessage());
        }


    }


    /**
     * Method to fetch enrolled students' list for professor
     * @param courseId
     * @return
     */
    public List<Student> fetchEnrolledStudent(String courseId) {

        List<Student> studentList = new ArrayList<>();

        try {
            ResultSet rs = null;
            System.out.println("Creating statement...");

            stmt = conn.prepareStatement(SqlQueries.VIEW_ENROLLED_STUDENTS); // courseAlreadyAssigned
            stmt.setString(1,courseId);
            rs = stmt.executeQuery();
//            logger.info("course added succesfully....");

            Student student = new Student();
            while(rs.next()){
                student.setStudentId(rs.getString("Id"));
                student.setStudentName(rs.getString("name"));
                student.setDepartment(rs.getString("department"));

                studentList.add(student);
            }




        return studentList;



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        System.out.println("reached dao");
        return null;

    }

    /**
     * Method used to add grades by professor
     * @param grade
     */

    public void addGrades(Grade grade){

        try {
            ResultSet rs = null;
            System.out.println("Creating statement...");
            stmt = conn.prepareStatement(SqlQueries.ADD_GRADE); // courseAlreadyAssigned
            stmt.setString(1, grade.getGradeObtained());
            stmt.setString(2, grade.getCourseId());
            stmt.setString(3, grade.getStudentId());

            logger.info(stmt.executeUpdate());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("reached dao");


    }


}
