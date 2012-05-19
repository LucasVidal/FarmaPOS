package log;

public class CreateTableActionLog extends ActionLog {

	public CreateTableActionLog(String description) {
		super(description, CreateTableActionLog.class.getName());
	}

}
