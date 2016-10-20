package edu.brandeis.cs12b.streams;

import java.util.Map;
import java.util.Set;

// HINT: you need this import! (if you erase it on accident, it is import java.util.stream.Collectors)
import java.util.stream.Collectors;

public class CarStats5 {
	
	
	/**
	 * Using Car.getCars() to get a stream, return a map from car manufactors to average
	 * mileage for cars produced by the manufacturers in the given set after the given year
	 * (exclusive).
	 * 
	 * @param manu the manufacturers that should appear as keys in the returned map
	 * @param year the cutoff year
	 * @return a map from manufacturers to average mileage
	 */
	public static Map<String, Double> averageMPG(Set<String> manu, int year) {
		return Car.getCars().stream()
				//filters for cars within set of manufacturers, after given year
				.filter(c->manu.contains(c.getManu()) && c.getYear()>year)
				//maps manufacturers of car to keyset of map, average of their mpg's to values of map
				.collect(Collectors.groupingBy(Car::getManu, Collectors.averagingDouble(Car::getMpg)));
	}
}
