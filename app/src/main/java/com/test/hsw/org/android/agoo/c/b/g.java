package org.android.agoo.c.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.umeng.message.b.ay;
import com.umeng.message.b.bk;
import com.umeng.message.b.bq;
import com.umeng.message.b.cm;
import com.umeng.message.b.cn;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.agoo.c.a.d;
import org.android.agoo.c.a.e;
import org.android.agoo.c.a.e.a;
import org.apache.http.HttpHost;

class g
{
  public static final String a = "agoo_dns_errorid";
  public static final String b = "agoo_dns_path";
  public static final String c = "agoo_dns_eventid";
  private static final String d = "DNSManager";
  private static final String e = "AGOO_HOST";
  private static final String f = "AGOO_HOST_SIZE";
  private static final String g = "AGOO_HOST_TYPE";
  private static final String h = "AGOO_HOST_VALUE_";
  private static final String i = "spdy";
  private static final String j = "off";
  private volatile double A = 0.0D;
  private volatile double B = 0.0D;
  private volatile e C = null;
  private volatile String k;
  private volatile String l;
  private volatile String m;
  private volatile String n;
  private volatile String o;
  private volatile String p;
  private volatile String q;
  private volatile int r = -1;
  private volatile long s = -1L;
  private volatile a t = null;
  private volatile f u = f.b;
  private volatile f v = f.b;
  private volatile Context w = null;
  private volatile int x = 0;
  private volatile boolean y = false;
  private volatile b z = null;

  g(Context paramContext)
  {
    this.w = paramContext;
    this.C = new e();
    this.z = new b();
    this.u = f.b;
    this.v = f.b;
  }

  // ERROR //
  private LinkedHashMap<String, String> a(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 111
    //   3: iconst_4
    //   4: invokevirtual 117	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   7: astore 6
    //   9: aload 6
    //   11: ldc 119
    //   13: aconst_null
    //   14: invokeinterface 125 3 0
    //   19: astore 7
    //   21: aload 6
    //   23: ldc 127
    //   25: iconst_m1
    //   26: invokeinterface 131 3 0
    //   31: istore 8
    //   33: new 133	com/umeng/message/b/bk
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 135	com/umeng/message/b/bk:<init>	(Landroid/content/Context;)V
    //   41: invokevirtual 138	com/umeng/message/b/bk:c	()Ljava/lang/String;
    //   44: astore 9
    //   46: aload_1
    //   47: ldc 140
    //   49: iconst_4
    //   50: invokevirtual 117	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   53: ldc 142
    //   55: lconst_0
    //   56: invokeinterface 146 4 0
    //   61: lstore 10
    //   63: new 148	java/util/LinkedHashMap
    //   66: dup
    //   67: invokespecial 149	java/util/LinkedHashMap:<init>	()V
    //   70: astore_3
    //   71: aload_3
    //   72: ldc 151
    //   74: aload 7
    //   76: invokevirtual 155	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: pop
    //   80: aload_3
    //   81: ldc 157
    //   83: iload 8
    //   85: invokestatic 163	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   88: invokevirtual 155	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: aload_3
    //   93: ldc 165
    //   95: aload 9
    //   97: invokevirtual 155	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: aload_3
    //   102: ldc 167
    //   104: aload_0
    //   105: getfield 169	org/android/agoo/c/b/g:k	Ljava/lang/String;
    //   108: invokevirtual 155	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: aload_3
    //   113: ldc 171
    //   115: aload_0
    //   116: getfield 173	org/android/agoo/c/b/g:l	Ljava/lang/String;
    //   119: invokevirtual 155	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: aload_3
    //   124: ldc 175
    //   126: lload 10
    //   128: invokestatic 180	java/lang/Long:toString	(J)Ljava/lang/String;
    //   131: invokevirtual 155	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: pop
    //   135: aload_3
    //   136: areturn
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_3
    //   140: aload_2
    //   141: astore 4
    //   143: ldc 182
    //   145: new 184	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   152: ldc 187
    //   154: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 4
    //   159: invokevirtual 194	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   162: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 201	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: aload_3
    //   173: areturn
    //   174: astore 4
    //   176: goto -33 -> 143
    //
    // Exception table:
    //   from	to	target	type
    //   0	71	137	java/lang/Throwable
    //   71	135	174	java/lang/Throwable
  }

  private final void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("AppStore", 4).edit();
      localEditor.putString("agoo_dns_errorid", paramString1);
      localEditor.putString("agoo_dns_path", paramString2);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  // ERROR //
  private final void a(f paramf, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	org/android/agoo/c/b/g:y	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_2
    //   9: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +40 -> 52
    //   15: aload_0
    //   16: getstatic 232	org/android/agoo/c/b/b:y	Lorg/android/agoo/c/b/b;
    //   19: new 184	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   26: ldc 234
    //   28: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 236
    //   37: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 239	org/android/agoo/c/b/g:a	(Lorg/android/agoo/c/b/b;Ljava/lang/String;)V
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 90	org/android/agoo/c/b/g:y	Z
    //   51: return
    //   52: aload_2
    //   53: ldc 241
    //   55: invokestatic 245	android/text/TextUtils:split	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   58: astore 6
    //   60: iconst_m1
    //   61: istore 7
    //   63: aconst_null
    //   64: astore 8
    //   66: aload 6
    //   68: ifnull +42 -> 110
    //   71: aload 6
    //   73: arraylength
    //   74: istore 9
    //   76: aconst_null
    //   77: astore 8
    //   79: iload 9
    //   81: ifle +29 -> 110
    //   84: aload 6
    //   86: iconst_0
    //   87: aaload
    //   88: astore 8
    //   90: bipush 80
    //   92: istore 7
    //   94: aload 6
    //   96: iconst_1
    //   97: aaload
    //   98: invokestatic 249	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   101: invokevirtual 253	java/lang/Integer:intValue	()I
    //   104: istore 11
    //   106: iload 11
    //   108: istore 7
    //   110: aload_0
    //   111: getfield 76	org/android/agoo/c/b/g:t	Lorg/android/agoo/c/b/g$a;
    //   114: ifnull +18 -> 132
    //   117: aload_0
    //   118: getfield 76	org/android/agoo/c/b/g:t	Lorg/android/agoo/c/b/g$a;
    //   121: aload_1
    //   122: aload 8
    //   124: iload 7
    //   126: aload_3
    //   127: invokeinterface 258 5 0
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield 90	org/android/agoo/c/b/g:y	Z
    //   137: return
    //   138: astore 5
    //   140: aload_0
    //   141: getstatic 232	org/android/agoo/c/b/b:y	Lorg/android/agoo/c/b/b;
    //   144: new 184	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   151: ldc 234
    //   153: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_2
    //   157: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 236
    //   162: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokevirtual 239	org/android/agoo/c/b/g:a	(Lorg/android/agoo/c/b/b;Ljava/lang/String;)V
    //   171: aload_0
    //   172: iconst_0
    //   173: putfield 90	org/android/agoo/c/b/g:y	Z
    //   176: return
    //   177: astore 4
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield 90	org/android/agoo/c/b/g:y	Z
    //   184: aload 4
    //   186: athrow
    //   187: astore 10
    //   189: goto -79 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   8	46	138	java/lang/Throwable
    //   52	60	138	java/lang/Throwable
    //   71	76	138	java/lang/Throwable
    //   84	90	138	java/lang/Throwable
    //   94	106	138	java/lang/Throwable
    //   110	132	138	java/lang/Throwable
    //   8	46	177	finally
    //   52	60	177	finally
    //   71	76	177	finally
    //   84	90	177	finally
    //   94	106	177	finally
    //   110	132	177	finally
    //   140	171	177	finally
    //   94	106	187	java/lang/RuntimeException
  }

  private String[] a(String paramString)
  {
    String[] arrayOfString = TextUtils.split(paramString, "\\|");
    int i1 = arrayOfString.length;
    for (int i2 = 0; ; i2++)
    {
      if (i2 < i1)
      {
        if (b(arrayOfString[i2]))
          continue;
        arrayOfString = null;
      }
      return arrayOfString;
    }
  }

  private final void b()
  {
    String str1;
    e.a locala;
    label713: Map localMap;
    try
    {
      d locald = new d();
      locald.a("deviceId", this.l);
      locald.a("app_version_code", "" + d());
      locald.a("agoo_version_code", "" + this.s);
      if (!TextUtils.isEmpty(this.k))
        locald.a("appkey", "" + this.k);
      int i1 = this.r;
      HttpHost localHttpHost;
      switch (1.a[this.u.ordinal()])
      {
      default:
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = this.m;
        arrayOfObject2[1] = "spdyip";
        String str6 = String.format("%s/%s/", arrayOfObject2);
        i1 = 80;
        str1 = str6;
        ay.c("DNSManager", "apollUrl" + str1);
        bk localbk = new bk(this.w);
        String str2 = localbk.c();
        if (!TextUtils.isEmpty(str2))
          locald.a("nt", str2);
        String str3 = localbk.b();
        if (!TextUtils.isEmpty(str3))
          locald.a("apn", str3);
        String str4 = c();
        if (!TextUtils.isEmpty(str4))
          locald.a("agoo_operators", str4);
        if (!TextUtils.isEmpty(this.o))
          locald.a("ttid", "" + this.o);
        if (!TextUtils.isEmpty(this.p))
          locald.a("imei", "" + this.p);
        if (!TextUtils.isEmpty(this.q))
          locald.a("imsi", "" + this.q);
        if (new BigDecimal(this.B).compareTo(new BigDecimal(0.0D)) != 0)
          locald.a("lac", "" + this.B);
        if (new BigDecimal(this.A).compareTo(new BigDecimal(0.0D)) != 0)
          locald.a("lat", "" + this.A);
        if ((TextUtils.isEmpty(this.n)) || (this.r == -1))
          break;
        localHttpHost = new HttpHost(this.n, i1);
      case 1:
      }
      for (locala = this.C.a(this.w, localHttpHost, str1, locald); ; locala = this.C.a(this.w, str1, locald))
      {
        if (locala != null)
          break label713;
        bq localbq1 = new bq(this.w, "dnsRequestError");
        LinkedHashMap localLinkedHashMap1 = a(this.w);
        localLinkedHashMap1.put("faileReasons", "result == null");
        localbq1.a(localLinkedHashMap1);
        a(this.w, b.o.toString(), this.m);
        a(b.o, this.m);
        return;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = this.m;
        arrayOfObject1[1] = "activeip";
        str1 = String.format("%s/%s/", arrayOfObject1);
        break;
      }
      localMap = locala.b;
      if ((localMap == null) || (localMap.isEmpty()))
      {
        bq localbq2 = new bq(this.w, "dnsRequestError");
        LinkedHashMap localLinkedHashMap2 = a(this.w);
        localLinkedHashMap2.put("faileReasons", "headers==null");
        localbq2.a(localLinkedHashMap2);
        a(this.w, "headers==null", str1);
        a(b.o, "get [" + str1 + "] error");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ay.e("DNSManager", "host Throwable", localThrowable);
      a(b.x, "remote get apoll failed");
      return;
    }
    String str5 = (String)localMap.get("server");
    if (TextUtils.isEmpty(str5))
    {
      ay.c("DNSManager", "register--->[serverName==null]");
      bq localbq9 = new bq(this.w, "dnsRequestError");
      LinkedHashMap localLinkedHashMap9 = a(this.w);
      localLinkedHashMap9.put("faileReasons", "[serverName==null]");
      localbq9.a(localLinkedHashMap9);
      a(this.w, "serverName==null", str1);
      a(b.o, "get [" + str1 + "] error");
      return;
    }
    if (!cn.a(str5))
    {
      ay.c("DNSManager", "register--->[serverName!=wjas]");
      bq localbq8 = new bq(this.w, "dnsRequestError");
      LinkedHashMap localLinkedHashMap8 = a(this.w);
      localLinkedHashMap8.put("faileReasons", "[serverName!=wjas]");
      localbq8.a(localLinkedHashMap8);
      a(this.w, "serverName!=wjas", str1);
      a(b.o, "get [" + str1 + "] error");
      return;
    }
    if ((300 <= locala.a) && (400 > locala.a))
    {
      bq localbq7 = new bq(this.w, "dnsRequestError");
      LinkedHashMap localLinkedHashMap7 = a(this.w);
      localLinkedHashMap7.put("faileReasons", Integer.toString(locala.a));
      localbq7.a(localLinkedHashMap7);
      a(this.w, "300<=statusCode<400", str1);
      a(b.o, "get [" + str1 + "] error");
      return;
    }
    if ((400 <= locala.a) && (500 > locala.a))
    {
      bq localbq6 = new bq(this.w, "dnsRequestError");
      LinkedHashMap localLinkedHashMap6 = a(this.w);
      localLinkedHashMap6.put("faileReasons", Integer.toString(locala.a));
      localbq6.a(localLinkedHashMap6);
      a(this.w, "400<=statusCode<500", str1);
      a(b.z, "get [" + str1 + "] error");
      return;
    }
    if (200 != locala.a)
    {
      bq localbq3 = new bq(this.w, "dnsRequestError");
      LinkedHashMap localLinkedHashMap3 = a(this.w);
      localLinkedHashMap3.put("faileReasons", Integer.toString(locala.a));
      localbq3.a(localLinkedHashMap3);
      a(this.w, Integer.toString(locala.a), str1);
      a(b.z, "get [" + str1 + "] error");
      return;
    }
    if (TextUtils.isEmpty(locala.c))
    {
      bq localbq4 = new bq(this.w, "dnsRequestError");
      LinkedHashMap localLinkedHashMap4 = a(this.w);
      localLinkedHashMap4.put("faileReasons", "responseBody is null");
      localbq4.a(localLinkedHashMap4);
      a(this.w, "responseBody is null", str1);
      a(b.o, "get [" + str1 + "] error");
      return;
    }
    String[] arrayOfString = a(locala.c);
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      a(this.w, "ips==null", str1);
      bq localbq5 = new bq(this.w, "dnsRequestError");
      LinkedHashMap localLinkedHashMap5 = a(this.w);
      localLinkedHashMap5.put("faileReasons", "ips==null");
      localbq5.a(localLinkedHashMap5);
      a(b.o, "get [" + str1 + "] error");
      return;
    }
    this.v = this.u;
    if ((locala.b != null) && (TextUtils.equals((CharSequence)locala.b.get("spdy"), "off")))
      this.v = f.a;
    ay.c("DNSManager", " initChannel[" + this.u.a() + "]--> resultChannel[" + this.v.a() + "]");
    new bq(this.w, "dnsRequestSuccess").a(a(this.w));
    a(arrayOfString, this.v);
    a(this.v, arrayOfString[0], this.l);
  }

  private final boolean b(String paramString)
  {
    String str = "(" + "(2[0-4]\\d)|(25[0-5])" + ")|(" + "1\\d{2}" + ")|(" + "[1-9]\\d" + ")|(" + "\\d" + ")";
    return Pattern.compile("(" + str + ").(" + str + ").(" + str + ").(" + str + "):\\d*$").matcher(paramString).matches();
  }

  private final String c()
  {
    String str = cm.b(this.w);
    if (!TextUtils.isEmpty(str))
    {
      if ((str.startsWith("46000")) || (str.startsWith("46002")))
        return "china_mobile";
      if (str.startsWith("46001"))
        return "china_unicom";
      if (str.startsWith("46003"))
        return "china_telecom";
    }
    return null;
  }

  private final String d()
  {
    try
    {
      String str = this.w.getPackageManager().getPackageInfo(this.w.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public final void a(String paramString, int paramInt)
  {
    this.n = paramString;
    this.r = paramInt;
  }

  public final void a(String paramString1, String paramString2, long paramLong)
  {
    a(paramString1, null, paramString2, paramLong);
  }

  public final void a(String paramString1, String paramString2, String paramString3)
  {
    this.o = paramString1;
    this.p = paramString2;
    this.q = paramString3;
  }

  public final void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this.m = paramString1;
    this.k = paramString2;
    this.l = paramString3;
    this.s = paramLong;
  }

  // ERROR //
  public final void a(b paramb, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	org/android/agoo/c/b/g:y	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 76	org/android/agoo/c/b/g:t	Lorg/android/agoo/c/b/g$a;
    //   12: ifnull +14 -> 26
    //   15: aload_0
    //   16: getfield 76	org/android/agoo/c/b/g:t	Lorg/android/agoo/c/b/g$a;
    //   19: aload_1
    //   20: aload_2
    //   21: invokeinterface 550 3 0
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 90	org/android/agoo/c/b/g:y	Z
    //   31: return
    //   32: astore 4
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 90	org/android/agoo/c/b/g:y	Z
    //   39: return
    //   40: astore_3
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 90	org/android/agoo/c/b/g:y	Z
    //   46: aload_3
    //   47: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   8	26	32	java/lang/Throwable
    //   8	26	40	finally
  }

  public final void a(f paramf)
  {
    this.u = paramf;
  }

  public final void a(a parama)
  {
    this.t = parama;
  }

  final void a(String[] paramArrayOfString, f paramf)
  {
    int i1 = 0;
    while (true)
    {
      int i3;
      try
      {
        SharedPreferences.Editor localEditor = this.w.getSharedPreferences("AGOO_HOST", 4).edit();
        localEditor.clear();
        int i2 = paramArrayOfString.length;
        i3 = 0;
        if (i3 >= i2)
          continue;
        if (!TextUtils.isEmpty(paramArrayOfString[i3]))
        {
          localEditor.putString("AGOO_HOST_VALUE_" + i1, paramArrayOfString[i3]);
          i1++;
          break label130;
          localEditor.putInt("AGOO_HOST_TYPE", paramf.b());
          localEditor.putInt("AGOO_HOST_SIZE", i1);
          localEditor.commit();
          this.x = 0;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      label130: i3++;
    }
  }

  final boolean a()
  {
    int i1 = 0;
    try
    {
      SharedPreferences localSharedPreferences = this.w.getSharedPreferences("AGOO_HOST", 4);
      int i2 = localSharedPreferences.getInt("AGOO_HOST_SIZE", 0);
      i1 = 0;
      if (i2 > 0)
      {
        int i3 = this.x;
        i1 = 0;
        if (i3 < i2)
        {
          String str = localSharedPreferences.getString("AGOO_HOST_VALUE_" + this.x, null);
          f localf = f.a(localSharedPreferences.getInt("AGOO_HOST_TYPE", f.b.b()));
          ay.c("DNSManager", "refreshLocalHost,mHostIndex=" + this.x);
          boolean bool = TextUtils.isEmpty(str);
          i1 = 0;
          if (!bool)
          {
            SharedPreferences.Editor localEditor = localSharedPreferences.edit();
            localEditor.remove("AGOO_HOST_VALUE_" + this.x);
            localEditor.commit();
            a(localf, str, this.l);
            i1 = 1;
            this.x = (1 + this.x);
          }
        }
      }
      return i1;
    }
    catch (Throwable localThrowable)
    {
      a(b.s, "refresh failed");
    }
    return i1;
  }

  public final void b(f paramf)
  {
    if (this.y)
    {
      ay.c("DNSManager", "DNSRemote[runing....]");
      return;
    }
    this.y = true;
    try
    {
      this.z.a(paramf);
      new Thread(this.z, "agoo-dns").start();
      return;
    }
    catch (Throwable localThrowable)
    {
      a(b.s, "thread target  failed");
    }
  }

  public static abstract interface a
  {
    public abstract void a(b paramb, String paramString);

    public abstract void a(f paramf, String paramString1, int paramInt, String paramString2);
  }

  final class b
    implements Runnable
  {
    private volatile boolean b = false;
    private volatile f c = f.b;

    b()
    {
    }

    public void a(f paramf)
    {
      this.c = paramf;
    }

    public void run()
    {
      try
      {
        if (this.b)
        {
          ay.c("DNSManager", "DNSRemote[runing....]");
          return;
        }
        this.b = true;
        if (g.a(g.this) != this.c)
        {
          ay.c("DNSManager", "currentChannleType[" + g.a(g.this).a() + "]!=channelType[" + this.c.a() + "]");
          g.a(g.this, this.c);
          g.b(g.this);
          return;
        }
        if (g.this.a())
        {
          ay.c("DNSManager", "refreshLocalHost successfully");
          return;
        }
        g.b(g.this);
        return;
      }
      catch (Throwable localThrowable)
      {
        ay.e("DNSManager", "host Throwable", localThrowable);
        g.this.a(b.s, "remote get apoll failed");
        return;
      }
      finally
      {
        this.b = false;
      }
      throw localObject;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.b.g
 * JD-Core Version:    0.6.0
 */