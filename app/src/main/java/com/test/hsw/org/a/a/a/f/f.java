package org.a.a.a.f;

public class f extends Number
  implements Comparable<f>, a<Number>
{
  private static final long a = 512176391864L;
  private int b;

  public f()
  {
  }

  public f(int paramInt)
  {
    this.b = paramInt;
  }

  public f(Number paramNumber)
  {
    this.b = paramNumber.intValue();
  }

  public f(String paramString)
    throws NumberFormatException
  {
    this.b = Integer.parseInt(paramString);
  }

  public int a(f paramf)
  {
    int i = paramf.b;
    if (this.b < i)
      return -1;
    if (this.b == i)
      return 0;
    return 1;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public void a(Number paramNumber)
  {
    this.b = paramNumber.intValue();
  }

  public Integer b()
  {
    return Integer.valueOf(this.b);
  }

  public void b(int paramInt)
  {
    this.b = (paramInt + this.b);
  }

  public void b(Number paramNumber)
  {
    this.b += paramNumber.intValue();
  }

  public void c()
  {
    this.b = (1 + this.b);
  }

  public void c(int paramInt)
  {
    this.b -= paramInt;
  }

  public void c(Number paramNumber)
  {
    this.b -= paramNumber.intValue();
  }

  public void d()
  {
    this.b = (-1 + this.b);
  }

  public double doubleValue()
  {
    return this.b;
  }

  public Integer e()
  {
    return Integer.valueOf(intValue());
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = paramObject instanceof f;
    int i = 0;
    if (bool)
    {
      int j = this.b;
      int k = ((f)paramObject).intValue();
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

  public String toString()
  {
    return String.valueOf(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.f.f
 * JD-Core Version:    0.6.0
 */