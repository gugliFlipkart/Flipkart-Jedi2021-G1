package com.flipkart.service;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorInterface {

    public void addGrades(Grade grade);
    public List<Student> viewEnrolledStudent(String courseId);
    public void addCoursesToTeach(String professorId,String courseId);
}
