package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controller.BreedController;
import db.BreedDB;
import model.Breed;

public class TestBreedController {
	private BreedController breedCtr;
	@Before
	public void setUp() throws SQLException {
		DBCleanup.cleanDB();
		breedCtr = new BreedController();
	}
	
	@Test
	public void testCreateOK() {
		Breed b;
		try {
			b = breedCtr.create("Husky", "Such a lovely and happy Canis familiaris", 27);
			assertNotNull(b);
			assertEquals("Husky", b.getName());
			assertEquals("Such a lovely and happy Canis familiaris", b.getDescription());
			assertEquals(27, b.getMaxWeight());
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test 
	public void testDelete() {
		try {
			breedCtr.delete(1);
			Breed b = new BreedDB().findById(1);
			assertNull(b);
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testFindAll() {
		List<Breed> res;
		try {
			res = breedCtr.findAll();
			assertNotNull(res);
			assertEquals(3, res.size());
		} catch (SQLException e) {
			fail();
		}
	}
	
	@Test
	public void testFindById() {
		try {
			Breed b = breedCtr.findById(2);
			assertNotNull(b);
			assertEquals(2, b.getId());
			// TODO: assert all other attributes
		} catch (SQLException e) {
			fail();
		}
	}
	
	@Test
	public void testFindByName() {
		try {
			List<Breed> breeds = breedCtr.findByName("Elk");
			assertNotNull(breeds);
			assertEquals(1, breeds.size());
			assertTrue(breeds.get(0).getName().toLowerCase().contains("elk"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate() {
		Breed b;
		try {
			b = breedCtr.findById(1);
			b.setDescription("d");
			b.setMaxWeight(1);
			b.setName("n");
			breedCtr.update(b);
			b = breedCtr.findById(1);
			assertEquals("d", b.getDescription());
			assertEquals("n", b.getName());
			assertEquals(1, b.getMaxWeight());
		} catch (SQLException e) {
			fail();
		}
	
		
	}
}
