package com.flipkart.exception;


public class CourseCapacityReached extends Exception{



    // can be used for student and professor


    @Override
    public String getMessage() {
        return "This course has reached its maximum limit. Add some other course.";
    }
}