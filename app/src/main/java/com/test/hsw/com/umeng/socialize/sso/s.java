package com.umeng.socialize.sso;

import android.os.Bundle;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.media.UMImage;

class s
  implements SocializeListeners.UMAuthListener
{
  s(l paraml, UMImage paramUMImage)
  {
  }

  public void a(Bundle paramBundle, p paramp)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("uid")))
    {
      String str = paramBundle.getString("uid");
      this.b.a(this.a, str, new t(this));
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
 * Qualified Name:     com.umeng.socialize.sso.s
 * JD-Core Version:    0.6.0
 */