package com.project.PPMTool.exception;

public class NotFoundException extends RuntimeException implements BaseException {
  public NotFoundException(String message) {
    super(message);
  }

  @Override
  public int getResponseCode() {
    return 404;
  }

  @Override
  public String getErrorMessage() {
    return getMessage();
  }
}
