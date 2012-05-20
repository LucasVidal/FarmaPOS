package suite;

import junit.framework.TestSuite;
import model.Comerce;
import model.Room;
import model.Table;

import org.junit.BeforeClass;

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
		
		Comerce.getRooms().add(room1);
		Comerce.getRooms().add(room2);
		Comerce.getRooms().add(room3);
	}
	
	private static void initializeTables()
	{
		t1 = 	new Table("1");
		t2 = 	new Table("2");
		t3 = 	new Table("3");
		t4 = 	new Table("4");
		room1.addTables(t1,t2,t3,t4);
		
		t10 = 	new Table("10");
		t11 = 	new Table("11");
		t12 = 	new Table("12");
		room2.addTables(t10,t11,t12);
		
		t21 = 	new Table("21");
		t22 = 	new Table("22");
		room3.addTables(t21,t22);
	}
}
