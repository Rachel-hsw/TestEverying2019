package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.a.a.e.d;
import com.xiaomi.f.a.a;
import com.xiaomi.f.a.j;
import com.xiaomi.f.a.q;
import com.xiaomi.f.a.u;
import com.xiaomi.push.service.ap;
import java.util.ArrayList;
import java.util.Iterator;

public class n
{
  private static n b;
  private static final ArrayList<a> e = new ArrayList();
  private boolean a = false;
  private Context c;
  private String d;
  private Intent f = null;
  private Integer g = null;

  private n(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.d = null;
    this.a = g();
  }

  public static n a(Context paramContext)
  {
    if (b == null)
      b = new n(paramContext);
    return b;
  }

  private boolean g()
  {
    PackageManager localPackageManager = this.c.getPackageManager();
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.xiaomi.xmsf", 4);
      if (localPackageInfo == null)
        return false;
      int i = localPackageInfo.versionCode;
      if (i >= 105)
        return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private Intent h()
  {
    Intent localIntent = new Intent();
    String str = this.c.getPackageName();
    if ((b()) && (!"com.xiaomi.xmsf".equals(str)))
    {
      localIntent.setPackage("com.xiaomi.xmsf");
      localIntent.setClassName("com.xiaomi.xmsf", i());
      localIntent.putExtra("mipush_app_package", str);
      j();
      return localIntent;
    }
    k();
    localIntent.setComponent(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"));
    localIntent.putExtra("mipush_app_package", str);
    return localIntent;
  }

  private String i()
  {
    try
    {
      if (this.c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106)
        return "com.xiaomi.push.service.XMPushService";
    }
    catch (Exception localException)
    {
    }
    return "com.xiaomi.xmsf.push.service.XMPushService";
  }

  private void j()
  {
    try
    {
      this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 2, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void k()
  {
    try
    {
      this.c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.c, "com.xiaomi.push.service.XMPushService"), 1, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private boolean l()
  {
    String str = this.c.getPackageName();
    if ((str.contains("miui")) || (str.contains("xiaomi")));
    do
      return true;
    while ((0x1 & this.c.getApplicationInfo().flags) != 0);
    return false;
  }

  public void a()
  {
    this.c.startService(h());
  }

  public void a(int paramInt)
  {
    Intent localIntent = h();
    localIntent.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
    localIntent.putExtra(ap.y, this.c.getPackageName());
    localIntent.putExtra(ap.z, paramInt);
    this.c.startService(localIntent);
  }

  public final void a(j paramj, boolean paramBoolean)
  {
    this.f = null;
    Intent localIntent = h();
    byte[] arrayOfByte = u.a(l.a(this.c, paramj, a.a));
    if (arrayOfByte == null)
    {
      com.xiaomi.a.a.c.c.a("register fail, because msgBytes is null.");
      return;
    }
    localIntent.setAction("com.xiaomi.mipush.REGISTER_APP");
    localIntent.putExtra("mipush_app_id", h.a(this.c).c());
    localIntent.putExtra("mipush_payload", arrayOfByte);
    localIntent.putExtra("mipush_session", this.d);
    localIntent.putExtra("mipush_env_chanage", paramBoolean);
    localIntent.putExtra("mipush_env_type", h.a(this.c).m());
    if ((d.d(this.c)) && (f()))
    {
      this.c.startService(localIntent);
      return;
    }
    this.f = localIntent;
  }

  public final void a(q paramq)
  {
    Intent localIntent = h();
    byte[] arrayOfByte = u.a(l.a(this.c, paramq, a.b));
    if (arrayOfByte == null)
    {
      com.xiaomi.a.a.c.c.a("unregister fail, because msgBytes is null.");
      return;
    }
    localIntent.setAction("com.xiaomi.mipush.UNREGISTER_APP");
    localIntent.putExtra("mipush_app_id", h.a(this.c).c());
    localIntent.putExtra("mipush_payload", arrayOfByte);
    this.c.startService(localIntent);
  }

  public final <T extends org.a.c.b<T, ?>> void a(T paramT, a parama, com.xiaomi.f.a.c paramc)
  {
    if (!parama.equals(a.a));
    for (boolean bool = true; ; bool = false)
    {
      a(paramT, parama, bool, paramc);
      return;
    }
  }

  public <T extends org.a.c.b<T, ?>> void a(T paramT, a parama, boolean paramBoolean)
  {
    a locala = new a();
    locala.a = paramT;
    locala.b = parama;
    locala.c = paramBoolean;
    synchronized (e)
    {
      e.add(locala);
      if (e.size() > 10)
        e.remove(0);
      return;
    }
  }

  public final <T extends org.a.c.b<T, ?>> void a(T paramT, a parama, boolean paramBoolean, com.xiaomi.f.a.c paramc)
  {
    a(paramT, parama, paramBoolean, true, paramc, true);
  }

  public final <T extends org.a.c.b<T, ?>> void a(T paramT, a parama, boolean paramBoolean1, com.xiaomi.f.a.c paramc, boolean paramBoolean2)
  {
    a(paramT, parama, paramBoolean1, true, paramc, paramBoolean2);
  }

  public final <T extends org.a.c.b<T, ?>> void a(T paramT, a parama, boolean paramBoolean1, boolean paramBoolean2, com.xiaomi.f.a.c paramc, boolean paramBoolean3)
  {
    a(paramT, parama, paramBoolean1, paramBoolean2, paramc, paramBoolean3, this.c.getPackageName(), h.a(this.c).c());
  }

  public final <T extends org.a.c.b<T, ?>> void a(T paramT, a parama, boolean paramBoolean1, boolean paramBoolean2, com.xiaomi.f.a.c paramc, boolean paramBoolean3, String paramString1, String paramString2)
  {
    if (!h.a(this.c).i())
    {
      if (paramBoolean2)
      {
        a(paramT, parama, paramBoolean1);
        return;
      }
      com.xiaomi.a.a.c.c.a("drop the message before initialization.");
      return;
    }
    Intent localIntent = h();
    com.xiaomi.f.a.h localh = l.a(this.c, paramT, parama, paramBoolean1, paramString1, paramString2);
    if (paramc != null)
      localh.a(paramc);
    byte[] arrayOfByte = u.a(localh);
    if (arrayOfByte == null)
    {
      com.xiaomi.a.a.c.c.a("send message fail, because msgBytes is null.");
      return;
    }
    localIntent.setAction("com.xiaomi.mipush.SEND_MESSAGE");
    localIntent.putExtra("mipush_payload", arrayOfByte);
    localIntent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", paramBoolean3);
    this.c.startService(localIntent);
  }

  public void b(int paramInt)
  {
    Intent localIntent = h();
    localIntent.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
    localIntent.putExtra(ap.y, this.c.getPackageName());
    localIntent.putExtra(ap.A, paramInt);
    localIntent.putExtra(ap.C, com.xiaomi.a.a.g.c.b(this.c.getPackageName() + paramInt));
    this.c.startService(localIntent);
  }

  public boolean b()
  {
    return (this.a) && (1 == h.a(this.c).m());
  }

  public void c()
  {
    if (this.f != null)
    {
      this.c.startService(this.f);
      this.f = null;
    }
  }

  public void d()
  {
    synchronized (e)
    {
      Iterator localIterator = e.iterator();
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        a(locala.a, locala.b, locala.c, false, null, true);
      }
    }
    e.clear();
    monitorexit;
  }

  public void e()
  {
    Intent localIntent = h();
    localIntent.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
    localIntent.putExtra(ap.y, this.c.getPackageName());
    localIntent.putExtra(ap.C, com.xiaomi.a.a.g.c.b(this.c.getPackageName()));
    this.c.startService(localIntent);
  }

  public boolean f()
  {
    if ((b()) && (l()))
      if (this.g == null)
      {
        this.g = Integer.valueOf(com.xiaomi.push.service.b.a(this.c).b());
        if (this.g.intValue() == 0)
        {
          o localo = new o(this, new Handler(Looper.getMainLooper()));
          this.c.getContentResolver().registerContentObserver(com.xiaomi.push.service.b.a(this.c).c(), false, localo);
        }
      }
    return this.g.intValue() != 0;
  }

  static class a<T extends org.a.c.b<T, ?>>
  {
    T a;
    a b;
    boolean c;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.n
 * JD-Core Version:    0.6.0
 */