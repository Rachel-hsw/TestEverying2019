package org.a.a.a.h;

import C;
import java.util.Arrays;
import org.a.a.a.v;

public abstract class g
{
  private static final g a = new a(',');
  private static final g b = new a('\t');
  private static final g c = new a(' ');
  private static final g d = new b(" \t\n\r\f".toCharArray());
  private static final g e = new e();
  private static final g f = new a('\'');
  private static final g g = new a('"');
  private static final g h = new b("'\"".toCharArray());
  private static final g i = new c();

  public static g a()
  {
    return a;
  }

  public static g a(char paramChar)
  {
    return new a(paramChar);
  }

  public static g a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return i;
    if (paramString.length() == 1)
      return new a(paramString.charAt(0));
    return new b(paramString.toCharArray());
  }

  public static g a(char[] paramArrayOfChar)
  {
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0))
      return i;
    if (paramArrayOfChar.length == 1)
      return new a(paramArrayOfChar[0]);
    return new b(paramArrayOfChar);
  }

  public static g b()
  {
    return b;
  }

  public static g b(String paramString)
  {
    if (v.a(paramString))
      return i;
    return new d(paramString);
  }

  public static g c()
  {
    return c;
  }

  public static g d()
  {
    return d;
  }

  public static g e()
  {
    return e;
  }

  public static g f()
  {
    return f;
  }

  public static g g()
  {
    return g;
  }

  public static g h()
  {
    return h;
  }

  public static g i()
  {
    return i;
  }

  public int a(char[] paramArrayOfChar, int paramInt)
  {
    return a(paramArrayOfChar, paramInt, 0, paramArrayOfChar.length);
  }

  public abstract int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3);

  static final class a extends g
  {
    private final char a;

    a(char paramChar)
    {
      this.a = paramChar;
    }

    public int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.a == paramArrayOfChar[paramInt1])
        return 1;
      return 0;
    }
  }

  static final class b extends g
  {
    private final char[] a;

    b(char[] paramArrayOfChar)
    {
      this.a = ((char[])paramArrayOfChar.clone());
      Arrays.sort(this.a);
    }

    public int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      if (Arrays.binarySearch(this.a, paramArrayOfChar[paramInt1]) >= 0)
        return 1;
      return 0;
    }
  }

  static final class c extends g
  {
    public int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      return 0;
    }
  }

  static final class d extends g
  {
    private final char[] a;

    d(String paramString)
    {
      this.a = paramString.toCharArray();
    }

    public int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = this.a.length;
      if (paramInt1 + i > paramInt3)
        return 0;
      int j = 0;
      while (true)
      {
        if (j >= this.a.length)
          break label53;
        if (this.a[j] != paramArrayOfChar[paramInt1])
          break;
        j++;
        paramInt1++;
      }
      label53: return i;
    }
  }

  static final class e extends g
  {
    public int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramArrayOfChar[paramInt1] <= ' ')
        return 1;
      return 0;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.g
 * JD-Core Version:    0.6.0
 */