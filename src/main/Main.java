package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import letters.Letter;
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

	// Use to know which letter can be sent or not
	private static ArrayList<Letter<?>> availableLetter;
	private static Random random;
	
	public static void main(String[] args) {
		int nbDays = (args.length > 0 ? Integer.parseInt(args[0]) : 10);
		random = new Random();
		availableLetter = new ArrayList<>();

//		availableLetter.add(new SimpleLetter(null, null, null));
//		availableLetter.add(new PromisoryNote(null, null, null));
//		availableLetter.add(new RegisteredLetter(null, null, null));
//		availableLetter.add(new UrgentLetter(null, null, null));
		
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
		Inhabitant sender = null;
		Inhabitant reciever = null;
		Letter<?> tmp = null;
		List<Letter<?>> tmpRecieveLetter = null;
		
		// The number of letter to send 
		int nbLetterSend = random.nextInt(10);
		
		// Recieve letter session
		for (Inhabitant inhabitant : inhabitants) {
			tmpRecieveLetter = inhabitant.getRecieveLetters();
			
			if(!tmpRecieveLetter.isEmpty()){
				for (Letter<?> letter : tmpRecieveLetter) {
					System.out.println(inhabitant.getName()+" receives "+letter+" from "+letter.getSender().getName());
				}
				// Remove all old letters
				inhabitant.setRecieveLetters(new ArrayList<Letter<?>>());
			}
		}
		
		// Send randomize letter session
		for (int i = 0; i < nbLetterSend; i++) {
			sender = inhabitants.get(random.nextInt(CITY_SIZE));
			reciever = inhabitants.get(random.nextInt(CITY_SIZE));
			
			if(!sender.equals(reciever)){
				// Generate a letter
				tmp = sender.makeLetter(reciever);
				// Simulate the payment
				sender.sendLetter(tmp);
				// Simulate the post of the letter
				city.sendLetter(tmp);
				System.out.println(sender.getName()+" mails "+tmp.toString()+" to "+reciever.getName()+" for cost of "+tmp.getCost()+" euro(s)");
			}
		}
		
		city.distributeLetters();
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
	private static ArrayList<Inhabitant> createInhabitants(City city) {
		ArrayList<Inhabitant> inhabitantList = new ArrayList<>(CITY_SIZE);
		
		for (int cpt = 1; cpt <= CITY_SIZE; cpt++) {
			inhabitantList.add(new Inhabitant(city, "inhabitant-" + cpt));
		}
		
		return inhabitantList;
	}
	
}
