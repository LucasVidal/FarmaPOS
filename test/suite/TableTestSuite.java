package suite;

import junit.framework.TestSuite;
import model.Commerce;
import model.Room;
import model.Table;

import org.junit.BeforeClass;

import controller.TableBuilder;

public class TableTestSuite extends TestSuite {

	protected static Room room1;
	protected static Room room2;
	protected static Room room3;

	protected static Table t1;
	protected static Table t3;
	protected static Table t2;
	protected static Table t4;
	protected static Table t10;
	protected static Table t11;
	protected static Table t12;
	protected static Table t21;
	protected static Table t22;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initializeRooms();
		initializeTables();
	}

	private static void initializeRooms() {
		room1=new Room("Sala 1");
		room2=new Room("Sala 2");
		room3=new Room("Sala 3");
		
		Commerce.getInstance().getRooms().add(room1);
		Commerce.getInstance().getRooms().add(room2);
		Commerce.getInstance().getRooms().add(room3);
	}
	
	private static void initializeTables()
	{
		t1 = 	new TableBuilder().withName("1").build();
		t2 = 	new TableBuilder().withName("2").build();
		t3 = 	new TableBuilder().withName("3").build();
		t4 = 	new TableBuilder().withName("4").build();
		room1.addTables(t1,t2,t3,t4);
		
		t10 = 	new TableBuilder().withName("10").build();
		t11 = 	new TableBuilder().withName("11").build();
		t12 = 	new TableBuilder().withName("12").build();
		room2.addTables(t10,t11,t12);
		
		t21 = 	new TableBuilder().withName("21").build();
		t22 = 	new TableBuilder().withName("22").build();
		room3.addTables(t21,t22);
	}
}
