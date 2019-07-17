package c.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.umeng.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ex
{
  private List<ev> a = new ArrayList();
  private n b = null;
  private r c = null;
  private x d = null;
  private ay e = null;
  private Context f = null;

  public ex(Context paramContext)
  {
    this.f = paramContext;
  }

  private void a(Context paramContext)
  {
    try
    {
      this.c.a(a.a(paramContext));
      this.c.e(a.b(paramContext));
      if ((a.a != null) && (a.b != null))
      {
        this.c.f(a.a);
        this.c.g(a.b);
      }
      this.c.c(bt.u(paramContext));
      this.c.a(bi.a);
      this.c.d("5.5.3");
      this.c.b(bt.d(paramContext));
      this.c.a(Integer.parseInt(bt.c(paramContext)));
      this.c.c(a.c);
      this.c.d(a.a());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void b(Context paramContext)
  {
    try
    {
      this.d.f(bt.a());
      this.d.a(bt.f(paramContext));
      this.d.b(bt.g(paramContext));
      this.d.c(bt.p(paramContext));
      this.d.e(Build.MODEL);
      this.d.g("Android");
      this.d.h(Build.VERSION.RELEASE);
      int[] arrayOfInt = bt.r(paramContext);
      if (arrayOfInt != null)
        this.d.a(new be(arrayOfInt[1], arrayOfInt[0]));
      if ((a.e != null) && (a.d != null));
      this.d.i(Build.BOARD);
      this.d.j(Build.BRAND);
      this.d.a(Build.TIME);
      this.d.k(Build.MANUFACTURER);
      this.d.l(Build.ID);
      this.d.m(Build.DEVICE);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void c(Context paramContext)
  {
    while (true)
    {
      try
      {
        String[] arrayOfString1 = bt.j(paramContext);
        if (!"Wi-Fi".equals(arrayOfString1[0]))
          continue;
        this.e.a(m.c);
        if ("".equals(arrayOfString1[1]))
          continue;
        this.e.e(arrayOfString1[1]);
        this.e.c(bt.s(paramContext));
        String[] arrayOfString2 = bt.n(paramContext);
        this.e.b(arrayOfString2[0]);
        this.e.a(arrayOfString2[1]);
        this.e.a(bt.m(paramContext));
        return;
        if ("2G/3G".equals(arrayOfString1[0]))
        {
          this.e.a(m.b);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      this.e.a(m.a);
    }
  }

  public Context a()
  {
    return this.f;
  }

  public void a(bn parambn)
  {
    String str = ff.g(this.f);
    if (str == null)
      return;
    monitorenter;
    try
    {
      if ((this.b != null) && (new b(this.f).b()))
      {
        parambn.a(this.b);
        this.b = null;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((ev)localIterator.next()).a(parambn, str);
    }
    finally
    {
      monitorexit;
    }
    this.a.clear();
    monitorexit;
    parambn.a(c());
    parambn.a(d());
    parambn.a(e());
    parambn.a(h());
    parambn.a(f());
    parambn.a(g());
    parambn.a(i());
  }

  public void a(ev paramev)
  {
    monitorenter;
    try
    {
      this.a.add(paramev);
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

  public void a(n paramn)
  {
    monitorenter;
    try
    {
      this.b = paramn;
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

  protected boolean a(int paramInt)
  {
    return true;
  }

  public int b()
  {
    monitorenter;
    try
    {
      int i = this.a.size();
      n localn = this.b;
      if (localn != null)
        i++;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public r c()
  {
    monitorenter;
    try
    {
      if (this.c == null)
      {
        this.c = new r();
        a(this.f);
      }
      r localr = this.c;
      return localr;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public x d()
  {
    monitorenter;
    try
    {
      if (this.d == null)
      {
        this.d = new x();
        b(this.f);
      }
      x localx = this.d;
      return localx;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public ay e()
  {
    monitorenter;
    try
    {
      if (this.e == null)
      {
        this.e = new ay();
        c(this.f);
      }
      ay localay = this.e;
      return localay;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public ao f()
  {
    try
    {
      ao localao = ef.a(this.f).a();
      return localao;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public al g()
  {
    try
    {
      al localal = dg.a(this.f).b();
      return localal;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public t h()
  {
    try
    {
      t localt = b.a(this.f);
      return localt;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new t();
  }

  public p i()
  {
    String[] arrayOfString = com.umeng.a.t.a(this.f);
    if ((arrayOfString != null) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1])))
      return new p(arrayOfString[0], arrayOfString[1]);
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ex
 * JD-Core Version:    0.6.0
 */