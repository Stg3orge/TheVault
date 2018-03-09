package model;

public class Breed {
	private int id;
	private String name;
	private String description;
	private int maxWeight;
	
	public Breed(String name, int maxWeight, String description) {
		super();
		this.maxWeight = maxWeight;
		this.name = name;
		this.description = description;
	}
	
	public Breed() {
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public String toString() {
		return "Breed [id=" + id + ", name=" + name + ", description=" + description + ", maxWeight=" + maxWeight + "]";
	}

	
	
	
	
}
