package com.rental.ws.service;

import java.util.Collection;

import com.rental.ws.model.Customer;

public interface CustomerService 
{
	public Customer getCustomerByEmail(String email);
	public Collection<Customer> getCustomersByCity(String city);
}
