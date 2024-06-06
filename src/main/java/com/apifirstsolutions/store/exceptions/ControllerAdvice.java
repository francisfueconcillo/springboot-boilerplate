package com.apifirstsolutions.store.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Map<String, Object>> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
    Map<String, Object> errorContent = new HashMap<>();
    errorContent.put("code", HttpStatus.BAD_REQUEST.value());
    errorContent.put("message", e.getMessage());
    return new ResponseEntity<>(errorContent, HttpStatus.BAD_REQUEST);
  }

}
