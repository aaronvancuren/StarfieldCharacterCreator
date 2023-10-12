package model.exceptions;

public class SkillPointException extends Exception
{
    public SkillPointException()
    {
        super();
    }

    public SkillPointException(String message)
    {
        super(message);
    }

    public SkillPointException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public SkillPointException(Throwable cause)
    {
        super(cause);
    }
}
