package suite;
import static org.junit.Assert.assertEquals;
import model.Cash;
import model.Comerce;
import model.PayMethod;

import org.junit.Before;
import org.junit.Test;


public class CashOperationsTest extends CashTestSuite{
	
	@Test
	public void initializationTest()
	{
		assertEquals(3,Comerce.getProviders().size());
	}
	
	@Before
	public void clearCashHistory()
	{
		Cash.getInstance().resetMovements();
		Cash.getInstance().setInitialValue(0.0);
	}
	
	@Test
	public void registerPurchaseTest()
	{
		Cash.getInstance().registerPurchase(98.0, 	Comerce.getProviders().get(0));
		Cash.getInstance().registerPurchase(12.0, 	Comerce.getProviders().get(1));
		
		assertEquals(new Double(-110.0),Cash.getInstance().getGrossAmount());
	}
	
	@Test
	public void movementsTest()
	{
		Cash.getInstance().registerPurchase(20.0, 	Comerce.getProviders().get(0));
		Cash.getInstance().registerSell(50.0, PayMethod.CASH);
		
		assertEquals(new Double(30.0),Cash.getInstance().getGrossAmount());
	}
	
	
}
