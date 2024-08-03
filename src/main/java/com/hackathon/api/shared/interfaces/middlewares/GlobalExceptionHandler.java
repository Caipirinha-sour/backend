package com.hackathon.api.shared.interfaces.middlewares;

import com.hackathon.api.shared.application.exceptions.ConflictException;
import com.hackathon.api.shared.application.exceptions.NotFoundException;
import com.hackathon.api.shared.application.exceptions.ValidationException;
import com.hackathon.api.shared.domain.models.error_response.ArgumentErrorResponse;
import com.hackathon.api.shared.domain.models.error_response.CodeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<Object> CreateResponseEntity(HttpStatus status, Exception exception) {
        return ResponseEntity
                .status(status)
                .body(
                        new CodeErrorResponse(status.value(), exception.getMessage())
                );
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException exception) {
        var status = HttpStatus.NOT_FOUND;
        return CreateResponseEntity(status, exception);
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<Object> handleValidationException(ValidationException exception) {
        var status = HttpStatus.BAD_REQUEST;
        return CreateResponseEntity(status, exception);
    }

    @ExceptionHandler({ConflictException.class})
    public ResponseEntity<Object> handleConflictException(ConflictException exception) {
        var status = HttpStatus.CONFLICT;
        return CreateResponseEntity(status, exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentException(MethodArgumentNotValidException exception) {
        var status = HttpStatus.BAD_REQUEST;

        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(status)
                .body(new ArgumentErrorResponse(status.value(), "There were some mistakes", errorMap));

    }
}
