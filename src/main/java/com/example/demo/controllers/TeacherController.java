package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Teacher;
import com.example.demo.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@GetMapping
	public Iterable<Teacher> getTeachers(){
		return service.getTeachers();
	}
	
	@GetMapping("/{std}")
    public Optional<Teacher> getStudentById(@PathVariable int std) {
        return service.getTeacherById(std);
    }
	
	@PostMapping
    public String insertStudents(@RequestBody Teacher t) {
        return service.insertTeachers(t);
    }
	
	
}
