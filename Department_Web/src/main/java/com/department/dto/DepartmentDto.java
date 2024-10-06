package com.department.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

   
	private Long deptId;
	
    @NotBlank(message = "please enter title")
	private String title;
	
    @AssertFalse(message = "isActive must be false")
	private Boolean isActive;
	
	private LocalDateTime cretaedAt;
	
	@Positive(message = "Number Of Employees greater than 0")
	private Integer count_of_employee;
	
	@Pattern(regexp = "^[A-Z]{2}[@][1-9]{3}$")
	private String dept_code;
}

