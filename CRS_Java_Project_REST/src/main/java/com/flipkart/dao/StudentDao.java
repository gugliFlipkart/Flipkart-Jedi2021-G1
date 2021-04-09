package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.clientMenu.CRSApplication;
import com.flipkart.constant.SqlQueries;
import com.flipkart.exception.*;
import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDao implements StudentDaoInterface {

    private static Logger logger = Logger.getLogger(CRSApplication.class);
    static Scanner scanner = new Scanner(System.in);

    PreparedStatement stmt;
    Connection conn;
    public StudentDao() {
//        Connection conn = null;
        conn = DBUtils.getConnection();
        PreparedStatement stmt = null;

    }

    /**
     * singleton
     */
    private static volatile StudentDao instance = null;
    public static StudentDao getInstance() {
        if (instance == null) {
            synchronized (StudentDao.class) {
                instance = new StudentDao();
            }
        }
        return instance;
    }


    /**
     * Method called when student registers for the semester
     * @return course catalogue
     */



    public List<Course> registerForSemester(){


        //fetch course list from db
        List<Course> courseList = new ArrayList<>();

        try {
            ///System.out.println("Creating statement...");
            stmt = conn.prepareStatement(SqlQueries.GET_COURSE_LIST);

            ResultSet rs = stmt.executeQuery();


            while(rs.next()){
                String courseId = rs.getString("courseId");
                String courseName = rs.getString("courseName");
                String courseFee = rs.getString("courseFee");
                String profId = rs.getString("profId");

                courseList.add(new Course(courseId,courseName,profId,courseFee));

            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

       return courseList;
    }



    /**
     * Method used to add the given course for the student
     * @param studentId, courseId
     *
     * @throws RequiredCourseAdditionException
     * @throws CourseCapacityReached
     * @throws CourseAlreadyRegisteredException
     */
    public boolean addCourse (String studentId, String courseId) throws RequiredCourseAdditionException, CourseCapacityReached, CourseAlreadyRegisteredException {

        // check for availabilty


        // if >6 added - display msg else add
        // if already added

        //following var is assigned from db data

        int courseAvailabityStatus = 0; // if >10 display msg
        int addedCoursesCount = 0;
        int courseAlreadyAdded = 0;


        try {
            ResultSet rs = null;
            //System.out.println("Creating statement...");

            stmt = conn.prepareStatement(SqlQueries.GET_HEADCOUNT_COURSE);
            stmt.setString(1,courseId);
            rs = stmt.executeQuery();
            rs.next();
            courseAvailabityStatus = rs.getInt(1);

            stmt = conn.prepareStatement(SqlQueries.STUDENT_COURSE_COUNT);
            stmt.setString(1,studentId);
            rs = stmt.executeQuery();
            rs.next();
            addedCoursesCount = rs.getInt(1);

            //
            stmt = conn.prepareStatement(SqlQueries.CHECK_COURSE_ADDED);
            stmt.setString(1,studentId);
            stmt.setString(2,courseId);
            rs = stmt.executeQuery();
            rs.next();
            courseAlreadyAdded = rs.getInt(1);

            if ( courseAvailabityStatus >= 10)
                //add
                throw new CourseCapacityReached();

            else if( courseAlreadyAdded > 0 )
                throw new CourseAlreadyRegisteredException(courseId);

            else if (addedCoursesCount > 6 ) {
                throw new RequiredCourseAdditionException();
            }

            else{
                //execute insert query

                try {
                    logger.info("*****  Adding Course *****");
                    stmt = conn.prepareStatement(SqlQueries.ADD_COURSE);
                    stmt.setString(1,studentId);
                    stmt.setString(2,courseId);

                    logger.info(stmt.executeUpdate());
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();

                }

            }




        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }









        return true;
    }

    /**
     * Method used for dropping a given course for the student
     * @param studentId, courseId
     * @return
     * @throws CourseNotFoundException
     */

    public boolean dropCourse(String studentId, String courseId) throws CourseNotFoundException {
        //if course added or not
        ResultSet rs =null;
        int coursePresent = 0;

        try {
            stmt = conn.prepareStatement(SqlQueries.CHECK_COURSE_ADDED);
            stmt.setString(1,studentId);
            stmt.setString(2,courseId);
            rs = stmt.executeQuery();
            rs.next();
            coursePresent = rs.getInt(1);

            if( coursePresent == 0) {

                throw new CourseNotFoundException(courseId);

            }
            else{
                //update query
                try {
                    logger.info("*****  Dropping Course  *****");

                    stmt = conn.prepareStatement(SqlQueries.DROP_COURSE);
                    stmt.setString(1,courseId);
                    stmt.setString(2,studentId);


                    logger.info(stmt.executeUpdate());


                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();

                }
                logger.info("Congrats! Course Dropped!");
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();

        }


        //System.out.println("return execute-----------");
        return true;


    }

    //no pay fee fn coz this doesnot interact with db directly

    /**
     * Method used to generate Student's Report Card
     * @param studentId
     * @return
     */

    public List<Grade> viewReportCard(String studentId){

        boolean resultDeclared = false;
        //"select course.courseId,course.courseName,studentGrade.grade from course inner join studentGrade on
        // course.courseId = studentGrade.courseId where studentGrade.studentId = ?";

        List<Grade> gradeList = new ArrayList<>();



        try {
            //logger.info("Creating statement...");
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

    public void studentRegistration(String studentId, String password){

        try {

            // todo check if user already available
            System.out.println("Creating statement...");
            stmt = conn.prepareStatement(SqlQueries.REGISTER_STUDENT);
            stmt.setString(1, studentId);
            stmt.setString(2, "STUDENT");
            stmt.setString(3, password);

            stmt.setInt(4, 0);

            System.out.println(stmt.executeUpdate());
            logger.info("student registered -----");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    
}
