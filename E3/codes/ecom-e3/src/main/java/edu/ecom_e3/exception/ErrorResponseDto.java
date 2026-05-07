package edu.ecom_e3.exception;

import java.time.LocalDateTime;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponseDto {
	
	private int statusCode;
	private String error;
	private String message;
	private String path;
	private LocalDateTime timeStamp;
	
	public static ErrorResponseDto failure(
			int statusCode, String error,String message,
			HttpServletRequest req
			) {
		return ErrorResponseDto.builder()
				.statusCode(statusCode)
				.error(error)
				.message(message)
				.path(req.getRequestURI())
				.timeStamp(LocalDateTime.now())
				.build();
	}
}
