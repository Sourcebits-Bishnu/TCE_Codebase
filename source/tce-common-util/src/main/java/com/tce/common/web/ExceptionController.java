package com.tce.common.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tce.common.exception.TataException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionController {
	

	@ExceptionHandler(MethodArgumentNotValidException.class)	
	public ResponseEntity<?> onArgumentValidationException(MethodArgumentNotValidException e) {
		Map<String, String> violations = new HashMap<>();
		 for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			violations.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		log.error("Argument Validation ERROR >>> {}", violations);
		return new ResponseEntity<>(violations,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)	
	public ResponseEntity<?> onConstraintValidationException(ConstraintViolationException e) {
		Map<String, String> violations = new HashMap<>();
		for (ConstraintViolation<?> error : e.getConstraintViolations()) {
			violations.put(error.getPropertyPath().toString(), error.getMessage());
		}
		log.error("Constraint Validation ERROR >>> {}", violations);
		return new ResponseEntity<>(violations,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = TataException.class)
	public ResponseEntity<?> classedgeEX(TataException ex) {
		log.error("ClassEdge ERROR >>>", ex);
		return new ResponseEntity<>(new TCEErrorResponse(ex.getErrorCode(),ex.getErrorMsg()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> globalEX(Exception ex) {
		log.error("ERROR >>>", ex);
		Map<String, String> violations = new HashMap<>();
		violations.put(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), ex.getMessage());
		return new ResponseEntity<>(violations,	HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
