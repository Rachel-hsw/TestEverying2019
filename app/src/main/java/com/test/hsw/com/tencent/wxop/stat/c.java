package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;
import com.tencent.wxop.stat.b.r;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  static String M;
  private static b N = l.av();
  static ah O = new ah(2);
  static ah P = new ah(1);
  private static d Q = d.aE;
  private static boolean R = false;
  private static boolean S = true;
  private static int T = 30000;
  private static int U = 100000;
  private static int V = 30;
  static String W;
  private static String X;
  private static String Y;
  private static String Z;
  static int aA;
  private static String aa;
  static String ab;
  private static int ac;
  static boolean ad;
  static int ae;
  static long af;
  private static int ag;
  static boolean ah;
  private static long ai;
  private static long aj;
  public static boolean ak;
  static volatile String al;
  private static volatile String am;
  private static int an;
  private static volatile int ao;
  private static int ap;
  private static int aq;
  private static boolean ar;
  private static int as;
  private static boolean at;
  private static String au;
  private static boolean av;
  private static ai aw;
  static boolean ax;
  static int ay;
  static long az;
  static String c;
  private static int w = 10;
  private static int x = 100;
  private static int y = 30;
  private static int z = 1;

  static
  {
    c = "__HIBERNATE__";
    W = "__HIBERNATE__TIME";
    M = "__MTA_KILL__";
    X = null;
    aa = "mta_channel";
    ab = "";
    ac = 180;
    ad = false;
    ae = 100;
    af = 10000L;
    ag = 1024;
    ah = true;
    ai = 0L;
    aj = 300000L;
    ak = true;
    al = "pingma.qq.com:80";
    am = "http://pingma.qq.com:80/mstat/report";
    an = 0;
    ao = 0;
    ap = 20;
    aq = 0;
    ar = false;
    as = 4096;
    at = false;
    au = null;
    av = false;
    aw = null;
    ax = true;
    ay = 0;
    az = 10000L;
    aA = 512;
  }

  public static int A()
  {
    return ap;
  }

  static void B()
  {
    aq = 1 + aq;
  }

  static void C()
  {
    aq = 0;
  }

  static int D()
  {
    return aq;
  }

  public static boolean E()
  {
    return at;
  }

  public static ai F()
  {
    return aw;
  }

  static void a(Context paramContext, ah paramah)
  {
    if (paramah.aI == P.aI)
    {
      P = paramah;
      a(paramah.df);
      if (!P.df.isNull("iplist"))
        g.r(paramContext).b(P.df.getString("iplist"));
    }
    do
      return;
    while (paramah.aI != O.aI);
    O = paramah;
  }

  // ERROR //
  private static void a(Context paramContext, ah paramah, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 236	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   4: astore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: aload 5
    //   11: invokeinterface 241 1 0
    //   16: ifeq +147 -> 163
    //   19: aload 5
    //   21: invokeinterface 245 1 0
    //   26: checkcast 247	java/lang/String
    //   29: astore 24
    //   31: aload 24
    //   33: ldc 249
    //   35: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   38: ifeq +36 -> 74
    //   41: aload_2
    //   42: aload 24
    //   44: invokevirtual 256	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   47: istore 26
    //   49: aload_1
    //   50: getfield 259	com/tencent/wxop/stat/ah:L	I
    //   53: iload 26
    //   55: if_icmpeq +887 -> 942
    //   58: iconst_1
    //   59: istore 27
    //   61: aload_1
    //   62: iload 26
    //   64: putfield 259	com/tencent/wxop/stat/ah:L	I
    //   67: iload 27
    //   69: istore 6
    //   71: goto -62 -> 9
    //   74: aload 24
    //   76: ldc_w 260
    //   79: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   82: ifeq +47 -> 129
    //   85: aload_2
    //   86: ldc_w 260
    //   89: invokevirtual 221	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 25
    //   94: aload 25
    //   96: invokevirtual 263	java/lang/String:length	()I
    //   99: ifle -90 -> 9
    //   102: aload_1
    //   103: new 207	org/json/JSONObject
    //   106: dup
    //   107: aload 25
    //   109: invokespecial 265	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   112: putfield 200	com/tencent/wxop/stat/ah:df	Lorg/json/JSONObject;
    //   115: goto -106 -> 9
    //   118: astore 4
    //   120: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   123: aload 4
    //   125: invokevirtual 270	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   128: return
    //   129: aload 24
    //   131: ldc_w 272
    //   134: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   137: ifeq -128 -> 9
    //   140: aload_1
    //   141: aload_2
    //   142: ldc_w 272
    //   145: invokevirtual 221	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: putfield 273	com/tencent/wxop/stat/ah:c	Ljava/lang/String;
    //   151: goto -142 -> 9
    //   154: astore_3
    //   155: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   158: aload_3
    //   159: invokevirtual 270	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   162: return
    //   163: iload 6
    //   165: iconst_1
    //   166: if_icmpne +61 -> 227
    //   169: invokestatic 279	com/tencent/wxop/stat/ak:aB	()Landroid/content/Context;
    //   172: invokestatic 285	com/tencent/wxop/stat/t:s	(Landroid/content/Context;)Lcom/tencent/wxop/stat/t;
    //   175: astore 7
    //   177: aload 7
    //   179: ifnull +9 -> 188
    //   182: aload 7
    //   184: aload_1
    //   185: invokevirtual 288	com/tencent/wxop/stat/t:b	(Lcom/tencent/wxop/stat/ah;)V
    //   188: aload_1
    //   189: getfield 196	com/tencent/wxop/stat/ah:aI	I
    //   192: getstatic 76	com/tencent/wxop/stat/c:P	Lcom/tencent/wxop/stat/ah;
    //   195: getfield 196	com/tencent/wxop/stat/ah:aI	I
    //   198: if_icmpne +29 -> 227
    //   201: aload_1
    //   202: getfield 200	com/tencent/wxop/stat/ah:df	Lorg/json/JSONObject;
    //   205: invokestatic 203	com/tencent/wxop/stat/c:a	(Lorg/json/JSONObject;)V
    //   208: aload_1
    //   209: getfield 200	com/tencent/wxop/stat/ah:df	Lorg/json/JSONObject;
    //   212: astore 8
    //   214: aload 8
    //   216: ifnull +11 -> 227
    //   219: aload 8
    //   221: invokevirtual 289	org/json/JSONObject:length	()I
    //   224: ifne +9 -> 233
    //   227: aload_0
    //   228: aload_1
    //   229: invokestatic 291	com/tencent/wxop/stat/c:a	(Landroid/content/Context;Lcom/tencent/wxop/stat/ah;)V
    //   232: return
    //   233: invokestatic 279	com/tencent/wxop/stat/ak:aB	()Landroid/content/Context;
    //   236: astore 10
    //   238: aload 8
    //   240: getstatic 114	com/tencent/wxop/stat/c:M	Ljava/lang/String;
    //   243: invokevirtual 294	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore 15
    //   248: aload 15
    //   250: invokestatic 297	com/tencent/wxop/stat/b/l:e	(Ljava/lang/String;)Z
    //   253: ifeq +26 -> 279
    //   256: new 207	org/json/JSONObject
    //   259: dup
    //   260: aload 15
    //   262: invokespecial 265	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   265: astore 16
    //   267: aload 16
    //   269: invokevirtual 289	org/json/JSONObject:length	()I
    //   272: istore 17
    //   274: iload 17
    //   276: ifne +90 -> 366
    //   279: aload 8
    //   281: getstatic 106	com/tencent/wxop/stat/c:c	Ljava/lang/String;
    //   284: invokevirtual 221	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   287: astore 12
    //   289: getstatic 85	com/tencent/wxop/stat/c:R	Z
    //   292: ifeq +33 -> 325
    //   295: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   298: new 299	java/lang/StringBuilder
    //   301: dup
    //   302: ldc_w 301
    //   305: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: aload 12
    //   310: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc_w 308
    //   316: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokevirtual 315	com/tencent/wxop/stat/b/b:e	(Ljava/lang/Object;)V
    //   325: aload 12
    //   327: invokestatic 319	com/tencent/wxop/stat/b/l:u	(Ljava/lang/String;)J
    //   330: lstore 13
    //   332: ldc_w 321
    //   335: invokestatic 319	com/tencent/wxop/stat/b/l:u	(Ljava/lang/String;)J
    //   338: lload 13
    //   340: lcmp
    //   341: ifgt -114 -> 227
    //   344: lload 13
    //   346: invokestatic 324	com/tencent/wxop/stat/c:b	(J)V
    //   349: goto -122 -> 227
    //   352: astore 9
    //   354: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   357: ldc_w 326
    //   360: invokevirtual 315	com/tencent/wxop/stat/b/b:e	(Ljava/lang/Object;)V
    //   363: goto -136 -> 227
    //   366: aload 16
    //   368: ldc_w 328
    //   371: invokevirtual 211	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   374: ifne +111 -> 485
    //   377: aload 16
    //   379: ldc_w 328
    //   382: invokevirtual 332	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   385: astore 19
    //   387: aload 19
    //   389: instanceof 334
    //   392: ifeq +510 -> 902
    //   395: aload 19
    //   397: checkcast 334	java/lang/Integer
    //   400: invokevirtual 337	java/lang/Integer:intValue	()I
    //   403: istore 20
    //   405: iload 20
    //   407: ifle +78 -> 485
    //   410: getstatic 85	com/tencent/wxop/stat/c:R	Z
    //   413: ifeq +33 -> 446
    //   416: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   419: new 299	java/lang/StringBuilder
    //   422: dup
    //   423: ldc_w 339
    //   426: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   429: iload 20
    //   431: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: ldc_w 344
    //   437: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokevirtual 346	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   446: invokestatic 352	java/lang/System:currentTimeMillis	()J
    //   449: sipush 1000
    //   452: iload 20
    //   454: bipush 60
    //   456: imul
    //   457: imul
    //   458: i2l
    //   459: ladd
    //   460: lstore 21
    //   462: aload 10
    //   464: getstatic 110	com/tencent/wxop/stat/c:W	Ljava/lang/String;
    //   467: lload 21
    //   469: invokestatic 357	com/tencent/wxop/stat/b/q:a	(Landroid/content/Context;Ljava/lang/String;J)V
    //   472: iconst_0
    //   473: invokestatic 360	com/tencent/wxop/stat/c:a	(Z)V
    //   476: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   479: ldc_w 362
    //   482: invokevirtual 365	com/tencent/wxop/stat/b/b:warn	(Ljava/lang/Object;)V
    //   485: aload 16
    //   487: ldc_w 367
    //   490: ldc_w 321
    //   493: invokestatic 370	com/tencent/wxop/stat/c:b	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Z
    //   496: ifeq +434 -> 930
    //   499: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   502: ldc_w 372
    //   505: invokevirtual 346	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   508: iconst_1
    //   509: istore 18
    //   511: aload 16
    //   513: ldc_w 374
    //   516: getstatic 379	android/os/Build:MODEL	Ljava/lang/String;
    //   519: invokestatic 370	com/tencent/wxop/stat/c:b	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Z
    //   522: ifeq +31 -> 553
    //   525: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   528: new 299	java/lang/StringBuilder
    //   531: dup
    //   532: ldc_w 381
    //   535: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   538: getstatic 379	android/os/Build:MODEL	Ljava/lang/String;
    //   541: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokevirtual 346	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   550: iconst_1
    //   551: istore 18
    //   553: aload 16
    //   555: ldc_w 382
    //   558: aload 10
    //   560: invokestatic 385	com/tencent/wxop/stat/b/l:D	(Landroid/content/Context;)Ljava/lang/String;
    //   563: invokestatic 370	com/tencent/wxop/stat/c:b	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Z
    //   566: ifeq +33 -> 599
    //   569: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   572: new 299	java/lang/StringBuilder
    //   575: dup
    //   576: ldc_w 387
    //   579: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   582: aload 10
    //   584: invokestatic 385	com/tencent/wxop/stat/b/l:D	(Landroid/content/Context;)Ljava/lang/String;
    //   587: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokevirtual 346	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   596: iconst_1
    //   597: istore 18
    //   599: aload 16
    //   601: ldc_w 389
    //   604: new 299	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 391	java/lang/StringBuilder:<init>	()V
    //   611: getstatic 394	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   614: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 370	com/tencent/wxop/stat/c:b	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Z
    //   623: ifeq +31 -> 654
    //   626: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   629: new 299	java/lang/StringBuilder
    //   632: dup
    //   633: ldc_w 396
    //   636: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   639: getstatic 394	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   642: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokevirtual 346	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   651: iconst_1
    //   652: istore 18
    //   654: aload 16
    //   656: ldc_w 398
    //   659: new 299	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 391	java/lang/StringBuilder:<init>	()V
    //   666: getstatic 403	android/os/Build$VERSION:SDK_INT	I
    //   669: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   672: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 370	com/tencent/wxop/stat/c:b	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Z
    //   678: ifeq +31 -> 709
    //   681: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   684: new 299	java/lang/StringBuilder
    //   687: dup
    //   688: ldc_w 405
    //   691: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   694: getstatic 403	android/os/Build$VERSION:SDK_INT	I
    //   697: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   700: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokevirtual 346	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   706: iconst_1
    //   707: istore 18
    //   709: aload 16
    //   711: ldc_w 407
    //   714: new 299	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 391	java/lang/StringBuilder:<init>	()V
    //   721: getstatic 403	android/os/Build$VERSION:SDK_INT	I
    //   724: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   727: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 370	com/tencent/wxop/stat/c:b	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Z
    //   733: ifeq +31 -> 764
    //   736: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   739: new 299	java/lang/StringBuilder
    //   742: dup
    //   743: ldc_w 405
    //   746: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   749: getstatic 403	android/os/Build$VERSION:SDK_INT	I
    //   752: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   755: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokevirtual 346	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   761: iconst_1
    //   762: istore 18
    //   764: aload 16
    //   766: ldc_w 409
    //   769: aload 10
    //   771: invokestatic 285	com/tencent/wxop/stat/t:s	(Landroid/content/Context;)Lcom/tencent/wxop/stat/t;
    //   774: aload 10
    //   776: invokevirtual 413	com/tencent/wxop/stat/t:t	(Landroid/content/Context;)Lcom/tencent/wxop/stat/b/c;
    //   779: invokevirtual 417	com/tencent/wxop/stat/b/c:b	()Ljava/lang/String;
    //   782: invokestatic 370	com/tencent/wxop/stat/c:b	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Z
    //   785: ifeq +41 -> 826
    //   788: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   791: new 299	java/lang/StringBuilder
    //   794: dup
    //   795: ldc_w 419
    //   798: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   801: aload 10
    //   803: invokestatic 285	com/tencent/wxop/stat/t:s	(Landroid/content/Context;)Lcom/tencent/wxop/stat/t;
    //   806: aload 10
    //   808: invokevirtual 413	com/tencent/wxop/stat/t:t	(Landroid/content/Context;)Lcom/tencent/wxop/stat/b/c;
    //   811: invokevirtual 417	com/tencent/wxop/stat/b/c:b	()Ljava/lang/String;
    //   814: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: invokevirtual 346	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   823: iconst_1
    //   824: istore 18
    //   826: aload 16
    //   828: ldc_w 421
    //   831: aload 10
    //   833: invokestatic 424	com/tencent/wxop/stat/c:h	(Landroid/content/Context;)Ljava/lang/String;
    //   836: invokestatic 370	com/tencent/wxop/stat/c:b	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Z
    //   839: ifeq +33 -> 872
    //   842: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   845: new 299	java/lang/StringBuilder
    //   848: dup
    //   849: ldc_w 426
    //   852: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   855: aload 10
    //   857: invokestatic 424	com/tencent/wxop/stat/c:h	(Landroid/content/Context;)Ljava/lang/String;
    //   860: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   866: invokevirtual 346	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   869: iconst_1
    //   870: istore 18
    //   872: iload 18
    //   874: ifeq -595 -> 279
    //   877: ldc_w 321
    //   880: invokestatic 319	com/tencent/wxop/stat/b/l:u	(Ljava/lang/String;)J
    //   883: invokestatic 324	com/tencent/wxop/stat/c:b	(J)V
    //   886: goto -607 -> 279
    //   889: astore 11
    //   891: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   894: aload 11
    //   896: invokevirtual 270	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   899: goto -620 -> 279
    //   902: aload 19
    //   904: instanceof 247
    //   907: ifeq +29 -> 936
    //   910: aload 19
    //   912: checkcast 247	java/lang/String
    //   915: invokestatic 430	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   918: invokevirtual 337	java/lang/Integer:intValue	()I
    //   921: istore 23
    //   923: iload 23
    //   925: istore 20
    //   927: goto -522 -> 405
    //   930: iconst_0
    //   931: istore 18
    //   933: goto -422 -> 511
    //   936: iconst_0
    //   937: istore 20
    //   939: goto -534 -> 405
    //   942: iload 6
    //   944: istore 27
    //   946: goto -885 -> 61
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	118	org/json/JSONException
    //   9	58	118	org/json/JSONException
    //   61	67	118	org/json/JSONException
    //   74	115	118	org/json/JSONException
    //   129	151	118	org/json/JSONException
    //   169	177	118	org/json/JSONException
    //   182	188	118	org/json/JSONException
    //   188	214	118	org/json/JSONException
    //   219	227	118	org/json/JSONException
    //   227	232	118	org/json/JSONException
    //   354	363	118	org/json/JSONException
    //   0	6	154	java/lang/Throwable
    //   9	58	154	java/lang/Throwable
    //   61	67	154	java/lang/Throwable
    //   74	115	154	java/lang/Throwable
    //   129	151	154	java/lang/Throwable
    //   169	177	154	java/lang/Throwable
    //   182	188	154	java/lang/Throwable
    //   188	214	154	java/lang/Throwable
    //   219	227	154	java/lang/Throwable
    //   227	232	154	java/lang/Throwable
    //   233	238	154	java/lang/Throwable
    //   238	274	154	java/lang/Throwable
    //   279	325	154	java/lang/Throwable
    //   325	349	154	java/lang/Throwable
    //   354	363	154	java/lang/Throwable
    //   366	405	154	java/lang/Throwable
    //   410	446	154	java/lang/Throwable
    //   446	485	154	java/lang/Throwable
    //   485	508	154	java/lang/Throwable
    //   511	550	154	java/lang/Throwable
    //   553	596	154	java/lang/Throwable
    //   599	651	154	java/lang/Throwable
    //   654	706	154	java/lang/Throwable
    //   709	761	154	java/lang/Throwable
    //   764	823	154	java/lang/Throwable
    //   826	869	154	java/lang/Throwable
    //   877	886	154	java/lang/Throwable
    //   891	899	154	java/lang/Throwable
    //   902	923	154	java/lang/Throwable
    //   233	238	352	org/json/JSONException
    //   238	274	352	org/json/JSONException
    //   279	325	352	org/json/JSONException
    //   325	349	352	org/json/JSONException
    //   366	405	352	org/json/JSONException
    //   410	446	352	org/json/JSONException
    //   446	485	352	org/json/JSONException
    //   485	508	352	org/json/JSONException
    //   511	550	352	org/json/JSONException
    //   553	596	352	org/json/JSONException
    //   599	651	352	org/json/JSONException
    //   654	706	352	org/json/JSONException
    //   709	761	352	org/json/JSONException
    //   764	823	352	org/json/JSONException
    //   826	869	352	org/json/JSONException
    //   877	886	352	org/json/JSONException
    //   891	899	352	org/json/JSONException
    //   902	923	352	org/json/JSONException
    //   238	274	889	java/lang/Exception
    //   366	405	889	java/lang/Exception
    //   410	446	889	java/lang/Exception
    //   446	485	889	java/lang/Exception
    //   485	508	889	java/lang/Exception
    //   511	550	889	java/lang/Exception
    //   553	596	889	java/lang/Exception
    //   599	651	889	java/lang/Exception
    //   654	706	889	java/lang/Exception
    //   709	761	889	java/lang/Exception
    //   764	823	889	java/lang/Exception
    //   826	869	889	java/lang/Exception
    //   877	886	889	java/lang/Exception
    //   902	923	889	java/lang/Exception
  }

  static void a(Context paramContext, JSONObject paramJSONObject)
  {
    while (true)
    {
      String str;
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (!str.equalsIgnoreCase(Integer.toString(P.aI)))
            break label71;
          JSONObject localJSONObject2 = paramJSONObject.getJSONObject(str);
          a(paramContext, P, localJSONObject2);
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        N.b(localJSONException);
      }
      label71: 
      do
      {
        return;
        if (!str.equalsIgnoreCase(Integer.toString(O.aI)))
          continue;
        JSONObject localJSONObject1 = paramJSONObject.getJSONObject(str);
        a(paramContext, O, localJSONObject1);
        break;
      }
      while (!str.equalsIgnoreCase("rs"));
      d locald = d.a(paramJSONObject.getInt(str));
      if (locald == null)
        continue;
      Q = locald;
      if (!R)
        continue;
      N.e("Change to ReportStrategy:" + locald.name());
    }
  }

  public static void a(d paramd)
  {
    Q = paramd;
    if (paramd != d.aG)
      e.aZ = 0L;
    if (R)
      N.e("Change to statSendStrategy: " + paramd);
  }

  private static void a(JSONObject paramJSONObject)
  {
    try
    {
      d locald = d.a(paramJSONObject.getInt("rs"));
      if (locald != null)
        a(locald);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!R);
      N.b("rs not found.");
    }
  }

  public static void a(boolean paramBoolean)
  {
    S = paramBoolean;
    if (!paramBoolean)
      N.warn("!!!!!!MTA StatService has been disabled!!!!!!");
  }

  private static void b(long paramLong)
  {
    q.a(ak.aB(), c, paramLong);
    a(false);
    N.warn("MTA is disable for current SDK version");
  }

  public static void b(Context paramContext, String paramString)
  {
    if (paramContext == null)
      N.error("ctx in StatConfig.setAppKey() is null");
    String str;
    do
    {
      do
      {
        return;
        if ((paramString == null) || (paramString.length() > 256))
        {
          N.error("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
          return;
        }
        if (Y != null)
          continue;
        Y = r.t(q.b(paramContext, "_mta_ky_tag_", null));
      }
      while (!(m(paramString) | m(l.z(paramContext))));
      str = Y;
    }
    while (str == null);
    q.c(paramContext, "_mta_ky_tag_", r.q(str));
  }

  private static boolean b(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (!paramJSONObject.isNull(paramString1))
    {
      String str = paramJSONObject.optString(paramString1);
      if ((l.e(paramString2)) && (l.e(str)) && (paramString2.equalsIgnoreCase(str)))
        return true;
    }
    return false;
  }

  public static void c(Context paramContext, String paramString)
  {
    if (paramString.length() > 128)
    {
      N.error("the length of installChannel can not exceed the range of 128 bytes.");
      return;
    }
    Z = paramString;
    q.c(paramContext, aa, paramString);
  }

  public static String d(Context paramContext)
  {
    monitorenter;
    try
    {
      if (Y != null);
      for (String str = Y; ; str = Y)
      {
        return str;
        if ((paramContext != null) && (Y == null))
          Y = l.z(paramContext);
        if ((Y != null) && (Y.trim().length() != 0))
          continue;
        N.error("AppKey can not be null or empty, please read Developer's Guide first!");
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static String e(Context paramContext)
  {
    monitorenter;
    try
    {
      if (Z != null);
      for (String str2 = Z; ; str2 = Z)
      {
        return str2;
        String str1 = q.b(paramContext, aa, "");
        Z = str1;
        if ((str1 == null) || (Z.trim().length() == 0))
          Z = l.A(paramContext);
        if ((Z != null) && (Z.trim().length() != 0))
          continue;
        N.c("installChannel can not be null or empty, please read Developer's Guide first!");
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static String f(Context paramContext)
  {
    return q.b(paramContext, "mta.acc.qq", ab);
  }

  public static String g(Context paramContext)
  {
    if (paramContext == null)
    {
      N.error("Context for getCustomUid is null.");
      return null;
    }
    if (au == null)
      au = q.b(paramContext, "MTA_CUSTOM_UID", "");
    return au;
  }

  public static String h(Context paramContext)
  {
    if (paramContext != null)
      return com.tencent.a.a.a.a.g.a(paramContext).f().c();
    return "0";
  }

  public static d j()
  {
    return Q;
  }

  public static boolean k()
  {
    return R;
  }

  static String l(String paramString)
  {
    try
    {
      String str = P.df.getString(paramString);
      if (str != null)
        return str;
    }
    catch (Throwable localThrowable)
    {
      N.c("can't find custom key:" + paramString);
    }
    return null;
  }

  public static boolean l()
  {
    return S;
  }

  public static int m()
  {
    return T;
  }

  private static boolean m(String paramString)
  {
    if (paramString == null);
    do
    {
      return false;
      if (Y != null)
        continue;
      Y = paramString;
      return true;
    }
    while (Y.contains(paramString));
    Y = Y + "|" + paramString;
    return true;
  }

  public static int n()
  {
    return x;
  }

  public static void n(String paramString)
  {
    if (paramString.length() > 128)
    {
      N.error("the length of installChannel can not exceed the range of 128 bytes.");
      return;
    }
    Z = paramString;
  }

  public static int o()
  {
    return y;
  }

  public static void o(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      N.error("statReportUrl cannot be null or empty.");
    while (true)
    {
      return;
      am = paramString;
      try
      {
        al = new URI(am).getHost();
        if (!R)
          continue;
        N.b("url:" + am + ", domain:" + al);
        return;
      }
      catch (Exception localException)
      {
        while (true)
          N.c(localException);
      }
    }
  }

  public static int p()
  {
    return w;
  }

  public static int q()
  {
    return z;
  }

  static int r()
  {
    return V;
  }

  public static int s()
  {
    return U;
  }

  public static void t()
  {
    ac = 60;
  }

  public static int u()
  {
    return ac;
  }

  public static int v()
  {
    return ag;
  }

  public static void w()
  {
    ah = true;
  }

  public static boolean x()
  {
    return ak;
  }

  public static String y()
  {
    return am;
  }

  static void z()
  {
    monitorenter;
    try
    {
      ao = 0;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.c
 * JD-Core Version:    0.6.0
 */