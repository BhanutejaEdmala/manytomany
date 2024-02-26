package com.example.manytomany.repositories;

import com.example.manytomany.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuRepo extends JpaRepository<Students,String> {
}
