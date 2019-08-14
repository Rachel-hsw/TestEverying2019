package com.squareup.a.a.b;

import com.squareup.a.a.i;
import java.io.IOException;
import java.util.List;
import java.util.Set;

class x extends i
{
  x(s params, String paramString, Object[] paramArrayOfObject, int paramInt, List paramList, boolean paramBoolean)
  {
    super(paramString, paramArrayOfObject);
  }

  public void e()
  {
    boolean bool = s.h(this.d).a(this.a, this.b, this.c);
    if (bool);
    try
    {
      this.d.i.a(this.a, a.l);
      if ((bool) || (this.c))
        synchronized (this.d)
        {
          s.i(this.d).remove(Integer.valueOf(this.a));
          return;
        }
    }
    catch (IOException localIOException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.x
 * JD-Core Version:    0.6.0
 */