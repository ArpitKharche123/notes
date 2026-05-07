package edu.ecom_e3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	//Exception Handler Methods
	
	//This method will be executed automatically
	//when the specified exception occurs
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleNotFound(NotFoundException ex,
			HttpServletRequest req){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(
						ErrorResponseDto.failure(
								HttpStatus.NOT_FOUND.value(),
								"NOT_FOUND",
								ex.getMessage(),
								req) 
						);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleGeneralException(Exception ex,
			HttpServletRequest req){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(
						ErrorResponseDto.failure(
								500,
								"INTERNAL_SERVER_ERROR",
								ex.getMessage(),
								req)
						);
	}
}
