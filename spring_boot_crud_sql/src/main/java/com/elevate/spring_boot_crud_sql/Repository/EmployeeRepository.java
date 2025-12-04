package com.elevate.spring_boot_crud_sql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elevate.spring_boot_crud_sql.Entity.Employee;


public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
