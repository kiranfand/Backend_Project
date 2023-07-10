package com.app.customexcep;

public class ProgrammErrorException extends RuntimeException {

	public ProgrammErrorException(String msg) 
	{
		super(msg);
	}
}
