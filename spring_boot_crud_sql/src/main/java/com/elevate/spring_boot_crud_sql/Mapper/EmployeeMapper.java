package com.elevate.spring_boot_crud_sql.Mapper;

import com.elevate.spring_boot_crud_sql.Dto.EmployeeRequest;
import com.elevate.spring_boot_crud_sql.Entity.Employee;

public class EmployeeMapper {

	public static Employee convertToEmployee(EmployeeRequest employeeRequest) {

		Employee employee = new Employee();

		employee.setId(employeeRequest.getId());
		employee.setName(employeeRequest.getName());
		employee.setEmail(employeeRequest.getEmail());
		employee.setDepartment(employeeRequest.getDepartment());
		employee.setSalary(employeeRequest.getSalary());
		employee.setJoiningDate(employeeRequest.getJoiningDate());
		
		return employee;

	}

}
