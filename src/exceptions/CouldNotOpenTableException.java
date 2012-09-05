package exceptions;

public class CouldNotOpenTableException extends NotAllowedOperationException {

	public CouldNotOpenTableException()
	{
		super("Could not open table");
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8102745623459010871L;

}
