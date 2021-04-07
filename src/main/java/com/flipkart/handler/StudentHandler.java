package com.flipkart.handler;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseCapacityReached;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.RequiredCourseAdditionException;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentService;
import com.sun.tools.javac.util.Pair;

import java.util.List;


/**
 * handler class for student
 */
public class StudentHandler {


    StudentInterface studentServiceInterface = StudentService.getInstance();


    public List<Course> registerForSemester(){
        return studentServiceInterface.registerForSemester();


    }

    public void addCourse(String studentid, String courseId) throws CourseAlreadyRegisteredException, RequiredCourseAdditionException, CourseCapacityReached {
        studentServiceInterface.addCourse(studentid,courseId);

    }
    public void dropCourse(String studentId, String courseId) throws CourseNotFoundException {
        studentServiceInterface.dropCourse(studentId,courseId);
    }

    public Pair<Boolean, List<String>> registerCourses(Student student){

        studentServiceInterface.registerCourses(student);

        return  null;

    }


    public boolean payFee(Student student, int mode){
        studentServiceInterface.payFee(student, mode);

        return false;
    }



    public List<Grade> viewReportCard(String studentId){

        return studentServiceInterface.viewReportCard(studentId);
//        return null;
    }

    public void studentRegistration(String studentId, String password){

        studentServiceInterface.studentRegistration(studentId, password);


    }




}
