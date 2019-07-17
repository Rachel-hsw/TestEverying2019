package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.utils.m;

class k extends s<Integer>
{
  k(c paramc, SocializeListeners.SocializeClientListener paramSocializeClientListener, Context paramContext, bf parambf)
  {
  }

  protected void a()
  {
    super.a();
    this.a.a();
  }

  protected void a(Integer paramInteger)
  {
    super.a(paramInteger);
    if (200 != paramInteger.intValue())
      m.a(this.b, null, paramInteger);
    this.a.a(paramInteger.intValue(), this.d.a);
  }

  protected Integer d()
  {
    return Integer.valueOf(this.d.a(this.b, this.c));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.k
 * JD-Core Version:    0.6.0
 */