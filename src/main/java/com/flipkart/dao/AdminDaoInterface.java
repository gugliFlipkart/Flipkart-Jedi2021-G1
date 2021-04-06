package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

import java.util.List;

public interface AdminDaoInterface {


    public List<Student> viewApprovalPendingRegistration();
    public void approveStudentRegistration(String studentId);
    public void addCourses(Course course);
    public List<Grade> generateReportCard(String studentId);

}
