package model;

public class Movement {

	private CashMovements movementType;
	private Double amount;
	private PayMethod payMethod;
	
	
	public Movement(CashMovements movementType, Double amount,
			PayMethod payMethod) {
		super();
		this.movementType = movementType;
		this.amount = amount;
		this.payMethod = payMethod;
	}
	
	
}
