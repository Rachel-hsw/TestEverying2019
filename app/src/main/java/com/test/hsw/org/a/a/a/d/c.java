package org.a.a.a.d;

import java.util.List;
import java.util.Set;

public class c extends RuntimeException
  implements e
{
  private static final long a = 20110706L;
  private final e b;

  public c()
  {
    this.b = new d();
  }

  public c(String paramString)
  {
    super(paramString);
    this.b = new d();
  }

  public c(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.b = new d();
  }

  public c(String paramString, Throwable paramThrowable, e parame)
  {
    super(paramString, paramThrowable);
    if (parame == null)
      parame = new d();
    this.b = parame;
  }

  public c(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.b = new d();
  }

  public List<org.a.a.a.j.c<String, Object>> a()
  {
    return this.b.a();
  }

  public List<Object> a(String paramString)
  {
    return this.b.a(paramString);
  }

  public c a(String paramString, Object paramObject)
  {
    this.b.d(paramString, paramObject);
    return this;
  }

  public Object b(String paramString)
  {
    return this.b.b(paramString);
  }

  public Set<String> b()
  {
    return this.b.b();
  }

  public c b(String paramString, Object paramObject)
  {
    this.b.c(paramString, paramObject);
    return this;
  }

  public String c()
  {
    return super.getMessage();
  }

  public String c(String paramString)
  {
    return this.b.c(paramString);
  }

  public String getMessage()
  {
    return c(super.getMessage());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.d.c
 * JD-Core Version:    0.6.0
 */