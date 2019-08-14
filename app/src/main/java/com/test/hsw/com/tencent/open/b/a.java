package com.tencent.open.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.open.a.f;

public class a
{
  protected static final String a = a.class.getName();
  protected static final Uri b = Uri.parse("content://telephony/carriers/preferapn");

  public static String a(Context paramContext)
  {
    int i = d(paramContext);
    String str;
    if (i == 2)
      str = "wifi";
    do
    {
      return str;
      if (i == 1)
        return "cmwap";
      if (i == 4)
        return "cmnet";
      if (i == 16)
        return "uniwap";
      if (i == 8)
        return "uninet";
      if (i == 64)
        return "wap";
      if (i == 32)
        return "net";
      if (i == 512)
        return "ctwap";
      if (i == 256)
        return "ctnet";
      if (i == 2048)
        return "3gnet";
      if (i == 1024)
        return "3gwap";
      str = b(paramContext);
    }
    while ((str != null) && (str.length() != 0));
    return "none";
  }

  public static String b(Context paramContext)
  {
    String str;
    try
    {
      Cursor localCursor = paramContext.getContentResolver().query(b, null, null, null, null);
      if (localCursor == null)
        return null;
      localCursor.moveToFirst();
      if (localCursor.isAfterLast())
      {
        if (localCursor == null)
          break label111;
        localCursor.close();
        break label111;
      }
      str = localCursor.getString(localCursor.getColumnIndex("apn"));
      if (localCursor != null)
      {
        localCursor.close();
        return str;
      }
    }
    catch (SecurityException localSecurityException)
    {
      f.e(a, "getApn has exception: " + localSecurityException.getMessage());
      str = "";
    }
    return str;
    label111: return null;
  }

  public static String c(Context paramContext)
  {
    String str;
    try
    {
      Cursor localCursor = paramContext.getContentResolver().query(b, null, null, null, null);
      if (localCursor == null)
        return null;
      localCursor.moveToFirst();
      if (localCursor.isAfterLast())
      {
        if (localCursor == null)
          break label111;
        localCursor.close();
        break label111;
      }
      str = localCursor.getString(localCursor.getColumnIndex("proxy"));
      if (localCursor != null)
      {
        localCursor.close();
        return str;
      }
    }
    catch (SecurityException localSecurityException)
    {
      f.e(a, "getApnProxy has exception: " + localSecurityException.getMessage());
      str = "";
    }
    return str;
    label111: return null;
  }

  public static int d(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
        return 128;
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null)
        return 128;
      if (localNetworkInfo.getTypeName().toUpperCase().equals("WIFI"))
        return 2;
      String str1 = localNetworkInfo.getExtraInfo().toLowerCase();
      if (str1.startsWith("cmwap"))
        return 1;
      if ((str1.startsWith("cmnet")) || (str1.startsWith("epc.tmobile.com")))
        break label274;
      if (str1.startsWith("uniwap"))
        return 16;
      if (str1.startsWith("uninet"))
        return 8;
      if (str1.startsWith("wap"))
        return 64;
      if (str1.startsWith("net"))
        return 32;
      if (str1.startsWith("ctwap"))
        return 512;
      if (str1.startsWith("ctnet"))
        return 256;
      if (str1.startsWith("3gwap"))
        return 1024;
      if (str1.startsWith("3gnet"))
        return 2048;
      if (str1.startsWith("#777"))
      {
        String str2 = c(paramContext);
        if (str2 != null)
        {
          int i = str2.length();
          if (i > 0)
            return 512;
        }
        return 256;
      }
    }
    catch (Exception localException)
    {
      f.e(a, "getMProxyType has exception: " + localException.getMessage());
    }
    return 128;
    label274: return 4;
  }

  public static String e(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
      return "MOBILE";
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo != null)
      return localNetworkInfo.getTypeName();
    return "MOBILE";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b.a
 * JD-Core Version:    0.6.0
 */