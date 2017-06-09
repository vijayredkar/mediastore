package com.rental.ws.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rental 
{	
	@Id
	@GeneratedValue
	 Long rental_id;	
	//java.sql.Date
	 Timestamp rental_date;
	 Long inventory_id;
	 Long customer_id ;
	 Timestamp return_date;
	 Long staff_id;
	 Timestamp last_update;
	
	public Rental()
	{
		
	}
	
	public Long getRental_id() {
		return rental_id;
	}


	public void setRental_id(Long rental_id) {
		this.rental_id = rental_id;
	}


	public Timestamp getRental_date() {
		return rental_date;
	}


	public void setRental_date(Timestamp rental_date) {
		this.rental_date = rental_date;
	}


	public Long getInventory_id() {
		return inventory_id;
	}


	public void setInventory_id(Long inventory_id) {
		this.inventory_id = inventory_id;
	}


	public Long getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}


	public Timestamp getReturn_date() {
		return return_date;
	}


	public void setReturn_date(Timestamp return_date) {
		this.return_date = return_date;
	}


	public Long getStaff_id() {
		return staff_id;
	}


	public void setStaff_id(Long staff_id) {
		this.staff_id = staff_id;
	}


	public Timestamp getLast_update() {
		return last_update;
	}


	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
}
