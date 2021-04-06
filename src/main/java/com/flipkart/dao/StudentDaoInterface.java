package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseCapacityReached;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.RequiredCourseAdditionException;

import java.util.List;

public interface StudentDaoInterface {

    public List<Course> registerForSemester();
//    public Pair<Boolean, List<String>> registerCourses(Student student);
    public boolean addCourse(String studentId, String courseId) throws RequiredCourseAdditionException, CourseCapacityReached, CourseAlreadyRegisteredException;
    public boolean dropCourse(String studentId, String courseId) throws CourseNotFoundException;
    public List<Grade> viewReportCard(String student);


}
