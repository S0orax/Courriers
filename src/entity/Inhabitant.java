package entity;

import letters.Letter;


public class Inhabitant
{
	private String name;
	private Account account;
	private City city;

	public Inhabitant(City city, String name) {
		this.name = name;
		this.city = city;
		this.account = new Account(5000);
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

		return this.account.getBalance();	
	}
	
	public void withdraw(int amount) {

	}
	
	public void credit(int amount) {

	}
	
}

