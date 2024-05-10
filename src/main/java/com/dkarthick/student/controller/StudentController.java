package com.dkarthick.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dkarthick.student.entity.Student;
import com.dkarthick.student.service.StudentService;

@RestController
@RequestMapping("api/")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("home")
	public ResponseEntity<?> home() {
		return new ResponseEntity<String>("Welcome to student application!!", HttpStatus.OK);
	}
	
	@GetMapping("student/all")
	public ResponseEntity<?> getAllStudentsData() {
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@GetMapping("student/find")
	public ResponseEntity<?> getStudentData(@RequestParam Integer id) {
		Student students = studentService.findStudent(id);
		return new ResponseEntity<Student>(students, HttpStatus.OK);
	}

	@PostMapping("student/create")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student) {
		Student newStudent = studentService.saveStudentData(student);
		return new ResponseEntity<Student>(newStudent, HttpStatus.CREATED);
	}
	
	@PutMapping("student/update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
		Student updatedStudent = studentService.updateStudentData(student, id);
		return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
	}
	
	@DeleteMapping("student/delete/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("id") Integer id) {
		studentService.deleteStudentData(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping("student/findBy")
	public ResponseEntity<?> findStudentData(@RequestParam String key, @RequestParam String value) {
		List<Student> students = studentService.findByStudents(key, value);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
}
