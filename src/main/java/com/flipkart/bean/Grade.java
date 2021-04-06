package com.flipkart.bean;

import java.util.Map;

public class Grade {
    private String studentId;
    private String courseId;
    private String gradeObtained;
    private String courseName ;
//
//    public Grade(String studentId, String courseId, String gradeObtained) {
//        this.studentId = studentId;
//        this.courseId = courseId;
//        this.gradeObtained = gradeObtained;
//
//    }
//
//
//    public Grade(String studentId,String courseName, String courseId, String gradeObtained) {
//        this.studentId = studentId;
//        this.courseId = courseId;
//        this.gradeObtained = gradeObtained;
//        this.courseName = courseName;
//    }


    @Override
    public String toString() {
        return "Grade{" +
                "courseId='" + courseId + '\'' +
                ", gradeObtained='" + gradeObtained + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getGradeObtained() {
        return gradeObtained;
    }

    public void setGradeObtained(String gradeObtained) {
        this.gradeObtained = gradeObtained;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
