package org.a.a.a.f;

public class i extends Number
  implements Comparable<i>, a<Number>
{
  private static final long a = -2135791679L;
  private short b;

  public i()
  {
  }

  public i(Number paramNumber)
  {
    this.b = paramNumber.shortValue();
  }

  public i(String paramString)
    throws NumberFormatException
  {
    this.b = Short.parseShort(paramString);
  }

  public i(short paramShort)
  {
    this.b = paramShort;
  }

  public int a(i parami)
  {
    int i = parami.b;
    if (this.b < i)
      return -1;
    if (this.b == i)
      return 0;
    return 1;
  }

  public void a(Number paramNumber)
  {
    this.b = paramNumber.shortValue();
  }

  public void a(short paramShort)
  {
    this.b = paramShort;
  }

  public Short b()
  {
    return Short.valueOf(this.b);
  }

  public void b(Number paramNumber)
  {
    this.b = (short)(this.b + paramNumber.shortValue());
  }

  public void b(short paramShort)
  {
    this.b = (short)(paramShort + this.b);
  }

  public void c()
  {
    this.b = (short)(1 + this.b);
  }

  public void c(Number paramNumber)
  {
    this.b = (short)(this.b - paramNumber.shortValue());
  }

  public void c(short paramShort)
  {
    this.b = (short)(this.b - paramShort);
  }

  public void d()
  {
    this.b = (short)(-1 + this.b);
  }

  public double doubleValue()
  {
    return this.b;
  }

  public Short e()
  {
    return Short.valueOf(shortValue());
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = paramObject instanceof i;
    int i = 0;
    if (bool)
    {
      int j = this.b;
      int k = ((i)paramObject).shortValue();
      i = 0;
      if (j == k)
        i = 1;
    }
    return i;
  }

  public float floatValue()
  {
    return this.b;
  }

  public int hashCode()
  {
    return this.b;
  }

  public int intValue()
  {
    return this.b;
  }

  public long longValue()
  {
    return this.b;
  }

  public short shortValue()
  {
    return this.b;
  }

  public String toString()
  {
    return String.valueOf(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.f.i
 * JD-Core Version:    0.6.0
 */