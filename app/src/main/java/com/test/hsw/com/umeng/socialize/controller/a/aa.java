package com.umeng.socialize.controller.a;

import android.content.Context;
import com.umeng.socialize.a.a;
import com.umeng.socialize.b.m;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.FetchFriendsListener;
import com.umeng.socialize.utils.i;

class aa extends s<m>
{
  aa(x paramx, SocializeListeners.FetchFriendsListener paramFetchFriendsListener, b paramb, Context paramContext, p paramp, String paramString)
  {
  }

  protected void a()
  {
    super.a();
    if (this.a != null)
      this.a.a();
  }

  protected void a(m paramm)
  {
    super.a(paramm);
    if (this.a != null)
    {
      if (paramm != null)
        this.a.a(paramm.n, paramm.a);
    }
    else
      return;
    this.a.a(-102, null);
  }

  protected m d()
  {
    try
    {
      m localm = this.b.a(this.c, this.d, this.e);
      return localm;
    }
    catch (NullPointerException localNullPointerException)
    {
      i.b(x.g(), localNullPointerException.toString());
      return null;
    }
    catch (a locala)
    {
      i.b(x.g(), locala.toString());
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.aa
 * JD-Core Version:    0.6.0
 */