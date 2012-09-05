package model;

public class PurchaseMovement extends Movement {

	private Provider provider;

	public PurchaseMovement(Double amount, Provider provider) {
		super();
		this.provider=provider;
		this.amount=amount;
	}

	@Override
	public Double getGrossValue() {
		return (-1) * this.amount;
	}

}
