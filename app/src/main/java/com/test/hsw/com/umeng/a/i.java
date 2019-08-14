package com.umeng.a;

import android.content.Context;
import c.a.b;
import c.a.bt;
import c.a.ex;
import c.a.l;

public class i
{
  public static final int a = 0;
  public static final int b = 1;
  static final int c = 2;
  static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;

  public static class a extends i.g
  {
    private l a;
    private b b;

    public a(b paramb, l paraml)
    {
      this.b = paramb;
      this.a = paraml;
    }

    public boolean a()
    {
      return this.a.c();
    }

    public boolean a(boolean paramBoolean)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.a.a();
      return l1 - this.b.c >= l2;
    }
  }

  public static class b extends i.g
  {
    private long a;
    private long b = 0L;

    public b(int paramInt)
    {
      this.a = paramInt;
      this.b = System.currentTimeMillis();
    }

    public boolean a()
    {
      return System.currentTimeMillis() - this.b < this.a;
    }

    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.b >= this.a;
    }
  }

  public static class c extends i.g
  {
    public boolean a(boolean paramBoolean)
    {
      return paramBoolean;
    }
  }

  public static class d extends i.g
  {
    private long a = 90000L;
    private long b;
    private b c;

    public d(b paramb, long paramLong)
    {
      this.c = paramb;
      if (paramLong < this.a)
        paramLong = this.a;
      this.b = paramLong;
    }

    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.c.c >= this.b;
    }

    public long b()
    {
      return this.b;
    }
  }

  public static class e extends i.g
  {
    private final int a;
    private ex b;

    public e(ex paramex, int paramInt)
    {
      this.a = paramInt;
      this.b = paramex;
    }

    public boolean a(boolean paramBoolean)
    {
      return this.b.b() > this.a;
    }
  }

  public static class f extends i.g
  {
    private long a = 86400000L;
    private b b;

    public f(b paramb)
    {
      this.b = paramb;
    }

    public boolean a(boolean paramBoolean)
    {
      return System.currentTimeMillis() - this.b.c >= this.a;
    }
  }

  public static class g
  {
    public boolean a()
    {
      return true;
    }

    public boolean a(boolean paramBoolean)
    {
      return true;
    }
  }

  public static class h extends i.g
  {
    private Context a = null;

    public h(Context paramContext)
    {
      this.a = paramContext;
    }

    public boolean a(boolean paramBoolean)
    {
      return bt.k(this.a);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.i
 * JD-Core Version:    0.6.0
 */