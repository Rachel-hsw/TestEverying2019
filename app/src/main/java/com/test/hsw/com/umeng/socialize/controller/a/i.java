package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.b.u;
import com.umeng.socialize.b.v;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import java.util.Map;

class i extends s<v>
{
  i(c paramc, Context paramContext, SocializeListeners.UMDataListener paramUMDataListener, Map paramMap)
  {
  }

  protected void a(v paramv)
  {
    super.a(paramv);
    this.b.b();
    this.b.a(200, this.c);
  }

  protected v d()
  {
    if (!this.d.a.e)
      new a(this.d.a).c(this.a);
    return (v)new com.umeng.socialize.b.a.a().a(new u(this.a, this.d.a));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.i
 * JD-Core Version:    0.6.0
 */