package com.umeng.socialize.controller.a;

import android.app.Activity;
import android.os.Bundle;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.utils.i;

class h
  implements SocializeListeners.UMAuthListener
{
  private boolean d = false;

  h(c paramc, SocializeListeners.UMAuthListener paramUMAuthListener, Activity paramActivity)
  {
  }

  public void a(Bundle paramBundle, p paramp)
  {
    this.a.a(paramBundle, paramp);
  }

  public void a(a parama, p paramp)
  {
    i.b("com.umeng.socialize", "do auth by sso failed." + parama.toString());
    i.b(c.c(this.c), "", parama);
    if (!this.d);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      if ((!this.d) || (paramp.a()))
        break;
      c.a(this.c, this.b, paramp, this);
      return;
    }
    this.a.a(parama, paramp);
  }

  public void a(p paramp)
  {
    this.a.a(paramp);
  }

  public void b(p paramp)
  {
    this.a.b(paramp);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.h
 * JD-Core Version:    0.6.0
 */