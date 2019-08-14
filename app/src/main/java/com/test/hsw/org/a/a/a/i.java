package org.a.a.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class i
  implements Serializable
{
  public static final i a;
  public static final i b;
  public static final i c;
  public static final i d;
  public static final i e;
  protected static final Map<String, i> f;
  private static final long g = 5947847346149275958L;
  private final Set<g> h = Collections.synchronizedSet(new HashSet());

  static
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ((String)null);
    a = new i(arrayOfString);
    b = new i(new String[] { "a-zA-Z" });
    c = new i(new String[] { "a-z" });
    d = new i(new String[] { "A-Z" });
    e = new i(new String[] { "0-9" });
    f = Collections.synchronizedMap(new HashMap());
    f.put(null, a);
    f.put("", a);
    f.put("a-zA-Z", b);
    f.put("A-Za-z", b);
    f.put("a-z", c);
    f.put("A-Z", d);
    f.put("0-9", e);
  }

  protected i(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
      a(paramArrayOfString[j]);
  }

  public static i a(String[] paramArrayOfString)
  {
    i locali;
    if (paramArrayOfString == null)
      locali = null;
    do
    {
      return locali;
      if (paramArrayOfString.length != 1)
        break;
      locali = (i)f.get(paramArrayOfString[0]);
    }
    while (locali != null);
    return new i(paramArrayOfString);
  }

  protected void a(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      int i = paramString.length();
      int j = 0;
      while (j < i)
      {
        int k = i - j;
        if ((k >= 4) && (paramString.charAt(j) == '^') && (paramString.charAt(j + 2) == '-'))
        {
          this.h.add(g.b(paramString.charAt(j + 1), paramString.charAt(j + 3)));
          j += 4;
          continue;
        }
        if ((k >= 3) && (paramString.charAt(j + 1) == '-'))
        {
          this.h.add(g.a(paramString.charAt(j), paramString.charAt(j + 2)));
          j += 3;
          continue;
        }
        if ((k >= 2) && (paramString.charAt(j) == '^'))
        {
          this.h.add(g.b(paramString.charAt(j + 1)));
          j += 2;
          continue;
        }
        this.h.add(g.a(paramString.charAt(j)));
        j++;
      }
    }
  }

  public boolean a(char paramChar)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
      if (((g)localIterator.next()).c(paramChar))
        return true;
    return false;
  }

  g[] a()
  {
    return (g[])this.h.toArray(new g[this.h.size()]);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof i))
      return false;
    i locali = (i)paramObject;
    return this.h.equals(locali.h);
  }

  public int hashCode()
  {
    return 89 + this.h.hashCode();
  }

  public String toString()
  {
    return this.h.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.i
 * JD-Core Version:    0.6.0
 */