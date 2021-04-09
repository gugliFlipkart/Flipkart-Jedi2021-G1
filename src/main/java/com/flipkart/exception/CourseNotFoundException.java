package com.flipkart.exception;

public class CourseNotFoundException extends Exception{
    String courseId;
    public CourseNotFoundException(String courseId){
        this.courseId = courseId;
    }
    @Override
    public String getMessage(){
        return "Course " + courseId +" not found !";
    }
}