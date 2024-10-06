package com.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entities.Professor;
import com.product.services.ProfessorService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {
	
	private  final ProfessorService   professorService;
	
	@PostMapping("/add")
	public  Professor save(@RequestBody Professor professor) {
		
		
		return professorService.save(professor);
	}
	
	@GetMapping
	public List<Professor> getAll(){
		
		return  professorService.getAll();
	}
	

}
