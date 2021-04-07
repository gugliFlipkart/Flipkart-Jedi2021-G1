package com.flipkart.clientMenu;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.UserType;
import com.flipkart.exception.CourseAlreadyRegisteredException;
import com.flipkart.exception.CourseCapacityReached;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.RequiredCourseAdditionException;
import com.flipkart.handler.AuthenticationHandler;
import jdk.internal.util.xml.impl.Pair;
import org.apache.log4j.Logger;

import java.util.Scanner;



public class CRSApplication {

    private static Logger logger = Logger.getLogger(CRSApplication.class);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        welcomeScreen();


    }


    /**
     * Method used to display Welcome Screen
     *
     */


    public static void welcomeScreen(){
        logger.info("  ");
        logger.info("-------------------------------------------------------------------------------------------------");
        logger.info("-------------------------------  Welcome to Course Management System  ---------------------------");
        logger.info("-------------------------------------------------------------------------------------------------");
        logger.info("   ");
        logger.info("======================================  Enter your choice  ======================================");
        logger.info("   ");
        logger.info(" 1. Login ");
        logger.info(" 2. Student Registration ");
        logger.info(" 3. Update password ");
        logger.info(" 9. Logout ");
        logger.info("  ");

        int userAction = scanner.nextInt();

        switch (userAction){
            case 1:
                login();
            case 2:
                studentRegistration();
            case 3:
                updatePassword();
            case 9:
                logger.info("********  Logged out  **********");
                break;
        }



    }

    /**
     *  Method which helps user login
     *  and takes the user to their corresponding Menu
     */

    public static void login() {

        String userId;
        String password;
        logger.info("Enter UserId");
        scanner.nextLine();
        userId = scanner.nextLine();
        logger.info("Enter Password");
        password = scanner.nextLine();


        AuthenticationHandler authenticationHandler = new AuthenticationHandler();
        String userType = authenticationHandler.callAuthService(userId, password) ;

        try {


            if (userType != null) {

                switch (userType) {
                    case "STUDENT":
                        StudentMenu studentMenu = new StudentMenu(userId);
                        studentMenu.enterStudentDashboard();
                        break;
                    case "PROFESSOR":

                        ProfessorMenu professorMenu = new ProfessorMenu();

                        professorMenu.enterProfessorDashboard(userId);

                        break;
                    case "ADMIN":

                        AdminMenu adminMenu = new AdminMenu();

                        adminMenu.enterAdminDashboard();
                        break;


                }


            } else {
               logger.info("***************  Oops!  Invalid Credentials   ************** ");
            }


        } catch (CourseCapacityReached courseCapacityReached) {
            courseCapacityReached.printStackTrace();
        } catch (CourseNotFoundException e) {
            e.printStackTrace();
        } catch (RequiredCourseAdditionException e) {
            e.printStackTrace();
        } catch (CourseAlreadyRegisteredException e) {
            e.printStackTrace();
        }

    }

    public static void studentRegistration(){




    }

    public static void updatePassword(){



    }


}
