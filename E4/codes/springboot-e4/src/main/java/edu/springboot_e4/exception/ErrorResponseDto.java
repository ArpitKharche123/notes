package edu.springboot_e4.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {
	private int status;
	private String error;
	private String message;
	private String path;
	private LocalDateTime timeStamp;
	
	public static ErrorResponseDto buildErrorDto(
			int status,String error,String message,String path) {
		return ErrorResponseDto.builder()
				.status(status)
				.error(error)
				.message(message)
				.path(path)
				.timeStamp(LocalDateTime.now())
				.build();
	} 
}
