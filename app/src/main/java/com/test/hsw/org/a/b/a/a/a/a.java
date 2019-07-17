package org.a.b.a.a.a;

public abstract class a
  implements c
{
  private final String a;
  private final String b;
  private final String c;

  public a(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("MIME type may not be null");
    this.a = paramString;
    int i = paramString.indexOf('/');
    if (i != -1)
    {
      this.b = paramString.substring(0, i);
      this.c = paramString.substring(i + 1);
      return;
    }
    this.b = paramString;
    this.c = null;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.b.a.a.a.a
 * JD-Core Version:    0.6.0
 */