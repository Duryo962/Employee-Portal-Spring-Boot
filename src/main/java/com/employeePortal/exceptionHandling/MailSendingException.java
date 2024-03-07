package com.employeePortal.exceptionHandling;

public class MailSendingException extends RuntimeException{
	
	public MailSendingException(String message)
	{
		super(message);
	}

}
