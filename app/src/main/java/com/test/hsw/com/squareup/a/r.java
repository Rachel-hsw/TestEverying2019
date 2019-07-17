package com.squareup.a;

import com.squareup.a.a.a.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class r
{
  private final String[] a;

  private r(a parama)
  {
    this.a = ((String[])a.a(parama).toArray(new String[a.a(parama).size()]));
  }

  private static String a(String[] paramArrayOfString, String paramString)
  {
    for (int i = -2 + paramArrayOfString.length; i >= 0; i -= 2)
      if (paramString.equalsIgnoreCase(paramArrayOfString[i]))
        return paramArrayOfString[(i + 1)];
    return null;
  }

  public int a()
  {
    return this.a.length / 2;
  }

  public String a(int paramInt)
  {
    int i = paramInt * 2;
    if ((i < 0) || (i >= this.a.length))
      return null;
    return this.a[i];
  }

  public String a(String paramString)
  {
    return a(this.a, paramString);
  }

  public String b(int paramInt)
  {
    int i = 1 + paramInt * 2;
    if ((i < 0) || (i >= this.a.length))
      return null;
    return this.a[i];
  }

  public Date b(String paramString)
  {
    String str = a(paramString);
    if (str != null)
      return e.a(str);
    return null;
  }

  public Set<String> b()
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < a(); i++)
      localTreeSet.add(a(i));
    return Collections.unmodifiableSet(localTreeSet);
  }

  public a c()
  {
    a locala = new a();
    a.a(locala).addAll(Arrays.asList(this.a));
    return locala;
  }

  public List<String> c(String paramString)
  {
    ArrayList localArrayList = null;
    for (int i = 0; i < a(); i++)
    {
      if (!paramString.equalsIgnoreCase(a(i)))
        continue;
      if (localArrayList == null)
        localArrayList = new ArrayList(2);
      localArrayList.add(b(i));
    }
    if (localArrayList != null)
      return Collections.unmodifiableList(localArrayList);
    return Collections.emptyList();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < a(); i++)
      localStringBuilder.append(a(i)).append(": ").append(b(i)).append("\n");
    return localStringBuilder.toString();
  }

  public static class a
  {
    private final List<String> a = new ArrayList(20);

    private a c(String paramString1, String paramString2)
    {
      this.a.add(paramString1);
      this.a.add(paramString2.trim());
      return this;
    }

    a a(String paramString)
    {
      int i = paramString.indexOf(":", 1);
      if (i != -1)
        return c(paramString.substring(0, i), paramString.substring(i + 1));
      if (paramString.startsWith(":"))
        return c("", paramString.substring(1));
      return c("", paramString);
    }

    public a a(String paramString1, String paramString2)
    {
      if (paramString1 == null)
        throw new IllegalArgumentException("fieldname == null");
      if (paramString2 == null)
        throw new IllegalArgumentException("value == null");
      if ((paramString1.length() == 0) || (paramString1.indexOf(0) != -1) || (paramString2.indexOf(0) != -1))
        throw new IllegalArgumentException("Unexpected header: " + paramString1 + ": " + paramString2);
      return c(paramString1, paramString2);
    }

    public r a()
    {
      return new r(this, null);
    }

    public a b(String paramString)
    {
      for (int i = 0; i < this.a.size(); i += 2)
      {
        if (!paramString.equalsIgnoreCase((String)this.a.get(i)))
          continue;
        this.a.remove(i);
        this.a.remove(i);
        i -= 2;
      }
      return this;
    }

    public a b(String paramString1, String paramString2)
    {
      b(paramString1);
      a(paramString1, paramString2);
      return this;
    }

    public String c(String paramString)
    {
      for (int i = -2 + this.a.size(); i >= 0; i -= 2)
        if (paramString.equalsIgnoreCase((String)this.a.get(i)))
          return (String)this.a.get(i + 1);
      return null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.r
 * JD-Core Version:    0.6.0
 */