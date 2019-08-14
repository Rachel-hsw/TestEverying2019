package com.umeng.socialize.controller.a;

import android.content.Context;
import android.widget.Toast;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.ba;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.b;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;

class w
  implements SocializeListeners.SnsPostListener
{
  w(o paramo, Context paramContext)
  {
  }

  public void a()
  {
    if (this.b.c.r())
    {
      String str = b.a(this.a, "umeng_socialize_text_waitting_share");
      Toast.makeText(this.a, str, 0).show();
    }
  }

  public void a(p paramp, int paramInt, ay paramay)
  {
    if ((paramInt == 200) && (this.b.c.r()))
      Toast.makeText(this.a, "发送成功", 0).show();
    do
      while (true)
      {
        return;
        if ((paramInt != 5027) && (paramInt != 5028))
          break;
        if (!this.b.c.r())
          continue;
        ba.a(this.a, paramInt, "授权已过期，请重新授权...");
        return;
      }
    while (!this.b.c.r());
    ba.a(this.a, paramInt, "发送失败，请重试...");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.w
 * JD-Core Version:    0.6.0
 */