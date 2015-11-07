package main;

import java.util.Random;

import entity.City;
import entity.Inhabitant;

/**
 * 
 * @author dubois bellamy
 *
 */
public class Main {
	
	private Random random;
	
	public Main() {
		this.random = new Random();
	}
	
	/**
	 * Create city with a randomize name
	 * @return a city with a randomize name
	 */
	private City createCity() {
		String cityName = "";
		int cityLength = 64;
		
		cityName += new Character((char) ('A' + this.random.nextInt('Z' - 'A')));
		
		for(int i = 0; i < cityLength - 1; i++) {
			cityName += new Character((char) ('a' + this.random.nextInt('z' - 'a')));
		}
		
		return new City(cityName);
	}
	
	/**
	 * Fill the habitants array passed in parameters with new habitants
	 * @param habitants
	 */
	private void createInhabitants(Inhabitant[] habitants) {
		for(int i = 0; i < habitants.length; i++) {
			habitants[i] = new Inhabitant("inhabitant-" + i);
		}
	}
	
	/**
	 * Print a separator line with 42 characters '*'
	 */
	private void printSeparator() {
		String separator = "";
		for(int i = 0; i < 42; i++) {
			separator += "*";
		}
		System.out.println(separator);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		City city = main.createCity();
		System.out.println("Creating " + city.getName() + " city");
		int nbHabitant = 100;
		Inhabitant[] habitants = new Inhabitant[nbHabitant];
		main.createInhabitants(habitants);
		System.out.println("Creating " + nbHabitant + " inhabitants");
		int nbDays = Integer.parseInt(args[0]);
		System.out.println("Mailing letters for " + nbDays + " days");
		
		main.printSeparator();
	}

}
