package com.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entities.AdmissionRecord;

@Repository
public interface AdmissionRecordRepostories extends JpaRepository<AdmissionRecord, Long> {

}
