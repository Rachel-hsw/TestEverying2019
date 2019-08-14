package com.umeng.socialize.sso;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;

class q
  implements SocializeListeners.UMAuthListener
{
  q(l paraml)
  {
  }

  public void a(Bundle paramBundle, p paramp)
  {
    if (!TextUtils.isEmpty(paramBundle.getString("uid")))
    {
      l.a(this.a);
      return;
    }
    Toast.makeText(this.a.D, "授权失败", 0).show();
  }

  public void a(a parama, p paramp)
  {
  }

  public void a(p paramp)
  {
  }

  public void b(p paramp)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.q
 * JD-Core Version:    0.6.0
 */