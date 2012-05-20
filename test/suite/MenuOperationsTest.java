package suite;
import static org.junit.Assert.*;

import javax.xml.ws.ServiceMode;

import model.Category;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MenuOperationsTest {
	

	@BeforeClass
	public static void setUp()
	{		
		
		Category root = Category.getRootCategory();
		
		
		Category minutas = Category.createCategoryInRoot("Minutas");
		Category bebidas = Category.createCategoryInRoot("Bebidas");
		
		Category cervezas = Category.createCategoryInRoot("Cervezas");
		cervezas.changeParentTo(bebidas);
		
		Category gaseosas = Category.createCategoryInRoot("Gaseosas");
		gaseosas.changeParentTo(bebidas);
		
		Category cervezasImportadas = Category.createCategoryInRoot("Cervezas Importadas");
		cervezasImportadas.changeParentTo(cervezas);
		

		assertEquals("ROOT", root .getName());
		assertEquals(2, root.getChildren().size());
		assertEquals(2, bebidas.getChildren().size());
		assertEquals(1, cervezas.getChildren().size());
		
		System.out.println ("setup ended. \nCategories\n"+root.getStringTree());
	}
	
	@Test
	public void addItemTest()
	{
		assertEquals(2, Category.getRootCategory().getChildren().size());
		assertTrue(true);		
	}
}
