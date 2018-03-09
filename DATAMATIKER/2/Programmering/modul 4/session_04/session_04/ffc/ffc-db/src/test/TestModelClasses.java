package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Breed;
import model.Dog;
import model.Member;

public class TestModelClasses {

	private Breed breed;
	private Dog dog;
	private Dog dog1;
	private Member member;
	private Member member1;
	
	@Before
	public void setUp() {
		breed = new Breed("Mudi", 33, "Another sheepdog");
		dog = new Dog("Arnold", 2016, breed);
		dog1 = new Dog("Bingo", 2015, breed);
		member = new Member("Charles", "charles@asdf.com", "11223344");
		member.addDog(dog1);
		member.addDog(dog1);
		member1 = new Member("Dogless Douglas", "douglas@asdf.com", "99887766");
		System.out.println(breed);
		System.out.println(dog);
		System.out.println(dog1);
		System.out.println(member);
		System.out.println(member1);
	}
	
	@Test
	public void testFeeYearFalse() {
		assertFalse(member1.isFeeDue());
	}
	
	@Test
	public void testFeeYearTrue() {
		assertTrue(member.isFeeDue());
	}
	
	//test more stuff

}
