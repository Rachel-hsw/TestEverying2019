package com.alipay.sdk.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.alipay.sdk.cons.a;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k
{
  static final String a = "com.alipay.android.app";
  public static final String b = "com.eg.android.AlipayGphone";
  private static final String c = "7.0.0";

  private static int a(String paramString1, String paramString2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.addAll(Arrays.asList(paramString1.split("\\.")));
    localArrayList2.addAll(Arrays.asList(paramString2.split("\\.")));
    int i = Math.max(localArrayList1.size(), localArrayList2.size());
    while (localArrayList1.size() < i)
      localArrayList1.add("0");
    while (localArrayList2.size() < i)
      localArrayList2.add("0");
    for (int j = 0; j < i; j++)
      if (Integer.parseInt((String)localArrayList1.get(j)) != Integer.parseInt((String)localArrayList2.get(j)))
        return Integer.parseInt((String)localArrayList1.get(j)) - Integer.parseInt((String)localArrayList2.get(j));
    return 0;
  }

  private static a a(Context paramContext, String paramString)
  {
    Iterator localIterator = paramContext.getPackageManager().getInstalledPackages(64).iterator();
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      if (!localPackageInfo.packageName.equals(paramString))
        continue;
      a locala = new a();
      locala.a = localPackageInfo.signatures[0].toByteArray();
      locala.b = localPackageInfo.versionCode;
      return locala;
    }
    return null;
  }

  public static String a()
  {
    return "Android " + Build.VERSION.RELEASE;
  }

  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      String str1 = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramArrayOfByte))).getPublicKey().toString();
      if (str1.indexOf("modulus") != -1)
      {
        String str2 = str1.substring(8 + str1.indexOf("modulus"), str1.lastIndexOf(",")).trim();
        return str2;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static boolean a(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.alipay.android.app", 128);
      return localPackageInfo != null;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  private static boolean a(PackageInfo paramPackageInfo)
  {
    int i = paramPackageInfo.applicationInfo.flags;
    return ((i & 0x1) == 0) && ((i & 0x80) == 0);
  }

  public static boolean a(String paramString)
  {
    return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(paramString).matches();
  }

  public static String b()
  {
    String str = c();
    int i = str.indexOf("-");
    if (i != -1)
      str = str.substring(0, i);
    int j = str.indexOf("\n");
    if (j != -1)
      str = str.substring(0, j);
    return "Linux " + str;
  }

  public static boolean b(Context paramContext)
  {
    while (true)
    {
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
        if (localPackageInfo == null)
          return false;
        String str = localPackageInfo.versionName;
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localArrayList1.addAll(Arrays.asList(str.split("\\.")));
        localArrayList2.addAll(Arrays.asList("7.0.0".split("\\.")));
        int i = Math.max(localArrayList1.size(), localArrayList2.size());
        if (localArrayList1.size() >= i)
          continue;
        localArrayList1.add("0");
        continue;
        if (localArrayList2.size() < i)
        {
          localArrayList2.add("0");
          continue;
          if (j >= i)
            continue;
          if (Integer.parseInt((String)localArrayList1.get(j)) == Integer.parseInt((String)localArrayList2.get(j)))
            continue;
          int k = Integer.parseInt((String)localArrayList1.get(j));
          int m = Integer.parseInt((String)localArrayList2.get(j));
          int n = k - m;
          if (n < 0)
          {
            return false;
            j++;
            continue;
            n = 0;
            continue;
          }
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        return false;
      }
      int j = 0;
    }
  }

  private static String c()
  {
    Matcher localMatcher;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
      try
      {
        String str1 = localBufferedReader.readLine();
        localBufferedReader.close();
        localMatcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(str1);
        if (!localMatcher.matches())
          return "Unavailable";
      }
      finally
      {
        localBufferedReader.close();
      }
    }
    catch (IOException localIOException)
    {
      return "Unavailable";
    }
    if (localMatcher.groupCount() < 4)
      return "Unavailable";
    String str2 = localMatcher.group(1) + "\n" + localMatcher.group(2) + " " + localMatcher.group(3) + "\n" + localMatcher.group(4);
    return str2;
  }

  public static String c(Context paramContext)
  {
    String str1 = a();
    String str2 = b();
    String str3 = d(paramContext);
    String str4 = e(paramContext);
    return " (" + str1 + ";" + str2 + ";" + str3 + ";;" + str4 + ")(sdk android)";
  }

  private static String d()
  {
    String str = a.b;
    return str.substring(0, str.indexOf("://"));
  }

  public static String d(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().locale.toString();
  }

  private static String e()
  {
    return "-1;-1";
  }

  public static String e(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localDisplayMetrics.widthPixels);
    localStringBuilder.append("*");
    localStringBuilder.append(localDisplayMetrics.heightPixels);
    return localStringBuilder.toString();
  }

  private static String f()
  {
    Random localRandom = new Random();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < 24)
    {
      switch (localRandom.nextInt(3))
      {
      default:
      case 0:
      case 1:
      case 2:
      }
      while (true)
      {
        i++;
        break;
        localStringBuilder.append(String.valueOf((char)(int)Math.round(65.0D + 25.0D * Math.random())));
        continue;
        localStringBuilder.append(String.valueOf((char)(int)Math.round(97.0D + 25.0D * Math.random())));
        continue;
        localStringBuilder.append(String.valueOf(new Random().nextInt(10)));
      }
    }
    return localStringBuilder.toString();
  }

  public static String f(Context paramContext)
  {
    try
    {
      Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (!localRunningAppProcessInfo.processName.contains("com.eg.android.AlipayGphone"))
          continue;
        String str = localRunningAppProcessInfo.processName;
        return str;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
    }
    return "error";
  }

  public static String g(Context paramContext)
  {
    List localList = paramContext.getPackageManager().getInstalledPackages(0);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < localList.size())
    {
      PackageInfo localPackageInfo = (PackageInfo)localList.get(i);
      int j = localPackageInfo.applicationInfo.flags;
      int k;
      if (((j & 0x1) == 0) && ((j & 0x80) == 0))
      {
        k = 1;
        label70: if (k != 0)
        {
          if (!localPackageInfo.packageName.equals("com.eg.android.AlipayGphone"))
            break label123;
          localStringBuilder.append(localPackageInfo.packageName).append(localPackageInfo.versionCode).append("-");
        }
      }
      while (true)
      {
        i++;
        break;
        k = 0;
        break label70;
        label123: if (localPackageInfo.packageName.contains("theme"))
          continue;
        localStringBuilder.append(localPackageInfo.packageName).append("-");
      }
    }
    String str = localStringBuilder.toString();
    if ((str != null) && (str.length() > 0))
      return str.substring(0, -1 + str.length());
    return null;
  }

  private static DisplayMetrics h(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }

  public static final class a
  {
    public byte[] a;
    public int b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.util.k
 * JD-Core Version:    0.6.0
 */