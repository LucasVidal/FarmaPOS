package db.xml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.Category;
import model.Item;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import common.Log;

public class XMLMenuParser {

	public static final String MENU_FILE = "carta.xml";

	public void parseMenu() {
		try {

			File fXmlFile = new File(MENU_FILE);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			Element root = doc.getDocumentElement();
			System.out.println("Root element :" + root.getNodeName());
			NodeList nList = root.getChildNodes();
			System.out.println("-----------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					System.out.println("Parsing "
							+ nNode.getNodeName()
							+ " - "
							+ nNode.getAttributes().getNamedItem("nombre")
									.getTextContent());

					if (nNode.getNodeName().toUpperCase()
							.equals(Category.NodeName))
						parseCategory(null, nNode);
					else if (nNode.getNodeName().toUpperCase()
							.equals(Item.NodeName))
						Category.getRootCategory().addNewItem(parseItem(nNode));

				}
			}
		} catch (Exception e) {
			Log.error(e);
		}

	}
	
	public Item parseItem(Node node)
	{
		String name = node.getAttributes().getNamedItem(Item.ATTRIBUTE_NAME_NAME).getTextContent();
		Double price = new Double(node.getAttributes().getNamedItem(Item.ATTRIBUTE_PRICE_NAME).getTextContent());
		return new Item(name, price);
	}
	
	public Category parseCategory(Category parent, Node node)
	{
		String name = node.getAttributes().getNamedItem(Category.ATTRIBUTE_NAME_NAME).getTextContent();
		Category cat; 
		if (null == parent)
			cat= Category.createCategoryInRoot(name);
		else
			cat= new Category(parent,new ArrayList<Category>(),name);
			
		for (int temp = 0; temp < node.getChildNodes().getLength(); temp++) {
	 
			   Node childNode = node.getChildNodes().item(temp);
			   if (childNode.getNodeType() == Node.ELEMENT_NODE) {
					 
				      System.out.println("Parsing "+childNode.getNodeName()+ " - "+ childNode.getAttributes().getNamedItem("nombre").getTextContent());
				      
				      if (childNode.getNodeName().toUpperCase().equals(Category.NodeName))
				    	  cat.getChildren().add(parseCategory(null, childNode));
				      else if (childNode.getNodeName().toUpperCase().equals(Item.NodeName))
				    	  cat.addNewItem(parseItem(childNode));
		 
				   }
		}
		return cat;
	}
}