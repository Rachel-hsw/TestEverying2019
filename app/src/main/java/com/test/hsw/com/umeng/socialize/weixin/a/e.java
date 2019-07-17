package com.umeng.socialize.weixin.a;

import android.os.Bundle;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;

class e extends s<Bundle>
{
  e(a parama, String paramString)
  {
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    SocializeListeners.UMAuthListener localUMAuthListener = a.y(this.b);
    if (a.x(this.b));
    for (p localp = p.j; ; localp = p.i)
    {
      localUMAuthListener.a(paramBundle, localp);
      return;
    }
  }

  protected Bundle d()
  {
    String str = com.umeng.socialize.weixin.b.a.a(this.a);
    return a.c(this.b, str);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.weixin.a.e
 * JD-Core Version:    0.6.0
 */