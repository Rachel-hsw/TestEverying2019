package com.squareup.a.a.b;

public enum a
{
  public final int r;
  public final int s;
  public final int t;

  static
  {
    a[] arrayOfa = new a[17];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    arrayOfa[3] = d;
    arrayOfa[4] = e;
    arrayOfa[5] = f;
    arrayOfa[6] = g;
    arrayOfa[7] = h;
    arrayOfa[8] = i;
    arrayOfa[9] = j;
    arrayOfa[10] = k;
    arrayOfa[11] = l;
    arrayOfa[12] = m;
    arrayOfa[13] = n;
    arrayOfa[14] = o;
    arrayOfa[15] = p;
    arrayOfa[16] = q;
    u = arrayOfa;
  }

  private a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.r = paramInt1;
    this.s = paramInt2;
    this.t = paramInt3;
  }

  public static a a(int paramInt)
  {
    for (a locala : values())
      if (locala.s == paramInt)
        return locala;
    return null;
  }

  public static a b(int paramInt)
  {
    for (a locala : values())
      if (locala.r == paramInt)
        return locala;
    return null;
  }

  public static a c(int paramInt)
  {
    for (a locala : values())
      if (locala.t == paramInt)
        return locala;
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.a
 * JD-Core Version:    0.6.0
 */