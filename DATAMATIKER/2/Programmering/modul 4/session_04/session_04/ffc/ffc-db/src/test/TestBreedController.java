package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import controller.BreedController;
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
		Breed b = breedCtr.create("Husky", "Such a lovely and happy Canis familiaris", 27);
		assertNotNull(b);
		assertEquals("Husky", b.getName());
		assertEquals("Such a lovely and happy Canis Familiaris", b.getDescription());
		assertEquals(27, b.getMaxWeight());
	}

}
