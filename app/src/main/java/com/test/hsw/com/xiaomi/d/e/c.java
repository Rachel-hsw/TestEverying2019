package com.xiaomi.d.e;

import com.xiaomi.d.c.b;
import com.xiaomi.d.c.b.a;
import com.xiaomi.d.c.f;
import com.xiaomi.d.c.f.a;
import com.xiaomi.d.c.f.b;
import com.xiaomi.d.c.g;
import com.xiaomi.d.c.h;
import com.xiaomi.d.c.h.a;
import com.xiaomi.d.k.b;
import com.xiaomi.d.k.b.a;
import com.xiaomi.push.service.t;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class c
{
  private static XmlPullParser a = null;

  public static com.xiaomi.d.c.a a(String paramString1, String paramString2, XmlPullParser paramXmlPullParser)
  {
    Object localObject = com.xiaomi.d.d.c.a().a("all", "xm:chat");
    if ((localObject != null) && ((localObject instanceof t)))
      return ((t)localObject).b(paramXmlPullParser);
    return null;
  }

  public static b a(XmlPullParser paramXmlPullParser, com.xiaomi.d.a parama)
  {
    String str1 = paramXmlPullParser.getAttributeValue("", "id");
    String str2 = paramXmlPullParser.getAttributeValue("", "to");
    String str3 = paramXmlPullParser.getAttributeValue("", "from");
    String str4 = paramXmlPullParser.getAttributeValue("", "chid");
    b.a locala = b.a.a(paramXmlPullParser.getAttributeValue("", "type"));
    HashMap localHashMap = new HashMap();
    for (int i = 0; i < paramXmlPullParser.getAttributeCount(); i++)
    {
      String str7 = paramXmlPullParser.getAttributeName(i);
      localHashMap.put(str7, paramXmlPullParser.getAttributeValue("", str7));
    }
    int j = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    int k;
    String str5;
    String str6;
    label178: Object localObject3;
    Object localObject4;
    int n;
    if (j == 0)
    {
      k = paramXmlPullParser.next();
      if (k == 2)
      {
        str5 = paramXmlPullParser.getName();
        str6 = paramXmlPullParser.getNamespace();
        if (str5.equals("error"))
        {
          localObject1 = e(paramXmlPullParser);
          int i2 = j;
          localObject3 = localObject2;
          localObject4 = localObject1;
          n = i2;
        }
      }
    }
    while (true)
    {
      int i1 = n;
      localObject1 = localObject4;
      localObject2 = localObject3;
      j = i1;
      break;
      localObject2 = new b();
      ((b)localObject2).a(a(str5, str6, paramXmlPullParser));
      break label178;
      if ((k == 3) && (paramXmlPullParser.getName().equals("iq")))
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        n = 1;
        continue;
        if (localObject2 == null)
        {
          if ((b.a.a == locala) || (b.a.b == locala))
          {
            d locald = new d();
            locald.k(str1);
            locald.m(str3);
            locald.n(str2);
            locald.a(b.a.d);
            locald.l(str4);
            locald.a(new h(h.a.e));
            parama.a(locald);
            com.xiaomi.a.a.c.c.d("iq usage error. send packet in packet parser.");
            return null;
          }
          localObject2 = new e();
        }
        ((b)localObject2).k(str1);
        ((b)localObject2).m(str2);
        ((b)localObject2).l(str4);
        ((b)localObject2).n(str3);
        ((b)localObject2).a(locala);
        ((b)localObject2).a((h)localObject1);
        ((b)localObject2).a(localHashMap);
        return localObject2;
      }
      int m = j;
      localObject3 = localObject2;
      localObject4 = localObject1;
      n = m;
    }
  }

  // ERROR //
  public static com.xiaomi.d.c.d a(XmlPullParser paramXmlPullParser)
  {
    // Byte code:
    //   0: ldc 164
    //   2: aload_0
    //   3: ldc 32
    //   5: ldc 166
    //   7: invokeinterface 40 3 0
    //   12: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +370 -> 385
    //   18: aload_0
    //   19: ldc 32
    //   21: ldc 46
    //   23: invokeinterface 40 3 0
    //   28: astore 24
    //   30: aload_0
    //   31: ldc 32
    //   33: ldc 34
    //   35: invokeinterface 40 3 0
    //   40: astore 25
    //   42: aload_0
    //   43: ldc 32
    //   45: ldc 44
    //   47: invokeinterface 40 3 0
    //   52: astore 26
    //   54: aload_0
    //   55: ldc 32
    //   57: ldc 42
    //   59: invokeinterface 40 3 0
    //   64: astore 27
    //   66: aload_0
    //   67: ldc 32
    //   69: ldc 48
    //   71: invokeinterface 40 3 0
    //   76: astore 28
    //   78: invokestatic 171	com/xiaomi/push/service/an:a	()Lcom/xiaomi/push/service/an;
    //   81: aload 24
    //   83: aload 27
    //   85: invokevirtual 174	com/xiaomi/push/service/an:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/push/service/an$b;
    //   88: astore 29
    //   90: aload 29
    //   92: ifnonnull +852 -> 944
    //   95: invokestatic 171	com/xiaomi/push/service/an:a	()Lcom/xiaomi/push/service/an;
    //   98: aload 24
    //   100: aload 26
    //   102: invokevirtual 174	com/xiaomi/push/service/an:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/push/service/an$b;
    //   105: astore 30
    //   107: aload 30
    //   109: ifnonnull +13 -> 122
    //   112: new 176	com/xiaomi/d/p
    //   115: dup
    //   116: ldc 178
    //   118: invokespecial 180	com/xiaomi/d/p:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: iconst_0
    //   123: istore 31
    //   125: aconst_null
    //   126: astore 32
    //   128: iload 31
    //   130: ifne +240 -> 370
    //   133: aload_0
    //   134: invokeinterface 73 1 0
    //   139: istore 33
    //   141: iload 33
    //   143: iconst_2
    //   144: if_icmpne +200 -> 344
    //   147: ldc 166
    //   149: aload_0
    //   150: invokeinterface 77 1 0
    //   155: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   158: ifne +13 -> 171
    //   161: new 176	com/xiaomi/d/p
    //   164: dup
    //   165: ldc 182
    //   167: invokespecial 180	com/xiaomi/d/p:<init>	(Ljava/lang/String;)V
    //   170: athrow
    //   171: aload_0
    //   172: invokeinterface 73 1 0
    //   177: iconst_4
    //   178: if_icmpeq +13 -> 191
    //   181: new 176	com/xiaomi/d/p
    //   184: dup
    //   185: ldc 182
    //   187: invokespecial 180	com/xiaomi/d/p:<init>	(Ljava/lang/String;)V
    //   190: athrow
    //   191: aload_0
    //   192: invokeinterface 185 1 0
    //   197: astore 34
    //   199: ldc 187
    //   201: aload 24
    //   203: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifne +13 -> 219
    //   209: ldc 189
    //   211: aload 24
    //   213: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   216: ifeq +90 -> 306
    //   219: new 191	com/xiaomi/d/c/c
    //   222: dup
    //   223: invokespecial 192	com/xiaomi/d/c/c:<init>	()V
    //   226: astore 32
    //   228: aload 32
    //   230: aload 24
    //   232: invokevirtual 193	com/xiaomi/d/c/c:l	(Ljava/lang/String;)V
    //   235: aload 32
    //   237: iconst_1
    //   238: invokevirtual 196	com/xiaomi/d/c/c:b	(Z)V
    //   241: aload 32
    //   243: aload 26
    //   245: invokevirtual 197	com/xiaomi/d/c/c:n	(Ljava/lang/String;)V
    //   248: aload 32
    //   250: aload 27
    //   252: invokevirtual 198	com/xiaomi/d/c/c:m	(Ljava/lang/String;)V
    //   255: aload 32
    //   257: aload 25
    //   259: invokevirtual 199	com/xiaomi/d/c/c:k	(Ljava/lang/String;)V
    //   262: aload 32
    //   264: aload 28
    //   266: invokevirtual 202	com/xiaomi/d/c/c:f	(Ljava/lang/String;)V
    //   269: new 204	com/xiaomi/d/c/a
    //   272: dup
    //   273: ldc 166
    //   275: aconst_null
    //   276: aconst_null
    //   277: checkcast 206	[Ljava/lang/String;
    //   280: aconst_null
    //   281: checkcast 206	[Ljava/lang/String;
    //   284: invokespecial 209	com/xiaomi/d/c/a:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    //   287: astore 35
    //   289: aload 35
    //   291: aload 34
    //   293: invokevirtual 211	com/xiaomi/d/c/a:b	(Ljava/lang/String;)V
    //   296: aload 32
    //   298: aload 35
    //   300: invokevirtual 212	com/xiaomi/d/c/c:a	(Lcom/xiaomi/d/c/a;)V
    //   303: aload 32
    //   305: areturn
    //   306: aload 30
    //   308: getfield 218	com/xiaomi/push/service/an$b:i	Ljava/lang/String;
    //   311: aload 25
    //   313: invokestatic 223	com/xiaomi/push/service/d:a	(Ljava/lang/String;Ljava/lang/String;)[B
    //   316: aload 34
    //   318: invokestatic 226	com/xiaomi/push/service/d:b	([BLjava/lang/String;)[B
    //   321: invokestatic 229	com/xiaomi/d/e/c:a	([B)V
    //   324: getstatic 10	com/xiaomi/d/e/c:a	Lorg/xmlpull/v1/XmlPullParser;
    //   327: invokeinterface 73 1 0
    //   332: pop
    //   333: getstatic 10	com/xiaomi/d/e/c:a	Lorg/xmlpull/v1/XmlPullParser;
    //   336: invokestatic 231	com/xiaomi/d/e/c:a	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/d/c/d;
    //   339: astore 32
    //   341: goto -213 -> 128
    //   344: iload 33
    //   346: iconst_3
    //   347: if_icmpne -219 -> 128
    //   350: aload_0
    //   351: invokeinterface 77 1 0
    //   356: ldc 233
    //   358: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq -233 -> 128
    //   364: iconst_1
    //   365: istore 31
    //   367: goto -239 -> 128
    //   370: aload 32
    //   372: ifnonnull -69 -> 303
    //   375: new 176	com/xiaomi/d/p
    //   378: dup
    //   379: ldc 182
    //   381: invokespecial 180	com/xiaomi/d/p:<init>	(Ljava/lang/String;)V
    //   384: athrow
    //   385: new 191	com/xiaomi/d/c/c
    //   388: dup
    //   389: invokespecial 192	com/xiaomi/d/c/c:<init>	()V
    //   392: astore_1
    //   393: aload_0
    //   394: ldc 32
    //   396: ldc 34
    //   398: invokeinterface 40 3 0
    //   403: astore_2
    //   404: aload_2
    //   405: ifnonnull +6 -> 411
    //   408: ldc 235
    //   410: astore_2
    //   411: aload_1
    //   412: aload_2
    //   413: invokevirtual 199	com/xiaomi/d/c/c:k	(Ljava/lang/String;)V
    //   416: aload_1
    //   417: aload_0
    //   418: ldc 32
    //   420: ldc 42
    //   422: invokeinterface 40 3 0
    //   427: invokevirtual 198	com/xiaomi/d/c/c:m	(Ljava/lang/String;)V
    //   430: aload_1
    //   431: aload_0
    //   432: ldc 32
    //   434: ldc 44
    //   436: invokeinterface 40 3 0
    //   441: invokevirtual 197	com/xiaomi/d/c/c:n	(Ljava/lang/String;)V
    //   444: aload_1
    //   445: aload_0
    //   446: ldc 32
    //   448: ldc 46
    //   450: invokeinterface 40 3 0
    //   455: invokevirtual 193	com/xiaomi/d/c/c:l	(Ljava/lang/String;)V
    //   458: aload_1
    //   459: aload_0
    //   460: ldc 32
    //   462: ldc 237
    //   464: invokeinterface 40 3 0
    //   469: invokevirtual 239	com/xiaomi/d/c/c:a	(Ljava/lang/String;)V
    //   472: aload_0
    //   473: ldc 32
    //   475: ldc 241
    //   477: invokeinterface 40 3 0
    //   482: astore 23
    //   484: aload 23
    //   486: astore 4
    //   488: aload_0
    //   489: ldc 32
    //   491: ldc 243
    //   493: invokeinterface 40 3 0
    //   498: astore 22
    //   500: aload 22
    //   502: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   505: ifne +9 -> 514
    //   508: aload_1
    //   509: aload 22
    //   511: invokevirtual 250	com/xiaomi/d/c/c:b	(Ljava/lang/String;)V
    //   514: aload_0
    //   515: ldc 32
    //   517: ldc 252
    //   519: invokeinterface 40 3 0
    //   524: astore 21
    //   526: aload 21
    //   528: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   531: ifne +9 -> 540
    //   534: aload_1
    //   535: aload 21
    //   537: invokevirtual 255	com/xiaomi/d/c/c:c	(Ljava/lang/String;)V
    //   540: aload_0
    //   541: ldc 32
    //   543: ldc_w 257
    //   546: invokeinterface 40 3 0
    //   551: astore 20
    //   553: aload 20
    //   555: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   558: ifne +9 -> 567
    //   561: aload_1
    //   562: aload 20
    //   564: invokevirtual 258	com/xiaomi/d/c/c:d	(Ljava/lang/String;)V
    //   567: aload_0
    //   568: ldc 32
    //   570: ldc_w 260
    //   573: invokeinterface 40 3 0
    //   578: astore 19
    //   580: aload 19
    //   582: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   585: ifne +9 -> 594
    //   588: aload_1
    //   589: aload 19
    //   591: invokevirtual 262	com/xiaomi/d/c/c:e	(Ljava/lang/String;)V
    //   594: aload 4
    //   596: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   599: ifne +157 -> 756
    //   602: aload 4
    //   604: ldc_w 264
    //   607: invokevirtual 268	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   610: ifeq +146 -> 756
    //   613: iconst_1
    //   614: istore 9
    //   616: aload_1
    //   617: iload 9
    //   619: invokevirtual 270	com/xiaomi/d/c/c:a	(Z)V
    //   622: aload_1
    //   623: aload_0
    //   624: ldc 32
    //   626: ldc 48
    //   628: invokeinterface 40 3 0
    //   633: invokevirtual 202	com/xiaomi/d/c/c:f	(Ljava/lang/String;)V
    //   636: aload_0
    //   637: invokestatic 274	com/xiaomi/d/e/c:g	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   640: astore 10
    //   642: aload 10
    //   644: ifnull +118 -> 762
    //   647: ldc 32
    //   649: aload 10
    //   651: invokevirtual 277	java/lang/String:trim	()Ljava/lang/String;
    //   654: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   657: ifne +105 -> 762
    //   660: aload_1
    //   661: aload 10
    //   663: invokevirtual 280	com/xiaomi/d/c/c:j	(Ljava/lang/String;)V
    //   666: aconst_null
    //   667: astore 12
    //   669: iconst_0
    //   670: istore 13
    //   672: iload 13
    //   674: ifne +242 -> 916
    //   677: aload_0
    //   678: invokeinterface 73 1 0
    //   683: istore 14
    //   685: iload 14
    //   687: iconst_2
    //   688: if_icmpne +202 -> 890
    //   691: aload_0
    //   692: invokeinterface 77 1 0
    //   697: astore 15
    //   699: aload_0
    //   700: invokeinterface 80 1 0
    //   705: astore 16
    //   707: aload 16
    //   709: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   712: ifeq +8 -> 720
    //   715: ldc_w 282
    //   718: astore 16
    //   720: aload 15
    //   722: ldc_w 284
    //   725: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   728: ifeq +41 -> 769
    //   731: aload_0
    //   732: invokestatic 274	com/xiaomi/d/e/c:g	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   735: ifnonnull +3 -> 738
    //   738: aload_1
    //   739: aload_0
    //   740: invokestatic 286	com/xiaomi/d/e/c:f	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   743: invokevirtual 288	com/xiaomi/d/c/c:g	(Ljava/lang/String;)V
    //   746: goto -74 -> 672
    //   749: astore_3
    //   750: aconst_null
    //   751: astore 4
    //   753: goto -265 -> 488
    //   756: iconst_0
    //   757: istore 9
    //   759: goto -143 -> 616
    //   762: invokestatic 293	com/xiaomi/d/c/d:u	()Ljava/lang/String;
    //   765: pop
    //   766: goto -100 -> 666
    //   769: aload 15
    //   771: ldc_w 295
    //   774: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   777: ifeq +50 -> 827
    //   780: aload_0
    //   781: ldc 32
    //   783: ldc_w 297
    //   786: invokeinterface 40 3 0
    //   791: astore 17
    //   793: aload_0
    //   794: invokestatic 286	com/xiaomi/d/e/c:f	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   797: astore 18
    //   799: aload 17
    //   801: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   804: ifne +14 -> 818
    //   807: aload_1
    //   808: aload 18
    //   810: aload 17
    //   812: invokevirtual 300	com/xiaomi/d/c/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   815: goto -143 -> 672
    //   818: aload_1
    //   819: aload 18
    //   821: invokevirtual 303	com/xiaomi/d/c/c:h	(Ljava/lang/String;)V
    //   824: goto -152 -> 672
    //   827: aload 15
    //   829: ldc_w 305
    //   832: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   835: ifeq +19 -> 854
    //   838: aload 12
    //   840: ifnonnull -168 -> 672
    //   843: aload_0
    //   844: invokeinterface 308 1 0
    //   849: astore 12
    //   851: goto -179 -> 672
    //   854: aload 15
    //   856: ldc 82
    //   858: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   861: ifeq +14 -> 875
    //   864: aload_1
    //   865: aload_0
    //   866: invokestatic 92	com/xiaomi/d/e/c:e	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/d/c/h;
    //   869: invokevirtual 309	com/xiaomi/d/c/c:a	(Lcom/xiaomi/d/c/h;)V
    //   872: goto -200 -> 672
    //   875: aload_1
    //   876: aload 15
    //   878: aload 16
    //   880: aload_0
    //   881: invokestatic 97	com/xiaomi/d/e/c:a	(Ljava/lang/String;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/d/c/a;
    //   884: invokevirtual 212	com/xiaomi/d/c/c:a	(Lcom/xiaomi/d/c/a;)V
    //   887: goto -215 -> 672
    //   890: iload 14
    //   892: iconst_3
    //   893: if_icmpne -221 -> 672
    //   896: aload_0
    //   897: invokeinterface 77 1 0
    //   902: ldc 233
    //   904: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   907: ifeq -235 -> 672
    //   910: iconst_1
    //   911: istore 13
    //   913: goto -241 -> 672
    //   916: aload_1
    //   917: aload 12
    //   919: invokevirtual 311	com/xiaomi/d/c/c:i	(Ljava/lang/String;)V
    //   922: aload_1
    //   923: areturn
    //   924: astore 8
    //   926: goto -332 -> 594
    //   929: astore 7
    //   931: goto -364 -> 567
    //   934: astore 6
    //   936: goto -396 -> 540
    //   939: astore 5
    //   941: goto -427 -> 514
    //   944: aload 29
    //   946: astore 30
    //   948: goto -841 -> 107
    //
    // Exception table:
    //   from	to	target	type
    //   472	484	749	java/lang/Exception
    //   567	594	924	java/lang/Exception
    //   540	567	929	java/lang/Exception
    //   514	540	934	java/lang/Exception
    //   488	514	939	java/lang/Exception
  }

  private static void a(byte[] paramArrayOfByte)
  {
    if (a == null);
    try
    {
      a = XmlPullParserFactory.newInstance().newPullParser();
      a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
      a.setInput(new InputStreamReader(new ByteArrayInputStream(paramArrayOfByte)));
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      while (true)
        localXmlPullParserException.printStackTrace();
    }
  }

  public static f b(XmlPullParser paramXmlPullParser)
  {
    Object localObject = f.b.a;
    String str1 = paramXmlPullParser.getAttributeValue("", "type");
    if ((str1 != null) && (!str1.equals("")));
    f localf;
    try
    {
      f.b localb = f.b.valueOf(str1);
      localObject = localb;
      localf = new f((f.b)localObject);
      localf.m(paramXmlPullParser.getAttributeValue("", "to"));
      localf.n(paramXmlPullParser.getAttributeValue("", "from"));
      localf.l(paramXmlPullParser.getAttributeValue("", "chid"));
      String str2 = paramXmlPullParser.getAttributeValue("", "id");
      if (str2 == null)
        str2 = "ID_NOT_AVAILABLE";
      localf.k(str2);
      i = 0;
      while (true)
      {
        if (i != 0)
          break label376;
        j = paramXmlPullParser.next();
        if (j != 2)
          break label349;
        str3 = paramXmlPullParser.getName();
        str4 = paramXmlPullParser.getNamespace();
        if (!str3.equals("status"))
          break;
        localf.a(paramXmlPullParser.nextText());
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException3)
    {
      while (true)
      {
        int j;
        String str3;
        String str4;
        System.err.println("Found invalid presence type " + str1);
        continue;
        if (str3.equals("priority"))
        {
          try
          {
            localf.a(Integer.parseInt(paramXmlPullParser.nextText()));
          }
          catch (NumberFormatException localNumberFormatException)
          {
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            localf.a(0);
          }
          continue;
        }
        if (str3.equals("show"))
        {
          String str5 = paramXmlPullParser.nextText();
          try
          {
            localf.a(f.a.valueOf(str5));
          }
          catch (IllegalArgumentException localIllegalArgumentException1)
          {
            System.err.println("Found invalid presence mode " + str5);
          }
          continue;
        }
        if (str3.equals("error"))
        {
          localf.a(e(paramXmlPullParser));
          continue;
        }
        localf.a(a(str3, str4, paramXmlPullParser));
        continue;
        label349: if ((j != 3) || (!paramXmlPullParser.getName().equals("presence")))
          continue;
        int i = 1;
      }
    }
    label376: return (f)localf;
  }

  public static k.b c(XmlPullParser paramXmlPullParser)
  {
    k.b localb = new k.b();
    String str1 = paramXmlPullParser.getAttributeValue("", "id");
    String str2 = paramXmlPullParser.getAttributeValue("", "to");
    String str3 = paramXmlPullParser.getAttributeValue("", "from");
    String str4 = paramXmlPullParser.getAttributeValue("", "chid");
    k.b.a locala = k.b.a.a(paramXmlPullParser.getAttributeValue("", "type"));
    localb.k(str1);
    localb.m(str2);
    localb.n(str3);
    localb.l(str4);
    localb.a(locala);
    int i = 0;
    h localh = null;
    while (i == 0)
    {
      int j = paramXmlPullParser.next();
      if (j == 2)
      {
        if (!paramXmlPullParser.getName().equals("error"))
          continue;
        localh = e(paramXmlPullParser);
        continue;
      }
      if ((j != 3) || (!paramXmlPullParser.getName().equals("bind")))
        continue;
      i = 1;
    }
    localb.a(localh);
    return localb;
  }

  public static g d(XmlPullParser paramXmlPullParser)
  {
    g localg = null;
    int i = 0;
    while (i == 0)
    {
      int j = paramXmlPullParser.next();
      if (j == 2)
      {
        localg = new g(paramXmlPullParser.getName());
        continue;
      }
      if ((j != 3) || (!paramXmlPullParser.getName().equals("error")))
        continue;
      i = 1;
    }
    return localg;
  }

  public static h e(XmlPullParser paramXmlPullParser)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    Object localObject1 = null;
    Object localObject2 = "-1";
    int i = 0;
    if (i < paramXmlPullParser.getAttributeCount())
      if (!paramXmlPullParser.getAttributeName(i).equals("code"))
        break label322;
    label322: for (Object localObject5 = paramXmlPullParser.getAttributeValue("", "code"); ; localObject5 = localObject2)
    {
      if (paramXmlPullParser.getAttributeName(i).equals("type"));
      for (Object localObject6 = paramXmlPullParser.getAttributeValue("", "type"); ; localObject6 = localObject1)
      {
        if (paramXmlPullParser.getAttributeName(i).equals("reason"))
          str1 = paramXmlPullParser.getAttributeValue("", "reason");
        i++;
        localObject1 = localObject6;
        localObject2 = localObject5;
        break;
        int j = 0;
        Object localObject3 = null;
        String str2 = null;
        while (j == 0)
        {
          int k = paramXmlPullParser.next();
          if (k == 2)
          {
            if (paramXmlPullParser.getName().equals("text"))
            {
              str2 = paramXmlPullParser.nextText();
              continue;
            }
            String str3 = paramXmlPullParser.getName();
            String str4 = paramXmlPullParser.getNamespace();
            if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(str4))
            {
              localObject3 = str3;
              continue;
            }
            localArrayList.add(a(str3, str4, paramXmlPullParser));
            continue;
          }
          if (k == 3)
          {
            if (!paramXmlPullParser.getName().equals("error"))
              continue;
            j = 1;
            continue;
          }
          if (k != 4)
            continue;
          str2 = paramXmlPullParser.getText();
        }
        if (localObject1 == null);
        for (Object localObject4 = "cancel"; ; localObject4 = localObject1)
          return new h(Integer.parseInt((String)localObject2), (String)localObject4, str1, localObject3, str2, localArrayList);
      }
    }
  }

  private static String f(XmlPullParser paramXmlPullParser)
  {
    String str = "";
    int i = paramXmlPullParser.getDepth();
    while ((paramXmlPullParser.next() != 3) || (paramXmlPullParser.getDepth() != i))
      str = str + paramXmlPullParser.getText();
    return str;
  }

  private static String g(XmlPullParser paramXmlPullParser)
  {
    for (int i = 0; i < paramXmlPullParser.getAttributeCount(); i++)
    {
      String str = paramXmlPullParser.getAttributeName(i);
      if (("xml:lang".equals(str)) || (("lang".equals(str)) && ("xml".equals(paramXmlPullParser.getAttributePrefix(i)))))
        return paramXmlPullParser.getAttributeValue(i);
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.e.c
 * JD-Core Version:    0.6.0
 */