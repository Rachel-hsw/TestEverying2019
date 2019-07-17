package com.squareup.a;

import com.squareup.a.a.l;

public final class j
{
  private final String a;
  private final String b;

  public j(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof j)) && (l.a(this.a, ((j)paramObject).a)) && (l.a(this.b, ((j)paramObject).b));
  }

  public int hashCode()
  {
    if (this.b != null);
    for (int i = this.b.hashCode(); ; i = 0)
    {
      int j = 31 * (i + 899);
      String str = this.a;
      int k = 0;
      if (str != null)
        k = this.a.hashCode();
      return j + k;
    }
  }

  public String toString()
  {
    return this.a + " realm=\"" + this.b + "\"";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.j
 * JD-Core Version:    0.6.0
 */