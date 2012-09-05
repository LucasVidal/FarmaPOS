package suite;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import model.Cash;
import model.Commerce;
import model.Item;
import model.PayMethod;
import model.Provider;
import model.Table;

import org.junit.Before;
import org.junit.Test;

import controller.TableBuilder;
import exceptions.CantSubstractThatQuantityException;
import exceptions.CouldNotChargeException;
import exceptions.CouldNotOpenTableException;
import exceptions.NotAllowedOperationException;
import exceptions.TableIsNotChargingException;
import exceptions.TableIsNotOpenException;


public class CashOperationsTest extends CashTestSuite{

	//private Object freeTable;

	private Table freeTable;
	private Item milanga;
	private Commerce commerce;
	private Cash cash;
	
	@Before
	public void initComponents()
	{
		cash = Commerce.getInstance().getCurrentCash();
		commerce = Commerce.getInstance();
		commerce.resetDay();
		
		milanga = new Item("Milanesa",10.0);
	}
	
	
	@Test
	public void initializationTest()
	{
		assertEquals(3,Commerce.getInstance().getProviders().size());
	}
	
	@Before
	public void clearCashHistory()
	{
		Commerce.getInstance().getCurrentCash().resetMovements();
		Commerce.getInstance().getCurrentCash().setInitialValue(0.0);
	}
	
	@Test
	public void registerPurchaseTest()
	{
		Commerce.getInstance().getCurrentCash().registerPurchase(98.0, 	Commerce.getInstance().getProviders().get(0));
		Commerce.getInstance().getCurrentCash().registerPurchase(12.0, 	Commerce.getInstance().getProviders().get(1));
		
		assertEquals(new Double(-110.0),Commerce.getInstance().getCurrentCash().getGrossAmount());
	}
	
	@Test
	public void movementsTest()
	{
		Commerce.getInstance().getCurrentCash().registerPurchase(20.0, 	Commerce.getInstance().getProviders().get(0));
		Commerce.getInstance().getCurrentCash().registerSell(50.0, PayMethod.CASH);
		
		assertEquals(new Double(30.0),Commerce.getInstance().getCurrentCash().getGrossAmount());
	}
	
	@Test
	public void agregatedServicesTest() throws CouldNotOpenTableException, TableIsNotOpenException, CantSubstractThatQuantityException, CouldNotChargeException, TableIsNotChargingException
	{	
		try {
			cash= populateCash(cash);
		} catch (NotAllowedOperationException e) {
			fail(e.getMessage());
		}
		
		for (Table m :commerce.getTodaysTables())
				System.out.println(m.getAmount());
		
		assertEquals(3, commerce.getTodaysTables().size());
	}
	
	@Test
	public void closeCashTest()
	{
		cash=Cash.createCash(new Date());
		cash.registerPurchase(20.0, 	Commerce.getInstance().getProviders().get(0));
		cash.registerSell(50.0, PayMethod.CASH);
		
		cash.close(1000.0);
		
		assertEquals(new Double(-1000.0+30.0),cash.getDifference());
	}
	
	public Cash populateCash(Cash c) throws NotAllowedOperationException
	{
		milanga.setPrice(10);
		Table t1 = new TableBuilder().withName("t1").build();
	
		t1.open();
		t1.addItem(milanga, 2);
		t1.addItem(milanga, 3);
		t1.removeItem(milanga, 1);													// +40 pé
		
		t1.charge();
		t1.close(PayMethod.CASH);
		
		t1 = new TableBuilder().withName("t1").build();
		t1.open();
		t1.addItem(milanga, 1);														// +10 pé
		
		t1.charge();
		t1.close(PayMethod.CASH);
		
		t1 = new TableBuilder().withName("t1").build();
		t1.open();
		t1.addItem(milanga, 1);														// no suma pé porque es con tarjeta
		
		t1.charge();
		t1.close(PayMethod.CREDIT_CARD);
		
		assertEquals(new Double(50.0),cash.getGrossAmount());
		
		c.registerPurchase(25.0, new Provider("Who cares which provider :)"));	// -25 pé
		
		return c;
	}
}