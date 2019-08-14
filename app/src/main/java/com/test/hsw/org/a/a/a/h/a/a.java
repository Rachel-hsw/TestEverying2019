package org.a.a.a.h.a;

import java.io.IOException;
import java.io.Writer;
import org.a.a.a.c;

public class a extends b
{
  private final b[] a;

  public a(b[] paramArrayOfb)
  {
    this.a = ((b[])c.c(paramArrayOfb));
  }

  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
    throws IOException
  {
    b[] arrayOfb = this.a;
    int i = arrayOfb.length;
    for (int j = 0; j < i; j++)
    {
      int k = arrayOfb[j].a(paramCharSequence, paramInt, paramWriter);
      if (k != 0)
        return k;
    }
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.a.a
 * JD-Core Version:    0.6.0
 */