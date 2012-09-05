package suite;

import static org.junit.Assert.*;

import model.*;

import org.junit.Before;
import org.junit.Test;

import controller.TableBuilder;

import exceptions.CantSubstractThatQuantityException;
import exceptions.CouldNotChargeException;
import exceptions.CouldNotOpenTableException;
import exceptions.NotAllowedOperationException;
import exceptions.TableIsNotChargingException;
import exceptions.TableIsNotOpenException;

public class TableOperationsTest extends TableTestSuite{

	
	private Table freeTable;
	private Room localRoom;
	private KitchenPrinter impresora;
	private Item milanga;
	private Item cervecita;
	
	@Before
	public void initTables()
	{
		localRoom = new Room("Salon loco");
		freeTable=new TableBuilder().withName("freeTable").build();
		localRoom.addTables(freeTable);
		
		impresora = new KitchenPrinter();
		
		milanga = new Item("Milanesa de pollo",10.0,impresora);
		cervecita = new Item("Quilmes cristal",22.0);
	}

	@Test
	public void initializingTest()
	{
		assertEquals(3,Commerce.getInstance().getRooms().size());
		
		assertEquals(4,room1.getTables().size());
		assertEquals(3,room2.getTables().size());
		assertEquals(2,room3.getTables().size());
		
		assertEquals(room3, t21.getRoom());
	}
	
	@Test
	public void cashierCanOpenATable() {
		try {
			freeTable.open();
		} catch (CouldNotOpenTableException e) {
			fail("Failed: "+e.getMessage());
		}
		assertTrue(freeTable.isOpen());
	}
	
	@Test(expected = CouldNotOpenTableException.class)
	public void cashierCantOpenATable() throws CouldNotOpenTableException
	{
		freeTable.setState(new OpenState());
		freeTable.open();
	}
	
	@Test
	public void cashierClosesATableWithCashSuccessfullyTest() throws CouldNotOpenTableException, CouldNotChargeException, TableIsNotChargingException 
	{
		freeTable.open();
		assertTrue(freeTable.isOpen());
		
		freeTable.charge();
		freeTable.close(PayMethod.CASH);
		
		assertFalse(freeTable.isOpen());
	}

	@Test
	public void cashierClosesATableWithDebitCardSuccessfullyTest() throws CouldNotOpenTableException, CouldNotChargeException, TableIsNotChargingException  
	{
		t2.setState(new FreeState());
		t2.open();
		assertTrue(t2.isOpen());
		
		t2.charge();
		t2.close(PayMethod.DEBIT_CARD);
		
		assertFalse(t2.isOpen());
	}
	
	@Test
	public void addAnItemToATableTest() throws TableIsNotOpenException, CouldNotOpenTableException
	{
		freeTable.open();
		freeTable.addItem(milanga, 2.0);
		
		assertEquals(new Double(milanga.getPrice() * 2.0),freeTable.getAmount());
		
		//Test log occurrence
		assertEquals(1, freeTable.getActionsLog().size());
	}
	
	
	@Test
	public void parciallyRemoveItemFromTableTest() throws CouldNotOpenTableException, TableIsNotOpenException, CantSubstractThatQuantityException
	{
		milanga.setPrice(10.0);

		freeTable.open();
		freeTable.addItem(milanga, 1.0);
		freeTable.addItem(milanga, 3.0);
		
		freeTable.removeItem(milanga, 2.0);
		
		assertEquals(new Double(20.0), freeTable.getAmount());
		assertEquals(3, freeTable.getActionsLog().size());
	}
	
	
	@Test
	public void totallyRemoveItemFromTableTest() throws CouldNotOpenTableException, TableIsNotOpenException, CantSubstractThatQuantityException
	{
		milanga.setPrice(10.0);

		freeTable.open();
		freeTable.addItem(milanga, 2.0);
		freeTable.addItem(milanga, 1.0);
		
		freeTable.removeItem(milanga, 3.0);
		
		assertEquals(new Double(0.0),freeTable.getAmount());
		assertEquals(3, freeTable.getActionsLog().size());
	}
	
	@Test(expected=CantSubstractThatQuantityException.class)
	public void removeInexistentItemFromTableFailsTest() throws CouldNotOpenTableException, TableIsNotOpenException, CantSubstractThatQuantityException
	{
		freeTable.open();
		freeTable.addItem(milanga, 2.0);
		freeTable.addItem(milanga, 1.0);
		
		freeTable.removeItem(cervecita,1.0);
	}
	
	@Test(expected=CantSubstractThatQuantityException.class)
	public void removeMoreThanTheTableHaveForOneItemFailsTest() throws CouldNotOpenTableException, TableIsNotOpenException, CantSubstractThatQuantityException
	{
		freeTable.open();
		freeTable.addItem(milanga, 2.0);
		freeTable.addItem(milanga, 1.0);
		
		freeTable.removeItem(milanga,4.0);
	}
}