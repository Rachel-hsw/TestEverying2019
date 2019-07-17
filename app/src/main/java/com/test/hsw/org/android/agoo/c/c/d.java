package org.android.agoo.c.c;

import java.util.Map;

public final class d
{
  public static final String a = "&";
  private volatile String b;
  private volatile String c;
  private volatile String d;
  private volatile String e;
  private volatile String f;
  private volatile String g;
  private volatile String h;
  private volatile long i = -1L;
  private volatile boolean j = true;
  private String k;
  private Map<String, Object> l = null;
  private Map<String, String> m = null;

  public final void a(long paramLong)
  {
    this.i = paramLong;
  }

  public final void a(String paramString)
  {
    this.h = paramString;
  }

  public final void a(String paramString, Object paramObject)
  {
    this.l.put(paramString, paramObject);
  }

  public final void a(String paramString1, String paramString2)
  {
    this.m.put(paramString1, paramString2);
  }

  public final void a(Map<String, String> paramMap)
  {
    this.m.putAll(paramMap);
  }

  public final void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public final boolean a()
  {
    return this.j;
  }

  public final long b()
  {
    return this.i;
  }

  public final void b(String paramString)
  {
    this.d = paramString;
  }

  public final void b(Map<String, Object> paramMap)
  {
    this.l.putAll(paramMap);
  }

  public final String c()
  {
    return this.h;
  }

  public final void c(String paramString)
  {
    this.b = paramString;
  }

  public final Map<String, String> d()
  {
    return this.m;
  }

  public final void d(String paramString)
  {
    this.c = paramString;
  }

  public final String e()
  {
    return this.d;
  }

  public final void e(String paramString)
  {
    this.e = paramString;
  }

  public final String f()
  {
    return this.b;
  }

  public final void f(String paramString)
  {
    this.f = paramString;
  }

  public final String g()
  {
    return this.c;
  }

  public final void g(String paramString)
  {
    this.g = paramString;
  }

  public final String h()
  {
    return this.e;
  }

  public final void h(String paramString)
  {
    this.k = paramString;
  }

  public final String i()
  {
    return this.f;
  }

  public final Map<String, Object> j()
  {
    return this.l;
  }

  public final String k()
  {
    return this.g;
  }

  public final String l()
  {
    return this.k;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.c.d
 * JD-Core Version:    0.6.0
 */