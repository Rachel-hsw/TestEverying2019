package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.k;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.utils.m;

class s extends com.umeng.socialize.common.s<k>
{
  s(o paramo, SocializeListeners.SnsPostListener paramSnsPostListener, String paramString1, String paramString2, Context paramContext, UMShareMsg paramUMShareMsg, p paramp)
  {
  }

  protected void a()
  {
    super.a();
    if (this.a != null)
      this.a.a();
    if (this.g.a.s())
      this.g.c.b(SocializeListeners.SnsPostListener.class);
  }

  protected void a(k paramk)
  {
    super.a(paramk);
    p localp = p.a(this.b);
    int i = paramk.a(localp);
    if (i != 200)
      m.a(this.d, localp, Integer.valueOf(i));
    if (this.a != null)
      this.a.a(localp, i, this.g.a);
    if (this.g.a.s())
      this.g.c.a(SocializeListeners.SnsPostListener.class, localp, i, this.g.a);
    o.a(this.g, this.d, (b)this.g.b);
    this.g.c.a();
    o.d(this.g);
    this.g.a.b(false);
  }

  protected k d()
  {
    ar localar = new ar(this.b, this.c);
    k localk;
    if (o.a(this.g, this.d))
    {
      localk = o.a(this.g, this.d, new ar[] { localar }, this.e);
      if (localk == null)
        localk = new k(-102);
    }
    int i;
    do
    {
      do
      {
        return localk;
        localk = new k(-104);
      }
      while (this.f == null);
      i = localk.a(this.f);
    }
    while (-102 == i);
    localk.a(i);
    return localk;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.s
 * JD-Core Version:    0.6.0
 */