package org.a.a.a.f;

public class d extends Number
  implements Comparable<d>, a<Number>
{
  private static final long a = 1587163916L;
  private double b;

  public d()
  {
  }

  public d(double paramDouble)
  {
    this.b = paramDouble;
  }

  public d(Number paramNumber)
  {
    this.b = paramNumber.doubleValue();
  }

  public d(String paramString)
    throws NumberFormatException
  {
    this.b = Double.parseDouble(paramString);
  }

  public int a(d paramd)
  {
    double d = paramd.b;
    return Double.compare(this.b, d);
  }

  public void a(double paramDouble)
  {
    this.b = paramDouble;
  }

  public void a(Number paramNumber)
  {
    this.b = paramNumber.doubleValue();
  }

  public Double b()
  {
    return Double.valueOf(this.b);
  }

  public void b(double paramDouble)
  {
    this.b = (paramDouble + this.b);
  }

  public void b(Number paramNumber)
  {
    this.b += paramNumber.doubleValue();
  }

  public void c(double paramDouble)
  {
    this.b -= paramDouble;
  }

  public void c(Number paramNumber)
  {
    this.b -= paramNumber.doubleValue();
  }

  public boolean c()
  {
    return Double.isNaN(this.b);
  }

  public boolean d()
  {
    return Double.isInfinite(this.b);
  }

  public double doubleValue()
  {
    return this.b;
  }

  public void e()
  {
    this.b = (1.0D + this.b);
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof d)) && (Double.doubleToLongBits(((d)paramObject).b) == Double.doubleToLongBits(this.b));
  }

  public void f()
  {
    this.b -= 1.0D;
  }

  public float floatValue()
  {
    return (float)this.b;
  }

  public Double g()
  {
    return Double.valueOf(doubleValue());
  }

  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.b);
    return (int)(l ^ l >>> 32);
  }

  public int intValue()
  {
    return (int)this.b;
  }

  public long longValue()
  {
    return ()this.b;
  }

  public String toString()
  {
    return String.valueOf(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.f.d
 * JD-Core Version:    0.6.0
 */