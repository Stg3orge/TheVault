package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestDBConnection.class,
	TestBreedDB.class,
	TestDogDB.class,
	TestBreedController.class,
	TestMemberDB.class,
	TestMemberController.class
})

/**
 * This class contains only class level annotations. By adding the test class 
 * names to the suite you can all the test classes (incl. all the contained
 * tests) by simply executing the test suite. The class body is left empty.
 * You COULD sepcify a @BeforeClass and an @AfterClass method which would be run
 * before and after the entire suite (once per test suite)
 * 
 * @author knol
 * @version 2017-02-20
 */
public class TestSuite {


}
