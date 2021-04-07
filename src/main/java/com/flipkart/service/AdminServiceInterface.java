package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

import java.util.List;

/**
 * Ibterface for Admin Service
 */

public interface AdminServiceInterface {


   // public List<Student> viewApprovalPendingregistration();
    public void approveStudentRegistration();
    public void addCourses(Course course);
    public void dropCourses(String courseId);
    public List<Grade> generateReportCard(String studentId);
}
