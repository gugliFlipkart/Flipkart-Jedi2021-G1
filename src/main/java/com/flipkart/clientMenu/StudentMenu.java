package com.flipkart.clientMenu;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseCapacityReached;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.RequiredCourseAdditionException;
import com.flipkart.handler.PaymentHandler;
import com.flipkart.handler.ProfessorHandler;
import com.flipkart.handler.StudentHandler;
import com.flipkart.service.ProfessorService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMenu {

    private static Logger logger = Logger.getLogger(StudentMenu.class);
    private String studentId;
    public StudentMenu(String studentId) {
        this.studentId = studentId;
    }

    Scanner scanner = new Scanner(System.in);
    StudentHandler studentHandler = new StudentHandler();
    // handler -> service -> dao -> query fetch course




    public void enterStudentDashboard() throws CourseNotFoundException, RequiredCourseAdditionException, CourseAlreadyRegisteredException, CourseCapacityReached {

        int flag = 0;
        while (true) {

            logger.info("                                                                                                  ");
            logger.info("*********************************    Successfully logged in      *********************************");
            logger.info("                                                                                                  ");
            logger.info("--------------------------------------------------------------------------------------------------");
            logger.info("===================================  Welcome to Student Menu    ===============================");
            logger.info("----------------------------------------------------------------------------------------------------");
            logger.info("                                                                                                      ");
            logger.info("Enter your choice: ");
            logger.info("                                                                                                      ");

            logger.info(" 1. Register For Semester \n 2. Pay fee \n 3. View Grades \n 9.exit");

            switch (scanner.nextInt()) {
                case 1: //registerforSemester
                    logger.info("-------------------    Student Registration    -------------------");

                    List<Course> courselist = studentHandler.registerForSemester(); //Todo response = list of course

                    for(Course course: courselist)
                        System.out.println(course.toString());

                    addDropCourse();//param = list of course

                    break;



                case 2: // pay fee

                    logger.info("--------------------    Fee Payment Portal     -----------------------");
                    // check for succefull registration of courses
//                    boolean courseRegistrationStatus = studentHandler.registerCourses(student).fst;
//
//                    if (courseRegistrationStatus)
//                        paymentMode(student);
//                    else
//                        System.out.println("u have not com[leted course registration! Duffer !");

                    break;

                case 3:// view Grade Card
                    logger.info("-------------------     Grade Card           -------------------------");


                    PaymentHandler paymentHandler = new PaymentHandler();
                    paymentHandler.make_payment(studentId);

                    break;


                case 9:// llogout
                    flag = 1;
                    break;


            }
            if(flag == 1) {

                logger.info ("********** User logged out **********");

                System.out.println("Logging out!! ===================");

                break;
            }

        }

    }

    /**
     * @param
     * @returns
     */


    public void addDropCourse() throws CourseAlreadyRegisteredException, RequiredCourseAdditionException, CourseCapacityReached, CourseNotFoundException {

//        List<String> addedCourseList = new ArrayList<String>(100);

//        int input = scanner.nextInt();
        int flag =0;
        logger.info("Enter 4 primary and 2 alternate Courses");

        while(true) {
            logger.info("Enter you choice : ");
            logger.info("1. Add course \n 2. Drop course --> 2 \n 9. Exit" );

            //can put condition
            switch (scanner.nextInt()) {
                case 1://add

//                addCourseList.add(scanner.next());
                    logger.info("Enter CourseID of the Course you wish to Add");
                    String courseIdAdd = scanner.next();
                    studentHandler.addCourse(studentId,courseIdAdd);//sends 1 course at a time
                    break;

                case 2://drop
                    logger.info("Enter CourseID of the Course you wish to Drop");
                    String courseIdDrop = scanner.next();
                    studentHandler.dropCourse(studentId,courseIdDrop);//
                    break;
                case 9://exit key for outer while loop
                    flag = 1;
                    break;

                }

            if(flag == 1) {
                logger.info("******  Exiting the add drop page  *******");
                break;
            }

        }

    }

    public void paymentMode(Student student){
        //online (credit )offline
        //Todo check for payment staus in db

       logger.info("select mode of Payment \n 1. Credit Card \n 2. Debit Card \n 3. Offline Payment");
        int mode = scanner.nextInt();
        studentHandler.payFee(student,mode);

    }

    public void studentRegistration(String userId, String password){


    }


}
