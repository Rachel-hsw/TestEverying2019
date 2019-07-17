package com.umeng.socialize.controller.a;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.av;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.az;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.FetchUserListener;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class z extends s<com.umeng.socialize.b.j>
{
  z(x paramx, SocializeListeners.FetchUserListener paramFetchUserListener, b paramb, Context paramContext)
  {
  }

  private void a(Context paramContext, az paramaz)
  {
    if (paramaz.a != null)
    {
      Map localMap = k.a(paramContext);
      Iterator localIterator1 = paramaz.a.iterator();
      while (localIterator1.hasNext())
      {
        av localav = (av)localIterator1.next();
        try
        {
          if (TextUtils.isEmpty(localav.f()))
            continue;
          p localp4 = p.a(localav.b());
          if ((localp4 != null) && (!k.a(paramContext, localp4)))
            k.b(paramContext, localp4, localav.f());
          if ((localp4 == null) || (!localMap.containsKey(localp4)))
            continue;
          localMap.remove(localp4);
        }
        catch (Exception localException)
        {
          i.e(x.g(), "Sync user center failed..", localException);
        }
      }
      if (localMap.size() > 0)
      {
        Iterator localIterator2 = localMap.keySet().iterator();
        while (localIterator2.hasNext())
        {
          p localp3 = (p)localIterator2.next();
          k.g(paramContext, localp3);
          k.d(paramContext, localp3);
        }
      }
    }
    p localp1;
    if (paramaz.c != null)
    {
      localp1 = p.a(paramaz.c.b());
      if (!com.umeng.socialize.utils.j.c(paramContext))
        break label262;
      p localp2 = com.umeng.socialize.utils.j.b(paramContext);
      i = 0;
      if (localp1 != null)
      {
        i = 0;
        if (localp1 == localp2);
      }
    }
    label262: for (int i = 1; ; i = 1)
    {
      if (i != 0)
        com.umeng.socialize.utils.j.a(paramContext, localp1.toString());
      return;
    }
  }

  protected void a()
  {
    super.a();
    if (this.a != null)
      this.a.a();
  }

  protected void a(com.umeng.socialize.b.j paramj)
  {
    super.a(paramj);
    if (this.a != null)
    {
      if (paramj != null)
        this.a.a(paramj.n, paramj.a);
    }
    else
      return;
    this.a.a(-102, null);
  }

  protected com.umeng.socialize.b.j d()
  {
    try
    {
      com.umeng.socialize.b.j localj = this.b.e(this.c);
      if (localj != null);
      try
      {
        if ((localj.a != null) && (this.d.c().k()))
          a(this.c, localj.a);
        return localj;
      }
      catch (Exception localException)
      {
        i.e(x.g(), "Sync user center failed..", localException);
        return localj;
      }
    }
    catch (a locala)
    {
      i.b(x.g(), locala.toString());
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.z
 * JD-Core Version:    0.6.0
 */