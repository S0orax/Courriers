package entity;

import java.util.ArrayList;

import letters.Letter;

public class City
{
	private ArrayList<Letter<?>> postbox;
	private String name;
	
	public City(String name) {
		this.name = name;
		this.postbox = new ArrayList<Letter<?>>();
	}
	
	public void sendLetter(Letter<?> letters) {

	}
	
	public void distributeLetters() {

	}
	
}

