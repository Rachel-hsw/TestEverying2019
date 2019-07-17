package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.f.a.b;
import com.xiaomi.f.a.c;
import com.xiaomi.f.a.n;
import java.util.List;

public class g
{
  public static final String a = "message_type";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final String f = "key_message";
  public static final String g = "key_command";
  public static final int h = 1;
  public static final int i = 2;
  private static int j = 0;

  public static int a(Context paramContext)
  {
    if (j == 0)
    {
      if (!b(paramContext))
        break label21;
      a(1);
    }
    while (true)
    {
      return j;
      label21: a(2);
    }
  }

  public static e a(String paramString1, List<String> paramList, long paramLong, String paramString2, String paramString3)
  {
    e locale = new e();
    locale.a(paramString1);
    locale.a(paramList);
    locale.a(paramLong);
    locale.b(paramString2);
    locale.c(paramString3);
    return locale;
  }

  public static f a(n paramn, c paramc, boolean paramBoolean)
  {
    f localf = new f();
    localf.a(paramn.c());
    if (!TextUtils.isEmpty(paramn.j()))
    {
      localf.a(1);
      localf.c(paramn.j());
    }
    while (true)
    {
      localf.h(paramn.p());
      if (paramn.l() != null)
        localf.b(paramn.l().f());
      if (paramc != null)
      {
        if (TextUtils.isEmpty(localf.a()))
          localf.a(paramc.b());
        if (TextUtils.isEmpty(localf.g()))
          localf.e(paramc.f());
        localf.f(paramc.j());
        localf.g(paramc.h());
        localf.b(paramc.l());
        localf.c(paramc.q());
        localf.d(paramc.o());
        localf.a(paramc.s());
      }
      localf.b(paramBoolean);
      return localf;
      if (!TextUtils.isEmpty(paramn.h()))
      {
        localf.a(2);
        localf.e(paramn.h());
        continue;
      }
      if (!TextUtils.isEmpty(paramn.r()))
      {
        localf.a(3);
        localf.d(paramn.r());
        continue;
      }
      localf.a(0);
    }
  }

  private static void a(int paramInt)
  {
    j = paramInt;
  }

  public static void a(Context paramContext, e parame)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("message_type", 3);
    localIntent.putExtra("key_command", parame);
    new PushServiceReceiver().onReceive(paramContext, localIntent);
  }

  private static boolean a(Context paramContext, Intent paramIntent)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      List localList = localPackageManager.queryBroadcastReceivers(paramIntent, 32);
      if (localList != null)
      {
        boolean bool = localList.isEmpty();
        if (!bool)
          return true;
      }
      return false;
    }
    catch (Exception localException)
    {
    }
    return true;
  }

  public static boolean b(Context paramContext)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setClassName(paramContext.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
    return a(paramContext, localIntent);
  }

  public static void c(Context paramContext)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("message_type", 4);
    new PushServiceReceiver().onReceive(paramContext, localIntent);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.g
 * JD-Core Version:    0.6.0
 */