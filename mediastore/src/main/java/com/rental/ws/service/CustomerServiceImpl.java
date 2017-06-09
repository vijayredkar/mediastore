package com.rental.ws.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.ws.exception.MediaStoreException;
import com.rental.ws.model.Customer;
import com.rental.ws.repository.CustomerDAO;
import com.rental.ws.repository.CustomerQueryDAO;
import com.rental.ws.repository.CustomerQueryDAOImpl;


@Service
public class CustomerServiceImpl implements CustomerService 
{	
	@Autowired
	CustomerQueryDAO customerqueryDAO;
	
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	/*
	 * API to find customer having the specified email
	 */
	@Override
	public Customer getCustomerByEmail(String email) 
	{
		try
		{
		  return customerqueryDAO.getCustomerByEmail(email);
		}
		catch (Exception e) 
		{
		  logger.error(new MediaStoreException().getMediaStoreRentalException(e));
		}
	
	    return null;
	}
	
	/*
	 * API to find customers belonging to the specified city
	 */
	@Override
	public Collection<Customer> getCustomersByCity(String city) 
	{
		logger.info("---Service getCustomersByCity "+city);
		try
		{
		  return customerqueryDAO.getCustomersByCity(city);
		}
		catch (Exception e) 
		{
		  logger.error(new MediaStoreException().getMediaStoreRentalException(e));
		}
		
		return null;
	}	
}
