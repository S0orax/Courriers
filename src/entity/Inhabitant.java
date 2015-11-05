package entity;

import letters.Letter;


public class Inhabitant
{
	private String name;
	private Account account;
	private City city;

	public Inhabitant(String name) {
		this.name = name;
	}
	
	public void sendLetter(Letter<?> letter) {
	
	}
	
	public void receiveLetter(Letter<?> letter) {

	}
	
	public City getCity() {
		return this.city;	
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getBalance() {

		return 0.0;	
	}
	
	public void withdraw(int amount) {

	}
	
	public void credit(int amount) {

	}
	
}

