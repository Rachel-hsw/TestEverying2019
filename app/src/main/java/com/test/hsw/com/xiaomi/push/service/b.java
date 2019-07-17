package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;

public class b
{
  private static b a;
  private Context b;
  private int c = 0;

  private b(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }

  public static b a(Context paramContext)
  {
    if (a == null)
      a = new b(paramContext);
    return a;
  }

  public boolean a()
  {
    return ("@SHIP.TO.2A2FE0D7@".contains("xmsf")) || ("@SHIP.TO.2A2FE0D7@".contains("xiaomi")) || ("@SHIP.TO.2A2FE0D7@".contains("miui"));
  }

  @SuppressLint({"NewApi"})
  public int b()
  {
    if (this.c != 0)
      return this.c;
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.c = Settings.Global.getInt(this.b.getContentResolver(), "device_provisioned", 0);
      return this.c;
    }
    this.c = Settings.Secure.getInt(this.b.getContentResolver(), "device_provisioned", 0);
    return this.c;
  }

  @SuppressLint({"NewApi"})
  public Uri c()
  {
    if (Build.VERSION.SDK_INT >= 17)
      return Settings.Global.getUriFor("device_provisioned");
    return Settings.Secure.getUriFor("device_provisioned");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.b
 * JD-Core Version:    0.6.0
 */