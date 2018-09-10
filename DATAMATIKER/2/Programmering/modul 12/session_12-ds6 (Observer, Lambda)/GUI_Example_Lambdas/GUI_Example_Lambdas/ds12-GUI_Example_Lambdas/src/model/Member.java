package model;

public class Member {
	private int id;
	private String name;
	private int since;
	
	public int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSince() {
		return since;
	}
	public void setSince(int since) {
		this.since = since;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", since=" + since + "]";
	}
	
	
	
}
