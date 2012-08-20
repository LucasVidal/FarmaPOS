package db.retrievers;

import model.Category;
import db.xml.XMLMenuParser;

public class MenuRetriever {

	private static MenuRetriever  _INSTANCE;

	public static MenuRetriever getInstance()
	{
		if (null == _INSTANCE)
			_INSTANCE = new MenuRetriever ();

		return _INSTANCE;
	}

	public Category getMenu()
	{
		XMLMenuParser parser = new XMLMenuParser();
		parser.parseMenu();

		return Category.getRootCategory();
	}
}
