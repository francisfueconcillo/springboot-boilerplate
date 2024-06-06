package com.apifirstsolutions.store.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Map<String, Object>> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
    Map<String, Object> errorContent = new HashMap<>();

    errorContent.put("code", HttpStatus.BAD_REQUEST.value());
    errorContent.put("message", e.getMessage());
    return new ResponseEntity<>(errorContent, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    Map<String, Object> errorContent = new HashMap<>();
    Map<String, Object> validationErrors = new HashMap<>();

    e.getBindingResult().getAllErrors().forEach((error -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      validationErrors.put(fieldName, errorMessage);
    }));

    errorContent.put("code", HttpStatus.BAD_REQUEST.value());
    errorContent.put("message", "ValidationError");
    errorContent.put("errors", validationErrors);
    return new ResponseEntity<>(errorContent, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<Map<String, Object>> handleDataIntegrityViolationException(
      MethodArgumentTypeMismatchException e) {
    Map<String, Object> errorContent = new HashMap<>();

    errorContent.put("code", HttpStatus.BAD_REQUEST.value());
    errorContent.put("message", e.getMessage());
    return new ResponseEntity<>(errorContent, HttpStatus.BAD_REQUEST);
  }

}
