package com.rental.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.ws.model.Customer;
import com.rental.ws.model.Rental;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>
{

}
