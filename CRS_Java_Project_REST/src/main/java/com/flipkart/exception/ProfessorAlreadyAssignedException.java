package com.flipkart.exception;


public class ProfessorAlreadyAssignedException extends Exception{

    String courseId;

    public ProfessorAlreadyAssignedException(){
        this.courseId = courseId;
    }

    @Override
    public String getMessage() {
        return "A professor has already been assigned to " + courseId;
    }
}