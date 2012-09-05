package model;

public class SellMovement extends Movement {

	private PayMethod payMethod;

	public SellMovement(Double amount,PayMethod payMethod) {
		super();
		
		this.amount=amount;
		this.payMethod=payMethod;
	}

	@Override
	public Double getGrossValue() {
		return this.payMethod.equals(PayMethod.CASH) ? amount : new Double(0.0);
	}
	
}
