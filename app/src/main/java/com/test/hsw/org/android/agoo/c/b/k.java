package org.android.agoo.c.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.message.b.ay;
import com.umeng.message.b.cd;
import com.umeng.message.b.ch;
import com.umeng.message.b.cm;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class k
{
  static final String a = "wifi";
  static final String b = "2g";
  static final String c = "3g";
  static final String d = "4g";
  public static final Uri e = Uri.parse("content://telephony/carriers/preferapn");
  private static final String f = "SignHelper";
  private static final String g = "|";
  private static final byte h = 0;
  private static final byte i = 1;
  private static final byte j = 2;
  private static final byte k = 3;
  private static final byte l = 4;
  private static final byte m = 5;
  private static final byte n = 6;
  private static final byte o = 7;
  private static final byte p = 8;

  private static final String a()
  {
    return a(System.currentTimeMillis());
  }

  private static final String a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(2000, 1, 1, 0, 0, 0);
    long l1 = localCalendar.getTimeInMillis();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf((paramLong - l1) / 1000L);
    return String.format("%010d", arrayOfObject);
  }

  // ERROR //
  private static final String a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: bipush 6
    //   4: newarray byte
    //   6: astore_2
    //   7: aload_0
    //   8: invokevirtual 107	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   11: ldc 109
    //   13: invokevirtual 113	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   16: checkcast 115	android/net/ConnectivityManager
    //   19: astore 19
    //   21: aload 19
    //   23: invokevirtual 119	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   26: astore 51
    //   28: aload 51
    //   30: astore 21
    //   32: aload 21
    //   34: ifnull +11 -> 45
    //   37: aload 21
    //   39: invokevirtual 125	android/net/NetworkInfo:isConnected	()Z
    //   42: ifne +860 -> 902
    //   45: aload 19
    //   47: invokevirtual 129	android/net/ConnectivityManager:getAllNetworkInfo	()[Landroid/net/NetworkInfo;
    //   50: astore 22
    //   52: aload 22
    //   54: ifnull +848 -> 902
    //   57: iconst_0
    //   58: istore 49
    //   60: iload 49
    //   62: aload 22
    //   64: arraylength
    //   65: if_icmpge +837 -> 902
    //   68: aload 22
    //   70: iload 49
    //   72: aaload
    //   73: ifnull +362 -> 435
    //   76: aload 22
    //   78: iload 49
    //   80: aaload
    //   81: invokevirtual 125	android/net/NetworkInfo:isConnected	()Z
    //   84: ifeq +351 -> 435
    //   87: aload 22
    //   89: iload 49
    //   91: aaload
    //   92: astore 50
    //   94: aload 50
    //   96: astore 23
    //   98: aload_0
    //   99: invokevirtual 133	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   102: getstatic 56	org/android/agoo/c/b/k:e	Landroid/net/Uri;
    //   105: aconst_null
    //   106: aconst_null
    //   107: aconst_null
    //   108: aconst_null
    //   109: invokevirtual 139	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   112: astore 42
    //   114: aload 42
    //   116: ifnull +780 -> 896
    //   119: aload 42
    //   121: invokeinterface 144 1 0
    //   126: pop
    //   127: aload 42
    //   129: aload 42
    //   131: ldc 146
    //   133: invokeinterface 150 2 0
    //   138: invokeinterface 154 2 0
    //   143: astore 44
    //   145: aload 44
    //   147: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   150: ifne +740 -> 890
    //   153: ldc 162
    //   155: aload 44
    //   157: invokevirtual 166	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   160: istore 47
    //   162: iload 47
    //   164: ifeq +277 -> 441
    //   167: iconst_3
    //   168: istore 45
    //   170: aload 42
    //   172: invokeinterface 169 1 0
    //   177: iload 45
    //   179: istore 25
    //   181: iload 25
    //   183: ifne +31 -> 214
    //   186: aload 23
    //   188: invokevirtual 172	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   191: astore 40
    //   193: aload 40
    //   195: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifne +16 -> 214
    //   201: ldc 174
    //   203: aload 40
    //   205: invokevirtual 166	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   208: ifeq +261 -> 469
    //   211: iconst_1
    //   212: istore 25
    //   214: aload 23
    //   216: invokevirtual 178	android/net/NetworkInfo:getType	()I
    //   219: istore 27
    //   221: aload 23
    //   223: invokevirtual 181	android/net/NetworkInfo:getSubtype	()I
    //   226: istore 28
    //   228: iconst_1
    //   229: iload 27
    //   231: if_icmpne +357 -> 588
    //   234: aload_0
    //   235: ldc 8
    //   237: invokevirtual 113	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   240: checkcast 183	android/net/wifi/WifiManager
    //   243: invokevirtual 187	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   246: invokevirtual 192	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   249: invokestatic 195	org/android/agoo/c/b/k:a	(Ljava/lang/String;)[B
    //   252: astore 39
    //   254: aload 39
    //   256: astore 4
    //   258: iload 25
    //   260: istore 6
    //   262: iload 28
    //   264: istore 5
    //   266: new 197	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   273: astore 7
    //   275: aload_0
    //   276: invokestatic 201	org/android/agoo/c/b/k:b	(Landroid/content/Context;)I
    //   279: istore 8
    //   281: aload 7
    //   283: new 197	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   290: ldc 203
    //   292: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload 8
    //   297: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 7
    //   309: ldc 25
    //   311: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 7
    //   317: new 197	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   324: ldc 203
    //   326: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: iload 5
    //   331: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 7
    //   343: ldc 25
    //   345: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 7
    //   351: new 197	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   358: ldc 203
    //   360: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: iload 6
    //   365: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload 7
    //   377: ldc 25
    //   379: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 7
    //   385: new 94	java/lang/String
    //   388: dup
    //   389: aload 4
    //   391: ldc 215
    //   393: invokespecial 218	java/lang/String:<init>	([BLjava/lang/String;)V
    //   396: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: ldc 220
    //   402: new 197	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   409: ldc 222
    //   411: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 7
    //   416: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 227	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   428: pop
    //   429: aload 7
    //   431: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: areturn
    //   435: iinc 49 1
    //   438: goto -378 -> 60
    //   441: ldc 229
    //   443: aload 44
    //   445: invokevirtual 166	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   448: istore 48
    //   450: iload 48
    //   452: ifeq +438 -> 890
    //   455: iconst_4
    //   456: istore 45
    //   458: goto -288 -> 170
    //   461: astore 24
    //   463: iload_1
    //   464: istore 25
    //   466: goto -285 -> 181
    //   469: ldc 231
    //   471: aload 40
    //   473: invokevirtual 166	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   476: ifeq +9 -> 485
    //   479: iconst_2
    //   480: istore 25
    //   482: goto -268 -> 214
    //   485: ldc 233
    //   487: aload 40
    //   489: invokevirtual 166	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   492: ifeq +10 -> 502
    //   495: bipush 8
    //   497: istore 25
    //   499: goto -285 -> 214
    //   502: ldc 235
    //   504: aload 40
    //   506: invokevirtual 166	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   509: ifeq +9 -> 518
    //   512: iconst_5
    //   513: istore 25
    //   515: goto -301 -> 214
    //   518: ldc 237
    //   520: aload 40
    //   522: invokevirtual 166	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   525: ifeq +10 -> 535
    //   528: bipush 6
    //   530: istore 25
    //   532: goto -318 -> 214
    //   535: ldc 239
    //   537: aload 40
    //   539: invokevirtual 166	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   542: ifeq +10 -> 552
    //   545: bipush 7
    //   547: istore 25
    //   549: goto -335 -> 214
    //   552: ldc 162
    //   554: aload 40
    //   556: invokevirtual 166	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   559: ifeq +9 -> 568
    //   562: iconst_3
    //   563: istore 25
    //   565: goto -351 -> 214
    //   568: ldc 229
    //   570: aload 40
    //   572: invokevirtual 166	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   575: istore 41
    //   577: iload 41
    //   579: ifeq -365 -> 214
    //   582: iconst_4
    //   583: istore 25
    //   585: goto -371 -> 214
    //   588: iload 27
    //   590: ifne +294 -> 884
    //   593: aload_0
    //   594: ldc 241
    //   596: invokevirtual 113	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   599: checkcast 243	android/telephony/TelephonyManager
    //   602: invokevirtual 247	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   605: astore 30
    //   607: bipush 6
    //   609: newarray byte
    //   611: astore 31
    //   613: aload 30
    //   615: instanceof 249
    //   618: ifeq +80 -> 698
    //   621: aload 30
    //   623: checkcast 249	android/telephony/gsm/GsmCellLocation
    //   626: astore 36
    //   628: aload 36
    //   630: ifnull +279 -> 909
    //   633: aload 36
    //   635: invokevirtual 252	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   638: istore 37
    //   640: aload 31
    //   642: iconst_3
    //   643: ldc 253
    //   645: iload 37
    //   647: iand
    //   648: bipush 8
    //   650: ishr
    //   651: i2b
    //   652: bastore
    //   653: aload 31
    //   655: iconst_2
    //   656: iload 37
    //   658: sipush 255
    //   661: iand
    //   662: i2b
    //   663: bastore
    //   664: aload 36
    //   666: invokevirtual 256	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   669: istore 38
    //   671: aload 31
    //   673: iconst_1
    //   674: ldc 253
    //   676: iload 38
    //   678: iand
    //   679: bipush 8
    //   681: ishr
    //   682: i2b
    //   683: bastore
    //   684: aload 31
    //   686: iconst_0
    //   687: iload 38
    //   689: sipush 255
    //   692: iand
    //   693: i2b
    //   694: bastore
    //   695: goto +214 -> 909
    //   698: aload 30
    //   700: instanceof 258
    //   703: ifeq +77 -> 780
    //   706: aload 30
    //   708: checkcast 258	android/telephony/cdma/CdmaCellLocation
    //   711: astore 33
    //   713: aload 33
    //   715: ifnull +65 -> 780
    //   718: aload 33
    //   720: invokevirtual 261	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   723: istore 34
    //   725: aload 31
    //   727: iconst_3
    //   728: ldc 253
    //   730: iload 34
    //   732: iand
    //   733: bipush 8
    //   735: ishr
    //   736: i2b
    //   737: bastore
    //   738: aload 31
    //   740: iconst_2
    //   741: iload 34
    //   743: sipush 255
    //   746: iand
    //   747: i2b
    //   748: bastore
    //   749: aload 33
    //   751: invokevirtual 264	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   754: istore 35
    //   756: aload 31
    //   758: iconst_1
    //   759: ldc 253
    //   761: iload 35
    //   763: iand
    //   764: bipush 8
    //   766: ishr
    //   767: i2b
    //   768: bastore
    //   769: aload 31
    //   771: iconst_0
    //   772: iload 35
    //   774: sipush 255
    //   777: iand
    //   778: i2b
    //   779: bastore
    //   780: aload 31
    //   782: astore 4
    //   784: goto -526 -> 258
    //   787: astore 15
    //   789: aload 7
    //   791: new 94	java/lang/String
    //   794: dup
    //   795: aload 4
    //   797: invokespecial 267	java/lang/String:<init>	([B)V
    //   800: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: pop
    //   804: goto -404 -> 400
    //   807: astore 20
    //   809: aconst_null
    //   810: astore 21
    //   812: goto -780 -> 32
    //   815: astore_3
    //   816: aload_2
    //   817: astore 4
    //   819: iconst_m1
    //   820: istore 5
    //   822: iconst_0
    //   823: istore 6
    //   825: goto -559 -> 266
    //   828: astore 26
    //   830: aload_2
    //   831: astore 4
    //   833: iload 25
    //   835: istore 6
    //   837: iconst_m1
    //   838: istore 5
    //   840: goto -574 -> 266
    //   843: astore 29
    //   845: aload_2
    //   846: astore 4
    //   848: iload 25
    //   850: istore 6
    //   852: iload 28
    //   854: istore 5
    //   856: goto -590 -> 266
    //   859: astore 32
    //   861: aload 31
    //   863: astore 4
    //   865: iload 25
    //   867: istore 6
    //   869: iload 28
    //   871: istore 5
    //   873: goto -607 -> 266
    //   876: astore 46
    //   878: iload 45
    //   880: istore_1
    //   881: goto -418 -> 463
    //   884: aload_2
    //   885: astore 4
    //   887: goto -629 -> 258
    //   890: iconst_0
    //   891: istore 45
    //   893: goto -723 -> 170
    //   896: iconst_0
    //   897: istore 45
    //   899: goto -722 -> 177
    //   902: aload 21
    //   904: astore 23
    //   906: goto -808 -> 98
    //   909: aload 31
    //   911: astore 4
    //   913: goto -655 -> 258
    //
    // Exception table:
    //   from	to	target	type
    //   98	114	461	java/lang/Throwable
    //   119	162	461	java/lang/Throwable
    //   441	450	461	java/lang/Throwable
    //   383	400	787	java/lang/Throwable
    //   21	28	807	java/lang/Throwable
    //   7	21	815	java/lang/Throwable
    //   37	45	815	java/lang/Throwable
    //   45	52	815	java/lang/Throwable
    //   60	94	815	java/lang/Throwable
    //   186	211	828	java/lang/Throwable
    //   214	228	828	java/lang/Throwable
    //   469	479	828	java/lang/Throwable
    //   485	495	828	java/lang/Throwable
    //   502	512	828	java/lang/Throwable
    //   518	528	828	java/lang/Throwable
    //   535	545	828	java/lang/Throwable
    //   552	562	828	java/lang/Throwable
    //   568	577	828	java/lang/Throwable
    //   234	254	843	java/lang/Throwable
    //   593	613	843	java/lang/Throwable
    //   613	628	859	java/lang/Throwable
    //   633	695	859	java/lang/Throwable
    //   698	713	859	java/lang/Throwable
    //   718	780	859	java/lang/Throwable
    //   170	177	876	java/lang/Throwable
  }

  public static final String a(Context paramContext, int paramInt1, short paramShort, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramContext));
    localStringBuilder.append("|");
    localStringBuilder.append("" + paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append("" + paramShort);
    localStringBuilder.append("|");
    localStringBuilder.append("" + a(paramLong1));
    localStringBuilder.append("|");
    localStringBuilder.append("" + a(paramLong2));
    localStringBuilder.append("|");
    localStringBuilder.append("" + paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append("" + paramInt3);
    return cd.a(localStringBuilder.toString().getBytes());
  }

  public static final String a(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
  {
    while (true)
    {
      try
      {
        URI localURI = new URI(paramString1);
        String str1 = a();
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(str1);
        localStringBuilder1.append(localURI.getPath());
        String str2 = a(localURI.getQuery(), paramMap);
        if (TextUtils.isEmpty(str2))
          continue;
        localStringBuilder1.append(str2);
        if (!TextUtils.isEmpty(paramString3))
        {
          str3 = ch.a(paramString3, localStringBuilder1.toString());
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(str1);
          localStringBuilder2.append(str3);
          String str4 = cd.a(localStringBuilder2.toString().getBytes());
          return str4;
        }
      }
      catch (Throwable localThrowable)
      {
        ay.d("SignHelper", "generatorSign[" + paramString1 + "]", localThrowable);
        return null;
      }
      String str3 = null;
    }
  }

  private static final String a(String paramString, Map<String, String> paramMap)
  {
    int i1 = 0;
    try
    {
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString1;
      int i2;
      if (!TextUtils.isEmpty(paramString))
      {
        arrayOfString1 = paramString.split("&");
        if (arrayOfString1 != null)
          i2 = arrayOfString1.length;
      }
      while (true)
      {
        if (i1 < i2)
        {
          String[] arrayOfString2 = arrayOfString1[i1].split("=");
          if ((arrayOfString2 != null) && (arrayOfString2.length == 2))
            localArrayList.add(arrayOfString2[0] + arrayOfString2[1]);
        }
        else
        {
          if ((paramMap != null) && (paramMap.size() > 0))
          {
            Iterator localIterator2 = paramMap.entrySet().iterator();
            while (localIterator2.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator2.next();
              String str2 = (String)localEntry.getKey();
              String str3 = (String)localEntry.getValue();
              if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
                continue;
              localArrayList.add(str2 + str3);
            }
          }
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            Collections.sort(localArrayList);
            StringBuilder localStringBuilder = new StringBuilder();
            Iterator localIterator1 = localArrayList.iterator();
            while (localIterator1.hasNext())
              localStringBuilder.append((String)localIterator1.next());
            String str1 = localStringBuilder.toString();
            return str1;
          }
          return null;
        }
        i1++;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  private static final byte[] a(String paramString)
  {
    byte[] arrayOfByte = new byte[6];
    if ((paramString == null) || (paramString.length() != 17))
      return arrayOfByte;
    String[] arrayOfString = paramString.split(":");
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
      arrayOfByte[i1] = (byte)Integer.parseInt(arrayOfString[i1], 16);
    return arrayOfByte;
  }

  private static final int b(Context paramContext)
  {
    String str = (String)cm.g(paramContext).get("netType");
    if (!TextUtils.isEmpty(str))
    {
      if ("wifi".equals(str))
        return 1;
      if ("2g".equals(str))
        return 2;
      if ("3g".equals(str))
        return 0;
      if ("4g".equals(str))
        return 3;
    }
    return -1;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.b.k
 * JD-Core Version:    0.6.0
 */