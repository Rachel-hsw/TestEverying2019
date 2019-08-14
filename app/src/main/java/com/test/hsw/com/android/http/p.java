package com.android.http;

import java.io.UnsupportedEncodingException;
import java.util.Map;

class p
  implements m
{
  p(n paramn, n.a parama)
  {
  }

  public void a()
  {
    this.b.onRequest();
  }

  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.b.onError(paramString1, paramString2, paramInt);
  }

  public void a(byte[] paramArrayOfByte, Map<String, String> paramMap, String paramString, int paramInt)
  {
    try
    {
      str = new String(paramArrayOfByte, "UTF-8");
      this.b.onSuccess(str, paramMap, paramString, paramInt);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
      {
        localUnsupportedEncodingException.printStackTrace();
        String str = null;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.p
 * JD-Core Version:    0.6.0
 */