package com.tencent.mm.a;

import android.util.Base64;
import javax.crypto.Cipher;

public final class a
{
  private Cipher j;

  public final String h(String paramString)
  {
    try
    {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      String str = new String(this.j.doFinal(arrayOfByte), "UTF8");
      return str;
    }
    catch (Exception localException)
    {
    }
    return "[des]" + paramString + "|" + localException.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.mm.a.a
 * JD-Core Version:    0.6.0
 */