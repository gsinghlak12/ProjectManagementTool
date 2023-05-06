package com.project.PPMTool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ResponseEntityExceptionHandler {
  @ExceptionHandler(RuntimeException.class)
  public final ResponseEntity<Object> handleProjectIdException(
      BaseException ex) {
    if (ex.getResponseCode() == 400) {
      return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.BAD_REQUEST);
    } else if (ex.getResponseCode() == 404) {
      return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
