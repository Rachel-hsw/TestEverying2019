package com.umeng.socialize.sso;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.bean.l;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.a.b;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.k;

class y extends s<Integer>
{
  y(UMTencentSsoHandler paramUMTencentSsoHandler, SocializeListeners.UMAuthListener paramUMAuthListener, Context paramContext, bf parambf, Bundle paramBundle)
  {
  }

  protected void a()
  {
    super.a();
    if (this.a != null)
    {
      SocializeListeners.UMAuthListener localUMAuthListener = this.a;
      localUMAuthListener.b(ax.o());
    }
  }

  protected void a(Integer paramInteger)
  {
    super.a(paramInteger);
    if (200 != paramInteger.intValue())
      i.c(UMTencentSsoHandler.o(), "##### Token 授权失败");
    while (true)
    {
      if (this.a != null)
      {
        SocializeListeners.UMAuthListener localUMAuthListener = this.a;
        Bundle localBundle = this.d;
        localUMAuthListener.a(localBundle, ax.o());
      }
      i.c(UMTencentSsoHandler.o(), "RESULT : CODE = " + paramInteger);
      return;
      i.c(UMTencentSsoHandler.o(), "##### Token 授权成功");
      String str = this.c.b();
      p localp = p.a(this.c.a);
      if ((localp == null) || (TextUtils.isEmpty(str)))
        continue;
      k.a(this.b, localp, str, "null");
      k.b(this.b, localp, this.c.b);
    }
  }

  protected Integer d()
  {
    return Integer.valueOf(new b(new ay("qq", l.a)).a(this.b, this.c));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.y
 * JD-Core Version:    0.6.0
 */