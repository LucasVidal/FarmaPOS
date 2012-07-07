package model.log;

import javax.management.RuntimeErrorException;

public class CreateTableActionLog extends ActionLog {

	public CreateTableActionLog(String description) {
		super(description, CreateTableActionLog.class.getName());
	}

	@Override
	public String getDetail() {
		throw new RuntimeException("Not implemented");
	}

}
