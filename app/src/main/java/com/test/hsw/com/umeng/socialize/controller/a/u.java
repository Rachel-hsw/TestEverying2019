package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.k;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;
import com.umeng.socialize.utils.m;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class u extends s<k>
{
  u(o paramo, SocializeListeners.MulStatusListener paramMulStatusListener, Context paramContext, ar[] paramArrayOfar, UMShareMsg paramUMShareMsg, Map paramMap)
  {
  }

  protected void a()
  {
    super.a();
    if (this.a != null)
      this.a.a();
  }

  protected void a(k paramk)
  {
    super.a(paramk);
    Map localMap = paramk.c();
    localMap.putAll(this.e);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      int i = ((Integer)localMap.get(localp)).intValue();
      if (200 == i)
        continue;
      m.a(this.b, localp, Integer.valueOf(i));
    }
    if (this.a != null)
      this.a.a(paramk, paramk.a(), this.f.a);
  }

  protected k d()
  {
    if (o.a(this.f, this.b))
      return o.a(this.f, this.b, this.c, this.d);
    return new k(-104);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.u
 * JD-Core Version:    0.6.0
 */