package betterBankAccount;

import java.util.ArrayList;
import java.util.List;



public class Bank {
	
	private List<Account> accounts;
	
	
	public Bank()
	{
		accounts = new ArrayList<Account>();
	}
	
	public void addAccount(Account a) {
		if (a!= null)
		accounts.add(a);
	}
	
	public Account findById(int id) {
		Account res = null;
		for(int i = 0 ; i < accounts.size() && res == null; i++) {
			if(accounts.get(i).getId() == id) {
				res = accounts.get(i);
			}
		}
		return res;
	}
	
	public boolean transfer(double amount, Account a, Account b) {

		boolean resultWithdraw = a.withdraw(amount);
		boolean resultDeposit = b.deposit(amount);
		
		return (resultWithdraw && resultDeposit);
	}

}
