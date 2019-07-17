package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.android.volley.q;
import java.io.File;

public class w
{
  private static final String a = "volley";

  public static q a(Context paramContext)
  {
    return a(paramContext, null);
  }

  public static q a(Context paramContext, int paramInt)
  {
    return a(paramContext, null, paramInt);
  }

  public static q a(Context paramContext, j paramj)
  {
    return a(paramContext, paramj, -1);
  }

  public static q a(Context paramContext, j paramj, int paramInt)
  {
    File localFile = new File(paramContext.getCacheDir(), "volley");
    Object localObject = "volley/0";
    try
    {
      String str1 = paramContext.getPackageName();
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(str1, 0);
      String str2 = str1 + "/" + localPackageInfo.versionCode;
      localObject = str2;
      label70: c localc;
      if (paramj == null)
      {
        if (Build.VERSION.SDK_INT >= 9)
          paramj = new k();
      }
      else
      {
        localc = new c(paramj);
        if (paramInt > -1)
          break label148;
      }
      label148: for (q localq = new q(new g(localFile), localc); ; localq = new q(new g(localFile, paramInt), localc))
      {
        localq.a();
        return localq;
        paramj = new h(AndroidHttpClient.newInstance((String)localObject));
        break;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label70;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.w
 * JD-Core Version:    0.6.0
 */