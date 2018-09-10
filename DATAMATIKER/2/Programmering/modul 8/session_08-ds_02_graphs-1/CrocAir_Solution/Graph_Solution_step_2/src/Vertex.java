
public class Vertex {
	private boolean mark;
	private String name;
	
	public Vertex(String name) {
		this.name = name;
		this.mark = false;
	}

	public String getName() {
		return name;
	}
	
	public boolean isMarked() {
		return mark;
	}
	
	public void setMarked(boolean mark) {
		this.mark = mark;
	}

}
