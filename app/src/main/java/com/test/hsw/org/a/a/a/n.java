package org.a.a.a;

public enum n
{
  private float j;
  private String k;

  static
  {
    n[] arrayOfn = new n[9];
    arrayOfn[0] = a;
    arrayOfn[1] = b;
    arrayOfn[2] = c;
    arrayOfn[3] = d;
    arrayOfn[4] = e;
    arrayOfn[5] = f;
    arrayOfn[6] = g;
    arrayOfn[7] = h;
    arrayOfn[8] = i;
    l = arrayOfn;
  }

  private n(float paramFloat, String paramString)
  {
    this.j = paramFloat;
    this.k = paramString;
  }

  static n a(String paramString)
  {
    return b(paramString);
  }

  static n b(String paramString)
  {
    if ("0.9".equals(paramString))
      return a;
    if ("1.1".equals(paramString))
      return b;
    if ("1.2".equals(paramString))
      return c;
    if ("1.3".equals(paramString))
      return d;
    if ("1.4".equals(paramString))
      return e;
    if ("1.5".equals(paramString))
      return f;
    if ("1.6".equals(paramString))
      return g;
    if ("1.7".equals(paramString))
      return h;
    if ("1.8".equals(paramString))
      return i;
    return null;
  }

  public boolean a(n paramn)
  {
    return this.j >= paramn.j;
  }

  public String toString()
  {
    return this.k;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.n
 * JD-Core Version:    0.6.0
 */