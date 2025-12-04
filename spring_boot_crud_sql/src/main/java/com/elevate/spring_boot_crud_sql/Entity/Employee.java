package com.elevate.spring_boot_crud_sql.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	private int id;
	private String name;
	private String email;
	private String department;
	private double salary;
	private LocalDate joiningDate;

}
	