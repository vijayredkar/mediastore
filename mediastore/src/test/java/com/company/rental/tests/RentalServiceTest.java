package com.company.rental.tests;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.rental.ws.model.Rental;
import com.rental.ws.repository.RentalDAO;
import com.rental.ws.repository.RentalQueryDAO;
import com.rental.ws.service.RentalService;
import com.rental.ws.service.RentalServiceImpl;

public class RentalServiceTest 
{

@Mock	
RentalDAO rentalDAO;

@Autowired
RentalService rentalService;

@Mock	
RentalQueryDAO rentalQueryDAO;

 @Before
 public void setup()
 {
   MockitoAnnotations.initMocks(this);
 }
	
 @After
 public void tearDown()
 {
	  
 }
/*
 * Unit test for getRentalsByCustomer	
 */
 @Test
 public void getRentalsByCustomerTest() throws Exception
 { 
	 //create mock rental objs
	 Rental rental = new Rental();	 
	 List<Rental> listOfRentals = new ArrayList<Rental>();
	 
	 rental.setRental_id(1L);
	 rental.setInventory_id(100L);
	 rental.setCustomer_id(200L);
	 rental.setRental_date(new Timestamp(2017, 06, 03, 11, 15, 18, 20));
	 rental.setReturn_date(new Timestamp(2017, 06, 10, 11, 15, 18, 20)); 
	 rental.setLast_update(new Timestamp(2017, 06, 10, 11, 15, 18, 20));
	 rental.setStaff_id(300L);
	 
	 listOfRentals.add(rental);
	 
	 rental.setRental_id(2L);
	 rental.setInventory_id(100L);
	 rental.setCustomer_id(200L);
	 rental.setRental_date(new Timestamp(2017, 06, 03, 11, 15, 18, 20));
	 rental.setReturn_date(new Timestamp(2017, 06, 10, 11, 15, 18, 20));
	 rental.setLast_update(new Timestamp(2017, 06, 10, 11, 15, 18, 20));
	 rental.setStaff_id(300L);
	 
	 listOfRentals.add(rental);
	 
	 RentalService rentalService = new RentalServiceImpl();
	 rentalService.setRentalQueryDAO(rentalQueryDAO);
	 
	 Mockito.when(rentalQueryDAO.getRentalsByCustomer(Mockito.anyLong(), Mockito.anyInt())).thenReturn(listOfRentals);
	 Assert.assertEquals(rentalService.getRentalsByCustomer(3L, 1).size(), 2);	 
	 Mockito.verify(rentalQueryDAO,Mockito.times(1)).getRentalsByCustomer(Mockito.anyLong(), Mockito.anyInt());
 } 
 
 /*
  * Unit test for createRental	
  */
  @Test
  public void createRental() throws Exception
  { 
 	 //create mock rental obj
 	 Rental rental = new Rental(); 	 
 	 rental.setRental_id(1L);
 	 rental.setInventory_id(100L);
 	 rental.setCustomer_id(200L);
 	 rental.setRental_date(new Timestamp(2017, 06, 03, 11, 15, 18, 20));
 	 rental.setReturn_date(new Timestamp(2017, 06, 10, 11, 15, 18, 20));
 	 rental.setLast_update(new Timestamp(2017, 06, 10, 11, 15, 18, 20));
 	 rental.setStaff_id(300L);
 	 
 	 RentalService rentalService = new RentalServiceImpl();
 	 rentalService.setRentalDAO(rentalDAO);
 	 
 	 Mockito.when(rentalDAO.save(rental)).thenReturn(rental);
	 Assert.assertNotNull(rentalService.createRental(rental));	 
	 Mockito.verify(rentalDAO,Mockito.times(1)).save(rental);
  } 
  
  /*
   * Unit test for updateRental	
   */
   @Test
   public void updateRental() throws Exception
   { 
  	 //create mock rental obj
  	 Rental rental = new Rental(); 	 
  	 rental.setRental_id(1L);
  	 rental.setInventory_id(100L);
  	 rental.setCustomer_id(200L);
  	 rental.setRental_date(new Timestamp(2017, 06, 03, 11, 15, 18, 20));
  	 rental.setReturn_date(new Timestamp(2017, 06, 10, 11, 15, 18, 20));
  	 rental.setLast_update(new Timestamp(2017, 06, 10, 11, 15, 18, 20));
  	 rental.setStaff_id(300L);
  	 
  	 RentalService rentalService = new RentalServiceImpl();
  	 rentalService.setRentalDAO(rentalDAO);
  	 
  	 Mockito.when(rentalDAO.save(rental)).thenReturn(rental);
 	 Assert.assertNotNull(rentalService.createRental(rental));	 
 	 Mockito.verify(rentalDAO,Mockito.times(1)).save(rental);
   }
}