package com.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.product.entities.Subject;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long>{

}
