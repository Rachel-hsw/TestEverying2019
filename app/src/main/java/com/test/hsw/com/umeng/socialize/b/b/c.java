package com.umeng.socialize.b.b;

public abstract class c
{
  private static final int a = 2;
  public static final int b = 76;
  protected static final int c = 255;
  protected static final byte d = 61;
  protected static final byte e = 61;
  private static final int l = 8192;
  protected final int f;
  protected byte[] g;
  protected int h;
  protected boolean i;
  protected int j;
  protected int k;
  private final int m;
  private final int n;
  private final int o;
  private int p;

  protected c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.m = paramInt1;
    this.n = paramInt2;
    if ((paramInt3 > 0) && (paramInt4 > 0));
    for (int i1 = paramInt2 * (paramInt3 / paramInt2); ; i1 = 0)
    {
      this.f = i1;
      this.o = paramInt4;
      return;
    }
  }

  protected static boolean b(byte paramByte)
  {
    switch (paramByte)
    {
    default:
      return false;
    case 9:
    case 10:
    case 13:
    case 32:
    }
    return true;
  }

  private void d()
  {
    if (this.g == null)
    {
      this.g = new byte[c()];
      this.h = 0;
      this.p = 0;
      return;
    }
    byte[] arrayOfByte = new byte[2 * this.g.length];
    System.arraycopy(this.g, 0, arrayOfByte, 0, this.g.length);
    this.g = arrayOfByte;
  }

  private void e()
  {
    this.g = null;
    this.h = 0;
    this.p = 0;
    this.j = 0;
    this.k = 0;
    this.i = false;
  }

  public Object a(Object paramObject)
    throws Exception
  {
    if (!(paramObject instanceof byte[]))
      throw new Exception("Parameter supplied to Base-N encode is not a byte[]");
    return d((byte[])(byte[])paramObject);
  }

  protected void a(int paramInt)
  {
    if ((this.g == null) || (this.g.length < paramInt + this.h))
      d();
  }

  abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  boolean a()
  {
    return this.g != null;
  }

  protected abstract boolean a(byte paramByte);

  int b()
  {
    if (this.g != null)
      return this.h - this.p;
    return 0;
  }

  public Object b(Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof byte[]))
      return c((byte[])(byte[])paramObject);
    if ((paramObject instanceof String))
      return b((String)paramObject);
    throw new Exception("Parameter supplied to Base-N decode is not a byte[] or a String");
  }

  public String b(byte[] paramArrayOfByte)
  {
    return a.a(d(paramArrayOfByte));
  }

  abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  public boolean b(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    for (int i1 = 0; i1 < paramArrayOfByte.length; i1++)
      if ((!a(paramArrayOfByte[i1])) && ((!paramBoolean) || ((paramArrayOfByte[i1] != 61) && (!b(paramArrayOfByte[i1])))))
        return false;
    return true;
  }

  public byte[] b(String paramString)
  {
    return c(a.b(paramString));
  }

  protected int c()
  {
    return 8192;
  }

  int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.g != null)
    {
      int i1 = Math.min(b(), paramInt2);
      System.arraycopy(this.g, this.p, paramArrayOfByte, paramInt1, i1);
      this.p = (i1 + this.p);
      if (this.p >= this.h)
        this.g = null;
      return i1;
    }
    if (this.i)
      return -1;
    return 0;
  }

  public boolean c(String paramString)
  {
    return b(a.b(paramString), true);
  }

  public byte[] c(byte[] paramArrayOfByte)
  {
    e();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return paramArrayOfByte;
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
    b(paramArrayOfByte, 0, -1);
    byte[] arrayOfByte = new byte[this.h];
    c(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }

  public byte[] d(byte[] paramArrayOfByte)
  {
    e();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return paramArrayOfByte;
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
    a(paramArrayOfByte, 0, -1);
    byte[] arrayOfByte = new byte[this.h - this.p];
    c(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }

  public String e(byte[] paramArrayOfByte)
  {
    return a.a(d(paramArrayOfByte));
  }

  protected boolean f(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null);
    while (true)
    {
      return false;
      for (int i1 = 0; i1 < paramArrayOfByte.length; i1++)
        if ((61 == paramArrayOfByte[i1]) || (a(paramArrayOfByte[i1])))
          return true;
    }
  }

  public long g(byte[] paramArrayOfByte)
  {
    long l1 = (-1 + (paramArrayOfByte.length + this.m)) / this.m * this.n;
    if (this.f > 0)
      l1 += (l1 + this.f - 1L) / this.f * this.o;
    return l1;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.b.c
 * JD-Core Version:    0.6.0
 */