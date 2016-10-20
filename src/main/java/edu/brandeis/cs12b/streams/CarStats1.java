package edu.brandeis.cs12b.streams;

public class CarStats1 {
	
	/**
	 * Using Car.getCars() to get a stream, calculate the number of cars produced between the
	 * two given years, exclusive.
	 * 
	 * @param startYear
	 * @param endYear
	 * @return the number of cars
	 */
	public static int countCars(int startYear, int endYear) {
		//cast from long to int
		//stream of set of cars
		return (int) Car.getCars().stream()
				//filters for cars within years
				.filter(c->c.getYear()<endYear && c.getYear()>startYear)
				//counts remaining cars
				.count();
	}
}
