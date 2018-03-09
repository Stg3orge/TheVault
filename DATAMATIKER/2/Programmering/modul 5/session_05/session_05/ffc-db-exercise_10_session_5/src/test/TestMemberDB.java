package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import db.BreedDB;
import db.DogDB;
import db.MemberDB;
import db.MemberDBIF;
import model.Dog;
import model.Member;

public class TestMemberDB {
	private MemberDBIF memberDB;
	
	@Before
	public void setUp() throws Exception {
		try {
			DBCleanup.cleanDB();
		}
		catch(Exception e) {
			throw new RuntimeException("Could not clean up the db");
		}
		memberDB = new MemberDB();
	}

	@Test
	public void testCreate() throws SQLException {
		Member m = memberDB.create("Joe", "joe@", "123");
		assertNotNull(m);
		assertEquals("Joe", m.getName());
		assertEquals("joe@", m.getEmail());
		assertEquals("123", m.getPhone());
	}

	@Test
	public void testUpdate() throws SQLException {
		Member m = memberDB.update(1, "Joe", "joe@", "123");
		assertNotNull(m);
		assertEquals("Joe", m.getName());
		assertEquals("joe@", m.getEmail());
		assertEquals("123", m.getPhone());
	}

	@Test
	public void testDelete() throws SQLException {
		boolean res = memberDB.delete(1);
		assertTrue(res);
		Member m = memberDB.findById(1, false);
		assertNull(m);
	}

	@Test
	public void testFindById() throws SQLException {
		Member m = memberDB.findById(3, false);
		assertNotNull(m);
		assertEquals(3, m.getId());
		assertEquals("Banana Joe", m.getName());
		assertEquals("joe@banana-island.com", m.getEmail());
		assertEquals("648484", m.getPhone());
		assertEquals(0, m.getDogs().size());
	}

	@Test
	public void testFindAll() throws SQLException {
		List<Member> res = memberDB.findAll();
		assertNotNull(res);
		assertEquals(3, res.size());
	}

	@Test
	public void testRemoveDog() throws SQLException {
		memberDB.removeDog(2, 2);
		List<Dog> dogs = new DogDB().findByMemberId(2);
		assertNotNull(dogs);
		assertEquals(1, dogs.size());
		assertEquals("Lia", dogs.get(0).getName());
	}

}
