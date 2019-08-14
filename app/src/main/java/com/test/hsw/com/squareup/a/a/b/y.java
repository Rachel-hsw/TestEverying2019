package com.squareup.a.a.b;

import b.e;
import com.squareup.a.a.i;
import java.io.IOException;
import java.util.Set;

class y extends i
{
  y(s params, String paramString, Object[] paramArrayOfObject, int paramInt1, e parame, int paramInt2, boolean paramBoolean)
  {
    super(paramString, paramArrayOfObject);
  }

  public void e()
  {
    try
    {
      boolean bool = s.h(this.e).a(this.a, this.b, this.c, this.d);
      if (bool)
        this.e.i.a(this.a, a.l);
      if ((bool) || (this.d))
        synchronized (this.e)
        {
          s.i(this.e).remove(Integer.valueOf(this.a));
          return;
        }
    }
    catch (IOException localIOException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.y
 * JD-Core Version:    0.6.0
 */