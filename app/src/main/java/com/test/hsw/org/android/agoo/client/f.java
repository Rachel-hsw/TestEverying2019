package org.android.agoo.client;

import java.util.Map;

public final class f
{
  private volatile String a;
  private volatile String b;
  private volatile String c;
  private volatile String d;
  private volatile String e;
  private volatile String f;
  private volatile long g = -1L;
  private volatile boolean h = true;
  private String i;
  private Map<String, Object> j = null;
  private Map<String, String> k = null;

  public final void a(long paramLong)
  {
    this.g = paramLong;
  }

  public final void a(String paramString)
  {
    this.c = paramString;
  }

  public final void a(String paramString, Object paramObject)
  {
    this.j.put(paramString, paramObject);
  }

  public final void a(String paramString1, String paramString2)
  {
    this.j.put(paramString1, paramString2);
  }

  public final void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public final boolean a()
  {
    return this.h;
  }

  public final long b()
  {
    return this.g;
  }

  public final void b(String paramString)
  {
    this.a = paramString;
  }

  public final Map<String, String> c()
  {
    return this.k;
  }

  public final void c(String paramString)
  {
    this.b = paramString;
  }

  public final String d()
  {
    return this.c;
  }

  public final void d(String paramString)
  {
    this.d = paramString;
  }

  public final String e()
  {
    return this.a;
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
    return this.d;
  }

  public final void g(String paramString)
  {
    this.i = paramString;
  }

  public final String h()
  {
    return this.e;
  }

  public final Map<String, Object> i()
  {
    return this.j;
  }

  public final String j()
  {
    return this.f;
  }

  public final String k()
  {
    return this.i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.client.f
 * JD-Core Version:    0.6.0
 */