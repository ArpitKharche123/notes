package edu.springboot_e4.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerNotFoundException(
			CustomerNotFoundException ex,HttpServletRequest req){
		
		ErrorResponseDto errorDto = ErrorResponseDto.buildErrorDto
		(404,
		"NOT_FOUND",
		ex.getMessage() ,
		req.getRequestURI());
		
		return ResponseEntity.status(404).body(errorDto);
		
	}
}
