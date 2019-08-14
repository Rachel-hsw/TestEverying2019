package com.squareup.a.a.b;

import com.squareup.a.a.i;
import java.io.IOException;
import java.util.List;
import java.util.Set;

class w extends i
{
  w(s params, String paramString, Object[] paramArrayOfObject, int paramInt, List paramList)
  {
    super(paramString, paramArrayOfObject);
  }

  public void e()
  {
    if (s.h(this.c).a(this.a, this.b))
      try
      {
        this.c.i.a(this.a, a.l);
        synchronized (this.c)
        {
          s.i(this.c).remove(Integer.valueOf(this.a));
          return;
        }
      }
      catch (IOException localIOException)
      {
      }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.w
 * JD-Core Version:    0.6.0
 */