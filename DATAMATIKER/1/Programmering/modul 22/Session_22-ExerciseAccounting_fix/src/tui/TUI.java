package tui;

import java.util.ArrayList;
import controller.AccountCtrl;
import libTUI.ConverterIF;
import libTUI.TextChoice;
import libTUI.TextInput;
import model.Account;
import model.Persistence;

public class TUI {
	private TextInput ti;
	private ConverterIF<Account> accountConverter; {
		ti = new TextInput();
		accountConverter = new ConverterIF<Account>() {
			@Override
			public String convertToString(Account a) {
				return a.getName() + " (" + a.getBalance() + ")";
			}
		};
	}

	public static void main(String[] args) {
		new TUI().run();
	}

	private void clear() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	public void run() {
		boolean goOn = true;

		while (goOn) {
			System.out.println("Options:\tNew account (n),\tList accounts (l),\tFind account (f),\n"
					+ "\t\tDeposit (d),\t\tWithdaw (w),\t\tTransfer (t),\n"
					+ " \t\tSave (S), \t\tLoad (L) \t\tQuit (q)");
			String choice = ti.promptString("Pick an action:");
			switch (choice) {
			case "n": // new
				createAccount();
				break;
			case "l": // list
				listAccounts();
				break;
			case "f": // find
				findAccount();
				break;
			case "d": // deposit
				deposit();
				break;
			case "w": // withdraw
				withdraw();
				break;
			case "t":// transfer
				transfer();
				break;
			case "S": // Save
				save();
				break;
			case "L": // Load
				load();
				break;
			case "q": // quit
				System.out.println("Exiting...");
				goOn = false;
				break;
			default:
				System.out.println("Sorry, no such command. Try again! (" + choice + ")");

			}
			System.out.println("\n");
		}
	}

	private void load() {
		System.out.println("Trying to load from default location...");
		try {
			new Persistence().load();
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println("Failed");
			reportException(e);
		}
	}

	private void save() {
		System.out.println("Trying to save to default locaton...");
		try {
			Persistence p = new Persistence();
			p.persist();
			System.out.println("Saving in " + (p.getSaveFile() != null ? p.getSaveFile().getAbsolutePath() : " ???"));
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println("Failed");
			reportException(e);
		}
	}

	private void transfer() {
		System.out.println("Transferring funds...");
		System.out.println("...from:");
		Account from = pickAccount();
		if (from == null) {
			canceled();
			return;
		}
		System.out.println("\n...to:");
		Account to = pickAccount();
		if (to == null) {
			canceled();
			return;
		}
		double amount = ti.promptDouble("\nAmount:");

		try {
			new AccountCtrl().transferFunds(from.getName(), to.getName(), amount);
			System.out.println("Success");
		} catch (Exception e) {
			reportException(e);
		}
	}

	private void withdraw() {
		System.out.println("Withdrawing from...");
		Account a = pickAccount();
		if (a == null) {
			canceled();
			return;
		}
		double amount = ti.promptDouble("Amount:");
		try {
			new AccountCtrl().withdrawFunds(a.getName(), amount);
			System.out.println("Success");
		} catch (Exception e) {
			reportException(e);
		}
	}

	private void deposit() {
		System.out.println("Deposit to...");
		Account a = pickAccount();
		if (a == null) {
			canceled();
			return;
		}
		double amount = ti.promptDouble("Amount:");
		try {
			new AccountCtrl().depositFunds(a.getName(), amount);
			System.out.println("Success");
		} catch (Exception e) {
			reportException(e);
		}
	}

	private void canceled() {
		System.out.println("Operation canceled");
	}

	private Account pickAccount() {
		boolean listWanted = ti.promptBoolean("Do you want to pick an account from a list?");
		Account account = null;
		if (listWanted) {
			TextChoice<Account> tc = getTextChoice();

			account = (Account)tc.promptChoice("Pick an account", "Select one:");
		} else {
			String name = ti.promptString("What account name:");
			account = new AccountCtrl().findByName(name);
		}
		return account;
	}

	private TextChoice<Account> getTextChoice() {
		TextChoice<Account> tc = new TextChoice<>(accountConverter);
		ArrayList<Account> accounts = new AccountCtrl().getAll();
		for (int i = 0; i < accounts.size(); i++) {
			tc.addOption(accounts.get(i));
		}
		return tc;
	}

	private void findAccount() {
		String name = ti.promptString("Type the account name you are looking for:");
		Account a = new AccountCtrl().findByName(name);
		displayAccount(a);
	}

	private void listAccounts() {
		ArrayList<Account> accounts = new AccountCtrl().getAll();
		for (int i = 0; i < accounts.size(); i++) {
			displayAccount(accounts.get(i));
		}
	}

	private void displayAccount(Account account) {
		System.out.println("Account: " + account.getName() + ",\tbalance: " + account.getBalance());
	}

	private void createAccount() {
		String name = ti.promptString("New account name:");
		double balance = ti.promptDouble("New account initial balance:");
		try {
			new AccountCtrl().createAccount(name, balance);
		} catch (Exception e) {
			reportException(e);
		}
	}

	private void reportException(Exception e) {
		System.out.println("Failed, message was: " + e.getMessage());
	}
}
