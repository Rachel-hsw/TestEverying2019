package com.tencent.a.a.a.a;

import android.content.Context;

public abstract class f
{
  protected Context e = null;

  protected f(Context paramContext)
  {
    this.e = paramContext;
  }

  public final void a(c paramc)
  {
    if (paramc == null);
    String str;
    do
    {
      return;
      str = paramc.toString();
    }
    while (!a());
    b(h.g(str));
  }

  protected abstract boolean a();

  protected abstract String b();

  protected abstract void b(String paramString);

  public final c e()
  {
    if (a());
    for (String str = h.f(b()); ; str = null)
    {
      c localc = null;
      if (str != null)
        localc = c.c(str);
      return localc;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.a.a.a.a.f
 * JD-Core Version:    0.6.0
 */