package com.umeng.socialize.controller;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b
{
  private static Map<p, String> a = new HashMap();

  static
  {
    a.put(p.m, "com.facebook.katana");
    a.put(p.n, "com.twitter.android");
    a.put(p.a, "com.google.android.apps.plus");
  }

  private static Intent a(Context paramContext, p paramp, Intent paramIntent)
  {
    paramIntent.setFlags(270532608);
    while (true)
    {
      try
      {
        List localList = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0);
        String str = (String)a.get(paramp);
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext())
          break label114;
        localResolveInfo = (ResolveInfo)localIterator.next();
        if (!str.equals(localResolveInfo.activityInfo.packageName))
          continue;
        if (localResolveInfo != null)
        {
          paramIntent.setClassName(localResolveInfo.activityInfo.packageName, "com.google.android.apps.plus.phone.HomeActivity");
          return paramIntent;
        }
      }
      catch (Exception localException)
      {
        i.e("com.umeng.socialize", "", localException);
      }
      return null;
      label114: ResolveInfo localResolveInfo = null;
    }
  }

  public static com.umeng.socialize.bean.b a(Context paramContext, p paramp, String paramString)
  {
    if (a.keySet().contains(paramp))
    {
      if (TextUtils.isEmpty(paramString))
        paramString = paramp.toString();
      return b(paramContext, paramp, paramString);
    }
    return null;
  }

  private static Intent b(Context paramContext, String paramString, UMediaObject paramUMediaObject)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("image/*;text/plain");
    if (!TextUtils.isEmpty(paramString))
    {
      localIntent.putExtra("android.intent.extra.TEXT", paramString);
      localIntent.putExtra("android.intent.extra.SUBJECT", paramString);
    }
    if ((paramUMediaObject instanceof UMImage))
    {
      String str = ((UMImage)paramUMediaObject).k();
      if (str != null)
      {
        Uri localUri = m.a(paramContext, str);
        if (localUri != null)
        {
          localIntent.putExtra("android.intent.extra.STREAM", localUri);
          m.b.add(localUri);
        }
      }
    }
    return localIntent;
  }

  private static com.umeng.socialize.bean.b b(Context paramContext, p paramp, String paramString)
  {
    String str = "umeng_socialize_google";
    if (paramp == p.m)
      str = "umeng_socialize_facebook";
    while (true)
    {
      int i = com.umeng.socialize.common.b.a(paramContext, b.a.c, str);
      com.umeng.socialize.bean.b localb = new com.umeng.socialize.bean.b(paramp.toString(), i);
      localb.d = i;
      localb.k = new c(paramp, paramString);
      return localb;
      if (paramp != p.n)
        continue;
      str = "umeng_socialize_twitter";
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.b
 * JD-Core Version:    0.6.0
 */