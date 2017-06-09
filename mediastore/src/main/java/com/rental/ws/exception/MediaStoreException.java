package com.rental.ws.exception;

public class MediaStoreException extends Exception
{	
	public MediaStoreException() 
	{
		super();
	}
	
	public String getMediaStoreRentalException(Exception e) 
	{
		return "Exception occurred when processing rental.\n"+ e.getMessage();
	}
	
	public String getMediaStoreCustomerException(Exception e) 
	{
		return "Exception occurred when processing customer data.\n"+ e.getMessage();
	}
}
