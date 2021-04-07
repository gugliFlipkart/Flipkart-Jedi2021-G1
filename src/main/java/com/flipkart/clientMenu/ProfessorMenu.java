package com.flipkart.clientMenu;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.handler.ProfessorHandler;
import com.flipkart.service.ProfessorService;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class ProfessorMenu {


    // Prof chosses what operation he wants to perform
    // 1.
    // 2.
    // 3.


    // crsapp -> menu ->handler-> service ->dao -> db

    private static Logger logger = Logger.getLogger(ProfessorMenu.class);
    Scanner scanner = new Scanner(System.in);
    ProfessorHandler professorHandler = new ProfessorHandler();

    ProfessorService professorService = new ProfessorService();

    public void enterProfessorDashboard(String professorId){

        logger.info(" ");
        logger.info("*********************************    Successfully logged in      *********************************");
        logger.info(" ");

        int flag = 0;
        while (true) {


            logger.info("--------------------------------------------------------------------------------------------------");
            logger.info("===================================  Welcome to Professor Menu    ===============================");
            logger.info("----------------------------------------------------------------------------------------------------");
            logger.info("     ");
            logger.info("Enter your choice: ");
            logger.info("   ");
            logger.info("1. Add Course to teach \n 2. View Enrolled Students \n 3. Add grades  \n 9. Exit");

            switch (scanner.nextInt()) {
                case 1: // add courses to teach
                    logger.info("-----You're redirected to page where you can add Courses to teach!-----");
                    logger.info("        ");
                    logger.info("Enter courseId you would like to teach :");
                    String courseId = scanner.next();
                    professorHandler.addCoursesToTeach(professorId,courseId);
                    break;

                case 2:  //view student list
                    logger.info("-----You're redirected to page where you can view list of Enrolled students!-----");
                    logger.info(" ");
                    logger.info("Enter Course ID to see enrolled Student");

                    String courseIdd = scanner.next();
                    List<Student> courseStudentList = professorHandler.ViewStudents(courseIdd);

                    for(Student student:courseStudentList)
                        System.out.println(student.toString());
//                    courseStudentList.forEach(Student-> System.out.println(Student.toString()));

                    break;
                case 3: // add grades

                    logger.info("-----You're redirected to page where you can add grades!-----");
                    logger.info("   ");

                    Grade grade = new Grade();
                    System.out.println("enter courseid");
                    grade.setCourseId(scanner.next());
                    System.out.println("enter student id");
                    grade.setStudentId(scanner.next());
                    System.out.println("enter gradeObtained");
                    grade.setGradeObtained(scanner.next());

                    professorHandler.addGrades(grade);
                    break;
                case 9:// logout
                    flag = 1;
                    break;

            }

            if(flag == 1) {

                System.out.println("******  Logged Out!  ******");

                break;
            }
        }



    }








}
