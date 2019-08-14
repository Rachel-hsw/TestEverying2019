package com.umeng.message.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

final class an
  implements Runnable
{
  an(Context paramContext)
  {
  }

  public void run()
  {
    try
    {
      PackageManager localPackageManager = this.a.getPackageManager();
      if ((TextUtils.equals(am.a(), am.b().toLowerCase())) && (localPackageManager.getPackageInfo("com.huawei.android.pushagent", 4) != null))
        aq.i(this.a, "agoo_huawei");
      if (TextUtils.equals(am.c(), am.b().toLowerCase()))
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.xiaomi.xmsf", 4);
        if ((localPackageInfo != null) && (localPackageInfo.versionCode >= 105))
          aq.i(this.a, "agoo_xiaomi");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.an
 * JD-Core Version:    0.6.0
 */