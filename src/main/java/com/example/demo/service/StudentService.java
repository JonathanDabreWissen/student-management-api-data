package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.entities.Teacher;
import com.example.demo.repos.StudentDao;

@Service
public class StudentService {
    @Autowired
    private StudentDao dao;
    
    @Autowired
    private TeacherService teacherService;
    
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


    public List<Student> getStudentsBySchool(String schoolName) {
        return dao.findBySchool(schoolName);
    }

    public List<Student> getStudentsByResult(boolean pass) {
        return pass ? dao.findPassingStudents() : dao.findFailingStudents();
    }

    public long getStudentCountByStandard(int standard) {
        return dao.countByStandard(standard);
    }

    public long getTotalStrengthBySchool(String schoolName) {
        return dao.countBySchool(schoolName);
    }

    public List<Student> getTopFiveStudents() {
        return dao.findTopFiveStudents();
    }

    public Optional<Student> getTopperByStandard(int standard) {
        return dao.findTopperByStandard(standard);
    }
    
    public Optional<Teacher> getClassTeacher(int rollNo) {
        Optional<Student> studentOpt = dao.findById(rollNo);
        if (studentOpt.isPresent()) {
            int standard = studentOpt.get().getStandard();
            return teacherService.getTeacherById(standard);
        }
        return Optional.empty();
    }

}
