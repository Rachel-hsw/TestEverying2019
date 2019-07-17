package com.umeng.message.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.umeng.b.a.a;
import com.umeng.message.ElectionReceiver;
import com.umeng.message.PushAgent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class dl
{
  public static final String a = System.getProperty("line.separator");
  private static final String b = "helper";

  public static String a()
  {
    return a(new Date());
  }

  public static String a(Context paramContext, int paramInt)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localList == null)
      return "";
    Iterator localIterator = localList.iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      if (!localIterator.hasNext())
        return "";
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    }
    while (localRunningAppProcessInfo.pid != paramInt);
    return localRunningAppProcessInfo.processName;
  }

  public static String a(Context paramContext, long paramLong)
  {
    if (paramLong < 1000L)
      return (int)paramLong + "B";
    if (paramLong < 1000000L)
      return Math.round((float)paramLong / 1000.0D) + "K";
    if (paramLong < 1000000000L)
      return new DecimalFormat("#0.0").format((float)paramLong / 1000000.0D) + "M";
    return new DecimalFormat("#0.00").format((float)paramLong / 1000000000.0D) + "G";
  }

  public static String a(File paramFile)
  {
    byte[] arrayOfByte = new byte[1024];
    try
    {
      boolean bool = paramFile.isFile();
      if (!bool)
        return "";
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      while (true)
      {
        int i = localFileInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1)
        {
          localFileInputStream.close();
          return String.format("%1$032x", new Object[] { new BigInteger(1, localMessageDigest.digest()) });
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static String a(Object paramObject)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramObject);
      String str = new String(dh.c(localByteArrayOutputStream.toByteArray()));
      return str;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public static String a(String paramString)
  {
    int i = 0;
    if (paramString == null)
      return null;
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(arrayOfByte1);
      byte[] arrayOfByte2 = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer();
      while (true)
      {
        if (i >= arrayOfByte2.length)
          return localStringBuffer.toString();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(arrayOfByte2[i]);
        localStringBuffer.append(String.format("%02X", arrayOfObject));
        i++;
      }
    }
    catch (Exception localException)
    {
    }
    return paramString.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
  }

  public static String a(Date paramDate)
  {
    if (paramDate == null)
      return "";
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramDate);
  }

  public static void a(Context paramContext, Class<?> paramClass)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null)
        return;
      if (localPackageManager.getApplicationEnabledSetting(paramContext.getPackageName()) > -1)
      {
        ComponentName localComponentName = new ComponentName(paramContext, paramClass);
        int i = localPackageManager.getComponentEnabledSetting(localComponentName);
        if ((i != 1) && (i != 0))
        {
          localPackageManager.setComponentEnabledSetting(localComponentName, 1, 1);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(Context paramContext, String paramString)
  {
    paramContext.startActivity(paramContext.getPackageManager().getLaunchIntentForPackage(paramString));
  }

  public static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null);
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static boolean a(Context paramContext)
  {
    try
    {
      List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (localList == null)
        return false;
      String str = paramContext.getPackageName();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.importance != 100)
          continue;
        boolean bool = localRunningAppProcessInfo.processName.equals(str);
        if (bool)
          return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  public static boolean a(Context paramContext, Handler paramHandler)
  {
    if (!PushAgent.getInstance(paramContext).isPushCheck())
      return true;
    while (true)
    {
      String str;
      int i17;
      int i18;
      int i19;
      int i20;
      int i21;
      int i22;
      int i23;
      int i24;
      int i25;
      int i26;
      int i27;
      int i29;
      try
      {
        if (!TextUtils.isEmpty(PushAgent.getInstance(paramContext).getMessageAppkey()))
          continue;
        paramHandler.post(new dm(paramContext));
        return false;
        if (!TextUtils.isEmpty(PushAgent.getInstance(paramContext).getMessageSecret()))
          continue;
        paramHandler.post(new dp(paramContext));
        return false;
        localObject1 = "";
        Intent localIntent1 = new Intent();
        localIntent1.setClassName(paramContext.getPackageName(), "com.umeng.message.NotificationProxyBroadcastReceiver");
        Iterator localIterator1 = paramContext.getPackageManager().queryBroadcastReceivers(localIntent1, 65536).iterator();
        if (localIterator1.hasNext())
          continue;
        int i = 0;
        if (i != 0)
          continue;
        paramHandler.post(new dv(paramContext));
        return false;
        ResolveInfo localResolveInfo13 = (ResolveInfo)localIterator1.next();
        if ((!localResolveInfo13.activityInfo.name.equals("com.umeng.message.NotificationProxyBroadcastReceiver")) || (!TextUtils.equals(localResolveInfo13.activityInfo.processName, paramContext.getPackageName())) || (localResolveInfo13.activityInfo.exported))
          continue;
        i = 1;
        continue;
        Intent localIntent2 = new Intent();
        localIntent2.setPackage(paramContext.getPackageName());
        localIntent2.setAction("android.intent.action.BOOT_COMPLETED");
        Iterator localIterator2 = paramContext.getPackageManager().queryBroadcastReceivers(localIntent2, 64).iterator();
        if (localIterator2.hasNext())
          continue;
        int j = 0;
        Object localObject2 = localObject1;
        if (j != 0)
          continue;
        paramHandler.post(new dw(paramContext));
        return false;
        ResolveInfo localResolveInfo12 = (ResolveInfo)localIterator2.next();
        if (!localResolveInfo12.activityInfo.name.equals("com.umeng.message.SystemReceiver"))
          continue;
        str = localResolveInfo12.activityInfo.processName;
        if ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, paramContext.getPackageName())))
          break label3154;
        localObject2 = str;
        j = 1;
        continue;
        Intent localIntent3 = new Intent();
        localIntent3.setPackage(paramContext.getPackageName());
        localIntent3.setAction("android.net.conn.CONNECTIVITY_CHANGE");
        Iterator localIterator3 = paramContext.getPackageManager().queryBroadcastReceivers(localIntent3, 64).iterator();
        if (localIterator3.hasNext())
          continue;
        int k = 0;
        if (k != 0)
          continue;
        paramHandler.post(new dy(paramContext));
        return false;
        ResolveInfo localResolveInfo11 = (ResolveInfo)localIterator3.next();
        if ((!localResolveInfo11.activityInfo.name.equals("com.umeng.message.SystemReceiver")) || (!TextUtils.equals(localObject2, localResolveInfo11.activityInfo.processName)))
          continue;
        k = 1;
        continue;
        Intent localIntent4 = new Intent();
        localIntent4.setPackage(paramContext.getPackageName());
        localIntent4.setAction("android.intent.action.PACKAGE_REMOVED");
        localIntent4.setData(Uri.parse("package:"));
        Iterator localIterator4 = paramContext.getPackageManager().queryBroadcastReceivers(localIntent4, 64).iterator();
        if (localIterator4.hasNext())
          continue;
        int m = 0;
        if (m != 0)
          continue;
        paramHandler.post(new dz(paramContext));
        return false;
        if (!((ResolveInfo)localIterator4.next()).activityInfo.name.equals("com.umeng.message.SystemReceiver"))
          continue;
        m = 1;
        continue;
        Intent localIntent5 = new Intent();
        localIntent5.setPackage(paramContext.getPackageName());
        localIntent5.setAction("org.agoo.android.intent.action.RECEIVE");
        Iterator localIterator5 = paramContext.getPackageManager().queryBroadcastReceivers(localIntent5, 64).iterator();
        if (localIterator5.hasNext())
          continue;
        int n = 0;
        if (n != 0)
          continue;
        paramHandler.post(new ea(paramContext));
        return false;
        ResolveInfo localResolveInfo10 = (ResolveInfo)localIterator5.next();
        if ((!localResolveInfo10.activityInfo.name.equals("com.umeng.message.MessageReceiver")) || (!TextUtils.equals(localObject2, localResolveInfo10.activityInfo.processName)))
          continue;
        n = 1;
        continue;
        b(paramContext, ElectionReceiver.class);
        Intent localIntent6 = new Intent();
        localIntent6.setPackage(paramContext.getPackageName());
        localIntent6.setAction("org.agoo.android.intent.action.ELECTION_RESULT_V4");
        localIntent6.addCategory("umeng");
        Iterator localIterator6 = paramContext.getPackageManager().queryBroadcastReceivers(localIntent6, 64).iterator();
        if (localIterator6.hasNext())
          continue;
        int i1 = 0;
        if (i1 != 0)
          continue;
        paramHandler.post(new eb(paramContext));
        return false;
        ResolveInfo localResolveInfo9 = (ResolveInfo)localIterator6.next();
        if ((!localResolveInfo9.activityInfo.name.equals("com.umeng.message.ElectionReceiver")) || (!TextUtils.equals(localObject2, localResolveInfo9.activityInfo.processName)))
          continue;
        i1 = 1;
        continue;
        Intent localIntent7 = new Intent();
        localIntent7.setPackage(paramContext.getPackageName());
        Iterator localIterator7 = paramContext.getPackageManager().queryBroadcastReceivers(localIntent7, 64).iterator();
        if (localIterator7.hasNext())
          continue;
        int i2 = 0;
        if (i2 != 0)
          continue;
        paramHandler.post(new ec(paramContext));
        return false;
        ResolveInfo localResolveInfo8 = (ResolveInfo)localIterator7.next();
        if ((!localResolveInfo8.activityInfo.name.equals("com.umeng.message.RegistrationReceiver")) || (localResolveInfo8.activityInfo.exported))
          continue;
        i2 = 1;
        continue;
        Intent localIntent8 = new Intent();
        localIntent8.setPackage(paramContext.getPackageName());
        localIntent8.setAction(paramContext.getPackageName() + ".intent.action.COMMAND");
        Iterator localIterator8 = paramContext.getPackageManager().queryBroadcastReceivers(localIntent8, 64).iterator();
        if (localIterator8.hasNext())
          continue;
        int i3 = 0;
        if (i3 != 0)
          continue;
        paramHandler.post(new dx(paramContext));
        return false;
        ResolveInfo localResolveInfo7 = (ResolveInfo)localIterator8.next();
        if ((!localResolveInfo7.activityInfo.name.equals("com.umeng.message.RegistrationReceiver")) || (localResolveInfo7.activityInfo.exported))
          continue;
        i3 = 1;
        continue;
        Intent localIntent9 = new Intent();
        localIntent9.setPackage(paramContext.getPackageName());
        localIntent9.setAction("android.intent.action.BOOT_COMPLETED");
        Iterator localIterator9 = paramContext.getPackageManager().queryBroadcastReceivers(localIntent9, 64).iterator();
        if (localIterator9.hasNext())
          continue;
        int i4 = 0;
        if (i4 != 0)
          continue;
        paramHandler.post(new ed(paramContext));
        return false;
        if (!((ResolveInfo)localIterator9.next()).activityInfo.name.equals("com.umeng.message.UmengMessageBootReceiver"))
          continue;
        i4 = 1;
        continue;
        Intent localIntent10 = new Intent();
        localIntent10.setPackage(paramContext.getPackageName());
        Iterator localIterator10 = paramContext.getPackageManager().queryIntentServices(localIntent10, 64).iterator();
        if (localIterator10.hasNext())
          continue;
        int i5 = 0;
        if (i5 != 0)
          continue;
        paramHandler.post(new ee(paramContext));
        return false;
        ResolveInfo localResolveInfo6 = (ResolveInfo)localIterator10.next();
        if ((!localResolveInfo6.serviceInfo.name.equals("com.umeng.message.UmengService")) || (!TextUtils.equals(localObject2, localResolveInfo6.serviceInfo.processName)) || (!localResolveInfo6.serviceInfo.exported))
          continue;
        i5 = 1;
        continue;
        Intent localIntent11 = new Intent();
        localIntent11.setPackage(paramContext.getPackageName());
        localIntent11.setAction(paramContext.getPackageName() + ".intent.action.START");
        Iterator localIterator11 = paramContext.getPackageManager().queryIntentServices(localIntent11, 64).iterator();
        if (localIterator11.hasNext())
          continue;
        int i6 = 0;
        if (i6 != 0)
          continue;
        paramHandler.post(new ef(paramContext));
        return false;
        ResolveInfo localResolveInfo5 = (ResolveInfo)localIterator11.next();
        if ((!localResolveInfo5.serviceInfo.name.equals("com.umeng.message.UmengService")) || (!TextUtils.equals(localObject2, localResolveInfo5.serviceInfo.processName)) || (!localResolveInfo5.serviceInfo.exported))
          continue;
        i6 = 1;
        continue;
        Intent localIntent12 = new Intent();
        localIntent12.setPackage(paramContext.getPackageName());
        localIntent12.setAction(paramContext.getPackageName() + ".intent.action.COCKROACH");
        Iterator localIterator12 = paramContext.getPackageManager().queryIntentServices(localIntent12, 64).iterator();
        if (localIterator12.hasNext())
          continue;
        int i7 = 0;
        if (i7 != 0)
          continue;
        paramHandler.post(new eg(paramContext));
        return false;
        ResolveInfo localResolveInfo4 = (ResolveInfo)localIterator12.next();
        if ((!localResolveInfo4.serviceInfo.name.equals("com.umeng.message.UmengService")) || (!TextUtils.equals(localObject2, localResolveInfo4.serviceInfo.processName)) || (!localResolveInfo4.serviceInfo.exported))
          continue;
        i7 = 1;
        continue;
        Intent localIntent13 = new Intent();
        localIntent13.addCategory("umeng");
        localIntent13.setPackage(paramContext.getPackageName());
        localIntent13.setAction("org.agoo.android.intent.action.PING_V4");
        Iterator localIterator13 = paramContext.getPackageManager().queryIntentServices(localIntent13, 64).iterator();
        if (localIterator13.hasNext())
          continue;
        int i8 = 0;
        if (i8 != 0)
          continue;
        paramHandler.post(new eh(paramContext));
        return false;
        if (!((ResolveInfo)localIterator13.next()).serviceInfo.name.equals("com.umeng.message.UmengService"))
          continue;
        i8 = 1;
        continue;
        Intent localIntent14 = new Intent();
        localIntent14.setClassName(paramContext.getPackageName(), "com.umeng.message.UmengIntentService");
        Iterator localIterator14 = paramContext.getPackageManager().queryIntentServices(localIntent14, 65536).iterator();
        if (localIterator14.hasNext())
          continue;
        int i9 = 0;
        if (i9 != 0)
          continue;
        paramHandler.post(new ei(paramContext));
        return false;
        ResolveInfo localResolveInfo3 = (ResolveInfo)localIterator14.next();
        if ((!localResolveInfo3.serviceInfo.name.equals("com.umeng.message.UmengIntentService")) || (!TextUtils.equals(localObject2, localResolveInfo3.serviceInfo.processName)))
          continue;
        i9 = 1;
        continue;
        Intent localIntent15 = new Intent();
        localIntent15.setPackage(paramContext.getPackageName());
        localIntent15.setAction("org.android.agoo.client.MessageReceiverService");
        Iterator localIterator15 = paramContext.getPackageManager().queryIntentServices(localIntent15, 64).iterator();
        if (localIterator15.hasNext())
          continue;
        int i10 = 0;
        if (i10 != 0)
          continue;
        paramHandler.post(new ej(paramContext));
        return false;
        ResolveInfo localResolveInfo2 = (ResolveInfo)localIterator15.next();
        if ((!localResolveInfo2.serviceInfo.name.equals("com.umeng.message.UmengMessageIntentReceiverService")) || (!TextUtils.equals(localObject2, localResolveInfo2.serviceInfo.processName)) || (!localResolveInfo2.serviceInfo.exported))
          continue;
        i10 = 1;
        continue;
        Intent localIntent16 = new Intent();
        localIntent16.setPackage(paramContext.getPackageName());
        localIntent16.setAction("org.android.agoo.client.ElectionReceiverService");
        Iterator localIterator16 = paramContext.getPackageManager().queryIntentServices(localIntent16, 64).iterator();
        if (localIterator16.hasNext())
          continue;
        int i11 = 0;
        if (i11 != 0)
          continue;
        paramHandler.post(new dn(paramContext));
        return false;
        if (!((ResolveInfo)localIterator16.next()).serviceInfo.name.equals("com.umeng.message.UmengMessageIntentReceiverService"))
          continue;
        i11 = 1;
        continue;
        Intent localIntent17 = new Intent();
        localIntent17.setPackage(paramContext.getPackageName());
        localIntent17.setAction("com.umeng.messge.registercallback.action");
        Iterator localIterator17 = paramContext.getPackageManager().queryIntentServices(localIntent17, 64).iterator();
        if (localIterator17.hasNext())
          continue;
        int i12 = 0;
        if (i12 != 0)
          continue;
        paramHandler.post(new do(paramContext));
        return false;
        ResolveInfo localResolveInfo1 = (ResolveInfo)localIterator17.next();
        if ((!localResolveInfo1.serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService")) || (!TextUtils.equals(paramContext.getPackageName(), localResolveInfo1.serviceInfo.processName)) || (localResolveInfo1.serviceInfo.exported))
          continue;
        i12 = 1;
        continue;
        Intent localIntent18 = new Intent();
        localIntent18.setPackage(paramContext.getPackageName());
        localIntent18.setAction("com.umeng.message.unregistercallback.action");
        Iterator localIterator18 = paramContext.getPackageManager().queryIntentServices(localIntent18, 64).iterator();
        if (localIterator18.hasNext())
          continue;
        int i13 = 0;
        if (i13 != 0)
          continue;
        paramHandler.post(new dq(paramContext));
        return false;
        if (!((ResolveInfo)localIterator18.next()).serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService"))
          continue;
        i13 = 1;
        continue;
        Intent localIntent19 = new Intent();
        localIntent19.setPackage(paramContext.getPackageName());
        localIntent19.setAction("com.umeng.message.message.handler.action");
        Iterator localIterator19 = paramContext.getPackageManager().queryIntentServices(localIntent19, 64).iterator();
        if (localIterator19.hasNext())
          continue;
        int i14 = 0;
        if (i14 != 0)
          continue;
        paramHandler.post(new dr(paramContext));
        return false;
        if (!((ResolveInfo)localIterator19.next()).serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService"))
          continue;
        i14 = 1;
        continue;
        Intent localIntent20 = new Intent();
        localIntent20.setPackage(paramContext.getPackageName());
        localIntent20.setAction("com.umeng.message.autoupdate.handler.action");
        Iterator localIterator20 = paramContext.getPackageManager().queryIntentServices(localIntent20, 64).iterator();
        if (localIterator20.hasNext())
          continue;
        int i15 = 0;
        if (i15 != 0)
          continue;
        paramHandler.post(new ds(paramContext));
        return false;
        if (!((ResolveInfo)localIterator20.next()).serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService"))
          continue;
        i15 = 1;
        continue;
        Intent localIntent21 = new Intent();
        localIntent21.setClassName(paramContext.getPackageName(), "com.umeng.message.UmengDownloadResourceService");
        Iterator localIterator21 = paramContext.getPackageManager().queryIntentServices(localIntent21, 65536).iterator();
        if (localIterator21.hasNext())
          continue;
        int i16 = 0;
        if (i16 != 0)
          continue;
        paramHandler.post(new dt(paramContext));
        return false;
        if (!((ResolveInfo)localIterator21.next()).serviceInfo.name.equals("com.umeng.message.UmengDownloadResourceService"))
          continue;
        i16 = 1;
        continue;
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096);
        String[] arrayOfString = localPackageInfo.requestedPermissions;
        i17 = 0;
        i18 = 0;
        i19 = 0;
        i20 = 0;
        i21 = 0;
        i22 = 0;
        i23 = 0;
        i24 = 0;
        i25 = 0;
        i26 = 0;
        i27 = 0;
        if (arrayOfString == null)
          break label3160;
        i29 = 0;
        if (i29 < localPackageInfo.requestedPermissions.length)
          continue;
        break label3160;
        if (i28 == 0)
        {
          paramHandler.post(new du(paramContext));
          return false;
          if (!"android.permission.WRITE_SETTINGS".equals(localPackageInfo.requestedPermissions[i29]))
            continue;
          i27 = 1;
          break label3221;
          if (!"android.permission.INTERNET".equals(localPackageInfo.requestedPermissions[i29]))
            continue;
          i26 = 1;
          break label3221;
          if (!"android.permission.ACCESS_WIFI_STATE".equals(localPackageInfo.requestedPermissions[i29]))
            continue;
          i24 = 1;
          break label3221;
          if (!"android.permission.ACCESS_NETWORK_STATE".equals(localPackageInfo.requestedPermissions[i29]))
            continue;
          i25 = 1;
          break label3221;
          if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(localPackageInfo.requestedPermissions[i29]))
            continue;
          i23 = 1;
          break label3221;
          if (!"android.permission.WAKE_LOCK".equals(localPackageInfo.requestedPermissions[i29]))
            continue;
          i22 = 1;
          break label3221;
          if (!"android.permission.READ_PHONE_STATE".equals(localPackageInfo.requestedPermissions[i29]))
            continue;
          i21 = 1;
          break label3221;
          if (!"android.permission.CHANGE_NETWORK_STATE".equals(localPackageInfo.requestedPermissions[i29]))
            continue;
          i20 = 1;
          break label3221;
          if (!"android.permission.CHANGE_WIFI_STATE".equals(localPackageInfo.requestedPermissions[i29]))
            continue;
          i19 = 1;
          break label3221;
          if (!"android.permission.GET_TASKS".equals(localPackageInfo.requestedPermissions[i29]))
            continue;
          i18 = 1;
          break label3221;
          boolean bool = "android.permission.RECEIVE_BOOT_COMPLETED".equals(localPackageInfo.requestedPermissions[i29]);
          if (!bool)
            break label3221;
          i17 = 1;
          break label3221;
          i28 = 0;
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return true;
      label3154: Object localObject1 = str;
      continue;
      label3160: if ((i27 == 0) || (i26 == 0) || (i24 == 0) || (i25 == 0) || (i23 == 0) || (i22 == 0) || (i21 == 0) || (i20 == 0) || (i19 == 0) || (i18 == 0) || (i17 == 0))
        continue;
      int i28 = 1;
      continue;
      label3221: i29++;
    }
  }

  public static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 == i)
        return localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }

  public static String b()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public static String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0; ; i++)
      {
        if (i >= arrayOfByte.length)
          return localStringBuffer.toString();
        localStringBuffer.append(Integer.toHexString(0xFF & arrayOfByte[i]));
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      a.a("helper", "getMD5 error", localNoSuchAlgorithmException);
    }
    return "";
  }

  public static final void b(Context paramContext, Class<?> paramClass)
  {
    if (paramContext != null);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (paramClass == null);
      while (true)
      {
        return;
        try
        {
          ComponentName localComponentName = new ComponentName(paramContext, paramClass);
          if (localPackageManager.getComponentEnabledSetting(localComponentName) != 2)
            continue;
          a.c("helper", "rebootReceiver[" + localComponentName.toString() + "]--->[ENABLED]");
          localPackageManager.setComponentEnabledSetting(localComponentName, 1, 1);
          return;
        }
        catch (Throwable localThrowable2)
        {
          return;
        }
      }
    }
    catch (Throwable localThrowable1)
    {
    }
  }

  public static void b(InputStream paramInputStream)
  {
    if (paramInputStream != null);
    try
    {
      paramInputStream.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static boolean b(Context paramContext)
  {
    String str = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName();
    return (str != null) && (str.equals(paramContext.getPackageName()));
  }

  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  public static String c(String paramString)
  {
    long l;
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l < 1024L)
        return (int)l + "B";
    }
    catch (NumberFormatException localNumberFormatException)
    {
      return paramString;
    }
    if (l < 1048576L)
      return new DecimalFormat("#0.00").format((float)l / 1024.0D) + "K";
    if (l < 1073741824L)
      return new DecimalFormat("#0.00").format((float)l / 1048576.0D) + "M";
    return new DecimalFormat("#0.00").format((float)l / 1073741824.0D) + "G";
  }

  public static boolean c(Context paramContext)
  {
    return paramContext.getPackageManager().checkPermission("android.permission.GET_TASKS", paramContext.getPackageName()) == 0;
  }

  public static boolean c(Context paramContext, String paramString)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
    if ((localList == null) || (localList.isEmpty()));
    while (true)
    {
      return false;
      for (int i = 0; i < localList.size(); i++)
        if ((((ActivityManager.RunningServiceInfo)localList.get(i)).service.getClassName().equals(paramString)) && (TextUtils.equals(((ActivityManager.RunningServiceInfo)localList.get(i)).service.getPackageName(), paramContext.getPackageName())))
          return true;
    }
  }

  public static boolean d(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }

  public static boolean e(String paramString)
  {
    if (d(paramString));
    String str;
    do
    {
      return false;
      str = paramString.trim().toLowerCase(Locale.US);
    }
    while ((!str.startsWith("http://")) && (!str.startsWith("https://")));
    return true;
  }

  public static Object f(String paramString)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(dh.h(paramString.getBytes()));
    try
    {
      ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
      try
      {
        Object localObject = localObjectInputStream.readObject();
        return localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        return null;
      }
    }
    catch (StreamCorruptedException localStreamCorruptedException)
    {
      localStreamCorruptedException.printStackTrace();
      return null;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.dl
 * JD-Core Version:    0.6.0
 */