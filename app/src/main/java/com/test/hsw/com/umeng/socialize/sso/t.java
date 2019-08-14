package com.umeng.socialize.sso;

import android.os.Bundle;

class t
  implements UMTencentSsoHandler.ObtainImageUrlListener
{
  t(s params)
  {
  }

  public void a(String paramString)
  {
    l.c(this.a.b).putString("imageUrl", paramString);
    l.c(this.a.b).remove("imageLocalUrl");
    l.d(this.a.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.t
 * JD-Core Version:    0.6.0
 */