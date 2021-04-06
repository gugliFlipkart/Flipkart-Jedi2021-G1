package com.flipkart.dummyDao;

import com.flipkart.bean.Grade;

import java.util.ArrayList;
import java.util.List;

public class DummyGradesDB {


    private static  DummyGradesDB instance = null;
    private List<Grade> gradeList= new ArrayList<Grade> ();



    public void addStudentGrade(Grade grade){

        gradeList.add(grade);
    }



    public static DummyGradesDB getInstance()
    {
        if(instance==null)
        {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized(DummyGradesDB.class){
                instance=new DummyGradesDB();
            }
        }
        return instance;
    }



}
