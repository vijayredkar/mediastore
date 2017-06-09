package com.rental.ws.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rental.ws.exception.MediaStoreException;
import com.rental.ws.model.Customer;
import com.rental.ws.model.Rental;
import com.rental.ws.service.CustomerService;
import com.rental.ws.service.RentalService;

@RestController
public class RentalController 
{   
    Logger logger = LoggerFactory.getLogger(RentalController.class);
    
    @Autowired
	CustomerService customerService;
    
    @Autowired
    RentalService rentalService;
        
     /*
      * REST API to get a Customer with the input email
      *
     */ 
    @RequestMapping(value="/api/customers/email",
					produces=MediaType.APPLICATION_JSON_VALUE,
					method=RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerByEmail(@RequestParam("email") String email)
	{		
		try 
		{
		  return new ResponseEntity<Customer>(customerService.getCustomerByEmail(email),HttpStatus.OK);
		} catch (Exception e) 
		{
			logger.error(new MediaStoreException().getMediaStoreCustomerException(e));
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    
	/*
	 * REST API to search Customers by city
	 */
	@RequestMapping(value="/api/customers/city",
					produces=MediaType.APPLICATION_JSON_VALUE,
					method=RequestMethod.GET)
	public ResponseEntity<Collection<Customer>> getCustomersByCity(@RequestParam("city") String city)
	{		
		try 
		{
			logger.info("---getCustomersByCity "+city);
		  return new ResponseEntity<Collection<Customer>>(customerService.getCustomersByCity(city),HttpStatus.OK);
		} catch (Exception e) 
		{
			logger.error(new MediaStoreException().getMediaStoreCustomerException(e));
			return new ResponseEntity<Collection<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	/*
     * REST API to create a rental item 
     */
	   @RequestMapping(value="/api/rentals",
			   		   method=RequestMethod.POST,
			   		   consumes=MediaType.APPLICATION_JSON_VALUE,
			   		   produces=MediaType.APPLICATION_JSON_VALUE)   
		public ResponseEntity<Rental> createRental(@RequestBody  Rental rental)
		{  
		   try 
		    {
			   rentalService.createRental(rental);		   
			   return new ResponseEntity(HttpStatus.CREATED);//created successfully
			}
		   catch (Exception e) 
		   {
			 logger.error(new MediaStoreException().getMediaStoreRentalException(e));
			 return new ResponseEntity<Rental>(HttpStatus.INTERNAL_SERVER_ERROR);
			}		   
		}

	    /*
	     * REST API to delete a rental item 
	     */
	   @RequestMapping(value="/api/rentals/{id}",
			   		   	method=RequestMethod.DELETE,
			   		   	consumes=MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<Rental> deleteRental(@PathVariable long id)
	    {  
		   try 
		   {
			rentalService.deleteRental(id);  
			return new ResponseEntity(HttpStatus.NO_CONTENT);//deleted successfully
		   }
		   catch (Exception e) 
		   {
			 logger.error(new MediaStoreException().getMediaStoreRentalException(e));
			 return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR); //not deleted
		   }
		}
	   
	    /*
	     * REST API to update a rental item 
	     */
	   @RequestMapping(value="/api/rentals/{id}",
			   		   method=RequestMethod.PUT,
			   		   consumes=MediaType.APPLICATION_JSON_VALUE,
			   		   produces=MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<Rental> updateRental(@RequestBody Rental rental)
	   {
		   try 
		   {
			rentalService.updateRental(rental);   
			return new ResponseEntity(HttpStatus.OK);//updated successfully
		   }
		   catch (Exception e) 
		   {
			 logger.error(new MediaStoreException().getMediaStoreRentalException(e));
			 return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR); //not updated
		   }		   			   
		}
	   
		/*
	     * REST API to find rentals by a customer 
	     */ 
	     
		@RequestMapping(value="/api/rentals/customer/{id}",
						produces=MediaType.APPLICATION_JSON_VALUE,
						method=RequestMethod.GET)
		public ResponseEntity<Collection<Rental>> getRentalsByCustomer(@PathVariable("id") long customerId,
																	   @RequestParam("page")int pageNumber) 
		{		
			try 
			{
			  return new ResponseEntity<Collection<Rental>>(rentalService.getRentalsByCustomer(customerId, pageNumber),HttpStatus.OK);
			} catch (Exception e) 
			{
				logger.error(new MediaStoreException().getMediaStoreRentalException(e));
				return new ResponseEntity<Collection<Rental>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		/*
		 * REST API to get rental by id
		 */
		@RequestMapping(value="/api/rentals/{id}",
						produces=MediaType.APPLICATION_JSON_VALUE,
						method=RequestMethod.GET)
		public ResponseEntity<Rental> getRental(@PathVariable("id") long id)
		{		
			try 
			{
			  return new ResponseEntity<Rental>(rentalService.getRental(id),HttpStatus.OK);
			} catch (Exception e) 
			{
				logger.error(new MediaStoreException().getMediaStoreCustomerException(e));
				return new ResponseEntity<Rental>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}		
		
}
