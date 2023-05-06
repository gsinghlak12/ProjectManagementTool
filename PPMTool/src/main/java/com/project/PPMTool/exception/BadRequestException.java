package com.project.PPMTool.exception;

public class BadRequestException extends RuntimeException implements BaseException {
  public BadRequestException(String message) {
    super(message);
  }

  @Override
  public int getResponseCode() {
    return 400;
  }

  @Override
  public String getErrorMessage() {
    return getMessage();
  }
}
