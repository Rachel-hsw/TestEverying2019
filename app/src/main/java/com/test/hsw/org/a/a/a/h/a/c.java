package org.a.a.a.h.a;

import java.io.IOException;
import java.io.Writer;

public abstract class c extends b
{
  public final int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
    throws IOException
  {
    if (a(Character.codePointAt(paramCharSequence, paramInt), paramWriter))
      return 1;
    return 0;
  }

  public abstract boolean a(int paramInt, Writer paramWriter)
    throws IOException;
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.a.c
 * JD-Core Version:    0.6.0
 */