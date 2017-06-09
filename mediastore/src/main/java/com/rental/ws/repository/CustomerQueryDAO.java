package com.rental.ws.repository;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.rental.ws.model.Customer;

public interface CustomerQueryDAO 
{
	public Customer getCustomerByEmail(String email) throws Exception;
	public Collection<Customer> getCustomersByCity(String city);
}
