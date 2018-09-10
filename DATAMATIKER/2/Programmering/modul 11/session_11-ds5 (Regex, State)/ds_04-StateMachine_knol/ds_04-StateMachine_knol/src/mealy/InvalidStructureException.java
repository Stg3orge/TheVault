package mealy;

/**
 * 
 * @author knol
 * @version 20180420
 *
 */
public class InvalidStructureException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidStructureException(String message) {
		super(message);
	}
}
