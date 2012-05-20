package suite;

import java.util.List;

import junit.framework.TestSuite;
import model.Comerce;
import model.Provider;
import model.Room;
import model.Table;

import org.junit.BeforeClass;

public class CashTestSuite extends TestSuite {

	
	private static List<Provider> providers;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initializeCash();
		initializeProviders();
	}

	private static void initializeProviders() {
		Comerce.addProvider(new Provider("Pablo"));
		Comerce.addProvider(new Provider("Coca-Cola"));
		Comerce.addProvider(new Provider("Quilmes"));
	}

	private static void initializeCash() {
	}
	
}
