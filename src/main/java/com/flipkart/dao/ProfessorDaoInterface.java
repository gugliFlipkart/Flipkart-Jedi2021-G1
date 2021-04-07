package com.flipkart.dao;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorDaoInterface  {

    /**
     * Interface for professor dao
     * @param grade
     */

    public void addGrades(Grade grade);
    public List<Student> fetchEnrolledStudent(String courseId);
    public void addCoursesToTeach(String professorId,String courseId);
}
