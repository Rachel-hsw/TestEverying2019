package com.umeng.socialize.view;

import android.webkit.WebView;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.controller.listener.SocializeListeners.SocializeClientListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;

class ai
  implements SocializeListeners.SocializeClientListener
{
  ai(aa paramaa)
  {
  }

  public void a()
  {
  }

  public void a(int paramInt, ay paramay)
  {
    if (paramInt == 200)
    {
      String str = aa.a(this.a, paramay, aa.h(this.a));
      aa.i(this.a).loadUrl(str);
      return;
    }
    if (aa.j(this.a) != null)
      aa.j(this.a).a(new a("can`t initlized entity.."), aa.h(this.a));
    aa.i(this.a).loadData("Error:502  Please make sure your network is available.", "text/html", "UTF-8");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.ai
 * JD-Core Version:    0.6.0
 */