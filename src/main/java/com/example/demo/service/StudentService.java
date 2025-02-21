package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Student;
import com.example.demo.repos.StudentDao;

@Service
public class StudentService {
	@Autowired
	StudentDao dao;

	public Iterable<Student> getStudents() {
		return dao.findAll();
	}

	public Optional<Student> getStudentById(int rollNo) {
		return dao.findById(rollNo);
	}

	public String insertStudents(Student s) {
		if (dao.existsById(s.getRollNo())) {
			return "Sorry, the Student already exists. Choose another Roll No.";
		}
		dao.save(s);
		return "Added new Student Successfully!";
	}

	public String updateStudent(Student s, int rollNo) {
		if (!dao.existsById(rollNo)) {
			return "Sorry, the Student does not exist. Choose another ID to update.";
		}
		dao.save(s);
		return "Updated record successfully.";
	}

	public String deleteStudent(int rollNo) {
		if (!dao.existsById(rollNo)) {
			return "Sorry, the Student does not exist. Choose another ID to delete.";
		}
		dao.deleteById(rollNo);
		return "Successfully deleted Student record!";
	}

	// Get students by school name
	public List<Student> getStudentsBySchool(String schoolName) {
		return ((List<Student>) dao.findAll()).stream()
				.filter(student -> student.getSchool().equalsIgnoreCase(schoolName))
				.collect(Collectors.toList());
	}

	// Get students based on pass/fail criteria
	public List<Student> getStudentsByResult(boolean pass) {
		return ((List<Student>) dao.findAll()).stream()
				.filter(student -> (pass ? student.getPercentage() >= 40 : student.getPercentage() < 40))
				.collect(Collectors.toList());
	}

	// Get count of students in a specific standard
	public long getStudentCountByStandard(int standard) {
		return ((List<Student>) dao.findAll()).stream()
				.filter(student -> student.getStandard() == standard)
				.count();
	}

	// Get total strength of a school
	public long getTotalStrengthBySchool(String schoolName) {
		return getStudentsBySchool(schoolName).size();
	}

	// Get top 5 students by percentage
	public List<Student> getTopFiveStudents() {
		return ((List<Student>) dao.findAll()).stream()
				.sorted((s1, s2) -> Float.compare(s2.getPercentage(), s1.getPercentage()))
				.limit(5)
				.collect(Collectors.toList());
	}

	// Get topper of a specific standard
	public Optional<Student> getTopperByStandard(int standard) {
		return ((List<Student>) dao.findAll()).stream()
				.filter(student -> student.getStandard() == standard)
				.max((s1, s2) -> Float.compare(s1.getPercentage(), s2.getPercentage()));
	}
}
