package org.android.agoo.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.b.af;
import com.umeng.message.b.af.a;
import com.umeng.message.b.am;
import com.umeng.message.b.ao;
import com.umeng.message.b.ap;
import com.umeng.message.b.aq;
import com.umeng.message.b.ar;
import com.umeng.message.b.ay;
import com.umeng.message.b.bk;
import com.umeng.message.b.bq;
import com.umeng.message.b.ce;
import com.umeng.message.b.cm;
import com.umeng.message.b.cn;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.android.agoo.c.c.b;
import org.android.agoo.c.c.d;
import org.android.agoo.c.c.h;
import org.android.agoo.c.c.i;
import org.android.agoo.service.AgooService;
import org.json.JSONException;
import org.json.JSONObject;

public final class ControlService
  implements org.android.agoo.a
{
  private static final String a = "SERVICE_NOT_AVAILABLE";
  private static final String b = "HAS_RETTY_REGISTER";
  private static final String c = "org.rome.android.ipp.intent.action.PINGA";
  private static final String d = "ControlService";
  private static final Random e = new Random();
  private static final int f = 5;
  private static final int g = 10000;
  private static final String h = "4";
  private static final b j = new h();
  private Context i = null;
  private final ServiceConnection k = new ControlService.1(this);
  private final ServiceConnection l = new ControlService.2(this);

  private final String a(Context paramContext, long paramLong)
  {
    try
    {
      localbk = new bk(paramContext);
      String str3 = localbk.f();
      str2 = str3;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        bk localbk;
        String str2;
        String str4 = localbk.c();
        str1 = str4;
        while (true)
        {
          if (TextUtils.isEmpty(str2))
            str2 = "unknow";
          if (TextUtils.isEmpty(str1))
            str1 = "unknow";
          StringBuffer localStringBuffer = new StringBuffer();
          localStringBuffer.append(af.f(paramContext));
          localStringBuffer.append("|");
          localStringBuffer.append(paramLong);
          localStringBuffer.append("|");
          localStringBuffer.append(System.currentTimeMillis());
          localStringBuffer.append("|");
          localStringBuffer.append(str2);
          localStringBuffer.append("|");
          localStringBuffer.append(str1);
          return localStringBuffer.toString();
          localThrowable1 = localThrowable1;
          str1 = null;
          str2 = null;
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
          String str1 = null;
      }
    }
  }

  private final void a(Context paramContext)
  {
    try
    {
      Intent localIntent = org.android.agoo.b.a.a(paramContext, "register_retry");
      localIntent.setPackage(paramContext.getPackageName());
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 1073741824);
      ((AlarmManager)paramContext.getSystemService("alarm")).cancel(localPendingIntent);
      localPendingIntent.cancel();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private final void a(Context paramContext, Intent paramIntent)
  {
    if (af.m(paramContext))
      return;
    af.t(paramContext);
    e(paramContext);
  }

  private final void a(Context paramContext, Intent paramIntent, String paramString, org.android.agoo.a.a parama)
  {
    try
    {
      String str = new JSONObject(paramString).getString("device_id");
      if (TextUtils.isEmpty(str))
      {
        a(paramContext, "SERVICE_NOT_AVAILABLE", parama);
        return;
      }
      af.b(paramContext, str);
      af.s(paramContext);
      af.y(paramContext);
      ar.a(paramContext, parama.callAgooElectionReceiver());
      b(paramContext);
      aq.i(paramContext);
      j(paramContext, paramIntent, parama);
      return;
    }
    catch (Throwable localThrowable)
    {
      a(paramContext, "SERVICE_NOT_AVAILABLE", parama);
      aq.h(paramContext, "data_parse_error");
    }
  }

  private final void a(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    if (!a(paramContext, parama))
    {
      ay.c("ControlService", "handleWake[" + paramContext.getPackageName() + "]--->[appkey==null,appSecret==null,ttid==null]");
      return;
    }
    if (!af.m(paramContext))
    {
      int m = af.u(paramContext);
      StringBuilder localStringBuilder = new StringBuilder().append("handleRetryRegister begin,retryCount = ").append(m).append("isRetryRegister=");
      if (m < 3);
      for (boolean bool = true; ; bool = false)
      {
        Log.d("ControlService", bool);
        if (m >= 3)
          break;
        a(paramContext, paramIntent);
        return;
      }
    }
    if (!bk.a(paramContext))
    {
      ay.c("ControlService", "connectManager[network connectedOrConnecting failed]");
      return;
    }
    String str1 = paramContext.getPackageName();
    String str2 = ar.a(paramContext);
    bq localbq = new bq(this.i, "handleWake");
    LinkedHashMap localLinkedHashMap = org.android.a.B(this.i);
    localLinkedHashMap.put("currentSudoPack", str2);
    localbq.a(localLinkedHashMap);
    aq.c(paramContext, str2, "handleWake");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (TextUtils.equals(str1, str2)))
    {
      a(paramContext, str1, str2, parama, "handleWake");
      return;
    }
    b(paramContext, "handleWake");
  }

  private final void a(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama, String paramString, boolean paramBoolean)
  {
    if ((af.m(paramContext)) && (a(paramContext, parama)))
    {
      String str = af.n(paramContext);
      d locald = new d();
      locald.c("mtop.push.device.reportKickAss");
      locald.d("4.0");
      locald.b(af.h(paramContext));
      locald.a(str);
      locald.a("app_version", af.a(paramContext));
      locald.a("sdk_version", Long.valueOf(af.a()));
      locald.a("app_pack", paramString);
      locald.a("app_replace", Boolean.valueOf(paramBoolean));
      i locali = j.a(paramContext, locald);
      ay.c("ControlService", "uninstall--->[result:" + locali.c() + "]");
      a(paramContext, paramIntent, parama, locali);
    }
  }

  private final void a(Context paramContext, String paramString)
  {
    ar.a(paramContext, paramString);
  }

  private final void a(Context paramContext, String paramString1, String paramString2, org.android.agoo.a.a parama)
  {
    Class localClass = parama.callAgooService();
    ay.c("ControlService", "restart---->[currentSudoPack:" + paramString2 + "][currentPack:" + paramString1 + "]:[stop]");
    if (a(localClass))
    {
      ay.c("ControlService", "disableService---->[" + paramString1 + "/" + parama.callAgooService() + "]");
      ao.a(paramContext, parama.callAgooService());
    }
    ap.a(paramContext);
  }

  private final void a(Context paramContext, String paramString1, String paramString2, org.android.agoo.a.a parama, String paramString3)
  {
    Class localClass = parama.callAgooService();
    ay.c("ControlService", "restart---->[currentSudoPack:" + paramString2 + "]:[start]");
    if (a(localClass))
    {
      ay.c("ControlService", "enabledService---->[" + paramString1 + "/" + parama.callAgooService() + "]");
      ao.b(paramContext, parama.callAgooService());
    }
    ap.a(paramContext, paramString3);
  }

  private final void a(Context paramContext, String paramString, org.android.agoo.a.a parama)
  {
    try
    {
      if ("SERVICE_NOT_AVAILABLE".equals(paramString))
      {
        boolean bool = parama.callRecoverableError(paramContext, paramString);
        int m = af.r(paramContext);
        if ((bool) && (m < 5))
        {
          int n = m + 1;
          long l1 = System.currentTimeMillis() + e.nextInt(10000);
          ay.c("ControlService", "registerfailed retrying--->[" + n + "][" + ce.a(l1) + "]ms");
          af.a(paramContext, n);
          Intent localIntent = org.android.agoo.b.a.a(paramContext, "register_retry");
          localIntent.setPackage(paramContext.getPackageName());
          PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 1073741824);
          ((AlarmManager)paramContext.getSystemService("alarm")).set(1, l1, localPendingIntent);
          return;
        }
        ay.c("ControlService", "Not retrying failed operation[" + m + "]");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private final void a(Context paramContext, i parami, d paramd, String paramString)
  {
    String str1 = null;
    if (parami != null);
    try
    {
      String str2;
      String str3;
      if (parami.b())
      {
        str2 = "y";
        str3 = new JSONObject(parami.c()).getString("device_id");
      }
      while (true)
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("utdid=" + aq.c(paramContext));
        localStringBuffer.append("-->");
        localStringBuffer.append("appkey=" + af.f(paramContext));
        localStringBuffer.append("-->");
        localStringBuffer.append("startTime=" + ce.a(System.currentTimeMillis()));
        localStringBuffer.append("-->");
        localStringBuffer.append("ret=" + str2);
        localStringBuffer.append("-->");
        localStringBuffer.append("fail_reasons=" + str1);
        localStringBuffer.append("-->");
        localStringBuffer.append("deviceId=" + str3);
        localStringBuffer.append("-->");
        localStringBuffer.append("sdkVersion=" + af.a());
        localStringBuffer.append("-->");
        localStringBuffer.append("requestUrl=" + paramString);
        localStringBuffer.append("-->");
        localStringBuffer.append("actiontype=register");
        aq.d(paramContext, str2, localStringBuffer.toString());
        return;
        str2 = "n";
        if (parami != null)
        {
          str1 = parami.e();
          str3 = null;
          continue;
        }
        str1 = "fail_reasons == null";
        str3 = null;
      }
    }
    catch (Throwable localThrowable)
    {
      aq.d(paramContext, "n", localThrowable.toString());
    }
  }

  private final void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str1 = null;
    try
    {
      String str2 = org.android.a.g(paramContext);
      if (paramBoolean);
      for (String str3 = "y"; ; str3 = "n")
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("utdid=" + aq.c(paramContext));
        localStringBuffer.append("-->");
        localStringBuffer.append("appkey=" + af.f(paramContext));
        localStringBuffer.append("-->");
        localStringBuffer.append("startTime=" + ce.a(System.currentTimeMillis()));
        localStringBuffer.append("-->");
        localStringBuffer.append("ret=" + str3);
        localStringBuffer.append("-->");
        localStringBuffer.append("categries=" + paramString1);
        localStringBuffer.append("-->");
        localStringBuffer.append("currentPack=" + paramString2);
        localStringBuffer.append("-->");
        localStringBuffer.append("currentSudoPack=" + paramString3);
        localStringBuffer.append("-->");
        localStringBuffer.append("fail_reasons=" + paramString4);
        localStringBuffer.append("-->");
        localStringBuffer.append("deviceId=" + str2);
        localStringBuffer.append("-->");
        localStringBuffer.append("sdkVersion=" + af.a());
        localStringBuffer.append("-->");
        localStringBuffer.append("actiontype=getNoticeElectionTrace");
        str1 = localStringBuffer.toString();
        aq.j(paramContext, str1);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      aq.j(paramContext, str1);
    }
  }

  private final boolean a(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama, i parami)
  {
    String str = parami.e();
    if (!TextUtils.isEmpty(str))
    {
      ay.d("ControlService", "checkMtopResultFailed---->[" + str + "]");
      aq.h(paramContext, str);
      if (TextUtils.equals(str, "ERRCODE_AUTH_REJECT"))
      {
        Intent localIntent = org.android.agoo.b.a.a(paramContext, "error");
        localIntent.setPackage(paramContext.getPackageName());
        localIntent.putExtra("error", str);
        n(paramContext, localIntent, parama);
        return false;
      }
    }
    return true;
  }

  private final boolean a(Context paramContext, org.android.agoo.a.a parama)
  {
    String str1 = af.f(paramContext);
    String str2 = af.h(paramContext);
    Intent localIntent = org.android.agoo.b.a.a(paramContext, "error");
    localIntent.setPackage(paramContext.getPackageName());
    if (TextUtils.isEmpty(str1))
    {
      localIntent.putExtra("error", "ERROR_APPKEY_NULL");
      n(paramContext, localIntent, parama);
      return false;
    }
    if (TextUtils.isEmpty(str2))
    {
      localIntent.putExtra("error", "ERROR_TTID_NULL");
      n(paramContext, localIntent, parama);
      return false;
    }
    j.a(str1);
    String str3 = af.j(paramContext);
    if ((TextUtils.isEmpty(str3)) && (!af.E(paramContext)))
    {
      localIntent.putExtra("error", "ERROR_APPSECRET_NULL");
      return false;
    }
    j.b(str3);
    j.c(af.G(paramContext));
    return true;
  }

  private final boolean a(Class<?> paramClass)
  {
    return (paramClass != null) && (TextUtils.equals(paramClass.getSuperclass().getName(), AgooService.class.getName()));
  }

  private final void b(Context paramContext)
  {
    Intent localIntent = org.android.agoo.b.a.a(paramContext, "registration");
    localIntent.setPackage(paramContext.getPackageName());
    paramContext.sendBroadcast(localIntent);
  }

  // ERROR //
  private final void b(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 524
    //   4: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 49
    //   9: aload 49
    //   11: astore 5
    //   13: aload 5
    //   15: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +84 -> 102
    //   21: aload 5
    //   23: invokevirtual 530	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   26: ldc_w 532
    //   29: invokestatic 536	android/text/TextUtils:indexOf	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)I
    //   32: iconst_m1
    //   33: if_icmpne +69 -> 102
    //   36: aload_1
    //   37: invokestatic 256	com/umeng/message/b/ar:a	(Landroid/content/Context;)Ljava/lang/String;
    //   40: astore 51
    //   42: new 258	com/umeng/message/b/bq
    //   45: dup
    //   46: aload_0
    //   47: getfield 53	org/android/agoo/impl/ControlService:i	Landroid/content/Context;
    //   50: ldc_w 538
    //   53: invokespecial 262	com/umeng/message/b/bq:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   56: astore 52
    //   58: aload_0
    //   59: getfield 53	org/android/agoo/impl/ControlService:i	Landroid/content/Context;
    //   62: invokestatic 268	org/android/a:B	(Landroid/content/Context;)Ljava/util/LinkedHashMap;
    //   65: astore 53
    //   67: aload 53
    //   69: ldc_w 270
    //   72: aload 51
    //   74: invokevirtual 276	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: aload 52
    //   80: aload 53
    //   82: invokevirtual 279	com/umeng/message/b/bq:a	(Ljava/util/LinkedHashMap;)V
    //   85: aload_1
    //   86: aload 51
    //   88: ldc_w 538
    //   91: invokestatic 282	com/umeng/message/b/aq:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: aload_1
    //   96: ldc_w 538
    //   99: invokespecial 290	org/android/agoo/impl/ControlService:b	(Landroid/content/Context;Ljava/lang/String;)V
    //   102: aload_2
    //   103: ldc_w 540
    //   106: iconst_0
    //   107: invokevirtual 544	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   110: ifeq +4 -> 114
    //   113: return
    //   114: aload_1
    //   115: invokestatic 157	com/umeng/message/b/af:m	(Landroid/content/Context;)Z
    //   118: ifne +12 -> 130
    //   121: ldc 19
    //   123: ldc_w 546
    //   126: invokestatic 229	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: return
    //   130: aload_2
    //   131: ldc_w 548
    //   134: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 6
    //   139: aload_2
    //   140: ldc_w 550
    //   143: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   146: astore 7
    //   148: aload_2
    //   149: ldc_w 552
    //   152: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 8
    //   157: aload_0
    //   158: aload_1
    //   159: aload_2
    //   160: ldc_w 554
    //   163: ldc2_w 555
    //   166: invokevirtual 560	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   169: invokestatic 327	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   172: invokevirtual 563	java/lang/Long:longValue	()J
    //   175: invokespecial 565	org/android/agoo/impl/ControlService:a	(Landroid/content/Context;J)Ljava/lang/String;
    //   178: astore 48
    //   180: aload 48
    //   182: astore 10
    //   184: aload_2
    //   185: ldc_w 567
    //   188: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   191: astore 47
    //   193: aload 47
    //   195: astore 12
    //   197: aload 7
    //   199: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifeq +75 -> 277
    //   205: aload_2
    //   206: ldc_w 569
    //   209: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 46
    //   214: aload_1
    //   215: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   218: aload 6
    //   220: aload 12
    //   222: aload 46
    //   224: aload 5
    //   226: aload 10
    //   228: ldc_w 576
    //   231: ldc 29
    //   233: invokevirtual 579	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   236: ifeq +10 -> 246
    //   239: aload_2
    //   240: ldc_w 569
    //   243: invokevirtual 582	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   246: ldc 19
    //   248: ldc_w 584
    //   251: invokestatic 229	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload_1
    //   255: aload 6
    //   257: invokestatic 586	com/umeng/message/b/aq:e	(Landroid/content/Context;Ljava/lang/String;)V
    //   260: return
    //   261: astore 9
    //   263: aconst_null
    //   264: astore 10
    //   266: goto -82 -> 184
    //   269: astore 11
    //   271: aconst_null
    //   272: astore 12
    //   274: goto -77 -> 197
    //   277: aload_2
    //   278: ldc_w 588
    //   281: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   284: astore 18
    //   286: ldc_w 590
    //   289: aload 18
    //   291: invokestatic 286	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   294: ifeq +167 -> 461
    //   297: aload_1
    //   298: invokestatic 294	com/umeng/message/b/af:n	(Landroid/content/Context;)Ljava/lang/String;
    //   301: aload 7
    //   303: iconst_0
    //   304: invokestatic 595	com/umeng/message/b/ch:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   307: astore 44
    //   309: aload 44
    //   311: astore 19
    //   313: aload 19
    //   315: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   318: istore 21
    //   320: iload 21
    //   322: ifeq +247 -> 569
    //   325: aload_2
    //   326: ldc_w 569
    //   329: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   332: astore 42
    //   334: aload_1
    //   335: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   338: aload 6
    //   340: aload 12
    //   342: aload 42
    //   344: aload 5
    //   346: aload 10
    //   348: ldc_w 597
    //   351: ldc 29
    //   353: invokevirtual 579	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   356: ifeq +10 -> 366
    //   359: aload_2
    //   360: ldc_w 569
    //   363: invokevirtual 582	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   366: aload_1
    //   367: aload 6
    //   369: aload 19
    //   371: invokestatic 599	com/umeng/message/b/aq:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   374: return
    //   375: astore 20
    //   377: aload 19
    //   379: astore 15
    //   381: aload 20
    //   383: astore 14
    //   385: aload_2
    //   386: ldc_w 569
    //   389: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   392: astore 17
    //   394: aload_1
    //   395: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   398: aload 6
    //   400: aload 12
    //   402: aload 17
    //   404: aload 5
    //   406: aload 10
    //   408: ldc_w 597
    //   411: ldc 29
    //   413: invokevirtual 579	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   416: ifeq +10 -> 426
    //   419: aload_2
    //   420: ldc_w 569
    //   423: invokevirtual 582	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   426: ldc 19
    //   428: new 215	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   435: ldc_w 601
    //   438: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload 15
    //   443: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: ldc_w 348
    //   449: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: aload 14
    //   457: invokestatic 604	com/umeng/message/b/ay:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   460: return
    //   461: ldc_w 606
    //   464: aload 18
    //   466: invokestatic 286	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   469: ifeq +18 -> 487
    //   472: aload_1
    //   473: invokestatic 294	com/umeng/message/b/af:n	(Landroid/content/Context;)Ljava/lang/String;
    //   476: aload 7
    //   478: iconst_1
    //   479: invokestatic 595	com/umeng/message/b/ch:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   482: astore 19
    //   484: goto -171 -> 313
    //   487: ldc_w 608
    //   490: aload 18
    //   492: invokestatic 286	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   495: ifeq +18 -> 513
    //   498: aload_1
    //   499: invokestatic 294	com/umeng/message/b/af:n	(Landroid/content/Context;)Ljava/lang/String;
    //   502: aload 7
    //   504: iconst_2
    //   505: invokestatic 595	com/umeng/message/b/ch:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   508: astore 19
    //   510: goto -197 -> 313
    //   513: ldc_w 610
    //   516: aload 18
    //   518: invokestatic 286	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   521: ifeq +18 -> 539
    //   524: aload_1
    //   525: invokestatic 612	com/umeng/message/b/af:B	(Landroid/content/Context;)Ljava/lang/String;
    //   528: aload 7
    //   530: iconst_1
    //   531: invokestatic 595	com/umeng/message/b/ch:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   534: astore 19
    //   536: goto -223 -> 313
    //   539: ldc_w 614
    //   542: aload 18
    //   544: invokestatic 286	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   547: ifeq +485 -> 1032
    //   550: aload_1
    //   551: invokestatic 612	com/umeng/message/b/af:B	(Landroid/content/Context;)Ljava/lang/String;
    //   554: aload 7
    //   556: iconst_2
    //   557: invokestatic 595	com/umeng/message/b/ch:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   560: astore 43
    //   562: aload 43
    //   564: astore 19
    //   566: goto -253 -> 313
    //   569: aload_2
    //   570: ldc_w 588
    //   573: invokevirtual 582	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   576: aload_2
    //   577: ldc_w 550
    //   580: aload 19
    //   582: invokevirtual 486	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   585: pop
    //   586: aload_2
    //   587: ldc_w 569
    //   590: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   593: astore 40
    //   595: aload_1
    //   596: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   599: aload 6
    //   601: aload 12
    //   603: aload 40
    //   605: aload 5
    //   607: aload 10
    //   609: aconst_null
    //   610: ldc 29
    //   612: invokevirtual 579	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   615: ifeq +10 -> 625
    //   618: aload_2
    //   619: ldc_w 569
    //   622: invokevirtual 582	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   625: aload_1
    //   626: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   629: aload 6
    //   631: invokevirtual 617	com/umeng/message/b/bf:b	(Ljava/lang/String;)Z
    //   634: ifne -521 -> 113
    //   637: aload_2
    //   638: ldc_w 619
    //   641: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   644: astore 37
    //   646: aload 37
    //   648: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   651: ifne +39 -> 690
    //   654: aload 37
    //   656: ldc_w 590
    //   659: invokestatic 286	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   662: ifeq +28 -> 690
    //   665: aload 19
    //   667: invokevirtual 623	java/lang/String:hashCode	()I
    //   670: istore 38
    //   672: aload_1
    //   673: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   676: aload 6
    //   678: iload 38
    //   680: invokevirtual 626	com/umeng/message/b/bf:a	(Ljava/lang/String;I)Z
    //   683: istore 39
    //   685: iload 39
    //   687: ifne -574 -> 113
    //   690: ldc 19
    //   692: new 215	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   699: ldc_w 628
    //   702: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload 19
    //   707: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: ldc_w 630
    //   713: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: aload 5
    //   718: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: ldc_w 348
    //   724: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 229	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: aload_1
    //   734: aload 6
    //   736: invokestatic 631	com/umeng/message/b/aq:b	(Landroid/content/Context;Ljava/lang/String;)V
    //   739: aload_2
    //   740: ldc_w 633
    //   743: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   746: invokestatic 639	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   749: istore 35
    //   751: iload 35
    //   753: istore 27
    //   755: aload_2
    //   756: ldc_w 641
    //   759: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   762: astore 34
    //   764: aload 34
    //   766: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   769: ifne +32 -> 801
    //   772: aload 34
    //   774: ldc_w 590
    //   777: invokestatic 286	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   780: ifeq +21 -> 801
    //   783: aload_1
    //   784: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   787: aload 6
    //   789: aload 19
    //   791: aload 8
    //   793: iload 27
    //   795: invokevirtual 644	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   798: return
    //   799: astore 28
    //   801: aload_2
    //   802: ldc_w 646
    //   805: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   808: astore 29
    //   810: aload 29
    //   812: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   815: ifne +87 -> 902
    //   818: aload_1
    //   819: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   822: aload 6
    //   824: aload 19
    //   826: aload 8
    //   828: aload 29
    //   830: iload 27
    //   832: invokevirtual 649	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   835: aload_2
    //   836: ldc_w 646
    //   839: invokevirtual 582	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   842: return
    //   843: astore 24
    //   845: aload_2
    //   846: ldc_w 569
    //   849: invokevirtual 527	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   852: astore 36
    //   854: aload_1
    //   855: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   858: aload 6
    //   860: aload 12
    //   862: aload 36
    //   864: aload 5
    //   866: aload 10
    //   868: ldc_w 651
    //   871: ldc 29
    //   873: invokevirtual 579	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   876: ifeq -186 -> 690
    //   879: aload_2
    //   880: ldc_w 569
    //   883: invokevirtual 582	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   886: goto -196 -> 690
    //   889: astore 25
    //   891: goto -201 -> 690
    //   894: astore 26
    //   896: iconst_m1
    //   897: istore 27
    //   899: goto -144 -> 755
    //   902: aload_1
    //   903: invokestatic 655	com/umeng/message/b/af:D	(Landroid/content/Context;)J
    //   906: lstore 30
    //   908: lload 30
    //   910: ldc2_w 555
    //   913: lcmp
    //   914: ifeq +48 -> 962
    //   917: aload_1
    //   918: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   921: astore 32
    //   923: new 215	java/lang/StringBuilder
    //   926: dup
    //   927: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   930: lload 30
    //   932: invokevirtual 449	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   935: ldc_w 657
    //   938: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: astore 33
    //   946: aload 32
    //   948: aload 6
    //   950: aload 19
    //   952: aload 8
    //   954: aload 33
    //   956: iload 27
    //   958: invokevirtual 649	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   961: return
    //   962: aload_1
    //   963: invokestatic 574	com/umeng/message/b/bf:a	(Landroid/content/Context;)Lcom/umeng/message/b/bf;
    //   966: aload 6
    //   968: aload 19
    //   970: aload 8
    //   972: iload 27
    //   974: invokevirtual 644	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   977: aload_3
    //   978: aload_1
    //   979: aload_2
    //   980: invokeinterface 660 3 0
    //   985: return
    //   986: astore 23
    //   988: goto -363 -> 625
    //   991: astore 16
    //   993: goto -567 -> 426
    //   996: astore 13
    //   998: aload 13
    //   1000: astore 14
    //   1002: aload 7
    //   1004: astore 15
    //   1006: goto -621 -> 385
    //   1009: astore 41
    //   1011: goto -645 -> 366
    //   1014: astore 45
    //   1016: goto -770 -> 246
    //   1019: astore 4
    //   1021: aconst_null
    //   1022: astore 5
    //   1024: goto -922 -> 102
    //   1027: astore 50
    //   1029: goto -927 -> 102
    //   1032: aload 7
    //   1034: astore 19
    //   1036: goto -723 -> 313
    //
    // Exception table:
    //   from	to	target	type
    //   157	180	261	java/lang/Throwable
    //   184	193	269	java/lang/Throwable
    //   313	320	375	java/lang/Throwable
    //   366	374	375	java/lang/Throwable
    //   569	586	375	java/lang/Throwable
    //   755	798	799	java/lang/Throwable
    //   637	685	843	java/lang/Throwable
    //   845	886	889	java/lang/Throwable
    //   739	751	894	java/lang/Throwable
    //   586	625	986	java/lang/Throwable
    //   385	426	991	java/lang/Throwable
    //   277	309	996	java/lang/Throwable
    //   461	484	996	java/lang/Throwable
    //   487	510	996	java/lang/Throwable
    //   513	536	996	java/lang/Throwable
    //   539	562	996	java/lang/Throwable
    //   325	366	1009	java/lang/Throwable
    //   205	246	1014	java/lang/Throwable
    //   0	9	1019	java/lang/Throwable
    //   13	102	1027	java/lang/Throwable
  }

  private final void b(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent1 = new Intent();
      localIntent1.setAction("org.agoo.android.intent.action.PING_V4");
      localIntent1.setClassName("com.taobao.taobao", "com.taobao.accs.ChannelService");
      localIntent1.putExtra("source", paramContext.getPackageName());
      paramContext.startService(localIntent1);
      str = ar.a(paramContext);
      if (TextUtils.isEmpty(str))
      {
        ay.c("ControlService", "onPingMessage:[currentSudoPack==null][retry election]");
        a(paramContext, paramString);
        return;
      }
    }
    catch (Exception localException)
    {
      String str;
      while (true)
        ay.e("ControlService", "onPingMessage ping accs error", localException);
      try
      {
        ay.c("ControlService", "messageConnection [bind]");
        Intent localIntent2 = new Intent();
        localIntent2.setAction("org.agoo.android.intent.action.PING_V4");
        localIntent2.addCategory(org.android.a.m(paramContext));
        localIntent2.setPackage(str);
        paramContext.bindService(localIntent2, this.k, 1);
        return;
      }
      catch (Throwable localThrowable)
      {
        ay.d("ControlService", "onPingMessage", localThrowable);
      }
    }
  }

  private final void b(Context paramContext, org.android.agoo.a.a parama)
  {
    ar.b(paramContext, parama.callAgooElectionReceiver());
    af.x(paramContext);
    ay.a("ControlService", "handleDisableCurrentPack-->[" + paramContext.getPackageName() + "]");
    ap.a(paramContext);
  }

  private final void c(Context paramContext)
  {
    boolean bool = org.android.a.F(paramContext);
    Log.d("ControlService", "doUnRegisterTemp,begin,flag=" + bool);
    String str1;
    String str2;
    String str3;
    if (bool)
    {
      str1 = af.g(paramContext);
      str2 = af.k(paramContext);
      str3 = af.i(paramContext);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
        break label70;
    }
    label70: String str5;
    do
    {
      return;
      j.a(str1);
      j.b(str2);
      j.c(af.G(paramContext));
      String str4 = af.o(paramContext);
      d locald = new d();
      locald.c("mtop.push.device.unregister");
      locald.d("4.0");
      locald.b(str3);
      locald.a(str4);
      locald.a("app_version", af.a(paramContext));
      locald.a("sdk_version", Long.valueOf(af.a()));
      locald.a("app_pack", paramContext.getPackageName());
      i locali = j.a(paramContext, locald);
      ay.c("ControlService", "unregister--->[server result:" + locali.c() + "]");
      str5 = locali.e();
    }
    while (!TextUtils.isEmpty(str5));
    Log.d("ControlService", "doUnRegisterTemp,errorId=" + str5);
    org.android.a.g(paramContext, false);
  }

  private final void c(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    String str = paramIntent.getStringExtra("id");
    bq localbq = new bq(this.i, "appMessageSuccess");
    LinkedHashMap localLinkedHashMap = org.android.a.B(this.i);
    localLinkedHashMap.put("messageId", str);
    localbq.a(localLinkedHashMap);
    if (!parama.callShouldProcessMessage(paramContext, paramIntent))
      return;
    if (af.z(paramContext))
    {
      ay.a("ControlService", "handleMessage[" + paramContext.getPackageName() + "]--->[disable]");
      new bq(this.i, "appMessageFailed").a(localLinkedHashMap);
      return;
    }
    b(paramContext, paramIntent, parama);
  }

  private final void d(Context paramContext)
  {
    try
    {
      if (org.android.a.v(paramContext))
      {
        ay.c("ControlService", "ippConnection [bind]");
        Intent localIntent = new Intent();
        localIntent.setAction("org.rome.android.ipp.intent.action.PINGA");
        paramContext.bindService(localIntent, this.l, 1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("ControlService", "ippConnection", localThrowable);
    }
  }

  private final void d(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    if (!a(paramContext, parama))
    {
      ay.c("ControlService", "handleAddPackage---->[appkey or appSecret ===null]");
      return;
    }
    if (!af.m(paramContext))
    {
      ay.c("ControlService", "handleAddPackage---->[devicetoken ===null]");
      return;
    }
    if (af.H(paramContext) == af.a.a)
    {
      ap.a(paramContext, null);
      return;
    }
    a(paramContext, "handleAddPackage");
  }

  private static final void e(Context paramContext)
  {
    try
    {
      Intent localIntent = org.android.agoo.b.a.a(paramContext, "register");
      localIntent.setPackage(paramContext.getPackageName());
      localIntent.putExtra("HAS_RETTY_REGISTER", true);
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private final void e(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    if ((paramIntent == null) || (paramContext == null));
    String str2;
    String str3;
    do
    {
      String str1;
      do
      {
        return;
        if (!af.m(paramContext))
        {
          ay.c("ControlService", "handleRemovePackage---->[devicetoken ===null]");
          return;
        }
        Uri localUri = paramIntent.getData();
        str1 = null;
        if (localUri == null)
          continue;
        str1 = localUri.getSchemeSpecificPart();
      }
      while (TextUtils.isEmpty(str1));
      boolean bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
      ay.c("ControlService", "handleRemovePackage---->[replacing:" + bool + "]");
      a(paramContext, paramIntent, parama, str1, bool);
      str2 = ar.a(paramContext);
      if (TextUtils.isEmpty(str2))
      {
        a(paramContext, "handleRemovePackage");
        return;
      }
      if (TextUtils.equals(str1, str2))
      {
        a(paramContext, "handleRemovePackage");
        return;
      }
      str3 = paramContext.getPackageName();
    }
    while (!TextUtils.equals(str2, str3));
    bq localbq = new bq(this.i, "handleRemovePackage");
    LinkedHashMap localLinkedHashMap = org.android.a.B(this.i);
    localLinkedHashMap.put("currentSudoPack", str2);
    localbq.a(localLinkedHashMap);
    aq.c(paramContext, str2, "handleRemovePackage");
    a(paramContext, str3, str2, parama, "handleRemovePackage");
  }

  private final void f(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    String str1 = paramIntent.getStringExtra("command");
    ay.c("ControlService", "command --->[" + str1 + "]");
    if (str1.equals("registration"))
    {
      parama.callRegistered(paramContext, af.n(paramContext));
      d(paramContext, paramIntent, parama);
    }
    while (true)
    {
      return;
      if (str1.equals("unregister"))
      {
        o(paramContext, paramIntent, parama);
        return;
      }
      if (str1.equals("error"))
      {
        n(paramContext, paramIntent, parama);
        return;
      }
      if (str1.equals("register"))
      {
        m(paramContext, paramIntent, parama);
        return;
      }
      if (str1.equals("register_retry"))
      {
        a(paramContext, paramIntent);
        return;
      }
      if (str1.equals("command_other_channel"))
      {
        g(paramContext, paramIntent, parama);
        return;
      }
      if (str1.equals("command_restart_sudo"))
      {
        String str4 = paramContext.getPackageName();
        String str5 = ar.a(paramContext);
        if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str5)) || (!TextUtils.equals(str4, str5)))
          continue;
        a(paramContext, str4, str5, parama, "command_restart_sudo");
        return;
      }
      if (str1.equals("command_bind_user"))
      {
        j(paramContext, paramIntent, parama);
        return;
      }
      if (str1.equals("command_unbind_user"))
      {
        k(paramContext, paramIntent, parama);
        return;
      }
      if (!str1.equals("agoo_command_restart_sudo_app"))
        break;
      String str2 = paramContext.getPackageName();
      String str3 = ar.a(paramContext);
      if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
        continue;
      bq localbq = new bq(this.i, "restartByApp");
      LinkedHashMap localLinkedHashMap = org.android.a.B(this.i);
      localLinkedHashMap.put("currentSudoPack", str3);
      localbq.a(localLinkedHashMap);
      b(paramContext, "restartByApp");
      aq.c(paramContext, str3, "restartByApp");
      return;
    }
    if (str1.equals("so_manager"))
    {
      org.android.a.e(paramContext, paramIntent.getIntExtra("soTimeout", 600));
      return;
    }
    parama.callUserCommand(paramContext, paramIntent);
  }

  private final void g(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    String str1 = paramIntent.getStringExtra("channel_android_device_token");
    String str2 = paramIntent.getStringExtra("channel_android_device_type");
    i locali;
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (af.m(paramContext)) && (a(paramContext, parama)))
    {
      String str3 = af.n(paramContext);
      d locald = new d();
      locald.c("mtop.push.device.bind.android");
      locald.d("5.0");
      locald.a(str3);
      locald.a("tb_app_device_token", str3);
      locald.a("android_device_token", str1);
      locald.a("android_device_type", str2);
      j.c(af.G(paramContext));
      locali = j.a(paramContext, locald);
      if (locali.b())
        Log.d("ControlService", "register GCM success");
    }
    else
    {
      return;
    }
    aq.h(paramContext, locali.e());
  }

  private final void h(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    boolean bool = false;
    String str1 = paramContext.getPackageName();
    String str2 = paramIntent.getStringExtra("election_result");
    aq.j(paramContext, "handleElectionResult begin");
    Set localSet = paramIntent.getCategories();
    if ((localSet != null) && (!localSet.isEmpty()) && (localSet.contains(org.android.a.m(paramContext))))
    {
      while (true)
      {
        String str3;
        try
        {
          str3 = paramIntent.getStringExtra("eventId");
          if (af.m(paramContext))
            continue;
          ay.c("ControlService", "handleElection---->[devicetoken == null]");
          if (!TextUtils.isEmpty(str3))
            continue;
          str3 = "handleElectionResult";
          a(paramContext, false, localSet.toString(), str1, str2, "isRegistered is failed");
          a(paramContext, str3);
          return;
          if (af.z(paramContext))
          {
            ay.c("ControlService", "handleElection--->[app:disable]");
            if (!TextUtils.isEmpty(str3))
              continue;
            str3 = "handleElectionResult";
            a(paramContext, false, localSet.toString(), str1, str2, "currentPack hasDisableApp");
            a(paramContext, str3);
            return;
          }
        }
        catch (Throwable localThrowable1)
        {
          a(paramContext, bool, localSet.toString(), str1, str2, localThrowable1.toString());
          return;
        }
        String str4 = paramIntent.getStringExtra("election_source");
        long l1 = paramIntent.getLongExtra("election_timeout", -1L);
        if (TextUtils.isEmpty(str2))
          return;
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (!TextUtils.equals(str1, str2)))
          break;
        if (org.android.a.D(paramContext))
        {
          ay.c("ControlService", "handleElection---->[noticeResult is true, result has came]");
          return;
        }
        org.android.a.f(paramContext, true);
        af.a(paramContext, l1, str4);
        bq localbq = new bq(this.i, "handleElectionResult");
        LinkedHashMap localLinkedHashMap = org.android.a.B(this.i);
        localLinkedHashMap.put("currentSudoPack", str2);
        localbq.a(localLinkedHashMap);
        aq.c(paramContext, str2, "handleElectionResult");
        if (TextUtils.isEmpty(str3))
          str3 = "handleElectionResult";
        try
        {
          a(paramContext, true, localSet.toString(), str1, str2, null);
          a(paramContext, str1, str2, parama, str3);
          return;
        }
        catch (Throwable localThrowable2)
        {
          bool = true;
        }
      }
      a(paramContext, false, localSet.toString(), str1, str2, "currentPack != currentSudoPack");
      if (af.H(paramContext) != af.a.a)
        a(paramContext, str1, str2, parama);
    }
  }

  private final void i(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    i locali;
    if ((af.m(paramContext)) && (a(paramContext, parama)))
    {
      String str = af.n(paramContext);
      d locald = new d();
      locald.c("mtop.push.device.unregister");
      locald.d("4.0");
      locald.b(af.h(paramContext));
      locald.a(str);
      locald.a("app_version", af.a(paramContext));
      locald.a("sdk_version", Long.valueOf(af.a()));
      locald.a("app_pack", paramContext.getPackageName());
      locali = j.a(paramContext, locald);
      ay.c("ControlService", "unregister--->[server result:" + locali.c() + "],result.isSuccess()=" + locali.b());
      if ((locali == null) || (locali.b()))
        break label196;
      org.android.a.g(paramContext, true);
      parama.callUnregistered(paramContext, "error");
    }
    while (true)
    {
      a(paramContext, paramIntent, parama, locali);
      return;
      label196: parama.callUnregistered(paramContext, af.n(paramContext));
    }
  }

  private final void j(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    i locali;
    StringBuilder localStringBuilder;
    String str3;
    if ((af.m(paramContext)) && (a(paramContext, parama)))
    {
      String str1 = af.d(paramContext);
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = af.n(paramContext);
        d locald = new d();
        locald.c("mtop.push.device.bindUser");
        locald.d("4.0");
        locald.a(str2);
        locald.e(str1);
        locald.a("s_token", str1);
        locald.a("push_token", "ajflajdflajflajflajlfajldfjalfdj");
        locali = j.a(paramContext, locald);
        localStringBuilder = new StringBuilder().append("doBinderUser--->[server result:");
        if (locali == null)
          break label215;
        str3 = locali.c();
      }
    }
    while (true)
    {
      ay.c("ControlService", str3 + "]");
      if ((locali == null) || (locali.b()));
      try
      {
        String str4 = new JSONObject(locali.c()).getString("push_user_token");
        if (!TextUtils.isEmpty(str4))
          af.c(paramContext, str4);
        label204: a(paramContext, paramIntent, parama, locali);
        return;
        label215: str3 = null;
      }
      catch (JSONException localJSONException)
      {
        break label204;
      }
    }
  }

  private final void k(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    i locali;
    StringBuilder localStringBuilder;
    if ((af.m(paramContext)) && (a(paramContext, parama)))
    {
      String str1 = org.android.a.i(paramContext);
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = af.n(paramContext);
        d locald = new d();
        locald.c("mtop.push.device.unBindUser");
        locald.d("4.0");
        locald.a(str2);
        locald.a("push_user_token", str1);
        locald.a("push_token", "ajflajdflajflajflajlfajldfjalfdj");
        locali = j.a(paramContext, locald);
        localStringBuilder = new StringBuilder().append("doBinderUser--->[server result:");
        if (locali == null)
          break label172;
      }
    }
    label172: for (String str3 = locali.c(); ; str3 = null)
    {
      ay.c("ControlService", str3 + "]");
      if (locali != null)
      {
        if (!locali.b())
          break;
        af.C(paramContext);
        af.c(paramContext);
      }
      return;
    }
    a(paramContext, paramIntent, parama, locali);
  }

  private final void l(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    d locald = new d();
    locald.c("mtop.push.device.createAndRegister");
    locald.d("4.0");
    locald.b(af.h(paramContext));
    locald.a("new_device", "true");
    locald.a("device_global_id", aq.c(paramContext));
    locald.a("c0", Build.BRAND);
    locald.a("c1", Build.MODEL);
    locald.a("c2", cm.d(paramContext));
    locald.a("c3", cm.e(paramContext));
    locald.a("c4", cm.c(paramContext));
    locald.a("c5", cm.a());
    locald.a("c6", cm.f(paramContext));
    locald.a("app_version", af.a(paramContext));
    locald.a("sdk_version", Long.valueOf(af.a()));
    locald.a("package_name", paramContext.getPackageName());
    if (af.m(paramContext))
      locald.a("old_device_id", af.n(paramContext));
    Log.d("ControlService", "doRegister app_version=" + af.a(paramContext));
    Map localMap = j.b(paramContext, locald);
    i locali;
    if (localMap != null)
      locali = (i)localMap.get("result");
    for (String str = (String)localMap.get("requestUrl"); ; str = null)
    {
      if (locali != null)
      {
        a(paramContext, locali, locald, str);
        if (!cn.a(locali.a(), locali.f()))
          ay.c("ControlService", "register--->[failed]");
        do
        {
          return;
          if (!locali.b())
            continue;
          ay.c("ControlService", "register--->[result:" + locali.c() + "]");
          org.android.a.c(paramContext, af.a());
          a(paramContext, paramIntent, locali.c(), parama);
          return;
        }
        while (a(paramContext, paramIntent, parama, locali));
      }
      a(paramContext, locali, locald, str);
      a(paramContext, "SERVICE_NOT_AVAILABLE", parama);
      return;
      locali = null;
    }
  }

  private final void m(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    aq.k(paramContext, "utdid=" + aq.c(paramContext));
    if (!a(paramContext, parama))
    {
      ay.a("ControlService", "handleRegister[" + paramContext.getPackageName() + "]--->[appkey==null,appSecret==null,ttid==null]");
      return;
    }
    boolean bool = paramIntent.getBooleanExtra("HAS_RETTY_REGISTER", false);
    if (!af.m(paramContext))
    {
      ay.a("ControlService", "handleRegister[" + paramContext.getPackageName() + "]--->[deviceToken==null][retty:" + bool + "]");
      af.y(paramContext);
      if (!bool)
        af.s(paramContext);
      am.a(paramContext);
      a(paramContext);
      l(paramContext, paramIntent, parama);
      return;
    }
    if (af.w(paramContext))
    {
      ay.a("ControlService", "handleRegister[" + paramContext.getPackageName() + "]--->[" + af.n(paramContext) + "][register timeout][retty:" + bool + "]");
      if (!bool)
        af.s(paramContext);
      a(paramContext);
      l(paramContext, paramIntent, parama);
      return;
    }
    if (af.a(paramContext, true))
    {
      ay.a("ControlService", "handleRegister[" + paramContext.getPackageName() + "]--->[disable]");
      return;
    }
    if (af.H(paramContext) == af.a.a)
    {
      ap.a(paramContext, null);
      return;
    }
    ar.a(paramContext, parama.callAgooElectionReceiver());
    Class[] arrayOfClass = new Class[3];
    arrayOfClass[0] = parama.callAgooMessageReceiver();
    arrayOfClass[1] = parama.callAgooSystemReceiver();
    arrayOfClass[2] = parama.callAgooRegistrationReceiver();
    ao.a(paramContext, arrayOfClass);
    String str = ar.a(paramContext);
    bq localbq = new bq(this.i, "handleRegister");
    LinkedHashMap localLinkedHashMap = org.android.a.B(this.i);
    localLinkedHashMap.put("currentSudoPack", str);
    localbq.a(localLinkedHashMap);
    aq.c(paramContext, str, "handleRegister");
    b(paramContext, "handleRegister");
  }

  private final void n(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    String str1 = paramIntent.getStringExtra("error");
    String str2 = paramIntent.getStringExtra("eventId");
    ay.c("ControlService", "handleError:" + str1);
    if (TextUtils.equals(str1, "EVENT_CONNECTED"))
      parama.callError(paramContext, str1);
    do
    {
      return;
      if ((TextUtils.equals(str1, "EVENT_SPDY_ERROR")) || (TextUtils.equals(str1, "EVENT_DISCONNECTED")))
      {
        String str3 = paramContext.getPackageName();
        String str4 = ar.a(paramContext);
        ay.c("ControlService", "handleError,currentPack=" + str3 + ",currentSudoPack=" + str4);
        if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (TextUtils.equals(str3, str4)))
          a(paramContext, str3, str4, parama, "command_restart_sudo");
        parama.callError(paramContext, str1);
        return;
      }
      if (TextUtils.equals(str1, "ERROR_NEED_ELECTION"))
      {
        a(paramContext, str2);
        return;
      }
      if (TextUtils.equals(str1, "ERROR_DEVICETOKEN_NULL"))
      {
        aq.g(paramContext, "ERROR_DEVICETOKEN_NULL");
        parama.callError(paramContext, str1);
        return;
      }
      if (!TextUtils.equals(str1, "ERRCODE_AUTH_REJECT"))
        continue;
      b(paramContext, parama);
      parama.callError(paramContext, str1);
      return;
    }
    while ((!TextUtils.equals(str1, "ERROR_APPKEY_NULL")) && (!TextUtils.equals(str1, "ERROR_APPSECRET_NULL")) && (!TextUtils.equals(str1, "ERROR_TTID_NULL")));
    aq.g(paramContext, "APPKEY_OR_SECRET_IS_NULL");
    b(paramContext, parama);
    parama.callError(paramContext, str1);
  }

  private final void o(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    if (af.m(paramContext))
    {
      String str1 = paramContext.getPackageName();
      String str2 = ar.a(paramContext);
      int m;
      if (!TextUtils.isEmpty(str2))
      {
        boolean bool = TextUtils.equals(str1, str2);
        m = 0;
        if (!bool);
      }
      else
      {
        ay.c("ControlService", "handleUnRegister---->[currentPack:" + str1 + "][currentSudoPack:" + str2 + "]:[retryElection]");
        if (a(parama.callAgooService()))
        {
          ay.c("ControlService", "disableService---->[" + parama.callAgooService() + "]");
          ao.a(paramContext, parama.callAgooService());
        }
        ap.a(paramContext);
        m = 1;
      }
      ar.b(paramContext, parama.callAgooElectionReceiver());
      if (m != 0)
        a(paramContext, "handleUnRegister");
      i(paramContext, paramIntent, parama);
      af.s(paramContext);
      af.e(paramContext);
    }
  }

  public final void onHandleIntent(Context paramContext, Intent paramIntent, org.android.agoo.a.a parama)
  {
    String str;
    try
    {
      ay.a(paramContext);
      ay.c("ControlService", "onHandleIntent [" + paramContext.getPackageName() + "][" + paramIntent.getAction() + "]");
      aq.a(paramContext);
      this.i = paramContext;
      str = paramIntent.getAction();
      if (TextUtils.equals(str, org.android.agoo.b.a.b(paramContext)))
      {
        f(paramContext, paramIntent, parama);
        return;
      }
      if ("android.intent.action.PACKAGE_REMOVED".equals(str))
      {
        e(paramContext, paramIntent, parama);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ay.d("ControlService", "onHandleIntent", localThrowable);
      return;
    }
    if (TextUtils.equals(str, "org.agoo.android.intent.action.RECEIVE"))
    {
      c(paramContext, paramIntent, parama);
      return;
    }
    if (TextUtils.equals(str, "org.agoo.android.intent.action.ELECTION_RESULT_V4"))
    {
      h(paramContext, paramIntent, parama);
      return;
    }
    if ((TextUtils.equals(str, "android.net.conn.CONNECTIVITY_CHANGE")) || (TextUtils.equals(str, "android.intent.action.BOOT_COMPLETED")) || (TextUtils.equals(str, "android.intent.action.PACKAGE_ADDED")) || (TextUtils.equals(str, "android.intent.action.PACKAGE_REPLACED")) || (TextUtils.equals(str, "android.intent.action.USER_PRESENT")))
    {
      if (TextUtils.equals(str, "android.net.conn.CONNECTIVITY_CHANGE"))
        af.v(paramContext);
      c(paramContext);
      a(paramContext, paramIntent, parama);
      return;
    }
    ay.d("ControlService", "handleWake[sms]");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.impl.ControlService
 * JD-Core Version:    0.6.0
 */