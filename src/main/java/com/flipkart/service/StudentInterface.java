package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseCapacityReached;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.RequiredCourseAdditionException;
import com.sun.tools.javac.util.Pair;

import java.util.List;

/**
 * Interface for student service
 */

public interface StudentInterface {


    public List<Grade> viewReportCard(String student);
    public List<Course> registerForSemester();
    public Pair<Boolean, List<String>> registerCourses(Student student);
    public void addCourse(String student, String courseId) throws CourseAlreadyRegisteredException, RequiredCourseAdditionException, CourseCapacityReached;
    public void dropCourse(String student, String courseId) throws CourseNotFoundException;
    public boolean payFee(Student student, int mode);
    public void studentRegistration(String userId, String password);

}
