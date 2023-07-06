package com.example.apigateway.feign;

import org.springframework.http.HttpStatus;

public class RestException extends RuntimeException {
  private HttpStatus status;
  private Object data;

  public RestException(Object data, HttpStatus status) {
    super();
    this.status = status;
    this.data = data;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }


  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "RestException{" +
        "status=" + status +
        ", data=" + data +
        '}';
  }
}
