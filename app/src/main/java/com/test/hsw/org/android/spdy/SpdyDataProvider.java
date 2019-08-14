package org.android.spdy;

import java.util.Map;

public class SpdyDataProvider
{
  byte[] data;
  public boolean finished = true;
  Map<String, String> postBody;

  public SpdyDataProvider(Map<String, String> paramMap)
  {
    this.data = null;
    this.postBody = paramMap;
  }

  public SpdyDataProvider(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    this.postBody = null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.spdy.SpdyDataProvider
 * JD-Core Version:    0.6.0
 */