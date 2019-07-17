package koudai.db;

import java.util.List;

public class g
{
  private Long a;
  private String b;
  private String c;
  private transient d d;
  private transient ProvinceDBDao e;
  private List<e> f;

  public g()
  {
  }

  public g(Long paramLong)
  {
    this.a = paramLong;
  }

  public g(Long paramLong, String paramString1, String paramString2)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
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
    this.d = paramd;
    if (paramd != null);
    for (ProvinceDBDao localProvinceDBDao = paramd.f(); ; localProvinceDBDao = null)
    {
      this.e = localProvinceDBDao;
      return;
    }
  }

  public String b()
  {
    return this.b;
  }

  public void b(String paramString)
  {
    this.c = paramString;
  }

  public String c()
  {
    return this.c;
  }

  public List<e> d()
  {
    List localList;
    if (this.f == null)
    {
      if (this.d == null)
        throw new a.a.a.d("Entity is detached from DAO context");
      localList = this.d.e().a(this.a);
      monitorenter;
    }
    try
    {
      if (this.f == null)
        this.f = localList;
      return this.f;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void e()
  {
    monitorenter;
    try
    {
      this.f = null;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void f()
  {
    if (this.e == null)
      throw new a.a.a.d("Entity is detached from DAO context");
    this.e.f(this);
  }

  public void g()
  {
    if (this.e == null)
      throw new a.a.a.d("Entity is detached from DAO context");
    this.e.i(this);
  }

  public void h()
  {
    if (this.e == null)
      throw new a.a.a.d("Entity is detached from DAO context");
    this.e.h(this);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     koudai.db.g
 * JD-Core Version:    0.6.0
 */