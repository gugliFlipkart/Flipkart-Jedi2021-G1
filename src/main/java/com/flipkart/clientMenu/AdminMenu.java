package com.flipkart.clientMenu;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.handler.AdminHandler;
import com.flipkart.handler.ProfessorHandler;
import com.flipkart.service.AdminService;
import com.flipkart.service.ProfessorService;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {


    private static Logger logger = Logger.getLogger(AdminMenu.class);

    Scanner scanner = new Scanner(System.in);
    AdminHandler adminHandler = new AdminHandler();
    AdminService adminService = new AdminService();


    /**
     * Method used to display admin menu
     */

    public void enterAdminDashboard() {


        int flag = 0;
        logger.info("******************** Successfully logged in ***************************");
        while (true) {

            logger.info(" ");
            logger.info("--------------------------------------------------------------------------");
            logger.info("==========================Welcome to Admin Menu =========================");
            logger.info("--------------------------------------------------------------------------");
            logger.info(" ");
            logger.info("Enter your choice");
            logger.info("1. Approve Student Registration \n 2. Add Course in Course Catalogue \n 3. Delete a course from Course Catalogue \n 4. Generate Student Report card \n  9. Exit");

            switch (scanner.nextInt()) {

                case 1:    // approve student registration

                    //logger.info("Enter the Student's ID");
                    //String studentId = scanner.next();
                    adminHandler.approveStudentRegistration(); //Todo remove studentId as parameter
                    break;


                case 2:   // add course in course catalogue

                    logger.info("Enter the course ID: ");
                    String courseId = scanner.next();
                    logger.info("Enter the course Name: ");
                    String courseName = scanner.next();
                    logger.info("Enter the professor ID: ");
                    String profId = scanner.next();
                    logger.info("Enter the course fee: ");
                    String coursefee = scanner.next();
                    Course course = new Course(courseId, courseName, profId, coursefee);
                    adminHandler.addCourses(course);

                    break;

                case 3:       // drop course

                    logger.info("Enter the Course ID: ");
                    String courseIdd = scanner.next();
                    adminHandler.dropCourses(courseIdd);
                    break;

                case 4:
                    logger.info("Enter student ID: ");
                    String studentId = scanner.next();
                    List<Grade> gradeList = adminHandler.generateReportCard(studentId);

                    for(Grade grade : gradeList)
                        System.out.println(grade.toString());
                    break;


                case 9:// logout
                    flag = 1;
                    break;

                default:
                    logger.info("Invalid Choice!");
                    break;

            }

            if (flag == 1) {
                logger.info("******* Logging Out! *********");
                break;
            }
        }

    }
}




