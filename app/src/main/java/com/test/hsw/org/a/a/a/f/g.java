package org.a.a.a.f;

public class g extends Number
  implements Comparable<g>, a<Number>
{
  private static final long a = 62986528375L;
  private long b;

  public g()
  {
  }

  public g(long paramLong)
  {
    this.b = paramLong;
  }

  public g(Number paramNumber)
  {
    this.b = paramNumber.longValue();
  }

  public g(String paramString)
    throws NumberFormatException
  {
    this.b = Long.parseLong(paramString);
  }

  public int a(g paramg)
  {
    long l = paramg.b;
    if (this.b < l)
      return -1;
    if (this.b == l)
      return 0;
    return 1;
  }

  public void a(long paramLong)
  {
    this.b = paramLong;
  }

  public void a(Number paramNumber)
  {
    this.b = paramNumber.longValue();
  }

  public Long b()
  {
    return Long.valueOf(this.b);
  }

  public void b(long paramLong)
  {
    this.b = (paramLong + this.b);
  }

  public void b(Number paramNumber)
  {
    this.b += paramNumber.longValue();
  }

  public void c()
  {
    this.b = (1L + this.b);
  }

  public void c(long paramLong)
  {
    this.b -= paramLong;
  }

  public void c(Number paramNumber)
  {
    this.b -= paramNumber.longValue();
  }

  public void d()
  {
    this.b -= 1L;
  }

  public double doubleValue()
  {
    return this.b;
  }

  public Long e()
  {
    return Long.valueOf(longValue());
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof g;
    int i = 0;
    if (bool1)
    {
      boolean bool2 = this.b < ((g)paramObject).longValue();
      i = 0;
      if (!bool2)
        i = 1;
    }
    return i;
  }

  public float floatValue()
  {
    return (float)this.b;
  }

  public int hashCode()
  {
    return (int)(this.b ^ this.b >>> 32);
  }

  public int intValue()
  {
    return (int)this.b;
  }

  public long longValue()
  {
    return this.b;
  }

  public String toString()
  {
    return String.valueOf(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.f.g
 * JD-Core Version:    0.6.0
 */