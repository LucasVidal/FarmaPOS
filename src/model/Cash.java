package model;

import java.util.ArrayList;
import java.util.List;

public class Cash {

	private List<Movement> movements;
	
	private static Cash INSTANCE=null;
	public static Cash getInstance()
	{
		if (INSTANCE==null)
			INSTANCE=new Cash();
		
		return INSTANCE;
	}
	
	public void registerSell(Double amount,PayMethod payMethod) {
		
		List<Movement> movs= this.getInstance().getMovements();
		
		movs.add(new Movement(CashMovements.SELL, amount, payMethod));
	}

	private List<Movement> getMovements() {
		if (this.movements==null)
			this.movements=new ArrayList<Movement>();
		
		return this.movements;
	}

}
