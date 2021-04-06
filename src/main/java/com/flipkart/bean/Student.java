package com.flipkart.bean;

public class Student extends User{


    private String studentName;
    private String department;
    private int rollNo;
    private String studentId;

    private int yearOfAdmission;

//    public Student(String studentName, String department, int rollNo, int yearOfAdmission, String studentId) {
//        this.studentName = studentName;
//        this.department = department;
//        this.rollNo = rollNo;
//        this.yearOfAdmission = yearOfAdmission;
//        this.studentId = studentId;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", department='" + department + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }


    //getter and setter

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
