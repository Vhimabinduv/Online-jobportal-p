package com.vp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class JobServiceException extends RuntimeException{
	public JobServiceException(String message)
	{
		super(message);
	}
}
