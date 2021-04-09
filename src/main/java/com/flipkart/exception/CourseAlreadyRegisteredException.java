package com.flipkart.exception;

public class CourseAlreadyRegisteredException extends Exception {

    String courseId;
    public CourseAlreadyRegisteredException(String courseId){
        this.courseId = courseId;
    }

    @Override
    public String getMessage(){
        return "You have already registered for " + courseId;
    }

}