package test;

import static org.junit.Assert.*;

import org.junit.Test;

import db.DBConnection;

public class TestDBConnection {

	@Test
	public void testDBConnection() {
		try {
			assertNotNull(DBConnection.getInstance().getConnection());
		}
		catch(Exception e) {
			fail();
		}
	}

}
