package org.a.a.a;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class g
  implements Serializable, Iterable<Character>
{
  private static final long a = 8270183163158333422L;
  private final char b;
  private final char c;
  private final boolean d;
  private transient String e;

  private g(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    if (paramChar1 > paramChar2);
    while (true)
    {
      this.b = paramChar2;
      this.c = paramChar1;
      this.d = paramBoolean;
      return;
      char c1 = paramChar2;
      paramChar2 = paramChar1;
      paramChar1 = c1;
    }
  }

  public static g a(char paramChar)
  {
    return new g(paramChar, paramChar, false);
  }

  public static g a(char paramChar1, char paramChar2)
  {
    return new g(paramChar1, paramChar2, false);
  }

  public static g b(char paramChar)
  {
    return new g(paramChar, paramChar, true);
  }

  public static g b(char paramChar1, char paramChar2)
  {
    return new g(paramChar1, paramChar2, true);
  }

  public char a()
  {
    return this.b;
  }

  public boolean a(g paramg)
  {
    if (paramg == null)
      throw new IllegalArgumentException("The Range must not be null");
    if (this.d)
      if (paramg.d)
        if ((this.b < paramg.b) || (this.c > paramg.c));
    do
      while (true)
      {
        return true;
        return false;
        int i;
        if (paramg.c >= this.b)
        {
          int j = paramg.b;
          int k = this.c;
          i = 0;
          if (j <= k);
        }
        else
        {
          i = 1;
        }
        return i;
        if (!paramg.d)
          break;
        if ((this.b != 0) || (this.c != 65535))
          return false;
      }
    while ((this.b <= paramg.b) && (this.c >= paramg.c));
    return false;
  }

  public char b()
  {
    return this.c;
  }

  public boolean c()
  {
    return this.d;
  }

  public boolean c(char paramChar)
  {
    if ((paramChar >= this.b) && (paramChar <= this.c));
    for (int i = 1; i != this.d; i = 0)
      return true;
    return false;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    g localg;
    do
    {
      return true;
      if (!(paramObject instanceof g))
        return false;
      localg = (g)paramObject;
    }
    while ((this.b == localg.b) && (this.c == localg.c) && (this.d == localg.d));
    return false;
  }

  public int hashCode()
  {
    int i = 'S' + this.b + '\007' * this.c;
    if (this.d);
    for (int j = 1; ; j = 0)
      return j + i;
  }

  public Iterator<Character> iterator()
  {
    return new a(this, null);
  }

  public String toString()
  {
    if (this.e == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(4);
      if (c())
        localStringBuilder.append('^');
      localStringBuilder.append(this.b);
      if (this.b != this.c)
      {
        localStringBuilder.append('-');
        localStringBuilder.append(this.c);
      }
      this.e = localStringBuilder.toString();
    }
    return this.e;
  }

  private static class a
    implements Iterator<Character>
  {
    private char a;
    private final g b;
    private boolean c;

    private a(g paramg)
    {
      this.b = paramg;
      this.c = true;
      if (g.b(this.b))
      {
        if (g.c(this.b) == 0)
        {
          if (g.d(this.b) == 65535)
          {
            this.c = false;
            return;
          }
          this.a = (char)('\001' + g.d(this.b));
          return;
        }
        this.a = '\000';
        return;
      }
      this.a = g.c(this.b);
    }

    private void b()
    {
      if (g.b(this.b))
      {
        if (this.a == 65535)
        {
          this.c = false;
          return;
        }
        if ('\001' + this.a == g.c(this.b))
        {
          if (g.d(this.b) == 65535)
          {
            this.c = false;
            return;
          }
          this.a = (char)('\001' + g.d(this.b));
          return;
        }
        this.a = (char)('\001' + this.a);
        return;
      }
      if (this.a < g.d(this.b))
      {
        this.a = (char)('\001' + this.a);
        return;
      }
      this.c = false;
    }

    public Character a()
    {
      if (!this.c)
        throw new NoSuchElementException();
      char c1 = this.a;
      b();
      return Character.valueOf(c1);
    }

    public boolean hasNext()
    {
      return this.c;
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.g
 * JD-Core Version:    0.6.0
 */