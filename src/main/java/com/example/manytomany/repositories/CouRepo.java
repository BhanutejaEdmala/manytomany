package com.example.manytomany.repositories;

import com.example.manytomany.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouRepo extends JpaRepository<Course,String> {

}
