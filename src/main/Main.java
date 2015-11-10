package main;

import java.util.ArrayList;
import java.util.Random;

import entity.City;
import entity.Inhabitant;

/**
 * 
 * @author dubois bellamy
 *
 */
public class Main {
	private static final int CITY_SIZE = 100;
	private static final int CITY_NAME_SIZE = 64;
	private static Random random;
	
	public static void main(String[] args) {
		random = new Random();
		int nbDays = (args[0] != null ? Integer.parseInt(args[0]) : 10);

		City city = createCity();
		ArrayList<Inhabitant> inhabitantList = createInhabitants(city);
		
		System.out.println("Creating " + city.getName() + " city");
		System.out.println("Creating " + CITY_SIZE + " inhabitants");
		System.out.println("Mailing letters for " + nbDays + " days");
		
		printSeparator();
	}
	
	/**
	 * Create city with a randomize name
	 * @return a city with a randomize name
	 */
	private static City createCity() {
		String cityName = "";
		
		cityName += new Character((char) ('A' + random.nextInt('Z' - 'A')));
		
		for(int i = 0; i < CITY_NAME_SIZE - 1; i++) {
			cityName += new Character((char) ('a' + random.nextInt('z' - 'a')));
		}
		
		return new City(cityName);
	}
	
	/**
	 * Fill the habitants array passed in parameters with new habitants
	 * @param habitants
	 */
	@SuppressWarnings("unused")
	private static ArrayList<Inhabitant> createInhabitants(City city) {
		int cpt = 0;
		ArrayList<Inhabitant> inhabitantList = new ArrayList<>(CITY_SIZE);
		
		for (Inhabitant inhabitant : inhabitantList) {
			inhabitant = new Inhabitant(city, "inhabitant-" + cpt++);
		}
		
		return inhabitantList;
	}
	
	/**
	 * Print a separator line with 42 characters '*'
	 */
	private static void printSeparator() {
		String separator = "";
		for(int i = 0; i < 42; i++) {
			separator += "*";
		}
		System.out.println(separator);
	}
}
