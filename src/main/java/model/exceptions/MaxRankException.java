package model.exceptions;

public class MaxRankException extends Exception
{
    public MaxRankException()
    {
        super();
    }

    public MaxRankException(String message)
    {
        super(message);
    }

    public MaxRankException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public MaxRankException(Throwable cause)
    {
        super(cause);
    }
}
