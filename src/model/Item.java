package model;

public class Item {

	private String name;
	private Double price;
	private Category category;
	private AddingItemObserver addingObservers;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	public Item(String name, Double price, Category category,
			AddingItemObserver addingObservers) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.addingObservers = addingObservers;
	}

}
