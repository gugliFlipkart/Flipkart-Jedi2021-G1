package com.flipkart.handler;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.service.AdminService;
import com.flipkart.service.AdminServiceInterface;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorService;

import java.util.List;

/**
 * handler class for admin
 */

public class AdminHandler {


    AdminServiceInterface adminService= AdminService.getInstance();


    public void approveStudentRegistration(){
        adminService.approveStudentRegistration();
    }

    public void addCourses(Course course){
        adminService.addCourses(course);
    }

     public void dropCourses(String courseId){
        adminService.dropCourses(courseId);
     }
    public List<Grade> generateReportCard(String studentId){

        return  adminService.generateReportCard(studentId);


    }


}
