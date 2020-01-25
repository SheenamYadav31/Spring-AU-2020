package myPackage;

public class CityBusinessLogic {
	
	//find if the city is metropolitan city or not. i.e., population greater than 4 million
	public boolean isMetropolitan(City city) {
		if(city.getPopulation()>=4000000) {
			return true;
		}
		return false;
	}
	
	//find cost of living in a city
	public double getCostofLiving(City city) {
		return city.getAverageIncome()*0.4;
	}

}
