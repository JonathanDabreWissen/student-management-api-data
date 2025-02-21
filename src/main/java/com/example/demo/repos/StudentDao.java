package com.example.demo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
    
    // 1. Get students by school name
    @Query("SELECT s FROM Student s WHERE s.school = :schoolName")
    List<Student> findBySchool(@Param("schoolName") String schoolName);
    
    // 2. Get students based on pass/fail criteria
    @Query("SELECT s FROM Student s WHERE s.percentage >= 40")
    List<Student> findPassingStudents();
    
    @Query("SELECT s FROM Student s WHERE s.percentage < 40")
    List<Student> findFailingStudents();

    // 3. Get count of students in a specific standard
    @Query("SELECT COUNT(s) FROM Student s WHERE s.standard = :standard")
    long countByStandard(@Param("standard") int standard);

    // 4. Get total strength of a school
    @Query("SELECT COUNT(s) FROM Student s WHERE s.school = :schoolName")
    long countBySchool(@Param("schoolName") String schoolName);

    // 5. Get top 5 students by percentage
    @Query("SELECT s FROM Student s ORDER BY s.percentage DESC LIMIT 5")
    List<Student> findTopFiveStudents();

    // 6. Get topper of a specific standard
    @Query("SELECT s FROM Student s WHERE s.standard = :standard ORDER BY s.percentage DESC LIMIT 1")
    Optional<Student> findTopperByStandard(@Param("standard") int standard);
}
