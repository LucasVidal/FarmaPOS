package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cash {

	public enum Status
	{
		OPEN,CLOSED,NOT_STARTED;
	}
	
	private List<Movement> movements;

	private Double initialValue;
	private Double endedValue;
	private Status status;
	
	private Day day;
	private static Cash INSTANCE=null;
	
	public Day getDay() {
		return day;
	}

	public void registerPurchase(Double amount, Provider provider) {
		this.getMovements().add(new PurchaseMovement(amount, provider));
	}
	
	public void registerSell(Double amount,PayMethod payMethod) {
		
		this.getMovements().add(new SellMovement(amount, payMethod));
	}
	
	private List<Movement> getMovements() {
		return this.movements;
	}

	public void resetMovements() {
		this.movements=new ArrayList<Movement>();
	}

	public void setInitialValue(Double amount) {
		this.initialValue=amount;
	}

	public Double getGrossAmount() {
		Double gross=this.initialValue;
		
		for (Movement m : this.getMovements())
			gross+=m.getGrossValue();
		
		return gross;
	}

	public void close(Double cashAmount) {
		this.endedValue=cashAmount;
	}

	public Double getDifference()
	{
		return this.getGrossAmount()-this.endedValue;
	}

	public static Cash createCash(Date date) {
		Cash cash=new Cash();
		cash.initialValue=0.0;
		cash.resetMovements();
		cash.day=new Day(date);
		cash.status=Status.OPEN;
		return cash;
	}
}
