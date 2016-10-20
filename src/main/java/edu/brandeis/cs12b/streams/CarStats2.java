package edu.brandeis.cs12b.streams;

public class CarStats2 {
	
	/**
	 * Using Car.getCars() to get a stream, calculate the average mileage of a car
	 * produced by the given manufacturer
	 * @param manufac the manufacturer 
	 * @return the average mileage
	 */
	public static double averageMilage(String manufac) {
		return Car.getCars().stream()
				//filters for cars of the manufacturer
				.filter(c->c.getManu().equals(manufac))
				//gets values of mpg of cars
				.mapToDouble(c->c.getMpg())
				//averages these values and returns double
				.average().getAsDouble();
	}
}
