package model;

import java.util.ArrayList;
import java.util.List;

public class Item {

	private String name;
	private Double price;
	private Category category;
	private List<AddingItemObserver> addingObservers;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Item(String name,  Double price,
			AddingItemObserver ... addingObservers) {
		super();
		this.name = name;
		this.price = price;
		this.category = Category.getRootCategory();
		
		this.addingObservers = new ArrayList<AddingItemObserver>();
		for (AddingItemObserver ao : addingObservers)
			this.addingObservers.add(ao);
	}
	
	/*public Item(String name, Double price)
	{
		//this(name,price);
	}*/
	
	public void notifyItemAdded(ItemOnTable iot) {
		for (AddingItemObserver ao : this.addingObservers)
			ao.notifyItemAdded(iot);
	}
	
	@Override
	public boolean equals(Object otherItem)
	{
		if (otherItem == null) return false;
	    if (otherItem == this) return true;
		if (!(otherItem instanceof Item)) return false;
	    
		return this.getId().equals(((Item) otherItem).getId());
	}
	
	
	private String getId() {
		//TODO: Temporary. Will take ID from database
		return this.getName();
	}
}