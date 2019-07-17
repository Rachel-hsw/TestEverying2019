package com.xiaomi.network;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  protected static Map<String, ArrayList<String>> b = new HashMap();
  protected static boolean e = false;
  private static f m;
  private static a n;
  private static String o;
  private static String p;
  protected Map<String, c> a = new HashMap();
  protected Context c;
  protected b d;
  private e f;
  private String g = "0";
  private long h = 0L;
  private final long i = 15L;
  private long j = 0L;
  private String k = "isp_prov_city_country_ip";
  private j.a l = new k(this);

  protected f(Context paramContext, e parame, b paramb, String paramString1, String paramString2, String paramString3)
  {
    this.c = paramContext.getApplicationContext();
    if (this.c == null)
      this.c = paramContext;
    this.d = paramb;
    if (parame == null)
    {
      this.f = new l(this);
      this.g = paramString1;
      if (paramString2 == null)
        break label132;
      label108: o = paramString2;
      if (paramString3 == null)
        break label141;
    }
    while (true)
    {
      p = paramString3;
      return;
      this.f = parame;
      break;
      label132: paramString2 = paramContext.getPackageName();
      break label108;
      label141: paramString3 = m();
    }
  }

  public static f a()
  {
    monitorenter;
    try
    {
      if (m == null)
        throw new IllegalStateException("the host manager is not initialized yet.");
    }
    finally
    {
      monitorexit;
    }
    f localf = m;
    monitorexit;
    return localf;
  }

  public static <T> String a(Collection<T> paramCollection, String paramString)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(localIterator.next());
      if (!localIterator.hasNext())
        continue;
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }

  public static String a(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramArrayOfString[0]);
    for (int i1 = 1; i1 < paramArrayOfString.length; i1++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramArrayOfString[i1]);
    }
    return localStringBuilder.toString();
  }

  private ArrayList<b> a(ArrayList<String> paramArrayList)
  {
    k();
    synchronized (this.a)
    {
      g();
      Iterator localIterator1 = this.a.keySet().iterator();
      while (localIterator1.hasNext())
      {
        String str11 = (String)localIterator1.next();
        if (paramArrayList.contains(str11))
          continue;
        paramArrayList.add(str11);
      }
    }
    monitorexit;
    synchronized (b)
    {
      Iterator localIterator2 = b.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str10 = (String)localIterator2.next();
        if (paramArrayList.contains(str10))
          continue;
        paramArrayList.add(str10);
      }
    }
    monitorexit;
    if (!paramArrayList.contains(c()))
      paramArrayList.add(c());
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    for (int i1 = 0; i1 < paramArrayList.size(); i1++)
      localArrayList.add(null);
    while (true)
    {
      int i3;
      int i4;
      try
      {
        if (!com.xiaomi.a.a.e.d.e(this.c))
          break label844;
        str1 = "wifi";
        String str2 = a(paramArrayList, str1, this.g);
        if (TextUtils.isEmpty(str2))
          continue;
        JSONObject localJSONObject1 = new JSONObject(str2);
        if (!"OK".equalsIgnoreCase(localJSONObject1.getString("S")))
          continue;
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("R");
        String str3 = localJSONObject2.getString("province");
        String str4 = localJSONObject2.getString("city");
        String str5 = localJSONObject2.getString("isp");
        String str6 = localJSONObject2.getString("ip");
        String str7 = localJSONObject2.getString("country");
        JSONObject localJSONObject3 = localJSONObject2.getJSONObject(str1);
        if (!str1.equals("wap"))
          continue;
        str1 = b();
        com.xiaomi.a.a.c.c.a("get bucket: " + str7 + " " + str3 + " " + " isp:" + str5 + " " + str1 + " hosts:" + localJSONObject3.toString());
        i3 = 0;
        if (i3 >= paramArrayList.size())
          continue;
        String str8 = (String)paramArrayList.get(i3);
        JSONArray localJSONArray = localJSONObject3.optJSONArray(str8);
        if (localJSONArray != null)
          continue;
        com.xiaomi.a.a.c.c.a("no bucket found for " + str8);
        break label838;
        b localb2 = new b(str8);
        i4 = 0;
        if (i4 >= localJSONArray.length())
          continue;
        String str9 = localJSONArray.getString(i4);
        if (TextUtils.isEmpty(str9))
          break label851;
        localb2.a(new o(str9, localJSONArray.length() - i4));
        break label851;
        localArrayList.set(i3, localb2);
        localb2.g = str7;
        localb2.c = str3;
        localb2.e = str5;
        localb2.f = str6;
        localb2.d = str4;
        if (!localJSONObject2.has("stat-percent"))
          continue;
        localb2.a(localJSONObject2.getDouble("stat-percent"));
        if (!localJSONObject2.has("stat-domain"))
          continue;
        localb2.b(localJSONObject2.getString("stat-domain"));
        if (!localJSONObject2.has("ttl"))
          continue;
        localb2.a(1000L * localJSONObject2.getInt("ttl"));
        e(localb2.e());
      }
      catch (JSONException localJSONException)
      {
        com.xiaomi.a.a.c.c.a("failed to get bucket" + localJSONException.getMessage());
        int i2 = 0;
        if (i2 >= paramArrayList.size())
          continue;
        b localb1 = (b)localArrayList.get(i2);
        if (localb1 == null)
          continue;
        a((String)paramArrayList.get(i2), localb1);
        i2++;
        continue;
      }
      catch (IOException localIOException)
      {
        com.xiaomi.a.a.c.c.a("failed to get bucket" + localIOException.getMessage());
        continue;
      }
      catch (Exception localException)
      {
        com.xiaomi.a.a.c.c.a("failed to get bucket" + localException.getMessage());
        continue;
        h();
        return localArrayList;
      }
      label838: i3++;
      continue;
      label844: String str1 = "wap";
      continue;
      label851: i4++;
    }
  }

  public static void a(Context paramContext, e parame, b paramb, String paramString1, String paramString2, String paramString3)
  {
    monitorenter;
    try
    {
      if (m == null)
      {
        if (n != null)
          break label65;
        m = new f(paramContext, parame, paramb, paramString1, paramString2, paramString3);
      }
      while (true)
      {
        if (m != null)
        {
          if (j.a() == null)
            j.a(paramContext);
          j.a().a(m.l);
        }
        return;
        label65: m = n.a(paramContext, parame, paramb, paramString1);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static void a(a parama)
  {
    monitorenter;
    try
    {
      n = parama;
      if ((j.a() != null) && (m != null))
        j.a().b(m.l);
      m = null;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static void a(String paramString1, String paramString2)
  {
    ArrayList localArrayList1 = (ArrayList)b.get(paramString1);
    Map localMap = b;
    monitorenter;
    if (localArrayList1 == null);
    try
    {
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(paramString2);
      b.put(paramString1, localArrayList2);
      while (true)
      {
        return;
        if (localArrayList1.contains(paramString2))
          continue;
        localArrayList1.add(paramString2);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "unknown";
    do
      return paramString;
    while (!paramString.startsWith("WIFI"));
    return "WIFI";
  }

  private String m()
  {
    try
    {
      PackageInfo localPackageInfo = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 16384);
      if (localPackageInfo != null)
      {
        String str = localPackageInfo.versionName;
        return str;
      }
    }
    catch (Exception localException)
    {
    }
    return "0";
  }

  public b a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("the url is empty");
    return a(new URL(paramString).getHost(), true);
  }

  public b a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("the host is empty");
    b localb1;
    if (!this.f.a(paramString))
      localb1 = null;
    do
    {
      return localb1;
      localb1 = c(paramString);
    }
    while ((localb1 != null) && (localb1.b()));
    if ((paramBoolean) && (com.xiaomi.a.a.e.d.d(this.c)))
    {
      b localb2 = d(paramString);
      if (localb2 != null)
        return localb2;
    }
    return new m(this, paramString, localb1);
  }

  protected String a(ArrayList<String> paramArrayList, String paramString1, String paramString2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new com.xiaomi.a.a.e.a("type", paramString1));
    localArrayList2.add(new com.xiaomi.a.a.e.a("uuid", paramString2));
    localArrayList2.add(new com.xiaomi.a.a.e.a("list", a(paramArrayList, ",")));
    b localb = c("resolver.gslb.mi-idc.com");
    String str1 = String.format("http://%1$s/gslb/gslb/getbucket.asp?ver=3.0", new Object[] { "resolver.gslb.mi-idc.com" });
    Iterator localIterator1;
    Object localObject;
    if (localb == null)
    {
      localArrayList1.add(str1);
      localIterator1 = localArrayList1.iterator();
      localObject = null;
    }
    while (true)
    {
      Uri.Builder localBuilder;
      if (localIterator1.hasNext())
      {
        localBuilder = Uri.parse((String)localIterator1.next()).buildUpon();
        Iterator localIterator2 = localArrayList2.iterator();
        while (true)
          if (localIterator2.hasNext())
          {
            com.xiaomi.a.a.e.c localc = (com.xiaomi.a.a.e.c)localIterator2.next();
            localBuilder.appendQueryParameter(localc.a(), localc.b());
            continue;
            localArrayList1 = localb.a(str1);
            break;
          }
      }
      try
      {
        if (this.d == null)
          return com.xiaomi.a.a.e.d.a(this.c, new URL(localBuilder.toString()));
        String str2 = this.d.a(localBuilder.toString());
        return str2;
        if (localObject == null)
          break label284;
        throw localObject;
      }
      catch (IOException localIOException)
      {
      }
    }
    label284: return null;
  }

  public void a(String paramString, b paramb)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramb == null))
      throw new IllegalArgumentException("the argument is invalid " + paramString + ", " + paramb);
    if (this.f.a(paramString))
      synchronized (this.a)
      {
        g();
        if (this.a.containsKey(paramString))
        {
          ((c)this.a.get(paramString)).a(paramb);
          return;
        }
        c localc = new c(paramString);
        localc.a(paramb);
        this.a.put(paramString, localc);
      }
  }

  public b b(String paramString)
  {
    return a(paramString, true);
  }

  public String b()
  {
    if (this.c == null)
      return "unknown";
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)this.c.getSystemService("connectivity");
      if (localConnectivityManager == null)
        return "unknown";
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null)
        return "unknown";
      if (localNetworkInfo.getType() == 1)
      {
        WifiManager localWifiManager = (WifiManager)this.c.getSystemService("wifi");
        if ((localWifiManager != null) && (localWifiManager.getConnectionInfo() != null))
          return "WIFI-" + localWifiManager.getConnectionInfo().getSSID();
      }
      else
      {
        String str = localNetworkInfo.getTypeName() + "-" + localNetworkInfo.getSubtypeName();
        return str;
      }
    }
    catch (Exception localException)
    {
    }
    return "unknown";
  }

  protected b c(String paramString)
  {
    synchronized (this.a)
    {
      g();
      c localc = (c)this.a.get(paramString);
      if (localc != null)
      {
        b localb = localc.a();
        if (localb != null)
          return localb;
      }
    }
    return null;
  }

  protected String c()
  {
    return "resolver.gslb.mi-idc.com";
  }

  protected b d(String paramString)
  {
    if (System.currentTimeMillis() - this.j > 1000L * (60L * this.h))
    {
      this.j = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      b localb = (b)a(localArrayList).get(0);
      if (localb != null)
      {
        this.h = 0L;
        return localb;
      }
      if (this.h < 15L)
        this.h = (1L + this.h);
    }
    return null;
  }

  public void d()
  {
    synchronized (this.a)
    {
      this.a.clear();
      return;
    }
  }

  public void e()
  {
    while (true)
    {
      int i1;
      synchronized (this.a)
      {
        g();
        ArrayList localArrayList1 = new ArrayList(this.a.keySet());
        i1 = -1 + localArrayList1.size();
        if (i1 < 0)
          continue;
        c localc = (c)this.a.get(localArrayList1.get(i1));
        if ((localc == null) || (localc.a() == null))
          break label158;
        localArrayList1.remove(i1);
        break label158;
        ArrayList localArrayList2 = a(localArrayList1);
        int i2 = 0;
        if (i2 < localArrayList1.size())
        {
          if (localArrayList2.get(i2) == null)
            continue;
          a((String)localArrayList1.get(i2), (b)localArrayList2.get(i2));
          i2++;
        }
      }
      return;
      label158: i1--;
    }
  }

  public void e(String paramString)
  {
    this.k = paramString;
  }

  // ERROR //
  protected String f()
  {
    // Byte code:
    //   0: new 556	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 78	com/xiaomi/network/f:c	Landroid/content/Context;
    //   8: invokevirtual 560	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: aload_0
    //   12: invokevirtual 562	com/xiaomi/network/f:i	()Ljava/lang/String;
    //   15: invokespecial 565	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 568	java/io/File:isFile	()Z
    //   23: ifeq +104 -> 127
    //   26: new 570	java/io/BufferedReader
    //   29: dup
    //   30: new 572	java/io/InputStreamReader
    //   33: dup
    //   34: new 574	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 577	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 580	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   45: invokespecial 583	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore_3
    //   49: new 116	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   56: astore 6
    //   58: aload_3
    //   59: invokevirtual 586	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore 7
    //   64: aload 7
    //   66: ifnull +47 -> 113
    //   69: aload 6
    //   71: aload 7
    //   73: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -19 -> 58
    //   80: astore_2
    //   81: new 116	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 588
    //   91: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 589	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   98: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 247	com/xiaomi/a/a/c/c:a	(Ljava/lang/String;)V
    //   107: aload_3
    //   108: invokestatic 593	com/xiaomi/a/a/b/a:a	(Ljava/io/Reader;)V
    //   111: aconst_null
    //   112: areturn
    //   113: aload 6
    //   115: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 9
    //   120: aload_3
    //   121: invokestatic 593	com/xiaomi/a/a/b/a:a	(Ljava/io/Reader;)V
    //   124: aload 9
    //   126: areturn
    //   127: aconst_null
    //   128: invokestatic 593	com/xiaomi/a/a/b/a:a	(Ljava/io/Reader;)V
    //   131: aconst_null
    //   132: areturn
    //   133: astore 5
    //   135: aconst_null
    //   136: astore_3
    //   137: aload 5
    //   139: astore 4
    //   141: aload_3
    //   142: invokestatic 593	com/xiaomi/a/a/b/a:a	(Ljava/io/Reader;)V
    //   145: aload 4
    //   147: athrow
    //   148: astore 4
    //   150: goto -9 -> 141
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_3
    //   156: goto -75 -> 81
    //
    // Exception table:
    //   from	to	target	type
    //   49	58	80	java/lang/Throwable
    //   58	64	80	java/lang/Throwable
    //   69	77	80	java/lang/Throwable
    //   113	120	80	java/lang/Throwable
    //   0	49	133	finally
    //   49	58	148	finally
    //   58	64	148	finally
    //   69	77	148	finally
    //   81	107	148	finally
    //   113	120	148	finally
    //   0	49	153	java/lang/Throwable
  }

  protected void f(String paramString)
  {
    synchronized (this.a)
    {
      this.a.clear();
      JSONArray localJSONArray = new JSONArray(paramString);
      for (int i1 = 0; i1 < localJSONArray.length(); i1++)
      {
        c localc = new c().a(localJSONArray.getJSONObject(i1));
        this.a.put(localc.c(), localc);
      }
      return;
    }
  }

  protected boolean g()
  {
    synchronized (this.a)
    {
      if (!e)
      {
        e = true;
        this.a.clear();
        try
        {
          String str = f();
          if (!TextUtils.isEmpty(str))
          {
            f(str);
            com.xiaomi.a.a.c.c.a("loading the new hosts succeed");
            return true;
          }
        }
        catch (Throwable localThrowable)
        {
          com.xiaomi.a.a.c.c.a("load host exception " + localThrowable.getMessage());
          return false;
        }
      }
      return true;
    }
  }

  public void h()
  {
    k();
    try
    {
      synchronized (this.a)
      {
        try
        {
          BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(this.c.openFileOutput(i(), 0)));
          String str = l().toString();
          if (!TextUtils.isEmpty(str))
            localBufferedWriter.write(str);
          localBufferedWriter.close();
          return;
        }
        catch (IOException localIOException)
        {
          while (true)
            localIOException.printStackTrace();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  protected String i()
  {
    List localList = ((ActivityManager)this.c.getSystemService("activity")).getRunningAppProcesses();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.pid == Process.myPid())
          return localRunningAppProcessInfo.processName;
      }
    }
    return "com.xiaomi";
  }

  public ArrayList<com.xiaomi.b.a.a.a.b> j()
  {
    while (true)
    {
      HashMap localHashMap1;
      com.xiaomi.b.a.a.a.b localb2;
      com.xiaomi.b.a.a.a.a locala;
      ArrayList localArrayList2;
      int i1;
      int i2;
      int i3;
      int i5;
      int i6;
      int i7;
      synchronized (this.a)
      {
        localHashMap1 = new HashMap();
        Iterator localIterator1 = this.a.keySet().iterator();
        if (!localIterator1.hasNext())
          break label644;
        String str1 = (String)localIterator1.next();
        c localc = (c)this.a.get(str1);
        if (localc == null)
          continue;
        Iterator localIterator3 = localc.b().iterator();
        if (!localIterator3.hasNext())
          continue;
        b localb = (b)localIterator3.next();
        localb2 = (com.xiaomi.b.a.a.a.b)localHashMap1.get(localb.e());
        if (localb2 != null)
          break label712;
        com.xiaomi.b.a.a.a.b localb3 = new com.xiaomi.b.a.a.a.b();
        localb3.a("httpapi");
        localb3.e(localb.f);
        localb3.d(g(localb.a));
        localb3.b(this.g);
        localb3.c(p);
        localb3.f(o);
        localb3.g(this.c.getPackageName());
        localb3.h(m());
        com.xiaomi.b.a.a.a.e locale = new com.xiaomi.b.a.a.a.e();
        locale.c(localb.d);
        locale.a(localb.g);
        locale.b(localb.c);
        locale.d(localb.e);
        localb3.a(locale);
        localHashMap1.put(localb.e(), localb3);
        localb4 = localb3;
        locala = new com.xiaomi.b.a.a.a.a();
        locala.a(localb.b);
        localArrayList2 = new ArrayList();
        Iterator localIterator4 = localb.f().iterator();
        if (localIterator4.hasNext())
        {
          o localo = (o)localIterator4.next();
          ArrayList localArrayList3 = localo.a();
          if (localArrayList3.isEmpty())
            continue;
          com.xiaomi.b.a.a.a.d locald = new com.xiaomi.b.a.a.a.d();
          locald.a(localo.a);
          i1 = 0;
          i2 = 0;
          long l1 = 0L;
          i3 = 0;
          HashMap localHashMap2 = new HashMap();
          Iterator localIterator5 = localArrayList3.iterator();
          if (!localIterator5.hasNext())
            continue;
          a locala1 = (a)localIterator5.next();
          if (locala1.a() < 0)
            continue;
          int i4 = i1 + 1;
          l1 += locala1.b();
          i5 = (int)(i3 + locala1.d());
          i6 = i2;
          i7 = i4;
          break label719;
          String str2 = locala1.e();
          if (TextUtils.isEmpty(str2))
            break label734;
          if (!localHashMap2.containsKey(str2))
            break label755;
          i9 = 1 + ((Integer)localHashMap2.get(str2)).intValue();
          localHashMap2.put(str2, Integer.valueOf(i9));
          break label734;
          locald.a(localHashMap2);
          locald.b(i1);
          locald.a(i2);
          locald.a(l1);
          locald.c(i3);
          localArrayList2.add(locald);
        }
      }
      if (localArrayList2.isEmpty())
        continue;
      locala.a(localArrayList2);
      localb4.a(locala);
      continue;
      label644: ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator2 = localHashMap1.values().iterator();
      while (localIterator2.hasNext())
      {
        com.xiaomi.b.a.a.a.b localb1 = (com.xiaomi.b.a.a.a.b)localIterator2.next();
        if (localb1.g() <= 0)
          continue;
        localArrayList1.add(localb1);
      }
      monitorexit;
      return localArrayList1;
      label712: com.xiaomi.b.a.a.a.b localb4 = localb2;
      continue;
      while (true)
      {
        label719: i1 = i7;
        i2 = i6;
        i3 = i5;
        break;
        label734: int i8 = i2 + 1;
        i7 = i1;
        i5 = i3;
        i6 = i8;
      }
      label755: int i9 = 1;
    }
  }

  public void k()
  {
    synchronized (this.a)
    {
      Iterator localIterator1 = this.a.values().iterator();
      if (localIterator1.hasNext())
        ((c)localIterator1.next()).a(false);
    }
    int i1 = 0;
    while (true)
    {
      if (i1 == 0)
      {
        Iterator localIterator2 = this.a.keySet().iterator();
        String str;
        do
        {
          if (!localIterator2.hasNext())
            break;
          str = (String)localIterator2.next();
        }
        while (!((c)this.a.get(str)).b().isEmpty());
        this.a.remove(str);
        i1 = 0;
        continue;
      }
      monitorexit;
      return;
      i1 = 1;
    }
  }

  protected JSONArray l()
  {
    JSONArray localJSONArray;
    synchronized (this.a)
    {
      localJSONArray = new JSONArray();
      Iterator localIterator = this.a.values().iterator();
      if (localIterator.hasNext())
        localJSONArray.put(((c)localIterator.next()).d());
    }
    monitorexit;
    return localJSONArray;
  }

  public static abstract interface a
  {
    public abstract f a(Context paramContext, e parame, f.b paramb, String paramString);
  }

  public static abstract interface b
  {
    public abstract String a(String paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.f
 * JD-Core Version:    0.6.0
 */