package model.log;

public class ModifyItemPriceActionLog extends ActionLog {

	public ModifyItemPriceActionLog(String description) {
		super(description,ModifyItemPriceActionLog.class.getName());
	}

	@Override
	public String getDetail() {
		throw new RuntimeException("Not implemented");
	}

}
