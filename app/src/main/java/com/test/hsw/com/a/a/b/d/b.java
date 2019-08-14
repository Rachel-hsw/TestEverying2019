package com.a.a.b.d;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public abstract interface b
{
  public abstract InputStream a(String paramString, Object paramObject)
    throws IOException;

  public static enum a
  {
    private String h;
    private String i;

    static
    {
      a[] arrayOfa = new a[7];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      j = arrayOfa;
    }

    private a(String paramString)
    {
      this.h = paramString;
      this.i = (paramString + "://");
    }

    public static a a(String paramString)
    {
      if (paramString != null)
        for (a locala : values())
          if (locala.d(paramString))
            return locala;
      return g;
    }

    private boolean d(String paramString)
    {
      return paramString.toLowerCase(Locale.US).startsWith(this.i);
    }

    public String b(String paramString)
    {
      return this.i + paramString;
    }

    public String c(String paramString)
    {
      if (!d(paramString))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = this.h;
        throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", arrayOfObject));
      }
      return paramString.substring(this.i.length());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.d.b
 * JD-Core Version:    0.6.0
 */