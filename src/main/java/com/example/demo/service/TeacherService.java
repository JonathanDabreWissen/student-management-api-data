package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Teacher;
import com.example.demo.repos.TeacherDao;

@Service
public class TeacherService {
	@Autowired
	private TeacherDao dao;
	
	public Iterable<Teacher> getTeachers(){
		return dao.findAll();
	}
	
	public Optional<Teacher> getTeacherById(int std){
		return dao.findById(std);
	}
	
	public String insertTeachers(Teacher t) {
		if (dao.existsById(t.getStd())) {
			return "Sorry, the teacher already exists. Choose another Std.";
		}
		dao.save(t);
		return "Added new Teacher Successfully!";
	}
}
