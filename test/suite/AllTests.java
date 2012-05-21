package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CashOperationsTest.class, MenuOperationsTest.class,
		TableOperationsTest.class })
public class AllTests {

}
