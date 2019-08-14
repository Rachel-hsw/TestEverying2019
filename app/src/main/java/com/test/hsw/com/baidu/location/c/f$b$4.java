package com.baidu.location.c;

 enum f$b$4
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
    //   31: ifeq +458 -> 489
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
    //   60: iconst_1
    //   61: invokestatic 42	com/baidu/location/c/f$b:a	(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/String;I)V
    //   64: aload_1
    //   65: aload 8
    //   67: invokevirtual 46	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   70: astore 34
    //   72: aload 34
    //   74: astore 10
    //   76: aload 10
    //   78: ifnull -54 -> 24
    //   81: iconst_0
    //   82: istore 11
    //   84: iload 11
    //   86: aload 10
    //   88: invokevirtual 52	org/json/JSONArray:length	()I
    //   91: if_icmpge +344 -> 435
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
    //   169: ifeq +12 -> 181
    //   172: aload 19
    //   174: ldc 70
    //   176: invokevirtual 66	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore 25
    //   181: aload 19
    //   183: ldc 72
    //   185: invokevirtual 62	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   188: istore 26
    //   190: aconst_null
    //   191: astore 27
    //   193: iload 26
    //   195: ifeq +15 -> 210
    //   198: aload 19
    //   200: ldc 72
    //   202: invokevirtual 76	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   205: invokestatic 82	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: astore 27
    //   210: aload 19
    //   212: ldc 84
    //   214: invokevirtual 62	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   217: istore 28
    //   219: aconst_null
    //   220: astore 29
    //   222: iload 28
    //   224: ifeq +15 -> 239
    //   227: aload 19
    //   229: ldc 84
    //   231: invokevirtual 88	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   234: invokestatic 93	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   237: astore 29
    //   239: aload 19
    //   241: ldc 95
    //   243: invokevirtual 62	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   246: istore 30
    //   248: aconst_null
    //   249: astore 31
    //   251: iload 30
    //   253: ifeq +15 -> 268
    //   256: aload 19
    //   258: ldc 95
    //   260: invokevirtual 88	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   263: invokestatic 93	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   266: astore 31
    //   268: aload 7
    //   270: invokevirtual 96	java/lang/StringBuffer:length	()I
    //   273: ifle +11 -> 284
    //   276: aload 7
    //   278: ldc 98
    //   280: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   283: pop
    //   284: aload 7
    //   286: ldc 104
    //   288: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   291: aload 21
    //   293: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   296: ldc 106
    //   298: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   301: aload 8
    //   303: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   306: ldc 106
    //   308: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   311: aload 23
    //   313: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   316: ldc 106
    //   318: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   321: aload 25
    //   323: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   326: ldc 108
    //   328: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   331: aload 29
    //   333: invokevirtual 111	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   336: ldc 98
    //   338: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   341: aload 31
    //   343: invokevirtual 111	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   346: ldc 98
    //   348: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   351: aload 27
    //   353: invokevirtual 111	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   356: ldc 113
    //   358: invokevirtual 102	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   361: pop
    //   362: iload 11
    //   364: bipush 50
    //   366: irem
    //   367: bipush 49
    //   369: if_icmpne +52 -> 421
    //   372: getstatic 119	java/util/Locale:US	Ljava/util/Locale;
    //   375: astore 16
    //   377: iconst_2
    //   378: anewarray 121	java/lang/Object
    //   381: astore 17
    //   383: aload 17
    //   385: iconst_0
    //   386: ldc 123
    //   388: aastore
    //   389: aload 17
    //   391: iconst_1
    //   392: aload 7
    //   394: invokevirtual 127	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   397: aastore
    //   398: aload 5
    //   400: aload 16
    //   402: ldc 129
    //   404: aload 17
    //   406: invokestatic 133	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   409: invokeinterface 139 2 0
    //   414: pop
    //   415: aload 7
    //   417: iconst_0
    //   418: invokevirtual 143	java/lang/StringBuffer:setLength	(I)V
    //   421: iinc 11 1
    //   424: goto -340 -> 84
    //   427: astore 9
    //   429: aconst_null
    //   430: astore 10
    //   432: goto -356 -> 76
    //   435: aload 7
    //   437: invokevirtual 96	java/lang/StringBuffer:length	()I
    //   440: ifle -416 -> 24
    //   443: getstatic 119	java/util/Locale:US	Ljava/util/Locale;
    //   446: astore 12
    //   448: iconst_2
    //   449: anewarray 121	java/lang/Object
    //   452: astore 13
    //   454: aload 13
    //   456: iconst_0
    //   457: ldc 123
    //   459: aastore
    //   460: aload 13
    //   462: iconst_1
    //   463: aload 7
    //   465: invokevirtual 127	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   468: aastore
    //   469: aload 5
    //   471: aload 12
    //   473: ldc 129
    //   475: aload 13
    //   477: invokestatic 133	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   480: invokeinterface 139 2 0
    //   485: pop
    //   486: goto -462 -> 24
    //   489: aload 6
    //   491: invokevirtual 96	java/lang/StringBuffer:length	()I
    //   494: ifle +33 -> 527
    //   497: aload 5
    //   499: getstatic 119	java/util/Locale:US	Ljava/util/Locale;
    //   502: ldc 129
    //   504: iconst_2
    //   505: anewarray 121	java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: ldc 145
    //   512: aastore
    //   513: dup
    //   514: iconst_1
    //   515: aload 6
    //   517: aastore
    //   518: invokestatic 133	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   521: invokeinterface 139 2 0
    //   526: pop
    //   527: getstatic 119	java/util/Locale:US	Ljava/util/Locale;
    //   530: astore 35
    //   532: iconst_1
    //   533: anewarray 121	java/lang/Object
    //   536: astore 36
    //   538: aload 36
    //   540: iconst_0
    //   541: iload_3
    //   542: invokestatic 82	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   545: aastore
    //   546: aload 5
    //   548: aload 35
    //   550: ldc 147
    //   552: aload 36
    //   554: invokestatic 133	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   557: invokeinterface 139 2 0
    //   562: pop
    //   563: aload 5
    //   565: areturn
    //   566: astore 15
    //   568: goto -206 -> 362
    //
    // Exception table:
    //   from	to	target	type
    //   64	72	427	org/json/JSONException
    //   94	112	566	org/json/JSONException
    //   120	129	566	org/json/JSONException
    //   129	138	566	org/json/JSONException
    //   146	155	566	org/json/JSONException
    //   155	164	566	org/json/JSONException
    //   172	181	566	org/json/JSONException
    //   181	190	566	org/json/JSONException
    //   198	210	566	org/json/JSONException
    //   210	219	566	org/json/JSONException
    //   227	239	566	org/json/JSONException
    //   239	248	566	org/json/JSONException
    //   256	268	566	org/json/JSONException
    //   268	284	566	org/json/JSONException
    //   284	362	566	org/json/JSONException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.f.b.4
 * JD-Core Version:    0.6.0
 */