package model;

public class ItemOnTable {
	private Item item;
	private Double quantity;
	private Double price;

	
	
	public ItemOnTable(Item item, Double quantity, Double price) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
