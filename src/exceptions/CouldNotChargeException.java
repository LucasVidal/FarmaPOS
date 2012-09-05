package exceptions;

public class CouldNotChargeException extends NotAllowedOperationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5184137142762126219L;

	public CouldNotChargeException()
	{
		super("Table is not open.");
	}

}
