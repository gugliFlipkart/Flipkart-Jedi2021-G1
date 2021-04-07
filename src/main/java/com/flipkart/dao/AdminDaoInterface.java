package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

import java.util.List;

public interface AdminDaoInterface {

    /**
     * Interface for Admin Dao
     *
     */
    //public List<Student> viewApprovalPendingRegistration();
    public void approveStudentRegistration();
    public void addCourses(Course course);
    public void dropCourses(String courseId);
    public List<Grade> generateReportCard(String studentId);

}
