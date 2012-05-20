package suite;

import junit.framework.TestSuite;
import model.Category;
import model.Item;
import model.KitchenPrinter;

import org.junit.BeforeClass;

public class MenuTestSuite extends TestSuite {

	private static KitchenPrinter kitchenPrinter1;

	private static Category root;
	private static Category minutas;
	private static Category bebidas;
	private static Category cervezas;
	private static Category sinAlcohol;
	private static Category cervezasImportadas;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initializeMenu();

		
	}

	public static void initializeMenu() {
		
		kitchenPrinter1 = new KitchenPrinter(); 
		
		createCategories();
		createItems();
	}

	private static void createItems() {
		minutas.addNewItem(new Item("Milanesa de carne",		9.5,	kitchenPrinter1));
		minutas.addNewItem(new Item("Milanesa de pollo",		8.0,	kitchenPrinter1));
		minutas.addNewItem(new Item("Fritas", 					1.5,	kitchenPrinter1));
		
		bebidas.addNewItem(new Item("Cafe",						8.0,	null));
		
		cervezas.addNewItem(new Item("Quilmes",					8.0,	null));
		cervezas.addNewItem(new Item("Heineken",				11.5,	null));
		cervezas.addNewItem(new Item("Stella Artois",			12.0,	null));
		
		cervezasImportadas.addNewItem(new Item("Negra Modelo",	12.0,	null));
		
		sinAlcohol.addNewItem(new Item("Coca-Cola",				9.5,	null));
		sinAlcohol.addNewItem(new Item("Agua saborizada",		7.0,	null));
	}

	private static void createCategories() {
		root = Category.getRootCategory();
		
		minutas = Category.createCategoryInRoot("Minutas");
		bebidas = Category.createCategoryInRoot("Bebidas");
		
		cervezas = Category.createCategoryInRoot("Cervezas");
		cervezas.changeParentTo(bebidas);
		
		sinAlcohol = Category.createCategoryInRoot("Sin Alcohol");
		sinAlcohol.changeParentTo(bebidas);
		
		cervezasImportadas = Category.createCategoryInRoot("Cervezas Importadas");
		cervezasImportadas.changeParentTo(cervezas);
	}

}
