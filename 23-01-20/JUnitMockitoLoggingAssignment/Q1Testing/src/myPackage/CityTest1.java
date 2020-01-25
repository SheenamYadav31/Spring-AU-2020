package myPackage;

import org.junit.Assert;
import org.junit.Test;

public class CityTest1 {
	City city1 = new City(); 
	City city2 = new City(); 
	
	@Test
	public void testString() {
		city1.setName("Delhi");
		city2.setName("New Delhi");
		Assert.assertEquals(city1.getName(),city2.getName());
	}
	
	@Test
	public void testNumber() {
		double population = 100000;
		Assert.assertEquals(100000,population,0);
	}

}
