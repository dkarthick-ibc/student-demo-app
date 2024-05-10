package com.dkarthick.student.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dkarthick.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByName(String name);
	
	List<Student> findByJoinDate(Date joinDate);
	
	List<Student> findByDob(Date dob);
	
	List<Student> findByClassName(String className);
}
