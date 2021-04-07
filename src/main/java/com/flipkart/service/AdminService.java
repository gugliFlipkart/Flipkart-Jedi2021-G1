package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDao;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.ProfessorDaoInterface;

import java.util.List;

public class AdminService implements AdminServiceInterface {


    /**
     * singleton
     */
    private static volatile AdminService instance = null;
    public static AdminService getInstance() {
        if (instance == null) {
            synchronized (AdminService.class) {
                instance = new AdminService();
            }
        }
        return instance;
    }



    AdminDaoInterface adminDaoInterface = AdminDao.getInstance();







    @Override
    public void approveStudentRegistration(String studentId) {
        adminDaoInterface.approveStudentRegistration(studentId);


    }

    @Override
    public void addCourses (Course course) {
        adminDaoInterface.addCourses(course);


    }


    @Override
    public void dropCourses(String courseId) {
         adminDaoInterface.dropCourses(courseId);
    }

    @Override
    public List<Grade> generateReportCard(String studentId) {
        return adminDaoInterface.generateReportCard(studentId);
    }

}
