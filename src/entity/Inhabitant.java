package entity;

import letters.Letter;

/**
 * Class to manage the inhabitant
 * @author dubois bellamy
 *
 */
public class Inhabitant
{
	private String name;
	private Account account;
	private City city;
	
	/**
	 * Constructor of a new Inhabitant
	 * @param city the city of this inhabitant
	 * @param name the name of this inhabitant
	 */
	public Inhabitant(City city, String name) {
		this.name = name;
		this.city = city;
		this.account = new Account(5000);
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
	public double getBalance() {
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

