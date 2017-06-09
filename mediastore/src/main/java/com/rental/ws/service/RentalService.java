package com.rental.ws.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.rental.ws.model.Rental;
import com.rental.ws.repository.RentalDAO;
import com.rental.ws.repository.RentalQueryDAO;

public interface RentalService 
{
	public Rental createRental( Rental rental);
    public void deleteRental(long id);
	public Rental updateRental(Rental rental);
	public Collection<Rental> getRentalsByCustomer(long customerId, int pageNumber);
	public Rental getRental(long id);
	public void setRentalQueryDAO(RentalQueryDAO rentalQueryDAO);
	public void setRentalDAO(RentalDAO rentalDAO);
}
