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
	
	/**
	 * Returns the gross amount for that item, negative if discounted. 
	 * */
	public Double getAmount()
	{
		return Math.signum(this.quantity) *this.price;
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
	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean canRemoveQantity(Double quantity) {
		return this.getQuantity()>=quantity;
	}

	public void removeQuantity(Double quantity) {
		Double p = this.price*(1-(quantity/this.quantity));

		this.price=Math.round(p*100.0)/100.0;
		
		this.quantity-=quantity;
	}
}
