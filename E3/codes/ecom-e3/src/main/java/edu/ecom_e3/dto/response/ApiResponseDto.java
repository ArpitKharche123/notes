package edu.ecom_e3.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponseDto<T> {
	private int statusCode;
	private String message;
	private T data;
	private LocalDateTime timeStamp;
	
	public static <T> ApiResponseDto<T> success(
			int statusCode,
			String message,
			T data
			){	
		return ApiResponseDto.<T>
				builder()
				.statusCode(statusCode)
				.message(message)
				.data(data)
				.timeStamp(LocalDateTime.now()) 
				.build();
	}
}
