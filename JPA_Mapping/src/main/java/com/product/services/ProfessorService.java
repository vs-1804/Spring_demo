package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.entities.Professor;
import com.product.repositories.ProfessorRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorService {
	
	private final ProfessorRespository professorRespository;
	
	public Professor save(Professor professor) {
		
		return professorRespository.save(professor);
	}
	
	public Optional<Professor> getById(Long profId){
		
		return professorRespository.findById(profId);
	}

	public List<Professor> getAll() {
		
		return professorRespository.findAll();
	}

}
