package com.baidu.location.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.baidu.location.e.a;
import com.baidu.location.e.m;
import com.baidu.location.e.o;
import java.lang.reflect.Method;
import java.util.List;

public class e extends k
  implements com.baidu.location.b.f
{
  public static final long j9 = 3000L;
  public static final int ka = 15;
  public static long kc = 0L;
  public static final long kf = 3000L;
  public static final long kh = 5000L;
  private static e kj = null;
  private boolean kb = true;
  private f kd = null;
  private Object ke = null;
  private long kg = 0L;
  private WifiManager ki = null;
  private Method kk = null;
  private boolean kl = false;
  private long km = 0L;
  private a kn = null;

  static
  {
    kc = 0L;
  }

  private void dd()
  {
    if (this.ki == null);
    while (true)
    {
      return;
      try
      {
        List localList = this.ki.getScanResults();
        f localf = new f(localList, this.kg);
        if ((this.kd != null) && (localf.jdMethod_new(this.kd)))
          continue;
        this.kd = localf;
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  public static e de()
  {
    if (kj == null)
      kj = new e();
    return kj;
  }

  public static double jdMethod_if(f paramf1, f paramf2)
  {
    double d = 1.0D;
    if ((paramf1 == null) || (paramf2 == null))
      d = 0.0D;
    List localList1;
    List localList2;
    int i;
    int j;
    float f;
    do
    {
      do
      {
        return d;
        localList1 = paramf1.kr;
        localList2 = paramf2.kr;
      }
      while (localList1 == localList2);
      if ((localList1 == null) || (localList2 == null))
        return 0.0D;
      i = localList1.size();
      j = localList2.size();
      f = i + j;
    }
    while ((i == 0) && (j == 0));
    if ((i == 0) || (j == 0))
      return 0.0D;
    int k = 0;
    int m = 0;
    String str;
    int i1;
    if (k < i)
    {
      str = ((ScanResult)localList1.get(k)).BSSID;
      if (str == null)
        i1 = m;
    }
    while (true)
    {
      k++;
      m = i1;
      break;
      for (int n = 0; ; n++)
      {
        if (n >= j)
          break label207;
        if (!str.equals(((ScanResult)localList2.get(n)).BSSID))
          continue;
        i1 = m + 1;
        break;
      }
      if (f <= 0.0F)
        return 0.0D;
      return m / f;
      label207: i1 = m;
    }
  }

  public static boolean jdMethod_if(f paramf1, f paramf2, float paramFloat)
  {
    if ((paramf1 == null) || (paramf2 == null))
      return false;
    List localList1 = paramf1.kr;
    List localList2 = paramf2.kr;
    if (localList1 == localList2)
      return true;
    if ((localList1 == null) || (localList2 == null))
      return false;
    int i = localList1.size();
    int j = localList2.size();
    float f = i + j;
    if ((i == 0) && (j == 0))
      return true;
    if ((i == 0) || (j == 0))
      return false;
    int k = 0;
    int m = 0;
    String str;
    int i1;
    if (k < i)
    {
      str = ((ScanResult)localList1.get(k)).BSSID;
      if (str == null)
        i1 = m;
    }
    while (true)
    {
      k++;
      m = i1;
      break;
      for (int n = 0; ; n++)
      {
        if (n >= j)
          break label202;
        if (!str.equals(((ScanResult)localList2.get(n)).BSSID))
          continue;
        i1 = m + 1;
        break;
      }
      return m * 2 >= f * paramFloat;
      label202: i1 = m;
    }
  }

  public static boolean jdMethod_if(List paramList1, List paramList2, float paramFloat)
  {
    if ((paramList1 == null) || (paramList2 == null))
      return false;
    if (paramList1 == paramList2)
      return true;
    if ((paramList1 == null) || (paramList2 == null))
      return false;
    int i = paramList1.size();
    int j = paramList2.size();
    float f = i + j;
    if ((i == 0) && (j == 0))
      return true;
    if ((i == 0) || (j == 0))
      return false;
    int k = 0;
    int m = 0;
    String str;
    int i1;
    if (k < i)
    {
      str = ((ScanResult)paramList1.get(k)).BSSID;
      if (str == null)
        i1 = m;
    }
    while (true)
    {
      k++;
      m = i1;
      break;
      for (int n = 0; ; n++)
      {
        if (n >= j)
          break label182;
        if (!str.equals(((ScanResult)paramList2.get(n)).BSSID))
          continue;
        i1 = m + 1;
        break;
      }
      return m * 2 >= f * paramFloat;
      label182: i1 = m;
    }
  }

  public boolean D(String paramString)
  {
    return super.D(paramString);
  }

  public boolean c0()
  {
    if (this.ki == null)
      return false;
    try
    {
      boolean bool = this.ki.isScanAlwaysAvailable();
      return bool;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
    }
    return false;
  }

  public void c1()
  {
    super.c1();
  }

  public f c2()
  {
    if (this.ki != null)
      try
      {
        f localf = new f(this.ki.getScanResults(), this.kg);
        return localf;
      }
      catch (Exception localException)
      {
      }
    return new f(null, 0L);
  }

  public boolean c3()
  {
    if (this.ki == null);
    do
      return false;
    while (System.currentTimeMillis() - this.kg <= 3000L);
    return c8();
  }

  // ERROR //
  public void c4()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/baidu/location/h/e:kl	Z
    //   6: istore_2
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: getstatic 150	com/baidu/location/f:isServing	Z
    //   18: ifeq -6 -> 12
    //   21: aload_0
    //   22: invokestatic 154	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   25: ldc 156
    //   27: invokevirtual 162	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 69	android/net/wifi/WifiManager
    //   33: putfield 48	com/baidu/location/h/e:ki	Landroid/net/wifi/WifiManager;
    //   36: aload_0
    //   37: new 164	com/baidu/location/h/e$a
    //   40: dup
    //   41: aload_0
    //   42: aconst_null
    //   43: invokespecial 167	com/baidu/location/h/e$a:<init>	(Lcom/baidu/location/h/e;Lcom/baidu/location/h/e$1;)V
    //   46: putfield 50	com/baidu/location/h/e:kn	Lcom/baidu/location/h/e$a;
    //   49: invokestatic 154	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   52: aload_0
    //   53: getfield 50	com/baidu/location/h/e:kn	Lcom/baidu/location/h/e$a;
    //   56: new 169	android/content/IntentFilter
    //   59: dup
    //   60: ldc 171
    //   62: invokespecial 174	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   65: invokevirtual 178	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   68: pop
    //   69: aload_0
    //   70: iconst_1
    //   71: putfield 58	com/baidu/location/h/e:kl	Z
    //   74: ldc 180
    //   76: invokestatic 186	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   79: ldc 188
    //   81: invokevirtual 192	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   84: astore 5
    //   86: aload 5
    //   88: ifnull -76 -> 12
    //   91: aload 5
    //   93: iconst_1
    //   94: invokevirtual 198	java/lang/reflect/Field:setAccessible	(Z)V
    //   97: aload_0
    //   98: aload 5
    //   100: aload_0
    //   101: getfield 48	com/baidu/location/h/e:ki	Landroid/net/wifi/WifiManager;
    //   104: invokevirtual 201	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: putfield 60	com/baidu/location/h/e:ke	Ljava/lang/Object;
    //   110: aload_0
    //   111: getfield 60	com/baidu/location/h/e:ke	Ljava/lang/Object;
    //   114: invokevirtual 207	java/lang/Object:getClass	()Ljava/lang/Class;
    //   117: pop
    //   118: goto -106 -> 12
    //   121: astore 4
    //   123: goto -111 -> 12
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    //   131: astore_3
    //   132: goto -63 -> 69
    //
    // Exception table:
    //   from	to	target	type
    //   74	86	121	java/lang/Exception
    //   91	118	121	java/lang/Exception
    //   2	7	126	finally
    //   15	49	126	finally
    //   49	69	126	finally
    //   69	74	126	finally
    //   74	86	126	finally
    //   91	118	126	finally
    //   49	69	131	java/lang/Exception
  }

  public String c5()
  {
    try
    {
      WifiInfo localWifiInfo = this.ki.getConnectionInfo();
      Object localObject = null;
      if (localWifiInfo != null)
      {
        String str = localWifiInfo.getMacAddress();
        localObject = str;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public f c6()
  {
    if ((this.kd == null) || (!this.kd.dq()))
      return c2();
    return this.kd;
  }

  public String c7()
  {
    if (this.ki == null)
      return null;
    while (true)
    {
      try
      {
        WifiInfo localWifiInfo = this.ki.getConnectionInfo();
        if (localWifiInfo == null)
          break;
        String str1 = localWifiInfo.getBSSID();
        if (str1 != null)
        {
          str2 = str1.replace(":", "");
          if ("000000000000".equals(str2))
            break;
          boolean bool = "".equals(str2);
          if (bool)
            break;
          return str2;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      String str2 = null;
    }
  }

  public boolean c8()
  {
    try
    {
      if ((this.ki.isWifiEnabled()) || ((Build.VERSION.SDK_INT > 17) && (this.ki.isScanAlwaysAvailable())))
        if (this.kk != null)
        {
          Object localObject1 = this.ke;
          if (localObject1 != null)
            try
            {
              Method localMethod = this.kk;
              Object localObject2 = this.ke;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = Boolean.valueOf(this.kb);
              localMethod.invoke(localObject2, arrayOfObject);
              this.kg = System.currentTimeMillis();
              return true;
            }
            catch (Exception localException2)
            {
              while (true)
                this.ki.startScan();
            }
        }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      while (true)
      {
        this.ki.startScan();
        this.kg = System.currentTimeMillis();
        return true;
        this.ki.startScan();
      }
    }
    catch (Exception localException1)
    {
    }
    return false;
  }

  public boolean c9()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        int i = localNetworkInfo.getType();
        if (i == 1)
          return true;
      }
      return false;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean cY()
  {
    long l = System.currentTimeMillis();
    if (l - this.km <= 5000L)
      return false;
    this.km = l;
    return c3();
  }

  public boolean cZ()
  {
    return (this.ki.isWifiEnabled()) && (3 == this.ki.getWifiState());
  }

  public int da()
  {
    if (this.ki == null);
    while (true)
    {
      return -1;
      try
      {
        WifiInfo localWifiInfo = this.ki.getConnectionInfo();
        if (localWifiInfo == null)
          continue;
        String str1 = localWifiInfo.getBSSID();
        int i = localWifiInfo.getRssi();
        if (i < 0)
          i = -i;
        if (str1 != null)
        {
          String str2 = str1.replace(":", "");
          if ("000000000000".equals(str2))
            continue;
          boolean bool = "".equals(str2);
          if (bool)
            continue;
        }
        return i;
      }
      catch (Exception localException)
      {
      }
    }
    return -1;
  }

  // ERROR //
  public void db()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/baidu/location/h/e:kl	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 154	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: aload_0
    //   18: getfield 50	com/baidu/location/h/e:kn	Lcom/baidu/location/h/e$a;
    //   21: invokevirtual 291	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   24: lconst_0
    //   25: putstatic 43	com/baidu/location/h/e:kc	J
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 50	com/baidu/location/h/e:kn	Lcom/baidu/location/h/e$a;
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 48	com/baidu/location/h/e:ki	Landroid/net/wifi/WifiManager;
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 58	com/baidu/location/h/e:kl	Z
    //   43: goto -32 -> 11
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_3
    //   52: goto -24 -> 28
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	46	finally
    //   14	28	46	finally
    //   28	43	46	finally
    //   14	28	51	java/lang/Exception
  }

  public f dc()
  {
    if ((this.kd == null) || (!this.kd.dm()))
      return c2();
    return this.kd;
  }

  public f jdMethod_do(List paramList)
  {
    return super.jdMethod_do(paramList);
  }

  private class a extends BroadcastReceiver
  {
    private a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramContext == null);
      do
      {
        do
          return;
        while (!paramIntent.getAction().equals("android.net.wifi.SCAN_RESULTS"));
        e.kc = System.currentTimeMillis() / 1000L;
        e.jdMethod_if(e.this);
        m.a9().a8();
      }
      while (System.currentTimeMillis() - a.jdMethod_for() > 5000L);
      o.jdMethod_do(a.a(), e.this.c6(), a.jdMethod_if(), a.jdMethod_do());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.h.e
 * JD-Core Version:    0.6.0
 */