package controller;

import java.util.ArrayList;

import model.Account;
import model.Accounting;
import model.BalanceUnderrunException;

public class AccountCtrl {
	public void depositFunds(String accountName, double amount) {
		Account account = Accounting.getInstance().findByName(accountName);
		account.deposit(amount);
	}

	public void withdrawFunds(String accountName, double amount) {
		Account account = Accounting.getInstance().findByName(accountName);
		account.withdraw(amount);
	}

	public void transferFunds(String from, String to, double amount) {
		try {
			withdrawFunds(from, amount);
			depositFunds(to, amount);
		} catch (Exception e) {
			throw new BalanceUnderrunException("You can't transfer this many monies");
		}
	}

	public void createAccount(String name, double initialBalance) {
		Account account = new Account(name, initialBalance);
		Accounting.getInstance().addAccount(account);
	}

	public ArrayList<Account> getAll() {
		return Accounting.getInstance().getAll();
	}

	public Account findByName(String name) {
		return Accounting.getInstance().findByName(name);
	}

}
