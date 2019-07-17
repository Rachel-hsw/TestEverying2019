package com.bokecc.sdk.mobile.exception;

public class DreamwinException extends Exception
{
  private ErrorCode L;
  private String M;

  public DreamwinException(ErrorCode paramErrorCode, String[] paramArrayOfString)
  {
    this.L = paramErrorCode;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
        localStringBuffer.append(paramArrayOfString[j]).append(" ");
      this.M = localStringBuffer.toString();
    }
  }

  public ErrorCode getErrorCode()
  {
    return this.L;
  }

  public String getMessage()
  {
    return this.M;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.exception.DreamwinException
 * JD-Core Version:    0.6.0
 */