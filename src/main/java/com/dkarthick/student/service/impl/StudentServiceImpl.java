package com.dkarthick.student.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkarthick.student.entity.Student;
import com.dkarthick.student.repository.StudentRepository;
import com.dkarthick.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudentData(Student student) {
		return studentRepository.saveAndFlush(student);
	}

	@Override
	public void deleteStudentData(Integer studentId) {
		studentRepository.deleteById(studentId);
		studentRepository.flush();
		LOGGER.info("student deleted successfully!");
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
	
	@Override
	public Student findStudent(Integer id) {
		Student student = studentRepository.findById(id).get();
		return student;
	}

	@Override
	public Student updateStudentData(Student studentToUpdate, Integer id) {
		LOGGER.info("Update student data...");
		Student student = studentRepository.findById(id).orElse(null);
		Student updatedStudent;
		if(student != null) {
			LOGGER.info("student data found");
			student.setName(studentToUpdate.getName());
			student.setDob(studentToUpdate.getDob());
			student.setJoinDate(studentToUpdate.getJoinDate());
			student.setClassName(studentToUpdate.getClassName());
			
			updatedStudent = studentRepository.save(student);
		} else {
			LOGGER.info("student data not found! save as new student!");
			updatedStudent = studentRepository.save(studentToUpdate);
		}
		
		studentRepository.flush();
		return updatedStudent;
	}
	
	@Override
	public List<Student> findByStudents(String key, String value) {
		LOGGER.info("search student by " + key + " = " + value);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyy-MM-dd");
		List<Student> students = null;
		try {
			if (key.equals("name")) {
				students = studentRepository.findByName(value);
			} else if (key.equals("joinDate")) {
				Date joinDate = formatter.parse(value);
				students = studentRepository.findByJoinDate(joinDate);
			} else if (key.equals("dob")) {
				Date dob = formatter.parse(value);
				students = studentRepository.findByDob(dob);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		LOGGER.info("students: " + students);
		return students;
	}
}
