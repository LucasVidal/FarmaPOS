package model;

public class Measures {
	private Integer x;
	private Integer y;
	private Integer width;
	private Integer height;
	
	public Measures()
	{
		super();
		this.x=1;
		this.y=1;
		this.width=10;
		this.height=10;
	}
	
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
	public void setHeight(Integer height) {
		this.height = height;
	}
}
