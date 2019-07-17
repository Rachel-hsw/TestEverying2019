package com.umeng.socialize.controller.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.k;
import com.umeng.socialize.utils.m;

class r
  implements SocializeListeners.UMAuthListener
{
  r(o paramo, ProgressDialog paramProgressDialog, Context paramContext, SocializeListeners.SnsPostListener paramSnsPostListener, Intent paramIntent)
  {
  }

  public void a(Bundle paramBundle, p paramp)
  {
    m.a(this.a);
    String str = paramBundle.getString("uid");
    if (!TextUtils.isEmpty(str))
    {
      k.b(this.b, paramp, str);
      i.c(o.b(this.e), "do oauth successed " + paramp);
      if (o.c(this.e))
      {
        o.a(this.e, false);
        this.e.a(this.b, str, paramp, this.c);
      }
    }
    else
    {
      return;
    }
    if (this.c != null)
      this.e.c.b(this.c);
    this.b.startActivity(this.d);
  }

  public void a(a parama, p paramp)
  {
    m.a(this.a);
  }

  public void a(p paramp)
  {
    m.a(this.a);
  }

  public void b(p paramp)
  {
    m.a(this.a);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.r
 * JD-Core Version:    0.6.0
 */