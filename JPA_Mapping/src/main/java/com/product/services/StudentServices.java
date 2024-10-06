package com.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.entities.Professor;
import com.product.entities.Student;
import com.product.entities.Subject;
import com.product.repositories.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServices {
	
	private final StudentRepository  studentRepository;
	private final SubjectServices subjectServices;
	private final ProfessorService professorService;
	
	public Student save(Student student) {
		 return studentRepository.save(student);
		 
	}

	public List<Student> getAll() {
		
		return studentRepository.findAll();
	}
	public Student getById(Long id) {
		
		return studentRepository.findById(id).orElse(null);
	}
	
	public Student assignSubject(Long studId , Long subId) {
		Optional<Subject> subject=subjectServices.getById(subId);
		Optional<Student> student= studentRepository.findById(studId);
		
		return subject.flatMap(sub->
		student.map(stud->{
		 	stud.getSubjects().add(sub);
		 	return studentRepository.save(stud);
		})).orElse(null);
		
	}
	
	public Student assignProfessor(Long studId , Long profId) {
		Optional<Professor> professor=professorService.getById(profId);
		Optional<Student> student= studentRepository.findById(studId);
		
		return professor.flatMap(prof->
		student.map(stud->{
		 	stud.getProfessor().add(prof);
		 	return studentRepository.save(stud);
		})).orElse(null);
		
	}
  
}
