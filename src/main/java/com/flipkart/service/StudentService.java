package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseCapacityReached;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.RequiredCourseAdditionException;
import com.flipkart.handler.StudentHandler;
import com.sun.tools.javac.util.Pair;

import java.util.List;

public class StudentService implements StudentInterface {

    /**
     * singleton
     */
    private static volatile StudentService instance = null;
    public static StudentService getInstance() {
        if (instance == null) {
            synchronized (StudentService.class) {
                instance = new StudentService();
            }
        }
        return instance;
    }

    StudentDaoInterface studentDaoInterface = StudentDao.getInstance();

    public List<Course> registerForSemester(){

        //fetch course list

        return studentDaoInterface.registerForSemester();
    }




    public void addCourse(String studentId, String courseId) throws CourseAlreadyRegisteredException, RequiredCourseAdditionException, CourseCapacityReached {

        studentDaoInterface.addCourse(studentId,courseId);

    }


    public void dropCourse(String studentId, String courseId) throws CourseNotFoundException {
        studentDaoInterface.dropCourse(studentId,courseId);

    }


    public Pair<Boolean, List<String>> registerCourses(Student student){

        return  null;
    }


    public boolean payFee(Student student, int mode){
        // if all course resgistration successfull than only can this fn be called
        //calls bankApi to do payment and get payment status
        boolean status = true;// dummy

        // this status is sent to atudentdao.payfeeStatusUpdate
        // this updates db payment status

        return status;

    }
    public List<Grade> viewReportCard(String studentId){
        return studentDaoInterface.viewReportCard(studentId);

    }


    public void studentRegistration(String studenntId, String password){

        studentDaoInterface.studentRegistration(studenntId, password);


    }

}
