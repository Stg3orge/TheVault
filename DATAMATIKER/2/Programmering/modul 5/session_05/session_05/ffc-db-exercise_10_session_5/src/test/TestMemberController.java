package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.MemberController;
import db.DogDB;
import db.MemberDB;
import model.Member;

public class TestMemberController {
	private MemberController memberController;

	@Before
	public void setUp() throws Exception {
		try {
			DBCleanup.cleanDB();
		}
		catch(Exception e) {
			throw new RuntimeException("Could not clean up the db");
		}
		memberController = new MemberController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateMemberAndDog() {
		String mName, phone, email, dName;
		int feeYear, breedId;
		mName = "Arnold";
		phone = "7777-7777";
		email = "arnold@7777.com";
		dName = "Superfido";
		feeYear = 2017;
		breedId = 1;
		try {
			Member m = memberController.createMemberAndDog(mName, phone, email, dName, feeYear, breedId);
			assertNotNull(m);
			assertNotNull(m.getDogs());
			assertNotNull(m.getDogs().get(0));
			assertNotNull(m.getDogs().get(0).getBreed());
			assertEquals(mName, m.getName());
			assertEquals(phone, m.getPhone());
			assertEquals(email, m.getEmail());
			assertEquals(dName, m.getDogs().get(0).getName());
			assertEquals(feeYear, m.getDogs().get(0).getFeeYear());
			assertEquals(breedId, m.getDogs().get(0).getBreed().getId());
		} catch (SQLException e) {
			fail();
			e.printStackTrace();
		}
		catch(Exception x) {
			fail("Unexepected exception " + x.getClass().getName());
		}
	}
	
	@Test
	public void testCreateMemberAndDogFail() throws SQLException {
		String phone, email, dName;
		int feeYear, breedId;
		String mName = "Arnold";
		phone = "7777-7777";
		email = "arnold@7777.com";
		dName = "Superfido";
		feeYear = 2017;
		breedId = 777;
		try {
			Member m = memberController.createMemberAndDog(mName, phone, email, dName, feeYear, breedId);
			fail();
		} catch (SQLException e) {
			assertTrue(true);
		}
		assertFalse(new MemberDB().findAll().stream().anyMatch(m -> m.getName().equals(mName)));
		assertFalse(new DogDB().findAll().stream().anyMatch(d -> d.getName().equals(dName)));
		//assertTrue( new MemberDB().findAll().stream().anyMatch(m -> m.getName().equals("Banana Joe")));
		System.out.println("testCreateMemberAndDogFail end");
	}

}
