package com.umeng.socialize.sso;

import android.os.Bundle;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.media.UMImage;

class h
  implements SocializeListeners.UMAuthListener
{
  h(c paramc, UMImage paramUMImage, Bundle paramBundle)
  {
  }

  public void a(Bundle paramBundle, p paramp)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("uid")))
    {
      String str = paramBundle.getString("uid");
      this.c.a(this.a, str, new i(this));
    }
  }

  public void a(a parama, p paramp)
  {
  }

  public void a(p paramp)
  {
  }

  public void b(p paramp)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.h
 * JD-Core Version:    0.6.0
 */