package exceptions;

import exceptions.NotAllowedOperationException;

public class TableIsNotChargingException extends NotAllowedOperationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5184137142762126219L;

	public TableIsNotChargingException()
	{
		super("Table is not being charged.");
	}

}
