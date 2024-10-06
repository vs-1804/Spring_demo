package com.department.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
//@EntityListeners(value = AuditingEntityListener.class)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;

	private String title;
	
    private Integer count_Of_Employee;
	
	private Boolean isActive;
	
	private String dept_code;
	
	@Column(updatable = false)
	private  LocalDateTime cretaedAt;
	
	private  LocalDateTime updatedAt;
	
	@PrePersist
	protected void onCreate() {
		cretaedAt = LocalDateTime.now();
		updatedAt = null; // Explicitly setting to null on creation
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now(); // Only updated during updates
	}

}
