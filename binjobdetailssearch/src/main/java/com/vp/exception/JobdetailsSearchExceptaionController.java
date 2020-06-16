package com.vp.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JobdetailsSearchExceptaionController {
	@Value("${job_records_not_found}")
	private String JobRecordsNotFound;
	
	@ExceptionHandler
	public ResponseEntity<Object> jobRecordsNotFound(JobsRecordNotFoundException jobsRecordNotFoundException){
		
		return new ResponseEntity<Object>(JobRecordsNotFound, HttpStatus.NOT_FOUND);
	
}
}
