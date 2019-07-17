package org.android.agoo.c.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.b.ay;
import com.umeng.message.b.cd;
import com.umeng.message.b.cm;
import com.umeng.message.b.co;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
{
  private static final int I = -1;
  public static final int a = 307;
  public static final int b = 401;
  public static final int c = 403;
  public static final int d = 404;
  public static final int e = 408;
  private static final String f = "ChannelManager";
  private static final String g = "AGOO_CONNECT";
  private static final String h = "AGOO_CONNECT_COUNT";
  private static final String i = "AGOO_CONNECT_CLIENT_CREATE_TIME";
  private static final String j = "AGOO_CONNECT_LAST_RECONNECT_TIME";
  private static volatile Map<String, String> k;
  private static volatile long l = 30000L;
  private static volatile Map<String, String> m;
  private static volatile f n = f.b;
  private static volatile a o = a.a;
  private static volatile Context p = null;
  private static volatile j q = null;
  private static volatile String r = null;
  private static volatile String s = null;
  private static volatile String t = null;
  private static volatile String u;
  private static volatile boolean v = true;
  private static volatile g w = null;
  private static volatile l x = l.a;
  private static volatile boolean y = false;
  private volatile int A = -1;
  private volatile h B = null;
  private volatile short C;
  private volatile long D = -1L;
  private volatile long E = -1L;
  private final g.a F = new d(this);
  private volatile boolean G = false;
  private volatile Object H = null;
  private volatile String z = null;

  private c()
  {
    w.a(this.F);
  }

  private final String a(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    org.android.agoo.c.a.d locald;
    try
    {
      locald = new org.android.agoo.c.a.d();
      if (paramMap == null)
        break label135;
      Iterator localIterator = paramMap.entrySet().iterator();
      if (localIterator == null)
        break label135;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry == null) || (co.a((String)localEntry.getKey())) || (co.a((String)localEntry.getValue())))
          continue;
        locald.a((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return localStringBuilder.toString();
    label135: localStringBuilder.append(paramString1);
    String str = locald.c();
    if (TextUtils.indexOf(paramString1, "?") == -1)
      localStringBuilder.append("?");
    while (true)
    {
      localStringBuilder.append("s=" + paramString2);
      if (TextUtils.isEmpty(str))
        break;
      localStringBuilder.append("&");
      localStringBuilder.append(str);
      break;
      localStringBuilder.append("&");
    }
  }

  private final void a(b paramb, String paramString)
  {
    try
    {
      if (q != null)
        q.a(this.H, -1L, paramb, null, null);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private final void f(String paramString)
  {
    HashMap localHashMap1;
    HashMap localHashMap2;
    String str2;
    String str3;
    try
    {
      m();
      if (this.B == null)
      {
        ay.c("ChannelManager", "dataChannel==null");
        return;
      }
      o();
      String str1 = k.a(p, n.b(), this.C, this.D, this.E, o.a(), x.a());
      localHashMap1 = new HashMap();
      localHashMap1.putAll(k);
      localHashMap2 = new HashMap();
      m.put("ov", Build.VERSION.RELEASE);
      LinkedHashMap localLinkedHashMap = cm.g(p);
      m.put("sv", localLinkedHashMap.get("agooReleaseTime"));
      m.put("pm", cd.a(Build.MODEL.getBytes()));
      localHashMap2.putAll(m);
      if (!TextUtils.isEmpty(str1))
        localHashMap2.put("c", str1);
      int i1 = n();
      Object[] arrayOfObject = new Object[6];
      arrayOfObject[0] = this.z;
      arrayOfObject[1] = Integer.valueOf(this.A);
      arrayOfObject[2] = s;
      arrayOfObject[3] = t;
      arrayOfObject[4] = Integer.valueOf(i1);
      arrayOfObject[5] = r;
      str2 = String.format("http://%s:%d/%s/%s/%d/%s", arrayOfObject);
      str3 = k.a(p, str2, localHashMap2, t, u);
      if (TextUtils.isEmpty(str3))
      {
        a(b.v, "");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ay.d("ChannelManager", "_connenct", localThrowable);
      return;
    }
    String str4 = a(str2, localHashMap2, str3);
    Log.d("ChannelManager", "mCurrentChannelType = " + n);
    switch (1.a[n.ordinal()])
    {
    default:
      ay.c("ChannelManager", "connenct  [SpdyChannel]");
    case 1:
    case 2:
    }
    while (true)
    {
      SharedPreferences.Editor localEditor = p.getSharedPreferences("AGOO_CONNECT", 4).edit();
      localEditor.putString("AGOO_CONNECT_HOST", this.z);
      localEditor.putInt("AGOO_CONNECT_PORT", this.A);
      localEditor.commit();
      this.B.a(this.H, p, str4, localHashMap1, l, q, paramString);
      return;
      ay.c("ChannelManager", "connenct  [SpdyChannel]");
      continue;
      ay.c("ChannelManager", "connenct  [ChunkedChannel]");
    }
  }

  private final void m()
  {
    switch (1.a[n.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return;
      try
      {
        if ((this.B != null) && (y) && ((this.B instanceof org.android.agoo.c.b.b.a)))
        {
          this.B.r();
          this.B = new org.android.agoo.c.b.b.a();
          y = false;
        }
        if ((this.B != null) && ((this.B instanceof org.android.agoo.c.b.b.a)))
          continue;
        this.B = new org.android.agoo.c.b.b.a();
        return;
      }
      catch (Throwable localThrowable2)
      {
        ay.d("ChannelManager", "builder.changeChannel.initSpdy", localThrowable2);
        a(b.f, "builder.changeChannel.initSpdy error");
        return;
      }
      try
      {
        if ((this.B != null) && ((this.B instanceof org.android.agoo.c.b.a.a)))
          continue;
        this.B = new org.android.agoo.c.b.a.a();
        return;
      }
      catch (Throwable localThrowable1)
      {
        a(b.n, "builder.changeChannel.initSpdy error");
        ay.d("ChannelManager", "builder.changeChannel.initChunked", localThrowable1);
      }
    }
  }

  private static final int n()
  {
    try
    {
      int i1 = p.getPackageManager().getPackageInfo(p.getPackageName(), 0).versionCode;
      return i1;
    }
    catch (Throwable localThrowable)
    {
      ay.d("ChannelManager", "getAppVersionCode", localThrowable);
    }
    return -1;
  }

  // ERROR //
  private final void o()
  {
    // Byte code:
    //   0: getstatic 90	org/android/agoo/c/b/c:p	Landroid/content/Context;
    //   3: ldc 23
    //   5: iconst_4
    //   6: invokevirtual 377	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   9: astore_2
    //   10: invokestatic 454	java/lang/System:currentTimeMillis	()J
    //   13: lstore_3
    //   14: aload_0
    //   15: aload_2
    //   16: ldc 29
    //   18: lload_3
    //   19: invokeinterface 458 4 0
    //   24: putfield 125	org/android/agoo/c/b/c:E	J
    //   27: aload_0
    //   28: aload_2
    //   29: ldc 32
    //   31: lload_3
    //   32: invokeinterface 458 4 0
    //   37: putfield 123	org/android/agoo/c/b/c:D	J
    //   40: aload_2
    //   41: invokeinterface 383 1 0
    //   46: astore 5
    //   48: aload_0
    //   49: getfield 125	org/android/agoo/c/b/c:E	J
    //   52: lload_3
    //   53: lcmp
    //   54: ifne +14 -> 68
    //   57: aload 5
    //   59: ldc 29
    //   61: lload_3
    //   62: invokeinterface 462 4 0
    //   67: pop
    //   68: aload_0
    //   69: aload_2
    //   70: ldc 26
    //   72: ldc_w 464
    //   75: invokeinterface 468 3 0
    //   80: invokestatic 474	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   83: putfield 262	org/android/agoo/c/b/c:C	S
    //   86: ldc 20
    //   88: new 151	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 476
    //   98: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: lload_3
    //   102: invokevirtual 479	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   105: ldc_w 481
    //   108: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 125	org/android/agoo/c/b/c:E	J
    //   115: invokevirtual 479	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   118: ldc_w 483
    //   121: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 123	org/android/agoo/c/b/c:D	J
    //   128: invokevirtual 479	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   131: ldc_w 485
    //   134: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 486	com/umeng/message/b/ay:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_0
    //   144: iconst_1
    //   145: aload_0
    //   146: getfield 262	org/android/agoo/c/b/c:C	S
    //   149: iadd
    //   150: i2s
    //   151: putfield 262	org/android/agoo/c/b/c:C	S
    //   154: aload 5
    //   156: ldc 32
    //   158: lload_3
    //   159: invokeinterface 462 4 0
    //   164: pop
    //   165: aload 5
    //   167: ldc 26
    //   169: new 151	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 344
    //   179: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 262	org/android/agoo/c/b/c:C	S
    //   186: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokeinterface 391 3 0
    //   197: pop
    //   198: aload 5
    //   200: invokeinterface 400 1 0
    //   205: pop
    //   206: return
    //   207: astore_1
    //   208: return
    //   209: astore 6
    //   211: goto -125 -> 86
    //
    // Exception table:
    //   from	to	target	type
    //   0	68	207	java/lang/Throwable
    //   86	206	207	java/lang/Throwable
    //   68	86	209	java/lang/Throwable
  }

  // ERROR //
  public final int a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 119	org/android/agoo/c/b/c:B	Lorg/android/agoo/c/b/h;
    //   4: ifnull +483 -> 487
    //   7: aload_0
    //   8: getfield 119	org/android/agoo/c/b/c:B	Lorg/android/agoo/c/b/h;
    //   11: invokeinterface 493 1 0
    //   16: getstatic 498	org/android/agoo/c/b/e:b	Lorg/android/agoo/c/b/e;
    //   19: if_acmpne +468 -> 487
    //   22: new 272	java/util/HashMap
    //   25: dup
    //   26: invokespecial 273	java/util/HashMap:<init>	()V
    //   29: astore 12
    //   31: aload_1
    //   32: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +19 -> 54
    //   38: aload_2
    //   39: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifeq +12 -> 54
    //   45: aload_3
    //   46: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +5 -> 54
    //   52: iconst_m1
    //   53: ireturn
    //   54: aload 12
    //   56: getstatic 244	org/android/agoo/c/b/c:m	Ljava/util/Map;
    //   59: invokeinterface 277 2 0
    //   64: aload 12
    //   66: ldc_w 500
    //   69: aload_1
    //   70: invokeinterface 288 3 0
    //   75: pop
    //   76: aload_2
    //   77: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +15 -> 95
    //   83: aload 12
    //   85: ldc_w 502
    //   88: aload_2
    //   89: invokeinterface 288 3 0
    //   94: pop
    //   95: aload_3
    //   96: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +15 -> 114
    //   102: aload 12
    //   104: ldc_w 504
    //   107: aload_3
    //   108: invokeinterface 288 3 0
    //   113: pop
    //   114: invokestatic 322	org/android/agoo/c/b/c:n	()I
    //   117: istore 14
    //   119: bipush 6
    //   121: anewarray 4	java/lang/Object
    //   124: astore 15
    //   126: aload 15
    //   128: iconst_0
    //   129: aload_0
    //   130: getfield 115	org/android/agoo/c/b/c:z	Ljava/lang/String;
    //   133: aastore
    //   134: aload 15
    //   136: iconst_1
    //   137: aload_0
    //   138: getfield 117	org/android/agoo/c/b/c:A	I
    //   141: invokestatic 328	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: aload 15
    //   147: iconst_2
    //   148: ldc_w 506
    //   151: aastore
    //   152: aload 15
    //   154: iconst_3
    //   155: getstatic 98	org/android/agoo/c/b/c:t	Ljava/lang/String;
    //   158: aastore
    //   159: aload 15
    //   161: iconst_4
    //   162: iload 14
    //   164: invokestatic 328	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: aastore
    //   168: aload 15
    //   170: iconst_5
    //   171: getstatic 94	org/android/agoo/c/b/c:r	Ljava/lang/String;
    //   174: aastore
    //   175: ldc_w 330
    //   178: aload 15
    //   180: invokestatic 334	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   183: astore 16
    //   185: getstatic 90	org/android/agoo/c/b/c:p	Landroid/content/Context;
    //   188: aload 16
    //   190: aload 12
    //   192: getstatic 98	org/android/agoo/c/b/c:t	Ljava/lang/String;
    //   195: getstatic 246	org/android/agoo/c/b/c:u	Ljava/lang/String;
    //   198: invokestatic 337	org/android/agoo/c/b/k:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   201: astore 17
    //   203: aload 17
    //   205: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   208: ifeq +103 -> 311
    //   211: ldc 20
    //   213: ldc_w 508
    //   216: invokestatic 510	com/umeng/message/b/ay:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: getstatic 342	org/android/agoo/c/b/b:v	Lorg/android/agoo/c/b/b;
    //   223: ldc_w 344
    //   226: invokespecial 239	org/android/agoo/c/b/c:a	(Lorg/android/agoo/c/b/b;Ljava/lang/String;)V
    //   229: iconst_m1
    //   230: ireturn
    //   231: astore 4
    //   233: iconst_m1
    //   234: istore 5
    //   236: aconst_null
    //   237: astore 6
    //   239: new 512	com/umeng/message/b/bq
    //   242: dup
    //   243: getstatic 90	org/android/agoo/c/b/c:p	Landroid/content/Context;
    //   246: ldc_w 514
    //   249: invokespecial 517	com/umeng/message/b/bq:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   252: astore 7
    //   254: getstatic 90	org/android/agoo/c/b/c:p	Landroid/content/Context;
    //   257: invokestatic 293	com/umeng/message/b/cm:g	(Landroid/content/Context;)Ljava/util/LinkedHashMap;
    //   260: astore 8
    //   262: aload 8
    //   264: ldc_w 519
    //   267: iload 5
    //   269: invokestatic 522	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   272: invokevirtual 523	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   275: pop
    //   276: aload 7
    //   278: aload 8
    //   280: invokevirtual 526	com/umeng/message/b/bq:a	(Ljava/util/LinkedHashMap;)V
    //   283: aload_0
    //   284: getfield 119	org/android/agoo/c/b/c:B	Lorg/android/agoo/c/b/h;
    //   287: aload 6
    //   289: aconst_null
    //   290: aconst_null
    //   291: invokeinterface 529 4 0
    //   296: istore 10
    //   298: ldc 20
    //   300: ldc_w 531
    //   303: aload 4
    //   305: invokestatic 349	com/umeng/message/b/ay:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: iload 10
    //   310: ireturn
    //   311: new 533	java/net/URI
    //   314: dup
    //   315: aload_0
    //   316: aload 16
    //   318: aload 12
    //   320: aload 17
    //   322: invokespecial 351	org/android/agoo/c/b/c:a	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   325: invokespecial 535	java/net/URI:<init>	(Ljava/lang/String;)V
    //   328: astore 18
    //   330: new 151	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   337: aload 18
    //   339: invokevirtual 538	java/net/URI:getPath	()Ljava/lang/String;
    //   342: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc 207
    //   347: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload 18
    //   352: invokevirtual 541	java/net/URI:getQuery	()Ljava/lang/String;
    //   355: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: astore 19
    //   363: ldc 20
    //   365: new 151	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 543
    //   375: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload 19
    //   380: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 485
    //   386: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 545	com/umeng/message/b/ay:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_0
    //   396: getfield 119	org/android/agoo/c/b/c:B	Lorg/android/agoo/c/b/h;
    //   399: aload 19
    //   401: aconst_null
    //   402: aconst_null
    //   403: invokeinterface 529 4 0
    //   408: istore 20
    //   410: iload 20
    //   412: istore 11
    //   414: iload 11
    //   416: ifeq +74 -> 490
    //   419: iload 11
    //   421: iconst_m1
    //   422: if_icmpeq +68 -> 490
    //   425: new 512	com/umeng/message/b/bq
    //   428: dup
    //   429: getstatic 90	org/android/agoo/c/b/c:p	Landroid/content/Context;
    //   432: ldc_w 514
    //   435: invokespecial 517	com/umeng/message/b/bq:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   438: astore 21
    //   440: getstatic 90	org/android/agoo/c/b/c:p	Landroid/content/Context;
    //   443: invokestatic 293	com/umeng/message/b/cm:g	(Landroid/content/Context;)Ljava/util/LinkedHashMap;
    //   446: astore 23
    //   448: aload 23
    //   450: ldc_w 519
    //   453: iload 11
    //   455: invokestatic 522	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   458: invokevirtual 523	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   461: pop
    //   462: aload 21
    //   464: aload 23
    //   466: invokevirtual 526	com/umeng/message/b/bq:a	(Ljava/util/LinkedHashMap;)V
    //   469: aload_0
    //   470: getfield 119	org/android/agoo/c/b/c:B	Lorg/android/agoo/c/b/h;
    //   473: aload 19
    //   475: aconst_null
    //   476: aconst_null
    //   477: invokeinterface 529 4 0
    //   482: istore 25
    //   484: iload 25
    //   486: ireturn
    //   487: iconst_m1
    //   488: istore 11
    //   490: iload 11
    //   492: ireturn
    //   493: astore 4
    //   495: iconst_m1
    //   496: istore 5
    //   498: aload 19
    //   500: astore 6
    //   502: goto -263 -> 239
    //   505: astore 22
    //   507: aload 19
    //   509: astore 6
    //   511: iload 11
    //   513: istore 5
    //   515: aload 22
    //   517: astore 4
    //   519: goto -280 -> 239
    //
    // Exception table:
    //   from	to	target	type
    //   0	52	231	java/lang/Throwable
    //   54	95	231	java/lang/Throwable
    //   95	114	231	java/lang/Throwable
    //   114	229	231	java/lang/Throwable
    //   311	363	231	java/lang/Throwable
    //   363	410	493	java/lang/Throwable
    //   425	484	505	java/lang/Throwable
  }

  public final f a()
  {
    return n;
  }

  public final void a(Object paramObject)
  {
    this.H = paramObject;
  }

  public final void a(String paramString)
  {
    try
    {
      if ((v) || (this.z == null) || (-1 == this.A))
      {
        if (this.G)
        {
          ay.c("ChannelManager", "connenct[dnsing]");
          return;
        }
        this.G = true;
        w.b(n);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ay.d("ChannelManager", "connenct", localThrowable);
      return;
    }
    if (b() == e.a)
    {
      ay.c("ChannelManager", "connenct[connecting]");
      return;
    }
    f(paramString);
  }

  public final void a(String paramString, byte[] paramArrayOfByte, i parami)
  {
    try
    {
      if (this.B != null)
        this.B.a(paramString, paramArrayOfByte, parami);
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.d("ChannelManager", "send", localThrowable);
    }
  }

  public final e b()
  {
    try
    {
      if (this.B != null)
      {
        e locale = this.B.f();
        return locale;
      }
    }
    catch (Throwable localThrowable)
    {
      ay.d("ChannelManager", "readyChannelState", localThrowable);
    }
    return e.d;
  }

  public final void c()
  {
    try
    {
      if ((this.B != null) && (this.B.f() == e.b))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(m);
        int i1 = n();
        Object[] arrayOfObject = new Object[6];
        arrayOfObject[0] = this.z;
        arrayOfObject[1] = Integer.valueOf(this.A);
        arrayOfObject[2] = "h";
        arrayOfObject[3] = t;
        arrayOfObject[4] = Integer.valueOf(i1);
        arrayOfObject[5] = r;
        String str1 = String.format("http://%s:%d/%s/%s/%d/%s", arrayOfObject);
        String str2 = k.a(p, str1, localHashMap, t, u);
        if (TextUtils.isEmpty(str2))
        {
          ay.d("ChannelManager", "hisMessage[sgin==null]");
          a(b.v, "");
          return;
        }
        URI localURI = new URI(a(str1, localHashMap, str2));
        String str3 = localURI.getPath() + "?" + localURI.getQuery();
        ay.b("ChannelManager", "hisMessage url [" + str3 + "]");
        this.B.a(str3, null, null);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ay.d("ChannelManager", "send", localThrowable);
    }
  }

  public final void d()
  {
    try
    {
      if ((this.B != null) && (b() == e.b))
        this.B.e();
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.d("ChannelManager", "disconnect", localThrowable);
    }
  }

  public final void e()
  {
    try
    {
      if (this.B != null)
        this.B.q();
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.d("ChannelManager", "shutdown", localThrowable);
    }
  }

  public final long f()
  {
    long l1 = -1L;
    try
    {
      if (this.B != null)
      {
        long l2 = this.B.p();
        l1 = l2;
      }
      return l1;
    }
    catch (Throwable localThrowable)
    {
      ay.d("ChannelManager", "ping", localThrowable);
    }
    return l1;
  }

  public static final class a
  {
    public a(Context paramContext, String paramString1, String paramString2)
    {
      c.a(paramContext);
      c.a(new g(paramContext));
      c.a(new HashMap());
      c.b(new HashMap());
      c.a(true);
      c.b(paramString1);
      c.c(paramString2);
    }

    public final a a()
    {
      c.a(true);
      return this;
    }

    public final a a(long paramLong)
    {
      c.a(paramLong);
      return this;
    }

    public final a a(long paramLong1, long paramLong2)
    {
      return this;
    }

    public final a a(String paramString)
    {
      c.d(paramString);
      return this;
    }

    public final a a(String paramString, int paramInt)
    {
      c.i().a(paramString, paramInt);
      return this;
    }

    public final a a(String paramString, long paramLong)
    {
      c.i().a(paramString, c.g(), c.h(), paramLong);
      return this;
    }

    public final a a(String paramString1, String paramString2)
    {
      c.j().put(paramString1, paramString2);
      return this;
    }

    public final a a(String paramString1, String paramString2, String paramString3)
    {
      c.i().a(paramString1, paramString2, paramString3);
      return this;
    }

    public final a a(Map<String, String> paramMap)
    {
      c.j().putAll(paramMap);
      return this;
    }

    public final a a(a parama)
    {
      c.a(parama);
      return this;
    }

    public final a a(f paramf)
    {
      c.a(paramf);
      c.i().a(paramf);
      return this;
    }

    public final a a(j paramj)
    {
      c.a(paramj);
      return this;
    }

    public final a a(l paraml)
    {
      c.a(paraml);
      return this;
    }

    public final a a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        c.j().put("c0", Build.BRAND);
        c.j().put("c1", Build.MODEL);
        c.j().put("c2", cm.d(c.k()));
        c.j().put("c3", cm.e(c.k()));
        c.j().put("c4", cm.c(c.k()));
        c.j().put("c5", cm.a());
        c.j().put("c6", cm.f(c.k()));
      }
      return this;
    }

    public final a b()
    {
      c.b(true);
      return this;
    }

    public final a b(long paramLong)
    {
      return this;
    }

    public final a b(String paramString)
    {
      c.e(paramString);
      return this;
    }

    public final a b(String paramString1, String paramString2)
    {
      c.l().put(paramString1, paramString2);
      return this;
    }

    public final a b(Map<String, String> paramMap)
    {
      c.l().putAll(paramMap);
      return this;
    }

    public final a c(long paramLong)
    {
      return this;
    }

    public final a c(String paramString)
    {
      c.l().remove(paramString);
      return this;
    }

    public final c c()
    {
      return new c(null);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.b.c
 * JD-Core Version:    0.6.0
 */