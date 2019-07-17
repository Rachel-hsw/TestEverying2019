package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public final class b
{
  private static final String a = "00:00:00:00:00:00";
  private static b e = null;
  private String b;
  private String c;
  private String d;

  private b(Context paramContext)
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      b(localTelephonyManager.getDeviceId());
      String str = localTelephonyManager.getSubscriberId();
      if (str != null)
        str = (str + "000000000000000").substring(0, 15);
      this.b = str;
      this.d = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return;
    }
    catch (Exception localException)
    {
      return;
    }
    finally
    {
      if (TextUtils.isEmpty(this.d))
        this.d = "00:00:00:00:00:00";
    }
    throw localObject;
  }

  public static b a(Context paramContext)
  {
    if (e == null)
      e = new b(paramContext);
    return e;
  }

  private void a(String paramString)
  {
    if (paramString != null)
      paramString = (paramString + "000000000000000").substring(0, 15);
    this.b = paramString;
  }

  public static g b(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 0))
        return g.a(localNetworkInfo.getSubtype());
      if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        return g.a;
      g localg = g.o;
      return localg;
    }
    catch (Exception localException)
    {
    }
    return g.o;
  }

  private void b(String paramString)
  {
    if (paramString != null)
    {
      byte[] arrayOfByte = paramString.getBytes();
      for (int i = 0; i < arrayOfByte.length; i++)
      {
        if ((arrayOfByte[i] >= 48) && (arrayOfByte[i] <= 57))
          continue;
        arrayOfByte[i] = 48;
      }
      String str = new String(arrayOfByte);
      paramString = (str + "000000000000000").substring(0, 15);
    }
    this.c = paramString;
  }

  public static String c(Context paramContext)
  {
    b localb = a(paramContext);
    String str1 = localb.b();
    String str2 = str1 + "|";
    String str3 = localb.a();
    if (TextUtils.isEmpty(str3));
    for (String str4 = str2 + "000000000000000"; ; str4 = str2 + str3)
      return str4.substring(0, 8);
  }

  private String d()
  {
    String str1 = b();
    String str2 = str1 + "|";
    String str3 = a();
    if (TextUtils.isEmpty(str3))
      return str2 + "000000000000000";
    return str2 + str3;
  }

  public final String a()
  {
    if (TextUtils.isEmpty(this.b))
      this.b = "000000000000000";
    return this.b;
  }

  public final String b()
  {
    if (TextUtils.isEmpty(this.c))
      this.c = "000000000000000";
    return this.c;
  }

  public final String c()
  {
    return this.d;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.util.b
 * JD-Core Version:    0.6.0
 */