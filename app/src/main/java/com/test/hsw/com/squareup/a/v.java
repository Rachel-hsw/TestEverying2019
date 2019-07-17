package com.squareup.a;

import java.io.IOException;

public enum v
{
  private final String e;

  static
  {
    v[] arrayOfv = new v[4];
    arrayOfv[0] = a;
    arrayOfv[1] = b;
    arrayOfv[2] = c;
    arrayOfv[3] = d;
    f = arrayOfv;
  }

  private v(String paramString)
  {
    this.e = paramString;
  }

  public static v a(String paramString)
    throws IOException
  {
    if (paramString.equals(a.e))
      return a;
    if (paramString.equals(b.e))
      return b;
    if (paramString.equals(d.e))
      return d;
    if (paramString.equals(c.e))
      return c;
    throw new IOException("Unexpected protocol: " + paramString);
  }

  public String toString()
  {
    return this.e;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.v
 * JD-Core Version:    0.6.0
 */