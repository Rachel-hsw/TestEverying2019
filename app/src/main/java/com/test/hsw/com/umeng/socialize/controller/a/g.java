package com.umeng.socialize.controller.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;

class g
  implements SocializeListeners.UMAuthListener
{
  Context a = this.b.getApplicationContext();

  g(c paramc, Activity paramActivity, SocializeListeners.UMAuthListener paramUMAuthListener)
  {
  }

  public void a(Bundle paramBundle, p paramp)
  {
    if (TextUtils.isEmpty(paramBundle.getString("uid")))
      Toast.makeText(this.a, "授权失败,请重试！", 1).show();
    if (this.c != null)
      this.c.a(paramBundle, paramp);
  }

  public void a(a parama, p paramp)
  {
    Toast.makeText(this.a, "授权失败,请重试！", 1).show();
    if (this.c != null)
      this.c.a(parama, paramp);
  }

  public void a(p paramp)
  {
    if (this.c != null)
      this.c.a(paramp);
  }

  public void b(p paramp)
  {
    if (this.c != null)
      this.c.b(paramp);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.g
 * JD-Core Version:    0.6.0
 */