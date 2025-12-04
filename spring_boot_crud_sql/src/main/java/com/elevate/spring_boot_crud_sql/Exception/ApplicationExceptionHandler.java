package com.elevate.spring_boot_crud_sql.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

	//this is custom exception , that's why i created a extra class for it MethodArgumentNotValidException
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {

		exception.printStackTrace();

		return ResponseEntity.badRequest().body(exception.getMessage());

	}

//=======================================================================================================================
	//When you send invalid data to a controller endpoint, Spring throws:
	//Your method catches that exception and returns a custom response with all validation errors.
	// "name": "Name must not be empty ..",
//    "joiningDate": "Joining date must be in past or present .",
//    "department": "Department must not be empty.",
//    "email": "Email should be valid"
//
	
	//this is already present in spring boot
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(
			MethodArgumentNotValidException ex) {

		Map<String, String> map = new HashMap<String, String>();

		BindingResult bindingResult = ex.getBindingResult();

		List<ObjectError> errors = bindingResult.getAllErrors();

		for (ObjectError objectError : errors) {

			FieldError fieldError = (FieldError) objectError;

			String fieldName = fieldError.getField();
			String message = fieldError.getDefaultMessage();

			map.put(fieldName, message);

		}

		return ResponseEntity.badRequest().body(map);
	}

}
