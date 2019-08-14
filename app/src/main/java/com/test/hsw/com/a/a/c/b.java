package com.a.a.c;

import android.opengl.GLES10;
import com.a.a.b.a.e;
import com.a.a.b.a.h;
import com.a.a.b.e.a;

public final class b
{
  private static final int a = 2048;
  private static e b;

  static
  {
    int[] arrayOfInt = new int[1];
    GLES10.glGetIntegerv(3379, arrayOfInt, 0);
    int i = Math.max(arrayOfInt[0], 2048);
    b = new e(i, i);
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = b.a();
    int j = b.b();
    while ((paramInt1 / paramInt3 > i) || (paramInt2 / paramInt3 > j))
    {
      if (paramBoolean)
      {
        paramInt3 *= 2;
        continue;
      }
      paramInt3++;
    }
    return paramInt3;
  }

  public static int a(e parame)
  {
    int i = parame.a();
    int j = parame.b();
    int k = b.a();
    int m = b.b();
    return Math.max((int)Math.ceil(i / k), (int)Math.ceil(j / m));
  }

  public static int a(e parame1, e parame2, h paramh, boolean paramBoolean)
  {
    int i = 1;
    int j = parame1.a();
    int k = parame1.b();
    int m = parame2.a();
    int n = parame2.b();
    int i1;
    switch (1.a[paramh.ordinal()])
    {
    default:
      i1 = i;
      if (i1 >= i)
        break;
    case 1:
    case 2:
    }
    while (true)
    {
      return a(j, k, i, paramBoolean);
      if (paramBoolean)
      {
        int i4 = j / 2;
        int i5 = k / 2;
        i1 = i;
        while ((i4 / i1 > m) || (i5 / i1 > n))
          i1 *= 2;
      }
      i1 = Math.max(j / m, k / n);
      break;
      if (paramBoolean)
      {
        int i2 = j / 2;
        int i3 = k / 2;
        i1 = i;
        while ((i2 / i1 > m) && (i3 / i1 > n))
          i1 *= 2;
        break;
      }
      i1 = Math.min(j / m, k / n);
      break;
      i = i1;
    }
  }

  public static e a(a parama, e parame)
  {
    int i = parama.a();
    if (i <= 0)
      i = parame.a();
    int j = parama.b();
    if (j <= 0)
      j = parame.b();
    return new e(i, j);
  }

  public static float b(e parame1, e parame2, h paramh, boolean paramBoolean)
  {
    int i = parame1.a();
    int j = parame1.b();
    int k = parame2.a();
    int m = parame2.b();
    float f1 = i / k;
    float f2 = j / m;
    int i2;
    int n;
    if (((paramh == h.a) && (f1 >= f2)) || ((paramh == h.b) && (f1 < f2)))
    {
      i2 = (int)(j / f1);
      n = k;
    }
    for (int i1 = i2; ; i1 = m)
    {
      float f3 = 1.0F;
      if (((!paramBoolean) && (n < i) && (i1 < j)) || ((paramBoolean) && (n != i) && (i1 != j)))
        f3 = n / i;
      return f3;
      n = (int)(i / f2);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.c.b
 * JD-Core Version:    0.6.0
 */