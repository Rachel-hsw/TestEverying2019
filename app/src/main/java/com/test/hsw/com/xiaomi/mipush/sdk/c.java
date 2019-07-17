package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xiaomi.a.a.c.a;
import com.xiaomi.push.a.e;
import com.xiaomi.push.a.f;

public class c
{
  private static boolean a = false;
  private static a b = null;

  public static void a(Context paramContext)
  {
    a = true;
    c(paramContext);
  }

  public static void a(Context paramContext, a parama)
  {
    b = parama;
    c(paramContext);
  }

  public static void b(Context paramContext)
  {
    a = false;
    c(paramContext);
  }

  private static void c(Context paramContext)
  {
    if (b != null);
    f localf;
    for (int i = 1; ; i = 0)
    {
      localf = new f(paramContext);
      if ((a) || (!d(paramContext)) || (i == 0))
        break;
      com.xiaomi.a.a.c.c.a(new e(b, localf));
      return;
    }
    if ((!a) && (d(paramContext)))
    {
      com.xiaomi.a.a.c.c.a(localf);
      return;
    }
    if (i != 0)
    {
      com.xiaomi.a.a.c.c.a(b);
      return;
    }
    com.xiaomi.a.a.c.c.a(new e(null, null));
  }

  private static boolean d(Context paramContext)
  {
    try
    {
      String[] arrayOfString = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
      int i = 0;
      int j;
      if (arrayOfString != null)
        j = arrayOfString.length;
      for (int k = 0; ; k++)
      {
        i = 0;
        if (k < j)
        {
          boolean bool = "android.permission.WRITE_EXTERNAL_STORAGE".equals(arrayOfString[k]);
          if (!bool)
            continue;
          i = 1;
        }
        return i;
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.c
 * JD-Core Version:    0.6.0
 */