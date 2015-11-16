package entity;

import java.util.ArrayList;
import java.util.Random;

import letters.Letter;
import letters.PromisoryNote;
import letters.RegisteredLetter;
import letters.SimpleLetter;
import letters.UrgentLetter;
import content.MoneyContent;
import content.TextContent;

/**
 * Class to manage the inhabitant
 * @author dubois bellamy
 *
 */
public class Inhabitant {
	private String name;
	private Account account;
	private City city;
	private static Random random;
	private ArrayList<Letter<?>> recieveLetters;
	
	/**
	 * Constructor of a new Inhabitant
	 * @param city the city of this inhabitant
	 * @param name the name of this inhabitant
	 */
	public Inhabitant(City city, String name) {
		this.name = name;
		this.city = city;
		this.account = new Account(5000);
		random = new Random();
		recieveLetters = new ArrayList<>();
	}
	
	/**
	 * Generate a random letter
	 * @param reciever - the random inhabitant selected
	 * @return the new generated letter
	 */
	public Letter<?> makeLetter(Inhabitant reciever){
		Letter<?> simpleContentLetter = null;
		Letter<?> complexeLetter = null;
		
		// Choose the simple letter's type
		switch(random.nextInt(2)){
		// Simple letter
		case 0 :
			simpleContentLetter = new SimpleLetter(this, reciever, new TextContent("bla bla"));
			account.withdraw(1);
			break;
			
		// PromisoryNote letter
		case 1 :
			simpleContentLetter = new PromisoryNote(this, reciever, new MoneyContent(random.nextInt(this.getBalance())));
			break;
		}
		
		// Choose the encapsulated letter's type
		switch(random.nextInt(3)){
		// Registered letter
		case 0 :
			complexeLetter = new RegisteredLetter(this, reciever, simpleContentLetter);
			break;
			
		// Urgent letter
		case 1 :
			complexeLetter = new UrgentLetter(this, reciever, simpleContentLetter);
			break;
		
		case 2 :
			// Nothing more
			complexeLetter = simpleContentLetter;
			break;
		}
		
		return complexeLetter;
	}
	
	/**
	 * Send a letter from this inhabitant
	 * @param letter the letter sent
	 */
	public void sendLetter(Letter<?> letter) {
		account.withdraw(letter.getCost());
	}
	
	/**
	 * Receive the letter and do the action of the letter
	 * @param letter the letter who is received
	 */
	public void receiveLetter(Letter<?> letter) {
		recieveLetters.add(letter);
	}
	
	/**
	 * Get the city of this inhabitant
	 * @return the city of this inhabitant
	 */
	public City getCity() {
		return this.city;	
	}
	
	/**
	 * Get the name of this inhabitant
	 * @return the name of this inhabitant
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the amount of this inhabitant bank account
	 * @return the amount of this inhabitant bank account
	 */
	public int getBalance() {
		return this.account.getBalance();	
	}
	
	/**
	 * Remove amount to this inhabitant bank account
	 * @param amount the cost to removing in this inhabitant bank account
	 */
	public void withdraw(int amount) {
		this.account.withdraw(amount);
	}
	
	/**
	 * Add amount to this inhabitant bank account
	 * @param amount the cost to adding in this inhabitant bank account
	 */
	public void credit(int amount) {
		this.account.credit(amount);
	}

	/**
	 * @return the recieveLetters
	 */
	public ArrayList<Letter<?>> getRecieveLetters() {
		return recieveLetters;
	}

	/**
	 * @param recieveLetters the recieveLetters to set
	 */
	public void setRecieveLetters(ArrayList<Letter<?>> recieveLetters) {
		this.recieveLetters = recieveLetters;
	}
	
}

