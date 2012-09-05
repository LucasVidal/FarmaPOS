package db.retrievers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

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

	public TreeNode getMenuAsTreeModel() {
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		DefaultMutableTreeNode root = Category.getRootCategory().getTreeNode();
		for (int i=0; i<root.getChildCount(); i++)
			list.add(root.getChildAt(i));
		
		return Category.getRootCategory().getTreeNode();
	}
}
