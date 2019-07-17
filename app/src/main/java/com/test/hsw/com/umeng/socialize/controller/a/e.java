package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.b.a.a;
import com.umeng.socialize.b.a.f;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.utils.m;

class e extends s<Integer>
{
  e(c paramc, SocializeListeners.SocializeClientListener paramSocializeClientListener, Context paramContext, p paramp)
  {
  }

  protected void a()
  {
    super.a();
    if (this.a != null)
      this.a.a();
  }

  protected void a(Integer paramInteger)
  {
    super.a(paramInteger);
    if (paramInteger.intValue() == 200)
    {
      com.umeng.socialize.utils.k.g(this.b, this.c);
      com.umeng.socialize.utils.k.d(this.b, this.c);
    }
    while (true)
    {
      if (this.a != null)
        this.a.a(paramInteger.intValue(), this.d.a);
      return;
      m.a(this.b, this.c, paramInteger);
    }
  }

  protected Integer d()
  {
    f localf = new a().a(new com.umeng.socialize.b.k(this.b, this.d.a, this.c));
    if (localf != null)
      return Integer.valueOf(localf.n);
    return Integer.valueOf(-102);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.e
 * JD-Core Version:    0.6.0
 */