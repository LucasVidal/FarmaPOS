package suite;

import static org.junit.Assert.*;
import model.ChargingState;
import model.Comerce;
import model.FreeState;
import model.OpenState;
import model.PayMethod;

import org.junit.Test;

import exceptions.CouldNotOpenTableException;

public class TableOperationsTest extends TableTestSuite{

	

	@Test
	public void initializingTest()
	{
		assertEquals(3,Comerce.getRooms().size());
		
		assertEquals(4,room1.getTables().size());
		assertEquals(3,room2.getTables().size());
		assertEquals(2,room3.getTables().size());
		
		assertEquals(room3, t21.getRoom());
	}
	
	@Test
	public void cashierCanOpenATable() {
		t1.setState(new FreeState());
		try {
			t1.open();
		} catch (CouldNotOpenTableException e) {
			fail("Failed: "+e.getMessage());
		}
		assertTrue(t1.isOpen());
	}
	
	@Test(expected = CouldNotOpenTableException.class)
	public void cashierCantOpenATable() throws CouldNotOpenTableException
	{
		t1.setState(new OpenState());
		t1.open();
	}
	
	@Test
	public void cashierClosesATableWithCashSuccessfullyTest() throws CouldNotOpenTableException
	{
		t2.setState(new FreeState());
		t2.open();
		assertTrue(t2.isOpen());
		
		t2.close(PayMethod.CASH);
		
		assertFalse(t2.isOpen());
	}

	@Test
	public void cashierClosesATableWithDebitCardSuccessfullyTest() throws CouldNotOpenTableException
	{
		t2.setState(new FreeState());
		t2.open();
		assertTrue(t2.isOpen());
		
		t2.close(PayMethod.DEBIT_CARD);
		
		assertFalse(t2.isOpen());
	}
}