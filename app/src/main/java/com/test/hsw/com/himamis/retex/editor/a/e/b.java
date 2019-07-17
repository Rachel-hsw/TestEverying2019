package com.himamis.retex.editor.a.e;

import java.util.Iterator;
import java.util.List;

public class b
  implements g
{
  private List<e> a;
  private String b;
  private String c;

  b(String paramString1, String paramString2, List<e> paramList, int paramInt)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.a = paramList;
  }

  public e a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    e locale;
    do
    {
      if (!localIterator.hasNext())
        return null;
      locale = (e)localIterator.next();
    }
    while (!locale.b().equals(paramString));
    return locale;
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public List<e> c()
  {
    return this.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.e.b
 * JD-Core Version:    0.6.0
 */