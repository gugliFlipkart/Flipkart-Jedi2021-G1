package com.flipkart.bean;

import java.util.List;

public class Course {

    private String courseId;
    private String courseName;
    private String profId;
    private String courseFee;

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", profId='" + profId + '\'' +
                ", courseFee='" + courseFee + '\'' +
                '}';
    }

    public Course(String courseId, String courseName, String profId, String courseFee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.profId = profId;
        this.courseFee = courseFee;
    }


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public String getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(String courseFee) {
        this.courseFee = courseFee;
    }
}
