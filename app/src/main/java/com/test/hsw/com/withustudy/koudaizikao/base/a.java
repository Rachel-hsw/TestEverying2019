package com.withustudy.koudaizikao.base;

import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.withustudy.koudaizikao.g.h;

class a
  implements SocializeListeners.SnsPostListener
{
  a(AbsBaseActivity paramAbsBaseActivity)
  {
  }

  public void a()
  {
  }

  public void a(p paramp, int paramInt, ay paramay)
  {
    if (paramInt == 200)
      h.a(this.a.getApplicationContext(), "WEIXIN_CIRCLE 200");
    do
      return;
    while (paramInt != -101);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.base.a
 * JD-Core Version:    0.6.0
 */