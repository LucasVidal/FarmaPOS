package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;


public class Category {
	public static final String NodeName = "CATEGORIA";
	public static final String ATTRIBUTE_NAME_NAME = "nombre";
	private Category parent;
	private List<Category> children;
	private String name;
	private List<Item> items;
	
	private static Category rootCategory;
	
	public static Category getRootCategory()
	{
		if (Category.rootCategory==null)
		{
			Category.rootCategory= new Category(null, null, "ROOT");
			Category.rootCategory.setParent(Category.rootCategory);
			Category.rootCategory.setChildren(new ArrayList<Category>());
		}
		
		return Category.rootCategory;
	}

	public static Category createCategoryInRoot(String name) {
		Category cat = new Category(Category.getRootCategory(),new ArrayList<Category>(), name);
		Category.rootCategory.addChildCategory(cat);
		
		return cat;
	}
	
	public Category(Category parent, List<Category> children, String name) {
		super();
		this.parent = parent;
		this.children = children;
		this.name = name;
		this.items = new ArrayList<Item>();
	}

	public void changeParentTo(Category cat) {
		this.parent.removeCategory(this);
		this.setParent(cat);
		cat.addChildCategory(this);
	}

	private void removeCategory(Category category) {
		this.children.remove(category);		
	}
	private void addChildCategory(Category category) {
		this.children.add(category);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> childs) {
		this.children = childs;
	}
	
	

	public String getStringTree()
	{
		StringBuilder s = new StringBuilder(this.name);
		for (Category c: this.getChildren())
			s.append("\n(hijos de "+this.name+")  "+c.getStringTree());
		return s.toString();
	}
	
	public String getStringTreeWithItems()
	{
		StringBuilder s = new StringBuilder(this.name);
		for (Category c: this.getChildren())
			s.append("\n(hijos de "+this.name+")  <CAT>"+c.getStringTreeWithItems());
		
		for (Item i: this.items)
			s.append("\n(hijos de "+this.name+")  <ITEM>"+i.getName()+ " $"+i.getPrice());
		
		return s.toString();
	}

	public void addNewItem(Item item) {
		item.setCategory(this);
		this.items.add(item);
	}
	
	public DefaultMutableTreeNode getTreeNode()
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(this.getName());
		for (Category c:this.children)
			node.add(c.getTreeNode());
		
		for (Item i:this.items)
			node.add(new DefaultMutableTreeNode(i));
		
		return node;
	}
}
