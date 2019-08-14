package c.a;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.a.a;
import com.umeng.a.a.d;
import com.umeng.a.i.a;
import com.umeng.a.i.b;
import com.umeng.a.i.c;
import com.umeng.a.i.d;
import com.umeng.a.i.f;
import com.umeng.a.i.g;
import com.umeng.a.i.h;
import com.umeng.a.k;
import com.umeng.a.u;
import com.umeng.a.w;
import java.util.Iterator;
import java.util.List;

public final class ek
  implements eu, fb, d
{
  private ex a = null;
  private w b = null;
  private b c = null;
  private l d = new l();
  private a e = null;
  private int f = 10;
  private int g;
  private Context h;

  public ek(Context paramContext)
  {
    this.h = paramContext;
    this.a = new ex(paramContext);
    this.c = new b(paramContext);
    this.b = w.a(paramContext);
    this.d.a(this.b.d());
    this.e = new a();
    this.g = this.b.d(-1);
  }

  private bn a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    try
    {
      bn localbn = new bn();
      new cp().a(localbn, paramArrayOfByte);
      return localbn;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  private void a(bn parambn)
  {
    dg localdg;
    byte[] arrayOfByte1;
    if (parambn != null)
    {
      localdg = dg.a(this.h);
      localdg.a();
      parambn.a(localdg.b());
      arrayOfByte1 = b(parambn);
      if (arrayOfByte1 != null);
    }
    else
    {
      return;
    }
    if (f());
    for (cd localcd = cd.b(this.h, a.a(this.h), arrayOfByte1); ; localcd = cd.a(this.h, a.a(this.h), arrayOfByte1))
    {
      byte[] arrayOfByte2 = localcd.c();
      w localw = w.a(this.h);
      localw.g();
      localw.b(arrayOfByte2);
      localdg.d();
      return;
    }
  }

  private void a(boolean paramBoolean)
  {
    boolean bool = this.c.b();
    if (bool)
      this.a.a(new n(this.c.j()));
    if (b(paramBoolean))
      e();
    do
      return;
    while ((!bool) && (!d()));
    b();
  }

  private boolean b(boolean paramBoolean)
  {
    int i = 1;
    if (!bt.l(this.h))
    {
      if (bu.a)
        bu.c("MobclickAgent", "network is unavailable");
      i = 0;
    }
    do
      return i;
    while ((this.c.b()) || ((bu.a) && (bt.w(this.h))));
    return this.e.c().a(paramBoolean);
  }

  private byte[] b(bn parambn)
  {
    if (parambn == null)
      return null;
    try
    {
      byte[] arrayOfByte = new cv().a(parambn);
      if (bu.a)
        bu.c("MobclickAgent", parambn.toString());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "Fail to serialize log ...", localException);
    }
    return null;
  }

  private void d(int paramInt)
  {
    a(a(new int[] { paramInt, (int)(System.currentTimeMillis() - this.c.k()) }));
    u.a(new el(this), paramInt);
  }

  private boolean d()
  {
    return this.a.b() > this.f;
  }

  private void e()
  {
    try
    {
      if (this.b.h())
      {
        fd localfd1 = new fd(this.h, this.c);
        localfd1.a(this);
        if (this.d.c())
          localfd1.b(true);
        localfd1.a();
        return;
      }
      localbn = a(new int[0]);
      if (localbn == null)
      {
        bu.a("MobclickAgent", "No data to report");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      bn localbn;
      if ((!(localThrowable instanceof OutOfMemoryError)) || (localThrowable != null))
      {
        localThrowable.printStackTrace();
        return;
        fd localfd2 = new fd(this.h, this.c);
        localfd2.a(this);
        if (this.d.c())
          localfd2.b(true);
        localfd2.a(localbn);
        localfd2.a(f());
        localfd2.a();
      }
    }
  }

  private void e(int paramInt)
  {
    d(paramInt);
  }

  private boolean f()
  {
    switch (this.g)
    {
    case 0:
    default:
      return false;
    case 1:
      return true;
    case -1:
    }
    return a.f;
  }

  protected bn a(int[] paramArrayOfInt)
  {
    int i = 0;
    while (true)
    {
      bn localbn1;
      bn localbn3;
      try
      {
        if (!TextUtils.isEmpty(a.a(this.h)))
          continue;
        bu.b("MobclickAgent", "Appkey is missing ,Please check AndroidManifest.xml");
        return null;
        byte[] arrayOfByte = w.a(this.h).f();
        if (arrayOfByte != null)
          continue;
        localbn1 = null;
        if ((localbn1 == null) && (this.a.b() == 0))
        {
          return null;
          localbn1 = a(arrayOfByte);
          continue;
        }
        if (localbn1 != null)
          break label263;
        localbn2 = new bn();
        this.a.a(localbn2);
        if ((!bu.a) || (!localbn2.B()))
          continue;
        Iterator localIterator = localbn2.z().iterator();
        if (!localIterator.hasNext())
          continue;
        if (((bj)localIterator.next()).p() > 0)
        {
          j = 1;
          break label273;
          if (i != 0)
            continue;
          bu.e("MobclickAgent", "missing Activities or PageViews");
          localbn3 = this.d.a(this.h, localbn2);
          if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 2))
            break label270;
          v localv = new v();
          localv.a(new au(paramArrayOfInt[0] / 1000, paramArrayOfInt[1]));
          localbn3.a(localv);
          return localbn3;
        }
      }
      catch (Exception localException)
      {
        bu.b("MobclickAgent", "Fail to construct message ...", localException);
        w.a(this.h).g();
        return null;
      }
      int j = i;
      break label273;
      label263: bn localbn2 = localbn1;
      continue;
      label270: return localbn3;
      label273: i = j;
    }
  }

  public void a()
  {
    if (bt.l(this.h))
      e();
    do
      return;
    while (!bu.a);
    bu.c("MobclickAgent", "network is unavailable");
  }

  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 3))
    {
      this.d.a(paramInt);
      this.e.b(paramInt);
    }
  }

  public void a(int paramInt, long paramLong)
  {
    this.e.a(paramInt, (int)paramLong);
  }

  public void a(ev paramev)
  {
    if (paramev != null)
      this.a.a(paramev);
    a(paramev instanceof bj);
  }

  public void b()
  {
    if (this.a.b() > 0);
    try
    {
      byte[] arrayOfByte = b(a(new int[0]));
      if (arrayOfByte != null)
        this.b.a(arrayOfByte);
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        if (!(localThrowable instanceof OutOfMemoryError))
          continue;
        this.b.g();
      }
      while (localThrowable == null);
      localThrowable.printStackTrace();
    }
  }

  public void b(int paramInt)
  {
    if (paramInt > 0)
      this.e.a(paramInt);
  }

  public void b(ev paramev)
  {
    this.a.a(paramev);
  }

  public void c()
  {
    a(a(new int[0]));
  }

  public void c(int paramInt)
  {
    this.g = paramInt;
  }

  public class a
  {
    private final long b = 1296000000L;
    private final int c = 1800000;
    private final int d = 10000;
    private i.g e;
    private int f = ek.a(ek.this).d();
    private int g;
    private int h;
    private int i;
    private boolean j = false;

    public a()
    {
      int k = ek.a(ek.this).e();
      if (k > 0)
        this.g = c(k);
      while (true)
      {
        int[] arrayOfInt = ek.a(ek.this).c();
        this.h = arrayOfInt[0];
        this.i = arrayOfInt[1];
        return;
        if (a.g > 0)
        {
          this.g = c(a.g);
          continue;
        }
        this.g = 10000;
      }
    }

    private i.g b(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      case 2:
      case 3:
      default:
        return new i.c();
      case 1:
        return new i.c();
      case 6:
        return new i.d(ek.b(ek.this), paramInt2);
      case 4:
        return new i.f(ek.b(ek.this));
      case 0:
        return new i.g();
      case 5:
      }
      return new i.h(ek.d(ek.this));
    }

    private int c(int paramInt)
    {
      if (paramInt > 1800000)
        paramInt = 1800000;
      return paramInt;
    }

    protected void a()
    {
      int k = 1;
      Object localObject;
      if (this.f > 0)
        if (((this.e instanceof i.a)) && (this.e.a()))
        {
          if (k == 0)
            break label56;
          localObject = this.e;
          label39: this.e = ((i.g)localObject);
        }
      while (true)
      {
        this.j = false;
        return;
        k = 0;
        break;
        label56: localObject = new i.a(ek.b(ek.this), ek.c(ek.this));
        break label39;
        if (((this.e instanceof i.b)) && (this.e.a()));
        while (true)
        {
          if (k != 0)
            break label159;
          if (!b())
            break label161;
          String str = cd.a(ek.d(ek.this));
          int m = k.a(this.g, str);
          this.e = new i.b(m);
          ek.a(ek.this, m);
          break;
          k = 0;
        }
        label159: continue;
        label161: this.e = b(this.h, this.i);
      }
    }

    public void a(int paramInt)
    {
      this.g = c(paramInt);
      d();
    }

    public void a(int paramInt1, int paramInt2)
    {
      this.h = paramInt1;
      this.i = paramInt2;
      d();
    }

    public void b(int paramInt)
    {
      this.f = paramInt;
      d();
    }

    protected boolean b()
    {
      if (ek.a(ek.this).h());
      do
        return false;
      while ((ek.b(ek.this).b()) || (System.currentTimeMillis() - ek.b(ek.this).k() <= 1296000000L));
      return true;
    }

    public i.g c()
    {
      a();
      return this.e;
    }

    protected void d()
    {
      this.j = true;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ek
 * JD-Core Version:    0.6.0
 */