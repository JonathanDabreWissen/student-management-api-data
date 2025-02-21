package com.example.demo.repos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {
    
   
}
