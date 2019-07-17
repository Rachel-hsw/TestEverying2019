package com.baidu.location.c;

 enum f$b$3
{
  // ERROR //
  java.util.List a(org.json.JSONObject paramJSONObject, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 19	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   4: astore 4
    //   6: new 21	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 24	java/util/ArrayList:<init>	()V
    //   13: astore 5
    //   15: new 26	java/lang/StringBuffer
    //   18: dup
    //   19: invokespecial 27	java/lang/StringBuffer:<init>	()V
    //   22: astore 6
    //   24: aload 4
    //   26: invokeinterface 33 1 0
    //   31: ifeq +391 -> 422
    //   34: new 26	java/lang/StringBuffer
    //   37: dup
    //   38: invokespecial 27	java/lang/StringBuffer:<init>	()V
    //   41: astore 7
    //   43: aload 4
    //   45: invokeinterface 37 1 0
    //   50: checkcast 39	java/lang/String
    //   53: astore 8
    //   55: aload 6
    //   57: aload 8
    //   59: aload_2
    //   60: iconst_0
    //   61: invokestatic 42	com/baidu/location/c/f$b:a	(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/String;I)V
    //   64: aload_1
    //   65: aload 8
    //   67: invokevirtual 46	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   70: astore 30
    //   72: aload 30
    //   74: astore 10
    //   76: aload 10
    //   78: ifnull -54 -> 24
    //   81: iconst_0
    //   82: istore 11
    //   84: iload 11
    //   86: aload 10
    //   88: invokevirtual 52	org/json/JSONArray:length	()I
    //   91: if_icmpge +277 -> 368
    //   94: aload 10
    //   96: iload 11
    //   98: invokevirtual 56	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   101: astore 19
    //   103: aload 19
    //   105: ldc 58
    //   107: invokevirtual 62	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   110: istore 20
    //   112: aconst_null
    //   113: astore 21
    //   115: iload 20
    //   117: ifeq +12 -> 129
    //   120: aload 19
    //   122: ldc 58
    //   124: invokevirtual 66	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 21
    //   129: aload 19
    //   131: ldc 68
    //   133: invokevirtual 62	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   136: istore 22
    //   138: aconst_null
    //   139: astore 23
    //   141: iload 22
    //   143: ifeq +12 -> 155
    //   146: aload 19
    //   148: ldc 68
    //   150: invokevirtual 66	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore 23
    //   155: aload 19
    //   157: ldc 70
    //   159: invokevirtual 62	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   162: istore 24
    //   164: aconst_null
    //   165: astore 25
    //   167: iload 24
    //   169: ifeq +15 -> 184
    //   172: aload 19
    //   174: ldc 70
    //   176: invokevirtual 74	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   179: invokestatic 80	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   182: astore 25
    //   184: aload 19
    //   186: ldc 82
    //   188: invokevirtual 62	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   191: istore 26
    //   193: aconst_null
    //   194: astore 27
    //   196: iload 26
    //   198: ifeq +15 -> 213
    //   201: aload 19
    //   203: ldc 82
    //   205: invokevirtual 74	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   208: invokestatic 80	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   211: astore 27
    //   213: aload 7
    //   215: invokevirtual 83	java/lang/StringBuffer:length	()I
    //   218: ifle +11 -> 229
    //   221: aload 7
    //   223: ldc 85
    //   225: invokevirtual 89	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   228: pop
    //   229: aload 7
    //   231: ldc 91
    //   233: invokevirtual 89	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   236: aload 8
    //   238: invokevirtual 89	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   241: ldc 93
    //   243: invokevirtual 89	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   246: aload 21
    //   248: invokevirtual 89	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   251: ldc 93
    //   253: invokevirtual 89	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   256: aload 23
    //   258: invokevirtual 89	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   261: ldc 95
    //   263: invokevirtual 89	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   266: aload 25
    //   268: invokevirtual 98	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   271: ldc 85
    //   273: invokevirtual 89	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   276: aload 27
    //   278: invokevirtual 98	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   281: ldc 100
    //   283: invokevirtual 89	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   286: pop
    //   287: iload 11
    //   289: bipush 50
    //   291: irem
    //   292: bipush 49
    //   294: if_icmpne +60 -> 354
    //   297: aload 7
    //   299: invokevirtual 83	java/lang/StringBuffer:length	()I
    //   302: ifle +52 -> 354
    //   305: getstatic 106	java/util/Locale:US	Ljava/util/Locale;
    //   308: astore 16
    //   310: iconst_2
    //   311: anewarray 108	java/lang/Object
    //   314: astore 17
    //   316: aload 17
    //   318: iconst_0
    //   319: ldc 110
    //   321: aastore
    //   322: aload 17
    //   324: iconst_1
    //   325: aload 7
    //   327: invokevirtual 114	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   330: aastore
    //   331: aload 5
    //   333: aload 16
    //   335: ldc 116
    //   337: aload 17
    //   339: invokestatic 120	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   342: invokeinterface 126 2 0
    //   347: pop
    //   348: aload 7
    //   350: iconst_0
    //   351: invokevirtual 130	java/lang/StringBuffer:setLength	(I)V
    //   354: iinc 11 1
    //   357: goto -273 -> 84
    //   360: astore 9
    //   362: aconst_null
    //   363: astore 10
    //   365: goto -289 -> 76
    //   368: aload 7
    //   370: invokevirtual 83	java/lang/StringBuffer:length	()I
    //   373: ifle -349 -> 24
    //   376: getstatic 106	java/util/Locale:US	Ljava/util/Locale;
    //   379: astore 12
    //   381: iconst_2
    //   382: anewarray 108	java/lang/Object
    //   385: astore 13
    //   387: aload 13
    //   389: iconst_0
    //   390: ldc 110
    //   392: aastore
    //   393: aload 13
    //   395: iconst_1
    //   396: aload 7
    //   398: invokevirtual 114	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   401: aastore
    //   402: aload 5
    //   404: aload 12
    //   406: ldc 116
    //   408: aload 13
    //   410: invokestatic 120	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   413: invokeinterface 126 2 0
    //   418: pop
    //   419: goto -395 -> 24
    //   422: aload 6
    //   424: invokevirtual 83	java/lang/StringBuffer:length	()I
    //   427: ifle +33 -> 460
    //   430: aload 5
    //   432: getstatic 106	java/util/Locale:US	Ljava/util/Locale;
    //   435: ldc 116
    //   437: iconst_2
    //   438: anewarray 108	java/lang/Object
    //   441: dup
    //   442: iconst_0
    //   443: ldc 132
    //   445: aastore
    //   446: dup
    //   447: iconst_1
    //   448: aload 6
    //   450: aastore
    //   451: invokestatic 120	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   454: invokeinterface 126 2 0
    //   459: pop
    //   460: getstatic 106	java/util/Locale:US	Ljava/util/Locale;
    //   463: astore 31
    //   465: iconst_1
    //   466: anewarray 108	java/lang/Object
    //   469: astore 32
    //   471: aload 32
    //   473: iconst_0
    //   474: iload_3
    //   475: invokestatic 137	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   478: aastore
    //   479: aload 5
    //   481: aload 31
    //   483: ldc 139
    //   485: aload 32
    //   487: invokestatic 120	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   490: invokeinterface 126 2 0
    //   495: pop
    //   496: aload 5
    //   498: areturn
    //   499: astore 15
    //   501: goto -214 -> 287
    //
    // Exception table:
    //   from	to	target	type
    //   64	72	360	org/json/JSONException
    //   94	112	499	org/json/JSONException
    //   120	129	499	org/json/JSONException
    //   129	138	499	org/json/JSONException
    //   146	155	499	org/json/JSONException
    //   155	164	499	org/json/JSONException
    //   172	184	499	org/json/JSONException
    //   184	193	499	org/json/JSONException
    //   201	213	499	org/json/JSONException
    //   213	229	499	org/json/JSONException
    //   229	287	499	org/json/JSONException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.f.b.3
 * JD-Core Version:    0.6.0
 */