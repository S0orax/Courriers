package entity;

/**
 * Class to manage a bank account
 * @author dubois bellamy
 *
 */
public class Account{
	private int balance;
	
	/**
	 * Constructor of a new bank account
	 * @param balance the initial price of this account
	 */
	public Account(int balance) {
		this.balance = balance;
	}
	
	/**
	 * Get the amount of this account
	 * @return the amount of this account
	 */
	public int getBalance() {
		return this.balance;	
	}
	
	/**
	 * Remove amount to this account balance
	 * @param amount the cost to removing
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	
	/**
	 * Add amount to this account balance
	 * @param amount the cost to adding
	 */
	public void credit(double amount) {
		this.balance += amount;
	}
	
}

