package com.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entities.Subject;
import com.product.services.SubjectServices;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {
	
	private final SubjectServices subjectServices;
	
	@PostMapping("/add")
	public Subject post(@RequestBody Subject subject) {
		
		return subjectServices.save(subject);
	}
	
	@GetMapping
    public List<Subject> getAll(){
		
	    return	subjectServices.getAll();
	}
	
	@PutMapping("{subId}/professor/{profId}")
	public Subject assignProfToSub(@PathVariable Long subId, @PathVariable Long profId) {
		return subjectServices.assignSubjectToProfessor(subId, profId);
		
	}
}
