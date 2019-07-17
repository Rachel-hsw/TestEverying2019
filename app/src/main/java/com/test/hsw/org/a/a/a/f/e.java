package org.a.a.a.f;

public class e extends Number
  implements Comparable<e>, a<Number>
{
  private static final long a = 5787169186L;
  private float b;

  public e()
  {
  }

  public e(float paramFloat)
  {
    this.b = paramFloat;
  }

  public e(Number paramNumber)
  {
    this.b = paramNumber.floatValue();
  }

  public e(String paramString)
    throws NumberFormatException
  {
    this.b = Float.parseFloat(paramString);
  }

  public int a(e parame)
  {
    float f = parame.b;
    return Float.compare(this.b, f);
  }

  public void a(float paramFloat)
  {
    this.b = paramFloat;
  }

  public void a(Number paramNumber)
  {
    this.b = paramNumber.floatValue();
  }

  public Float b()
  {
    return Float.valueOf(this.b);
  }

  public void b(float paramFloat)
  {
    this.b = (paramFloat + this.b);
  }

  public void b(Number paramNumber)
  {
    this.b += paramNumber.floatValue();
  }

  public void c(float paramFloat)
  {
    this.b -= paramFloat;
  }

  public void c(Number paramNumber)
  {
    this.b -= paramNumber.floatValue();
  }

  public boolean c()
  {
    return Float.isNaN(this.b);
  }

  public boolean d()
  {
    return Float.isInfinite(this.b);
  }

  public double doubleValue()
  {
    return this.b;
  }

  public void e()
  {
    this.b = (1.0F + this.b);
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof e)) && (Float.floatToIntBits(((e)paramObject).b) == Float.floatToIntBits(this.b));
  }

  public void f()
  {
    this.b -= 1.0F;
  }

  public float floatValue()
  {
    return this.b;
  }

  public Float g()
  {
    return Float.valueOf(floatValue());
  }

  public int hashCode()
  {
    return Float.floatToIntBits(this.b);
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
 * Qualified Name:     org.a.a.a.f.e
 * JD-Core Version:    0.6.0
 */