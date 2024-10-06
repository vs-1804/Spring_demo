package com.product.controller;

import org.springframework.web.bind.annotation.RestController;

import com.product.entities.AdmissionRecord;
import com.product.services.AdmissionRecordService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("record")
public class AdmissionRecordController {

	private final AdmissionRecordService  admissionRecordService;
	
	@PostMapping("/add")
	public AdmissionRecord AdmissionRecord (@RequestBody AdmissionRecord admissionRecord) {
		
		return  admissionRecordService.save(admissionRecord);
	}
	
	@PostMapping("{feeId}/student/{studentId}")
	public AdmissionRecord assignStudentToFee(@PathVariable Long feeId, @PathVariable Long studentId) {
		
		return  admissionRecordService.assignFeeToStudent(feeId, studentId);
	}
	 
	
}
