package com.ta.utdid2.b.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public final class e
{
  private static ConnectivityManager a = null;
  private static final int[] b = { 4, 7, 2, 1 };

  public static boolean a(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = c(paramContext);
    if (localConnectivityManager != null)
      try
      {
        NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        if (localNetworkInfo != null)
        {
          boolean bool = localNetworkInfo.isConnected();
          return bool;
        }
      }
      catch (Exception localException)
      {
        Log.e("NetworkUtils", localException.toString());
      }
    while (true)
    {
      return false;
      Log.e("NetworkUtils", "connManager is null!");
    }
  }

  public static boolean b(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = c(paramContext);
    if (localConnectivityManager != null);
    while (true)
    {
      int k;
      try
      {
        NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        if (localNetworkInfo == null)
          continue;
        int i = localNetworkInfo.getSubtype();
        if (!c.a)
          continue;
        Log.d("NetworkUtils", "subType:" + i + ": name:" + localNetworkInfo.getSubtypeName());
        int[] arrayOfInt = b;
        int j = arrayOfInt.length;
        k = 0;
        if (k >= j)
          break label132;
        if (arrayOfInt[k] != i)
          break label134;
        return true;
        Log.e("NetworkUtils", "networkInfo is null!");
        return false;
      }
      catch (Exception localException)
      {
        Log.e("NetworkUtils", localException.toString());
        return false;
      }
      Log.e("NetworkUtils", "connManager is null!");
      label132: return false;
      label134: k++;
    }
  }

  private static ConnectivityManager c(Context paramContext)
  {
    if (paramContext == null)
    {
      Log.e("NetworkUtils", "context is null!");
      return null;
    }
    if (a == null)
      a = (ConnectivityManager)paramContext.getSystemService("connectivity");
    return a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.b.a.e
 * JD-Core Version:    0.6.0
 */