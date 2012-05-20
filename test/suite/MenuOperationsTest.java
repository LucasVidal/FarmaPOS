package suite;
import static org.junit.Assert.*;

import javax.xml.ws.ServiceMode;

import model.Category;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MenuOperationsTest extends MenuTestSuite{
	
	@Test
	public void addItemTest()
	{
		assertEquals(2, Category.getRootCategory().getChildren().size());
		assertTrue(true);
	}
}
