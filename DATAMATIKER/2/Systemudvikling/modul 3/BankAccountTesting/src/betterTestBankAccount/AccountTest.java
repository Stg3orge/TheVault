package betterTestBankAccount;

import betterBankAccount.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import betterBankAccount.Account;

public class AccountTest {
	private Account a;
	private Account a16000;

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp()");
		a = new Account(1,3000d);
		a16000 = new Account(2,16000d);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown()");
	}

	@Test
	public void testRedraw() {
		System.out.println("testRedraw()");
		boolean result = a.withdraw(3000);
		assertTrue(result);
		double expBal = 0d;
		assertEquals(expBal, a.getBalance(), 0d);
	}

}
