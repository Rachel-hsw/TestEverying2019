package org.a.a.a.j;

public class b<L, R> extends c<L, R>
{
  private static final long c = 4954918890077093841L;
  public L a;
  public R b;

  public b()
  {
  }

  public b(L paramL, R paramR)
  {
    this.a = paramL;
    this.b = paramR;
  }

  public static <L, R> b<L, R> a(L paramL, R paramR)
  {
    return new b(paramL, paramR);
  }

  public L a()
  {
    return this.a;
  }

  public void a(L paramL)
  {
    this.a = paramL;
  }

  public R b()
  {
    return this.b;
  }

  public void b(R paramR)
  {
    this.b = paramR;
  }

  public R setValue(R paramR)
  {
    Object localObject = b();
    b(paramR);
    return localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.j.b
 * JD-Core Version:    0.6.0
 */