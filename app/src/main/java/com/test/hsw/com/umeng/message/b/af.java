package com.umeng.message.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.android.a;

public final class af
{
  public static final String A = "app_device_token_temp";
  public static final String B = "app_key_temp";
  public static final String C = "app_sercet_temp";
  public static final String D = "app_tt_id_temp";
  private static final String E = "AppStore";
  private static final String F = "app_device_token";
  private static final String G = "app_version";
  private static final String H = "app_disable_version";
  private static final String I = "agoo_mode";
  private static final String J = "agoo_start_time";
  private static final String K = "agoo_end_time";
  private static final int L = 0;
  private static final String M = "backoff_count";
  private static final String N = "app_disable";
  private static final String O = "app_election_source";
  private static final String P = "app_sudo_pack_timeout";
  private static final String Q = "app_agoo_multiplex";
  private static final String R = "app_agoo_command_uptime_time";
  private static final String S = "app_last_register_time ";
  private static final String T = "app_retry_register";
  private static final String U = "Settings";

  @Deprecated
  private static final String V = "42.120.111.1";
  private static final String W = "42.120.80.36";
  private static final String X = "100.67.1.238";
  private static final String Y = "http://api.m.taobao.com/rest/api3.do";
  private static final String Z = "https://utop.umengcloud.com/rest/api3.do";
  public static final int a = 300000;
  private static final String aa = "http://api.wapa.taobao.com/rest/api3.do";
  private static final String ab = "http://api.waptest.taobao.com/rest/api3.do";
  private static final String ac = "http://apoll.m.taobao.com";
  private static final String ad = "http://upoll.umengcloud.com";
  private static final String ae = "http://apoll.m.taobao.com";
  private static final String af = "http://apoll.m.taobao.com";
  private static final long ag = 20151015L;
  public static final int b = 120;
  public static final int c = 1320;
  public static final int d = 1800000;
  public static final long e = 10000L;
  public static final long f = 600000L;
  public static final long g = 60000L;
  public static final long h = 300000L;
  public static final long i = 20000L;
  public static final long j = 120000L;
  public static final long k = 20000L;
  public static final long l = 60000L;
  public static final long m = 30000L;
  public static final long n = 2000L;
  public static final long o = 2000L;
  public static final long p = 1000L;
  public static final long q = 2000L;
  public static final long r = 10000L;
  public static final long s = 2000L;
  public static final long t = 2000L;
  public static final long u = 1800000L;
  public static final long v = 600000L;
  public static final long w = 15000L;
  public static final long x = 5000L;
  public static final long y = 5000L;
  public static final long z = 40000L;

  // ERROR //
  public static final boolean A(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 166	com/umeng/message/b/af:b	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: astore_2
    //   5: aload_2
    //   6: ldc 55
    //   8: iconst_1
    //   9: invokeinterface 172 3 0
    //   14: istore_3
    //   15: aload_2
    //   16: ldc 58
    //   18: ldc2_w 173
    //   21: invokeinterface 178 4 0
    //   26: lstore 5
    //   28: aload_2
    //   29: ldc 29
    //   31: ldc 179
    //   33: invokeinterface 183 3 0
    //   38: istore 7
    //   40: aload_0
    //   41: invokestatic 188	org/android/a:p	(Landroid/content/Context;)I
    //   44: istore 8
    //   46: iload 7
    //   48: ldc 179
    //   50: if_icmpeq +20 -> 70
    //   53: iload 7
    //   55: iload 8
    //   57: if_icmpeq +13 -> 70
    //   60: aload_0
    //   61: iconst_1
    //   62: ldc2_w 173
    //   65: invokestatic 191	com/umeng/message/b/af:a	(Landroid/content/Context;ZJ)V
    //   68: iconst_1
    //   69: ireturn
    //   70: lload 5
    //   72: ldc2_w 173
    //   75: lcmp
    //   76: ifeq +16 -> 92
    //   79: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   82: lstore 9
    //   84: lload 5
    //   86: lload 9
    //   88: lcmp
    //   89: ifgt +10 -> 99
    //   92: iconst_1
    //   93: ireturn
    //   94: astore_1
    //   95: iconst_1
    //   96: ireturn
    //   97: astore 4
    //   99: iload_3
    //   100: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	15	94	java/lang/Throwable
    //   15	46	97	java/lang/Throwable
    //   60	68	97	java/lang/Throwable
    //   79	84	97	java/lang/Throwable
  }

  public static final String B(Context paramContext)
  {
    return a.i(paramContext);
  }

  public static final void C(Context paramContext)
  {
    a.j(paramContext);
  }

  public static final long D(Context paramContext)
  {
    try
    {
      SharedPreferences localSharedPreferences = b(paramContext);
      int i1 = localSharedPreferences.getInt("agoo_start_time", -1);
      int i2 = localSharedPreferences.getInt("agoo_end_time", -1);
      if ((i1 != -1) && (i2 != -1))
      {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(System.currentTimeMillis());
        int i3 = localCalendar.get(11);
        int i4 = localCalendar.get(12);
        int i5 = localCalendar.get(13) + (60 * (i3 * 60) + i4 * 60);
        if (i5 < i1)
          localCalendar.add(13, i1 - i5);
        while (true)
        {
          return localCalendar.getTimeInMillis();
          if (i5 <= i2)
            break;
          localCalendar.add(13, 86400 + (i1 - i5));
        }
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return -1L;
  }

  public static final boolean E(Context paramContext)
  {
    return a.n(paramContext);
  }

  public static final boolean F(Context paramContext)
  {
    try
    {
      int i1 = b(paramContext).getInt("agoo_mode", a.d.a());
      int i2 = a.d.a();
      int i3 = 0;
      if (i1 != i2)
      {
        int i4 = a.e.a();
        i3 = 0;
        if (i1 != i4)
          i3 = 1;
      }
      return i3;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static final String G(Context paramContext)
  {
    return H(paramContext).e();
  }

  public static final a H(Context paramContext)
  {
    try
    {
      switch (b(paramContext).getInt("agoo_mode", a.e.a()))
      {
      case 1:
      default:
        return a.e;
      case -2:
        return a.a;
      case -1:
        return a.b;
      case 0:
        return a.c;
      case 2:
      }
      a locala = a.d;
      return locala;
    }
    catch (Throwable localThrowable)
    {
    }
    return a.e;
  }

  public static final long a()
  {
    return 20151015L;
  }

  private static final String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong));
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "none";
  }

  public static final String a(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public static final void a(Context paramContext, int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = b(paramContext).edit();
      localEditor.putInt("backoff_count", paramInt);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("Settings", "setBackOffCount", localThrowable);
    }
  }

  public static final void a(Context paramContext, long paramLong, String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = b(paramContext).edit();
      localEditor.putLong("app_sudo_pack_timeout", paramLong);
      localEditor.putString("app_election_source", paramString);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Context paramContext, String paramString)
  {
    a.a(paramContext, paramString);
  }

  public static final void a(Context paramContext, boolean paramBoolean, long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = b(paramContext).edit();
      localEditor.putBoolean("app_agoo_multiplex", paramBoolean);
      localEditor.putLong("app_agoo_command_uptime_time", paramLong);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext != null);
    try
    {
      a.a(paramContext, paramBoolean1, paramBoolean2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  // ERROR //
  public static final boolean a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 166	com/umeng/message/b/af:b	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: astore_3
    //   5: aload_3
    //   6: ldc 46
    //   8: iconst_0
    //   9: invokeinterface 172 3 0
    //   14: istore 4
    //   16: iload_1
    //   17: ifne +6 -> 23
    //   20: iload 4
    //   22: ireturn
    //   23: aload_3
    //   24: ldc 29
    //   26: ldc 179
    //   28: invokeinterface 183 3 0
    //   33: istore 6
    //   35: aload_0
    //   36: invokestatic 188	org/android/a:p	(Landroid/content/Context;)I
    //   39: istore 7
    //   41: iload 6
    //   43: ldc 179
    //   45: if_icmpeq -25 -> 20
    //   48: iload 6
    //   50: iload 7
    //   52: if_icmpeq -32 -> 20
    //   55: aload_0
    //   56: invokestatic 336	com/umeng/message/b/af:y	(Landroid/content/Context;)V
    //   59: aload_0
    //   60: invokestatic 338	com/umeng/message/b/af:e	(Landroid/content/Context;)V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_2
    //   66: iconst_0
    //   67: ireturn
    //   68: astore 5
    //   70: iload 4
    //   72: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	16	65	java/lang/Throwable
    //   23	41	68	java/lang/Throwable
    //   55	63	68	java/lang/Throwable
  }

  public static final SharedPreferences b(Context paramContext)
  {
    try
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("AppStore", 4);
      return localSharedPreferences;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final void b(Context paramContext, String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = b(paramContext);
      int i1 = a.p(paramContext);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putString("app_device_token", paramString);
      localEditor.putString("app_device_token_temp", paramString);
      localEditor.putInt("app_version", i1);
      localEditor.putLong("app_last_register_time ", System.currentTimeMillis());
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void c(Context paramContext)
  {
    a.a(paramContext);
  }

  public static void c(Context paramContext, String paramString)
  {
    a.b(paramContext, paramString);
  }

  public static final String d(Context paramContext)
  {
    return a.b(paramContext);
  }

  public static final void d(Context paramContext, String paramString)
  {
    if (paramContext != null);
    try
    {
      a.c(paramContext, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void e(Context paramContext)
  {
    a.h(paramContext);
  }

  public static void e(Context paramContext, String paramString)
  {
    if (paramContext != null);
    try
    {
      a.d(paramContext, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final String f(Context paramContext)
  {
    return a.d(paramContext);
  }

  public static final String g(Context paramContext)
  {
    try
    {
      String str = b(paramContext).getString("app_key_temp", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "";
  }

  public static final String h(Context paramContext)
  {
    return a.e(paramContext);
  }

  public static final String i(Context paramContext)
  {
    try
    {
      String str = b(paramContext).getString("app_tt_id_temp", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "";
  }

  public static final String j(Context paramContext)
  {
    return a.f(paramContext);
  }

  public static final String k(Context paramContext)
  {
    try
    {
      String str = b(paramContext).getString("app_sercet_temp", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "";
  }

  public static final String l(Context paramContext)
  {
    return n(paramContext);
  }

  public static final boolean m(Context paramContext)
  {
    return !TextUtils.isEmpty(n(paramContext));
  }

  public static final String n(Context paramContext)
  {
    return a.g(paramContext);
  }

  public static String o(Context paramContext)
  {
    try
    {
      String str = b(paramContext).getString("app_device_token_temp", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final String p(Context paramContext)
  {
    try
    {
      String str = b(paramContext).getString("app_election_source", "local");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "local";
  }

  public static final long q(Context paramContext)
  {
    try
    {
      long l1 = b(paramContext).getLong("app_sudo_pack_timeout", -1L);
      return l1;
    }
    catch (Throwable localThrowable)
    {
    }
    return -1L;
  }

  public static final int r(Context paramContext)
  {
    try
    {
      int i1 = b(paramContext).getInt("backoff_count", 0);
      return i1;
    }
    catch (Throwable localThrowable)
    {
      Log.w("Settings", "getBackoffCount", localThrowable);
    }
    return 0;
  }

  public static final void s(Context paramContext)
  {
    a(paramContext, 0);
  }

  public static final void t(Context paramContext)
  {
    try
    {
      SharedPreferences localSharedPreferences = b(paramContext);
      int i1 = 1 + localSharedPreferences.getInt("app_retry_register", 0);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putInt("app_retry_register", i1);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("Settings", "setRetryRegisterCount", localThrowable);
    }
  }

  public static final int u(Context paramContext)
  {
    try
    {
      int i1 = b(paramContext).getInt("app_retry_register", 0);
      return i1;
    }
    catch (Throwable localThrowable)
    {
      Log.w("Settings", "getRetryRegisterCount", localThrowable);
    }
    return 0;
  }

  public static final void v(Context paramContext)
  {
    try
    {
      SharedPreferences.Editor localEditor = b(paramContext).edit();
      localEditor.putInt("app_retry_register", 0);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("Settings", "RestRetryRegisterCount", localThrowable);
    }
  }

  public static final boolean w(Context paramContext)
  {
    int i1 = 1;
    String str1 = "";
    try
    {
      long l1 = b(paramContext).getLong("app_last_register_time ", -1L);
      if (l1 != -1L)
        str1 = a(l1);
      String str2 = a(System.currentTimeMillis());
      if (l1 != -1L)
      {
        boolean bool = str2.equals(str1);
        if (bool)
          i1 = 0;
      }
      return i1;
    }
    catch (Throwable localThrowable)
    {
    }
    return i1;
  }

  public static final void x(Context paramContext)
  {
    try
    {
      SharedPreferences.Editor localEditor = b(paramContext).edit();
      localEditor.putBoolean("app_disable", true);
      localEditor.putInt("app_disable_version", a.p(paramContext));
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void y(Context paramContext)
  {
    try
    {
      SharedPreferences.Editor localEditor = b(paramContext).edit();
      localEditor.putBoolean("app_disable", false);
      localEditor.putInt("app_disable_version", a.p(paramContext));
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final boolean z(Context paramContext)
  {
    return a(paramContext, false);
  }

  public static abstract enum a
  {
    private int f;

    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      g = arrayOfa;
    }

    private a(int paramInt)
    {
      this.f = paramInt;
    }

    public final int a()
    {
      return this.f;
    }

    public abstract int b();

    public abstract String c();

    public abstract String d();

    public abstract String e();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.af
 * JD-Core Version:    0.6.0
 */