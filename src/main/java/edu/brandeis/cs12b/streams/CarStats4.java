package edu.brandeis.cs12b.streams;

import java.util.Set;

public class CarStats4 {
	
	/**
	 * Using Car.getCars() to get a stream, determine if there exists a car
	 * that was produced by one of the given manufacturs after the given year
	 * (exclusive) with mileage above mpg (exclusive)
	 * @param manu
	 * @param year
	 * @param mpg
	 * @return if such a car exists
	 */
	public static boolean exists(Set<String> manu, int year, double mpg) {
		return Car.getCars().stream()
				//filters for cars within set of manufacturers, after given year, above given mpg
				.filter(c->manu.contains(c.getManu()) && c.getYear()>year && c.getMpg()>mpg)
				//if more than 0 exist, return true
				.count() > 0;		
	}
}
