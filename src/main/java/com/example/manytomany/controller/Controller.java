package com.example.manytomany.controller;

import com.example.manytomany.entities.Course;
import com.example.manytomany.entities.Students;
import com.example.manytomany.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    Service service;
    @RequestMapping("/sform")
    public String sform(){
        return "studentinput";
    }
   @RequestMapping("/sadd")
    public String stuadd(@ModelAttribute Students stu, ModelMap m){
        String r = service.stuAdd(stu);
        m.put("r",r);
        m.put("sid",stu.getId());
        return "res";
    }
    @RequestMapping("/caform")
    public String caform(@RequestParam String sid,ModelMap m) {
        m.put("sid",sid);
        return "addcourses";
    }
    @RequestMapping("/csadd")
    public String csadd(@RequestParam String id,@RequestParam String cid,@RequestParam String cname,ModelMap m){
       String s = service.csadd(id,cid,cname);
       m.put("r",s);
       m.put("sid",id);
        return "res";
    }
    @RequestMapping("slist")
    public String listS(ModelMap m){
        List<Students> sl = service.studentsList();
        m.put("sl",sl);
       return "slist";
    }
    @RequestMapping("/clist")
    public String listC(ModelMap m){
        List<Course> cl = service.coursesList();
        m.put("sl",cl);
        return "clist";
    }
    @RequestMapping("/ssc")
    public String ssc(@RequestParam String sid, ModelMap m){
        List<Course> cl = service.specificStuCourses(sid);
        m.put("sl",cl);
        m.put("sid",sid);
        return "ssc";
    }
    @RequestMapping("/cuform")
    public String cuform(@RequestParam String cid,ModelMap m){
        m.put("cid",cid);
        return "cuform";
    }
    @RequestMapping("/cuadd")
    public String cuadd(@RequestParam String cid,@RequestParam String cname,ModelMap m){
        int i=service.courseUpdate(cid,cname);
        if(i==0){
            m.put("r","No Course Found");
            return "res";
        }
        else {
            return "redirect:/clist";
        }
    }
    @RequestMapping("/vss")
    public String vss(@RequestParam String cid,ModelMap m){
        List<Students> sl = service.specificCouStudents(cid);
        m.put("sl",sl);
        return "vss";
    }
    @RequestMapping("/csn")
    public String csn(@RequestParam String sid,ModelMap m){
        m.put("sid",sid);
        return "scform";
    }
    @RequestMapping("/cstuname")
    public String name(@RequestParam String sid,@RequestParam String name,ModelMap m){
        int i=service.studentNameUpdate(sid,name);
        if(i==0){
            m.put("r","No Course Found");
            return "res";
        }
        else {
            return "redirect:/slist";
        }
    }
    @RequestMapping("/join")
    public String join(ModelMap m){
        List<Students> sl =service.join();
        m.put("s",sl);
        return "join";
    }
    @RequestMapping("/dstu")
    public String dStudent(@RequestParam String sid,ModelMap m){
        String s = service.deleteStudent(sid);
        return "redirect:/slist";
    }
    @RequestMapping("/cdel")
    public String dCourse(@RequestParam String cid,ModelMap m){
        String s = service.deleteCourse(cid);
        return "redirect:/clist";
    }
    @RequestMapping("/cdsm")
    public String dCourseOfStu(@RequestParam String cid, @RequestParam String sid, ModelMap m){
        String s = service.delCouOfStu(sid, cid);
        return "redirect:/ssc?sid=" + sid;
    }

}
