package com.flipkart.clientMenu;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseCapacityReached;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.RequiredCourseAdditionException;
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


    /**
     * method to view Student dashboard
     * @throws CourseNotFoundException
     * @throws RequiredCourseAdditionException
     * @throws CourseAlreadyRegisteredException
     * @throws CourseCapacityReached
     */

    public void enterStudentDashboard() throws CourseNotFoundException, RequiredCourseAdditionException, CourseAlreadyRegisteredException, CourseCapacityReached {

        int flag = 0;
        while (true) {
            logger.info("--------Successfully logged in---------");
            logger.info("===========Welcome to Student Menu============");
            logger.info(" 1. Register For Semester \n 2. Pay fee \n 3. View Grades-- 3 \n 9.exit");

            switch (scanner.nextInt()) {
                case 1: //registerforSemester
                    logger.info("----------Registration-----------");
//                String studentId = scanner.next();
                    List<Course> courselist = studentHandler.registerForSemester(); //Todo response = list of course

                    for(Course course: courselist)
                        System.out.println(course.toString());

                    addDropCourse();//param = list of course

                    break;

//                case 2://register courses // checks if no of course added is 6 (4 primary and 2 alter)

//                    studentHandler.registerCourses(userId);

//                    break;

                case 2: // pay fee
                    logger.info("--------Fee Payment Portal---------");
                    // check for succefull registration of courses
//                    boolean courseRegistrationStatus = studentHandler.registerCourses(student).fst;
//
//                    if (courseRegistrationStatus)
//                        paymentMode(student);
//                    else
//                        System.out.println("u have not com[leted course registration! Duffer !");

                    break;

                case 3:// view Grade Card
                    logger.info("--------Grade Card---------");
                    List<Grade> gradelist = studentHandler.viewReportCard(studentId);

                    for(Grade grade : gradelist)
                        System.out.println(grade.toString());

                    break;
                case 9: // to logout
                    flag = 1;
                    break;


            }
            if(flag == 1) {
                System.out.println("---------User logged out-----------");
                break;
            }

        }

    }

    /**
     * Method to help student add/drop courses
     * @param
     * @returns
     */


    public void addDropCourse() throws CourseAlreadyRegisteredException, RequiredCourseAdditionException, CourseCapacityReached, CourseNotFoundException {

//        List<String> addedCourseList = new ArrayList<String>(100);

//        int input = scanner.nextInt();
        int flag =0;
        System.out.println("enter 4 primary and 2 alter course");

        while(true) {
            System.out.println("enter\n add course--> 1 \n drop course --> 2 \n exit--> 9");

            //can put condition
            switch (scanner.nextInt()) {
                case 1://add

//                addCourseList.add(scanner.next());
                    System.out.println("Enter CourseID to Add");
                    String courseIdAdd = scanner.next();
                    studentHandler.addCourse(studentId,courseIdAdd);//sends 1 course at a time
                    break;

                case 2://drop
                    System.out.println("Enter CourseID to Drop");
                    String courseIdDrop = scanner.next();
                    studentHandler.dropCourse(studentId,courseIdDrop);//
                    break;
                case 9://exit key for outer while loop
                    flag = 1;
                    break;

                }

            if(flag == 1) {
                System.out.println("exiting add drop page");
                break;
            }

        }

    }

    /**
     * Method to help student pay fee
     * @param student
     */

    public void paymentMode(Student student){
        //online (credit )offline
        //Todo check for payment staus in db

        System.out.println("select mode of Payemnt \n cc-- 1\n db---2\n offline --3");
        int mode = scanner.nextInt();
        studentHandler.payFee(student,mode);

    }


}
