package com.example.demo.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Student;

public interface  StudentDao extends JpaRepository<Student, Integer> {
	/*
	public List<Student> getByDesignation(String desig);
	public List<Student> findByAgeGreaterThan(int age);
	public List<Student> findByAgeLessThan(int age);
	@Query("from Employee where designation=?1 order by age desc")
	public List<Student> myCustomQuery(String desig);
	
	@Query("from Employee where designation=?1")
	public List<Student> getEmployeeByDesignation(String desig);
	*/
}
