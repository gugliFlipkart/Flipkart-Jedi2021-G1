package com.flipkart.exception;


public class CourseAlreadyPresentInCatalogueException extends Exception{
    String courseId;
    public CourseAlreadyPresentInCatalogueException(String courseId){
        this.courseId = courseId;
    }
    @Override
    public String getMessage(){
        return courseId + " already present in Course Catalogue.";
    }
}