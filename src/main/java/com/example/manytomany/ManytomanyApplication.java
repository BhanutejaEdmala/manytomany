package com.example.manytomany;

import com.example.manytomany.entities.Course;
import com.example.manytomany.entities.Students;
import com.example.manytomany.repositories.CouRepo;
import com.example.manytomany.repositories.StuRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Modifying;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ManytomanyApplication implements CommandLineRunner {
@Autowired
	StuRepo srepo;
@Autowired
	CouRepo crepo;
	public static void main(String[] args) {
		SpringApplication.run(ManytomanyApplication.class, args);
	}
@Modifying
@Transactional
	@Override
	public void run(String... args) throws Exception {
	// Create students
//		Students s1 = new Students();
//		s1.setId("1");
//		s1.setName("Virat");
//
//		Students s2 = new Students();
//		s2.setId("2");
//		s2.setName("Sachin");
//
//		// Create courses
//		Course c1 = new Course();
//		c1.setId("c1");
//		c1.setName("DSA");
////		Course ccrepo.findById("c1");
//
//		Course c2 = new Course();
//		c2.setId("c2");
//		c2.setName("Algorithms");
////		//c2.getStudents().add(s2);
////		 //Establishing relationships
//		s1.getCourses().add(c1);
//		s1.getCourses().add(c2);
//////       Course c2 = crepo.findById("c2").get();
//////	   c2.getStudents().add(srepo.findById("s2").get());
//////	   crepo.save(c2);
//		s2.getCourses().add(c1);
////////
////		// Saving students and courses
//		srepo.save(s1);
//		srepo.save(s2);
//Students s = srepo.findById("1").get();
//List<Course> c = s.getCourses();
//	for(Course sc:c){
//		if(sc.getId().equals("c1"))
//			sc.setName("aws");
//	}
//	Course f = crepo.findById("c1").get();
//	f.setName("aws");
//	//crepo.save(f);
//	srepo.save(s);
////		crepo.save(c1);
//	//crepo.save(c2);
//	Students s2 = srepo.findById("2").get();
//	srepo.delete(s2);
//	Course c2 = crepo.findById("c2").get();
//
//	// Add s2 to the students list of c2
//	c2.getStudents().add(s2);
//
//	// Ensure that c2 is also added to the courses list of s2 to maintain bidirectional relationship
//	s2.getCourses().add(c2);

	// Save changes to both entities
//	Students s = srepo.findById("45").get();
//	List<Course> a = s.getCourses();
//	for(Course c:a){
//		System.out.println(c);
//	}

}
}
