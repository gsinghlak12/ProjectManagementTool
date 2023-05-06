package com.project.PPMTool.exception;

public interface BaseException {
  int getResponseCode();

  String getErrorMessage();
}
