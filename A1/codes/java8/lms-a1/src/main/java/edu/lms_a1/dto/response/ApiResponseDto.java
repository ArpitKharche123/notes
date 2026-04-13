package edu.lms_a1.dto.response;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponseDto<T> {
	private int status;
	private String message;
	private T data;
	
	public static <T> ApiResponseDto<T> success(
			T data,String message){
		
		return ApiResponseDto.<T>builder()
				.status(HttpStatus.OK.value())
				.message(message)
				.data(data)
				.build();
	} 
	
	public static <T> ApiResponseDto<T> created(
			T data,String message){
		
		return ApiResponseDto.<T>builder()
				.status(HttpStatus.CREATED.value())
				.message(message)
				.data(data)
				.build(); 
	} 
}
