package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.HorribleException;
import model.Group;

public class TestGroupDB {

	@Before
	public void setUp() throws Exception {
		DBCleanup.cleanDB();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
//		try {
//			List<Group> gs = new GroupDB().findAll();
//			assertEquals(2, gs.size());
//		} catch (HorribleException e) {
//			fail();
//			e.printStackTrace();
//		}
	}

}
