package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;

class j
  implements SocializeListeners.SocializeClientListener
{
  j(c paramc, SocializeListeners.SocializeClientListener paramSocializeClientListener, bf parambf, Context paramContext)
  {
  }

  public void a()
  {
    if (this.a != null)
      this.a.a();
  }

  public void a(int paramInt, ay paramay)
  {
    if ((paramInt == 200) && (this.b != null))
    {
      p localp = p.a(this.b.a);
      paramay.a(this.c, localp, 13);
    }
    if (this.a != null)
      this.a.a(paramInt, paramay);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.j
 * JD-Core Version:    0.6.0
 */