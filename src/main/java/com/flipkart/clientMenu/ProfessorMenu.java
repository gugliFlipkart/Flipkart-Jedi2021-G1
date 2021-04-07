package com.flipkart.clientMenu;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.handler.ProfessorHandler;
import com.flipkart.service.ProfessorService;

import java.util.List;
import java.util.Scanner;

public class ProfessorMenu {


    // Prof chosses what operation he wants to perform
    // 1.
    // 2.
    // 3.


    // crsapp -> menu ->handler-> service ->dao -> db

    Scanner scanner = new Scanner(System.in);
    ProfessorHandler professorHandler = new ProfessorHandler();

    ProfessorService professorService = new ProfessorService();

    public void enterProfessorDashboard(String professorId){


        int flag = 0;
        while (true) {
            System.out.println("We are in prof Menu\n Enter \n add couses to teach --> 1\n view Enrolledstudent--> 2\n add grades --> 3 \n exit -- 9");

            switch (scanner.nextInt()) {
                case 1: // add couses to teach
                    System.out.println("Enter courseId you would like to teach ");
                    String courseId = scanner.next();
                    professorHandler.addCoursesToTeach(professorId,courseId);

                    break;
                case 2:  //view student

                    System.out.println("Enter Course ID to see enrolled Student");
                    String courseIdd = scanner.next();
                    List<Student> courseStudentList = professorHandler.ViewStudents(courseIdd);

                    for(Student student:courseStudentList)
                        System.out.println(student.toString());
//                    courseStudentList.forEach(Student-> System.out.println(Student.toString()));

                    break;
                case 3: // add grades

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
                System.out.println("Logging Out !!");
                break;
            }
        }



    }








}
