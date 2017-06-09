package com.rental.ws.repository;

import java.util.Collection;

import com.rental.ws.model.Rental;

public interface RentalQueryDAO 
{
	public Collection<Rental> getRentalsByCustomer(long customerId, int pageNumber);
}
