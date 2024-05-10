package com.dkarthick.student.service;

import java.util.List;

import com.dkarthick.student.entity.Student;

public interface StudentService {

	public Student saveStudentData(Student student);
	
	public void deleteStudentData(Integer studentId);
	
	public List<Student> getAllStudents();
	
	public Student updateStudentData(Student studentToUpdate, Integer id); 
	
	public Student findStudent(Integer id);
	
	public List<Student> findByStudents(String key, String value);
}
