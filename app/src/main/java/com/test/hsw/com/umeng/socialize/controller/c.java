package com.umeng.socialize.controller;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.OnSnsPlatformClickListener;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.media.BaseShareContent;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.m;

final class c
  implements SocializeListeners.OnSnsPlatformClickListener
{
  c(p paramp, String paramString)
  {
  }

  public void a(Context paramContext, ay paramay, SocializeListeners.SnsPostListener paramSnsPostListener)
  {
    String str1;
    UMediaObject localUMediaObject;
    if (paramay != null)
    {
      str1 = paramay.d();
      localUMediaObject = paramay.a();
    }
    while (true)
    {
      if ((localUMediaObject != null) && ((localUMediaObject instanceof BaseShareContent)))
      {
        BaseShareContent localBaseShareContent = (BaseShareContent)localUMediaObject;
        str1 = localBaseShareContent.k();
        localUMediaObject = localBaseShareContent.c();
      }
      String str3;
      String str2;
      int i;
      switch (d.a[this.a.ordinal()])
      {
      default:
        str3 = null;
        str2 = null;
        if ((str2 != null) && (str3 != null) && (com.umeng.socialize.utils.c.a(str2, paramContext)))
          break;
        Toast.makeText(paramContext, "sorry, you haven't installed " + this.a + "yet.", 0).show();
        i = 40000;
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        if (paramSnsPostListener != null)
          paramSnsPostListener.a(this.a, i, paramay);
        return;
        str2 = "com.twitter.android";
        str3 = "com.twitter.android.composer.ComposerActivity";
        break;
        str2 = "com.google.android.apps.plus";
        str3 = "com.google.android.libraries.social.gateway.GatewayActivity";
        break;
        str2 = "com.facebook.katana";
        str3 = "com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias";
        break;
        ax.e(this.a);
        Intent localIntent = b.a(paramContext, str1, localUMediaObject);
        localIntent.setClassName(str2, str3);
        try
        {
          paramContext.startActivity(localIntent);
          m.a(paramContext, this.b, str1, localUMediaObject, this.a.toString());
          i = 200;
        }
        catch (Exception localException)
        {
          Toast.makeText(paramContext, "" + this.a + " is disabled", 0).show();
          i = 40000;
        }
      }
      localUMediaObject = null;
      str1 = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.c
 * JD-Core Version:    0.6.0
 */