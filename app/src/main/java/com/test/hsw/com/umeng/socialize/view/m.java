package com.umeng.socialize.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.a.o;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;

class m
  implements View.OnClickListener
{
  m(ShareActivity paramShareActivity)
  {
  }

  public void onClick(View paramView)
  {
    ShareActivity.g(this.a).setClickable(false);
    if (ShareActivity.h(this.a) != null)
    {
      ShareActivity.h(this.a).b(o.d);
      ShareActivity.k(this.a).a(SocializeListeners.SnsPostListener.class, ShareActivity.i(this.a), 40000, ShareActivity.j(this.a));
      ShareActivity.h(this.a).c().a();
      this.a.a();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.m
 * JD-Core Version:    0.6.0
 */