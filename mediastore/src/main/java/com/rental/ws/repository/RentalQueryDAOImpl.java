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
import com.rental.ws.model.Rental;

/*
 * DAO class for DB operations
 */
@Component
public class RentalQueryDAOImpl implements RentalQueryDAO
{
  Logger logger = LoggerFactory.getLogger(RentalQueryDAOImpl.class);
  
  EntityManagerFactory emf;
  
  @PersistenceUnit
  public void setEmf(EntityManagerFactory emf)
  {
	 this.emf =  emf;
  }
  
  /*
   * API to query the DB and return rentals associated with a customer 
   */ 

	@Override
	public Collection<Rental> getRentalsByCustomer(long customerId , int pageNumber)  
	{ 
		  String qryString = "from Rental where customer_id = :param";
		  	  
		  EntityManager em = emf.createEntityManager();
		  Query qry = em.createQuery(qryString);
		  qry.setParameter("param", customerId);//binding parameter to mitigate SQL Injection attacks
		  
		  List<Rental> resultList = qry.setMaxResults(ProjectConstants.MAX_RESULTS_PAGE)
				  			           .getResultList();
		  
		  if(resultList == null || resultList.size() == 0)
		  {
			 return null;
		  }	  	  
		  
		  return resultList;	
	}
	
	//attempted pagination logic
/*	public Collection<Rental> getRentalsByCustomer(long customerId, int pageNumber)   
	{ 
		  String qryString = "from Rental where customer_id = :param";
		  
		  EntityManager em = emf.createEntityManager();
		  Query qry = em.createQuery(qryString);
		  qry.setParameter("param", customerId);//binding parameter to mitigate SQL Injection attacks
		  
		  List<Rental> resultList = qry.getResultList();
		  
		  if(resultList == null || resultList.size() == 0)
		  {
			 return null;
		  }
		  if(pageNumber <=0)
		  {
		    pageNumber =1;			  
		  }
		  else if(pageNumber > (resultList.size() / ProjectConstants.MAX_RESULTS_PAGE))
		  {
			  pageNumber = (resultList.size() / ProjectConstants.MAX_RESULTS_PAGE) + 1;
		  }
		  
		  logger.info("----pageNumber "+pageNumber);
		  
		  
		  int startIndex, endIndex;
		  endIndex = pageNumber  * ProjectConstants.MAX_RESULTS_PAGE;// 1 * 10 =10        2 * 10=20
		  startIndex = endIndex - (ProjectConstants.MAX_RESULTS_PAGE - 1) ;//10 - (10-1)=1    20 - (10 -1)=11
		  
		  logger.info("----startIndex "+startIndex);
		  logger.info("----endIndex "+endIndex);
		  
		  
		  EntityManager em = emf.createEntityManager();
		  Query qry = em.createQuery(qryString);
		  qry.setParameter("param", customerId);//binding parameter to mitigate SQL Injection attacks
		  
		  
//		  List<Rental> resultList = qry.getResultList();
		  
		  if(resultList == null || resultList.size() == 0)
		  {
			 return null;
		  }
		  //else
		  if(resultList.size() < ProjectConstants.MAX_RESULTS_PAGE)
		  {
			  logger.info("----pageination 1 ");  
			return resultList;
		  }
		  else
		  {   logger.info("----pageination 2 ");
			  List paginatedList = resultList.subList(startIndex, endIndex+1);
			  if(paginatedList.size() < ProjectConstants.MAX_RESULTS_PAGE)
			  {  
				  logger.info("----pageination 3 "); 
				 return resultList.subList(resultList.size() - ProjectConstants.MAX_RESULTS_PAGE, resultList.size());
			  }
			  else
			  {   logger.info("----pageination 4 ");
				  return paginatedList;				  
			  }
		  }
		  
		  List<Rental> resultList = qry.setMaxResults(ProjectConstants.MAX_RESULTS_PAGE)
				  			           .getResultList().subList(startIndex, endIndex+1);
		  
		  //return resultList;	
	}*/
}