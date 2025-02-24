package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.entities.Teacher;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public Iterable<Student> getStudents() {
        return service.getStudents();
    }

    @GetMapping("/{rollNo}")
    public Optional<Student> getStudentById(@PathVariable int rollNo) {
        return service.getStudentById(rollNo);
    }

    @PostMapping
    public String insertStudents(@RequestBody Student s) {
        return service.insertStudents(s);
    }

    @PutMapping("/{rollNo}")
    public String updateStudent(@RequestBody Student s, @PathVariable int rollNo) {
        return service.updateStudent(s, rollNo);
    }

    @DeleteMapping("/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo) {
        return service.deleteStudent(rollNo);
    }

    // Get all students from a specific school
    @GetMapping("/school/{name}")
    public List<Student> getStudentsBySchool(@PathVariable String name) {
        return service.getStudentsBySchool(name);
    }

    // Get all students who passed or failed
    @GetMapping("/result/{pass}")
    public List<Student> getStudentsByResult(@PathVariable boolean pass) {
        return service.getStudentsByResult(pass);
    }

    // Get count of students in a specific standard
    @GetMapping("/standard/{standard}/count")
    public long getStudentCountByStandard(@PathVariable int standard) {
        return service.getStudentCountByStandard(standard);
    }

    // Get total strength of a school
    @GetMapping("/school/{name}/strength")
    public long getTotalStrengthBySchool(@PathVariable String name) {
        return service.getTotalStrengthBySchool(name);
    }

    // Get top 5 students by percentage
    @GetMapping("/top5")
    public List<Student> getTopFiveStudents() {
        return service.getTopFiveStudents();
    }

    // Get topper of a specific standard
    @GetMapping("/standard/{standard}/topper")
    public Optional<Student> getTopperByStandard(@PathVariable int standard) {
        return service.getTopperByStandard(standard);
    }
    
    @GetMapping("/{rollNo}/class_teacher")
    public Optional<Teacher> getClassTeacher(@PathVariable int rollNo) {
        return service.getClassTeacher(rollNo);
    }
    
}
