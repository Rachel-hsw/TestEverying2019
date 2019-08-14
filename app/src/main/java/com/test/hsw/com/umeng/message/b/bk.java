package com.umeng.message.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.text.TextUtils;
import org.apache.http.HttpHost;

public class bk
{
  static final String a = "wifi";
  static final String b = "wimax";
  static final String c = "mobile";
  static final String d = "gsm";
  static final String e = "gprs";
  static final String f = "edge";
  static final String g = "cdma";
  static final String h = "umts";
  static final String i = "hspa";
  static final String j = "hsupa";
  static final String k = "hsdpa";
  static final String l = "ehrpd";
  static final String m = "evdo0";
  static final String n = "evdoa";
  static final String o = "evdob";
  static final String p = "lte";
  static final String q = "umb";
  static final String r = "hspa+";
  static final String s = "unknown";
  static final String t = "wifi";
  static final String u = "2g";
  static final String v = "3g";
  static final String w = "4g";
  static final String x = "none";
  static final String y = "1xrtt";
  private static final String z = "ConnectManager";
  private String A;
  private int B;
  private String C;
  private boolean D = false;
  private String E;
  private String F;

  public bk(Context paramContext)
  {
    c(paramContext);
    this.F = cm.b(paramContext);
  }

  private final void a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    try
    {
      if (paramNetworkInfo.getExtraInfo() != null)
      {
        String str = paramNetworkInfo.getExtraInfo().toUpperCase().trim();
        if (str != null)
        {
          this.C = str;
          if ((str.indexOf("CMWAP") != -1) || (str.indexOf("UNIWAP") != -1) || (str.indexOf("3GWAP") != -1))
          {
            this.D = true;
            this.A = "10.0.0.172";
            this.B = 80;
            return;
          }
          if (str.indexOf("CTWAP") != -1)
          {
            this.D = true;
            this.A = "10.0.0.200";
            this.B = 80;
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    this.D = false;
  }

  private final void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      this.E = "none";
    do
    {
      return;
      if ((paramString.equals("gsm")) || (paramString.equals("gprs")) || (paramString.equals("edge")))
      {
        this.E = "2g";
        return;
      }
      if ((!paramString.startsWith("cdma")) && (!paramString.equals("umts")) && (!paramString.equals("1xrtt")) && (!paramString.equals("ehrpd")) && (!paramString.equals("evdo0")) && (!paramString.equals("evdoa")) && (!paramString.equals("evdob")) && (!paramString.equals("hsupa")) && (!paramString.equals("hsdpa")) && (!paramString.equals("hspa")))
        continue;
      this.E = "3g";
      return;
    }
    while ((!paramString.equals("lte")) && (!paramString.equals("umb")) && (!paramString.equals("hspa+")));
    this.E = "4g";
  }

  public static final boolean a(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isConnected();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static HttpHost b(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && ("wifi".equals(localNetworkInfo.getTypeName().toLowerCase())));
    for (String str1 = "wifi"; ; str1 = "")
    {
      if (!TextUtils.equals(str1, "wifi"))
        return null;
      String str3;
      int i2;
      if (Build.VERSION.SDK_INT < 11)
      {
        str3 = Proxy.getDefaultHost();
        i2 = Proxy.getDefaultPort();
        if (str3 == null)
          break label132;
      }
      label132: for (HttpHost localHttpHost2 = new HttpHost(str3, i2); ; localHttpHost2 = null)
        while (true)
        {
          return localHttpHost2;
          try
          {
            int i1 = Integer.parseInt(System.getProperty("http.proxyPort"));
            String str2 = System.getProperty("http.proxyHost");
            if (co.a(str2))
              break;
            HttpHost localHttpHost1 = new HttpHost(str2, i1);
            return localHttpHost1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            return null;
          }
        }
    }
  }

  private final void c(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        if ("wifi".equals(localNetworkInfo.getTypeName().toLowerCase()))
        {
          this.E = "wifi";
          this.D = false;
          return;
        }
        a(paramContext, localNetworkInfo);
        a(localNetworkInfo.getSubtypeName().toLowerCase());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final boolean a()
  {
    return this.D;
  }

  public final String b()
  {
    return this.C;
  }

  public final String c()
  {
    return this.E;
  }

  public final String d()
  {
    return this.A;
  }

  public final int e()
  {
    return this.B;
  }

  public final String f()
  {
    if (!TextUtils.isEmpty(this.F))
    {
      if ((this.F.startsWith("46000")) || (this.F.startsWith("46002")))
        return "cm";
      if (this.F.startsWith("46001"))
        return "cu";
      if (this.F.startsWith("46003"))
        return "ct";
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bk
 * JD-Core Version:    0.6.0
 */