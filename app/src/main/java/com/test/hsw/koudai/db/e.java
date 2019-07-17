package koudai.db;

public class e
{
  private Long a;
  private String b;
  private String c;
  private String d;
  private Long e;
  private transient d f;
  private transient MajorDBDao g;
  private g h;
  private Long i;

  public e()
  {
  }

  public e(Long paramLong)
  {
    this.a = paramLong;
  }

  public e(Long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramLong2;
  }

  public Long a()
  {
    return this.a;
  }

  public void a(Long paramLong)
  {
    this.a = paramLong;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(d paramd)
  {
    this.f = paramd;
    if (paramd != null);
    for (MajorDBDao localMajorDBDao = paramd.e(); ; localMajorDBDao = null)
    {
      this.g = localMajorDBDao;
      return;
    }
  }

  public void a(g paramg)
  {
    monitorenter;
    try
    {
      this.h = paramg;
      if (paramg == null);
      for (Long localLong = null; ; localLong = paramg.a())
      {
        this.e = localLong;
        this.i = this.e;
        return;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public String b()
  {
    return this.b;
  }

  public void b(Long paramLong)
  {
    this.e = paramLong;
  }

  public void b(String paramString)
  {
    this.c = paramString;
  }

  public String c()
  {
    return this.c;
  }

  public void c(String paramString)
  {
    this.d = paramString;
  }

  public String d()
  {
    return this.d;
  }

  public Long e()
  {
    return this.e;
  }

  public g f()
  {
    Long localLong = this.e;
    g localg;
    if ((this.i == null) || (!this.i.equals(localLong)))
    {
      if (this.f == null)
        throw new a.a.a.d("Entity is detached from DAO context");
      localg = (g)this.f.f().a(localLong);
      monitorenter;
    }
    try
    {
      this.h = localg;
      this.i = localLong;
      return this.h;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void g()
  {
    if (this.g == null)
      throw new a.a.a.d("Entity is detached from DAO context");
    this.g.f(this);
  }

  public void h()
  {
    if (this.g == null)
      throw new a.a.a.d("Entity is detached from DAO context");
    this.g.i(this);
  }

  public void i()
  {
    if (this.g == null)
      throw new a.a.a.d("Entity is detached from DAO context");
    this.g.h(this);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.e
 * JD-Core Version:    0.6.0
 */