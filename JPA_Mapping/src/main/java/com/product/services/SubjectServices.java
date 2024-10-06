package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.entities.Professor;
import com.product.entities.Subject;
import com.product.repositories.SubjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectServices {
	
	private final SubjectRepository subjectRepository;
	
	private final ProfessorService professorService;
	
	public Subject save(@RequestBody Subject subject) {
		
		return subjectRepository.save(subject);
	}

	public List<Subject> getAll() {
	
		return subjectRepository.findAll();
		
	}
	public Optional<Subject> getById(Long subId) {
		
		return subjectRepository.findById(subId);
		
	}
	
	public Subject assignSubjectToProfessor(Long subId, Long ProfId) {
		Optional<Subject> subject= subjectRepository.findById(subId);
		Optional<Professor> professor= professorService.getById(ProfId);
		
		return subject.flatMap(sub->
		 professor.map( prof->{
			 sub.setProfessor(prof);
			 return subjectRepository.save(sub);
		 })).orElse(null);
		
	}

}
