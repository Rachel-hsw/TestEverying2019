package com.umeng.socialize.view;

import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.a;
import com.umeng.socialize.view.abs.SocialPopupDialog;

class h
  implements SocializeListeners.SocializeClientListener
{
  h(a parama, p paramp)
  {
  }

  public void a()
  {
    if ((a.a(this.b) != null) && (!a.a(this.b).isShowing()))
      a.a(this.b).b();
  }

  public void a(int paramInt, ay paramay)
  {
    a.a(this.b).c();
    if (paramInt == 200)
    {
      this.b.b();
      if (a.b(this.b) != null)
        a.b(this.b).a(this.a, false);
    }
    do
      return;
    while (a.b(this.b) == null);
    a.b(this.b).a(paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.h
 * JD-Core Version:    0.6.0
 */