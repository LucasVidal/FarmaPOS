package suite;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import model.Category;

import org.junit.Test;


public class MenuOperationsTest extends MenuTestSuite{
	
	@Test
	public void dumbTest()
	{
		System.out.println(Category.getRootCategory().getStringTree());
		assertEquals(2, Category.getRootCategory().getChildren().size());
		assertTrue(true);
	}
}
