package com.dkarthick.student.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="student")
public class Student {

	private Integer id;
	@NotNull(message = "DOB is required")
	private Date dob;
	private Date joinDate;
	@NotNull(message = "Name is required")
	private String name;
	private String className;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "dob")
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	@Column(name = "join_date")
	public Date getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	@Column(name = "name")	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "class")
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Student [dob=" + dob + ", joinDate=" + joinDate + ", name=" + name + ", className=" + className + "]";
	}
	
	
}
