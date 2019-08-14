package org.a.a.a.h.a;

import java.io.IOException;
import java.io.Writer;

public class i extends c
{
  private final int a;
  private final int b;
  private final boolean c;

  public i()
  {
    this(0, 2147483647, true);
  }

  private i(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
  }

  public static i a(int paramInt1, int paramInt2)
  {
    return new i(paramInt1, paramInt2, false);
  }

  public static i b(int paramInt)
  {
    return a(paramInt, 2147483647);
  }

  public static i b(int paramInt1, int paramInt2)
  {
    return new i(paramInt1, paramInt2, true);
  }

  public static i c(int paramInt)
  {
    return a(0, paramInt);
  }

  public boolean a(int paramInt, Writer paramWriter)
    throws IOException
  {
    if (this.c)
    {
      if ((paramInt >= this.a) && (paramInt <= this.b));
    }
    else
      do
        return false;
      while ((paramInt >= this.a) && (paramInt <= this.b));
    if (paramInt > 65535)
      paramWriter.write("\\u" + a(paramInt));
    while (true)
    {
      return true;
      if (paramInt > 4095)
      {
        paramWriter.write("\\u" + a(paramInt));
        continue;
      }
      if (paramInt > 255)
      {
        paramWriter.write("\\u0" + a(paramInt));
        continue;
      }
      if (paramInt > 15)
      {
        paramWriter.write("\\u00" + a(paramInt));
        continue;
      }
      paramWriter.write("\\u000" + a(paramInt));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.a.i
 * JD-Core Version:    0.6.0
 */