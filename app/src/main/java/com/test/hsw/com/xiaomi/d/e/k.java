package com.xiaomi.d.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.xiaomi.a.a.c.c;
import com.xiaomi.a.a.d.b;
import com.xiaomi.push.c.a;
import com.xiaomi.push.service.XMPushService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class k
{
  private static b a = new b(true);
  private static int b = -1;
  private static final Object c = new Object();
  private static List<a> d = Collections.synchronizedList(new ArrayList());
  private static String e = "";
  private static a f = null;

  private static int a(Context paramContext)
  {
    if (b == -1)
      b = b(paramContext);
    return b;
  }

  public static int a(String paramString)
  {
    try
    {
      int i = paramString.getBytes("UTF-8").length;
      return i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return paramString.getBytes().length;
  }

  private static long a(int paramInt, long paramLong)
  {
    if (paramInt == 0);
    for (int i = 13; ; i = 11)
      return paramLong * i / 10L;
  }

  private static void a(a parama)
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (!locala.a(parama))
        continue;
      locala.f += parama.f;
      return;
    }
    d.add(parama);
  }

  public static void a(XMPushService paramXMPushService, String paramString, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if ((paramXMPushService == null) || (TextUtils.isEmpty(paramString)) || (!"com.xiaomi.xmsf".equals(paramXMPushService.getPackageName())) || ("com.xiaomi.xmsf".equals(paramString)));
    while (true)
    {
      return;
      int i = a(paramXMPushService);
      if (-1 == i)
        continue;
      synchronized (c)
      {
        boolean bool = d.isEmpty();
        if (paramBoolean);
        for (int j = 1; ; j = 0)
        {
          if (i != 0)
            break label139;
          str = c(paramXMPushService);
          a(new a(paramString, paramLong2, i, j, str, a(i, paramLong1)));
          if (!bool)
            break;
          a.a(new l(paramXMPushService), 5000L);
          return;
        }
        label139: String str = "";
      }
    }
  }

  private static int b(Context paramContext)
  {
    ConnectivityManager localConnectivityManager;
    try
    {
      localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
        return -1;
    }
    catch (Exception localException1)
    {
      return -1;
    }
    NetworkInfo localNetworkInfo;
    try
    {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null)
        return -1;
    }
    catch (Exception localException2)
    {
      return -1;
    }
    return localNetworkInfo.getType();
  }

  private static void b(Context paramContext, List<a> paramList)
  {
    SQLiteDatabase localSQLiteDatabase;
    try
    {
      synchronized (a.a)
      {
        localSQLiteDatabase = d(paramContext).getWritableDatabase();
        localSQLiteDatabase.beginTransaction();
        try
        {
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("package_name", locala.a);
            localContentValues.put("message_ts", Long.valueOf(locala.b));
            localContentValues.put("network_type", Integer.valueOf(locala.c));
            localContentValues.put("bytes", Long.valueOf(locala.f));
            localContentValues.put("rcv", Integer.valueOf(locala.d));
            localContentValues.put("imsi", locala.e);
            localSQLiteDatabase.insert("traffic", null, localContentValues);
          }
        }
        finally
        {
          localSQLiteDatabase.endTransaction();
        }
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      c.a(localSQLiteException);
      return;
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
    monitorexit;
  }

  // ERROR //
  private static String c(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 48	com/xiaomi/d/e/k:e	Ljava/lang/String;
    //   6: invokestatic 109	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +12 -> 21
    //   12: getstatic 48	com/xiaomi/d/e/k:e	Ljava/lang/String;
    //   15: astore_3
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_3
    //   20: areturn
    //   21: aload_0
    //   22: ldc 249
    //   24: invokevirtual 154	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   27: checkcast 251	android/telephony/TelephonyManager
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +11 -> 45
    //   37: aload 4
    //   39: invokevirtual 254	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   42: putstatic 48	com/xiaomi/d/e/k:e	Ljava/lang/String;
    //   45: getstatic 48	com/xiaomi/d/e/k:e	Ljava/lang/String;
    //   48: astore_3
    //   49: goto -33 -> 16
    //   52: astore_1
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_2
    //   59: goto -14 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   3	16	52	finally
    //   21	32	52	finally
    //   37	45	52	finally
    //   45	49	52	finally
    //   21	32	58	java/lang/Exception
    //   37	45	58	java/lang/Exception
  }

  private static a d(Context paramContext)
  {
    if (f != null)
      return f;
    f = new a(paramContext);
    return f;
  }

  static class a
  {
    public String a = "";
    public long b = 0L;
    public int c = -1;
    public int d = -1;
    public String e = "";
    public long f = 0L;

    public a(String paramString1, long paramLong1, int paramInt1, int paramInt2, String paramString2, long paramLong2)
    {
      this.a = paramString1;
      this.b = paramLong1;
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramString2;
      this.f = paramLong2;
    }

    public boolean a(a parama)
    {
      return (TextUtils.equals(parama.a, this.a)) && (TextUtils.equals(parama.e, this.e)) && (parama.c == this.c) && (parama.d == this.d) && (Math.abs(parama.b - this.b) <= 5000L);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.e.k
 * JD-Core Version:    0.6.0
 */