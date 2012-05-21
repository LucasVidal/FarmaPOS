package exceptions;

public class TableIsNotOpenException extends NotAllowedOperationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5184137142762126219L;

	public TableIsNotOpenException()
	{
		super("Table is not open.");
	}

}
