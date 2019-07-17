package com.baidu.location.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.baidu.location.b.b;
import com.baidu.location.b.o;
import com.baidu.location.h.h;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class d
  implements b
{
  static final String ab = "com.baidu.lbs.offlinelocationprovider";
  private static final String ad = "http://180.149.144.31:8091/offline_loc";
  private static final String ae = "com.baidu.lbs.offlinelocationprovider";
  private static final String ag = "ofld";
  public static final String ai = "1";
  static final String ak = "http://loc.map.baidu.com/offline_loc";
  private static final String am = "http://loc.map.baidu.com/offline_loc";
  private static Context an;
  public static final String ao = "oflv2";
  public static final String ap = "oflv1";
  private static d aq;
  private static final String ar = "content://%s/";
  private static final String as = "com.baidu.lbs.offlinelocationprovider.debug";
  private static final int at = 2000;
  private final e ac;
  private final File af;
  private final f ah;
  private final g aj;
  private final a al;

  private d()
  {
    try
    {
      localFile = new File(an.getFilesDir(), "ofld");
    }
    catch (Exception localException2)
    {
      try
      {
        File localFile;
        if (!localFile.exists())
          localFile.mkdir();
        while (true)
        {
          label32: this.af = localFile;
          this.al = new a(this);
          this.aj = new g(this.al.jdMethod_if());
          this.ac = new e(this, this.al.jdMethod_if());
          this.ah = new f(this, this.al.jdMethod_if(), this.ac.o());
          return;
          localException2 = localException2;
          localFile = null;
        }
      }
      catch (Exception localException1)
      {
        break label32;
      }
    }
  }

  private BDLocation jdMethod_do(String[] paramArrayOfString)
  {
    new BDLocation();
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    FutureTask localFutureTask = (FutureTask)localExecutorService.submit(new d.1(this, paramArrayOfString));
    try
    {
      BDLocation localBDLocation = (BDLocation)localFutureTask.get(2000L, TimeUnit.MILLISECONDS);
      return localBDLocation;
    }
    catch (InterruptedException localInterruptedException)
    {
      localFutureTask.cancel(true);
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      localFutureTask.cancel(true);
      return null;
    }
    catch (TimeoutException localTimeoutException)
    {
      o.aX().j("offlineLocation Timeout Exception!");
      localFutureTask.cancel(true);
      return null;
    }
    finally
    {
      localExecutorService.shutdown();
    }
    throw localObject;
  }

  public static void jdMethod_if(Context paramContext)
  {
    if (an == null)
    {
      an = paramContext;
      com.baidu.location.b.c.N().jdMethod_do(an);
    }
  }

  private static final Uri jdMethod_int(String paramString)
  {
    return Uri.parse(String.format("content://%s/", new Object[] { paramString }));
  }

  private void jdMethod_int()
  {
    this.ac.q();
  }

  public static d jdMethod_try()
  {
    if (aq == null)
      monitorenter;
    try
    {
      if (aq == null)
      {
        if (an == null)
          jdMethod_if(com.baidu.location.f.getServiceContext());
        aq = new d();
      }
      monitorexit;
      aq.jdMethod_int();
      return aq;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private boolean jdMethod_void()
  {
    String str = an.getPackageName();
    ProviderInfo localProviderInfo1 = an.getPackageManager().resolveContentProvider(ab, 0);
    ProviderInfo localProviderInfo2;
    int j;
    if (localProviderInfo1 == null)
    {
      String[] arrayOfString = this.ac.v();
      localProviderInfo2 = localProviderInfo1;
      j = 0;
      if (j < arrayOfString.length)
      {
        localProviderInfo2 = an.getPackageManager().resolveContentProvider(arrayOfString[j], 0);
        if (localProviderInfo2 == null)
          break label77;
      }
    }
    while (true)
    {
      int i;
      if (localProviderInfo2 == null)
        i = 1;
      label77: boolean bool;
      do
      {
        return i;
        j++;
        break;
        bool = str.equals(localProviderInfo2.packageName);
        i = 0;
      }
      while (!bool);
      return true;
      localProviderInfo2 = localProviderInfo1;
    }
  }

  public double jdMethod_byte()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)an.getSystemService("connectivity")).getActiveNetworkInfo();
    a locala = a.new;
    int i;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
    {
      if (localNetworkInfo.getType() == 1)
        locala = a.a;
      if (localNetworkInfo.getType() == 0)
      {
        i = localNetworkInfo.getSubtype();
        if ((i != 1) && (i != 2) && (i != 4) && (i != 7) && (i != 11))
          break label101;
        locala = a.if;
      }
    }
    while (locala == a.new)
    {
      return this.ac.A();
      label101: if ((i == 3) || (i == 5) || (i == 6) || (i == 8) || (i == 9) || (i == 10) || (i == 12) || (i == 14) || (i == 15))
      {
        locala = a.for;
        continue;
      }
      if (i != 13)
        continue;
      locala = a.int;
    }
    if (locala == a.a)
      return this.ac.r();
    if (locala == a.if)
      return this.ac.p();
    if (locala == a.for)
      return this.ac.E();
    if (locala == a.int)
      return this.ac.z();
    return 0.0D;
  }

  public boolean jdMethod_case()
  {
    return this.ac.y();
  }

  public Context jdMethod_char()
  {
    return an;
  }

  File d()
  {
    return this.af;
  }

  public boolean jdMethod_do(String paramString)
  {
    return this.ac.jdMethod_new(paramString);
  }

  public boolean e()
  {
    return this.ac.C();
  }

  public Cursor jdMethod_for(String[] paramArrayOfString)
  {
    c.a locala = new c.a(paramArrayOfString);
    return this.al.jdMethod_if(locala);
  }

  public boolean jdMethod_goto()
  {
    return this.ac.x();
  }

  public void h()
  {
  }

  public boolean i()
  {
    return this.ac.t();
  }

  public long jdMethod_if(String paramString)
  {
    return this.ac.jdMethod_try(paramString);
  }

  public BDLocation jdMethod_if(h paramh, com.baidu.location.h.f paramf, BDLocation paramBDLocation, c paramc, b paramb)
  {
    int i;
    String str;
    if (paramc == c.do)
    {
      i = this.ac.s();
      str = com.baidu.location.b.c.N().O() + "&mixMode=1";
      if (paramb != b.a)
        break label128;
    }
    label128: for (Boolean localBoolean = Boolean.valueOf(true); ; localBoolean = Boolean.valueOf(false))
    {
      String[] arrayOfString = c.jdMethod_if(paramh, paramf, paramBDLocation, str, localBoolean.booleanValue(), i);
      int j = arrayOfString.length;
      BDLocation localBDLocation = null;
      if (j > 0)
      {
        localBDLocation = jdMethod_do(arrayOfString);
        if ((localBDLocation == null) || (localBDLocation.getLocType() == 67));
      }
      return localBDLocation;
      str = com.baidu.location.b.c.N().O();
      i = 0;
      break;
    }
  }

  g j()
  {
    return this.aj;
  }

  public void k()
  {
    this.aj.I();
  }

  f l()
  {
    return this.ah;
  }

  public boolean jdMethod_long()
  {
    return this.ac.w();
  }

  public boolean m()
  {
    return this.ac.B();
  }

  public void n()
  {
    if (jdMethod_void())
      this.al.jdMethod_for();
  }

  e jdMethod_new()
  {
    return this.ac;
  }

  private static enum a
  {
    static
    {
      a = new a("NETWORK_WIFI", 1);
      if = new a("NETWORK_2G", 2);
      for = new a("NETWORK_3G", 3);
      int = new a("NETWORK_4G", 4);
      a[] arrayOfa = new a[5];
      arrayOfa[0] = new;
      arrayOfa[1] = a;
      arrayOfa[2] = if;
      arrayOfa[3] = for;
      arrayOfa[4] = int;
      do = arrayOfa;
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = do;
      if = arrayOfb;
    }
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[2];
      arrayOfc[0] = do;
      arrayOfc[1] = if;
      a = arrayOfc;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.d
 * JD-Core Version:    0.6.0
 */