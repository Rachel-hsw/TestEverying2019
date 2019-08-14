package com.umeng.socialize.controller.a;

import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;

class n
  implements SocializeListeners.SocializeClientListener
{
  n(c.a parama)
  {
  }

  public void a()
  {
  }

  public void a(int paramInt, ay paramay)
  {
    if (this.a.b != null)
    {
      if (paramInt == 200)
        this.a.b.a(this.a.e, this.a.a);
    }
    else
      return;
    this.a.b.a(new a(paramInt, "upload platform appkey failed."), this.a.a);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.n
 * JD-Core Version:    0.6.0
 */