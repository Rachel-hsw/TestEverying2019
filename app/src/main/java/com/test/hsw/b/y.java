package b;

final class y
{
  static final int a = 2048;
  final byte[] b = new byte[2048];
  int c;
  int d;
  y e;
  y f;

  public y a()
  {
    if (this.e != this);
    for (y localy = this.e; ; localy = null)
    {
      this.f.e = this.e;
      this.e.f = this.f;
      this.e = null;
      this.f = null;
      return localy;
    }
  }

  public y a(int paramInt)
  {
    int i = this.d - this.c - paramInt;
    if ((paramInt <= 0) || (i <= 0))
      throw new IllegalArgumentException();
    if (paramInt < i)
    {
      y localy2 = z.a.a();
      System.arraycopy(this.b, this.c, localy2.b, localy2.c, paramInt);
      this.c = (paramInt + this.c);
      localy2.d = (paramInt + localy2.d);
      this.f.a(localy2);
      return localy2;
    }
    y localy1 = z.a.a();
    System.arraycopy(this.b, paramInt + this.c, localy1.b, localy1.c, i);
    this.d -= i;
    localy1.d = (i + localy1.d);
    a(localy1);
    return this;
  }

  public y a(y paramy)
  {
    paramy.f = this;
    paramy.e = this.e;
    this.e.f = paramy;
    this.e = paramy;
    return paramy;
  }

  public void a(y paramy, int paramInt)
  {
    if (paramInt + (paramy.d - paramy.c) > 2048)
      throw new IllegalArgumentException();
    if (paramInt + paramy.d > 2048)
    {
      System.arraycopy(paramy.b, paramy.c, paramy.b, 0, paramy.d - paramy.c);
      paramy.d -= paramy.c;
      paramy.c = 0;
    }
    System.arraycopy(this.b, this.c, paramy.b, paramy.d, paramInt);
    paramy.d = (paramInt + paramy.d);
    this.c = (paramInt + this.c);
  }

  public void b()
  {
    if (this.f == this)
      throw new IllegalStateException();
    if (this.f.d - this.f.c + (this.d - this.c) > 2048)
      return;
    a(this.f, this.d - this.c);
    a();
    z.a.a(this);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.y
 * JD-Core Version:    0.6.0
 */