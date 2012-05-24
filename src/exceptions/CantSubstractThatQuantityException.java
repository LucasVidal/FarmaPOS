package exceptions;

public class CantSubstractThatQuantityException extends NotAllowedOperationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5515770885964761972L;

	public CantSubstractThatQuantityException()
	{
		super("Can't substract that quantity for the item in this table");
	}
	
}
