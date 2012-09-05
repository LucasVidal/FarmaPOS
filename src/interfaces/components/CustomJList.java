package interfaces.components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class CustomJList<ModelType> extends JList<ModelType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 540100697016324155L;

	public void initializeWithList(List<ModelType> list)
	{
		
		DefaultListModel<ModelType> model = new DefaultListModel<ModelType>();
		
		for (ModelType element : list)
			model.addElement(element);
		
		this.setModel(model);
	}

	public void addElement(ModelType element) {
		if (null == this.getModel())
			initializeWithList(new ArrayList<ModelType>());
		
		DefaultListModel<ModelType> model = (DefaultListModel<ModelType>) this.getModel();
		model.addElement(element);
	}
}
