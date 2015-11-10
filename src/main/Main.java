package main;

import java.util.ArrayList;
import java.util.Random;

import letters.Letter;
import letters.PromisoryNote;
import letters.RegisteredLetter;
import letters.SimpleLetter;
import letters.UrgentLetter;

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
	private static final String SEPARATOR = "**************************************" ;

	// Use to know wich letter can be sent or not
	private static ArrayList<Letter<?>> availableLetter;
	private static Random random;
	
	public static void main(String[] args) {
		random = new Random();
		availableLetter = new ArrayList<>();
		int nbDays = (args.length > 0 ? Integer.parseInt(args[0]) : 10);

		availableLetter.add(new SimpleLetter(null, null, null));
		availableLetter.add(new PromisoryNote(null, null, null));
		availableLetter.add(new RegisteredLetter(null, null, null));
		availableLetter.add(new UrgentLetter(null, null, null));
		
		City city = createCity();
		ArrayList<Inhabitant> inhabitants = createInhabitants(city);
		
		System.out.println("Creating " + city.getName() + " city");
		System.out.println("Creating " + CITY_SIZE + " inhabitants");
		System.out.println("Mailing letters for " + nbDays + " days");
		System.out.println(SEPARATOR);
		
		for (int i = 1; i <= nbDays; i++) {
			System.out.println("Day " + i);
			
			doOneDay(city, inhabitants);
			
			System.out.println(SEPARATOR);
		}
	}
	
	/**
	 * Simulate one day with random values
	 * @param city
	 * @param inhabitants
	 */
	private static void doOneDay(City city, ArrayList<Inhabitant> inhabitants){
		
	}
	
	/**
	 * Create city with a randomize name
	 * @return a city with a randomize name
	 */
	private static City createCity() {
		String cityName = "";
		
		cityName += (char) ('A' + random.nextInt(26));
		
		for(int i = 0; i < CITY_NAME_SIZE - 1; i++) {
			cityName += (char) ('a' + random.nextInt(26));
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
	
}
