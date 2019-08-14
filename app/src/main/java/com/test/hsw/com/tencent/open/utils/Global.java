package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.File;

public final class Global
{
  private static Context a;

  public static final Context getContext()
  {
    if (a == null)
      return null;
    return a;
  }

  public static final File getFilesDir()
  {
    if (getContext() == null)
      return null;
    return getContext().getFilesDir();
  }

  public static final String getPackageName()
  {
    if (getContext() == null)
      return "";
    return getContext().getPackageName();
  }

  public static final SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    if (getContext() == null)
      return null;
    return getContext().getSharedPreferences(paramString, paramInt);
  }

  public static int getVersionCode()
  {
    return a.getSharedPreferences("openSdk.pref", 0).getInt("app.vercode", 0);
  }

  public static void saveVersionCode()
  {
    Context localContext = getContext();
    if (localContext == null);
    while (true)
    {
      return;
      try
      {
        PackageInfo localPackageInfo = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0);
        if (localPackageInfo == null)
          continue;
        SharedPreferences.Editor localEditor = localContext.getSharedPreferences("openSdk.pref", 0).edit();
        localEditor.putInt("app.vercode", localPackageInfo.versionCode);
        localEditor.commit();
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
  }

  public static final void setContext(Context paramContext)
  {
    a = paramContext;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.Global
 * JD-Core Version:    0.6.0
 */