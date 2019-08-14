package com.umeng.message.b;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.android.a;
import org.android.agoo.c.c.h;
import org.android.agoo.service.ElectionReceiverService;
import org.android.agoo.service.ElectionReceiverService.Stub;
import org.json.JSONObject;

public final class ar
{
  private static final String a = "ElectionService";
  private static final org.android.agoo.c.c.b b = new h();
  private static final Random c = new Random();
  private static final String d = "set_CurrentSudo";
  private static final String e = "get_CurrentSudo";
  private static String f = null;
  private static String g = "";
  private static Map<String, String> h = null;
  private static Context i;
  private static HandlerThread j = null;
  private static Handler k = null;
  private static final String l = "org.agoo.android.sudo.%s";
  private static final String m = "org.agoo.android.packs_v1.%s";
  private static final String n = "17984173941739471471917341";

  static
  {
    j = new HandlerThread("electionService-thread");
    j.start();
    k = new Handler(j.getLooper(), new b());
  }

  private static int a(PackageInfo paramPackageInfo)
  {
    try
    {
      String str = paramPackageInfo.versionName;
      int i1 = paramPackageInfo.versionCode;
      int i2 = Math.abs((str + "." + i1).hashCode());
      return i2;
    }
    catch (Throwable localThrowable)
    {
    }
    return -1;
  }

  // ERROR //
  private static final a a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 137	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore 6
    //   6: iload_3
    //   7: iconst_m1
    //   8: if_icmpne +17 -> 25
    //   11: aload 6
    //   13: aload_0
    //   14: invokevirtual 140	android/content/Context:getPackageName	()Ljava/lang/String;
    //   17: iconst_0
    //   18: invokevirtual 146	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   21: getfield 151	android/content/pm/ApplicationInfo:flags	I
    //   24: pop
    //   25: aload 6
    //   27: aload_1
    //   28: iconst_0
    //   29: invokevirtual 146	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   32: astore 25
    //   34: aload 25
    //   36: astore 8
    //   38: aload 8
    //   40: ifnonnull +34 -> 74
    //   43: ldc 8
    //   45: new 101	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   52: ldc 153
    //   54: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 155
    //   63: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aconst_null
    //   73: areturn
    //   74: aload 8
    //   76: getfield 164	android/content/pm/ApplicationInfo:enabled	Z
    //   79: ifne +42 -> 121
    //   82: ldc 8
    //   84: new 101	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   91: ldc 153
    //   93: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 166
    //   102: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aconst_null
    //   112: areturn
    //   113: astore 4
    //   115: aconst_null
    //   116: astore 5
    //   118: aload 5
    //   120: areturn
    //   121: aload 6
    //   123: aload_1
    //   124: iconst_0
    //   125: invokevirtual 170	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   128: astore 24
    //   130: aload 24
    //   132: astore 10
    //   134: aload 10
    //   136: ifnonnull +34 -> 170
    //   139: ldc 8
    //   141: new 101	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   148: ldc 153
    //   150: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 172
    //   159: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aconst_null
    //   169: areturn
    //   170: aload_2
    //   171: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifeq +170 -> 344
    //   177: iconst_1
    //   178: anewarray 4	java/lang/Object
    //   181: astore 17
    //   183: aload 17
    //   185: iconst_0
    //   186: aload_0
    //   187: invokestatic 183	org/android/a:m	(Landroid/content/Context;)Ljava/lang/String;
    //   190: aastore
    //   191: ldc 35
    //   193: aload 17
    //   195: invokestatic 187	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   198: astore 18
    //   200: aload_0
    //   201: invokevirtual 191	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   204: aload 18
    //   206: invokestatic 197	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   209: astore 19
    //   211: aload_0
    //   212: invokestatic 199	com/umeng/message/b/ar:f	(Landroid/content/Context;)Ljava/lang/String;
    //   215: astore 20
    //   217: aload 20
    //   219: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   222: ifne +479 -> 701
    //   225: aload 19
    //   227: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: ifne +471 -> 701
    //   233: aload 20
    //   235: aload 19
    //   237: iconst_2
    //   238: invokestatic 204	com/umeng/message/b/ch:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   241: astore 21
    //   243: aload 21
    //   245: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   248: ifeq +34 -> 282
    //   251: ldc 8
    //   253: new 101	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   260: ldc 153
    //   262: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_1
    //   266: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: ldc 206
    //   271: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aconst_null
    //   281: areturn
    //   282: new 208	org/json/JSONObject
    //   285: dup
    //   286: aload 21
    //   288: invokespecial 209	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   291: astore 22
    //   293: aload 22
    //   295: ifnonnull +42 -> 337
    //   298: ldc 8
    //   300: new 101	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   307: ldc 153
    //   309: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_1
    //   313: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 211
    //   318: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 21
    //   323: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc 213
    //   328: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload 22
    //   339: aload_1
    //   340: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   343: astore_2
    //   344: aload_2
    //   345: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifeq +34 -> 382
    //   351: ldc 8
    //   353: new 101	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   360: ldc 153
    //   362: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_1
    //   366: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc 219
    //   371: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aconst_null
    //   381: areturn
    //   382: aload_2
    //   383: invokestatic 224	com/umeng/message/b/ar$a:a	(Ljava/lang/String;)Lcom/umeng/message/b/ar$a;
    //   386: astore 5
    //   388: aload 5
    //   390: ifnonnull +34 -> 424
    //   393: ldc 8
    //   395: new 101	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   402: ldc 153
    //   404: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_1
    //   408: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: ldc 226
    //   413: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: aconst_null
    //   423: areturn
    //   424: aload 5
    //   426: invokevirtual 229	com/umeng/message/b/ar$a:b	()J
    //   429: lstore 11
    //   431: aload 5
    //   433: invokevirtual 231	com/umeng/message/b/ar$a:a	()I
    //   436: istore 13
    //   438: lload 11
    //   440: ldc2_w 232
    //   443: lcmp
    //   444: ifeq +9 -> 453
    //   447: iload 13
    //   449: iconst_m1
    //   450: if_icmpne +34 -> 484
    //   453: ldc 8
    //   455: new 101	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   462: ldc 153
    //   464: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload_1
    //   468: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc 235
    //   473: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: aconst_null
    //   483: areturn
    //   484: aload 10
    //   486: invokestatic 238	com/umeng/message/b/ar:b	(Landroid/content/pm/PackageInfo;)J
    //   489: lstore 14
    //   491: aload 10
    //   493: invokestatic 240	com/umeng/message/b/ar:a	(Landroid/content/pm/PackageInfo;)I
    //   496: istore 16
    //   498: lload 14
    //   500: ldc2_w 232
    //   503: lcmp
    //   504: ifeq +12 -> 516
    //   507: lload 14
    //   509: ldc2_w 232
    //   512: lcmp
    //   513: ifne +34 -> 547
    //   516: ldc 8
    //   518: new 101	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   525: ldc 153
    //   527: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_1
    //   531: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: ldc 242
    //   536: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: aconst_null
    //   546: areturn
    //   547: lload 14
    //   549: lload 11
    //   551: lcmp
    //   552: ifeq +54 -> 606
    //   555: ldc 8
    //   557: new 101	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   564: ldc 153
    //   566: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload_1
    //   570: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: ldc 244
    //   575: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: lload 14
    //   580: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   583: ldc 249
    //   585: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: lload 11
    //   590: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   593: ldc 166
    //   595: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aconst_null
    //   605: areturn
    //   606: iload 16
    //   608: iload 13
    //   610: if_icmpeq +54 -> 664
    //   613: ldc 8
    //   615: new 101	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   622: ldc 153
    //   624: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload_1
    //   628: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: ldc 251
    //   633: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: iload 16
    //   638: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   641: ldc 253
    //   643: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: iload 13
    //   648: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   651: ldc 166
    //   653: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aconst_null
    //   663: areturn
    //   664: ldc 8
    //   666: new 101	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   673: ldc 153
    //   675: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload_1
    //   679: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: ldc 255
    //   684: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: goto -575 -> 118
    //   696: astore 26
    //   698: goto -673 -> 25
    //   701: aconst_null
    //   702: areturn
    //   703: astore 7
    //   705: aconst_null
    //   706: astore 8
    //   708: goto -670 -> 38
    //   711: astore 9
    //   713: aconst_null
    //   714: astore 10
    //   716: goto -582 -> 134
    //   719: astore 23
    //   721: aconst_null
    //   722: astore 22
    //   724: goto -431 -> 293
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	113	java/lang/Throwable
    //   43	72	113	java/lang/Throwable
    //   74	111	113	java/lang/Throwable
    //   139	168	113	java/lang/Throwable
    //   170	280	113	java/lang/Throwable
    //   298	337	113	java/lang/Throwable
    //   337	344	113	java/lang/Throwable
    //   344	380	113	java/lang/Throwable
    //   382	388	113	java/lang/Throwable
    //   393	422	113	java/lang/Throwable
    //   424	438	113	java/lang/Throwable
    //   453	482	113	java/lang/Throwable
    //   484	498	113	java/lang/Throwable
    //   516	545	113	java/lang/Throwable
    //   555	604	113	java/lang/Throwable
    //   613	662	113	java/lang/Throwable
    //   664	693	113	java/lang/Throwable
    //   11	25	696	java/lang/Throwable
    //   25	34	703	java/lang/Throwable
    //   121	130	711	java/lang/Throwable
    //   282	293	719	java/lang/Throwable
  }

  // ERROR //
  private static d a(Context paramContext, Map<String, Long> paramMap)
  {
    // Byte code:
    //   0: new 258	com/umeng/message/b/ar$d
    //   3: dup
    //   4: invokespecial 259	com/umeng/message/b/ar$d:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: invokestatic 264	com/umeng/message/b/af:m	(Landroid/content/Context;)Z
    //   12: ifeq +470 -> 482
    //   15: aload_0
    //   16: invokestatic 266	com/umeng/message/b/ar:g	(Landroid/content/Context;)Z
    //   19: ifeq +463 -> 482
    //   22: ldc 8
    //   24: new 101	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 268
    //   34: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 269	java/lang/Object:toString	()Ljava/lang/String;
    //   41: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc_w 271
    //   47: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 273	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: new 275	org/android/agoo/c/c/d
    //   59: dup
    //   60: invokespecial 276	org/android/agoo/c/c/d:<init>	()V
    //   63: astore_3
    //   64: aload_3
    //   65: ldc_w 278
    //   68: invokevirtual 280	org/android/agoo/c/c/d:c	(Ljava/lang/String;)V
    //   71: aload_3
    //   72: ldc_w 282
    //   75: invokevirtual 284	org/android/agoo/c/c/d:d	(Ljava/lang/String;)V
    //   78: aload_3
    //   79: aload_0
    //   80: invokestatic 286	com/umeng/message/b/af:h	(Landroid/content/Context;)Ljava/lang/String;
    //   83: invokevirtual 288	org/android/agoo/c/c/d:b	(Ljava/lang/String;)V
    //   86: aload_3
    //   87: aload_0
    //   88: invokestatic 290	com/umeng/message/b/af:l	(Landroid/content/Context;)Ljava/lang/String;
    //   91: invokevirtual 292	org/android/agoo/c/c/d:a	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: ldc_w 294
    //   98: new 208	org/json/JSONObject
    //   101: dup
    //   102: aload_1
    //   103: invokespecial 297	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   106: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   109: invokevirtual 301	org/android/agoo/c/c/d:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   112: getstatic 47	com/umeng/message/b/ar:b	Lorg/android/agoo/c/c/b;
    //   115: aload_0
    //   116: aload_3
    //   117: invokeinterface 306 3 0
    //   122: astore 4
    //   124: aload 4
    //   126: ifnull +377 -> 503
    //   129: aload 4
    //   131: invokevirtual 311	org/android/agoo/c/c/i:a	()Ljava/util/Map;
    //   134: aload 4
    //   136: invokevirtual 313	org/android/agoo/c/c/i:f	()I
    //   139: invokestatic 318	com/umeng/message/b/cn:a	(Ljava/util/Map;I)Z
    //   142: ifne +44 -> 186
    //   145: aload_2
    //   146: ldc_w 320
    //   149: invokevirtual 321	com/umeng/message/b/ar$d:a	(Ljava/lang/String;)V
    //   152: aload_2
    //   153: aload 4
    //   155: invokevirtual 324	org/android/agoo/c/c/i:b	()Z
    //   158: invokevirtual 327	com/umeng/message/b/ar$d:a	(Z)V
    //   161: getstatic 60	com/umeng/message/b/ar:h	Ljava/util/Map;
    //   164: ldc_w 329
    //   167: ldc_w 320
    //   170: invokeinterface 335 3 0
    //   175: pop
    //   176: ldc 8
    //   178: ldc_w 337
    //   181: invokestatic 273	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_2
    //   185: areturn
    //   186: aload 4
    //   188: invokevirtual 324	org/android/agoo/c/c/i:b	()Z
    //   191: ifeq +277 -> 468
    //   194: ldc 8
    //   196: new 101	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 339
    //   206: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 4
    //   211: invokevirtual 341	org/android/agoo/c/c/i:c	()Ljava/lang/String;
    //   214: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 271
    //   220: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 273	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: new 208	org/json/JSONObject
    //   232: dup
    //   233: aload 4
    //   235: invokevirtual 341	org/android/agoo/c/c/i:c	()Ljava/lang/String;
    //   238: invokespecial 209	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   241: astore 5
    //   243: ldc 8
    //   245: new 101	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 343
    //   255: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload 5
    //   260: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   263: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 271
    //   269: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 273	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload 5
    //   280: ifnull +188 -> 468
    //   283: aload 5
    //   285: ldc_w 345
    //   288: invokevirtual 347	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 8
    //   293: ldc2_w 232
    //   296: lstore 9
    //   298: ldc 8
    //   300: new 101	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 349
    //   310: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 8
    //   315: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc_w 271
    //   321: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 273	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload 8
    //   332: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   335: istore 11
    //   337: iload 11
    //   339: ifne +108 -> 447
    //   342: aload 5
    //   344: ldc_w 351
    //   347: invokevirtual 347	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   350: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   353: lstore 13
    //   355: lload 13
    //   357: lstore 9
    //   359: aload_2
    //   360: aload 8
    //   362: invokevirtual 358	com/umeng/message/b/ar$d:c	(Ljava/lang/String;)V
    //   365: aload_2
    //   366: aload 4
    //   368: invokevirtual 324	org/android/agoo/c/c/i:b	()Z
    //   371: invokevirtual 327	com/umeng/message/b/ar$d:a	(Z)V
    //   374: aload_2
    //   375: ldc_w 360
    //   378: invokevirtual 361	com/umeng/message/b/ar$d:b	(Ljava/lang/String;)V
    //   381: aload_0
    //   382: aload_1
    //   383: aload 8
    //   385: lload 9
    //   387: ldc_w 363
    //   390: invokestatic 366	com/umeng/message/b/ar:a	(Landroid/content/Context;Ljava/util/Map;Ljava/lang/String;JLjava/lang/String;)V
    //   393: aload_2
    //   394: areturn
    //   395: astore 6
    //   397: aload_2
    //   398: ldc_w 360
    //   401: invokevirtual 361	com/umeng/message/b/ar$d:b	(Ljava/lang/String;)V
    //   404: aload_2
    //   405: aload 6
    //   407: invokevirtual 367	java/lang/Throwable:toString	()Ljava/lang/String;
    //   410: invokevirtual 321	com/umeng/message/b/ar$d:a	(Ljava/lang/String;)V
    //   413: aload_2
    //   414: iconst_0
    //   415: invokevirtual 327	com/umeng/message/b/ar$d:a	(Z)V
    //   418: getstatic 60	com/umeng/message/b/ar:h	Ljava/util/Map;
    //   421: ldc_w 329
    //   424: aload 6
    //   426: invokevirtual 367	java/lang/Throwable:toString	()Ljava/lang/String;
    //   429: invokeinterface 335 3 0
    //   434: pop
    //   435: ldc 8
    //   437: ldc_w 360
    //   440: aload 6
    //   442: invokestatic 370	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   445: aload_2
    //   446: areturn
    //   447: aload_2
    //   448: iconst_0
    //   449: invokevirtual 327	com/umeng/message/b/ar$d:a	(Z)V
    //   452: aload_2
    //   453: ldc_w 360
    //   456: invokevirtual 361	com/umeng/message/b/ar$d:b	(Ljava/lang/String;)V
    //   459: aload_2
    //   460: ldc_w 372
    //   463: invokevirtual 321	com/umeng/message/b/ar$d:a	(Ljava/lang/String;)V
    //   466: aload_2
    //   467: areturn
    //   468: aload_2
    //   469: ldc_w 360
    //   472: invokevirtual 361	com/umeng/message/b/ar$d:b	(Ljava/lang/String;)V
    //   475: aload_2
    //   476: iconst_0
    //   477: invokevirtual 327	com/umeng/message/b/ar$d:a	(Z)V
    //   480: aload_2
    //   481: areturn
    //   482: aload_2
    //   483: ldc_w 360
    //   486: invokevirtual 361	com/umeng/message/b/ar$d:b	(Ljava/lang/String;)V
    //   489: aload_2
    //   490: iconst_0
    //   491: invokevirtual 327	com/umeng/message/b/ar$d:a	(Z)V
    //   494: aload_2
    //   495: ldc_w 374
    //   498: invokevirtual 321	com/umeng/message/b/ar$d:a	(Ljava/lang/String;)V
    //   501: aload_2
    //   502: areturn
    //   503: aconst_null
    //   504: areturn
    //   505: astore 12
    //   507: goto -148 -> 359
    //
    // Exception table:
    //   from	to	target	type
    //   229	278	395	java/lang/Throwable
    //   283	293	395	java/lang/Throwable
    //   298	337	395	java/lang/Throwable
    //   359	393	395	java/lang/Throwable
    //   447	466	395	java/lang/Throwable
    //   342	355	505	java/lang/Throwable
  }

  // ERROR //
  public static final String a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: anewarray 4	java/lang/Object
    //   4: astore 6
    //   6: aload 6
    //   8: iconst_0
    //   9: aload_0
    //   10: invokestatic 183	org/android/a:m	(Landroid/content/Context;)Ljava/lang/String;
    //   13: aastore
    //   14: ldc 32
    //   16: aload 6
    //   18: invokestatic 187	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: astore 7
    //   23: aload_0
    //   24: invokevirtual 191	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   27: aload 7
    //   29: invokestatic 197	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 8
    //   34: aload_0
    //   35: invokestatic 199	com/umeng/message/b/ar:f	(Landroid/content/Context;)Ljava/lang/String;
    //   38: astore 9
    //   40: aload 9
    //   42: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +96 -> 141
    //   48: aload 8
    //   50: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +88 -> 141
    //   56: aload 9
    //   58: aload 8
    //   60: iconst_2
    //   61: invokestatic 204	com/umeng/message/b/ch:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   64: astore_2
    //   65: aload_0
    //   66: aload_2
    //   67: invokestatic 377	com/umeng/message/b/ar:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   70: istore 10
    //   72: iload 10
    //   74: ifeq +36 -> 110
    //   77: ldc 8
    //   79: new 101	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 379
    //   89: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_2
    //   93: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc_w 271
    //   99: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 273	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_2
    //   109: areturn
    //   110: ldc 8
    //   112: new 101	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 381
    //   122: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_2
    //   126: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 383
    //   132: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 273	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_2
    //   146: aload_1
    //   147: astore_3
    //   148: invokestatic 388	org/android/agoo/e/b:a	()Lorg/android/agoo/e/b;
    //   151: astore 4
    //   153: iconst_2
    //   154: anewarray 117	java/lang/String
    //   157: astore 5
    //   159: aload 5
    //   161: iconst_0
    //   162: ldc 18
    //   164: aastore
    //   165: aload 5
    //   167: iconst_1
    //   168: new 101	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 390
    //   178: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_3
    //   182: invokevirtual 367	java/lang/Throwable:toString	()Ljava/lang/String;
    //   185: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: aastore
    //   192: aload 4
    //   194: aload_0
    //   195: ldc 18
    //   197: aload 5
    //   199: invokevirtual 393	org/android/agoo/e/b:a	(Landroid/content/Context;Ljava/lang/Object;[Ljava/lang/String;)V
    //   202: aload_2
    //   203: areturn
    //   204: astore_3
    //   205: goto -57 -> 148
    //
    // Exception table:
    //   from	to	target	type
    //   0	72	143	java/lang/Throwable
    //   110	141	143	java/lang/Throwable
    //   77	108	204	java/lang/Throwable
  }

  public static final void a(Context paramContext, Class<?> paramClass)
  {
    try
    {
      d(paramContext);
      if (paramClass != null)
        paramContext.getPackageManager().setComponentEnabledSetting(new ComponentName(paramContext, paramClass), 1, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.c("ElectionService", "registerApp", localThrowable);
    }
  }

  // ERROR //
  public static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 412	java/util/HashMap
    //   3: dup
    //   4: invokespecial 413	java/util/HashMap:<init>	()V
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: ldc 56
    //   12: astore 4
    //   14: aload_0
    //   15: invokestatic 415	com/umeng/message/b/ar:a	(Landroid/content/Context;)Ljava/lang/String;
    //   18: astore 5
    //   20: invokestatic 420	java/lang/System:currentTimeMillis	()J
    //   23: lstore 6
    //   25: new 412	java/util/HashMap
    //   28: dup
    //   29: invokespecial 413	java/util/HashMap:<init>	()V
    //   32: putstatic 60	com/umeng/message/b/ar:h	Ljava/util/Map;
    //   35: aload_1
    //   36: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +7 -> 46
    //   42: aload_1
    //   43: putstatic 54	com/umeng/message/b/ar:f	Ljava/lang/String;
    //   46: aload_0
    //   47: invokestatic 424	com/umeng/message/b/aq:g	(Landroid/content/Context;)V
    //   50: new 426	com/umeng/message/b/bq
    //   53: dup
    //   54: aload_0
    //   55: ldc_w 428
    //   58: invokespecial 430	com/umeng/message/b/bq:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   61: aload_0
    //   62: invokestatic 434	org/android/a:B	(Landroid/content/Context;)Ljava/util/LinkedHashMap;
    //   65: invokevirtual 437	com/umeng/message/b/bq:a	(Ljava/util/LinkedHashMap;)V
    //   68: new 208	org/json/JSONObject
    //   71: dup
    //   72: invokespecial 438	org/json/JSONObject:<init>	()V
    //   75: astore 12
    //   77: ldc 8
    //   79: new 101	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 440
    //   89: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: invokevirtual 140	android/content/Context:getPackageName	()Ljava/lang/String;
    //   96: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc_w 271
    //   102: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 273	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_0
    //   112: invokestatic 199	com/umeng/message/b/ar:f	(Landroid/content/Context;)Ljava/lang/String;
    //   115: astore 13
    //   117: aload_0
    //   118: invokestatic 183	org/android/a:m	(Landroid/content/Context;)Ljava/lang/String;
    //   121: astore 14
    //   123: aload_0
    //   124: invokevirtual 140	android/content/Context:getPackageName	()Ljava/lang/String;
    //   127: astore 15
    //   129: aload 13
    //   131: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +19 -> 153
    //   137: aload 14
    //   139: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne +11 -> 153
    //   145: aload 15
    //   147: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifeq +53 -> 203
    //   153: getstatic 60	com/umeng/message/b/ar:h	Ljava/util/Map;
    //   156: ldc_w 329
    //   159: ldc_w 442
    //   162: invokeinterface 335 3 0
    //   167: pop
    //   168: ldc 8
    //   170: ldc_w 444
    //   173: invokestatic 446	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_0
    //   177: aload 5
    //   179: getstatic 58	com/umeng/message/b/ar:g	Ljava/lang/String;
    //   182: lload 6
    //   184: aload_2
    //   185: aconst_null
    //   186: aconst_null
    //   187: aload 4
    //   189: invokestatic 449	com/umeng/message/b/ar:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Lcom/umeng/message/b/ar$d;Lcom/umeng/message/b/ar$d;Ljava/lang/String;)V
    //   192: iconst_0
    //   193: ifeq +9 -> 202
    //   196: aconst_null
    //   197: invokeinterface 454 1 0
    //   202: return
    //   203: aload_0
    //   204: invokevirtual 191	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   207: astore 17
    //   209: aload 17
    //   211: ifnonnull +53 -> 264
    //   214: ldc 8
    //   216: ldc_w 456
    //   219: invokestatic 446	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: getstatic 60	com/umeng/message/b/ar:h	Ljava/util/Map;
    //   225: ldc_w 329
    //   228: ldc_w 458
    //   231: invokeinterface 335 3 0
    //   236: pop
    //   237: aload_0
    //   238: aload 5
    //   240: getstatic 58	com/umeng/message/b/ar:g	Ljava/lang/String;
    //   243: lload 6
    //   245: aload_2
    //   246: aconst_null
    //   247: aconst_null
    //   248: aload 4
    //   250: invokestatic 449	com/umeng/message/b/ar:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Lcom/umeng/message/b/ar$d;Lcom/umeng/message/b/ar$d;Ljava/lang/String;)V
    //   253: iconst_0
    //   254: ifeq -52 -> 202
    //   257: aconst_null
    //   258: invokeinterface 454 1 0
    //   263: return
    //   264: new 460	com/umeng/message/b/ax
    //   267: dup
    //   268: ldc_w 462
    //   271: bipush 10
    //   273: invokespecial 465	com/umeng/message/b/ax:<init>	(Ljava/lang/String;I)V
    //   276: astore 11
    //   278: aload 11
    //   280: invokeinterface 468 1 0
    //   285: istore 19
    //   287: aconst_null
    //   288: astore_3
    //   289: iload 19
    //   291: ifne +55 -> 346
    //   294: getstatic 60	com/umeng/message/b/ar:h	Ljava/util/Map;
    //   297: ldc_w 470
    //   300: ldc_w 472
    //   303: invokeinterface 335 3 0
    //   308: pop
    //   309: ldc 8
    //   311: ldc_w 472
    //   314: invokestatic 273	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_0
    //   318: aload 5
    //   320: getstatic 58	com/umeng/message/b/ar:g	Ljava/lang/String;
    //   323: lload 6
    //   325: aload_2
    //   326: aconst_null
    //   327: aconst_null
    //   328: aload 4
    //   330: invokestatic 449	com/umeng/message/b/ar:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Lcom/umeng/message/b/ar$d;Lcom/umeng/message/b/ar$d;Ljava/lang/String;)V
    //   333: aload 11
    //   335: ifnull -133 -> 202
    //   338: aload 11
    //   340: invokeinterface 454 1 0
    //   345: return
    //   346: ldc 35
    //   348: iconst_1
    //   349: anewarray 4	java/lang/Object
    //   352: dup
    //   353: iconst_0
    //   354: aload 14
    //   356: aastore
    //   357: invokestatic 187	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   360: astore 21
    //   362: aload 17
    //   364: aload 21
    //   366: invokestatic 197	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   369: astore 22
    //   371: aload 22
    //   373: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   376: istore 23
    //   378: aconst_null
    //   379: astore 24
    //   381: iload 23
    //   383: ifne +581 -> 964
    //   386: aload 13
    //   388: aload 22
    //   390: iconst_2
    //   391: invokestatic 204	com/umeng/message/b/ch:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   394: astore 25
    //   396: ldc 8
    //   398: new 101	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   405: ldc_w 474
    //   408: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload 25
    //   413: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: ldc_w 271
    //   419: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: aload_0
    //   429: invokevirtual 137	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   432: astore 39
    //   434: aload 39
    //   436: aload 15
    //   438: iconst_0
    //   439: invokevirtual 146	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   442: getfield 151	android/content/pm/ApplicationInfo:flags	I
    //   445: istore 40
    //   447: new 476	android/content/Intent
    //   450: dup
    //   451: ldc_w 478
    //   454: invokespecial 479	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   457: astore 41
    //   459: aload 41
    //   461: aload_0
    //   462: invokestatic 183	org/android/a:m	(Landroid/content/Context;)Ljava/lang/String;
    //   465: invokevirtual 483	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   468: pop
    //   469: aload 39
    //   471: aload 41
    //   473: bipush 32
    //   475: invokevirtual 487	android/content/pm/PackageManager:queryBroadcastReceivers	(Landroid/content/Intent;I)Ljava/util/List;
    //   478: astore 43
    //   480: new 208	org/json/JSONObject
    //   483: dup
    //   484: aload 25
    //   486: invokespecial 209	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   489: astore 44
    //   491: aload 43
    //   493: invokeinterface 493 1 0
    //   498: astore 45
    //   500: aload 4
    //   502: astore 46
    //   504: aload 45
    //   506: invokeinterface 498 1 0
    //   511: ifeq +445 -> 956
    //   514: aload 45
    //   516: invokeinterface 502 1 0
    //   521: checkcast 504	android/content/pm/ResolveInfo
    //   524: astore 47
    //   526: aload 47
    //   528: ifnull -24 -> 504
    //   531: aload 47
    //   533: getfield 508	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   536: astore 52
    //   538: aload 52
    //   540: ifnull +11 -> 551
    //   543: aload 52
    //   545: instanceof 510
    //   548: ifne +42 -> 590
    //   551: ldc_w 512
    //   554: astore 46
    //   556: ldc 8
    //   558: ldc_w 514
    //   561: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: goto -60 -> 504
    //   567: astore 48
    //   569: aload 46
    //   571: astore 49
    //   573: ldc 8
    //   575: ldc_w 516
    //   578: aload 48
    //   580: invokestatic 370	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   583: aload 49
    //   585: astore 46
    //   587: goto -83 -> 504
    //   590: aload 52
    //   592: getfield 519	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   595: astore 53
    //   597: aload 53
    //   599: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   602: ifne +11 -> 613
    //   605: aload 52
    //   607: invokevirtual 522	android/content/pm/ActivityInfo:isEnabled	()Z
    //   610: ifne +75 -> 685
    //   613: new 101	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   620: aload 46
    //   622: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc_w 524
    //   628: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload 53
    //   633: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: ldc 166
    //   638: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: astore 46
    //   646: ldc 8
    //   648: new 101	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 526
    //   658: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload 53
    //   663: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: ldc 166
    //   668: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: goto -173 -> 504
    //   680: astore 54
    //   682: goto -178 -> 504
    //   685: aload 44
    //   687: aload 53
    //   689: invokevirtual 217	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   692: astore 55
    //   694: aload 55
    //   696: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   699: ifeq +109 -> 808
    //   702: new 101	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   709: aload 46
    //   711: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: ldc_w 524
    //   717: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload 53
    //   722: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: ldc_w 528
    //   728: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: astore 46
    //   736: ldc 8
    //   738: new 101	java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   745: ldc_w 526
    //   748: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload 53
    //   753: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: ldc_w 530
    //   759: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   768: goto -264 -> 504
    //   771: astore 10
    //   773: aload 46
    //   775: astore 4
    //   777: aload_0
    //   778: aload 5
    //   780: getstatic 58	com/umeng/message/b/ar:g	Ljava/lang/String;
    //   783: lload 6
    //   785: aload_2
    //   786: aload_3
    //   787: aconst_null
    //   788: aload 4
    //   790: invokestatic 449	com/umeng/message/b/ar:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Lcom/umeng/message/b/ar$d;Lcom/umeng/message/b/ar$d;Ljava/lang/String;)V
    //   793: aload 11
    //   795: ifnull +10 -> 805
    //   798: aload 11
    //   800: invokeinterface 454 1 0
    //   805: aload 10
    //   807: athrow
    //   808: aload_0
    //   809: aload 53
    //   811: aload 55
    //   813: iload 40
    //   815: invokestatic 532	com/umeng/message/b/ar:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Lcom/umeng/message/b/ar$a;
    //   818: astore 56
    //   820: aload 56
    //   822: ifnull +82 -> 904
    //   825: ldc 8
    //   827: new 101	java/lang/StringBuilder
    //   830: dup
    //   831: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   834: ldc_w 526
    //   837: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: aload 53
    //   842: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: ldc_w 534
    //   848: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: aload 56
    //   853: invokevirtual 536	com/umeng/message/b/ar$a:c	()J
    //   856: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   859: ldc 255
    //   861: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   870: aload 12
    //   872: aload 53
    //   874: aload 56
    //   876: invokevirtual 539	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   879: pop
    //   880: aload_2
    //   881: aload 53
    //   883: aload 56
    //   885: invokevirtual 536	com/umeng/message/b/ar$a:c	()J
    //   888: invokestatic 543	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   891: invokeinterface 335 3 0
    //   896: pop
    //   897: aload 46
    //   899: astore 49
    //   901: goto -318 -> 583
    //   904: new 101	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   911: aload 46
    //   913: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: ldc_w 545
    //   919: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload 53
    //   924: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: ldc_w 547
    //   930: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: aload 55
    //   935: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: ldc_w 271
    //   941: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: astore 59
    //   949: aload 59
    //   951: astore 49
    //   953: goto -370 -> 583
    //   956: aload 46
    //   958: astore 4
    //   960: aload 44
    //   962: astore 24
    //   964: aload 24
    //   966: ifnonnull +126 -> 1092
    //   969: aload_0
    //   970: invokestatic 264	com/umeng/message/b/af:m	(Landroid/content/Context;)Z
    //   973: ifeq +119 -> 1092
    //   976: ldc 8
    //   978: new 101	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   985: ldc_w 549
    //   988: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: aload 15
    //   993: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: ldc_w 551
    //   999: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: aload 15
    //   1004: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: ldc_w 553
    //   1010: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: invokestatic 555	com/umeng/message/b/af:a	()J
    //   1016: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1019: ldc_w 271
    //   1022: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: invokestatic 560	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1031: pop
    //   1032: aload_2
    //   1033: aload 15
    //   1035: invokestatic 555	com/umeng/message/b/af:a	()J
    //   1038: invokestatic 543	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1041: invokeinterface 335 3 0
    //   1046: pop
    //   1047: new 221	com/umeng/message/b/ar$a
    //   1050: dup
    //   1051: invokespecial 561	com/umeng/message/b/ar$a:<init>	()V
    //   1054: astore 37
    //   1056: aload 37
    //   1058: aload_0
    //   1059: invokestatic 564	com/umeng/message/b/ar:b	(Landroid/content/Context;)I
    //   1062: invokevirtual 567	com/umeng/message/b/ar$a:a	(I)V
    //   1065: aload 37
    //   1067: invokestatic 555	com/umeng/message/b/af:a	()J
    //   1070: invokevirtual 570	com/umeng/message/b/ar$a:b	(J)V
    //   1073: aload 37
    //   1075: aload_0
    //   1076: invokestatic 573	com/umeng/message/b/ar:c	(Landroid/content/Context;)J
    //   1079: invokevirtual 575	com/umeng/message/b/ar$a:a	(J)V
    //   1082: aload 12
    //   1084: aload 15
    //   1086: aload 37
    //   1088: invokevirtual 539	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1091: pop
    //   1092: aconst_null
    //   1093: astore_3
    //   1094: aload_2
    //   1095: ifnull +12 -> 1107
    //   1098: aload_2
    //   1099: invokeinterface 578 1 0
    //   1104: ifgt +116 -> 1220
    //   1107: getstatic 60	com/umeng/message/b/ar:h	Ljava/util/Map;
    //   1110: ldc_w 329
    //   1113: ldc_w 580
    //   1116: invokeinterface 335 3 0
    //   1121: pop
    //   1122: aload 17
    //   1124: aload 21
    //   1126: aconst_null
    //   1127: invokestatic 584	android/provider/Settings$System:putString	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   1130: pop
    //   1131: aload_0
    //   1132: aload 5
    //   1134: getstatic 58	com/umeng/message/b/ar:g	Ljava/lang/String;
    //   1137: lload 6
    //   1139: aload_2
    //   1140: aconst_null
    //   1141: aconst_null
    //   1142: aload 4
    //   1144: invokestatic 449	com/umeng/message/b/ar:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Lcom/umeng/message/b/ar$d;Lcom/umeng/message/b/ar$d;Ljava/lang/String;)V
    //   1147: aload 11
    //   1149: ifnull -947 -> 202
    //   1152: aload 11
    //   1154: invokeinterface 454 1 0
    //   1159: return
    //   1160: astore 26
    //   1162: ldc 8
    //   1164: ldc_w 516
    //   1167: aload 26
    //   1169: invokestatic 370	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1172: goto -208 -> 964
    //   1175: astore 8
    //   1177: aload 11
    //   1179: astore 9
    //   1181: ldc 8
    //   1183: ldc_w 516
    //   1186: aload 8
    //   1188: invokestatic 370	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1191: aload_0
    //   1192: aload 5
    //   1194: getstatic 58	com/umeng/message/b/ar:g	Ljava/lang/String;
    //   1197: lload 6
    //   1199: aload_2
    //   1200: aload_3
    //   1201: aconst_null
    //   1202: aload 4
    //   1204: invokestatic 449	com/umeng/message/b/ar:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Lcom/umeng/message/b/ar$d;Lcom/umeng/message/b/ar$d;Ljava/lang/String;)V
    //   1207: aload 9
    //   1209: ifnull -1007 -> 202
    //   1212: aload 9
    //   1214: invokeinterface 454 1 0
    //   1219: return
    //   1220: aload 12
    //   1222: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1225: astore 33
    //   1227: ldc 8
    //   1229: new 101	java/lang/StringBuilder
    //   1232: dup
    //   1233: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   1236: ldc_w 586
    //   1239: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: aload 33
    //   1244: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: ldc_w 271
    //   1250: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1256: invokestatic 160	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1259: aload 17
    //   1261: aload 21
    //   1263: aload 13
    //   1265: aload 33
    //   1267: iconst_2
    //   1268: invokestatic 588	com/umeng/message/b/ch:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1271: invokestatic 584	android/provider/Settings$System:putString	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   1274: pop
    //   1275: aload_0
    //   1276: aload_2
    //   1277: invokestatic 590	com/umeng/message/b/ar:a	(Landroid/content/Context;Ljava/util/Map;)Lcom/umeng/message/b/ar$d;
    //   1280: astore_3
    //   1281: aload_3
    //   1282: ifnull +17 -> 1299
    //   1285: aload_3
    //   1286: invokevirtual 591	com/umeng/message/b/ar$d:b	()Z
    //   1289: istore 30
    //   1291: aconst_null
    //   1292: astore 31
    //   1294: iload 30
    //   1296: ifne +14 -> 1310
    //   1299: aload_0
    //   1300: aload_2
    //   1301: invokestatic 593	com/umeng/message/b/ar:b	(Landroid/content/Context;Ljava/util/Map;)Lcom/umeng/message/b/ar$d;
    //   1304: astore 32
    //   1306: aload 32
    //   1308: astore 31
    //   1310: aload_0
    //   1311: aload 5
    //   1313: getstatic 58	com/umeng/message/b/ar:g	Ljava/lang/String;
    //   1316: lload 6
    //   1318: aload_2
    //   1319: aload_3
    //   1320: aload 31
    //   1322: aload 4
    //   1324: invokestatic 449	com/umeng/message/b/ar:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Lcom/umeng/message/b/ar$d;Lcom/umeng/message/b/ar$d;Ljava/lang/String;)V
    //   1327: aload 11
    //   1329: ifnull -1127 -> 202
    //   1332: aload 11
    //   1334: invokeinterface 454 1 0
    //   1339: return
    //   1340: astore 10
    //   1342: aconst_null
    //   1343: astore_3
    //   1344: aconst_null
    //   1345: astore 11
    //   1347: goto -570 -> 777
    //   1350: astore 10
    //   1352: goto -575 -> 777
    //   1355: astore 51
    //   1357: aload 49
    //   1359: astore 4
    //   1361: aload 51
    //   1363: astore 10
    //   1365: aconst_null
    //   1366: astore_3
    //   1367: goto -590 -> 777
    //   1370: astore 10
    //   1372: aload 9
    //   1374: astore 11
    //   1376: goto -599 -> 777
    //   1379: astore 8
    //   1381: aconst_null
    //   1382: astore_3
    //   1383: aconst_null
    //   1384: astore 9
    //   1386: goto -205 -> 1181
    //   1389: astore 29
    //   1391: goto -116 -> 1275
    //   1394: astore 26
    //   1396: aload 44
    //   1398: astore 24
    //   1400: goto -238 -> 1162
    //   1403: astore 26
    //   1405: aload 46
    //   1407: astore 4
    //   1409: aload 44
    //   1411: astore 24
    //   1413: goto -251 -> 1162
    //   1416: astore 50
    //   1418: aload 49
    //   1420: astore 4
    //   1422: aload 50
    //   1424: astore 26
    //   1426: aload 44
    //   1428: astore 24
    //   1430: goto -268 -> 1162
    //
    // Exception table:
    //   from	to	target	type
    //   531	538	567	java/lang/Throwable
    //   543	551	567	java/lang/Throwable
    //   556	564	567	java/lang/Throwable
    //   590	597	567	java/lang/Throwable
    //   685	768	567	java/lang/Throwable
    //   808	820	567	java/lang/Throwable
    //   825	897	567	java/lang/Throwable
    //   904	949	567	java/lang/Throwable
    //   597	613	680	java/lang/Throwable
    //   613	677	680	java/lang/Throwable
    //   504	526	771	finally
    //   531	538	771	finally
    //   543	551	771	finally
    //   556	564	771	finally
    //   590	597	771	finally
    //   597	613	771	finally
    //   613	677	771	finally
    //   685	768	771	finally
    //   808	820	771	finally
    //   825	897	771	finally
    //   904	949	771	finally
    //   396	491	1160	java/lang/Throwable
    //   278	287	1175	java/lang/Throwable
    //   294	317	1175	java/lang/Throwable
    //   346	378	1175	java/lang/Throwable
    //   386	396	1175	java/lang/Throwable
    //   969	1092	1175	java/lang/Throwable
    //   1098	1107	1175	java/lang/Throwable
    //   1107	1131	1175	java/lang/Throwable
    //   1162	1172	1175	java/lang/Throwable
    //   1275	1281	1175	java/lang/Throwable
    //   1285	1291	1175	java/lang/Throwable
    //   1299	1306	1175	java/lang/Throwable
    //   35	46	1340	finally
    //   46	153	1340	finally
    //   153	176	1340	finally
    //   203	209	1340	finally
    //   214	237	1340	finally
    //   264	278	1340	finally
    //   278	287	1350	finally
    //   294	317	1350	finally
    //   346	378	1350	finally
    //   386	396	1350	finally
    //   396	491	1350	finally
    //   491	500	1350	finally
    //   969	1092	1350	finally
    //   1098	1107	1350	finally
    //   1107	1131	1350	finally
    //   1162	1172	1350	finally
    //   1220	1275	1350	finally
    //   1275	1281	1350	finally
    //   1285	1291	1350	finally
    //   1299	1306	1350	finally
    //   573	583	1355	finally
    //   1181	1191	1370	finally
    //   35	46	1379	java/lang/Throwable
    //   46	153	1379	java/lang/Throwable
    //   153	176	1379	java/lang/Throwable
    //   203	209	1379	java/lang/Throwable
    //   214	237	1379	java/lang/Throwable
    //   264	278	1379	java/lang/Throwable
    //   1220	1275	1389	java/lang/Throwable
    //   491	500	1394	java/lang/Throwable
    //   504	526	1403	java/lang/Throwable
    //   573	583	1416	java/lang/Throwable
  }

  private static void a(Context paramContext, String paramString1, String paramString2, long paramLong, Map<String, Long> paramMap, d paramd1, d paramd2, String paramString3)
  {
    if (paramd1 != null);
    while (true)
    {
      try
      {
        if (paramd1.b())
          break label959;
        if ((paramd2 == null) || (!paramd2.b()))
          break label967;
        break label959;
        String str2 = a.g(paramContext);
        if ((paramd1 == null) || (paramd1.b()))
          continue;
        str3 = "remoteRet=" + paramd1.a() + "-->remoteFailed=" + paramd1.b() + "-->remoteSudoPack=" + paramd1.d() + "-->source=" + paramd1.c();
        localObject = null;
        if ((paramMap == null) || (paramMap.isEmpty()))
          break label944;
        str4 = paramMap.toString();
        if (TextUtils.isEmpty(null))
        {
          str5 = (String)h.get("electionFailed");
          String str6 = (String)h.get("lock");
          StringBuffer localStringBuffer = new StringBuffer();
          localStringBuffer.append("utdid=" + aq.c(paramContext));
          localStringBuffer.append("-->");
          localStringBuffer.append("deviceId=" + str2);
          localStringBuffer.append("-->");
          localStringBuffer.append("appkey=" + af.f(paramContext));
          localStringBuffer.append("-->");
          localStringBuffer.append("startTime=" + ce.a(paramLong));
          localStringBuffer.append("-->");
          localStringBuffer.append("ret=" + str1);
          localStringBuffer.append("-->");
          localStringBuffer.append("fail_reasons=" + null);
          localStringBuffer.append("-->");
          localStringBuffer.append("currentPackage=" + paramContext.getPackageName());
          localStringBuffer.append("-->");
          localStringBuffer.append("packsMap=" + str4);
          localStringBuffer.append("-->");
          localStringBuffer.append("lastsudo=" + paramString1);
          localStringBuffer.append("-->");
          localStringBuffer.append("currentsudo=" + paramString2);
          localStringBuffer.append("-->");
          localStringBuffer.append("finishtime=" + ce.a(System.currentTimeMillis()));
          localStringBuffer.append("-->");
          localStringBuffer.append("errorMapString=" + str5);
          localStringBuffer.append("-->");
          localStringBuffer.append("lock=" + str6);
          localStringBuffer.append("-->");
          localStringBuffer.append("errorStr=" + paramString3);
          localStringBuffer.append("-->");
          localStringBuffer.append("sdkVersion=" + af.a());
          localStringBuffer.append("-->");
          localStringBuffer.append("remoteInfo=" + str3);
          localStringBuffer.append("-->");
          localStringBuffer.append("localInfo=" + (String)localObject);
          localStringBuffer.append("-->");
          localStringBuffer.append("election");
          aq.e(paramContext, str1, localStringBuffer.toString());
          return;
          if ((paramd2 == null) || (paramd2.b()))
            break label950;
          String str7 = "LocalRet=" + paramd2.a() + "-->localFailed=" + paramd2.b() + "-->localSudoPack=" + paramd2.d() + "-->source=" + paramd2.c();
          localObject = str7;
          str3 = null;
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        aq.e(paramContext, "n", localThrowable.toString());
        return;
      }
      String str5 = null;
      continue;
      label944: String str4 = null;
      continue;
      label950: Object localObject = null;
      String str3 = null;
      continue;
      label959: String str1 = "y";
      continue;
      label967: str1 = "n";
    }
  }

  private static final void a(Context paramContext, Map<String, Long> paramMap, String paramString1, long paramLong, String paramString2)
  {
    boolean bool1 = true;
    if ((paramMap == null) || (paramMap.size() <= 0))
      return;
    String str = a(paramContext);
    if (!TextUtils.isEmpty(str))
      ay.c("ElectionService", "noticeElectionResult[lastSudoPack:" + str + "]");
    ay.c("ElectionService", "noticeElectionResult[sudoPack:" + paramString1 + "][timeout:" + paramLong + "][electionSource:" + paramString2 + "]");
    g = paramString1;
    b(paramContext, paramString1);
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("election_result", paramString1);
    localIntent1.putExtra("election_source", paramString2);
    localIntent1.putExtra("election_timeout", paramLong);
    localIntent1.setAction("org.agoo.android.intent.action.ELECTION_RESULT_V4");
    localIntent1.setFlags(32);
    localIntent1.addCategory(a.m(paramContext));
    localIntent1.setPackage(paramString1);
    if (!TextUtils.isEmpty(f))
      localIntent1.putExtra("eventId", f);
    i = paramContext;
    a.f(paramContext, false);
    paramContext.sendBroadcast(localIntent1);
    a(paramString1, localIntent1);
    ay.c("ElectionService", "lastSudoPack=" + str);
    StringBuilder localStringBuilder1 = new StringBuilder().append("!TextUtils.isEmpty(lastSudoPack)=");
    boolean bool2;
    label293: StringBuilder localStringBuilder2;
    if (!TextUtils.isEmpty(str))
    {
      bool2 = bool1;
      ay.c("ElectionService", bool2);
      localStringBuilder2 = new StringBuilder().append("!TextUtils.equals(currentSudoPack, lastSudoPack)=");
      if (TextUtils.equals(paramString1, str))
        break label491;
    }
    while (true)
    {
      ay.c("ElectionService", bool1);
      if ((TextUtils.isEmpty(str)) || (TextUtils.equals(paramString1, str)))
        break;
      ay.c("ElectionService", "noticeElectionResult[lastSudoPack:" + str + "]stop");
      Intent localIntent2 = new Intent();
      localIntent2.putExtra("election_result", paramString1);
      localIntent2.putExtra("election_source", paramString2);
      localIntent2.putExtra("election_timeout", paramLong);
      localIntent2.setAction("org.agoo.android.intent.action.ELECTION_RESULT_V4");
      localIntent2.setFlags(32);
      localIntent2.addCategory(a.m(paramContext));
      localIntent2.setPackage(str);
      paramContext.sendBroadcast(localIntent2);
      a(str, localIntent2);
      return;
      bool2 = false;
      break label293;
      label491: bool1 = false;
    }
  }

  private static void a(String paramString, Intent paramIntent)
  {
    try
    {
      k.post(new e(paramString, paramIntent));
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ElectionService", "noticeElectionBindService error >>", localThrowable);
    }
  }

  private static final boolean a(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext, paramString, null, paramInt) != null;
  }

  private static int b(Context paramContext)
  {
    int i1 = -1;
    if (paramContext != null);
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      String str = localPackageInfo.versionName;
      int i2 = localPackageInfo.versionCode;
      int i3 = Math.abs((str + "." + i2).hashCode());
      i1 = i3;
      return i1;
    }
    catch (Throwable localThrowable)
    {
    }
    return i1;
  }

  private static final long b(PackageInfo paramPackageInfo)
  {
    long l1 = -1L;
    try
    {
      if (Build.VERSION.SDK_INT >= 9)
        l1 = paramPackageInfo.lastUpdateTime;
      return l1;
    }
    catch (Throwable localThrowable)
    {
      ay.e("ElectionService", "registerApp", localThrowable);
    }
    return l1;
  }

  private static d b(Context paramContext, Map<String, Long> paramMap)
  {
    d locald = new d();
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      ay.e("ElectionService", "localElection failed [null == packMap || 0 >= packMap.size()]");
      locald.b("localElection");
      locald.a("[null == packMap || 0 >= packMap.size()");
      locald.a(false);
      return locald;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    ArrayList localArrayList = new ArrayList();
    long l1 = -1L;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str3 = (String)localEntry.getKey();
      long l2 = ((Long)localEntry.getValue()).longValue();
      if (l2 > l1)
      {
        localArrayList.clear();
        l1 = l2;
      }
      if (l2 != l1)
        continue;
      localArrayList.add(str3);
    }
    String str1 = (String)localArrayList.get(c.nextInt(10000) % localArrayList.size());
    String str2;
    if (TextUtils.isEmpty(str1))
    {
      locald.b("localElection");
      locald.c(str1);
      locald.a(true);
      str2 = paramContext.getPackageName();
      ay.c("ElectionService", "sudoPack==currentPack[:" + str2 + "]");
    }
    while (true)
    {
      a(paramContext, paramMap, str2, -1L, "local");
      return locald;
      str2 = str1;
    }
  }

  public static void b(Context paramContext, Class<?> paramClass)
  {
    if (paramContext != null);
    try
    {
      e(paramContext);
      if (paramClass != null)
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        ComponentName localComponentName = new ComponentName(paramContext, paramClass);
        ay.c("ElectionService", "unRegisterApp[" + localComponentName.toString() + "]");
        localPackageManager.setComponentEnabledSetting(localComponentName, 2, 1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.c("ElectionService", "unRegisterApp", localThrowable);
    }
  }

  private static final void b(Context paramContext, String paramString)
  {
    try
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a.m(paramContext);
      String str1 = String.format("org.agoo.android.sudo.%s", arrayOfObject);
      String str2 = f(paramContext);
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramString)))
      {
        String str3 = ch.a(str2, paramString, 2);
        Settings.System.putString(paramContext.getContentResolver(), str1, str3);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("ElectionService", "setCurrentSudo", localThrowable);
      org.android.agoo.e.b localb = org.android.agoo.e.b.a();
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "set_CurrentSudo";
      arrayOfString[1] = ("exp=" + localThrowable.toString());
      localb.a(paramContext, "set_CurrentSudo", arrayOfString);
    }
  }

  private static final long c(Context paramContext)
  {
    long l1 = -1L;
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 2);
      if (Build.VERSION.SDK_INT >= 9)
        l1 = localPackageInfo.lastUpdateTime;
      return l1;
    }
    catch (Throwable localThrowable)
    {
      ay.e("ElectionService", "registerApp", localThrowable);
    }
    return l1;
  }

  private static final boolean c(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, -1);
  }

  // ERROR //
  private static final void d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 199	com/umeng/message/b/ar:f	(Landroid/content/Context;)Ljava/lang/String;
    //   4: astore 4
    //   6: aload_0
    //   7: invokevirtual 140	android/content/Context:getPackageName	()Ljava/lang/String;
    //   10: astore 5
    //   12: aload_0
    //   13: invokestatic 183	org/android/a:m	(Landroid/content/Context;)Ljava/lang/String;
    //   16: astore 6
    //   18: aload 4
    //   20: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +339 -> 362
    //   26: aload 6
    //   28: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +331 -> 362
    //   34: aload 5
    //   36: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifeq +4 -> 43
    //   42: return
    //   43: aload_0
    //   44: invokevirtual 191	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   47: astore 7
    //   49: aload 7
    //   51: ifnull +311 -> 362
    //   54: new 221	com/umeng/message/b/ar$a
    //   57: dup
    //   58: invokespecial 561	com/umeng/message/b/ar$a:<init>	()V
    //   61: astore 8
    //   63: aload 8
    //   65: invokestatic 555	com/umeng/message/b/af:a	()J
    //   68: invokevirtual 570	com/umeng/message/b/ar$a:b	(J)V
    //   71: aload 8
    //   73: aload_0
    //   74: invokestatic 573	com/umeng/message/b/ar:c	(Landroid/content/Context;)J
    //   77: invokevirtual 575	com/umeng/message/b/ar$a:a	(J)V
    //   80: aload 8
    //   82: aload_0
    //   83: invokestatic 564	com/umeng/message/b/ar:b	(Landroid/content/Context;)I
    //   86: invokevirtual 567	com/umeng/message/b/ar$a:a	(I)V
    //   89: aload 8
    //   91: aload_0
    //   92: invokestatic 634	com/umeng/message/b/af:f	(Landroid/content/Context;)Ljava/lang/String;
    //   95: invokevirtual 821	com/umeng/message/b/ar$a:b	(Ljava/lang/String;)V
    //   98: ldc 35
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload 6
    //   108: aastore
    //   109: invokestatic 187	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   112: astore 9
    //   114: aload 7
    //   116: aload 9
    //   118: invokestatic 197	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 10
    //   123: aload 10
    //   125: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: istore 11
    //   130: aconst_null
    //   131: astore 12
    //   133: iload 11
    //   135: ifne +53 -> 188
    //   138: aload 4
    //   140: aload 10
    //   142: iconst_2
    //   143: invokestatic 204	com/umeng/message/b/ch:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   146: astore 16
    //   148: aload 16
    //   150: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifeq +173 -> 326
    //   156: ldc 8
    //   158: new 101	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 823
    //   168: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 10
    //   173: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 825
    //   179: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 446	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 12
    //   190: ifnonnull +12 -> 202
    //   193: new 208	org/json/JSONObject
    //   196: dup
    //   197: invokespecial 438	org/json/JSONObject:<init>	()V
    //   200: astore 12
    //   202: aload 12
    //   204: aload 5
    //   206: aload 8
    //   208: invokevirtual 539	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   211: pop
    //   212: ldc 8
    //   214: new 101	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 827
    //   224: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 12
    //   229: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   232: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 271
    //   238: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 273	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload 7
    //   249: aload 9
    //   251: aload 4
    //   253: aload 12
    //   255: invokevirtual 298	org/json/JSONObject:toString	()Ljava/lang/String;
    //   258: iconst_2
    //   259: invokestatic 588	com/umeng/message/b/ch:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   262: invokestatic 584	android/provider/Settings$System:putString	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   265: pop
    //   266: return
    //   267: astore_1
    //   268: ldc 8
    //   270: ldc_w 407
    //   273: aload_1
    //   274: invokestatic 370	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: invokestatic 388	org/android/agoo/e/b:a	()Lorg/android/agoo/e/b;
    //   280: astore_2
    //   281: iconst_2
    //   282: anewarray 117	java/lang/String
    //   285: astore_3
    //   286: aload_3
    //   287: iconst_0
    //   288: ldc 18
    //   290: aastore
    //   291: aload_3
    //   292: iconst_1
    //   293: new 101	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 390
    //   303: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_1
    //   307: invokevirtual 367	java/lang/Throwable:toString	()Ljava/lang/String;
    //   310: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: aastore
    //   317: aload_2
    //   318: aload_0
    //   319: ldc 18
    //   321: aload_3
    //   322: invokevirtual 393	org/android/agoo/e/b:a	(Landroid/content/Context;Ljava/lang/Object;[Ljava/lang/String;)V
    //   325: return
    //   326: new 208	org/json/JSONObject
    //   329: dup
    //   330: aload 16
    //   332: invokespecial 209	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   335: astore 17
    //   337: aload 17
    //   339: astore 12
    //   341: goto -153 -> 188
    //   344: astore 15
    //   346: ldc 8
    //   348: ldc_w 407
    //   351: aload 15
    //   353: invokestatic 370	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   356: aconst_null
    //   357: astore 12
    //   359: goto -171 -> 188
    //   362: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	42	267	java/lang/Throwable
    //   43	49	267	java/lang/Throwable
    //   54	130	267	java/lang/Throwable
    //   193	202	267	java/lang/Throwable
    //   202	266	267	java/lang/Throwable
    //   346	356	267	java/lang/Throwable
    //   138	188	344	java/lang/Throwable
    //   326	337	344	java/lang/Throwable
  }

  private static void e(Context paramContext)
  {
    try
    {
      String str1 = f(paramContext);
      String str2 = paramContext.getPackageName();
      String str3 = a.m(paramContext);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)))
      {
        if (TextUtils.isEmpty(str2))
          return;
        ContentResolver localContentResolver = paramContext.getContentResolver();
        if (localContentResolver != null)
        {
          String str4 = String.format("org.agoo.android.packs_v1.%s", new Object[] { str3 });
          String str5 = Settings.System.getString(localContentResolver, str4);
          if (!TextUtils.isEmpty(str5))
          {
            String str6 = ch.b(str1, str5, 2);
            if (!TextUtils.isEmpty(str6))
            {
              ay.c("ElectionService", "unRegister old appInfo[" + str6 + "]");
              JSONObject localJSONObject = new JSONObject(str6);
              localJSONObject.remove(str2);
              ay.c("ElectionService", "unRegister save[" + localJSONObject.toString() + "]");
              String str7 = ch.a(str1, localJSONObject.toString(), 2);
              Settings.System.putString(paramContext.getContentResolver(), str4, str7);
              return;
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      ay.e("ElectionService", "Exception", localThrowable);
      org.android.agoo.e.b localb = org.android.agoo.e.b.a();
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "get_CurrentSudo";
      arrayOfString[1] = ("exp=" + localThrowable.toString());
      localb.a(paramContext, "get_CurrentSudo", arrayOfString);
    }
  }

  private static final String f(Context paramContext)
  {
    String str = aq.c(paramContext);
    if (TextUtils.isEmpty(str))
    {
      ay.c("ElectionService", "getPassword[utdid==null]");
      str = "17984173941739471471917341";
    }
    return str;
  }

  private static final boolean g(Context paramContext)
  {
    String str1 = af.f(paramContext);
    String str2 = af.h(paramContext);
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
    String str3;
    do
    {
      return false;
      b.a(str1);
      str3 = af.j(paramContext);
    }
    while ((TextUtils.isEmpty(str3)) && (!af.E(paramContext)));
    b.b(str3);
    b.c(af.G(paramContext));
    return true;
  }

  static final class a
  {
    private long a = -1L;
    private long b = -1L;
    private int c = -1;
    private String d = null;

    // ERROR //
    static a a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   4: ifne +77 -> 81
      //   7: new 36	org/json/JSONObject
      //   10: dup
      //   11: aload_0
      //   12: invokespecial 39	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   15: astore_2
      //   16: new 2	com/umeng/message/b/ar$a
      //   19: dup
      //   20: invokespecial 40	com/umeng/message/b/ar$a:<init>	()V
      //   23: astore_3
      //   24: aload_3
      //   25: aload_2
      //   26: ldc 42
      //   28: ldc2_w 16
      //   31: invokevirtual 46	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
      //   34: putfield 19	com/umeng/message/b/ar$a:a	J
      //   37: aload_3
      //   38: aload_2
      //   39: ldc 48
      //   41: ldc2_w 16
      //   44: invokevirtual 46	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
      //   47: putfield 21	com/umeng/message/b/ar$a:b	J
      //   50: aload_3
      //   51: aload_2
      //   52: ldc 50
      //   54: iconst_m1
      //   55: invokevirtual 54	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
      //   58: putfield 23	com/umeng/message/b/ar$a:c	I
      //   61: aload_3
      //   62: aload_2
      //   63: ldc 56
      //   65: aconst_null
      //   66: invokevirtual 60	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   69: putfield 25	com/umeng/message/b/ar$a:d	Ljava/lang/String;
      //   72: aload_3
      //   73: areturn
      //   74: astore_1
      //   75: aconst_null
      //   76: areturn
      //   77: astore 4
      //   79: aload_3
      //   80: areturn
      //   81: aconst_null
      //   82: areturn
      //
      // Exception table:
      //   from	to	target	type
      //   0	24	74	java/lang/Throwable
      //   24	72	77	java/lang/Throwable
    }

    public int a()
    {
      return this.c;
    }

    public void a(int paramInt)
    {
      this.c = paramInt;
    }

    public void a(long paramLong)
    {
      this.a = paramLong;
    }

    public long b()
    {
      return this.a;
    }

    public void b(long paramLong)
    {
      this.b = paramLong;
    }

    public void b(String paramString)
    {
      this.d = paramString;
    }

    public long c()
    {
      return this.b;
    }

    public String d()
    {
      return this.d;
    }

    public String toString()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("appInstallTime", this.a);
        localJSONObject.put("appSdkVersion", this.b);
        localJSONObject.put("appVersionHash", this.c);
        localJSONObject.put("appKey", this.d);
        String str = localJSONObject.toString();
        return str;
      }
      catch (Throwable localThrowable)
      {
      }
      return null;
    }
  }

  static class b
    implements Handler.Callback
  {
    public boolean handleMessage(Message paramMessage)
    {
      return true;
    }
  }

  static class c
    implements ServiceConnection
  {
    private Intent a;
    private ElectionReceiverService b;
    private ServiceConnection c;

    public c(Intent paramIntent)
    {
      this.a = paramIntent;
      this.c = this;
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      Log.d("ElectionService", "ElectionConnection conneted:" + paramComponentName);
      this.b = ElectionReceiverService.Stub.asInterface(paramIBinder);
      Log.d("ElectionService", "onConnected current tid:" + Thread.currentThread().getId());
      Log.d("ElectionService", "ElectionConnection sent:" + this.a);
      if (this.b != null)
        ar.b().post(new as(this));
    }

    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      Log.d("ElectionService", "MessageConnection disConnected");
    }
  }

  static final class d
  {
    private String a;
    private boolean b;
    private String c;
    private String d;

    public String a()
    {
      return this.a;
    }

    public void a(String paramString)
    {
      this.a = paramString;
    }

    public void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }

    public void b(String paramString)
    {
      this.c = paramString;
    }

    public boolean b()
    {
      return this.b;
    }

    public String c()
    {
      return this.c;
    }

    public void c(String paramString)
    {
      this.d = paramString;
    }

    public String d()
    {
      return this.d;
    }
  }

  static class e
    implements Runnable
  {
    private String a;
    private Intent b;

    public e(String paramString, Intent paramIntent)
    {
      this.a = paramString;
      this.b = paramIntent;
    }

    public void run()
    {
      Intent localIntent1 = new Intent();
      Log.d("ElectionService", "this election sudupack:" + this.a + ",action=" + this.b.getAction());
      localIntent1.setAction(this.b.getAction());
      localIntent1.putExtras(this.b.getExtras());
      localIntent1.setFlags(this.b.getFlags());
      localIntent1.setPackage(this.b.getPackage());
      localIntent1.addCategory(a.m(ar.a()));
      Log.d("ElectionService", "start to service...");
      try
      {
        ar.c localc = new ar.c(localIntent1);
        Intent localIntent2 = new Intent("org.android.agoo.client.ElectionReceiverService");
        Log.d("ElectionService", "this message pack:" + this.a);
        localIntent2.setPackage(this.a);
        boolean bool2 = ar.a().bindService(localIntent2, localc, 17);
        bool1 = bool2;
        Log.d("ElectionService", "start service ret:" + bool1);
        return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          Log.d("ElectionService", "ElectionConnection,bindService error,e=" + localException);
          boolean bool1 = false;
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ar
 * JD-Core Version:    0.6.0
 */