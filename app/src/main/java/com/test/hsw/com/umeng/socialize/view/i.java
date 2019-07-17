package com.umeng.socialize.view;

import com.umeng.socialize.bean.ay;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.a;
import com.umeng.socialize.utils.j;
import com.umeng.socialize.view.abs.SocialPopupDialog;

class i
  implements SocializeListeners.SocializeClientListener
{
  i(a parama)
  {
  }

  public void a()
  {
    a.a(this.a).b();
  }

  public void a(int paramInt, ay paramay)
  {
    a.a(this.a).c();
    if (paramInt == 200)
    {
      j.a(a.c(this.a), true);
      this.a.b();
      if (a.b(this.a) != null)
        a.b(this.a).a(null, false);
    }
    do
      return;
    while (a.b(this.a) == null);
    a.b(this.a).a(paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.i
 * JD-Core Version:    0.6.0
 */