package com.rental.ws.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rental.ws.controller.RentalController;
import com.rental.ws.exception.MediaStoreException;
import com.rental.ws.model.Rental;
import com.rental.ws.repository.RentalDAO;
import com.rental.ws.repository.RentalQueryDAO;


@Service
public class RentalServiceImpl implements RentalService 
{
    Logger logger = LoggerFactory.getLogger(RentalServiceImpl.class);
   
    @Autowired
	RentalDAO rentalDAO;

    @Autowired
	RentalQueryDAO rentalQueryDAO;
    
	/*
	 * API to create a rental item
	 */
	@Override
	public Rental createRental(Rental rental)
	{
		try 
		{
		 return rentalDAO.save(rental);
		}
		catch (Exception e) 
		{
		  logger.error(new MediaStoreException().getMediaStoreRentalException(e));
		}
		return null;
	}

	/*
	 * API to delete a rental item
	 */
	@Override
	public void deleteRental(long id)
	{
		try 
		{
		  rentalDAO.delete(id);
		} 
		catch (Exception e) 
		{
		  logger.error(new MediaStoreException().getMediaStoreRentalException(e));
		}		
	}

	
	/*
	 * API to update a rental item
	 */
	@Override
	public Rental updateRental(Rental rental)
	{
		try 
		{
		  rentalDAO.save(rental);
		} catch (Exception e) 
		{
		  logger.error(new MediaStoreException().getMediaStoreRentalException(e));
		}
		return null;		
	}

	/*
	 * API to get all rentals by a customer
	 */
	@Override	
	public Collection<Rental> getRentalsByCustomer(long customerId, int pageNumber) 
	{
		try 
		{
			return rentalQueryDAO.getRentalsByCustomer(customerId, pageNumber);
		} catch (Exception e)  
		{
		  logger.error(new MediaStoreException().getMediaStoreRentalException(e));
		}
		return null;		
	}

	/*
	 * API to find a rental item by id
	 */
	@Override
	public Rental getRental(long id) 
	{
		try 
		{
			/*
			List<Rental> results = rentalDAO.findAll();
			logger.info("----------------results.size() "+results.size());			
			results.stream()
				   .forEach(result -> {logger.info("result.getRental_id() "+result.getRental_id()+"---"+"result.getCustomer_id() "+result.getCustomer_id());});
			*/
			
		  return rentalDAO.findOne(id);
		} catch (Exception e) 
		{
		  logger.error(new MediaStoreException().getMediaStoreRentalException(e));
		}
		
		return null;
	}	
	
	public void setRentalQueryDAO(RentalQueryDAO rentalQueryDAO) 
	{
		this.rentalQueryDAO = rentalQueryDAO;
	}

	@Override
	public void setRentalDAO(RentalDAO rentalDAO) 
	{
		this.rentalDAO = rentalDAO;
	}
}
