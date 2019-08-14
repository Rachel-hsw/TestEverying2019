package com.xiaomi.network;

import java.net.InetSocketAddress;

public final class d
{
  private String a;
  private int b;

  public d(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }

  public static d a(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf(":");
    String str;
    int j;
    if (i != -1)
    {
      str = paramString.substring(0, i);
      j = i + 1;
    }
    try
    {
      k = Integer.parseInt(paramString.substring(j));
      if (k <= 0)
      {
        paramString = str;
        return new d(paramString, paramInt);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        int k;
        paramString = str;
        continue;
        paramInt = k;
      }
    }
  }

  public static InetSocketAddress b(String paramString, int paramInt)
  {
    d locald = a(paramString, paramInt);
    return new InetSocketAddress(locald.b(), locald.a());
  }

  public int a()
  {
    return this.b;
  }

  public String b()
  {
    return this.a;
  }

  public String toString()
  {
    if (this.b > 0)
      return this.a + ":" + this.b;
    return this.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.d
 * JD-Core Version:    0.6.0
 */