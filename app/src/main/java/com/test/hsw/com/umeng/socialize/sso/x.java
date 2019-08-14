package com.umeng.socialize.sso;

import android.content.Context;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.l;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.k;
import com.umeng.socialize.utils.m;
import java.util.Map;

class x extends UMTencentSsoHandler.a<com.umeng.socialize.b.a>
{
  x(UMTencentSsoHandler paramUMTencentSsoHandler, Context paramContext, String paramString, UMTencentSsoHandler.ObtainAppIdListener paramObtainAppIdListener)
  {
    super(paramContext, paramString);
  }

  protected void a(com.umeng.socialize.b.a parama)
  {
    super.a(parama);
    if ((parama != null) && (parama.a != null))
    {
      this.b.c = ((String)parama.a.get("qzone"));
      if (parama.b != null)
        this.b.d = ((String)parama.b.get("qzone"));
      m.a(this.b.D, parama.a);
      k.a(this.b.D, this.b.c, this.b.d);
      if (this.a != null)
        this.a.a();
      return;
    }
    i.b(UMTencentSsoHandler.o(), "obtain appId failed,public account share...");
    this.b.c = "100424468";
    this.a.a();
  }

  protected com.umeng.socialize.b.a d()
  {
    return new com.umeng.socialize.controller.a.a(new ay("com.umeng.qq.sso", l.a)).f(this.b.D);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.x
 * JD-Core Version:    0.6.0
 */