package com.example.manytomany.service;

import com.example.manytomany.entities.Course;
import com.example.manytomany.entities.Students;
import com.example.manytomany.repositories.CouRepo;
import com.example.manytomany.repositories.StuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
   @Autowired
    StuRepo srepo;
   @Autowired
    CouRepo crepo;
    public String stuAdd(Students a){
        if(srepo.existsById(a.getId()))
            return "Student Already Exists";
        else{
            srepo.save(a);
            return "Saved Successfully";
        }
    }
    public String csadd(String a,String b,String c){
        if(srepo.existsById(a)){
            Students s = srepo.findById(a).get();
            Course cu = new Course();
           cu.setId(b);
           cu.setName(c);
           s.getCourses().add(cu);
           srepo.save(s);
           return "Course Added Successfully";
        }
        else
            return "Student Doesn't Exist ";
    }
    public List<Students> studentsList(){
        List<Students> sl = srepo.findAll();
        return sl;
    }
    public List<Course> coursesList(){
        List<Course> sl = crepo.findAll();
        return sl;
    }
    public List<Course> specificStuCourses(String sid){
        List<Course> cl = crepo.findAll();
        List<Course> scl = new ArrayList<>();
        for(Course c:cl){
            if(c.getStudents().contains(srepo.findById(sid).get()))
                scl.add(c);
        }
        return scl;
    }
    public List<Students> specificCouStudents(String cid){
        List<Students> sl = srepo.findAll();
        List<Students> scl = new ArrayList<>();
        for(Students s:sl){
            if(s.getCourses().contains(crepo.findById(cid).get()))
                scl.add(s);
        }
        return scl;
    }
    public int  courseUpdate(String a,String b){
        if(crepo.existsById(a)){
              Course c = crepo.findById(a).get();
              c.setName(b);
              crepo.save(c);
              return 1;
        }
        else
            return 0;
    }
    public int  studentNameUpdate(String a,String b){
        if(srepo.existsById(a)){
            Students c = srepo.findById(a).get();
            c.setName(b);
            srepo.save(c);
            return 1;
        }
        else
            return 0;
    }
    public List join(){
        List<Students> sl = srepo.findAll();
        return sl;
    }
   public String deleteStudent(String a){
        if(srepo.existsById(a)){
            Students s = srepo.findById(a).get();
            List<Course> sl = s.getCourses();
            sl.clear();
            s.setCourses(sl);
            srepo.delete(s);
            return "Deleted Successfully";
        }
        else
            return "Student Doesn't Exist";
   }
   public String deleteCourse(String courseId) {
        Optional<Course> optionalCourse = crepo.findById(courseId);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            List<Students> students = course.getStudents();

            // Clear the association between students and the course
            for (Students student : students) {
                student.getCourses().remove(course);
            }

            // Save the updated students
            srepo.saveAll(students);

            // Delete the course
            crepo.deleteById(courseId);

            return "Course and its associations deleted successfully";
        } else {
            return "Course not found";
        }
    }
public String delCouOfStu(String a,String b){
if(srepo.existsById(a)){
    Students s = srepo.findById(a).get();
    List<Course> cl = s.getCourses();
   List<Course> mcl =cl.stream().filter(i->!(i.getId().equals(b))).collect(Collectors.toList());
   s.setCourses(mcl);
   srepo.save(s);
   return "Deleted";
}
else
    return "Course Not Found";
}
}
