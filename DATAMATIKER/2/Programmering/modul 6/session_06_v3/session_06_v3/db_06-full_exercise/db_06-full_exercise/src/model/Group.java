package model;

public class Group {
	private int id;
	private String name;
	private String description;
	public Group(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Group) {
			return ((Group)o).getId() == this.id;
		}
		return false;
	}
	
}
