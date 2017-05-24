package com.cap.test;

import java.util.Iterator;
import java.util.List;

import org.cap.model.Country;
import org.cap.service.CountryService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
@WebAppConfiguration
public class MyCountryServiceTest {

	@Autowired
	CountryService countryService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllCountries() {
		List<Country> listOfCountries = countryService.getAllCountries();
		System.out.println(listOfCountries.size());
		Iterator<Country> it = listOfCountries.iterator();
		while (it.hasNext()) {
			Country country = (Country) it.next();
			System.out.println("ID" + "   "   +  "Country Name"    + "" + " Population");
			System.out.print(country.getId() + "    "   +  country.getCountryName()    + "      " + country.getPopulation());
		}
		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCountry() {
		Country country = new Country();
		country = countryService.getCountry(1);
		System.out.print("Country Name : " + country.getCountryName()
				+ "            " + "Country Population             "
				+ country.getPopulation());

		// fail("Not yet implemented");
	}

	@Test
	public void testAddCountry() {
		Country country = new Country();
		country.setId(124);
		country.setCountryName("Uunites States");
		country.setPopulation(12345l);
		countryService.addCountry(country);

		// fail("Not yet implemented");
	}

	@Test
	public void testUpdateCountry() {
		Country country = new Country();
		country = countryService.getCountry(102);
		country.setCountryName("United States");
		country.setPopulation(5858585l);
		countryService.updateCountry(country);
		// fail("Not yet implemented");
	}

	@Test
	public void testDeleteCountry() {
		Country country = new Country();
		countryService.deleteCountry(124);

		// fail("Not yet implemented");
	}

}
