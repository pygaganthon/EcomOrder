package com.example.demo.exception;

@SuppressWarnings("serial")
public abstract class AbstractExceptionWithDetails extends RuntimeException
{

    private final ErrorCode error;
    protected final String[] additionalInfo;

    public AbstractExceptionWithDetails(ErrorCode error, String... additionalInfo)
    {
        this(error, null, additionalInfo);
    }

    public AbstractExceptionWithDetails(ErrorCode error, Throwable ex, String... additionalInfo)
    {
        super(ex);
        this.error = error;
        this.additionalInfo = additionalInfo;
    }

    public ErrorCode getError()
    {
        return error;
    }

    public String[] getAdditionalInfo()
    {
        return additionalInfo;
    }

    public int getErrorCode()
    {
        return error.getCode();
    }

    public String getErrorMessage()
    {
        return error.getDescription();
    }

    @Override
    public String toString()
    {
        StringBuilder ret = new StringBuilder();
        ret.append("Error code ");
        ret.append(error.getCode());
        ret.append(":");
        ret.append(error.getDescription());
        ret.append("; Additional Information:[");
        for (String addl : additionalInfo)
        {
            ret.append(addl + ",");
        }
        ret.append("]");
        return ret.toString();
    }
}
