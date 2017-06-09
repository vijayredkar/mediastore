package com.rental.ws.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.rental.ws.constants.ProjectConstants;
import com.rental.ws.model.Customer;

/*
 * DAO class for DB operations
 */
@Component
public class CustomerQueryDAOImpl implements CustomerQueryDAO
{
  Logger logger = LoggerFactory.getLogger(CustomerQueryDAOImpl.class);
  
  EntityManagerFactory emf;
  
  @PersistenceUnit
  public void setEmf(EntityManagerFactory emf)
  {
	 this.emf =  emf;
  }
  
  /*
   * API to query the DB and return customer who has the specified email 
   */
  
  //public List<City> getCities(String startsWith, int maxRowsToDisplay) throws Exception
  public Customer getCustomerByEmail(String email) throws Exception
  {  
	  //String searchClause = email.toLowerCase();
	  //String qryString = "from City where LOWER(cityName) LIKE :param";
	  String qryString = "from Customer where LOWER(email) = :param";
	  	  
	  EntityManager em = emf.createEntityManager();
	  Query qry = em.createQuery(qryString);
	  qry.setParameter("param", email.toLowerCase());//binding parameter to mitigate SQL Injection attacks
	  
	  /*List<City> citiestList = qry.setMaxResults(maxRowsToDisplay)
			  								.getResultList();*/
	  
	  logger.info("-------------qry.toString() "+qry.toString());
	  
	  List<Customer> customerList  = qry.getResultList();
	  
	  if(customerList == null || customerList.size() == 0)
	  {
		 return null;
	  }	  	  
	  
	  return customerList.get(0);
  }

  /*
   * API to query the DB and return customer who belongs to the specified city
   */
  
@Override
public Collection<Customer> getCustomersByCity(String city) 
{  
	logger.info("---DAO getCustomersByCity "+city);
	  //String searchClause = email.toLowerCase();
	  //String qryString = "from City where LOWER(cityName) LIKE :param";
	  //String qryString = "from Customer, Address, City  where City.city_id = Address.city_id and Address.address_id = Customer.address_id and  LOWER(City.city) = :param";
		String qryString = "from Customer cu, Address a, City ci  where ci.city_id = a.city_id and a.address_id = cu.address_id and  LOWER(ci.city) = :param";
	  	  
	  EntityManager em = emf.createEntityManager();
	  Query qry = em.createQuery(qryString);
	  qry.setParameter("param", city.toLowerCase());//binding parameter to mitigate SQL Injection attacks
	  
	  List resultList = qry.setMaxResults(ProjectConstants.MAX_RESULTS_PAGE)
			  			   .getResultList();
	  
	  logger.info("------------resultList.size()  "+resultList.size());
	  
	  if(resultList == null || resultList.size() == 0)
	  {
		 return null;
	  }	  	  
	  
	  return resultList;	
}	
}