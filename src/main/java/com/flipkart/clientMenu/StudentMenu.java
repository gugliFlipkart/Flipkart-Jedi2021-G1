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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMenu {

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
            System.out.println("We are in Student Menu\n Enter \n register For Sem--> 1\n pay feee -- 2\n view grades-- 3 \n exit --9");

            switch (scanner.nextInt()) {
                case 1: //registerforSemester
                    System.out.println("In student menu case 1");
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

                    PaymentHandler paymentHandler = new PaymentHandler();
                    paymentHandler.make_payment(studentId);

                    break;

                case 3://
                    List<Grade> gradelist = studentHandler.viewReportCard(studentId);

                    for(Grade grade : gradelist)
                        System.out.println(grade.toString());

                    break;
                case 9:// llogout
                    flag = 1;
                    break;


            }
            if(flag == 1) {
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

    public void paymentMode(Student student){
        //online (credit )offline
        //Todo check for payment staus in db

        System.out.println("select mode of Payemnt \n cc-- 1\n db---2\n offline --3");
        int mode = scanner.nextInt();
        studentHandler.payFee(student,mode);

    }


}
