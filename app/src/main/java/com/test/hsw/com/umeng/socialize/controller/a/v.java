package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.k;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.utils.m;

class v extends s<Integer>
{
  v(o paramo, SocializeListeners.SnsPostListener paramSnsPostListener, p paramp, String paramString1, String paramString2, Context paramContext)
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
      m.a(this.e, null, paramInteger);
    if (this.a != null)
      this.a.a(this.b, paramInteger.intValue(), this.f.a);
  }

  protected Integer d()
  {
    ar[] arrayOfar = new ar[1];
    arrayOfar[0] = new ar(this.b.toString(), this.c);
    UMShareMsg localUMShareMsg = new UMShareMsg();
    localUMShareMsg.d = this.d;
    if (o.a(this.f, this.e));
    for (int i = o.a(this.f, this.e, arrayOfar, localUMShareMsg).a(); ; i = -104)
      return Integer.valueOf(i);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.v
 * JD-Core Version:    0.6.0
 */