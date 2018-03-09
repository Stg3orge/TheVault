package model;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 7083109944997491854L;

	
	private String name;
	private double balance;
	
	public Account(String name, double balance) {
		// 2
		if(name == null) {
			throw new IllegalArgumentException("You can't create an account with no name");
		}
		
		//3
		if(balance < 0) {
			throw new IllegalArgumentException("You can't create an account with negative balance");			
		}
		
		this.name = name;		
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		// 1, 4
		if(amount > balance) {
			//throw new IllegalArgumentException("You are trying to withdraw too much money");
			throw new BalanceUnderrunException("You are trying to withdraw too much money");
		}
		
		this.balance -= amount;
	}
}
