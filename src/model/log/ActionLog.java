package model.log;

import java.util.Date;

public abstract class ActionLog {

	public ActionLog(String description, String level) {
		super();
		this.description = description;
		this.level = level;
		this.timestamp = new Date();
	}
	
	private String description;
	private String level;
	private Date timestamp;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public abstract String getDetail();
}
