// package com.example.app.controller.handlers;

// import java.net.http.HttpHeaders;
// import java.util.Map;
// import java.util.TreeMap;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.FieldError;
// import org.springframework.validation.ObjectError;
// import org.springframework.web.HttpRequestMethodNotSupportedException;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.RestControllerAdvice;
// import org.springframework.web.context.request.WebRequest;
// import
// org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// import com.example.app.builders.ErrorResponse;

// @RestControllerAdvice
// public class GlobalHandlerExceptions extends ResponseEntityExceptionHandler {

// @Override
// protected ResponseEntity<Object>
// handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
// HttpHeaders headers, HttpStatusCode status, WebRequest request) {
// Map<String, String> errors = new TreeMap<>();
// for (FieldError error : ex.getBindingResult().getFieldErrors()) {
// errors.put(error.getField(), error.getDefaultMessage());
// }
// for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
// errors.put(error.getObjectName(), error.getDefaultMessage());
// }

// ErrorResponse errorResponse = new ErrorResponse();
// errorResponse.setErrors(errors);
// errorResponse.setRuta(request.getDescription(false).substring(4));
// return handleExceptionInternal(ex, errorResponse, null,
// HttpStatus.BAD_REQUEST, request);
// }

// @Override
// protected ResponseEntity<Object>
// handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException
// ex,
// HttpHeaders headers, HttpStatus status, WebRequest request) {

// Map<String, String> errors = new TreeMap<>();

// StringBuilder builder = new StringBuilder();
// builder.append("El método ");
// builder.append(ex.getMethod());
// builder.append(" no está soportado para esta petición. Los métodos soportados
// son ");

// ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

// errors.put("Error", builder.toString());
// ErrorResponse errorResponse = new ErrorResponse();
// errorResponse.setErrors(errors);
// errorResponse.setRuta(request.getDescription(false).substring(4));

// return new ResponseEntity<Object>(errorResponse, new HttpHeaders(),
// HttpStatus.METHOD_NOT_ALLOWED);
// }
// }
