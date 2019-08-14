package com.umeng.socialize.view;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.view.abs.SocialPopupDialog;

class g
  implements SocializeListeners.UMAuthListener
{
  g(f paramf, p paramp)
  {
  }

  public void a(Bundle paramBundle, p paramp)
  {
    if (!TextUtils.isEmpty(paramBundle.getString("uid")))
    {
      a.a(this.b.b, this.a);
      return;
    }
    a.a(this.b.b).c();
  }

  public void a(com.umeng.socialize.a.a parama, p paramp)
  {
    a.a(this.b.b).c();
  }

  public void a(p paramp)
  {
    a.a(this.b.b).c();
  }

  public void b(p paramp)
  {
    a.a(this.b.b).b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.g
 * JD-Core Version:    0.6.0
 */