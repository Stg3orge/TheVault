package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

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
	
	@Test
	public void testCreate() {
		try {
			Dog d = dogDB.create("Rex", 2015, 3, 2);
			d = dogDB.findById(d.getId(), false);
			assertNotNull(d);
			assertNotNull(d.getBreed());
			assertEquals("Rex", d.getName());
			assertEquals(2015, d.getFeeYear());
			//assertEquals(3, d.getOWNER?!?!) 
			// TODO test correct owner when member class is done
			assertEquals(2, d.getBreed().getId());
			//...
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdate() {
		try {
			Dog d = dogDB.update(1, "Rex", 2015, 3, 2);
			assertNotNull(d);
			assertNotNull(d.getBreed());
			assertEquals("Rex", d.getName());
			assertEquals(2015, d.getFeeYear());
			//assertEquals(3, d.getOWNER?!?!) 
			// TODO test correct owner when member class is done
			assertEquals(2, d.getBreed().getId());
			//...
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test 
	public void testDelete() {
		try {
			dogDB.delete(1);
			assertNull(dogDB.findById(1, false));
		}
		catch(SQLException e) {
			fail();
		}
	}
	@Test 
	public void testFindAll() {
		try {
			List<Dog> res = dogDB.findAll();
			assertNotNull(res);
			assertEquals(3, res.size());
		}
		catch(SQLException e) {
			fail();
		}
	}
	@Test 
	public void testFindByMemberId() {
		try {
			List<Dog> res = dogDB.findByMemberId(2);
			assertNotNull(res);
			assertEquals(2, res.size()); // member 2 has 2 dogs.
		}
		catch(SQLException e) {
			fail();
		}
	}
	@Test 
	public void testFindByName() {
		try {
			List<Dog> res = dogDB.findByName("Balt");
			assertNotNull(res);
			assertEquals(1, res.size());
			assertEquals("Balto", res.get(0).getName());
		}
		catch(SQLException e) {
			fail();
		}
	}

}
