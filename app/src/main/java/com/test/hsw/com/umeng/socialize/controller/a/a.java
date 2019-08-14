package com.umeng.socialize.controller.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.socialize.b.b;
import com.umeng.socialize.b.f;
import com.umeng.socialize.b.j;
import com.umeng.socialize.b.l;
import com.umeng.socialize.b.m;
import com.umeng.socialize.b.n;
import com.umeng.socialize.b.o;
import com.umeng.socialize.b.s;
import com.umeng.socialize.b.t;
import com.umeng.socialize.b.u;
import com.umeng.socialize.b.v;
import com.umeng.socialize.b.w;
import com.umeng.socialize.b.x;
import com.umeng.socialize.b.y;
import com.umeng.socialize.b.z;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.bc;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.bean.g;
import com.umeng.socialize.bean.k;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.r;
import com.umeng.socialize.controller.AuthService;
import com.umeng.socialize.controller.CommentService;
import com.umeng.socialize.controller.LikeService;
import com.umeng.socialize.controller.ShareService;
import com.umeng.socialize.controller.UserCenterService;
import com.umeng.socialize.controller.e;
import com.umeng.socialize.controller.e.a;
import com.umeng.socialize.media.UMediaObject;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static int g = 0;
  private static final String h = "installed";
  private static final String i = "umsocial_uid";
  protected ay a;
  protected ShareService b;
  protected CommentService c;
  protected LikeService d;
  protected AuthService e;
  protected UserCenterService f;

  public a(ay paramay)
  {
    this.a = paramay;
    this.c = ((CommentService)e.a(this.a, e.a.b, new Object[0]));
    this.d = ((LikeService)e.a(this.a, e.a.d, new Object[0]));
    this.e = ((AuthService)e.a(this.a, e.a.a, new Object[0]));
    this.b = ((ShareService)e.a(this.a, e.a.c, new Object[0]));
    ay localay = this.a;
    e.a locala = e.a.e;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.e;
    this.f = ((UserCenterService)e.a(localay, locala, arrayOfObject));
  }

  public int a(Context paramContext, bf parambf)
  {
    if ((this.e instanceof c))
      return ((c)this.e).a(paramContext, parambf);
    return -105;
  }

  public m a(Context paramContext, p paramp, String paramString)
    throws com.umeng.socialize.a.a
  {
    m localm = (m)new com.umeng.socialize.b.a.a().a(new l(paramContext, this.a, paramp, paramString));
    if (localm == null)
      throw new com.umeng.socialize.a.a(-103, "Response is null...");
    if (localm.n != 200)
      throw new com.umeng.socialize.a.a(localm.n, localm.m);
    if (localm.a != null)
    {
      Iterator localIterator = localm.a.iterator();
      while (localIterator.hasNext())
        ((bc)localIterator.next()).e(paramString);
    }
    return localm;
  }

  public z a(Context paramContext, ar paramar)
  {
    return (z)new com.umeng.socialize.b.a.a().a(new y(paramContext, this.a, paramar));
  }

  public k a(Context paramContext, ar paramar, String[] paramArrayOfString)
  {
    if ((paramar == null) || (TextUtils.isEmpty(paramar.b)) || (paramar.a == null) || (paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return new k(-105);
    n localn = new n(paramContext, this.a, paramar, paramArrayOfString);
    o localo = (o)new com.umeng.socialize.b.a.a().a(localn);
    if (localo == null)
      return new k(-103);
    k localk = new k(localo.n);
    localk.b(localo.a);
    return localk;
  }

  public String a(Context paramContext, UMediaObject paramUMediaObject, String paramString)
  {
    x localx = (x)new com.umeng.socialize.b.a.a().a(new w(paramContext, this.a, paramUMediaObject, paramString));
    if (localx != null)
      return localx.a;
    return "";
  }

  protected boolean c(Context paramContext)
  {
    if (!this.a.e)
      d(paramContext);
    return this.a.e;
  }

  public int d(Context paramContext)
  {
    int j = 1;
    if (g == -1);
    while (true)
    {
      int m;
      com.umeng.socialize.b.c localc;
      synchronized (paramContext.getSharedPreferences("umeng_socialize", 0))
      {
        g = ???.getInt("installed", 1);
        if (!TextUtils.isEmpty(r.g))
          continue;
        r.g = paramContext.getSharedPreferences("umeng_socialize", 0).getString("umsocial_uid", "");
        com.umeng.socialize.utils.i.a("com.umeng.socialize", "set  field UID from preference.");
        com.umeng.socialize.b.a.a locala = new com.umeng.socialize.b.a.a();
        ay localay1 = this.a;
        if (g == 0)
        {
          m = 0;
          localc = (com.umeng.socialize.b.c)locala.a(new b(paramContext, localay1, m));
          if (localc == null)
            break;
          if (g != j)
            continue;
          synchronized (paramContext.getSharedPreferences("umeng_socialize", 0).edit())
          {
            ???.putInt("installed", 0);
            ???.commit();
            g = 0;
            if (localc.n == 200)
              if ((TextUtils.isEmpty(r.g)) || (!r.g.equals(localc.h)))
              {
                com.umeng.socialize.utils.i.a("com.umeng.socialize", "update UID src=" + r.g + " dest=" + localc.h);
                r.g = localc.h;
                synchronized (paramContext.getSharedPreferences("umeng_socialize", 0).edit())
                {
                  ???.putString("umsocial_uid", r.g);
                  ???.commit();
                }
              }
          }
        }
      }
      synchronized (this.a)
      {
        this.a.b(localc.b);
        this.a.a = localc.e;
        this.a.b = localc.d;
        if (localc.f == 0);
        while (true)
        {
          this.a.a(j);
          ay localay3 = this.a;
          if (localc.g != 0)
            break label469;
          localg = g.b;
          localay3.a(localg);
          this.a.c(localc.c);
          this.a.a(localc.a);
          this.a.d(localc.j);
          this.a.e = true;
          return localc.n;
          localObject4 = finally;
          monitorexit;
          throw localObject4;
          m = j;
          break;
          localObject3 = finally;
          monitorexit;
          throw localObject3;
          localObject1 = finally;
          monitorexit;
          throw localObject1;
          int k = 0;
        }
        label469: g localg = g.a;
      }
    }
    return -103;
  }

  public j e(Context paramContext)
    throws com.umeng.socialize.a.a
  {
    j localj = (j)new com.umeng.socialize.b.a.a().a(new com.umeng.socialize.b.i(paramContext, this.a));
    if (localj == null)
      throw new com.umeng.socialize.a.a(-103, "Response is null...");
    if (localj.n != 200)
      throw new com.umeng.socialize.a.a(localj.n, localj.m);
    return localj;
  }

  public com.umeng.socialize.b.a f(Context paramContext)
  {
    return (com.umeng.socialize.b.a)new com.umeng.socialize.b.a.a().a(new f(paramContext, this.a));
  }

  public ay f()
  {
    return this.a;
  }

  public int g(Context paramContext)
  {
    t localt = (t)new com.umeng.socialize.b.a.a().a(new s(paramContext, this.a));
    if (localt != null)
      return localt.n;
    return -102;
  }

  public int h(Context paramContext)
  {
    v localv = (v)new com.umeng.socialize.b.a.a().a(new u(paramContext, this.a));
    if (localv != null)
      return localv.n;
    return -102;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.a
 * JD-Core Version:    0.6.0
 */