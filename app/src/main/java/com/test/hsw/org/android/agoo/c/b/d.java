package org.android.agoo.c.b;

import android.text.TextUtils;

class d
  implements g.a
{
  d(c paramc)
  {
  }

  public void a(b paramb, String paramString)
  {
    c.a(this.a, false);
    c.a(this.a, paramb, paramString);
  }

  public void a(f paramf, String paramString1, int paramInt, String paramString2)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (paramInt > 0))
      {
        c.a(false);
        c.a(this.a, paramString1);
        c.a(this.a, paramInt);
        c.a(paramf);
      }
      this.a.a(paramString2);
      c.a(this.a, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        c.a(this.a, b.y, "host [" + paramString1 + "] failed");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.b.d
 * JD-Core Version:    0.6.0
 */