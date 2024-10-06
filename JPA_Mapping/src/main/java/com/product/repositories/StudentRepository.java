package com.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entities.Student;

public interface StudentRepository  extends JpaRepository<Student, Long>{

}
