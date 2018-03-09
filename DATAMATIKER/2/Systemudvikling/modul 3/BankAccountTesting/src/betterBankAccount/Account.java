package betterBankAccount;


public class Account {
	private int id;
	private double balance;
	

	public Account(int numberAccount, double startBal) {
		id= numberAccount;
		balance = startBal;
	}
	
	
	  /**
	   * Withdraw the amount from the account.
	   * Only amounts greater of equals to the balance
	   * can be withdrawn. 
	   * Maximum amount that can be withdrawn is 15.000 kr. 
	   * Minimun is 10 kr
	   * @param amount The amount to be withdrawn
	   * @return <code>true</code> if the amount is successfully withdrawn,'
	   * <code>false</code> otherwise
	   */	
	public boolean withdraw(double amount) {
		boolean res = false;
		if(amount <= balance && amount <= 15000) {
			balance -= amount;
			res = true;
		}
		return res;
	}
	
	  /**
	   * Deposit the amount to the account.
	   * Only positive amounts can be deposited.
	   * @param amount The amount to deposit in the account
	   * @return <code>true</code> if the amount is successfully deposited,
	   * <code>false</code> otherwise
	   */
	
	public boolean deposit(double amount) {
		if(amount < 0) {
			return withdraw(amount * -1);
		}
		balance += amount;
		return true;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getId() {
		return id;
	}

}
