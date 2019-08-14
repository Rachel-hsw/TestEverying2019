package com.umeng.message.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;
import org.android.a;

public class by
{
  public static final String a = "DaemonServer";
  public static final String b = "runServer";
  public static final String c = "agoo.pid";
  public static final String d = "startservice -a {packname}.intent.action.COCKROACH --es cockroach cockroach-PPreotect --es pack {packname}";
  private static final String f = by.class.getName();
  private static final String g = "daemonserver.pid";
  private static final int h = 100;
  private static int k = 1800;
  private static int l = 7200;
  private static int m = 2500;
  private static final ReentrantLock n = new ReentrantLock();
  private static by o = null;
  public boolean e = false;
  private Context i = null;
  private String j;
  private String p = "100001";
  private String q = "tb_android_daemon_1.1.0";
  private String r = "";
  private String s = "21646297";
  private String t = "null";
  private String u = "";
  private String v = "100.69.165.28";
  private String w = "http://100.69.165.28/agoo/report";
  private int x = 80;
  private boolean y = true;

  public by(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this.i = paramContext;
    k = paramInt;
    this.e = paramBoolean;
    this.j = a(new Build(), "CPU_ABI");
    this.r = ("/data/data/" + paramContext.getPackageName());
    this.u = String.valueOf(a.s(this.i));
    this.s = a.d(this.i);
    this.t = aq.c(this.i);
    int i1 = a.E(this.i);
    if ((i1 == 1) || (i1 == 2))
    {
      this.v = "agoodm.m.taobao.com";
      this.x = 80;
      this.w = "http://agoodm.m.taobao.com/agoo/report";
      this.p = "1009527";
      return;
    }
    if (i1 == 0)
    {
      this.v = "110.75.98.154";
      this.x = 80;
      this.w = "http://agoodm.wapa.taobao.com/agoo/report";
      this.p = "1009527";
      return;
    }
    this.v = "100.69.168.33";
    this.x = 80;
    this.w = "http://100.69.168.33/agoo/report";
    k = 60;
    this.p = "9527";
  }

  public static final PendingIntent a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramContext.getApplicationContext().getPackageName() + ".intent.action.COCKROACH");
    localIntent.putExtra("cockroach", "cockroach-PPreotect");
    localIntent.putExtra("pack", paramContext.getApplicationContext().getPackageName());
    return PendingIntent.getService(paramContext, 0, localIntent, 134217728);
  }

  // ERROR //
  public static by a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 69	com/umeng/message/b/by:n	Ljava/util/concurrent/locks/ReentrantLock;
    //   3: invokevirtual 213	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   6: getstatic 71	com/umeng/message/b/by:o	Lcom/umeng/message/b/by;
    //   9: ifnonnull +16 -> 25
    //   12: new 2	com/umeng/message/b/by
    //   15: dup
    //   16: aload_0
    //   17: iload_1
    //   18: iload_2
    //   19: invokespecial 215	com/umeng/message/b/by:<init>	(Landroid/content/Context;IZ)V
    //   22: putstatic 71	com/umeng/message/b/by:o	Lcom/umeng/message/b/by;
    //   25: getstatic 69	com/umeng/message/b/by:n	Ljava/util/concurrent/locks/ReentrantLock;
    //   28: invokevirtual 218	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   31: getstatic 71	com/umeng/message/b/by:o	Lcom/umeng/message/b/by;
    //   34: areturn
    //   35: astore 4
    //   37: getstatic 69	com/umeng/message/b/by:n	Ljava/util/concurrent/locks/ReentrantLock;
    //   40: invokevirtual 218	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   43: goto -12 -> 31
    //   46: astore_3
    //   47: getstatic 69	com/umeng/message/b/by:n	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 218	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   53: aload_3
    //   54: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	25	35	java/lang/Exception
    //   0	25	46	finally
  }

  private static String a(Build paramBuild, String paramString)
  {
    try
    {
      String str = Build.class.getField(paramString).get(paramBuild).toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "Unknown";
  }

  private static void a(Context paramContext, AlarmManager paramAlarmManager, PendingIntent paramPendingIntent, long paramLong)
  {
    paramAlarmManager.cancel(paramPendingIntent);
    paramAlarmManager.setRepeating(2, paramLong + 1000 * m, 1000 * m, paramPendingIntent);
  }

  // ERROR //
  private void a(FileOutputStream paramFileOutputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 121	com/umeng/message/b/by:j	Ljava/lang/String;
    //   4: invokestatic 252	com/umeng/message/b/bz:a	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: getstatic 56	com/umeng/message/b/by:f	Ljava/lang/String;
    //   11: new 123	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   18: ldc 254
    //   20: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 258	java/lang/String:length	()I
    //   27: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 266	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   36: pop
    //   37: aload_2
    //   38: invokevirtual 270	java/lang/String:getBytes	()[B
    //   41: invokestatic 275	com/umeng/message/b/ca:a	([B)[B
    //   44: astore 4
    //   46: getstatic 56	com/umeng/message/b/by:f	Ljava/lang/String;
    //   49: new 123	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 277
    //   59: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: arraylength
    //   65: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 266	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: aload 4
    //   77: arraylength
    //   78: ifgt +4 -> 82
    //   81: return
    //   82: aload_1
    //   83: ifnull -2 -> 81
    //   86: new 279	java/io/ByteArrayInputStream
    //   89: dup
    //   90: aload 4
    //   92: invokespecial 282	java/io/ByteArrayInputStream:<init>	([B)V
    //   95: astore 6
    //   97: bipush 100
    //   99: newarray byte
    //   101: astore 16
    //   103: aload 6
    //   105: aload 16
    //   107: iconst_0
    //   108: bipush 100
    //   110: invokevirtual 286	java/io/ByteArrayInputStream:read	([BII)I
    //   113: istore 17
    //   115: iload 17
    //   117: iflt +52 -> 169
    //   120: aload_1
    //   121: aload 16
    //   123: iconst_0
    //   124: iload 17
    //   126: invokevirtual 292	java/io/FileOutputStream:write	([BII)V
    //   129: goto -26 -> 103
    //   132: astore 11
    //   134: getstatic 56	com/umeng/message/b/by:f	Ljava/lang/String;
    //   137: ldc_w 294
    //   140: aload 11
    //   142: invokestatic 297	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   145: pop
    //   146: aload_1
    //   147: invokevirtual 300	java/io/FileOutputStream:flush	()V
    //   150: aload 6
    //   152: ifnull -71 -> 81
    //   155: aload 6
    //   157: invokevirtual 303	java/io/ByteArrayInputStream:close	()V
    //   160: return
    //   161: astore 15
    //   163: aload 15
    //   165: invokevirtual 306	java/io/IOException:printStackTrace	()V
    //   168: return
    //   169: aload_1
    //   170: invokevirtual 300	java/io/FileOutputStream:flush	()V
    //   173: aload 6
    //   175: ifnull -94 -> 81
    //   178: aload 6
    //   180: invokevirtual 303	java/io/ByteArrayInputStream:close	()V
    //   183: return
    //   184: astore 20
    //   186: aload 20
    //   188: invokevirtual 306	java/io/IOException:printStackTrace	()V
    //   191: return
    //   192: astore 18
    //   194: getstatic 56	com/umeng/message/b/by:f	Ljava/lang/String;
    //   197: ldc_w 294
    //   200: aload 18
    //   202: invokestatic 297	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   205: pop
    //   206: goto -33 -> 173
    //   209: astore 13
    //   211: getstatic 56	com/umeng/message/b/by:f	Ljava/lang/String;
    //   214: ldc_w 294
    //   217: aload 13
    //   219: invokestatic 297	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   222: pop
    //   223: goto -73 -> 150
    //   226: astore 7
    //   228: aconst_null
    //   229: astore 6
    //   231: aload_1
    //   232: invokevirtual 300	java/io/FileOutputStream:flush	()V
    //   235: aload 6
    //   237: ifnull +8 -> 245
    //   240: aload 6
    //   242: invokevirtual 303	java/io/ByteArrayInputStream:close	()V
    //   245: aload 7
    //   247: athrow
    //   248: astore 8
    //   250: getstatic 56	com/umeng/message/b/by:f	Ljava/lang/String;
    //   253: ldc_w 294
    //   256: aload 8
    //   258: invokestatic 297	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   261: pop
    //   262: goto -27 -> 235
    //   265: astore 10
    //   267: aload 10
    //   269: invokevirtual 306	java/io/IOException:printStackTrace	()V
    //   272: goto -27 -> 245
    //   275: astore 7
    //   277: goto -46 -> 231
    //   280: astore 11
    //   282: aconst_null
    //   283: astore 6
    //   285: goto -151 -> 134
    //
    // Exception table:
    //   from	to	target	type
    //   97	103	132	java/io/IOException
    //   103	115	132	java/io/IOException
    //   120	129	132	java/io/IOException
    //   155	160	161	java/io/IOException
    //   178	183	184	java/io/IOException
    //   169	173	192	java/io/IOException
    //   146	150	209	java/io/IOException
    //   86	97	226	finally
    //   231	235	248	java/io/IOException
    //   240	245	265	java/io/IOException
    //   97	103	275	finally
    //   103	115	275	finally
    //   120	129	275	finally
    //   134	146	275	finally
    //   86	97	280	java/io/IOException
  }

  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    cc.a("", "chmod 500 " + paramString, localStringBuilder);
    cc.a("", paramString + " " + e(), localStringBuilder);
    Log.w(f, paramString + " " + e());
  }

  public static void b(Context paramContext)
  {
    int i1 = Calendar.getInstance().get(11);
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    PendingIntent localPendingIntent;
    long l1;
    if (localAlarmManager != null)
    {
      localPendingIntent = a(paramContext);
      l1 = SystemClock.elapsedRealtime();
      if ((i1 > 23) || (i1 < 6))
      {
        Log.w(f, "time is night, do not wakeup cpu");
        b(paramContext, localAlarmManager, localPendingIntent, l1);
      }
    }
    else
    {
      return;
    }
    Log.w(f, "time is daytime, wakeup cpu for keeping connecntion");
    a(paramContext, localAlarmManager, localPendingIntent, l1);
  }

  private static void b(Context paramContext, AlarmManager paramAlarmManager, PendingIntent paramPendingIntent, long paramLong)
  {
    paramAlarmManager.cancel(paramPendingIntent);
    paramAlarmManager.setRepeating(3, paramLong + 1000 * l, 1000 * l, paramPendingIntent);
  }

  private String c()
  {
    if (this.j.startsWith("arm"))
      return "armeabi/";
    return this.j + "/";
  }

  private String d()
    throws IOException
  {
    InputStream localInputStream = null;
    File localFile = new File(this.i.getFilesDir(), "DaemonServer");
    if (localFile.exists())
      localFile.delete();
    Log.w(f, "open assets from = " + c() + "DaemonServer");
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    try
    {
      boolean bool = this.e;
      localInputStream = null;
      if (bool)
      {
        localInputStream = this.i.getAssets().open(c() + "DaemonServer");
        byte[] arrayOfByte = new byte[100];
        while (true)
        {
          int i1 = localInputStream.read(arrayOfByte);
          if (i1 <= 0)
            break;
          localFileOutputStream.write(arrayOfByte, 0, i1);
        }
      }
    }
    catch (Exception localException)
    {
      Log.e(f, "error in copy daemon files", localException);
      if (localInputStream != null);
      try
      {
        localInputStream.close();
      }
      catch (IOException localIOException4)
      {
        try
        {
          while (true)
          {
            localFileOutputStream.close();
            while (true)
            {
              return localFile.getCanonicalPath();
              a(localFileOutputStream);
              if (localInputStream != null);
              try
              {
                localInputStream.close();
                try
                {
                  localFileOutputStream.close();
                }
                catch (IOException localIOException5)
                {
                  Log.e(f, "error in close io", localIOException5);
                }
              }
              catch (IOException localIOException6)
              {
                while (true)
                  Log.e(f, "error in close input file", localIOException6);
              }
            }
            localIOException4 = localIOException4;
            Log.e(f, "error in close input file", localIOException4);
          }
        }
        catch (IOException localIOException3)
        {
          while (true)
            Log.e(f, "error in close io", localIOException3);
        }
      }
    }
    finally
    {
      if (localInputStream == null);
    }
    try
    {
      localInputStream.close();
    }
    catch (IOException localIOException2)
    {
      try
      {
        while (true)
        {
          localFileOutputStream.close();
          throw localObject;
          localIOException2 = localIOException2;
          Log.e(f, "error in close input file", localIOException2);
        }
      }
      catch (IOException localIOException1)
      {
        while (true)
          Log.e(f, "error in close io", localIOException1);
      }
    }
  }

  private String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = "/data/data/" + this.i.getPackageName();
    localStringBuilder.append("-s \"" + str1 + "/lib/" + "\" ");
    localStringBuilder.append("-n \"runServer\" ");
    localStringBuilder.append("-p \"" + i() + "\" ");
    localStringBuilder.append("-f \"" + str1 + "\" ");
    localStringBuilder.append("-t \"" + k + "\" ");
    localStringBuilder.append("-c \"agoo.pid\" ");
    if (this.r != null)
      localStringBuilder.append("-P " + this.r + " ");
    if (this.p != null)
      localStringBuilder.append("-K " + this.p + " ");
    if (this.q != null)
      localStringBuilder.append("-U " + this.q + " ");
    if (this.w != null)
      localStringBuilder.append("-L " + this.w + " ");
    localStringBuilder.append("-D " + h() + " ");
    if (this.v != null)
      localStringBuilder.append("-I " + this.v + " ");
    if (this.x > 0)
      localStringBuilder.append("-O " + this.x + " ");
    String str2 = f();
    String str3 = g();
    if ((str2 != null) && (!str2.isEmpty()))
    {
      localStringBuilder.append("-X " + str2 + " ");
      localStringBuilder.append("-Y " + str3 + " ");
    }
    if (this.y)
      localStringBuilder.append("-T ");
    localStringBuilder.append("-Z ");
    return localStringBuilder.toString();
  }

  private static String f()
  {
    if (Build.VERSION.SDK_INT < 11)
      return Proxy.getDefaultHost();
    return System.getProperty("http.proxyHost");
  }

  private static String g()
  {
    if (Build.VERSION.SDK_INT < 11)
      return String.valueOf(Proxy.getDefaultPort());
    return System.getProperty("http.proxyPort");
  }

  private String h()
  {
    String str1 = "{\"package\":\"" + this.i.getPackageName() + "\",\"appKey\":\"" + this.s + "\",\"utdid\":\"" + this.t + "\",\"sdkVersion\":\"" + this.u + "\"}";
    try
    {
      String str2 = URLEncoder.encode(str1, "UTF-8");
      return str2;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return str1;
  }

  private String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startservice -a {packname}.intent.action.COCKROACH --es cockroach cockroach-PPreotect --es pack {packname}".replaceAll("\\{packname\\}", this.i.getApplicationContext().getPackageName()));
    if (Build.VERSION.SDK_INT > 15)
      localStringBuilder.append(" --user 0");
    return localStringBuilder.toString();
  }

  public void a()
  {
    a(a.G(this.i));
  }

  public void a(int paramInt)
  {
    if (paramInt > 0)
      k = paramInt;
    Log.d(f, "api level is:" + Build.VERSION.SDK_INT);
    b(this.i);
    if (Build.VERSION.SDK_INT < 20);
    try
    {
      a(d());
      aq.n(this.i);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  public void b()
  {
    File localFile = new File("/data/data/" + this.i.getPackageName(), "daemonserver.pid");
    if (localFile.exists())
      localFile.delete();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.by
 * JD-Core Version:    0.6.0
 */