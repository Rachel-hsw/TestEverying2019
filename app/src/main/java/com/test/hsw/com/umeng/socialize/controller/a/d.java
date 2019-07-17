package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.b.f;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import com.umeng.socialize.utils.m;
import java.util.Map;

class d extends s<com.umeng.socialize.b.a>
{
  d(c paramc, SocializeListeners.UMDataListener paramUMDataListener, Context paramContext)
  {
  }

  protected void a()
  {
    super.a();
    this.a.b();
  }

  protected void a(com.umeng.socialize.b.a parama)
  {
    if (parama != null)
    {
      c.a(this.c, parama.b);
      c.b(this.c, parama.a);
      String str1 = p.g.toString();
      String str2 = p.f.toString();
      c.a(this.c).put(str1, c.a(this.c).get(str2));
      c.b(this.c).put(str1, c.b(this.c).get(str2));
      m.a(this.b, c.b(this.c));
      m.b(this.b, c.a(this.c));
      if (this.a != null)
        this.a.a(parama.n, c.b(this.c));
      return;
    }
    this.a.a(-102, null);
  }

  protected com.umeng.socialize.b.a d()
  {
    a locala = new a(this.c.a);
    if (!locala.c(this.b))
      locala.d(this.b);
    return (com.umeng.socialize.b.a)new com.umeng.socialize.b.a.a().a(new f(this.b, this.c.a));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.d
 * JD-Core Version:    0.6.0
 */