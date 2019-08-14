package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.xiaomi.d.e.k;
import com.xiaomi.f.a.e;
import com.xiaomi.f.a.h;
import com.xiaomi.f.a.u;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.a.c.f;
import org.json.JSONException;

public class ac
{
  private static void a(XMPushService paramXMPushService, h paramh, String paramString)
  {
    paramXMPushService.a(new ah(4, paramXMPushService, paramh, paramString));
  }

  private static void a(XMPushService paramXMPushService, h paramh, String paramString1, String paramString2)
  {
    paramXMPushService.a(new ai(4, paramXMPushService, paramh, paramString1, paramString2));
  }

  private static void a(XMPushService paramXMPushService, byte[] paramArrayOfByte, long paramLong)
  {
    Long localLong = Long.valueOf(System.currentTimeMillis());
    h localh = new h();
    Intent localIntent1;
    String str1;
    com.xiaomi.f.a.c localc;
    try
    {
      u.a(localh, paramArrayOfByte);
      if (TextUtils.isEmpty(localh.f))
        break label857;
      localIntent1 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
      localIntent1.putExtra("mipush_payload", paramArrayOfByte);
      localIntent1.putExtra("mrt", Long.toString(localLong.longValue()));
      localIntent1.setPackage(localh.f);
      str1 = aj.a(localh);
      k.a(paramXMPushService, str1, paramLong, true, System.currentTimeMillis());
      localc = localh.m();
      if (localc != null)
        localc.a("mrt", Long.toString(localLong.longValue()));
      if ((com.xiaomi.f.a.a.e == localh.a()) && (z.a(paramXMPushService).a(localh.f)) && (!aj.b(localh)))
      {
        String str4 = "";
        if (localc != null)
          str4 = localc.b();
        com.xiaomi.a.a.c.c.a("Drop a message for unregistered, msgid=" + str4);
        a(paramXMPushService, localh, localh.f);
        return;
      }
      if ((com.xiaomi.f.a.a.e == localh.a()) && (!TextUtils.equals(paramXMPushService.getPackageName(), "com.xiaomi.xmsf")) && (!TextUtils.equals(paramXMPushService.getPackageName(), localh.f)))
      {
        com.xiaomi.a.a.c.c.a("Receive a message with wrong package name, expect " + paramXMPushService.getPackageName() + ", received " + localh.f);
        a(paramXMPushService, localh, "unmatched_package", "package should be " + paramXMPushService.getPackageName() + ", but got " + localh.f);
        return;
      }
    }
    catch (f localf)
    {
      com.xiaomi.a.a.c.c.a(localf);
      return;
    }
    if ((localc != null) && (localc.b() != null))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localh.h();
      arrayOfObject[1] = localc.b();
      com.xiaomi.a.a.c.c.a(String.format("receive a message, appid=%1$s, msgid= %2$s", arrayOfObject));
    }
    if ((c(localh)) && (a(paramXMPushService, str1)))
    {
      c(paramXMPushService, localh);
      return;
    }
    if ((a(localh)) && (!a(paramXMPushService, str1)) && (!b(localh)))
    {
      d(paramXMPushService, localh);
      return;
    }
    String str2;
    if (((aj.b(localh)) && (b(paramXMPushService, localh.f))) || (a(paramXMPushService, localIntent1)))
    {
      if (com.xiaomi.f.a.a.a == localh.a())
      {
        String str3 = localh.j();
        SharedPreferences.Editor localEditor = paramXMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
        localEditor.putString(str3, localh.e);
        localEditor.commit();
      }
      if ((localc == null) || (TextUtils.isEmpty(localc.h())) || (TextUtils.isEmpty(localc.j())) || (localc.h == 1) || ((!aj.a(localc.s())) && (aj.a(paramXMPushService, localh.f))))
      {
        paramXMPushService.sendBroadcast(localIntent1, s.a(localh.f));
        if ((localh.a() != com.xiaomi.f.a.a.b) || ("com.xiaomi.xmsf".equals(paramXMPushService.getPackageName())))
          return;
        paramXMPushService.stopSelf();
        return;
      }
      if (localc == null)
        break label864;
      Map localMap = localc.j;
      str2 = null;
      if (localMap != null)
        str2 = (String)localc.j.get("jobkey");
      if (TextUtils.isEmpty(str2))
        str2 = localc.b();
    }
    for (boolean bool = ak.a(paramXMPushService, localh.f, str2); ; bool = false)
    {
      if (bool)
        com.xiaomi.a.a.c.c.a("drop a duplicate message, key=" + str2);
      while (true)
      {
        b(paramXMPushService, localh);
        break;
        aj.a(paramXMPushService, localh, paramArrayOfByte);
        if (aj.b(localh))
          continue;
        Intent localIntent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        localIntent2.putExtra("mipush_payload", paramArrayOfByte);
        localIntent2.setPackage(localh.f);
        try
        {
          List localList = paramXMPushService.getPackageManager().queryBroadcastReceivers(localIntent2, 0);
          if ((localList == null) || (localList.isEmpty()))
            continue;
          paramXMPushService.sendBroadcast(localIntent2, s.a(localh.f));
        }
        catch (Exception localException)
        {
          paramXMPushService.sendBroadcast(localIntent2, s.a(localh.f));
        }
      }
      paramXMPushService.a(new ad(4, paramXMPushService, localh));
      return;
      label857: com.xiaomi.a.a.c.c.a("receive a mipush message without package name");
      return;
      label864: str2 = null;
    }
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

  private static boolean a(Context paramContext, String paramString)
  {
    Intent localIntent1 = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
    localIntent1.setPackage(paramString);
    Intent localIntent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
    localIntent2.setPackage(paramString);
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      List localList1 = localPackageManager.queryBroadcastReceivers(localIntent2, 32);
      List localList2 = localPackageManager.queryIntentServices(localIntent1, 32);
      int i;
      if (localList1.isEmpty())
      {
        boolean bool = localList2.isEmpty();
        i = 0;
        if (bool);
      }
      else
      {
        i = 1;
      }
      return i;
    }
    catch (Exception localException)
    {
      com.xiaomi.a.a.c.c.a(localException);
    }
    return false;
  }

  private static boolean a(h paramh)
  {
    return ("com.xiaomi.xmsf".equals(paramh.f)) && (paramh.m() != null) && (paramh.m().s() != null) && (paramh.m().s().containsKey("miui_package_name"));
  }

  private static void b(XMPushService paramXMPushService, h paramh)
  {
    paramXMPushService.a(new ae(4, paramXMPushService, paramh));
  }

  private static boolean b(Context paramContext, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo2 = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      localPackageInfo1 = localPackageInfo2;
      if (localPackageInfo1 == null)
        return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        PackageInfo localPackageInfo1 = null;
    }
    return true;
  }

  private static boolean b(h paramh)
  {
    return paramh.m().s().containsKey("notify_effect");
  }

  private static void c(XMPushService paramXMPushService, h paramh)
  {
    paramXMPushService.a(new af(4, paramXMPushService, paramh));
  }

  private static boolean c(h paramh)
  {
    if ((paramh.m() == null) || (paramh.m().s() == null))
      return false;
    return "1".equals(paramh.m().s().get("obslete_ads_message"));
  }

  private static void d(XMPushService paramXMPushService, h paramh)
  {
    paramXMPushService.a(new ag(4, paramXMPushService, paramh));
  }

  private static h e(XMPushService paramXMPushService, h paramh)
  {
    e locale = new e();
    locale.b(paramh.h());
    com.xiaomi.f.a.c localc1 = paramh.m();
    if (localc1 != null)
    {
      locale.a(localc1.b());
      locale.a(localc1.d());
      if (!TextUtils.isEmpty(localc1.f()))
        locale.c(localc1.f());
    }
    h localh = paramXMPushService.a(paramh.j(), paramh.h(), locale, com.xiaomi.f.a.a.f);
    com.xiaomi.f.a.c localc2 = paramh.m().a();
    localc2.a("mat", Long.toString(System.currentTimeMillis()));
    localh.a(localc2);
    return localh;
  }

  public void a(Context paramContext, an.b paramb, boolean paramBoolean, int paramInt, String paramString)
  {
    x localx;
    if (!paramBoolean)
    {
      localx = y.a(paramContext);
      if ((localx == null) || (!"token-expired".equals(paramString)));
    }
    try
    {
      y.a(paramContext, localx.d, localx.e, localx.f);
      return;
    }
    catch (IOException localIOException)
    {
      com.xiaomi.a.a.c.c.a(localIOException);
      return;
    }
    catch (JSONException localJSONException)
    {
      com.xiaomi.a.a.c.c.a(localJSONException);
    }
  }

  public void a(XMPushService paramXMPushService, com.xiaomi.d.c.d paramd, an.b paramb)
  {
    if ((paramd instanceof com.xiaomi.d.c.c))
    {
      com.xiaomi.d.c.c localc = (com.xiaomi.d.c.c)paramd;
      com.xiaomi.d.c.a locala = localc.p("s");
      if (locala != null);
      try
      {
        a(paramXMPushService, d.b(d.a(paramb.i, localc.k()), locala.c()), k.a(paramd.a()));
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        com.xiaomi.a.a.c.c.a(localIllegalArgumentException);
        return;
      }
    }
    com.xiaomi.a.a.c.c.a("not a mipush message");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.ac
 * JD-Core Version:    0.6.0
 */