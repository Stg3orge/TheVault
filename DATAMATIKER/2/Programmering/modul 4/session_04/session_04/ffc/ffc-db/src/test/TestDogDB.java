package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import db.DogDB;
import db.DogDBIF;
import model.Dog;

public class TestDogDB {
	private DogDBIF dogDB;
	
	@Before
	public void setUp() {
		try {
			DBCleanup.cleanDB();
		}
		catch(Exception e) {
			throw new RuntimeException("Could not clean up the db");
		}
		dogDB = new DogDB();
	}

	@Test
	public void testFindById() {
		try {
			Dog d = dogDB.findById(1, false);
			assertNotNull(d);
			assertNotNull(d.getBreed());
			assertNull(d.getBreed().getName());
			//...
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testFindByIdRetrieveAssociation() {
		try {
			Dog d = dogDB.findById(1, true);
			assertNotNull(d);
			assertNotNull(d.getBreed());
			assertNotNull(d.getBreed().getName());
			//...
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

}
