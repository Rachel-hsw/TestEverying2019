package org.a.a.a.h.a;

import java.io.IOException;
import java.io.Writer;

public class f extends c
{
  private final int a;
  private final int b;
  private final boolean c;

  public f()
  {
    this(0, 2147483647, true);
  }

  private f(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
  }

  public static f a(int paramInt1, int paramInt2)
  {
    return new f(paramInt1, paramInt2, true);
  }

  public static f b(int paramInt)
  {
    return b(paramInt, 2147483647);
  }

  public static f b(int paramInt1, int paramInt2)
  {
    return new f(paramInt1, paramInt2, false);
  }

  public static f c(int paramInt)
  {
    return b(0, paramInt);
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
    paramWriter.write("&#");
    paramWriter.write(Integer.toString(paramInt, 10));
    paramWriter.write(59);
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.a.f
 * JD-Core Version:    0.6.0
 */