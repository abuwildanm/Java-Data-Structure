package Exceptions;

/**
 * Exception class for illegal decrease key
 * operations in pairing heaps.
 * @author Mark Allen Weiss
 */

public class IllegalValue extends Exception
{
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public IllegalValue( String message )
    {
        super( message );
    }
}
