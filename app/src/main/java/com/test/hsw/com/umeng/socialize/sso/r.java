package com.umeng.socialize.sso;

import android.content.Context;
import android.os.Bundle;
import com.umeng.socialize.utils.a;
import com.umeng.socialize.utils.m;

class r extends UMTencentSsoHandler.a<Void>
{
  r(l paraml, Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1);
  }

  protected void a(Void paramVoid)
  {
    super.a(paramVoid);
    m.a(this.b.b);
    String str = a.c(this.a);
    l.c(this.b).putString("imageLocalUrl", str);
    l.c(this.b).remove("imageUrl");
    l.d(this.b);
  }

  protected Void d()
  {
    a.b(this.a);
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.r
 * JD-Core Version:    0.6.0
 */