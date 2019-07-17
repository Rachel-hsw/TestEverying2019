package c.a;

public class dq
{
  private static int a = 2147483647;

  public static dp a(byte[] paramArrayOfByte, dp paramdp)
  {
    if (paramArrayOfByte[0] > 16)
      paramdp = new dh.a();
    do
      return paramdp;
    while ((paramArrayOfByte.length <= 1) || ((0x80 & paramArrayOfByte[1]) == 0));
    return new dh.a();
  }

  public static void a(int paramInt)
  {
    a = paramInt;
  }

  public static void a(dn paramdn, byte paramByte)
    throws cs
  {
    a(paramdn, paramByte, a);
  }

  public static void a(dn paramdn, byte paramByte, int paramInt)
    throws cs
  {
    int i = 0;
    if (paramInt <= 0)
      throw new cs("Maximum skip depth exceeded");
    switch (paramByte)
    {
    case 5:
    case 7:
    case 9:
    default:
      return;
    case 2:
      paramdn.t();
      return;
    case 3:
      paramdn.u();
      return;
    case 6:
      paramdn.v();
      return;
    case 8:
      paramdn.w();
      return;
    case 10:
      paramdn.x();
      return;
    case 4:
      paramdn.y();
      return;
    case 11:
      paramdn.A();
      return;
    case 12:
      paramdn.j();
      while (true)
      {
        di localdi = paramdn.l();
        if (localdi.b == 0)
        {
          paramdn.k();
          return;
        }
        a(paramdn, localdi.b, paramInt - 1);
        paramdn.m();
      }
    case 13:
      dk localdk = paramdn.n();
      while (i < localdk.c)
      {
        a(paramdn, localdk.a, paramInt - 1);
        a(paramdn, localdk.b, paramInt - 1);
        i++;
      }
      paramdn.o();
      return;
    case 14:
      dr localdr = paramdn.r();
      while (i < localdr.b)
      {
        a(paramdn, localdr.a, paramInt - 1);
        i++;
      }
      paramdn.s();
      return;
    case 15:
    }
    dj localdj = paramdn.p();
    while (i < localdj.b)
    {
      a(paramdn, localdj.a, paramInt - 1);
      i++;
    }
    paramdn.q();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.dq
 * JD-Core Version:    0.6.0
 */