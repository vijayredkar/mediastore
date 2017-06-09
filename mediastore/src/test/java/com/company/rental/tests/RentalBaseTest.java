package com.company.rental.tests;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rental.ws.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= Application.class)
public abstract class RentalBaseTest 
{
  Logger logger = LoggerFactory.getLogger(RentalBaseTest.class);
}
