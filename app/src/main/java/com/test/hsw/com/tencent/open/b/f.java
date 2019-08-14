package com.tencent.open.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.utils.Global;

public class f extends SQLiteOpenHelper
{
  protected static final String a = com.tencent.open.a.f.d + ".ReportDatabaseHelper";
  protected static final String[] b = { "key" };
  protected static f c;

  public f(Context paramContext)
  {
    super(paramContext, "sdk_report.db", null, 2);
  }

  public static f a()
  {
    monitorenter;
    try
    {
      if (c == null)
        c = new f(Global.getContext());
      f localf = c;
      return localf;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  public java.util.List<java.io.Serializable> a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 64	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 65	java/util/ArrayList:<init>	()V
    //   9: invokestatic 71	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   12: astore_3
    //   13: aload_1
    //   14: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: istore 4
    //   19: iload 4
    //   21: ifeq +11 -> 32
    //   24: aload_3
    //   25: astore 12
    //   27: aload_0
    //   28: monitorexit
    //   29: aload 12
    //   31: areturn
    //   32: aload_0
    //   33: invokevirtual 81	com/tencent/open/b/f:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 5
    //   38: aload 5
    //   40: ifnonnull +9 -> 49
    //   43: aload_3
    //   44: astore 12
    //   46: goto -19 -> 27
    //   49: aload 5
    //   51: ldc 83
    //   53: aconst_null
    //   54: ldc 85
    //   56: iconst_1
    //   57: anewarray 36	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokevirtual 91	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore 14
    //   72: aload 14
    //   74: astore 9
    //   76: aload 9
    //   78: ifnull +110 -> 188
    //   81: aload 9
    //   83: invokeinterface 97 1 0
    //   88: ifle +100 -> 188
    //   91: aload 9
    //   93: invokeinterface 101 1 0
    //   98: pop
    //   99: new 103	java/io/ByteArrayInputStream
    //   102: dup
    //   103: aload 9
    //   105: aload 9
    //   107: ldc 105
    //   109: invokeinterface 109 2 0
    //   114: invokeinterface 113 2 0
    //   119: invokespecial 116	java/io/ByteArrayInputStream:<init>	([B)V
    //   122: astore 18
    //   124: new 118	java/io/ObjectInputStream
    //   127: dup
    //   128: aload 18
    //   130: invokespecial 121	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   133: astore 19
    //   135: aload 19
    //   137: invokevirtual 125	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   140: checkcast 127	java/io/Serializable
    //   143: astore 23
    //   145: aload 19
    //   147: ifnull +8 -> 155
    //   150: aload 19
    //   152: invokevirtual 130	java/io/ObjectInputStream:close	()V
    //   155: aload 18
    //   157: invokevirtual 131	java/io/ByteArrayInputStream:close	()V
    //   160: aload 23
    //   162: ifnull +12 -> 174
    //   165: aload_3
    //   166: aload 23
    //   168: invokeinterface 137 2 0
    //   173: pop
    //   174: aload 9
    //   176: invokeinterface 140 1 0
    //   181: istore 24
    //   183: iload 24
    //   185: ifne -86 -> 99
    //   188: aload 9
    //   190: ifnull +10 -> 200
    //   193: aload 9
    //   195: invokeinterface 141 1 0
    //   200: iconst_0
    //   201: ifeq +7 -> 208
    //   204: aconst_null
    //   205: invokevirtual 130	java/io/ObjectInputStream:close	()V
    //   208: aload 5
    //   210: ifnull +8 -> 218
    //   213: aload 5
    //   215: invokevirtual 142	android/database/sqlite/SQLiteDatabase:close	()V
    //   218: aload_3
    //   219: astore 12
    //   221: goto -194 -> 27
    //   224: astore 32
    //   226: aconst_null
    //   227: astore 21
    //   229: aload 21
    //   231: ifnull +8 -> 239
    //   234: aload 21
    //   236: invokevirtual 130	java/io/ObjectInputStream:close	()V
    //   239: aload 18
    //   241: invokevirtual 131	java/io/ByteArrayInputStream:close	()V
    //   244: aconst_null
    //   245: astore 23
    //   247: goto -87 -> 160
    //   250: astore 22
    //   252: aconst_null
    //   253: astore 23
    //   255: goto -95 -> 160
    //   258: astore 27
    //   260: aconst_null
    //   261: astore 19
    //   263: aload 19
    //   265: ifnull +8 -> 273
    //   268: aload 19
    //   270: invokevirtual 130	java/io/ObjectInputStream:close	()V
    //   273: aload 18
    //   275: invokevirtual 131	java/io/ByteArrayInputStream:close	()V
    //   278: aload 27
    //   280: athrow
    //   281: astore 16
    //   283: aload 9
    //   285: astore 7
    //   287: getstatic 34	com/tencent/open/b/f:a	Ljava/lang/String;
    //   290: ldc 144
    //   292: invokestatic 148	com/tencent/open/a/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload 7
    //   297: ifnull +10 -> 307
    //   300: aload 7
    //   302: invokeinterface 141 1 0
    //   307: iconst_0
    //   308: ifeq +7 -> 315
    //   311: aconst_null
    //   312: invokevirtual 130	java/io/ObjectInputStream:close	()V
    //   315: aload 5
    //   317: ifnull -99 -> 218
    //   320: aload 5
    //   322: invokevirtual 142	android/database/sqlite/SQLiteDatabase:close	()V
    //   325: goto -107 -> 218
    //   328: astore_2
    //   329: aload_0
    //   330: monitorexit
    //   331: aload_2
    //   332: athrow
    //   333: astore 15
    //   335: aload 15
    //   337: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   340: goto -132 -> 208
    //   343: astore 13
    //   345: aload 13
    //   347: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   350: goto -35 -> 315
    //   353: aload 9
    //   355: ifnull +10 -> 365
    //   358: aload 9
    //   360: invokeinterface 141 1 0
    //   365: iconst_0
    //   366: ifeq +7 -> 373
    //   369: aconst_null
    //   370: invokevirtual 130	java/io/ObjectInputStream:close	()V
    //   373: aload 5
    //   375: ifnull +8 -> 383
    //   378: aload 5
    //   380: invokevirtual 142	android/database/sqlite/SQLiteDatabase:close	()V
    //   383: aload 10
    //   385: athrow
    //   386: astore 11
    //   388: aload 11
    //   390: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   393: goto -20 -> 373
    //   396: astore 31
    //   398: goto -243 -> 155
    //   401: astore 30
    //   403: goto -243 -> 160
    //   406: astore 26
    //   408: goto -169 -> 239
    //   411: astore 29
    //   413: goto -140 -> 273
    //   416: astore 28
    //   418: goto -140 -> 278
    //   421: astore 10
    //   423: goto -70 -> 353
    //   426: astore 8
    //   428: aload 7
    //   430: astore 9
    //   432: aload 8
    //   434: astore 10
    //   436: goto -83 -> 353
    //   439: astore 6
    //   441: aconst_null
    //   442: astore 7
    //   444: goto -157 -> 287
    //   447: astore 27
    //   449: goto -186 -> 263
    //   452: astore 20
    //   454: aload 19
    //   456: astore 21
    //   458: goto -229 -> 229
    //   461: astore 10
    //   463: aconst_null
    //   464: astore 9
    //   466: goto -113 -> 353
    //
    // Exception table:
    //   from	to	target	type
    //   124	135	224	java/lang/Exception
    //   239	244	250	java/io/IOException
    //   124	135	258	finally
    //   81	99	281	java/lang/Exception
    //   99	124	281	java/lang/Exception
    //   150	155	281	java/lang/Exception
    //   155	160	281	java/lang/Exception
    //   165	174	281	java/lang/Exception
    //   174	183	281	java/lang/Exception
    //   234	239	281	java/lang/Exception
    //   239	244	281	java/lang/Exception
    //   268	273	281	java/lang/Exception
    //   273	278	281	java/lang/Exception
    //   278	281	281	java/lang/Exception
    //   2	19	328	finally
    //   32	38	328	finally
    //   193	200	328	finally
    //   204	208	328	finally
    //   213	218	328	finally
    //   300	307	328	finally
    //   311	315	328	finally
    //   320	325	328	finally
    //   335	340	328	finally
    //   345	350	328	finally
    //   358	365	328	finally
    //   369	373	328	finally
    //   378	383	328	finally
    //   383	386	328	finally
    //   388	393	328	finally
    //   204	208	333	java/io/IOException
    //   311	315	343	java/io/IOException
    //   369	373	386	java/io/IOException
    //   150	155	396	java/io/IOException
    //   155	160	401	java/io/IOException
    //   234	239	406	java/io/IOException
    //   268	273	411	java/io/IOException
    //   273	278	416	java/io/IOException
    //   81	99	421	finally
    //   99	124	421	finally
    //   150	155	421	finally
    //   155	160	421	finally
    //   165	174	421	finally
    //   174	183	421	finally
    //   234	239	421	finally
    //   239	244	421	finally
    //   268	273	421	finally
    //   273	278	421	finally
    //   278	281	421	finally
    //   287	295	426	finally
    //   49	72	439	java/lang/Exception
    //   135	145	447	finally
    //   135	145	452	java/lang/Exception
    //   49	72	461	finally
  }

  // ERROR //
  public void a(String paramString, java.util.List<java.io.Serializable> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_2
    //   5: invokeinterface 155 1 0
    //   10: istore 5
    //   12: iload 5
    //   14: ifne +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: iload 5
    //   22: bipush 20
    //   24: if_icmpgt +159 -> 183
    //   27: iload 5
    //   29: istore 6
    //   31: aload_1
    //   32: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne -18 -> 17
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 158	com/tencent/open/b/f:b	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 161	com/tencent/open/b/f:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   47: astore 7
    //   49: aload 7
    //   51: ifnull -34 -> 17
    //   54: aload 7
    //   56: invokevirtual 164	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   59: new 166	android/content/ContentValues
    //   62: dup
    //   63: invokespecial 167	android/content/ContentValues:<init>	()V
    //   66: astore 8
    //   68: iconst_0
    //   69: istore 9
    //   71: iload 9
    //   73: iload 6
    //   75: if_icmpge +196 -> 271
    //   78: aload_2
    //   79: iload 9
    //   81: invokeinterface 171 2 0
    //   86: checkcast 127	java/io/Serializable
    //   89: astore 12
    //   91: aload 12
    //   93: ifnull +79 -> 172
    //   96: aload 8
    //   98: ldc 173
    //   100: aload_1
    //   101: invokevirtual 176	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: new 178	java/io/ByteArrayOutputStream
    //   107: dup
    //   108: sipush 512
    //   111: invokespecial 181	java/io/ByteArrayOutputStream:<init>	(I)V
    //   114: astore 13
    //   116: new 183	java/io/ObjectOutputStream
    //   119: dup
    //   120: aload 13
    //   122: invokespecial 186	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   125: astore 14
    //   127: aload 14
    //   129: aload 12
    //   131: invokevirtual 190	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   134: aload 14
    //   136: ifnull +8 -> 144
    //   139: aload 14
    //   141: invokevirtual 191	java/io/ObjectOutputStream:close	()V
    //   144: aload 13
    //   146: invokevirtual 192	java/io/ByteArrayOutputStream:close	()V
    //   149: aload 8
    //   151: ldc 105
    //   153: aload 13
    //   155: invokevirtual 196	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   158: invokevirtual 199	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   161: aload 7
    //   163: ldc 83
    //   165: aconst_null
    //   166: aload 8
    //   168: invokevirtual 203	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   171: pop2
    //   172: aload 8
    //   174: invokevirtual 206	android/content/ContentValues:clear	()V
    //   177: iinc 9 1
    //   180: goto -109 -> 71
    //   183: bipush 20
    //   185: istore 6
    //   187: goto -156 -> 31
    //   190: astore 26
    //   192: aconst_null
    //   193: astore 16
    //   195: aload 16
    //   197: ifnull +8 -> 205
    //   200: aload 16
    //   202: invokevirtual 191	java/io/ObjectOutputStream:close	()V
    //   205: aload 13
    //   207: invokevirtual 192	java/io/ByteArrayOutputStream:close	()V
    //   210: goto -61 -> 149
    //   213: astore 17
    //   215: goto -66 -> 149
    //   218: astore 21
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 191	java/io/ObjectOutputStream:close	()V
    //   228: aload 13
    //   230: invokevirtual 192	java/io/ByteArrayOutputStream:close	()V
    //   233: aload 21
    //   235: athrow
    //   236: astore 11
    //   238: getstatic 34	com/tencent/open/b/f:a	Ljava/lang/String;
    //   241: ldc 208
    //   243: invokestatic 148	com/tencent/open/a/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload 7
    //   248: invokevirtual 211	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   251: aload 7
    //   253: ifnull -236 -> 17
    //   256: aload 7
    //   258: invokevirtual 142	android/database/sqlite/SQLiteDatabase:close	()V
    //   261: goto -244 -> 17
    //   264: astore 4
    //   266: aload_0
    //   267: monitorexit
    //   268: aload 4
    //   270: athrow
    //   271: aload 7
    //   273: invokevirtual 214	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   276: aload 7
    //   278: invokevirtual 211	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   281: aload 7
    //   283: ifnull -266 -> 17
    //   286: aload 7
    //   288: invokevirtual 142	android/database/sqlite/SQLiteDatabase:close	()V
    //   291: goto -274 -> 17
    //   294: astore 10
    //   296: aload 7
    //   298: invokevirtual 211	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   301: aload 7
    //   303: ifnull +8 -> 311
    //   306: aload 7
    //   308: invokevirtual 142	android/database/sqlite/SQLiteDatabase:close	()V
    //   311: aload 10
    //   313: athrow
    //   314: astore 25
    //   316: goto -172 -> 144
    //   319: astore 24
    //   321: goto -172 -> 149
    //   324: astore 20
    //   326: goto -121 -> 205
    //   329: astore 23
    //   331: goto -103 -> 228
    //   334: astore 22
    //   336: goto -103 -> 233
    //   339: astore 21
    //   341: aload 14
    //   343: astore_3
    //   344: goto -124 -> 220
    //   347: astore 15
    //   349: aload 14
    //   351: astore 16
    //   353: goto -158 -> 195
    //
    // Exception table:
    //   from	to	target	type
    //   116	127	190	java/io/IOException
    //   205	210	213	java/io/IOException
    //   116	127	218	finally
    //   59	68	236	java/lang/Exception
    //   78	91	236	java/lang/Exception
    //   96	116	236	java/lang/Exception
    //   139	144	236	java/lang/Exception
    //   144	149	236	java/lang/Exception
    //   149	172	236	java/lang/Exception
    //   172	177	236	java/lang/Exception
    //   200	205	236	java/lang/Exception
    //   205	210	236	java/lang/Exception
    //   224	228	236	java/lang/Exception
    //   228	233	236	java/lang/Exception
    //   233	236	236	java/lang/Exception
    //   271	276	236	java/lang/Exception
    //   4	12	264	finally
    //   31	49	264	finally
    //   54	59	264	finally
    //   246	251	264	finally
    //   256	261	264	finally
    //   276	281	264	finally
    //   286	291	264	finally
    //   296	301	264	finally
    //   306	311	264	finally
    //   311	314	264	finally
    //   59	68	294	finally
    //   78	91	294	finally
    //   96	116	294	finally
    //   139	144	294	finally
    //   144	149	294	finally
    //   149	172	294	finally
    //   172	177	294	finally
    //   200	205	294	finally
    //   205	210	294	finally
    //   224	228	294	finally
    //   228	233	294	finally
    //   233	236	294	finally
    //   238	246	294	finally
    //   271	276	294	finally
    //   139	144	314	java/io/IOException
    //   144	149	319	java/io/IOException
    //   200	205	324	java/io/IOException
    //   224	228	329	java/io/IOException
    //   228	233	334	java/io/IOException
    //   127	134	339	finally
    //   127	134	347	java/io/IOException
  }

  // ERROR //
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 161	com/tencent/open/b/f:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull -11 -> 11
    //   25: aload 4
    //   27: ldc 83
    //   29: ldc 85
    //   31: iconst_1
    //   32: anewarray 36	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_1
    //   38: aastore
    //   39: invokevirtual 218	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   42: pop
    //   43: aload 4
    //   45: ifnull -34 -> 11
    //   48: aload 4
    //   50: invokevirtual 142	android/database/sqlite/SQLiteDatabase:close	()V
    //   53: goto -42 -> 11
    //   56: astore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: astore 6
    //   63: getstatic 34	com/tencent/open/b/f:a	Ljava/lang/String;
    //   66: ldc 220
    //   68: invokestatic 148	com/tencent/open/a/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload 4
    //   73: ifnull -62 -> 11
    //   76: aload 4
    //   78: invokevirtual 142	android/database/sqlite/SQLiteDatabase:close	()V
    //   81: goto -70 -> 11
    //   84: astore 5
    //   86: aload 4
    //   88: ifnull +8 -> 96
    //   91: aload 4
    //   93: invokevirtual 142	android/database/sqlite/SQLiteDatabase:close	()V
    //   96: aload 5
    //   98: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	56	finally
    //   14	20	56	finally
    //   48	53	56	finally
    //   76	81	56	finally
    //   91	96	56	finally
    //   96	99	56	finally
    //   25	43	61	java/lang/Exception
    //   25	43	84	finally
    //   63	71	84	finally
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b.f
 * JD-Core Version:    0.6.0
 */