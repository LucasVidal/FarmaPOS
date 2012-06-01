package exceptions;

public class TableIsNotOpenException extends NotAllowedOperationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableIsNotOpenException ()
	{
		super("Table is not open.");
	}
	
}
