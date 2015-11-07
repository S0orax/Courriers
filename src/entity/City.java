package entity;

import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * Get the name of this city
	 * @return the name of this city
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the post box of this city
	 * @return the post box of this city
	 */
	public List<Letter<?>> getPostBox() {
		return this.postbox;
	}
	
}

