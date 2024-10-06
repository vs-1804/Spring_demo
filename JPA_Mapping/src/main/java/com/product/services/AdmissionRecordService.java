package com.product.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.entities.AdmissionRecord;
import com.product.entities.Student;
import com.product.repositories.AdmissionRecordRepostories;
import com.product.repositories.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdmissionRecordService {
	
	private final AdmissionRecordRepostories admissionRecordRepostories;
	private final StudentRepository studentRepository;
	
	public AdmissionRecord save(AdmissionRecord admissionRecord) {
		
		return admissionRecordRepostories.save(admissionRecord);
	}
	
	public AdmissionRecord assignFeeToStudent(Long feeId,Long studentId) {
		Optional<Student> student =studentRepository.findById(studentId);
		Optional<AdmissionRecord> admRec=admissionRecordRepostories.findById(feeId);
		
		return student.flatMap(stud->
		admRec.map(adm->{
			adm.setStudent(stud);
			return admissionRecordRepostories.save(adm);
		})).orElse(null);
		
		
	}

}
