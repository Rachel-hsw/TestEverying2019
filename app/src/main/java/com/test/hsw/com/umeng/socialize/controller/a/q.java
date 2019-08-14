package com.umeng.socialize.controller.a;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Window;
import android.widget.Toast;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.b;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.controller.listener.SocializeListeners.a;
import com.umeng.socialize.view.ak;

class q extends SocializeListeners.a
{
  q(o paramo, Activity paramActivity)
  {
  }

  public void a(int paramInt)
  {
    String str = this.a.getResources().getString(b.a(this.a, b.a.e, "umeng_socialize_tip_loginfailed"));
    Toast.makeText(this.a, str, 0).show();
  }

  public void a(p paramp, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      o.a(this.b).showAtLocation(this.a.getWindow().getDecorView(), 80, 0, 0);
      return;
    }
    if (paramp != null)
    {
      this.b.a(this.a, paramp, null);
      return;
    }
    o.a(this.b).showAtLocation(this.a.getWindow().getDecorView(), 80, 0, 0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.q
 * JD-Core Version:    0.6.0
 */