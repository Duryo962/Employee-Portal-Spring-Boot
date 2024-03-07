package com.employeePortal.exceptionHandling;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ProblemDetail> badrequest(BadRequestException exception)
	{
			ProblemDetail detail=ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
			detail.setProperty("Message", exception.getMessage());
			detail.setType(URI.create("/error"));
			detail.setStatus(HttpStatus.BAD_REQUEST);
			detail.setProperty("Error", "Error");
			return ResponseEntity.ok().body(detail);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ProblemDetail> employeeNotFound(EmployeeNotFoundException exception)
	{
		ProblemDetail detail=ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		detail.setProperty("Message", exception.getMessage());
		detail.setType(URI.create("/error"));
		detail.setStatus(HttpStatus.NOT_FOUND);
		detail.setProperty("Error", "Error");
		
		return ResponseEntity.ok(detail);
	}
	
	@ExceptionHandler(MailSendingException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ProblemDetail> mailSendingExcep(MailSendingException exception)
	{
			ProblemDetail detail=ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
			detail.setProperty("Message", exception.getMessage());
			detail.setType(URI.create("/error"));
			detail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			detail.setProperty("Error", "Error");
			return ResponseEntity.ok().body(detail);
	}

}
