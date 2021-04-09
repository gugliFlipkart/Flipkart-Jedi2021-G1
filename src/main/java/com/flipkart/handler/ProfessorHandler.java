package com.flipkart.handler;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorService;

import java.util.List;

/**
 * handler class for professor
 */

public class ProfessorHandler {

    ProfessorInterface professorService = ProfessorService.getInstance();

    public void addCoursesToTeach(String professorId, String courseId){

        professorService.addCoursesToTeach(professorId, courseId);
    }


    public void addGrades(Grade grade){
        professorService.addGrades(grade);
    }


    public List<Student> ViewStudents(String courseId){

        return  professorService.viewEnrolledStudent(courseId);


    }


}
