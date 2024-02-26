package com.example.manytomany.service;

import com.example.manytomany.entities.Course;
import com.example.manytomany.entities.Students;

import java.util.List;

public interface ServiceInterface {
    public String stuAdd(Students a);
    public String csadd(String a,String b,String c);
    public List<Students> studentsList();
    public List<Course> coursesList();
    public List<Course> specificStuCourses(String sid);
    public List<Students> specificCouStudents(String cid);
    public int  courseUpdate(String a,String b);
    public int  studentNameUpdate(String a,String b);
    public String deleteStudent(String a);
    public String deleteCourse(String courseId);
    public String delCouOfStu(String a,String b);
}
