package com.umeng.socialize.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.umeng.socialize.bean.aw;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.utils.k;

class f
  implements View.OnClickListener
{
  f(a parama, aw paramaw)
  {
  }

  public void onClick(View paramView)
  {
    p localp = p.a(this.a.a);
    if (k.a(a.c(this.b), localp))
    {
      a.a(this.b, localp);
      return;
    }
    a.d(this.b).a(a.c(this.b), localp, new g(this, localp));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.f
 * JD-Core Version:    0.6.0
 */