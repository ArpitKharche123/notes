package edu.lms_a1.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponseDto {
	private int statusCode;
	private String message;
	private String error;
	private String path;
	private LocalDateTime timeStamp;
}
