package model.exceptions;

public final class RankChallengeException extends Exception
{
    public RankChallengeException()
    {
        super();
    }

    public RankChallengeException(String message)
    {
        super(message);
    }

    public RankChallengeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public RankChallengeException(Throwable cause)
    {
        super(cause);
    }
}
