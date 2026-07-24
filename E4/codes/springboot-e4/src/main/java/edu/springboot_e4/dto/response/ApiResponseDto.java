package edu.springboot_e4.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponseDto<T> {
	private String message;
	private int statusCode;
	private T data;
	
	public static<T> ApiResponseDto<T> buildDto
	(String message,int code,T data){
		return ApiResponseDto.<T>builder()
				.message(message)
				.statusCode(code)
				.data(data)
				.build();
	}
}
