package edu.brandeis.cs12b.streams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class CarStatsTest {

	@Test
	public void stats1Test() {
		assertEquals(157, CarStats1.countCars(2005, 2009));
		assertEquals(559, CarStats1.countCars(1990, 2009));
		assertEquals(1000, CarStats1.countCars(0, 3000));
	}


	@Test
	public void stats2Test() {
		assertEquals(26.03, CarStats2.averageMilage("Ford"), 0.1);
		assertEquals(25.98, CarStats2.averageMilage("Kia"), 0.1);
		assertEquals(26.41, CarStats2.averageMilage("Honda"), 0.1);
	}

	@Test
	public void stats3Test() {
		assertEquals(25.9, CarStats3.averageMilage(makeSet("Ford", "Kia"), 2015), 0.1);
		assertEquals(26.1, CarStats3.averageMilage(makeSet("Porsche", "Honda"), 2000), 0.1);
		assertEquals(26.1, CarStats3.averageMilage(makeSet("Porsche", "Honda", "Nothing"), 2000), 0.1);
	}

	@Test
	public void stats4Test() {
		assertTrue(CarStats4.exists(makeSet("Ford"), 2002, 23.0));
		assertFalse(CarStats4.exists(makeSet("Ford"), 2015, 32.0));


		assertTrue(CarStats4.exists(makeSet("Ford", "Honda"), 2009, 23.0));
		assertTrue(CarStats4.exists(makeSet("Ford", "Honda", "Kia"), 2009, 31.5));
		assertFalse(CarStats4.exists(makeSet("Kia"), 2019, 31.9));
	}

	@Test

	public void stats5Test() {

	Map<String, Double> result = CarStats5.averageMPG(makeSet("Honda", "Toyota"), 2005);



	assertEquals(2, result.size());

	assertEquals(25.9, result.get("Toyota"), 0.1);

	assertEquals(26.69, result.get("Honda"), 0.1);



	}

	@Test
	public void semicolons() {
		assertTrue(
				getSemicolons(Paths.get("src", "main", "java", "edu", 
						"brandeis", "cs12b", "streams", "CarStats1.java")) 
				<= 2
				);

		assertTrue(
				getSemicolons(Paths.get("src", "main", "java", "edu", 
						"brandeis", "cs12b", "streams", "CarStats2.java")) 
				<= 2
				);

		assertTrue(
				getSemicolons(Paths.get("src", "main", "java", "edu", 
						"brandeis", "cs12b", "streams", "CarStats3.java")) 
				<= 3
				);

		assertTrue(
				getSemicolons(Paths.get("src", "main", "java", "edu", 
						"brandeis", "cs12b", "streams", "CarStats4.java")) 
				<= 3
				);

		assertTrue(
				getSemicolons(Paths.get("src", "main", "java", "edu", 
						"brandeis", "cs12b", "streams", "CarStats5.java")) 
				<= 5
				);
	}



	private static long getSemicolons(Path p) {
		try {
			return Files.lines(p)
					.flatMapToInt(s -> s.chars())
					.filter(i -> i == ';')
					.count();
		} catch (IOException e) {
			return Long.MAX_VALUE;
		}

	}

	@SafeVarargs
	private static <K> Set<K> makeSet(K... args) {
		return new HashSet<K>(Arrays.asList(args));
	}
}
