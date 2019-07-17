package com.bokecc.sdk.mobile.exception;

public enum ErrorCode
{
  private int N;

  static
  {
    INVALID_REQUEST = new ErrorCode("INVALID_REQUEST", 2, -12);
    ErrorCode[] arrayOfErrorCode = new ErrorCode[3];
    arrayOfErrorCode[0] = NETWORK_ERROR;
    arrayOfErrorCode[1] = PROCESS_FAIL;
    arrayOfErrorCode[2] = INVALID_REQUEST;
    O = arrayOfErrorCode;
  }

  private ErrorCode(int paramInt)
  {
    this.N = paramInt;
  }

  public int Value()
  {
    return this.N;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.exception.ErrorCode
 * JD-Core Version:    0.6.0
 */