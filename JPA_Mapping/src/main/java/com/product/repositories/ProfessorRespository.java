package com.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entities.Professor;

@Repository
public interface ProfessorRespository extends  JpaRepository<Professor, Long> {

}
