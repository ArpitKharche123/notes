package edu.learningspringboot.exception;

import java.time.Instant;

public record ErrorResponse(
        boolean success,
        String errorCode,
        String message,
        Instant timestamp,
        String path
) {
    public static ErrorResponse error(
            String errorCode,
            String message,
            String path
    ){
        return new ErrorResponse(
              false,
              errorCode,
              message,
              Instant.now(),
              path
        );
    }

}
