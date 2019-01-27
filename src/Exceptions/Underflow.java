package Exceptions;

/**
 * Exception class for access in empty containers
 * such as stacks, queues, and priority queues.
 * @author Mark Allen Weiss
 */
public class Underflow extends Exception
{
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public Underflow( String message )
    {
        super( message );
    }
}
