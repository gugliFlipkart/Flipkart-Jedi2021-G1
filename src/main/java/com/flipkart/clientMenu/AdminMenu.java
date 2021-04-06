package com.flipkart.clientMenu;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.handler.ProfessorHandler;
import com.flipkart.service.ProfessorService;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    private static Logger logger = Logger.getLogger(ProfessorMenu.class);

    Scanner scanner = new Scanner(System.in);
    ProfessorHandler professorHandler = new ProfessorHandler();

    ProfessorService professorService = new ProfessorService();


    /**
     *
     */

    public void enterAdminDashboard(String professorId) {


        int flag = 0;
        while (true) {
            logger.info("--------------Successfully logged in---------------");
            logger.info("===================Welcome to Admin Menu=================");
            logger.info("1. View pending Approval Requests \n 2. Approve Student Registration \n 3. Add Course in Course Catalogue \n 4. Generate Student Report card \n  9. Exit");

            switch (scanner.nextInt()) {
                case 1: // add couses to teach
                    logger.info("-----You're redirected to page where you can add view pending approval requests-----");

                    String courseId = scanner.next();
                    professorHandler.addCoursesToTeach(professorId,courseId);

                    break;
                case 2:  //view student
                    logger.info("-----You're redirected to page where you can view list of Enrolled students!-----");
                    logger.info("Enter Course ID to see enrolled Student");
                    String courseIdd = scanner.next();
                    List<Student> courseStudentList = professorHandler.ViewStudents(courseIdd);

                    for(Student student:courseStudentList)
                        System.out.println(student.toString());
//                    courseStudentList.forEach(Student-> System.out.println(Student.toString()));

                    break;
                case 3: // add grades
                    logger.info("-----You're redirected to page where you can add grades!-----");
                    Grade grade = new Grade();
                    System.out.println("Enter course Id : ");
                    grade.setCourseId(scanner.next());
                    System.out.println("Enter Student Id : ");
                    grade.setStudentId(scanner.next());
                    System.out.println("Enter Grade Obtained : ");
                    grade.setGradeObtained(scanner.next());

                    professorHandler.addGrades(grade);
                    break;
                case 9:// logout
                    flag = 1;
                    break;

            }

            if(flag == 1) {
                System.out.println("Logging Out!");
                break;
            }
        }

    }



}
