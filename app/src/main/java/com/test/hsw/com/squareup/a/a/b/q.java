package com.squareup.a.a.b;

import java.util.Arrays;

public final class q
{
  static final int a = 65536;
  static final int b = 1;
  static final int c = 1;
  static final int d = 2;
  static final int e = 1;
  static final int f = 1;
  static final int g = 2;
  static final int h = 2;
  static final int i = 3;
  static final int j = 4;
  static final int k = 5;
  static final int l = 5;
  static final int m = 6;
  static final int n = 7;
  static final int o = 8;
  static final int p = 10;
  static final int q = 10;
  static final int r = 1;
  private int s;
  private int t;
  private int u;
  private final int[] v = new int[10];

  q a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= this.v.length)
      return this;
    int i1 = 1 << paramInt1;
    this.s = (i1 | this.s);
    if ((paramInt2 & 0x1) != 0)
    {
      this.t = (i1 | this.t);
      if ((paramInt2 & 0x2) == 0)
        break label86;
      this.u = (i1 | this.u);
    }
    while (true)
    {
      this.v[paramInt1] = paramInt3;
      return this;
      this.t &= (i1 ^ 0xFFFFFFFF);
      break;
      label86: this.u &= (i1 ^ 0xFFFFFFFF);
    }
  }

  void a()
  {
    this.u = 0;
    this.t = 0;
    this.s = 0;
    Arrays.fill(this.v, 0);
  }

  void a(q paramq)
  {
    int i1 = 0;
    if (i1 < 10)
    {
      if (!paramq.a(i1));
      while (true)
      {
        i1++;
        break;
        a(i1, paramq.c(i1), paramq.b(i1));
      }
    }
  }

  boolean a(int paramInt)
  {
    return (1 << paramInt & this.s) != 0;
  }

  boolean a(boolean paramBoolean)
  {
    int i1;
    if ((0x4 & this.s) != 0)
      i1 = this.v[2];
    while (i1 == 1)
    {
      return true;
      if (paramBoolean)
      {
        i1 = 1;
        continue;
      }
      i1 = 0;
    }
    return false;
  }

  int b()
  {
    return Integer.bitCount(this.s);
  }

  int b(int paramInt)
  {
    return this.v[paramInt];
  }

  boolean b(boolean paramBoolean)
  {
    int i1;
    if ((0x20 & this.s) != 0)
      i1 = this.v[5];
    while (i1 == 1)
    {
      return true;
      if (paramBoolean)
      {
        i1 = 1;
        continue;
      }
      i1 = 0;
    }
    return false;
  }

  int c()
  {
    if ((0x2 & this.s) != 0)
      return this.v[1];
    return -1;
  }

  int c(int paramInt)
  {
    boolean bool = m(paramInt);
    int i1 = 0;
    if (bool)
      i1 = 2;
    if (l(paramInt))
      i1 |= 1;
    return i1;
  }

  int d(int paramInt)
  {
    if ((0x2 & this.s) != 0)
      paramInt = this.v[1];
    return paramInt;
  }

  boolean d()
  {
    if ((0x400 & this.s) != 0);
    for (int i1 = this.v[10]; ; i1 = 0)
    {
      int i2 = i1 & 0x1;
      int i3 = 0;
      if (i2 != 0)
        i3 = 1;
      return i3;
    }
  }

  int e(int paramInt)
  {
    if ((0x4 & this.s) != 0)
      paramInt = this.v[2];
    return paramInt;
  }

  int f(int paramInt)
  {
    if ((0x8 & this.s) != 0)
      paramInt = this.v[3];
    return paramInt;
  }

  int g(int paramInt)
  {
    if ((0x10 & this.s) != 0)
      paramInt = this.v[4];
    return paramInt;
  }

  int h(int paramInt)
  {
    if ((0x20 & this.s) != 0)
      paramInt = this.v[5];
    return paramInt;
  }

  int i(int paramInt)
  {
    if ((0x40 & this.s) != 0)
      paramInt = this.v[6];
    return paramInt;
  }

  int j(int paramInt)
  {
    if ((0x80 & this.s) != 0)
      paramInt = this.v[7];
    return paramInt;
  }

  int k(int paramInt)
  {
    if ((0x100 & this.s) != 0)
      paramInt = this.v[8];
    return paramInt;
  }

  boolean l(int paramInt)
  {
    return (1 << paramInt & this.t) != 0;
  }

  boolean m(int paramInt)
  {
    return (1 << paramInt & this.u) != 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.q
 * JD-Core Version:    0.6.0
 */