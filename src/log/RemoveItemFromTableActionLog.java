package log;

public class RemoveItemFromTableActionLog extends ActionLog {

	public RemoveItemFromTableActionLog(String description) {
		super(description, RemoveItemFromTableActionLog.class.getName());
	}

	@Override
	public String getDetail() {
		throw new RuntimeException("Not implemented");
	}

}
