package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private int id;
	private String name;
	private String email;
	private String phone;
	private List<Dog> dogs;
	
	{
		dogs = new ArrayList<>();
	}
	
	public Member(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public Member() {
	
	}
	
	public void setDogs(List<Dog> dogs) {
		this.dogs.clear();
		this.dogs.addAll(dogs);
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public List<Dog> getDogs() {
		return dogs;
	}
	
	public void addDog(Dog dog) {
		// avoid hidden null values - only accept non-null dogs!
		if(dog != null) {
			this.dogs.add(dog);
		}
	}
	
	// derived property:
	public boolean isFeeDue() {
		boolean res = false;
		for(int i = 0 ; !res && i < dogs.size(); i++){
			if(dogs.get(i).isFeeDue()) {
				res = true;
			}
		}
		return res;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dogs=" + dogs + "]";
	}
	
	
	
}
