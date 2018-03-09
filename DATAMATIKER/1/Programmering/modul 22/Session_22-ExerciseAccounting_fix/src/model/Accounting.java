package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Accounting implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Accounting instance;
	private ArrayList<Account> accounts;

	private Accounting() {
		accounts = new ArrayList<>();
	}

	public static Accounting getInstance() {
		if (instance == null) {
			instance = new Accounting();
		}
		return instance;
	}

	public void addAccount(Account account) {
		if (account != null) {
			if (findByName(account.getName()) == null) {
				accounts.add(account);
			} else {
				throw new DuplicateAccountNameException("Account with this name already exists");
			}
		}
	}

	public Account findByName(String name) {
		Account currAccount = null;
		for (int i = 0; i < accounts.size(); i++) {
			currAccount = accounts.get(i);
			if (currAccount.getName().equals(name)) {
				return currAccount;
			}
		}
		return null;
	}

	public ArrayList<Account> getAll() {
		// this copies the arraylist, s.t. we maintain information hiding wrt. the
		// arraylist in the container
		return new ArrayList<Account>(this.accounts);
	}
}
