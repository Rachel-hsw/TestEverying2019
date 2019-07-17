package org.a.a.a.e;

import java.math.BigInteger;

public final class a extends Number
  implements Comparable<a>
{
  public static final a a = new a(0, 1);
  public static final a b = new a(1, 1);
  public static final a c = new a(1, 2);
  public static final a d = new a(1, 3);
  public static final a e = new a(2, 3);
  public static final a f = new a(1, 4);
  public static final a g = new a(2, 4);
  public static final a h = new a(3, 4);
  public static final a i = new a(1, 5);
  public static final a j = new a(2, 5);
  public static final a k = new a(3, 5);
  public static final a l = new a(4, 5);
  private static final long m = 65382027393090L;
  private final int n;
  private final int o;
  private transient int p = 0;
  private transient String q = null;
  private transient String r = null;

  private a(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.o = paramInt2;
  }

  public static a a(double paramDouble)
  {
    if (paramDouble < 0.0D);
    double d1;
    for (int i1 = -1; ; i1 = 1)
    {
      d1 = Math.abs(paramDouble);
      if ((d1 <= 2147483647.0D) && (!Double.isNaN(d1)))
        break;
      throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
    }
    int i2 = (int)d1;
    double d2 = d1 - i2;
    int i3 = (int)d2;
    double d3 = d2 - i3;
    double d4 = 1.7976931348623157E+308D;
    int i4 = 1;
    int i5 = 1;
    int i6 = 0;
    int i7 = 0;
    int i8 = 1;
    int i9 = i3;
    double d5 = 1.0D;
    double d6 = d3;
    while (true)
    {
      int i10 = (int)(d5 / d6);
      double d7 = d5 - d6 * i10;
      int i11 = i6 + i9 * i8;
      int i12 = i5 + i9 * i7;
      double d8 = Math.abs(d2 - i11 / i12);
      i4++;
      if ((d4 <= d8) || (i12 > 10000) || (i12 <= 0) || (i4 >= 25))
      {
        if (i4 == 25)
          throw new ArithmeticException("Unable to convert double to fraction");
        return b(i1 * (i8 + i2 * i7), i7);
      }
      d4 = d8;
      i5 = i7;
      d5 = d6;
      i7 = i12;
      i9 = i10;
      d6 = d7;
      i6 = i8;
      i8 = i11;
    }
  }

  public static a a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      throw new ArithmeticException("The denominator must not be zero");
    if (paramInt2 < 0)
    {
      if ((paramInt1 == -2147483648) || (paramInt2 == -2147483648))
        throw new ArithmeticException("overflow: can't negate");
      paramInt1 = -paramInt1;
      paramInt2 = -paramInt2;
    }
    return new a(paramInt1, paramInt2);
  }

  public static a a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
      throw new ArithmeticException("The denominator must not be zero");
    if (paramInt3 < 0)
      throw new ArithmeticException("The denominator must not be negative");
    if (paramInt2 < 0)
      throw new ArithmeticException("The numerator must not be negative");
    long l1;
    if (paramInt1 < 0)
      l1 = paramInt1 * paramInt3 - paramInt2;
    while ((l1 < -2147483648L) || (l1 > 2147483647L))
    {
      throw new ArithmeticException("Numerator too large to represent as an Integer.");
      l1 = paramInt1 * paramInt3 + paramInt2;
    }
    return new a((int)l1, paramInt3);
  }

  public static a a(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("The string must not be null");
    if (paramString.indexOf('.') >= 0)
      return a(Double.parseDouble(paramString));
    int i1 = paramString.indexOf(' ');
    if (i1 > 0)
    {
      int i3 = Integer.parseInt(paramString.substring(0, i1));
      String str = paramString.substring(i1 + 1);
      int i4 = str.indexOf('/');
      if (i4 < 0)
        throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
      return a(i3, Integer.parseInt(str.substring(0, i4)), Integer.parseInt(str.substring(i4 + 1)));
    }
    int i2 = paramString.indexOf('/');
    if (i2 < 0)
      return a(Integer.parseInt(paramString), 1);
    return a(Integer.parseInt(paramString.substring(0, i2)), Integer.parseInt(paramString.substring(i2 + 1)));
  }

  private a a(a parama, boolean paramBoolean)
  {
    if (parama == null)
      throw new IllegalArgumentException("The fraction must not be null");
    if (this.n == 0)
    {
      if (paramBoolean)
        return parama;
      return parama.g();
    }
    if (parama.n == 0)
      return this;
    int i1 = c(this.o, parama.o);
    if (i1 == 1)
    {
      int i5 = d(this.n, parama.o);
      int i6 = d(parama.n, this.o);
      if (paramBoolean);
      for (int i7 = f(i5, i6); ; i7 = g(i5, i6))
        return new a(i7, e(this.o, parama.o));
    }
    BigInteger localBigInteger1 = BigInteger.valueOf(this.n).multiply(BigInteger.valueOf(parama.o / i1));
    BigInteger localBigInteger2 = BigInteger.valueOf(parama.n).multiply(BigInteger.valueOf(this.o / i1));
    BigInteger localBigInteger3;
    int i2;
    if (paramBoolean)
    {
      localBigInteger3 = localBigInteger1.add(localBigInteger2);
      i2 = localBigInteger3.mod(BigInteger.valueOf(i1)).intValue();
      if (i2 != 0)
        break label257;
    }
    BigInteger localBigInteger4;
    label257: int i4;
    for (int i3 = i1; ; i4 = c(i2, i1))
    {
      localBigInteger4 = localBigInteger3.divide(BigInteger.valueOf(i3));
      if (localBigInteger4.bitLength() <= 31)
        break label268;
      throw new ArithmeticException("overflow: numerator too large after multiply");
      localBigInteger3 = localBigInteger1.subtract(localBigInteger2);
      break;
    }
    label268: return new a(localBigInteger4.intValue(), e(this.o / i1, parama.o / i4));
  }

  public static a b(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      throw new ArithmeticException("The denominator must not be zero");
    if (paramInt1 == 0)
      return a;
    int i4;
    int i1;
    if ((paramInt2 == -2147483648) && ((paramInt1 & 0x1) == 0))
    {
      i4 = paramInt1 / 2;
      i1 = paramInt2 / 2;
    }
    for (int i2 = i4; ; i2 = paramInt1)
    {
      if (i1 < 0)
      {
        if ((i2 == -2147483648) || (i1 == -2147483648))
          throw new ArithmeticException("overflow: can't negate");
        i2 = -i2;
        i1 = -i1;
      }
      int i3 = c(i2, i1);
      return new a(i2 / i3, i1 / i3);
      i1 = paramInt2;
    }
  }

  private static int c(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      if ((paramInt1 == -2147483648) || (paramInt2 == -2147483648))
        throw new ArithmeticException("overflow: gcd is 2^31");
      return Math.abs(paramInt1) + Math.abs(paramInt2);
    }
    if ((Math.abs(paramInt1) == 1) || (Math.abs(paramInt2) == 1))
      return 1;
    if (paramInt1 > 0);
    for (int i1 = -paramInt1; ; i1 = paramInt1)
    {
      if (paramInt2 > 0)
        paramInt2 = -paramInt2;
      int i2 = 0;
      int i3 = paramInt2;
      while (((i1 & 0x1) == 0) && ((i3 & 0x1) == 0) && (i2 < 31))
      {
        i1 /= 2;
        i3 /= 2;
        i2++;
      }
      if (i2 == 31)
        throw new ArithmeticException("overflow: gcd is 2^31");
      int i4;
      int i6;
      int i7;
      if ((i1 & 0x1) == 1)
      {
        i4 = i3;
        int i5 = i4;
        i6 = i3;
        i7 = i5;
      }
      while (true)
      {
        if ((i7 & 0x1) == 0)
        {
          i7 /= 2;
          continue;
          i4 = -(i1 / 2);
          break;
        }
        if (i7 > 0);
        int i9;
        for (int i8 = -i7; ; i8 = i1)
        {
          i9 = (i6 - i8) / 2;
          if (i9 != 0)
            break;
          return -i8 * (1 << i2);
          i6 = i7;
        }
        i1 = i8;
        i7 = i9;
      }
    }
  }

  private static int d(int paramInt1, int paramInt2)
  {
    long l1 = paramInt1 * paramInt2;
    if ((l1 < -2147483648L) || (l1 > 2147483647L))
      throw new ArithmeticException("overflow: mul");
    return (int)l1;
  }

  private static int e(int paramInt1, int paramInt2)
  {
    long l1 = paramInt1 * paramInt2;
    if (l1 > 2147483647L)
      throw new ArithmeticException("overflow: mulPos");
    return (int)l1;
  }

  private static int f(int paramInt1, int paramInt2)
  {
    long l1 = paramInt1 + paramInt2;
    if ((l1 < -2147483648L) || (l1 > 2147483647L))
      throw new ArithmeticException("overflow: add");
    return (int)l1;
  }

  private static int g(int paramInt1, int paramInt2)
  {
    long l1 = paramInt1 - paramInt2;
    if ((l1 < -2147483648L) || (l1 > 2147483647L))
      throw new ArithmeticException("overflow: add");
    return (int)l1;
  }

  public int a()
  {
    return this.n;
  }

  public a a(int paramInt)
  {
    if (paramInt == 1)
      return this;
    if (paramInt == 0)
      return b;
    if (paramInt < 0)
    {
      if (paramInt == -2147483648)
        return f().a(2).a(-(paramInt / 2));
      return f().a(-paramInt);
    }
    a locala = c(this);
    if (paramInt % 2 == 0)
      return locala.a(paramInt / 2);
    return locala.a(paramInt / 2).c(this);
  }

  public a a(a parama)
  {
    return a(parama, true);
  }

  public int b()
  {
    return this.o;
  }

  public a b(a parama)
  {
    return a(parama, false);
  }

  public int c()
  {
    return Math.abs(this.n % this.o);
  }

  public a c(a parama)
  {
    if (parama == null)
      throw new IllegalArgumentException("The fraction must not be null");
    if ((this.n == 0) || (parama.n == 0))
      return a;
    int i1 = c(this.n, parama.o);
    int i2 = c(parama.n, this.o);
    return b(d(this.n / i1, parama.n / i2), e(this.o / i2, parama.o / i1));
  }

  public int d()
  {
    return this.n / this.o;
  }

  public a d(a parama)
  {
    if (parama == null)
      throw new IllegalArgumentException("The fraction must not be null");
    if (parama.n == 0)
      throw new ArithmeticException("The fraction to divide by must not be zero");
    return c(parama.f());
  }

  public double doubleValue()
  {
    return this.n / this.o;
  }

  public int e(a parama)
  {
    if (this == parama);
    long l1;
    long l2;
    do
    {
      do
        return 0;
      while ((this.n == parama.n) && (this.o == parama.o));
      l1 = this.n * parama.o;
      l2 = parama.n * this.o;
    }
    while (l1 == l2);
    if (l1 < l2)
      return -1;
    return 1;
  }

  public a e()
  {
    if (this.n == 0)
      if (!equals(a));
    int i1;
    do
    {
      return this;
      return a;
      i1 = c(Math.abs(this.n), this.o);
    }
    while (i1 == 1);
    return a(this.n / i1, this.o / i1);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    a locala;
    do
    {
      return true;
      if (!(paramObject instanceof a))
        return false;
      locala = (a)paramObject;
    }
    while ((a() == locala.a()) && (b() == locala.b()));
    return false;
  }

  public a f()
  {
    if (this.n == 0)
      throw new ArithmeticException("Unable to invert zero.");
    if (this.n == -2147483648)
      throw new ArithmeticException("overflow: can't negate numerator");
    if (this.n < 0)
      return new a(-this.o, -this.n);
    return new a(this.o, this.n);
  }

  public float floatValue()
  {
    return this.n / this.o;
  }

  public a g()
  {
    if (this.n == -2147483648)
      throw new ArithmeticException("overflow: too large to negate");
    return new a(-this.n, this.o);
  }

  public a h()
  {
    if (this.n >= 0)
      return this;
    return g();
  }

  public int hashCode()
  {
    if (this.p == 0)
      this.p = (37 * (629 + a()) + b());
    return this.p;
  }

  public String i()
  {
    if (this.r == null)
    {
      if (this.n != 0)
        break label25;
      this.r = "0";
    }
    while (true)
    {
      return this.r;
      label25: if (this.n == this.o)
      {
        this.r = "1";
        continue;
      }
      if (this.n == -1 * this.o)
      {
        this.r = "-1";
        continue;
      }
      if (this.n > 0);
      int i2;
      for (int i1 = -this.n; ; i1 = this.n)
      {
        if (i1 >= -this.o)
          break label169;
        i2 = c();
        if (i2 != 0)
          break label122;
        this.r = Integer.toString(d());
        break;
      }
      label122: this.r = (32 + d() + ' ' + i2 + '/' + b());
      continue;
      label169: this.r = (32 + a() + '/' + b());
    }
  }

  public int intValue()
  {
    return this.n / this.o;
  }

  public long longValue()
  {
    return this.n / this.o;
  }

  public String toString()
  {
    if (this.q == null)
      this.q = (32 + a() + '/' + b());
    return this.q;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.e.a
 * JD-Core Version:    0.6.0
 */