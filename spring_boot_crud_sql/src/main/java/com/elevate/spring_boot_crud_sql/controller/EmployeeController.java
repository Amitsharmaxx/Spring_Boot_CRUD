package com.elevate.spring_boot_crud_sql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elevate.spring_boot_crud_sql.Dao.EmployeeDao;
import com.elevate.spring_boot_crud_sql.Dto.EmployeeRequest;
import com.elevate.spring_boot_crud_sql.Entity.Employee;
import com.elevate.spring_boot_crud_sql.Mapper.EmployeeMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Employee API", description = "Operations related to Employee management")
public class EmployeeController {

	@Autowired
	private EmployeeDao employDao;

//---------------------------------------------------------------------------------------------------------------------
	@GetMapping(value = "/random")
	public int getRandom() {

		return (int) (Math.random() * 100);
	}

	@GetMapping(value = "/addition/{a}/{b}")
	public int getAddition(@PathVariable(name = "a") int a, @PathVariable(name = "b") int b) {
		return a + b;
	}

//-------------------------------------------------------------------------------------------------------------------------------
// save employ controller , here i can only send 1 object at a time because this method accepts ONE Employee object, not a list.
	// i am also validating this save method 
	@PostMapping("/save-employee")
	public ResponseEntity<Object> addEmployee(@RequestBody @Valid EmployeeRequest employeerequest) {
		
		
		Employee employee = EmployeeMapper.convertToEmployee(employeerequest);

		//System.out.println("Employee is : " + employee);

		return ResponseEntity.ok().body("Employee saved");

	}
	
	

//-------------------------------------------------------------------------------------------------------------------------------	
	// this method will get single employee object
	@GetMapping("/get-employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {

		return employDao.getEmployeeByIdDao(id);
	}

//-------------------------------------------------------------------------------------------------------------------------
	// update employee by id
	@PostMapping("/update-employee/{id}")
	public Employee updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {

		return employDao.UpdateEmployeeById(id, employee);
	}

//-------------------------------------------------------------------------------------------------------------------------
	// get all employee
	@GetMapping("/getAll-employee")
	@Operation(summary = "get All employee", description = "All the employees will be shown") // to show description on
																								// swagger ui
	public List<Employee> getAllEmployee() {
		return employDao.getAllEmployeeDao();
	}

//--------------------------------------------------------------------------------------------------------------------------

	// pagination
	@GetMapping(value = "/getEmployeeWithPageNumberDao/{pagenumber}")
	public Page<Employee> getEmployeeWithPageNumberDao(@PathVariable(name = "pagenumber") int pagenumber) {

		return employDao.getEmployeeWithPageNumberDao(pagenumber);
	}

//--------------------------------------------------------------------------------------------------------------	
	// sort by attribute
//	public List<Employee> sortEmployeeByAttributeDescController(@PathVariable(name = "attribute") String attribute) {
//		return employDao.sortEmployeeByAttributeDesc(attribute);
//
//	}
	
	
	
	
	

}
