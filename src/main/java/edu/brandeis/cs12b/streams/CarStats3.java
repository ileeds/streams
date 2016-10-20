package edu.brandeis.cs12b.streams;

import java.util.Set;

public class CarStats3 {

	/**
	 * Using Car.getCars() to get a stream, calculate the average mileage of all cars
	 * produced after the given year (exclusive) that was manufactured by any of the manufacturers
	 * in the given set.
	 * 
	 * @param manu the set of relevant manufacturers
	 * @param year
	 * 
	 * @return the average mileage
	 */
	public static double averageMilage(Set<String> manu, int year) {
		return Car.getCars().stream()
				//filters for cars after year and within set of manufacturers
				.filter(c->c.getYear()>year && manu.contains(c.getManu()))
				//gets mpg of these cars, averages, returns double
				.mapToDouble(c->c.getMpg())
				.average().getAsDouble();
	}
}
