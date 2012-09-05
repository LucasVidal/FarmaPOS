package db.retrievers;

import interfaces.components.TableButton;
import interfaces.components.TableButtonFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomLayoutRetriever {

	private static RoomLayoutRetriever _INSTANCE;

	public static RoomLayoutRetriever getInstance() {
		if (null == _INSTANCE)
			_INSTANCE = new RoomLayoutRetriever();
		
		return _INSTANCE;
	}

	public List<TableButton> getTablesForRoom(int i) {
		
		TableButton tableButton_1 = 	TableButtonFactory.createTableButton("1");
		TableButton tableButton_1A = 	TableButtonFactory.createTableButton("1A");
		TableButton tableButton_2 = 	TableButtonFactory.createTableButton("2");
		TableButton tableButton_3 = 	TableButtonFactory.createTableButton("3");
		TableButton tableButton_3A =	TableButtonFactory.createTableButton("3A");
		TableButton tableButton_4 = 	TableButtonFactory.createTableButton("4");
		TableButton tableButton_4A = 	TableButtonFactory.createTableButton("4A");
		TableButton tableButton_5 = 	TableButtonFactory.createTableButton("5");
		TableButton tableButton_5A = 	TableButtonFactory.createTableButton("5A");
		TableButton tableButton_6 = 	TableButtonFactory.createTableButton("6");
		TableButton tableButton_7 = 	TableButtonFactory.createTableButton("7");
		TableButton tableButton_9 = 	TableButtonFactory.createTableButton("9");
		TableButton tableButton_9A = 	TableButtonFactory.createTableButton("9A");
		TableButton tableButton_10 = 	TableButtonFactory.createTableButton("10");
		TableButton tableButton_10A = 	TableButtonFactory.createTableButton("10A");
		TableButton tableButton_11 = 	TableButtonFactory.createTableButton("11");
		TableButton tableButton_12 = 	TableButtonFactory.createTableButton("12");
		TableButton tableButton_12A = 	TableButtonFactory.createTableButton("12A");
		
		tableButton_1.setBounds(10, 164, 70, 70);
		tableButton_1A.setBounds(94, 164, 70, 70);
		tableButton_2.setBounds(10, 366, 70, 70);
		tableButton_3.setBounds(220, 557, 70, 70);
		tableButton_3A.setBounds(220, 482, 70, 70);
		tableButton_4.setBounds(343, 559, 70, 61);
		tableButton_4A.setBounds(343, 484, 70, 61);
		tableButton_5.setBounds(466, 555, 70, 68);
		tableButton_5A.setBounds(466, 482, 70, 70);
		tableButton_6.setBounds(586, 557, 70, 70);
		tableButton_7.setBounds(586, 283, 70, 70);
		tableButton_9.setBounds(466, 138, 70, 70);
		tableButton_9A.setBounds(466, 217, 70, 70);
		tableButton_10.setBounds(364, 138, 70, 70);
		tableButton_10A.setBounds(364, 215, 70, 70);
		tableButton_11.setBounds(220, 256, 70, 70);
		tableButton_12.setBounds(220, 181, 70, 70);
		tableButton_12A.setBounds(220, 106, 70, 70);
		
		return new ArrayList<TableButton>(Arrays.asList(
			tableButton_1,
			tableButton_1A,
			tableButton_2,
			tableButton_3,
			tableButton_3A,
			tableButton_4,
			tableButton_4A,
			tableButton_5,
			tableButton_5A,
			tableButton_6,
			tableButton_7,
			tableButton_9,
			tableButton_9A,
			tableButton_10,
			tableButton_10A,
			tableButton_11,
			tableButton_12,
			tableButton_12A)
		);

	}

}
