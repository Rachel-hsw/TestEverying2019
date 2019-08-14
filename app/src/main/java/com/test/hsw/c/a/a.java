package c.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class a
{
  private final int a = 10;
  private final int b = 20;
  private final String c;
  private List<ah> d;
  private aj e;

  public a(String paramString)
  {
    this.c = paramString;
  }

  private boolean g()
  {
    aj localaj = this.e;
    Object localObject;
    if (localaj == null)
    {
      localObject = null;
      if (localaj != null)
        break label205;
    }
    label205: for (int i = 0; ; i = localaj.j())
    {
      String str = a(f());
      int j = 0;
      if (str != null)
      {
        boolean bool = str.equals(localObject);
        j = 0;
        if (!bool)
        {
          if (localaj == null)
            localaj = new aj();
          localaj.a(str);
          localaj.a(System.currentTimeMillis());
          localaj.a(i + 1);
          ah localah = new ah();
          localah.a(this.c);
          localah.c(str);
          localah.b((String)localObject);
          localah.a(localaj.f());
          if (this.d == null)
            this.d = new ArrayList(2);
          this.d.add(localah);
          if (this.d.size() > 10)
            this.d.remove(0);
          this.e = localaj;
          j = 1;
        }
      }
      return j;
      localObject = localaj.c();
      break;
    }
  }

  public String a(String paramString)
  {
    if (paramString == null);
    String str;
    do
    {
      return null;
      str = paramString.trim();
    }
    while ((str.length() == 0) || ("0".equals(str)) || ("unknown".equals(str.toLowerCase(Locale.US))));
    return str;
  }

  public void a(aj paramaj)
  {
    this.e = paramaj;
  }

  public void a(al paramal)
  {
    this.e = ((aj)paramal.d().get(this.c));
    List localList = paramal.j();
    if ((localList != null) && (localList.size() > 0))
    {
      if (this.d == null)
        this.d = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ah localah = (ah)localIterator.next();
        if (!this.c.equals(localah.a))
          continue;
        this.d.add(localah);
      }
    }
  }

  public void a(List<ah> paramList)
  {
    this.d = paramList;
  }

  public boolean a()
  {
    return g();
  }

  public String b()
  {
    return this.c;
  }

  public boolean c()
  {
    return (this.e == null) || (this.e.j() <= 20);
  }

  public aj d()
  {
    return this.e;
  }

  public List<ah> e()
  {
    return this.d;
  }

  public abstract String f();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.a
 * JD-Core Version:    0.6.0
 */