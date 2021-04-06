package com.flipkart.exception;

public class ResultNotDeclaredException extends Exception {

    //can be used for both student and admin
    String studentId;

    public ResultNotDeclaredException(String studentId) {

        this.studentId = studentId;
    }

    public String getMessage(){

        return "Be patient ! " + studentId +" All the Grades not added yet ";

    }
}
