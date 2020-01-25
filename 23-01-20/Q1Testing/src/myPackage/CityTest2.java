package myPackage;

import org.junit.Test;

import junit.framework.Assert;

public class CityTest2 {
	
	City city1 = new City(); 
	//City city2 = new City(); 
	CityBusinessLogic cityLogic = new CityBusinessLogic();
			
	@SuppressWarnings("deprecation")
	@Test
	public void testIsMetropolitan() {
		city1.setName("Delhi");
		city1.setCountry("India");
		city1.setPopulation(5000000);
		city1.setAverageIncome(1000000);
		
		boolean isMetropol = cityLogic.isMetropolitan(city1);
		Assert.assertEquals("Delhi is Metropolitan",true, isMetropol);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCostofLiving() {
		city1.setName("Delhi");
		city1.setCountry("India");
		city1.setPopulation(5000000);
		city1.setAverageIncome(1000000);
		
		double costOfLiving = cityLogic.getCostofLiving(city1);
		Assert.assertEquals(400000, costOfLiving, 0);
	}
}
