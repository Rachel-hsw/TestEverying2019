package c.a;

public class ck extends cs
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  private static final ds j = new ds("TApplicationException");
  private static final di k = new di("message", 11, 1);
  private static final di l = new di("type", 8, 2);
  private static final long m = 1L;
  protected int i = 0;

  public ck()
  {
  }

  public ck(int paramInt)
  {
    this.i = paramInt;
  }

  public ck(int paramInt, String paramString)
  {
    super(paramString);
    this.i = paramInt;
  }

  public ck(String paramString)
  {
    super(paramString);
  }

  public static ck a(dn paramdn)
    throws cs
  {
    paramdn.j();
    String str = null;
    int n = 0;
    di localdi = paramdn.l();
    if (localdi.b == 0)
    {
      paramdn.k();
      return new ck(n, str);
    }
    switch (localdi.c)
    {
    default:
      dq.a(paramdn, localdi.b);
    case 1:
    case 2:
    }
    while (true)
    {
      paramdn.m();
      break;
      if (localdi.b == 11)
      {
        str = paramdn.z();
        continue;
      }
      dq.a(paramdn, localdi.b);
      continue;
      if (localdi.b == 8)
      {
        n = paramdn.w();
        continue;
      }
      dq.a(paramdn, localdi.b);
    }
  }

  public int a()
  {
    return this.i;
  }

  public void b(dn paramdn)
    throws cs
  {
    paramdn.a(j);
    if (getMessage() != null)
    {
      paramdn.a(k);
      paramdn.a(getMessage());
      paramdn.c();
    }
    paramdn.a(l);
    paramdn.a(this.i);
    paramdn.c();
    paramdn.d();
    paramdn.b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ck
 * JD-Core Version:    0.6.0
 */