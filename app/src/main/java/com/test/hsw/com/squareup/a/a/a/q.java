package com.squareup.a.a.a;

import com.squareup.a.aa;
import com.squareup.a.v;
import java.io.IOException;
import java.net.ProtocolException;

public final class q
{
  public static final int a = 307;
  public static final int b = 100;
  public final v c;
  public final int d;
  public final String e;

  public q(v paramv, int paramInt, String paramString)
  {
    this.c = paramv;
    this.d = paramInt;
    this.e = paramString;
  }

  public static q a(aa paramaa)
  {
    return new q(paramaa.b(), paramaa.c(), paramaa.d());
  }

  public static q a(String paramString)
    throws IOException
  {
    int i = 9;
    int m;
    v localv;
    if (paramString.startsWith("HTTP/1."))
    {
      if ((paramString.length() < i) || (paramString.charAt(8) != ' '))
        throw new ProtocolException("Unexpected status line: " + paramString);
      m = '￐' + paramString.charAt(7);
      if (m == 0)
        localv = v.a;
    }
    while (paramString.length() < i + 3)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
      if (m == 1)
      {
        localv = v.b;
        continue;
      }
      throw new ProtocolException("Unexpected status line: " + paramString);
      if (paramString.startsWith("ICY "))
      {
        localv = v.a;
        i = 4;
        continue;
      }
      throw new ProtocolException("Unexpected status line: " + paramString);
    }
    int j = i + 3;
    int k;
    try
    {
      k = Integer.parseInt(paramString.substring(i, j));
      if (paramString.length() > i + 3)
        if (paramString.charAt(i + 3) != ' ')
          throw new ProtocolException("Unexpected status line: " + paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
    }
    for (String str = paramString.substring(i + 4); ; str = "")
      return new q(localv, k, str);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.c == v.a);
    for (String str = "HTTP/1.0"; ; str = "HTTP/1.1")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(" ").append(this.d);
      if (this.e != null)
        localStringBuilder.append(" ").append(this.e);
      return localStringBuilder.toString();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.q
 * JD-Core Version:    0.6.0
 */