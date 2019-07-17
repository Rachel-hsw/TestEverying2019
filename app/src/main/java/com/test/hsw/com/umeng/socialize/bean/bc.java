package com.umeng.socialize.bean;

import java.io.Serializable;

public class bc
  implements Serializable
{
  private static final long b = 1L;
  public char a;
  private int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private a i;
  private long j;
  private boolean k = true;

  public int a()
  {
    return this.c;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(long paramLong)
  {
    this.j = paramLong;
  }

  public void a(a parama)
  {
    this.i = parama;
    if (parama != null)
      this.a = parama.b.charAt(0);
  }

  public void a(String paramString)
  {
    this.f = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public final boolean a(bc parambc)
  {
    if (parambc == null);
    do
    {
      return false;
      if (parambc.g() > this.j)
        return true;
      if (parambc.h() != h())
        return true;
      if (!parambc.d().equals(this.e))
        return true;
    }
    while ((parambc.e() == null) || (parambc.e().equals(this.g)));
    return true;
  }

  public String b()
  {
    return this.d;
  }

  public void b(String paramString)
  {
    this.d = paramString;
  }

  public String c()
  {
    return this.f;
  }

  public void c(String paramString)
  {
    this.e = paramString;
  }

  public String d()
  {
    return this.e;
  }

  public void d(String paramString)
  {
    this.g = paramString;
  }

  public String e()
  {
    return this.g;
  }

  public void e(String paramString)
  {
    this.h = paramString;
  }

  public String f()
  {
    return this.h;
  }

  public boolean f(String paramString)
  {
    return (paramString != null) && (paramString.equals(Character.valueOf(this.a)));
  }

  public long g()
  {
    return this.j;
  }

  public boolean h()
  {
    return this.k;
  }

  public a i()
  {
    return this.i;
  }

  public char j()
  {
    if ((this.a == 0) && (this.i != null))
      this.a = this.i.b.charAt(0);
    if (this.a != 0)
    {
      int m = this.a;
      if (((64 < m) && (m < 91)) || ((96 < m) && (m < 123)));
      do
        return m;
      while (m == "常".charAt(0));
    }
    return "符".charAt(0);
  }

  public static class a
    implements Serializable
  {
    private static final long c = 1L;
    public String a;
    public String b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.bc
 * JD-Core Version:    0.6.0
 */