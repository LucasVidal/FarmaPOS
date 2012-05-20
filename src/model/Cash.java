package model;

import java.util.ArrayList;
import java.util.List;

public class Cash {

	private List<Movement> movements;

	private Double initialValue;
	
	private static Cash INSTANCE=null;
	
	public void registerPurchase(Double amount, Provider provider) {
		this.getMovements().add(new PurchaseMovement(amount, provider));
	}
	
	public void registerSell(Double amount,PayMethod payMethod) {
		
		this.getMovements().add(new SellMovement(amount, payMethod));
	}

	public static Cash getInstance()
	{
		if (INSTANCE==null)
		{
			INSTANCE=new Cash();
			INSTANCE.initialValue=0.0;
		}
		
		return INSTANCE;
	}
	
	private List<Movement> getMovements() {
		if (this.movements==null)
			this.resetMovements();
		
		return this.movements;
	}

	public void resetMovements() {
		this.movements=new ArrayList<Movement>();
	}

	public void setInitialValue(Double amount) {
		this.initialValue=amount;
	}

	public Double getGrossAmount() {
		Double gross=0.0;
		
		for (Movement m : this.getMovements())
			gross+=m.getGrossValue();
		
		return gross;
	}


}
