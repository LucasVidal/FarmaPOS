package model;

public class KitchenPrinter implements AddingItemObserver {

	@Override
	public void notifyItemAdded(ItemOnTable iot) {
		System.out.print("Printing in kitchens printer: ("+iot.getQuantity()+") "+iot.getItem().getName());
	}

}
