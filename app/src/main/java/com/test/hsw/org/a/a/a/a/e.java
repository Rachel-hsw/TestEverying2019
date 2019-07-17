package org.a.a.a.a;

final class e
{
  private final Object a;
  private final int b;

  public e(Object paramObject)
  {
    this.b = System.identityHashCode(paramObject);
    this.a = paramObject;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof e));
    e locale;
    do
    {
      return false;
      locale = (e)paramObject;
    }
    while ((this.b != locale.b) || (this.a != locale.a));
    return true;
  }

  public int hashCode()
  {
    return this.b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.a.e
 * JD-Core Version:    0.6.0
 */