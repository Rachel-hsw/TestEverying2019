package com.umeng.socialize.sso;

import android.content.Context;
import android.widget.Toast;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.controller.listener.SocializeListeners.OnSnsPlatformClickListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;

class b
  implements SocializeListeners.OnSnsPlatformClickListener
{
  b(a parama)
  {
  }

  public void a(Context paramContext, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    if (this.a.e())
    {
      this.a.C.b(paramSnsPostListener);
      this.a.a(this.a.G, paramay, paramSnsPostListener);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("请安装");
    localStringBuilder.append(this.a.G.b);
    localStringBuilder.append("客户端");
    Toast.makeText(this.a.D, localStringBuilder.toString(), 0).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.b
 * JD-Core Version:    0.6.0
 */