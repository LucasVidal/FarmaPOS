package exceptions;

public class CouldNotOpenTableException extends Exception {

	public CouldNotOpenTableException()
	{
		super("Could not open table");
	}
	
	public CouldNotOpenTableException(String message)
	{
		super(message);
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8102745623459010871L;

}
