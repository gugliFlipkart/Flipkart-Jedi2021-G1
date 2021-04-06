package com.flipkart.dummyDao;

import com.flipkart.bean.Course;
import com.flipkart.bean.CourseRegistration;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class DummyCourseCatalogueDB {


    private static  DummyCourseCatalogueDB instance = null;
    private List<CourseRegistration> courseRegistrationList= new ArrayList<CourseRegistration>();
    private List<Course> courseList= new ArrayList<Course>();


    public static DummyCourseCatalogueDB getInstance()
    {
        if(instance==null)
        {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized(DummyCourseCatalogueDB.class){
                instance=new DummyCourseCatalogueDB();
            }
        }
        return instance;
    }




    public List <String> fetchEnrolledStudents(String courseId){

        List<String> courseStudentList = new ArrayList<>();

        for( CourseRegistration item : courseRegistrationList){

            if(item.getCourseId() == courseId){


                courseStudentList.add(item.getStudentId());
            }

        }
        return  courseStudentList;
    }



//    public void addCourses(String ){
//
//
//
//    }

}
