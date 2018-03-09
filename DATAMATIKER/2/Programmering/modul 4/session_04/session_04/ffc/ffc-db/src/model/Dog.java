package model;

import java.time.LocalDate;

public class Dog {
	private int id;
	private String name;
	private int feeYear;
	private Breed breed;
		
	public Dog(String name, int feeYear, Breed breed) {
		super();
		this.name = name;
		this.feeYear = feeYear;
		this.breed = breed;
	}
	
	public Dog() {
		
	}

	// derived property
	public boolean isFeeDue() {
		LocalDate ld = LocalDate.now();
		int year = ld.getYear();
		return feeYear < year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFeeYear() {
		return feeYear;
	}

	public void setFeeYear(int feeYear) {
		this.feeYear = feeYear;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", feeYear=" + feeYear + ", breed=" + breed + ", isFeeDue()="
				+ isFeeDue() + "]";
	}
	
	

}
