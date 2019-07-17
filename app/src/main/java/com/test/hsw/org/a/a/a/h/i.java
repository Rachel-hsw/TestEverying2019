package org.a.a.a.h;

import C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.a.a.a.c;

public class i
  implements Cloneable, ListIterator<String>
{
  private static final i a = new i();
  private static final i b;
  private char[] c;
  private String[] d;
  private int e;
  private g f = g.d();
  private g g = g.i();
  private g h = g.i();
  private g i = g.i();
  private boolean j = false;
  private boolean k = true;

  static
  {
    a.a(g.a());
    a.b(g.g());
    a.c(g.i());
    a.d(g.e());
    a.a(false);
    a.b(false);
    b = new i();
    b.a(g.b());
    b.b(g.g());
    b.c(g.i());
    b.d(g.e());
    b.a(false);
    b.b(false);
  }

  public i()
  {
    this.c = null;
  }

  public i(String paramString)
  {
    if (paramString != null)
    {
      this.c = paramString.toCharArray();
      return;
    }
    this.c = null;
  }

  public i(String paramString, char paramChar)
  {
    this(paramString);
    a(paramChar);
  }

  public i(String paramString, char paramChar1, char paramChar2)
  {
    this(paramString, paramChar1);
    b(paramChar2);
  }

  public i(String paramString1, String paramString2)
  {
    this(paramString1);
    f(paramString2);
  }

  public i(String paramString, g paramg)
  {
    this(paramString);
    a(paramg);
  }

  public i(String paramString, g paramg1, g paramg2)
  {
    this(paramString, paramg1);
    b(paramg2);
  }

  public i(char[] paramArrayOfChar)
  {
    this.c = c.a(paramArrayOfChar);
  }

  public i(char[] paramArrayOfChar, char paramChar)
  {
    this(paramArrayOfChar);
    a(paramChar);
  }

  public i(char[] paramArrayOfChar, char paramChar1, char paramChar2)
  {
    this(paramArrayOfChar, paramChar1);
    b(paramChar2);
  }

  public i(char[] paramArrayOfChar, String paramString)
  {
    this(paramArrayOfChar);
    f(paramString);
  }

  public i(char[] paramArrayOfChar, g paramg)
  {
    this(paramArrayOfChar);
    a(paramg);
  }

  public i(char[] paramArrayOfChar, g paramg1, g paramg2)
  {
    this(paramArrayOfChar, paramg1);
    b(paramg2);
  }

  private int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, e parame, List<String> paramList)
  {
    int m = paramInt1;
    while (true)
    {
      int i2;
      if (m < paramInt2)
      {
        i2 = Math.max(n().a(paramArrayOfChar, m, m, paramInt2), o().a(paramArrayOfChar, m, m, paramInt2));
        if ((i2 != 0) && (l().a(paramArrayOfChar, m, m, paramInt2) <= 0) && (m().a(paramArrayOfChar, m, m, paramInt2) <= 0));
      }
      else
      {
        if (m < paramInt2)
          break;
        a(paramList, "");
        return -1;
      }
      m += i2;
    }
    int n = l().a(paramArrayOfChar, m, m, paramInt2);
    if (n > 0)
    {
      a(paramList, "");
      return n + m;
    }
    int i1 = m().a(paramArrayOfChar, m, m, paramInt2);
    if (i1 > 0)
      return a(paramArrayOfChar, m + i1, paramInt2, parame, paramList, m, i1);
    return a(paramArrayOfChar, m, paramInt2, parame, paramList, 0, 0);
  }

  private int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, e parame, List<String> paramList, int paramInt3, int paramInt4)
  {
    parame.g();
    int m;
    int n;
    int i1;
    int i2;
    if (paramInt4 > 0)
    {
      m = 1;
      n = 0;
      i1 = m;
      i2 = paramInt1;
    }
    while (true)
    {
      if (i2 >= paramInt2)
        break label318;
      if (i1 != 0)
      {
        if (a(paramArrayOfChar, i2, paramInt2, paramInt3, paramInt4))
        {
          if (a(paramArrayOfChar, i2 + paramInt4, paramInt2, paramInt3, paramInt4))
          {
            parame.a(paramArrayOfChar, i2, paramInt4);
            i2 += paramInt4 * 2;
            n = parame.e();
            continue;
            m = 0;
            break;
          }
          i2 += paramInt4;
          i1 = 0;
          continue;
        }
        int i7 = i2 + 1;
        parame.a(paramArrayOfChar[i2]);
        n = parame.e();
        i2 = i7;
        continue;
      }
      int i3 = l().a(paramArrayOfChar, i2, paramInt1, paramInt2);
      if (i3 > 0)
      {
        a(paramList, parame.d(0, n));
        return i3 + i2;
      }
      if ((paramInt4 > 0) && (a(paramArrayOfChar, i2, paramInt2, paramInt3, paramInt4)))
      {
        i2 += paramInt4;
        i1 = 1;
        continue;
      }
      int i4 = n().a(paramArrayOfChar, i2, paramInt1, paramInt2);
      if (i4 > 0)
      {
        i2 += i4;
        continue;
      }
      int i5 = o().a(paramArrayOfChar, i2, paramInt1, paramInt2);
      if (i5 > 0)
      {
        parame.a(paramArrayOfChar, i2, i5);
        i2 += i5;
        continue;
      }
      int i6 = i2 + 1;
      parame.a(paramArrayOfChar[i2]);
      n = parame.e();
      i2 = i6;
    }
    label318: a(paramList, parame.d(0, n));
    return -1;
  }

  public static i a(String paramString)
  {
    i locali = s();
    locali.c(paramString);
    return locali;
  }

  public static i a(char[] paramArrayOfChar)
  {
    i locali = s();
    locali.c(paramArrayOfChar);
    return locali;
  }

  private void a(List<String> paramList, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (q())
        return;
      if (p())
        paramString = null;
    }
    paramList.add(paramString);
  }

  private boolean a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (int m = 0; m < paramInt4; m++)
      if ((paramInt1 + m >= paramInt2) || (paramArrayOfChar[(paramInt1 + m)] != paramArrayOfChar[(paramInt3 + m)]))
        return false;
    return true;
  }

  public static i b()
  {
    return s();
  }

  public static i b(String paramString)
  {
    i locali = t();
    locali.c(paramString);
    return locali;
  }

  public static i b(char[] paramArrayOfChar)
  {
    i locali = t();
    locali.c(paramArrayOfChar);
    return locali;
  }

  public static i c()
  {
    return t();
  }

  private static i s()
  {
    return (i)a.clone();
  }

  private static i t()
  {
    return (i)b.clone();
  }

  private void u()
  {
    if (this.d == null)
    {
      if (this.c == null)
      {
        List localList2 = a(null, 0, 0);
        this.d = ((String[])localList2.toArray(new String[localList2.size()]));
      }
    }
    else
      return;
    List localList1 = a(this.c, 0, this.c.length);
    this.d = ((String[])localList1.toArray(new String[localList1.size()]));
  }

  public String a()
  {
    if (this.c == null)
      return null;
    return new String(this.c);
  }

  protected List<String> a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramArrayOfChar == null) || (paramInt2 == 0))
      localObject = Collections.emptyList();
    while (true)
    {
      return localObject;
      e locale = new e();
      localObject = new ArrayList();
      int m = paramInt1;
      while ((m >= 0) && (m < paramInt2))
      {
        m = a(paramArrayOfChar, m, paramInt2, locale, (List)localObject);
        if (m < paramInt2)
          continue;
        a((List)localObject, "");
      }
    }
  }

  public i a(char paramChar)
  {
    return a(g.a(paramChar));
  }

  public i a(g paramg)
  {
    if (paramg == null)
    {
      this.f = g.i();
      return this;
    }
    this.f = paramg;
    return this;
  }

  public i a(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }

  public i b(char paramChar)
  {
    return b(g.a(paramChar));
  }

  public i b(g paramg)
  {
    if (paramg != null)
      this.g = paramg;
    return this;
  }

  public i b(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }

  public i c(char paramChar)
  {
    return c(g.a(paramChar));
  }

  public i c(String paramString)
  {
    i();
    if (paramString != null)
    {
      this.c = paramString.toCharArray();
      return this;
    }
    this.c = null;
    return this;
  }

  public i c(g paramg)
  {
    if (paramg != null)
      this.h = paramg;
    return this;
  }

  public i c(char[] paramArrayOfChar)
  {
    i();
    this.c = c.a(paramArrayOfChar);
    return this;
  }

  public Object clone()
  {
    try
    {
      Object localObject = r();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    return null;
  }

  public int d()
  {
    u();
    return this.d.length;
  }

  public i d(g paramg)
  {
    if (paramg != null)
      this.i = paramg;
    return this;
  }

  public void d(String paramString)
  {
    throw new UnsupportedOperationException("set() is unsupported");
  }

  public String e()
  {
    if (hasNext())
    {
      String[] arrayOfString = this.d;
      int m = this.e;
      this.e = (m + 1);
      return arrayOfString[m];
    }
    return null;
  }

  public void e(String paramString)
  {
    throw new UnsupportedOperationException("add() is unsupported");
  }

  public String f()
  {
    if (hasPrevious())
    {
      String[] arrayOfString = this.d;
      int m = -1 + this.e;
      this.e = m;
      return arrayOfString[m];
    }
    return null;
  }

  public i f(String paramString)
  {
    return a(g.b(paramString));
  }

  public String[] g()
  {
    u();
    return (String[])this.d.clone();
  }

  public List<String> h()
  {
    u();
    ArrayList localArrayList = new ArrayList(this.d.length);
    String[] arrayOfString = this.d;
    int m = arrayOfString.length;
    for (int n = 0; n < m; n++)
      localArrayList.add(arrayOfString[n]);
    return localArrayList;
  }

  public boolean hasNext()
  {
    u();
    return this.e < this.d.length;
  }

  public boolean hasPrevious()
  {
    u();
    return this.e > 0;
  }

  public i i()
  {
    this.e = 0;
    this.d = null;
    return this;
  }

  public String j()
  {
    if (hasNext())
    {
      String[] arrayOfString = this.d;
      int m = this.e;
      this.e = (m + 1);
      return arrayOfString[m];
    }
    throw new NoSuchElementException();
  }

  public String k()
  {
    if (hasPrevious())
    {
      String[] arrayOfString = this.d;
      int m = -1 + this.e;
      this.e = m;
      return arrayOfString[m];
    }
    throw new NoSuchElementException();
  }

  public g l()
  {
    return this.f;
  }

  public g m()
  {
    return this.g;
  }

  public g n()
  {
    return this.h;
  }

  public int nextIndex()
  {
    return this.e;
  }

  public g o()
  {
    return this.i;
  }

  public boolean p()
  {
    return this.j;
  }

  public int previousIndex()
  {
    return -1 + this.e;
  }

  public boolean q()
  {
    return this.k;
  }

  Object r()
    throws CloneNotSupportedException
  {
    i locali = (i)super.clone();
    if (locali.c != null)
      locali.c = ((char[])locali.c.clone());
    locali.i();
    return locali;
  }

  public void remove()
  {
    throw new UnsupportedOperationException("remove() is unsupported");
  }

  public String toString()
  {
    if (this.d == null)
      return "StrTokenizer[not tokenized yet]";
    return "StrTokenizer" + h();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.i
 * JD-Core Version:    0.6.0
 */