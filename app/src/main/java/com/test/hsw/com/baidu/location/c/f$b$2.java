package com.baidu.location.c;

 enum f$b$2
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
    //   60: iconst_0
    //   61: invokestatic 42	com/baidu/location/c/f$b:a	(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/String;I)V
    //   64: aload_1
    //   65: aload 8
    //   67: invokevirtual 46	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   70: astore 32
    //   72: aload 32
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
    //   143: ifeq +15 -> 158
    //   146: aload 19
    //   148: ldc 68
    //   150: invokevirtual 72	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   153: invokestatic 78	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   156: astore 23
    //   158: aload 19
    //   160: ldc 80
    //   162: invokevirtual 62	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   165: istore 24
    //   167: aconst_null
    //   168: astore 25
    //   170: iload 24
    //   172: ifeq +15 -> 187
    //   175: aload 19
    //   177: ldc 80
    //   179: invokevirtual 72	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   182: invokestatic 78	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   185: astore 25
    //   187: aload 19
    //   189: ldc 82
    //   191: invokevirtual 62	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   194: istore 26
    //   196: aconst_null
    //   197: astore 27
    //   199: iload 26
    //   201: ifeq +15 -> 216
    //   204: aload 19
    //   206: ldc 82
    //   208: invokevirtual 72	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   211: invokestatic 78	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   214: astore 27
    //   216: aload 19
    //   218: ldc 84
    //   220: invokevirtual 62	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   223: istore 28
    //   225: aconst_null
    //   226: astore 29
    //   228: iload 28
    //   230: ifeq +15 -> 245
    //   233: aload 19
    //   235: ldc 84
    //   237: invokevirtual 72	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   240: invokestatic 78	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   243: astore 29
    //   245: aload 21
    //   247: ifnull +107 -> 354
    //   250: aload 23
    //   252: ifnull +102 -> 354
    //   255: aload 25
    //   257: ifnull +97 -> 354
    //   260: aload 27
    //   262: ifnull +92 -> 354
    //   265: aload 29
    //   267: ifnull +87 -> 354
    //   270: aload 7
    //   272: invokevirtual 85	java/lang/StringBuffer:length	()I
    //   275: ifle +11 -> 286
    //   278: aload 7
    //   280: ldc 87
    //   282: invokevirtual 91	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   285: pop
    //   286: aload 7
    //   288: ldc 93
    //   290: invokevirtual 91	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   293: aload 8
    //   295: invokevirtual 91	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   298: ldc 95
    //   300: invokevirtual 91	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   303: aload 21
    //   305: invokevirtual 91	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   308: ldc 97
    //   310: invokevirtual 91	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   313: aload 23
    //   315: invokevirtual 100	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   318: ldc 87
    //   320: invokevirtual 91	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   323: aload 25
    //   325: invokevirtual 100	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   328: ldc 87
    //   330: invokevirtual 91	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   333: aload 27
    //   335: invokevirtual 100	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   338: ldc 87
    //   340: invokevirtual 91	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   343: aload 29
    //   345: invokevirtual 100	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   348: ldc 102
    //   350: invokevirtual 91	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   353: pop
    //   354: iload 11
    //   356: bipush 50
    //   358: irem
    //   359: bipush 49
    //   361: if_icmpne +60 -> 421
    //   364: aload 7
    //   366: invokevirtual 85	java/lang/StringBuffer:length	()I
    //   369: ifle +52 -> 421
    //   372: getstatic 108	java/util/Locale:US	Ljava/util/Locale;
    //   375: astore 16
    //   377: iconst_2
    //   378: anewarray 110	java/lang/Object
    //   381: astore 17
    //   383: aload 17
    //   385: iconst_0
    //   386: ldc 112
    //   388: aastore
    //   389: aload 17
    //   391: iconst_1
    //   392: aload 7
    //   394: invokevirtual 116	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   397: aastore
    //   398: aload 5
    //   400: aload 16
    //   402: ldc 118
    //   404: aload 17
    //   406: invokestatic 122	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   409: invokeinterface 128 2 0
    //   414: pop
    //   415: aload 7
    //   417: iconst_0
    //   418: invokevirtual 132	java/lang/StringBuffer:setLength	(I)V
    //   421: iinc 11 1
    //   424: goto -340 -> 84
    //   427: astore 9
    //   429: aconst_null
    //   430: astore 10
    //   432: goto -356 -> 76
    //   435: aload 7
    //   437: invokevirtual 85	java/lang/StringBuffer:length	()I
    //   440: ifle -416 -> 24
    //   443: getstatic 108	java/util/Locale:US	Ljava/util/Locale;
    //   446: astore 12
    //   448: iconst_2
    //   449: anewarray 110	java/lang/Object
    //   452: astore 13
    //   454: aload 13
    //   456: iconst_0
    //   457: ldc 112
    //   459: aastore
    //   460: aload 13
    //   462: iconst_1
    //   463: aload 7
    //   465: invokevirtual 116	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   468: aastore
    //   469: aload 5
    //   471: aload 12
    //   473: ldc 118
    //   475: aload 13
    //   477: invokestatic 122	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   480: invokeinterface 128 2 0
    //   485: pop
    //   486: goto -462 -> 24
    //   489: aload 6
    //   491: invokevirtual 85	java/lang/StringBuffer:length	()I
    //   494: ifle +33 -> 527
    //   497: aload 5
    //   499: getstatic 108	java/util/Locale:US	Ljava/util/Locale;
    //   502: ldc 118
    //   504: iconst_2
    //   505: anewarray 110	java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: ldc 134
    //   512: aastore
    //   513: dup
    //   514: iconst_1
    //   515: aload 6
    //   517: aastore
    //   518: invokestatic 122	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   521: invokeinterface 128 2 0
    //   526: pop
    //   527: getstatic 108	java/util/Locale:US	Ljava/util/Locale;
    //   530: astore 33
    //   532: iconst_1
    //   533: anewarray 110	java/lang/Object
    //   536: astore 34
    //   538: aload 34
    //   540: iconst_0
    //   541: iload_3
    //   542: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   545: aastore
    //   546: aload 5
    //   548: aload 33
    //   550: ldc 141
    //   552: aload 34
    //   554: invokestatic 122	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   557: invokeinterface 128 2 0
    //   562: pop
    //   563: aload 5
    //   565: areturn
    //   566: astore 15
    //   568: goto -214 -> 354
    //
    // Exception table:
    //   from	to	target	type
    //   64	72	427	org/json/JSONException
    //   94	112	566	org/json/JSONException
    //   120	129	566	org/json/JSONException
    //   129	138	566	org/json/JSONException
    //   146	158	566	org/json/JSONException
    //   158	167	566	org/json/JSONException
    //   175	187	566	org/json/JSONException
    //   187	196	566	org/json/JSONException
    //   204	216	566	org/json/JSONException
    //   216	225	566	org/json/JSONException
    //   233	245	566	org/json/JSONException
    //   270	286	566	org/json/JSONException
    //   286	354	566	org/json/JSONException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.f.b.2
 * JD-Core Version:    0.6.0
 */