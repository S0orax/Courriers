package entity;

import java.util.Random;

import content.MoneyContent;
import content.TextContent;

import letters.Letter;
import letters.PromisoryNote;
import letters.RegisteredLetter;
import letters.SimpleLetter;
import letters.UrgentLetter;

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
	}
	
	/**
	 * Generate a random letter to a random inhabitant
	 * @param reciever - the random inhabitant selected
	 * @return the new generated letter
	 */
	public Letter<?> makeLetter(Inhabitant reciever){
		Letter<?> newLetter = null;
		
		// Choose the letter's type
		switch(random.nextInt(4)){
		// Simple letter
		case 0 :
			newLetter = new SimpleLetter(this, reciever, new TextContent("bla bla"));
			break;
			
		// PromisoryNote letter
		case 1 :
			newLetter = new PromisoryNote(this, reciever, new MoneyContent(random.nextInt(this.getBalance())));
			break;
			
		// Registered letter
		case 2 :
			newLetter = new RegisteredLetter(this, reciever, null);
			
			break;
			
		// Urgent letter
		case 3 :
			newLetter = new UrgentLetter(this, reciever, null);
			
			break;
			
		default :
			break;
		}
		
		return newLetter;
	}
	
	/**
	 * Send a letter from this inhabitant
	 * @param letter the letter who is sent
	 */
	public void sendLetter(Letter<?> letter) {
		// TO DO
	}
	
	/**
	 * Receive the letter and do the action of the letter
	 * @param letter the letter who is received
	 */
	public void receiveLetter(Letter<?> letter) {
		// TO-DO
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
	
}

