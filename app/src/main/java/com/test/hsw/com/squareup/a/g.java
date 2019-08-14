package com.squareup.a;

import com.squareup.a.a.a.c;

public final class g
{
  private final boolean a;
  private final boolean b;
  private final int c;
  private final int d;
  private final boolean e;
  private final boolean f;
  private final int g;
  private final int h;
  private final boolean i;

  private g(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3, int paramInt4, boolean paramBoolean5)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramBoolean3;
    this.f = paramBoolean4;
    this.g = paramInt3;
    this.h = paramInt4;
    this.i = paramBoolean5;
  }

  public static g a(r paramr)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int j = -1;
    int k = -1;
    boolean bool3 = false;
    boolean bool4 = false;
    int m = -1;
    int n = -1;
    boolean bool5 = false;
    int i1 = 0;
    if (i1 < paramr.a())
      if ((paramr.a(i1).equalsIgnoreCase("Cache-Control")) || (paramr.a(i1).equalsIgnoreCase("Pragma")));
    while (true)
    {
      i1++;
      break;
      String str1 = paramr.b(i1);
      boolean bool6 = bool1;
      int i2 = 0;
      while (i2 < str1.length())
      {
        int i3 = c.a(str1, i2, "=,;");
        String str2 = str1.substring(i2, i3).trim();
        Object localObject;
        if ((i3 == str1.length()) || (str1.charAt(i3) == ',') || (str1.charAt(i3) == ';'))
        {
          i2 = i3 + 1;
          localObject = null;
        }
        while (true)
        {
          if (!"no-cache".equalsIgnoreCase(str2))
            break label288;
          bool6 = true;
          break;
          int i4 = c.a(str1, i3 + 1);
          if ((i4 < str1.length()) && (str1.charAt(i4) == '"'))
          {
            int i6 = i4 + 1;
            int i7 = c.a(str1, i6, "\"");
            String str4 = str1.substring(i6, i7);
            i2 = i7 + 1;
            localObject = str4;
            continue;
          }
          int i5 = c.a(str1, i4, ",;");
          String str3 = str1.substring(i4, i5).trim();
          i2 = i5;
          localObject = str3;
        }
        label288: if ("no-store".equalsIgnoreCase(str2))
        {
          bool2 = true;
          continue;
        }
        if ("max-age".equalsIgnoreCase(str2))
        {
          j = c.a(localObject);
          continue;
        }
        if ("s-maxage".equalsIgnoreCase(str2))
        {
          k = c.a(localObject);
          continue;
        }
        if ("public".equalsIgnoreCase(str2))
        {
          bool3 = true;
          continue;
        }
        if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool4 = true;
          continue;
        }
        if ("max-stale".equalsIgnoreCase(str2))
        {
          m = c.a(localObject);
          continue;
        }
        if ("min-fresh".equalsIgnoreCase(str2))
        {
          n = c.a(localObject);
          continue;
        }
        if (!"only-if-cached".equalsIgnoreCase(str2))
          continue;
        bool5 = true;
        continue;
        return new g(bool1, bool2, j, k, bool3, bool4, m, n, bool5);
      }
      bool1 = bool6;
    }
  }

  public boolean a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public int d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.e;
  }

  public boolean f()
  {
    return this.f;
  }

  public int g()
  {
    return this.g;
  }

  public int h()
  {
    return this.h;
  }

  public boolean i()
  {
    return this.i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.g
 * JD-Core Version:    0.6.0
 */