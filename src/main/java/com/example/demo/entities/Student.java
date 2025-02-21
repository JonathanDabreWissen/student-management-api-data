package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUD")
public class Student {
	@Id
	private int rollNo;
	
	private String name;
	private int standard;
	private String school;
	private float percentage;
	
	// Default constructor (required by JPA)
    public Student() {}

	public Student(int rollNo, String name, int standard, String school, float percentage) {
		this.rollNo = rollNo;
		this.name = name;
		this.standard = standard;
		this.school = school;
		this.percentage = percentage;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public int getStandard() {
		return standard;
	}

	public String getSchool() {
		return school;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
}
