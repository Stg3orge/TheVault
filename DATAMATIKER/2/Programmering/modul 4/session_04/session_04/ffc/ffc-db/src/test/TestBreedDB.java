package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import db.BreedDB;
import db.BreedDBIF;
import model.Breed;

public class TestBreedDB {
	private BreedDBIF breedDB ;
	
	@Before
	public void setUp() {
		try {
			DBCleanup.cleanDB();
		}
		catch(Exception e) {
			throw new RuntimeException("Could not clean up the db");
		}
		breedDB = new BreedDB();
	}
	


	@Test
	public void testInsert() {
		Breed b = new Breed("Husky", 22, "A happy sledge dog");
		try {
			assertEquals(b.getId(), 0);
			Breed returnValue = breedDB.create(b);
			assertEquals(b.getName(), returnValue.getName());
			assertEquals(b.getDescription(), returnValue.getDescription());
			assertNotEquals(b.getId(), 0);
			System.out.println(b);
			System.out.println(returnValue);
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test public void testUpdate() {
		try {
			Breed b = breedDB.findById(1);
			b.setName("Husky");
			b.setDescription("A happy sledge dog");
			b.setMaxWeight(22);
			assertNotNull(breedDB.update(b));
			Breed b1 = breedDB.findById(1);
			assertEquals("Husky", b1.getName());
			assertEquals("A happy sledge dog", b1.getDescription());
			assertEquals(22, b1.getMaxWeight());
			assertEquals(1, b1.getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test public void testFindByName() {
		try {
			Collection<Breed> breeds = breedDB.findByName("Mal");
			int count = 0;;
			for(Breed b : breeds) {
				if(b.getName().equals("Alaskan Malamute")) {
					count++;
				}
			}
			assertEquals(1, count);
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testGetAll() {
		try {
			List<Breed> breeds = breedDB.getAll();
			assertTrue(breeds.size() == 3); // reset script only inserts 3 breeds
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
		
	}

}
