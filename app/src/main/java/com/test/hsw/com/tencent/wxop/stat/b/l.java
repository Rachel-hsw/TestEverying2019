package com.tencent.wxop.stat.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.wxop.stat.c;
import com.tencent.wxop.stat.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public final class l
{
  private static int U;
  private static String W;
  private static String a = null;
  private static String aR;
  private static String b = null;
  private static int bG;
  private static volatile int bn;
  private static String bq;
  private static String br;
  private static String bs;
  private static String c = null;
  private static String cC;
  private static String cE;
  private static Random cR;
  private static DisplayMetrics cS;
  private static b cT;
  private static String cU;
  private static String cV;
  private static long cW;
  private static o cX;
  private static String cY;
  private static long cZ;
  private static String da;
  private static int w;

  static
  {
    W = null;
    cR = null;
    cS = null;
    bq = null;
    br = "";
    bs = "";
    bG = -1;
    cT = null;
    cU = null;
    aR = null;
    bn = -1;
    cV = null;
    cC = null;
    cW = -1L;
    cE = "";
    cX = null;
    cY = "__MTA_FIRST_ACTIVATE__";
    U = -1;
    cZ = -1L;
    w = 0;
    da = "";
  }

  public static String A(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        Object localObject = localApplicationInfo.metaData.get("InstallChannel");
        if (localObject != null)
          return localObject.toString();
        cT.c("Could not read InstallChannel meta-data from AndroidManifest.xml");
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        cT.d("Could not read InstallChannel meta-data from AndroidManifest.xml");
    }
  }

  public static String B(Context paramContext)
  {
    if (paramContext == null)
      return null;
    return paramContext.getClass().getName();
  }

  public static String C(Context paramContext)
  {
    if (bq != null)
      return bq;
    try
    {
      int i;
      if (r.a(paramContext, "android.permission.READ_PHONE_STATE"))
        if (paramContext.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", paramContext.getPackageName()) != 0)
        {
          i = 0;
          if (i != 0)
          {
            TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
            if (localTelephonyManager != null)
              bq = localTelephonyManager.getSimOperator();
          }
        }
      while (true)
      {
        return bq;
        i = 1;
        break;
        cT.d("Could not get permission of android.permission.READ_PHONE_STATE");
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
        cT.b(localThrowable);
    }
  }

  public static String D(Context paramContext)
  {
    if (e(br))
      return br;
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      br = str;
      if (str == null)
        return "";
    }
    catch (Throwable localThrowable)
    {
      cT.b(localThrowable);
    }
    return br;
  }

  public static String E(Context paramContext)
  {
    String str1;
    String str2;
    try
    {
      if ((r.a(paramContext, "android.permission.INTERNET")) && (r.a(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
          break label119;
        str1 = localNetworkInfo.getTypeName();
        str2 = localNetworkInfo.getExtraInfo();
        if (str1 == null)
          break label119;
        if (str1.equalsIgnoreCase("WIFI"))
          return "WIFI";
        if (!str1.equalsIgnoreCase("MOBILE"))
          break label111;
        if (str2 != null)
          return str2;
      }
      else
      {
        cT.d("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        return "";
      }
    }
    catch (Throwable localThrowable)
    {
      cT.b(localThrowable);
      return "";
    }
    return "MOBILE";
    label111: if (str2 != null)
    {
      return str2;
      label119: str1 = "";
    }
    return str1;
  }

  public static Integer F(Context paramContext)
  {
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null)
      {
        Integer localInteger = Integer.valueOf(localTelephonyManager.getNetworkType());
        return localInteger;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static String G(Context paramContext)
  {
    if (e(bs))
      return bs;
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      bs = str;
      if ((str == null) || (bs.length() == 0))
        return "unknown";
    }
    catch (Throwable localThrowable)
    {
      cT.b(localThrowable);
    }
    return bs;
  }

  public static String H(Context paramContext)
  {
    if (e(cU))
      return cU;
    try
    {
      if (!r.a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
        break label150;
      String str1 = Environment.getExternalStorageState();
      if ((str1 != null) && (str1.equals("mounted")))
      {
        String str2 = Environment.getExternalStorageDirectory().getPath();
        if (str2 != null)
        {
          StatFs localStatFs = new StatFs(str2);
          long l1 = localStatFs.getBlockCount() * localStatFs.getBlockSize() / 1000000L;
          long l2 = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize() / 1000000L;
          String str3 = String.valueOf(l2) + "/" + String.valueOf(l1);
          cU = str3;
          return str3;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      cT.b(localThrowable);
    }
    return null;
    label150: cT.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
    return null;
  }

  static String I(Context paramContext)
  {
    try
    {
      if (aR != null)
        return aR;
      int i = Process.myPid();
      Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.pid != i)
          continue;
        aR = localRunningAppProcessInfo.processName;
      }
      label70: return aR;
    }
    catch (Throwable localThrowable)
    {
      break label70;
    }
  }

  public static String J(Context paramContext)
  {
    return e(paramContext, a.ct);
  }

  public static Integer K(Context paramContext)
  {
    monitorenter;
    while (true)
    {
      int k;
      try
      {
        if (bn > 0)
        {
          int j = bn % 1000;
          if (j != 0)
            continue;
          try
          {
            k = 1000 + bn;
            int m = bn;
            n = 0;
            if (m < 2147383647)
              break label124;
            q.b(paramContext, "MTA_EVENT_INDEX", n);
            int i = 1 + bn;
            bn = i;
            Integer localInteger = Integer.valueOf(i);
            monitorexit;
            return localInteger;
          }
          catch (Throwable localThrowable)
          {
            cT.c(localThrowable);
            continue;
          }
        }
      }
      finally
      {
        monitorexit;
      }
      bn = q.a(paramContext, "MTA_EVENT_INDEX", 0);
      q.b(paramContext, "MTA_EVENT_INDEX", 1000 + bn);
      continue;
      label124: int n = k;
    }
  }

  public static String L(Context paramContext)
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      long l1 = localMemoryInfo.availMem / 1000000L;
      long l2 = ay() / 1000000L;
      String str = String.valueOf(l1) + "/" + String.valueOf(l2);
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }

  public static String M(Context paramContext)
  {
    if (e(cE))
      return cE;
    try
    {
      SensorManager localSensorManager = (SensorManager)paramContext.getSystemService("sensor");
      if (localSensorManager != null)
      {
        List localList = localSensorManager.getSensorList(-1);
        if (localList != null)
        {
          StringBuilder localStringBuilder = new StringBuilder(10 * localList.size());
          i = 0;
          if (i < localList.size())
          {
            localStringBuilder.append(((Sensor)localList.get(i)).getType());
            if (i == -1 + localList.size())
              break label138;
            localStringBuilder.append(",");
            break label138;
          }
          cE = localStringBuilder.toString();
        }
      }
      return cE;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        int i;
        cT.b(localThrowable);
        continue;
        label138: i++;
      }
    }
  }

  public static int N(Context paramContext)
  {
    monitorenter;
    try
    {
      if (U != -1);
      for (int i = U; ; i = U)
      {
        return i;
        O(paramContext);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static void O(Context paramContext)
  {
    int i = q.a(paramContext, cY, 1);
    U = i;
    if (i == 1)
      q.b(paramContext, cY, 0);
  }

  public static boolean P(Context paramContext)
  {
    if (cZ < 0L)
      cZ = q.f(paramContext, "mta.qq.com.checktime");
    return Math.abs(System.currentTimeMillis() - cZ) > 86400000L;
  }

  public static void Q(Context paramContext)
  {
    cZ = System.currentTimeMillis();
    q.a(paramContext, "mta.qq.com.checktime", cZ);
  }

  public static String R(Context paramContext)
  {
    if (paramContext == null);
    ResolveInfo localResolveInfo;
    do
    {
      return null;
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.HOME");
      localResolveInfo = paramContext.getPackageManager().resolveActivity(localIntent, 0);
    }
    while ((localResolveInfo.activityInfo == null) || (localResolveInfo.activityInfo.packageName.equals("android")));
    return localResolveInfo.activityInfo.packageName;
  }

  public static int a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
      w = q.a(paramContext, "mta.qq.com.difftime", 0);
    return w;
  }

  private static Long a(String paramString1, String paramString2, Long paramLong)
  {
    if ((paramString1 == null) || (paramString2 == null));
    String[] arrayOfString;
    do
    {
      return paramLong;
      if ((paramString2.equalsIgnoreCase(".")) || (paramString2.equalsIgnoreCase("|")))
        paramString2 = "\\" + paramString2;
      arrayOfString = paramString1.split(paramString2);
    }
    while (arrayOfString.length != 3);
    try
    {
      Object localObject = Long.valueOf(0L);
      int i = 0;
      while (i < arrayOfString.length)
      {
        Long localLong = Long.valueOf(100L * (((Long)localObject).longValue() + Long.valueOf(arrayOfString[i]).longValue()));
        i++;
        localObject = localLong;
      }
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return (Long)paramLong;
  }

  public static void a(Context paramContext, int paramInt)
  {
    w = paramInt;
    q.b(paramContext, "mta.qq.com.difftime", paramInt);
  }

  public static boolean a(f paramf)
  {
    if (paramf == null)
      return false;
    return e(paramf.S());
  }

  public static long ad()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      long l = localCalendar.getTimeInMillis();
      return l + 86400000L;
    }
    catch (Throwable localThrowable)
    {
      cT.b(localThrowable);
    }
    return 86400000L + System.currentTimeMillis();
  }

  private static Random at()
  {
    monitorenter;
    try
    {
      if (cR == null)
        cR = new Random();
      Random localRandom = cR;
      return localRandom;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static int au()
  {
    if (bG != -1)
      return bG;
    try
    {
      if (p.a())
        bG = 1;
      bG = 0;
      return 0;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        cT.b(localThrowable);
    }
  }

  public static b av()
  {
    monitorenter;
    try
    {
      if (cT == null)
      {
        b localb1 = new b("MtaSDK");
        cT = localb1;
        localb1.ap();
      }
      b localb2 = cT;
      return localb2;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static String aw()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.roll(6, 0);
    return new SimpleDateFormat("yyyyMMdd").format(localCalendar.getTime());
  }

  public static String ax()
  {
    if (e(cC))
      return cC;
    StatFs localStatFs1 = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs1.getBlockSize() * localStatFs1.getBlockCount() / 1000000L;
    StatFs localStatFs2 = new StatFs(Environment.getDataDirectory().getPath());
    long l2 = localStatFs2.getBlockSize() * localStatFs2.getAvailableBlocks() / 1000000L;
    String str = String.valueOf(l2) + "/" + String.valueOf(l1);
    cC = str;
    return str;
  }

  private static long ay()
  {
    if (cW > 0L)
      return cW;
    long l = 1L;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
      l = 1024 * Integer.valueOf(localBufferedReader.readLine().split("\\s+")[1]).intValue();
      localBufferedReader.close();
      label63: cW = l;
      return l;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }

  public static JSONObject az()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("n", m.r());
      String str = m.ax();
      if ((str != null) && (str.length() > 0))
        localJSONObject.put("na", str);
      int i = m.aA();
      if (i > 0)
        localJSONObject.put("fx", i / 1000000);
      int j = m.D();
      if (j > 0)
        localJSONObject.put("fn", j / 1000000);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      Log.w("MtaSDK", "get cpu error", localThrowable);
    }
    return localJSONObject;
  }

  public static byte[] b(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
    byte[] arrayOfByte1 = new byte[4096];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(2 * paramArrayOfByte.length);
    while (true)
    {
      int i = localGZIPInputStream.read(arrayOfByte1);
      if (i == -1)
        break;
      localByteArrayOutputStream.write(arrayOfByte1, 0, i);
    }
    byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    localByteArrayInputStream.close();
    localGZIPInputStream.close();
    localByteArrayOutputStream.close();
    return arrayOfByte2;
  }

  public static String c(Context paramContext)
  {
    monitorenter;
    try
    {
      if ((a != null) && (a.trim().length() != 0));
      for (String str2 = a; ; str2 = a)
      {
        return str2;
        String str1 = r.b(paramContext);
        a = str1;
        if ((str1 != null) && (a.trim().length() != 0))
          continue;
        a = Integer.toString(at().nextInt(2147483647));
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static String d(long paramLong)
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong));
  }

  public static String e(Context paramContext, String paramString)
  {
    if (c.E() == true)
    {
      if (aR == null)
        aR = I(paramContext);
      if (aR != null)
        paramString = paramString + "_" + aR;
    }
    return paramString;
  }

  public static boolean e(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() != 0);
  }

  public static int r()
  {
    return at().nextInt(2147483647);
  }

  public static String t(String paramString)
  {
    if (paramString == null)
      return "0";
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0; i < arrayOfByte.length; i++)
      {
        int j = 0xFF & arrayOfByte[i];
        if (j < 16)
          localStringBuffer.append("0");
        localStringBuffer.append(Integer.toHexString(j));
      }
      String str = localStringBuffer.toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "0";
  }

  public static long u(String paramString)
  {
    return a(paramString, ".", Long.valueOf(0L)).longValue();
  }

  public static HttpHost v(Context paramContext)
  {
    if (paramContext == null)
      return null;
    String str2;
    do
    {
      String str1;
      try
      {
        if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0)
          return null;
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null)
          return null;
        if ((localNetworkInfo.getTypeName() != null) && (localNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")))
          return null;
        str1 = localNetworkInfo.getExtraInfo();
        if (str1 == null)
          return null;
        if ((str1.equals("cmwap")) || (str1.equals("3gwap")) || (str1.equals("uniwap")))
        {
          HttpHost localHttpHost1 = new HttpHost("10.0.0.172", 80);
          return localHttpHost1;
        }
      }
      catch (Throwable localThrowable)
      {
        cT.b(localThrowable);
        return null;
      }
      if (str1.equals("ctwap"))
        return new HttpHost("10.0.0.200", 80);
      str2 = Proxy.getDefaultHost();
    }
    while ((str2 == null) || (str2.trim().length() <= 0));
    HttpHost localHttpHost2 = new HttpHost(str2, Proxy.getDefaultPort());
    return localHttpHost2;
  }

  public static String w(Context paramContext)
  {
    monitorenter;
    try
    {
      if ((c == null) || (c.trim().length() == 0))
        c = r.c(paramContext);
      String str = c;
      return str;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static DisplayMetrics x(Context paramContext)
  {
    if (cS == null)
    {
      cS = new DisplayMetrics();
      ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(cS);
    }
    return cS;
  }

  public static boolean y(Context paramContext)
  {
    try
    {
      if (r.a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
        if (localConnectivityManager == null)
          break label100;
        NetworkInfo[] arrayOfNetworkInfo = localConnectivityManager.getAllNetworkInfo();
        if (arrayOfNetworkInfo == null)
          break label100;
        i = 0;
        if (i >= arrayOfNetworkInfo.length)
          break label100;
        if ((arrayOfNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI")) && (arrayOfNetworkInfo[i].isConnected()))
          return true;
      }
      else
      {
        cT.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        int i;
        cT.b(localThrowable);
        continue;
        i++;
      }
    }
    label100: return false;
  }

  public static String z(Context paramContext)
  {
    if (b != null)
      return b;
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        String str = localApplicationInfo.metaData.getString("TA_APPKEY");
        if (str == null)
          break label62;
        b = str;
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      cT.b("Could not read APPKEY meta-data from AndroidManifest.xml");
    }
    while (true)
    {
      return null;
      label62: cT.b("Could not read APPKEY meta-data from AndroidManifest.xml");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b.l
 * JD-Core Version:    0.6.0
 */