package com.umeng.socialize.controller.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.utils.i;

class m
  implements SocializeListeners.UMAuthListener
{
  m(c.a parama)
  {
  }

  private bf a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("access_token");
    String str2 = paramBundle.getString("uid");
    String str3 = paramBundle.getString("openid");
    if ((this.a.a == p.j) || (this.a.a == p.i));
    for (String str4 = "wxsession"; ; str4 = this.a.a.toString())
      return bf.a(new ar(str4, str2), str1, str3);
  }

  public void a(Bundle paramBundle, p paramp)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("access_token")) && (paramBundle.containsKey("uid")))
    {
      this.a.e = paramBundle;
      bf localbf = a(paramBundle);
      localbf.e(paramBundle.getString("expires_in"));
      String str = paramBundle.getString("refresh_token");
      if (!TextUtils.isEmpty(str))
      {
        localbf.f(str);
        localbf.g(paramBundle.getString("scope"));
        localbf.h(com.umeng.socialize.utils.m.e(com.umeng.socialize.utils.m.a(this.a.d)));
      }
      this.a.g.a(this.a.d, localbf, this.a.a());
    }
    do
    {
      return;
      i.b(c.c(this.a.g), paramp.toString() + " authorize data is invalid.");
    }
    while (this.a.b == null);
    this.a.b.a(new a("no found access_token"), paramp);
  }

  public void a(a parama, p paramp)
  {
    if (this.a.b != null)
      this.a.b.a(parama, paramp);
  }

  public void a(p paramp)
  {
    if (this.a.b != null)
      this.a.b.a(paramp);
  }

  public void b(p paramp)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.m
 * JD-Core Version:    0.6.0
 */