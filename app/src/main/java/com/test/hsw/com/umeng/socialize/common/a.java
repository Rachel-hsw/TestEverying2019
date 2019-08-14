package com.umeng.socialize.common;

public class a
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final String[] m = { "jpeg", "gif", "png", "bmp", "pcx", "iff", "ras", "pbm", "pgm", "ppm", "psd", "swf" };

  // ERROR //
  public static String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 71	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 74	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 80	java/io/InputStream:read	()I
    //   13: istore 7
    //   15: aload_1
    //   16: invokevirtual 80	java/io/InputStream:read	()I
    //   19: istore 8
    //   21: iload 7
    //   23: bipush 71
    //   25: if_icmpne +35 -> 60
    //   28: iload 8
    //   30: bipush 73
    //   32: if_icmpne +28 -> 60
    //   35: getstatic 61	com/umeng/socialize/common/a:m	[Ljava/lang/String;
    //   38: iconst_1
    //   39: aaload
    //   40: astore_3
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 83	java/io/InputStream:close	()V
    //   49: aload_3
    //   50: areturn
    //   51: astore 22
    //   53: aload 22
    //   55: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   58: aload_3
    //   59: areturn
    //   60: iload 7
    //   62: sipush 137
    //   65: if_icmpne +35 -> 100
    //   68: iload 8
    //   70: bipush 80
    //   72: if_icmpne +28 -> 100
    //   75: getstatic 61	com/umeng/socialize/common/a:m	[Ljava/lang/String;
    //   78: iconst_2
    //   79: aaload
    //   80: astore_3
    //   81: aload_1
    //   82: ifnull -33 -> 49
    //   85: aload_1
    //   86: invokevirtual 83	java/io/InputStream:close	()V
    //   89: aload_3
    //   90: areturn
    //   91: astore 21
    //   93: aload 21
    //   95: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   98: aload_3
    //   99: areturn
    //   100: iload 7
    //   102: sipush 255
    //   105: if_icmpne +36 -> 141
    //   108: iload 8
    //   110: sipush 216
    //   113: if_icmpne +28 -> 141
    //   116: getstatic 61	com/umeng/socialize/common/a:m	[Ljava/lang/String;
    //   119: iconst_0
    //   120: aaload
    //   121: astore_3
    //   122: aload_1
    //   123: ifnull -74 -> 49
    //   126: aload_1
    //   127: invokevirtual 83	java/io/InputStream:close	()V
    //   130: aload_3
    //   131: areturn
    //   132: astore 20
    //   134: aload 20
    //   136: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   139: aload_3
    //   140: areturn
    //   141: iload 7
    //   143: bipush 66
    //   145: if_icmpne +35 -> 180
    //   148: iload 8
    //   150: bipush 77
    //   152: if_icmpne +28 -> 180
    //   155: getstatic 61	com/umeng/socialize/common/a:m	[Ljava/lang/String;
    //   158: iconst_3
    //   159: aaload
    //   160: astore_3
    //   161: aload_1
    //   162: ifnull -113 -> 49
    //   165: aload_1
    //   166: invokevirtual 83	java/io/InputStream:close	()V
    //   169: aload_3
    //   170: areturn
    //   171: astore 19
    //   173: aload 19
    //   175: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   178: aload_3
    //   179: areturn
    //   180: iload 7
    //   182: bipush 10
    //   184: if_icmpne +35 -> 219
    //   187: iload 8
    //   189: bipush 6
    //   191: if_icmpge +28 -> 219
    //   194: getstatic 61	com/umeng/socialize/common/a:m	[Ljava/lang/String;
    //   197: iconst_4
    //   198: aaload
    //   199: astore_3
    //   200: aload_1
    //   201: ifnull -152 -> 49
    //   204: aload_1
    //   205: invokevirtual 83	java/io/InputStream:close	()V
    //   208: aload_3
    //   209: areturn
    //   210: astore 18
    //   212: aload 18
    //   214: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   217: aload_3
    //   218: areturn
    //   219: iload 7
    //   221: bipush 70
    //   223: if_icmpne +35 -> 258
    //   226: iload 8
    //   228: bipush 79
    //   230: if_icmpne +28 -> 258
    //   233: getstatic 61	com/umeng/socialize/common/a:m	[Ljava/lang/String;
    //   236: iconst_5
    //   237: aaload
    //   238: astore_3
    //   239: aload_1
    //   240: ifnull -191 -> 49
    //   243: aload_1
    //   244: invokevirtual 83	java/io/InputStream:close	()V
    //   247: aload_3
    //   248: areturn
    //   249: astore 17
    //   251: aload 17
    //   253: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   256: aload_3
    //   257: areturn
    //   258: iload 7
    //   260: bipush 89
    //   262: if_icmpne +37 -> 299
    //   265: iload 8
    //   267: sipush 166
    //   270: if_icmpne +29 -> 299
    //   273: getstatic 61	com/umeng/socialize/common/a:m	[Ljava/lang/String;
    //   276: bipush 6
    //   278: aaload
    //   279: astore_3
    //   280: aload_1
    //   281: ifnull -232 -> 49
    //   284: aload_1
    //   285: invokevirtual 83	java/io/InputStream:close	()V
    //   288: aload_3
    //   289: areturn
    //   290: astore 16
    //   292: aload 16
    //   294: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   297: aload_3
    //   298: areturn
    //   299: iload 7
    //   301: bipush 80
    //   303: if_icmpne +112 -> 415
    //   306: iload 8
    //   308: bipush 49
    //   310: if_icmplt +105 -> 415
    //   313: iload 8
    //   315: bipush 54
    //   317: if_icmpgt +98 -> 415
    //   320: iload 8
    //   322: bipush 48
    //   324: isub
    //   325: istore 12
    //   327: iload 12
    //   329: iconst_1
    //   330: if_icmplt +10 -> 340
    //   333: iload 12
    //   335: bipush 6
    //   337: if_icmple +25 -> 362
    //   340: ldc 88
    //   342: astore_3
    //   343: aload_1
    //   344: ifnull -295 -> 49
    //   347: aload_1
    //   348: invokevirtual 83	java/io/InputStream:close	()V
    //   351: aload_3
    //   352: areturn
    //   353: astore 13
    //   355: aload 13
    //   357: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   360: aload_3
    //   361: areturn
    //   362: iconst_3
    //   363: newarray int
    //   365: dup
    //   366: iconst_0
    //   367: bipush 7
    //   369: iastore
    //   370: dup
    //   371: iconst_1
    //   372: bipush 8
    //   374: iastore
    //   375: dup
    //   376: iconst_2
    //   377: bipush 9
    //   379: iastore
    //   380: iload 12
    //   382: iconst_1
    //   383: isub
    //   384: iconst_3
    //   385: irem
    //   386: iaload
    //   387: istore 14
    //   389: getstatic 61	com/umeng/socialize/common/a:m	[Ljava/lang/String;
    //   392: iload 14
    //   394: aaload
    //   395: astore_3
    //   396: aload_1
    //   397: ifnull -348 -> 49
    //   400: aload_1
    //   401: invokevirtual 83	java/io/InputStream:close	()V
    //   404: aload_3
    //   405: areturn
    //   406: astore 15
    //   408: aload 15
    //   410: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   413: aload_3
    //   414: areturn
    //   415: iload 7
    //   417: bipush 56
    //   419: if_icmpne +36 -> 455
    //   422: iload 8
    //   424: bipush 66
    //   426: if_icmpne +29 -> 455
    //   429: getstatic 61	com/umeng/socialize/common/a:m	[Ljava/lang/String;
    //   432: bipush 10
    //   434: aaload
    //   435: astore_3
    //   436: aload_1
    //   437: ifnull -388 -> 49
    //   440: aload_1
    //   441: invokevirtual 83	java/io/InputStream:close	()V
    //   444: aload_3
    //   445: areturn
    //   446: astore 11
    //   448: aload 11
    //   450: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   453: aload_3
    //   454: areturn
    //   455: iload 7
    //   457: bipush 70
    //   459: if_icmpne +36 -> 495
    //   462: iload 8
    //   464: bipush 87
    //   466: if_icmpne +29 -> 495
    //   469: getstatic 61	com/umeng/socialize/common/a:m	[Ljava/lang/String;
    //   472: bipush 11
    //   474: aaload
    //   475: astore_3
    //   476: aload_1
    //   477: ifnull -428 -> 49
    //   480: aload_1
    //   481: invokevirtual 83	java/io/InputStream:close	()V
    //   484: aload_3
    //   485: areturn
    //   486: astore 10
    //   488: aload 10
    //   490: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   493: aload_3
    //   494: areturn
    //   495: ldc 88
    //   497: astore_3
    //   498: aload_1
    //   499: ifnull -450 -> 49
    //   502: aload_1
    //   503: invokevirtual 83	java/io/InputStream:close	()V
    //   506: aload_3
    //   507: areturn
    //   508: astore 9
    //   510: aload 9
    //   512: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   515: aload_3
    //   516: areturn
    //   517: astore 24
    //   519: aconst_null
    //   520: astore_1
    //   521: ldc 88
    //   523: astore_3
    //   524: aload_1
    //   525: ifnull -476 -> 49
    //   528: aload_1
    //   529: invokevirtual 83	java/io/InputStream:close	()V
    //   532: aload_3
    //   533: areturn
    //   534: astore 4
    //   536: aload 4
    //   538: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   541: aload_3
    //   542: areturn
    //   543: astore 23
    //   545: aconst_null
    //   546: astore_1
    //   547: aload 23
    //   549: astore 5
    //   551: aload_1
    //   552: ifnull +7 -> 559
    //   555: aload_1
    //   556: invokevirtual 83	java/io/InputStream:close	()V
    //   559: aload 5
    //   561: athrow
    //   562: astore 6
    //   564: aload 6
    //   566: invokevirtual 86	java/io/IOException:printStackTrace	()V
    //   569: goto -10 -> 559
    //   572: astore 5
    //   574: goto -23 -> 551
    //   577: astore_2
    //   578: goto -57 -> 521
    //
    // Exception table:
    //   from	to	target	type
    //   45	49	51	java/io/IOException
    //   85	89	91	java/io/IOException
    //   126	130	132	java/io/IOException
    //   165	169	171	java/io/IOException
    //   204	208	210	java/io/IOException
    //   243	247	249	java/io/IOException
    //   284	288	290	java/io/IOException
    //   347	351	353	java/io/IOException
    //   400	404	406	java/io/IOException
    //   440	444	446	java/io/IOException
    //   480	484	486	java/io/IOException
    //   502	506	508	java/io/IOException
    //   0	9	517	java/lang/Exception
    //   528	532	534	java/io/IOException
    //   0	9	543	finally
    //   555	559	562	java/io/IOException
    //   9	21	572	finally
    //   35	41	572	finally
    //   75	81	572	finally
    //   116	122	572	finally
    //   155	161	572	finally
    //   194	200	572	finally
    //   233	239	572	finally
    //   273	280	572	finally
    //   362	396	572	finally
    //   429	436	572	finally
    //   469	476	572	finally
    //   9	21	577	java/lang/Exception
    //   35	41	577	java/lang/Exception
    //   75	81	577	java/lang/Exception
    //   116	122	577	java/lang/Exception
    //   155	161	577	java/lang/Exception
    //   194	200	577	java/lang/Exception
    //   233	239	577	java/lang/Exception
    //   273	280	577	java/lang/Exception
    //   362	396	577	java/lang/Exception
    //   429	436	577	java/lang/Exception
    //   469	476	577	java/lang/Exception
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.common.a
 * JD-Core Version:    0.6.0
 */