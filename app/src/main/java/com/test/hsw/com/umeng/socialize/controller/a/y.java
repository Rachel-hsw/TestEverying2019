package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.utils.m;

class y extends s<Integer>
{
  y(x paramx, SocializeListeners.SocializeClientListener paramSocializeClientListener, b paramb, Context paramContext)
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
    if (200 != paramInteger.intValue())
      m.a(this.c, null, paramInteger);
    if (this.a != null)
      this.a.a(paramInteger.intValue(), this.d.a);
  }

  protected Integer d()
  {
    return Integer.valueOf(this.b.d(this.c));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.y
 * JD-Core Version:    0.6.0
 */