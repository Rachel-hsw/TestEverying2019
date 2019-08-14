package a.a.a.e;

import a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i<T>
{
  public static boolean a;
  public static boolean b;
  private final j<T> c;
  private StringBuilder d;
  private final List<Object> e;
  private final List<f<T, ?>> f;
  private final a<T, ?> g;
  private final String h;
  private Integer i;
  private Integer j;

  protected i(a<T, ?> parama)
  {
    this(parama, "T");
  }

  protected i(a<T, ?> parama, String paramString)
  {
    this.g = parama;
    this.h = paramString;
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.c = new j(parama, paramString);
  }

  private <J> f<T, J> a(String paramString, a.a.a.i parami1, a<J, ?> parama, a.a.a.i parami2)
  {
    f localf = new f(paramString, parami1, parama, parami2, "J" + (1 + this.f.size()));
    this.f.add(localf);
    return localf;
  }

  public static <T2> i<T2> a(a<T2, ?> parama)
  {
    return new i(parama);
  }

  private void a(String paramString, a.a.a.i[] paramArrayOfi)
  {
    int k = paramArrayOfi.length;
    for (int m = 0; ; m++)
    {
      if (m >= k)
        return;
      a.a.a.i locali = paramArrayOfi[m];
      k();
      a(this.d, locali);
      if (String.class.equals(locali.b))
        this.d.append(" COLLATE LOCALIZED");
      this.d.append(paramString);
    }
  }

  private void a(StringBuilder paramStringBuilder, String paramString)
  {
    this.e.clear();
    Iterator localIterator1 = this.f.iterator();
    int k;
    label41: Iterator localIterator2;
    if (!localIterator1.hasNext())
    {
      if (!this.c.a())
        break label175;
      k = 0;
      if (k != 0)
      {
        paramStringBuilder.append(" WHERE ");
        this.c.a(paramStringBuilder, paramString, this.e);
      }
      localIterator2 = this.f.iterator();
    }
    label175: f localf2;
    do
    {
      if (!localIterator2.hasNext())
      {
        return;
        f localf1 = (f)localIterator1.next();
        paramStringBuilder.append(" JOIN ").append(localf1.b.c()).append(' ');
        paramStringBuilder.append(localf1.e).append(" ON ");
        a.a.a.d.d.a(paramStringBuilder, localf1.a, localf1.c).append('=');
        a.a.a.d.d.a(paramStringBuilder, localf1.e, localf1.d);
        break;
        k = 1;
        break label41;
      }
      localf2 = (f)localIterator2.next();
    }
    while (localf2.f.a());
    if (k == 0)
    {
      paramStringBuilder.append(" WHERE ");
      k = 1;
    }
    while (true)
    {
      localf2.f.a(paramStringBuilder, localf2.e, this.e);
      break;
      paramStringBuilder.append(" AND ");
    }
  }

  private void b(String paramString)
  {
    if (a)
      a.a.a.e.b("Built SQL for query: " + paramString);
    if (b)
      a.a.a.e.b("Values for query: " + this.e);
  }

  private void k()
  {
    if (this.d == null)
      this.d = new StringBuilder();
    do
      return;
    while (this.d.length() <= 0);
    this.d.append(",");
  }

  public <J> f<T, J> a(f<?, T> paramf, a.a.a.i parami1, Class<J> paramClass, a.a.a.i parami2)
  {
    a locala = this.g.a().d(paramClass);
    return a(paramf.e, parami1, locala, parami2);
  }

  public <J> f<T, J> a(a.a.a.i parami, Class<J> paramClass)
  {
    a locala = this.g.a().d(paramClass);
    a.a.a.i locali = locala.e();
    return a(this.h, parami, locala, locali);
  }

  public <J> f<T, J> a(a.a.a.i parami1, Class<J> paramClass, a.a.a.i parami2)
  {
    a locala = this.g.a().d(paramClass);
    return a(this.h, parami1, locala, parami2);
  }

  public <J> f<T, J> a(Class<J> paramClass, a.a.a.i parami)
  {
    return a(this.g.e(), paramClass, parami);
  }

  public h<T> a()
  {
    int k = -1;
    StringBuilder localStringBuilder = new StringBuilder(a.a.a.d.d.b(this.g.c(), this.h, this.g.f()));
    a(localStringBuilder, this.h);
    if ((this.d != null) && (this.d.length() > 0))
      localStringBuilder.append(" ORDER BY ").append(this.d);
    if (this.i != null)
    {
      localStringBuilder.append(" LIMIT ?");
      this.e.add(this.i);
    }
    for (int m = -1 + this.e.size(); ; m = k)
    {
      if (this.j != null)
      {
        if (this.i == null)
          throw new IllegalStateException("Offset cannot be set without limit");
        localStringBuilder.append(" OFFSET ?");
        this.e.add(this.j);
        k = -1 + this.e.size();
      }
      String str = localStringBuilder.toString();
      b(str);
      return h.a(this.g, str, this.e.toArray(), m, k);
    }
  }

  public i<T> a(int paramInt)
  {
    this.i = Integer.valueOf(paramInt);
    return this;
  }

  public i<T> a(k paramk1, k paramk2, k[] paramArrayOfk)
  {
    this.c.a(b(paramk1, paramk2, paramArrayOfk), new k[0]);
    return this;
  }

  public i<T> a(k paramk, k[] paramArrayOfk)
  {
    this.c.a(paramk, paramArrayOfk);
    return this;
  }

  public i<T> a(a.a.a.i parami, String paramString)
  {
    k();
    a(this.d, parami).append(' ');
    this.d.append(paramString);
    return this;
  }

  public i<T> a(String paramString)
  {
    k();
    this.d.append(paramString);
    return this;
  }

  public i<T> a(a.a.a.i[] paramArrayOfi)
  {
    a(" ASC", paramArrayOfi);
    return this;
  }

  protected StringBuilder a(StringBuilder paramStringBuilder, a.a.a.i parami)
  {
    this.c.a(parami);
    paramStringBuilder.append(this.h).append('.').append('\'').append(parami.e).append('\'');
    return paramStringBuilder;
  }

  public e<T> b()
  {
    if (!this.f.isEmpty())
      throw new a.a.a.d("JOINs are not supported for DELETE queries");
    String str1 = this.g.c();
    StringBuilder localStringBuilder = new StringBuilder(a.a.a.d.d.a(str1, null));
    a(localStringBuilder, this.h);
    String str2 = localStringBuilder.toString().replace(this.h + ".\"", '"' + str1 + "\".\"");
    b(str2);
    return e.a(this.g, str2, this.e.toArray());
  }

  public i<T> b(int paramInt)
  {
    this.j = Integer.valueOf(paramInt);
    return this;
  }

  public i<T> b(a.a.a.i[] paramArrayOfi)
  {
    a(" DESC", paramArrayOfi);
    return this;
  }

  public k b(k paramk1, k paramk2, k[] paramArrayOfk)
  {
    return this.c.a(" OR ", paramk1, paramk2, paramArrayOfk);
  }

  public d<T> c()
  {
    StringBuilder localStringBuilder = new StringBuilder(a.a.a.d.d.a(this.g.c(), this.h));
    a(localStringBuilder, this.h);
    String str = localStringBuilder.toString();
    b(str);
    return d.a(this.g, str, this.e.toArray());
  }

  public k c(k paramk1, k paramk2, k[] paramArrayOfk)
  {
    return this.c.a(" AND ", paramk1, paramk2, paramArrayOfk);
  }

  public List<T> d()
  {
    return a().c();
  }

  public g<T> e()
  {
    return a().d();
  }

  public g<T> f()
  {
    return a().e();
  }

  public c<T> g()
  {
    return a().f();
  }

  public T h()
  {
    return a().g();
  }

  public T i()
  {
    return a().h();
  }

  public long j()
  {
    return c().c();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.e.i
 * JD-Core Version:    0.6.0
 */