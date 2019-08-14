package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.b.a.a;
import com.umeng.socialize.b.d;
import com.umeng.socialize.b.e;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import java.util.Map;

class l extends s<e>
{
  l(c paramc, SocializeListeners.UMDataListener paramUMDataListener, Context paramContext, p[] paramArrayOfp)
  {
  }

  protected void a()
  {
    if (this.a != null)
      this.a.b();
  }

  protected void a(e parame)
  {
    int i = -102;
    Map localMap = null;
    if (parame != null)
    {
      localMap = parame.a;
      i = parame.n;
    }
    if (this.a != null)
      this.a.a(i, localMap);
  }

  protected e d()
  {
    return (e)new a().a(new d(this.b, this.d.a, this.c));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.l
 * JD-Core Version:    0.6.0
 */