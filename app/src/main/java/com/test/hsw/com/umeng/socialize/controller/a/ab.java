package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.k;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.MulStatusListener;
import com.umeng.socialize.utils.m;

class ab extends s<k>
{
  ab(x paramx, SocializeListeners.MulStatusListener paramMulStatusListener, b paramb, Context paramContext, ar paramar, String[] paramArrayOfString, p paramp)
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
    if (200 != paramk.a())
      m.a(this.c, this.f, Integer.valueOf(paramk.a()));
    if (this.a != null)
      this.a.a(paramk, paramk.a(), this.g.a);
  }

  protected k d()
  {
    return this.b.a(this.c, this.d, this.e);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.ab
 * JD-Core Version:    0.6.0
 */