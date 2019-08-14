package b;

final class z
{
  static final z a = new z();
  static final long b = 65536L;
  long c;
  private y d;

  y a()
  {
    monitorenter;
    try
    {
      if (this.d != null)
      {
        y localy = this.d;
        this.d = localy.e;
        localy.e = null;
        this.c -= 2048L;
        return localy;
      }
      return new y();
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void a(y paramy)
  {
    if ((paramy.e != null) || (paramy.f != null))
      throw new IllegalArgumentException();
    monitorenter;
    try
    {
      if (2048L + this.c > 65536L)
        return;
      this.c = (2048L + this.c);
      paramy.e = this.d;
      paramy.d = 0;
      paramy.c = 0;
      this.d = paramy;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.z
 * JD-Core Version:    0.6.0
 */