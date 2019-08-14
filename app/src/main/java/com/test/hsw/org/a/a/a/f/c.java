package org.a.a.a.f;

public class c extends Number
  implements Comparable<c>, a<Number>
{
  private static final long a = -1585823265L;
  private byte b;

  public c()
  {
  }

  public c(byte paramByte)
  {
    this.b = paramByte;
  }

  public c(Number paramNumber)
  {
    this.b = paramNumber.byteValue();
  }

  public c(String paramString)
    throws NumberFormatException
  {
    this.b = Byte.parseByte(paramString);
  }

  public int a(c paramc)
  {
    int i = paramc.b;
    if (this.b < i)
      return -1;
    if (this.b == i)
      return 0;
    return 1;
  }

  public void a(byte paramByte)
  {
    this.b = paramByte;
  }

  public void a(Number paramNumber)
  {
    this.b = paramNumber.byteValue();
  }

  public Byte b()
  {
    return Byte.valueOf(this.b);
  }

  public void b(byte paramByte)
  {
    this.b = (byte)(paramByte + this.b);
  }

  public void b(Number paramNumber)
  {
    this.b = (byte)(this.b + paramNumber.byteValue());
  }

  public byte byteValue()
  {
    return this.b;
  }

  public void c()
  {
    this.b = (byte)(1 + this.b);
  }

  public void c(byte paramByte)
  {
    this.b = (byte)(this.b - paramByte);
  }

  public void c(Number paramNumber)
  {
    this.b = (byte)(this.b - paramNumber.byteValue());
  }

  public void d()
  {
    this.b = (byte)(-1 + this.b);
  }

  public double doubleValue()
  {
    return this.b;
  }

  public Byte e()
  {
    return Byte.valueOf(byteValue());
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = paramObject instanceof c;
    int i = 0;
    if (bool)
    {
      int j = this.b;
      int k = ((c)paramObject).byteValue();
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
 * Qualified Name:     org.a.a.a.f.c
 * JD-Core Version:    0.6.0
 */