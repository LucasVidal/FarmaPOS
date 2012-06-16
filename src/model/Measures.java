package model;

public class Measures {
	private Integer x;
	private Integer y;
	private Integer width;
	private Integer height;
	
	
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public Measures(Integer x, Integer y, Integer width, Integer height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}

	public static Measures getDefaultLocation() {
		return new Measures(1,1,10,10);
	}
}
