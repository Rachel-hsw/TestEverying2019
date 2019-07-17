package com.umeng.message.local;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UmengLocalNotificationHelper
{
  private static final String a = UmengLocalNotificationHelper.class.getName();

  public static String getDateFromTime(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
  }

  public static String getDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    String str1 = "" + paramInt1 + "-";
    String str2;
    String str3;
    label100: String str4;
    if (paramInt2 < 10)
    {
      str2 = str1 + "0" + paramInt2 + "-";
      if (paramInt3 >= 10)
        break label238;
      str3 = str2 + "0" + paramInt3 + " ";
      if (paramInt4 >= 10)
        break label267;
      str4 = str3 + "0" + paramInt4 + ":";
      label137: if (paramInt5 >= 10)
        break label296;
    }
    label267: label296: for (String str5 = str4 + "0" + paramInt5 + ":"; ; str5 = str4 + paramInt5 + ":")
    {
      if (paramInt6 >= 10)
        break label326;
      return str5 + "0" + paramInt6;
      str2 = str1 + paramInt2 + "-";
      break;
      label238: str3 = str2 + paramInt3 + " ";
      break label100;
      str4 = str3 + paramInt4 + ":";
      break label137;
    }
    label326: return str5 + paramInt6;
  }

  public static long getQingMingTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws Exception
  {
    String str = String.valueOf(paramInt1);
    int i = Integer.parseInt(str.substring(-2 + str.length(), str.length()));
    int j = (int)(4.81D + 0.2422D * i);
    int k = i / 4;
    StringBuilder localStringBuilder1 = new StringBuilder(String.valueOf(paramInt1 + "-04-0" + (j - k) + " "));
    Object localObject1;
    Object localObject2;
    label145: StringBuilder localStringBuilder3;
    if (paramInt2 >= 10)
    {
      localObject1 = Integer.valueOf(paramInt2);
      StringBuilder localStringBuilder2 = new StringBuilder(String.valueOf(localObject1 + ":"));
      if (paramInt3 < 10)
        break label219;
      localObject2 = Integer.valueOf(paramInt3);
      localStringBuilder3 = new StringBuilder(String.valueOf(localObject2 + ":"));
      if (paramInt4 < 10)
        break label240;
    }
    label219: label240: for (Object localObject3 = Integer.valueOf(paramInt4); ; localObject3 = "0" + paramInt4)
    {
      return getTimeFromDate(localObject3);
      localObject1 = "0" + paramInt2;
      break;
      localObject2 = "0" + paramInt3;
      break label145;
    }
  }

  // ERROR //
  public static long getTimeAndUpdateLocalNotification(android.content.Context paramContext, UmengLocalNotification paramUmengLocalNotification)
  {
    // Byte code:
    //   0: invokestatic 113	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aload_1
    //   5: invokevirtual 118	com/umeng/message/local/UmengLocalNotification:getYear	()I
    //   8: istore 4
    //   10: aload_1
    //   11: invokevirtual 121	com/umeng/message/local/UmengLocalNotification:getMonth	()I
    //   14: istore 5
    //   16: aload_1
    //   17: invokevirtual 124	com/umeng/message/local/UmengLocalNotification:getDay	()I
    //   20: istore 6
    //   22: aload_1
    //   23: invokevirtual 127	com/umeng/message/local/UmengLocalNotification:getHour	()I
    //   26: istore 7
    //   28: aload_1
    //   29: invokevirtual 130	com/umeng/message/local/UmengLocalNotification:getMinute	()I
    //   32: istore 8
    //   34: aload_1
    //   35: invokevirtual 133	com/umeng/message/local/UmengLocalNotification:getSecond	()I
    //   38: istore 9
    //   40: aload_1
    //   41: invokevirtual 136	com/umeng/message/local/UmengLocalNotification:getRepeatingNum	()I
    //   44: istore 10
    //   46: invokestatic 142	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   49: astore 11
    //   51: aload 11
    //   53: iconst_1
    //   54: iload 4
    //   56: invokevirtual 146	java/util/Calendar:set	(II)V
    //   59: aload 11
    //   61: iconst_2
    //   62: iload 5
    //   64: iconst_1
    //   65: isub
    //   66: invokevirtual 146	java/util/Calendar:set	(II)V
    //   69: aload 11
    //   71: iconst_5
    //   72: iload 6
    //   74: invokevirtual 146	java/util/Calendar:set	(II)V
    //   77: aload 11
    //   79: bipush 11
    //   81: iload 7
    //   83: invokevirtual 146	java/util/Calendar:set	(II)V
    //   86: aload 11
    //   88: bipush 12
    //   90: iload 8
    //   92: invokevirtual 146	java/util/Calendar:set	(II)V
    //   95: aload 11
    //   97: bipush 13
    //   99: iload 9
    //   101: invokevirtual 146	java/util/Calendar:set	(II)V
    //   104: aload 11
    //   106: invokevirtual 149	java/util/Calendar:getTimeInMillis	()J
    //   109: lstore 12
    //   111: aload_1
    //   112: invokevirtual 152	com/umeng/message/local/UmengLocalNotification:getSpecialDay	()I
    //   115: istore 14
    //   117: iload 10
    //   119: istore 15
    //   121: lload 12
    //   123: ldc2_w 153
    //   126: lload_2
    //   127: ladd
    //   128: lcmp
    //   129: ifge +8 -> 137
    //   132: iload 15
    //   134: ifgt +122 -> 256
    //   137: invokestatic 142	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   140: astore 16
    //   142: aload 16
    //   144: lload 12
    //   146: invokevirtual 157	java/util/Calendar:setTimeInMillis	(J)V
    //   149: aload 16
    //   151: iconst_1
    //   152: invokevirtual 161	java/util/Calendar:get	(I)I
    //   155: istore 17
    //   157: iconst_1
    //   158: aload 16
    //   160: iconst_2
    //   161: invokevirtual 161	java/util/Calendar:get	(I)I
    //   164: iadd
    //   165: istore 18
    //   167: aload 16
    //   169: iconst_5
    //   170: invokevirtual 161	java/util/Calendar:get	(I)I
    //   173: istore 19
    //   175: aload 16
    //   177: bipush 11
    //   179: invokevirtual 161	java/util/Calendar:get	(I)I
    //   182: istore 20
    //   184: aload 16
    //   186: bipush 12
    //   188: invokevirtual 161	java/util/Calendar:get	(I)I
    //   191: istore 21
    //   193: aload 16
    //   195: bipush 13
    //   197: invokevirtual 161	java/util/Calendar:get	(I)I
    //   200: istore 22
    //   202: aload_1
    //   203: iload 17
    //   205: invokevirtual 165	com/umeng/message/local/UmengLocalNotification:setYear	(I)V
    //   208: aload_1
    //   209: iload 18
    //   211: invokevirtual 168	com/umeng/message/local/UmengLocalNotification:setMonth	(I)V
    //   214: aload_1
    //   215: iload 19
    //   217: invokevirtual 171	com/umeng/message/local/UmengLocalNotification:setDay	(I)V
    //   220: aload_1
    //   221: iload 20
    //   223: invokevirtual 174	com/umeng/message/local/UmengLocalNotification:setHour	(I)V
    //   226: aload_1
    //   227: iload 21
    //   229: invokevirtual 177	com/umeng/message/local/UmengLocalNotification:setMinute	(I)V
    //   232: aload_1
    //   233: iload 22
    //   235: invokevirtual 180	com/umeng/message/local/UmengLocalNotification:setSecond	(I)V
    //   238: aload_1
    //   239: iload 15
    //   241: invokevirtual 183	com/umeng/message/local/UmengLocalNotification:setRepeatingNum	(I)V
    //   244: aload_0
    //   245: invokestatic 188	com/umeng/message/local/UmengLocalNotificationStore:getInstance	(Landroid/content/Context;)Lcom/umeng/message/local/UmengLocalNotificationStore;
    //   248: aload_1
    //   249: invokevirtual 192	com/umeng/message/local/UmengLocalNotificationStore:updateLocalNotification	(Lcom/umeng/message/local/UmengLocalNotification;)Z
    //   252: pop
    //   253: lload 12
    //   255: lreturn
    //   256: iload 14
    //   258: ifeq +1142 -> 1400
    //   261: iload 4
    //   263: aload_1
    //   264: invokevirtual 195	com/umeng/message/local/UmengLocalNotification:getRepeatingInterval	()I
    //   267: iadd
    //   268: istore 37
    //   270: iload 14
    //   272: tableswitch	default:+64 -> 336, 1:+90->362, 2:+314->586, 3:+365->637, 4:+401->673, 5:+438->710, 6:+466->738, 7:+690->962, 8:+726->998, 9:+764->1036, 10:+802->1074, 11:+1026->1298, 12:+1064->1336
    //   337: iconst_3
    //   338: istore 30
    //   340: iload 37
    //   342: istore 4
    //   344: iload 5
    //   346: istore 29
    //   348: iinc 15 255
    //   351: iload 29
    //   353: istore 5
    //   355: iload 30
    //   357: istore 6
    //   359: goto -238 -> 121
    //   362: new 41	java/lang/StringBuilder
    //   365: dup
    //   366: new 41	java/lang/StringBuilder
    //   369: dup
    //   370: iload 37
    //   372: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   375: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: ldc 197
    //   380: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   389: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   392: astore 57
    //   394: iload 7
    //   396: bipush 10
    //   398: if_icmplt +122 -> 520
    //   401: iload 7
    //   403: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: astore 58
    //   408: new 41	java/lang/StringBuilder
    //   411: dup
    //   412: aload 57
    //   414: aload 58
    //   416: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   419: ldc 68
    //   421: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   430: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   433: astore 59
    //   435: iload 8
    //   437: bipush 10
    //   439: if_icmplt +103 -> 542
    //   442: iload 8
    //   444: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   447: astore 60
    //   449: new 41	java/lang/StringBuilder
    //   452: dup
    //   453: aload 59
    //   455: aload 60
    //   457: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   460: ldc 68
    //   462: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   471: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   474: astore 61
    //   476: iload 9
    //   478: bipush 10
    //   480: if_icmplt +84 -> 564
    //   483: iload 9
    //   485: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   488: astore 62
    //   490: aload 61
    //   492: aload 62
    //   494: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   503: lstore 12
    //   505: iload 6
    //   507: istore 30
    //   509: iload 37
    //   511: istore 4
    //   513: iload 5
    //   515: istore 29
    //   517: goto -169 -> 348
    //   520: new 41	java/lang/StringBuilder
    //   523: dup
    //   524: ldc 64
    //   526: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   529: iload 7
    //   531: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   534: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: astore 58
    //   539: goto -131 -> 408
    //   542: new 41	java/lang/StringBuilder
    //   545: dup
    //   546: ldc 64
    //   548: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   551: iload 8
    //   553: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   556: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: astore 60
    //   561: goto -112 -> 449
    //   564: new 41	java/lang/StringBuilder
    //   567: dup
    //   568: ldc 64
    //   570: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   573: iload 9
    //   575: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   578: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: astore 62
    //   583: goto -93 -> 490
    //   586: iload 37
    //   588: bipush 12
    //   590: invokestatic 203	com/umeng/message/local/UmengCalendar:iGetLMonthDays	(II)I
    //   593: istore 54
    //   595: iload 54
    //   597: istore 30
    //   599: iload 37
    //   601: bipush 12
    //   603: iload 30
    //   605: iload 7
    //   607: iload 8
    //   609: iload 9
    //   611: invokestatic 205	com/umeng/message/local/UmengLocalNotificationHelper:getDateTime	(IIIIII)Ljava/lang/String;
    //   614: invokestatic 209	com/umeng/message/local/UmengCalendar:lunarTosolar	(Ljava/lang/String;)Ljava/lang/String;
    //   617: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   620: lstore 55
    //   622: lload 55
    //   624: lstore 12
    //   626: iload 37
    //   628: istore 4
    //   630: iload 5
    //   632: istore 29
    //   634: goto -286 -> 348
    //   637: iload 37
    //   639: iconst_1
    //   640: iconst_1
    //   641: iload 7
    //   643: iload 8
    //   645: iload 9
    //   647: invokestatic 205	com/umeng/message/local/UmengLocalNotificationHelper:getDateTime	(IIIIII)Ljava/lang/String;
    //   650: invokestatic 209	com/umeng/message/local/UmengCalendar:lunarTosolar	(Ljava/lang/String;)Ljava/lang/String;
    //   653: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   656: lstore 12
    //   658: iload 6
    //   660: istore 30
    //   662: iload 37
    //   664: istore 4
    //   666: iload 5
    //   668: istore 29
    //   670: goto -322 -> 348
    //   673: iload 37
    //   675: iconst_1
    //   676: bipush 15
    //   678: iload 7
    //   680: iload 8
    //   682: iload 9
    //   684: invokestatic 205	com/umeng/message/local/UmengLocalNotificationHelper:getDateTime	(IIIIII)Ljava/lang/String;
    //   687: invokestatic 209	com/umeng/message/local/UmengCalendar:lunarTosolar	(Ljava/lang/String;)Ljava/lang/String;
    //   690: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   693: lstore 12
    //   695: iload 6
    //   697: istore 30
    //   699: iload 37
    //   701: istore 4
    //   703: iload 5
    //   705: istore 29
    //   707: goto -359 -> 348
    //   710: iload 37
    //   712: iload 7
    //   714: iload 8
    //   716: iload 9
    //   718: invokestatic 211	com/umeng/message/local/UmengLocalNotificationHelper:getQingMingTime	(IIII)J
    //   721: lstore 12
    //   723: iload 6
    //   725: istore 30
    //   727: iload 37
    //   729: istore 4
    //   731: iload 5
    //   733: istore 29
    //   735: goto -387 -> 348
    //   738: new 41	java/lang/StringBuilder
    //   741: dup
    //   742: new 41	java/lang/StringBuilder
    //   745: dup
    //   746: iload 37
    //   748: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   751: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   754: ldc 213
    //   756: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   765: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   768: astore 48
    //   770: iload 7
    //   772: bipush 10
    //   774: if_icmplt +122 -> 896
    //   777: iload 7
    //   779: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   782: astore 49
    //   784: new 41	java/lang/StringBuilder
    //   787: dup
    //   788: aload 48
    //   790: aload 49
    //   792: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   795: ldc 68
    //   797: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   806: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   809: astore 50
    //   811: iload 8
    //   813: bipush 10
    //   815: if_icmplt +103 -> 918
    //   818: iload 8
    //   820: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   823: astore 51
    //   825: new 41	java/lang/StringBuilder
    //   828: dup
    //   829: aload 50
    //   831: aload 51
    //   833: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   836: ldc 68
    //   838: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   847: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   850: astore 52
    //   852: iload 9
    //   854: bipush 10
    //   856: if_icmplt +84 -> 940
    //   859: iload 9
    //   861: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   864: astore 53
    //   866: aload 52
    //   868: aload 53
    //   870: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   873: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   879: lstore 12
    //   881: iload 6
    //   883: istore 30
    //   885: iload 37
    //   887: istore 4
    //   889: iload 5
    //   891: istore 29
    //   893: goto -545 -> 348
    //   896: new 41	java/lang/StringBuilder
    //   899: dup
    //   900: ldc 64
    //   902: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   905: iload 7
    //   907: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   910: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: astore 49
    //   915: goto -131 -> 784
    //   918: new 41	java/lang/StringBuilder
    //   921: dup
    //   922: ldc 64
    //   924: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   927: iload 8
    //   929: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   932: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   935: astore 51
    //   937: goto -112 -> 825
    //   940: new 41	java/lang/StringBuilder
    //   943: dup
    //   944: ldc 64
    //   946: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   949: iload 9
    //   951: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   954: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: astore 53
    //   959: goto -93 -> 866
    //   962: iload 37
    //   964: iconst_5
    //   965: iconst_5
    //   966: iload 7
    //   968: iload 8
    //   970: iload 9
    //   972: invokestatic 205	com/umeng/message/local/UmengLocalNotificationHelper:getDateTime	(IIIIII)Ljava/lang/String;
    //   975: invokestatic 209	com/umeng/message/local/UmengCalendar:lunarTosolar	(Ljava/lang/String;)Ljava/lang/String;
    //   978: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   981: lstore 12
    //   983: iload 6
    //   985: istore 30
    //   987: iload 37
    //   989: istore 4
    //   991: iload 5
    //   993: istore 29
    //   995: goto -647 -> 348
    //   998: iload 37
    //   1000: bipush 7
    //   1002: bipush 7
    //   1004: iload 7
    //   1006: iload 8
    //   1008: iload 9
    //   1010: invokestatic 205	com/umeng/message/local/UmengLocalNotificationHelper:getDateTime	(IIIIII)Ljava/lang/String;
    //   1013: invokestatic 209	com/umeng/message/local/UmengCalendar:lunarTosolar	(Ljava/lang/String;)Ljava/lang/String;
    //   1016: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   1019: lstore 12
    //   1021: iload 6
    //   1023: istore 30
    //   1025: iload 37
    //   1027: istore 4
    //   1029: iload 5
    //   1031: istore 29
    //   1033: goto -685 -> 348
    //   1036: iload 37
    //   1038: bipush 8
    //   1040: bipush 15
    //   1042: iload 7
    //   1044: iload 8
    //   1046: iload 9
    //   1048: invokestatic 205	com/umeng/message/local/UmengLocalNotificationHelper:getDateTime	(IIIIII)Ljava/lang/String;
    //   1051: invokestatic 209	com/umeng/message/local/UmengCalendar:lunarTosolar	(Ljava/lang/String;)Ljava/lang/String;
    //   1054: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   1057: lstore 12
    //   1059: iload 6
    //   1061: istore 30
    //   1063: iload 37
    //   1065: istore 4
    //   1067: iload 5
    //   1069: istore 29
    //   1071: goto -723 -> 348
    //   1074: new 41	java/lang/StringBuilder
    //   1077: dup
    //   1078: new 41	java/lang/StringBuilder
    //   1081: dup
    //   1082: iload 37
    //   1084: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1087: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1090: ldc 215
    //   1092: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1101: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1104: astore 42
    //   1106: iload 7
    //   1108: bipush 10
    //   1110: if_icmplt +122 -> 1232
    //   1113: iload 7
    //   1115: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1118: astore 43
    //   1120: new 41	java/lang/StringBuilder
    //   1123: dup
    //   1124: aload 42
    //   1126: aload 43
    //   1128: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1131: ldc 68
    //   1133: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1139: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1142: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1145: astore 44
    //   1147: iload 8
    //   1149: bipush 10
    //   1151: if_icmplt +103 -> 1254
    //   1154: iload 8
    //   1156: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1159: astore 45
    //   1161: new 41	java/lang/StringBuilder
    //   1164: dup
    //   1165: aload 44
    //   1167: aload 45
    //   1169: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1172: ldc 68
    //   1174: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1183: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1186: astore 46
    //   1188: iload 9
    //   1190: bipush 10
    //   1192: if_icmplt +84 -> 1276
    //   1195: iload 9
    //   1197: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1200: astore 47
    //   1202: aload 46
    //   1204: aload 47
    //   1206: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1209: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1212: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   1215: lstore 12
    //   1217: iload 6
    //   1219: istore 30
    //   1221: iload 37
    //   1223: istore 4
    //   1225: iload 5
    //   1227: istore 29
    //   1229: goto -881 -> 348
    //   1232: new 41	java/lang/StringBuilder
    //   1235: dup
    //   1236: ldc 64
    //   1238: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1241: iload 7
    //   1243: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1246: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1249: astore 43
    //   1251: goto -131 -> 1120
    //   1254: new 41	java/lang/StringBuilder
    //   1257: dup
    //   1258: ldc 64
    //   1260: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1263: iload 8
    //   1265: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1268: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1271: astore 45
    //   1273: goto -112 -> 1161
    //   1276: new 41	java/lang/StringBuilder
    //   1279: dup
    //   1280: ldc 64
    //   1282: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1285: iload 9
    //   1287: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1290: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1293: astore 47
    //   1295: goto -93 -> 1202
    //   1298: iload 37
    //   1300: bipush 9
    //   1302: bipush 9
    //   1304: iload 7
    //   1306: iload 8
    //   1308: iload 9
    //   1310: invokestatic 205	com/umeng/message/local/UmengLocalNotificationHelper:getDateTime	(IIIIII)Ljava/lang/String;
    //   1313: invokestatic 209	com/umeng/message/local/UmengCalendar:lunarTosolar	(Ljava/lang/String;)Ljava/lang/String;
    //   1316: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   1319: lstore 12
    //   1321: iload 6
    //   1323: istore 30
    //   1325: iload 37
    //   1327: istore 4
    //   1329: iload 5
    //   1331: istore 29
    //   1333: goto -985 -> 348
    //   1336: iload 37
    //   1338: bipush 12
    //   1340: bipush 8
    //   1342: iload 7
    //   1344: iload 8
    //   1346: iload 9
    //   1348: invokestatic 205	com/umeng/message/local/UmengLocalNotificationHelper:getDateTime	(IIIIII)Ljava/lang/String;
    //   1351: invokestatic 209	com/umeng/message/local/UmengCalendar:lunarTosolar	(Ljava/lang/String;)Ljava/lang/String;
    //   1354: invokestatic 105	com/umeng/message/local/UmengLocalNotificationHelper:getTimeFromDate	(Ljava/lang/String;)J
    //   1357: lstore 40
    //   1359: lload 40
    //   1361: lstore 12
    //   1363: goto -1027 -> 336
    //   1366: astore 38
    //   1368: iload 6
    //   1370: istore 30
    //   1372: aload 38
    //   1374: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   1377: getstatic 16	com/umeng/message/local/UmengLocalNotificationHelper:a	Ljava/lang/String;
    //   1380: aload 38
    //   1382: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   1385: invokestatic 225	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1388: pop
    //   1389: iload 37
    //   1391: istore 4
    //   1393: iload 5
    //   1395: istore 29
    //   1397: goto -1049 -> 348
    //   1400: aload_1
    //   1401: invokevirtual 228	com/umeng/message/local/UmengLocalNotification:getRepeatingUnit	()I
    //   1404: istore 26
    //   1406: aload_1
    //   1407: invokevirtual 195	com/umeng/message/local/UmengLocalNotification:getRepeatingInterval	()I
    //   1410: istore 27
    //   1412: iload 26
    //   1414: tableswitch	default:+38 -> 1452, 1:+49->1463, 2:+136->1550, 3:+239->1653, 4:+328->1742, 5:+414->1828, 6:+497->1911
    //   1453: iconst_3
    //   1454: istore 30
    //   1456: iload 5
    //   1458: istore 29
    //   1460: goto -1112 -> 348
    //   1463: iload 4
    //   1465: iload 27
    //   1467: iadd
    //   1468: istore 35
    //   1470: invokestatic 142	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   1473: astore 36
    //   1475: aload 36
    //   1477: iconst_1
    //   1478: iload 35
    //   1480: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1483: aload 36
    //   1485: iconst_2
    //   1486: iload 5
    //   1488: iconst_1
    //   1489: isub
    //   1490: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1493: aload 36
    //   1495: iconst_5
    //   1496: iload 6
    //   1498: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1501: aload 36
    //   1503: bipush 11
    //   1505: iload 7
    //   1507: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1510: aload 36
    //   1512: bipush 12
    //   1514: iload 8
    //   1516: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1519: aload 36
    //   1521: bipush 13
    //   1523: iload 9
    //   1525: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1528: aload 36
    //   1530: invokevirtual 149	java/util/Calendar:getTimeInMillis	()J
    //   1533: lstore 12
    //   1535: iload 6
    //   1537: istore 30
    //   1539: iload 35
    //   1541: istore 4
    //   1543: iload 5
    //   1545: istore 29
    //   1547: goto -1199 -> 348
    //   1550: iload 5
    //   1552: iload 27
    //   1554: iadd
    //   1555: istore 29
    //   1557: iload 29
    //   1559: bipush 12
    //   1561: if_icmple +20 -> 1581
    //   1564: iload 4
    //   1566: iload 29
    //   1568: bipush 12
    //   1570: idiv
    //   1571: iadd
    //   1572: istore 4
    //   1574: iload 29
    //   1576: bipush 12
    //   1578: irem
    //   1579: istore 29
    //   1581: invokestatic 142	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   1584: astore 34
    //   1586: aload 34
    //   1588: iconst_1
    //   1589: iload 4
    //   1591: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1594: aload 34
    //   1596: iconst_2
    //   1597: iload 29
    //   1599: iconst_1
    //   1600: isub
    //   1601: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1604: aload 34
    //   1606: iconst_5
    //   1607: iload 6
    //   1609: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1612: aload 34
    //   1614: bipush 11
    //   1616: iload 7
    //   1618: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1621: aload 34
    //   1623: bipush 12
    //   1625: iload 8
    //   1627: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1630: aload 34
    //   1632: bipush 13
    //   1634: iload 9
    //   1636: invokevirtual 146	java/util/Calendar:set	(II)V
    //   1639: aload 34
    //   1641: invokevirtual 149	java/util/Calendar:getTimeInMillis	()J
    //   1644: lstore 12
    //   1646: iload 6
    //   1648: istore 30
    //   1650: goto -1302 -> 348
    //   1653: lload 12
    //   1655: sipush 1000
    //   1658: bipush 60
    //   1660: bipush 60
    //   1662: iload 27
    //   1664: bipush 24
    //   1666: imul
    //   1667: imul
    //   1668: imul
    //   1669: imul
    //   1670: i2l
    //   1671: ladd
    //   1672: lstore 12
    //   1674: invokestatic 142	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   1677: astore 33
    //   1679: aload 33
    //   1681: lload 12
    //   1683: invokevirtual 157	java/util/Calendar:setTimeInMillis	(J)V
    //   1686: aload 33
    //   1688: iconst_1
    //   1689: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1692: istore 4
    //   1694: iconst_1
    //   1695: aload 33
    //   1697: iconst_2
    //   1698: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1701: iadd
    //   1702: istore 29
    //   1704: aload 33
    //   1706: iconst_5
    //   1707: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1710: istore 30
    //   1712: aload 33
    //   1714: bipush 11
    //   1716: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1719: istore 7
    //   1721: aload 33
    //   1723: bipush 12
    //   1725: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1728: istore 8
    //   1730: aload 33
    //   1732: bipush 13
    //   1734: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1737: istore 9
    //   1739: goto -1391 -> 348
    //   1742: lload 12
    //   1744: sipush 1000
    //   1747: bipush 60
    //   1749: iload 27
    //   1751: bipush 60
    //   1753: imul
    //   1754: imul
    //   1755: imul
    //   1756: i2l
    //   1757: ladd
    //   1758: lstore 12
    //   1760: invokestatic 142	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   1763: astore 32
    //   1765: aload 32
    //   1767: lload 12
    //   1769: invokevirtual 157	java/util/Calendar:setTimeInMillis	(J)V
    //   1772: aload 32
    //   1774: iconst_1
    //   1775: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1778: istore 4
    //   1780: iconst_1
    //   1781: aload 32
    //   1783: iconst_2
    //   1784: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1787: iadd
    //   1788: istore 29
    //   1790: aload 32
    //   1792: iconst_5
    //   1793: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1796: istore 30
    //   1798: aload 32
    //   1800: bipush 11
    //   1802: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1805: istore 7
    //   1807: aload 32
    //   1809: bipush 12
    //   1811: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1814: istore 8
    //   1816: aload 32
    //   1818: bipush 13
    //   1820: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1823: istore 9
    //   1825: goto -1477 -> 348
    //   1828: lload 12
    //   1830: sipush 1000
    //   1833: iload 27
    //   1835: bipush 60
    //   1837: imul
    //   1838: imul
    //   1839: i2l
    //   1840: ladd
    //   1841: lstore 12
    //   1843: invokestatic 142	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   1846: astore 31
    //   1848: aload 31
    //   1850: lload 12
    //   1852: invokevirtual 157	java/util/Calendar:setTimeInMillis	(J)V
    //   1855: aload 31
    //   1857: iconst_1
    //   1858: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1861: istore 4
    //   1863: iconst_1
    //   1864: aload 31
    //   1866: iconst_2
    //   1867: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1870: iadd
    //   1871: istore 29
    //   1873: aload 31
    //   1875: iconst_5
    //   1876: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1879: istore 30
    //   1881: aload 31
    //   1883: bipush 11
    //   1885: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1888: istore 7
    //   1890: aload 31
    //   1892: bipush 12
    //   1894: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1897: istore 8
    //   1899: aload 31
    //   1901: bipush 13
    //   1903: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1906: istore 9
    //   1908: goto -1560 -> 348
    //   1911: lload 12
    //   1913: iload 27
    //   1915: sipush 1000
    //   1918: imul
    //   1919: i2l
    //   1920: ladd
    //   1921: lstore 12
    //   1923: invokestatic 142	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   1926: astore 28
    //   1928: aload 28
    //   1930: lload 12
    //   1932: invokevirtual 157	java/util/Calendar:setTimeInMillis	(J)V
    //   1935: aload 28
    //   1937: iconst_1
    //   1938: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1941: istore 4
    //   1943: iconst_1
    //   1944: aload 28
    //   1946: iconst_2
    //   1947: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1950: iadd
    //   1951: istore 29
    //   1953: aload 28
    //   1955: iconst_5
    //   1956: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1959: istore 30
    //   1961: aload 28
    //   1963: bipush 11
    //   1965: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1968: istore 7
    //   1970: aload 28
    //   1972: bipush 12
    //   1974: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1977: istore 8
    //   1979: aload 28
    //   1981: bipush 13
    //   1983: invokevirtual 161	java/util/Calendar:get	(I)I
    //   1986: istore 9
    //   1988: goto -1640 -> 348
    //   1991: astore 23
    //   1993: getstatic 16	com/umeng/message/local/UmengLocalNotificationHelper:a	Ljava/lang/String;
    //   1996: aload 23
    //   1998: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   2001: invokestatic 225	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2004: pop
    //   2005: aload 23
    //   2007: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   2010: lload 12
    //   2012: lreturn
    //   2013: astore 38
    //   2015: goto -643 -> 1372
    //
    // Exception table:
    //   from	to	target	type
    //   362	394	1366	java/lang/Exception
    //   401	408	1366	java/lang/Exception
    //   408	435	1366	java/lang/Exception
    //   442	449	1366	java/lang/Exception
    //   449	476	1366	java/lang/Exception
    //   483	490	1366	java/lang/Exception
    //   490	505	1366	java/lang/Exception
    //   520	539	1366	java/lang/Exception
    //   542	561	1366	java/lang/Exception
    //   564	583	1366	java/lang/Exception
    //   586	595	1366	java/lang/Exception
    //   637	658	1366	java/lang/Exception
    //   673	695	1366	java/lang/Exception
    //   710	723	1366	java/lang/Exception
    //   738	770	1366	java/lang/Exception
    //   777	784	1366	java/lang/Exception
    //   784	811	1366	java/lang/Exception
    //   818	825	1366	java/lang/Exception
    //   825	852	1366	java/lang/Exception
    //   859	866	1366	java/lang/Exception
    //   866	881	1366	java/lang/Exception
    //   896	915	1366	java/lang/Exception
    //   918	937	1366	java/lang/Exception
    //   940	959	1366	java/lang/Exception
    //   962	983	1366	java/lang/Exception
    //   998	1021	1366	java/lang/Exception
    //   1036	1059	1366	java/lang/Exception
    //   1074	1106	1366	java/lang/Exception
    //   1113	1120	1366	java/lang/Exception
    //   1120	1147	1366	java/lang/Exception
    //   1154	1161	1366	java/lang/Exception
    //   1161	1188	1366	java/lang/Exception
    //   1195	1202	1366	java/lang/Exception
    //   1202	1217	1366	java/lang/Exception
    //   1232	1251	1366	java/lang/Exception
    //   1254	1273	1366	java/lang/Exception
    //   1276	1295	1366	java/lang/Exception
    //   1298	1321	1366	java/lang/Exception
    //   1336	1359	1366	java/lang/Exception
    //   244	253	1991	java/lang/Exception
    //   599	622	2013	java/lang/Exception
  }

  public static long getTimeFromDate(String paramString)
    throws Exception
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString).getTime();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.local.UmengLocalNotificationHelper
 * JD-Core Version:    0.6.0
 */