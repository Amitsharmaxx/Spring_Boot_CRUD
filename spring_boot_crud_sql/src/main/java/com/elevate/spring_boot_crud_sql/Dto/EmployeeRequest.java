package com.elevate.spring_boot_crud_sql.Dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

	
	private int id;
	
	@NotEmpty(message = "Name must not be empty ..")
	private String name;
	
	@NotEmpty(message = "Email must be not empty")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotEmpty(message = "Department must not be empty.")
	private String department;
	
	 @Min(value = 21000, message = "Salary must be at least 21000")
	 @Max(value = 45000, message = "Salary must be less than or equal to 45000")
	private double salary;
	
	@PastOrPresent(message = "Joining date must be in past or present .")
	private LocalDate joiningDate;
	
	
	
}
