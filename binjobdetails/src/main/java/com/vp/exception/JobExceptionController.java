package com.vp.exception;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
@RestController
public class JobExceptionController extends  ResponseEntityExceptionHandler{
	
	
	@Value("${job_not_found}")
	private String JobRecordsNotFound;
	@Value("${exception_found}")
	private String Request;
//specific exceptions
	@ExceptionHandler(value=JobNotFoundException.class)
	public ResponseEntity<Object> jobexception(JobNotFoundException exception,WebRequest request)
	{
		ErrorDetails errordetails= new ErrorDetails(new Date(),JobRecordsNotFound,request.getDescription(false));
		return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
	}
	
	/*//globalexceptions
	@ExceptionHandler(value=RuntimeException.class)
	public ResponseEntity<Object> handleGlobalexception(RuntimeException exception,WebRequest request)
	{
		ErrorDetails errordetails= new ErrorDetails(new Date(),Request,request.getDescription(false));
		return new ResponseEntity<>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
	
	
	@ExceptionHandler({JobServiceException.class , SQLException.class , NullPointerException.class})
	public ResponseEntity<Object> handle()
	{
		return new ResponseEntity<>("Job Service not available" , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
