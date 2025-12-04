package com.elevate.spring_boot_crud_sql.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Repository;

import com.elevate.spring_boot_crud_sql.Entity.Employee;
import com.elevate.spring_boot_crud_sql.Exception.EmployeeNotFoundException;
import com.elevate.spring_boot_crud_sql.Repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employrepository;

//-------------------------------------------------------------------------------------------------------------------------	
	// save employee
	public Employee saveEmployeeDao(Employee employee) {

		return employrepository.saveAndFlush(employee);
	}

//-------------------------------------------------------------------------------------------------------------------------	
	// get id
	public Employee getEmployeeByIdDao(int id) {

//		Optional<Employee> optional = employrepository.findById(id);
//
//		if (optional.isPresent()) {
//			return optional.get();
//		}
//		return null;
		
		return employrepository.findById(id)
				.orElseThrow( ()-> new EmployeeNotFoundException("Employee not Found with id - "+id));

	}

//-------------------------------------------------------------------------------------------------------------------------
	// update
	public Employee UpdateEmployeeById(int id, Employee updateEmployee) {

		Optional<Employee> optional = employrepository.findById(id);

		if (optional.isPresent()) {

			Employee existing = optional.get();

			existing.setDepartment(updateEmployee.getDepartment());
			existing.setEmail(updateEmployee.getEmail());
			existing.setJoiningDate(updateEmployee.getJoiningDate());
			existing.setName(updateEmployee.getName());
			existing.setSalary(updateEmployee.getSalary());

			return employrepository.save(existing);

		}
		return null;
	}

//-------------------------------------------------------------------------------------------------------------------------
	// fetch all data
	public List<Employee> getAllEmployeeDao(){	
		
		return employrepository.findAll();
		
	}
	
	
	
//---------------------------------------------------------------------------------------------------------------------------
	// public List<Employee> get

	
	
	
//--------------------------------------------------------------------------------------------------------------------------
	//pagination
	
	public Page<Employee> getEmployeeWithPageNumberDao(int pagenumber){
		
		return employrepository.findAll(PageRequest.of(pagenumber, 2));
	}
	
		

//------------------------------------------------------------------------------------------------------------------------
	//sort by salary
	public List<Employee> sortEmployeeByAttributeDescDao(String attribute){
		return employrepository.findAll(Sort.by(Order.desc(attribute)));
	}

	
//=========================================================================================================================
	
	
	
	
}