package com.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entities.Student;
import com.product.services.StudentServices;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
	
	private final StudentServices  studentServices;

	@PostMapping("/add")
	public Student save(@RequestBody Student student) {
		
	return	studentServices.save(student);
	
	}
	@GetMapping
	public List<Student> getAll() {
		
	return	studentServices.getAll();
	
	}
	@PutMapping("{studId}/subject/{subId}")
	public Student assignSubject(@PathVariable Long studId, @PathVariable Long subId) {
		
		 return studentServices.assignSubject(studId, subId);
	}
	@PutMapping("{studId}/professor/{profId}")
	public Student assignProfessor(@PathVariable Long studId, @PathVariable Long profId) {
		
		 return studentServices.assignProfessor(studId, profId);
	}
	
}
