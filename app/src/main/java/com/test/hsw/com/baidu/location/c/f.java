package com.baidu.location.c;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.b.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

final class f
  implements b
{
  static final int a0 = 30;
  static final int a1 = 6;
  private static final double a2 = 90.0D;
  private static final double a3 = 180.0D;
  private static final double a5 = -90.0D;
  private static final double a6 = -180.0D;
  static final String aV = "rgc";
  private static final double[] aY = { 45.0D, 135.0D, 225.0D, 315.0D };
  private static final String aZ = "0123456789bcdefghjkmnpqrstuvwxyz";
  private final int a4;
  private final SQLiteDatabase a7;
  private int aU;
  private final d aW;
  private int aX;

  f(d paramd, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.aW = paramd;
    this.aX = -1;
    this.aU = -1;
    this.a7 = paramSQLiteDatabase;
    this.a4 = paramInt;
    if ((this.a7 != null) && (this.a7.isOpen()))
    {
      this.a7.execSQL("CREATE TABLE IF NOT EXISTS RGCAREA(gridkey VARCHAR(10) PRIMARY KEY, country VARCHAR(100),countrycode VARCHAR(100), province VARCHAR(100), city VARCHAR(100), citycode VARCHAR(100), district VARCHAR(100), timestamp INTEGER, version VARCHAR(50))");
      this.a7.execSQL("CREATE TABLE IF NOT EXISTS RGCROAD(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE)");
      this.a7.execSQL("CREATE TABLE IF NOT EXISTS RGCSITE(_id INTEGER PRIMARY KEY AUTOINCREMENT, gridkey VARCHAR(10), street VARCHAR(100), streetnumber VARCHAR(100), x DOUBLE, y DOUBLE)");
      this.a7.execSQL("CREATE TABLE IF NOT EXISTS RGCPOI(pid VARCHAR(50) PRIMARY KEY , gridkey VARCHAR(10), name VARCHAR(100), type VARCHAR(50), x DOUBLE, y DOUBLE, rank INTEGER)");
      this.a7.execSQL("CREATE TABLE IF NOT EXISTS RGCUPDATE(gridkey VARCHAR(10), version VARCHAR(50), type INTEGER, timestamp INTEGER, PRIMARY KEY(gridkey, type))");
    }
  }

  private static double[] jdMethod_for(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double[] arrayOfDouble = new double[2];
    double d1 = Math.toRadians(paramDouble1);
    double d2 = Math.toRadians(paramDouble2);
    double d3 = Math.toRadians(paramDouble4);
    double d4 = Math.asin(Math.sin(d1) * Math.cos(paramDouble3 / 6378137.0D) + Math.cos(d1) * Math.sin(paramDouble3 / 6378137.0D) * Math.cos(d3));
    double d5 = d2 + Math.atan2(Math.sin(d3) * Math.sin(paramDouble3 / 6378137.0D) * Math.cos(d1), Math.cos(paramDouble3 / 6378137.0D) - Math.sin(d1) * Math.sin(d4));
    arrayOfDouble[0] = Math.toDegrees(d4);
    arrayOfDouble[1] = Math.toDegrees(d5);
    return arrayOfDouble;
  }

  private double jdMethod_if(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    double d1 = (paramDouble5 - paramDouble3) * (paramDouble1 - paramDouble3) + (paramDouble6 - paramDouble4) * (paramDouble2 - paramDouble4);
    if (d1 <= 0.0D)
      return Math.sqrt((paramDouble1 - paramDouble3) * (paramDouble1 - paramDouble3) + (paramDouble2 - paramDouble4) * (paramDouble2 - paramDouble4));
    double d2 = (paramDouble5 - paramDouble3) * (paramDouble5 - paramDouble3) + (paramDouble6 - paramDouble4) * (paramDouble6 - paramDouble4);
    if (d1 >= d2)
      return Math.sqrt((paramDouble1 - paramDouble5) * (paramDouble1 - paramDouble5) + (paramDouble2 - paramDouble6) * (paramDouble2 - paramDouble6));
    double d3 = d1 / d2;
    double d4 = paramDouble3 + d3 * (paramDouble5 - paramDouble3);
    double d5 = paramDouble4 + d3 * (paramDouble6 - paramDouble4);
    return Math.sqrt((paramDouble1 - d4) * (paramDouble1 - d4) + (d5 - paramDouble2) * (d5 - paramDouble2));
  }

  private static int jdMethod_if(int paramInt1, int paramInt2)
  {
    double d;
    int i;
    if (100 > paramInt2)
    {
      d = -0.1D;
      i = 60000;
    }
    while (true)
    {
      return paramInt1 + (int)(d * paramInt2 + i);
      if (500 > paramInt2)
      {
        d = -0.75D;
        i = 55500;
        continue;
      }
      d = -0.5D;
      i = 0;
    }
  }

  private static String jdMethod_if(int paramInt, double paramDouble1, double paramDouble2)
  {
    int i = paramInt * 5;
    char[] arrayOfChar = new char[paramInt + 1];
    a locala1 = new a(90.0D, -90.0D, null);
    a locala2 = new a(180.0D, -180.0D, null);
    int j = 1;
    int k = 1;
    int m = 0;
    a locala3;
    double d1;
    label72: double d2;
    int i1;
    int i2;
    if (j <= i)
      if (k != 0)
      {
        locala3 = locala2;
        d1 = paramDouble1;
        d2 = (a.jdMethod_if(locala3) + a.a(locala3)) / 2.0D;
        i1 = m << 1;
        if ((int)(d1 * 1000000.0D) <= (int)(1000000.0D * d2))
          break label184;
        a.jdMethod_if(locala3, d2);
        i2 = i1 | 0x1;
        label126: if (j % 5 != 0)
          break label251;
        arrayOfChar[(-1 + j / 5)] = "0123456789bcdefghjkmnpqrstuvwxyz".charAt(i2);
      }
    label184: label251: for (int i3 = 0; ; i3 = i2)
    {
      if (k == 0);
      for (int i4 = 1; ; i4 = 0)
      {
        j++;
        k = i4;
        m = i3;
        break;
        locala3 = locala1;
        d1 = paramDouble2;
        break label72;
        a.a(locala3, d2);
        i2 = i1;
        break label126;
      }
      arrayOfChar[paramInt] = '\000';
      StringBuffer localStringBuffer = new StringBuffer();
      for (int n = 0; n < paramInt; n++)
        localStringBuffer.append(arrayOfChar[n]);
      return localStringBuffer.toString();
    }
  }

  private double jdMethod_int(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d1 = paramDouble4 - paramDouble2;
    double d2 = paramDouble3 - paramDouble1;
    double d3 = Math.toRadians(paramDouble1);
    Math.toRadians(paramDouble2);
    double d4 = Math.toRadians(paramDouble3);
    Math.toRadians(paramDouble4);
    double d5 = Math.toRadians(d1);
    double d6 = Math.toRadians(d2);
    double d7 = Math.sin(d6 / 2.0D) * Math.sin(d6 / 2.0D) + Math.cos(d3) * Math.cos(d4) * Math.sin(d5 / 2.0D) * Math.sin(d5 / 2.0D);
    return 6378137.0D * (2.0D * Math.atan2(Math.sqrt(d7), Math.sqrt(1.0D - d7)));
  }

  // ERROR //
  boolean F()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 58	com/baidu/location/c/f:aW	Lcom/baidu/location/c/d;
    //   6: invokevirtual 182	com/baidu/location/c/d:new	()Lcom/baidu/location/c/e;
    //   9: invokevirtual 187	com/baidu/location/c/e:B	()Z
    //   12: ifeq +123 -> 135
    //   15: aload_0
    //   16: getfield 62	com/baidu/location/c/f:aU	I
    //   19: iconst_m1
    //   20: if_icmpne +115 -> 135
    //   23: aload_0
    //   24: getfield 60	com/baidu/location/c/f:aX	I
    //   27: iconst_m1
    //   28: if_icmpne +107 -> 135
    //   31: aload_0
    //   32: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   35: ifnull +100 -> 135
    //   38: aload_0
    //   39: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   42: invokevirtual 72	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   45: ifeq +90 -> 135
    //   48: aload_0
    //   49: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   52: ldc 189
    //   54: aconst_null
    //   55: invokevirtual 193	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 12
    //   60: aload 12
    //   62: astore 6
    //   64: aload 6
    //   66: invokeinterface 198 1 0
    //   71: pop
    //   72: aload_0
    //   73: aload 6
    //   75: iconst_0
    //   76: invokeinterface 202 2 0
    //   81: putfield 62	com/baidu/location/c/f:aU	I
    //   84: aload_0
    //   85: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   88: ldc 204
    //   90: aconst_null
    //   91: invokevirtual 193	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   94: astore_1
    //   95: aload_1
    //   96: invokeinterface 198 1 0
    //   101: pop
    //   102: aload_0
    //   103: aload_1
    //   104: iconst_0
    //   105: invokeinterface 202 2 0
    //   110: putfield 60	com/baidu/location/c/f:aX	I
    //   113: aload 6
    //   115: ifnull +10 -> 125
    //   118: aload 6
    //   120: invokeinterface 207 1 0
    //   125: aload_1
    //   126: ifnull +9 -> 135
    //   129: aload_1
    //   130: invokeinterface 207 1 0
    //   135: aload_0
    //   136: getfield 62	com/baidu/location/c/f:aU	I
    //   139: istore_2
    //   140: iconst_0
    //   141: istore_3
    //   142: iload_2
    //   143: ifne +18 -> 161
    //   146: aload_0
    //   147: getfield 60	com/baidu/location/c/f:aX	I
    //   150: istore 4
    //   152: iconst_0
    //   153: istore_3
    //   154: iload 4
    //   156: ifne +5 -> 161
    //   159: iconst_1
    //   160: istore_3
    //   161: iload_3
    //   162: ireturn
    //   163: astore 9
    //   165: aconst_null
    //   166: astore 6
    //   168: aload 6
    //   170: ifnull +10 -> 180
    //   173: aload 6
    //   175: invokeinterface 207 1 0
    //   180: aload_1
    //   181: ifnull -46 -> 135
    //   184: aload_1
    //   185: invokeinterface 207 1 0
    //   190: goto -55 -> 135
    //   193: astore 10
    //   195: goto -60 -> 135
    //   198: astore 5
    //   200: aconst_null
    //   201: astore 6
    //   203: aload 6
    //   205: ifnull +10 -> 215
    //   208: aload 6
    //   210: invokeinterface 207 1 0
    //   215: aload_1
    //   216: ifnull +9 -> 225
    //   219: aload_1
    //   220: invokeinterface 207 1 0
    //   225: aload 5
    //   227: athrow
    //   228: astore 17
    //   230: goto -105 -> 125
    //   233: astore 16
    //   235: goto -100 -> 135
    //   238: astore 11
    //   240: goto -60 -> 180
    //   243: astore 8
    //   245: goto -30 -> 215
    //   248: astore 7
    //   250: goto -25 -> 225
    //   253: astore 5
    //   255: goto -52 -> 203
    //   258: astore 13
    //   260: goto -92 -> 168
    //
    // Exception table:
    //   from	to	target	type
    //   48	60	163	java/lang/Exception
    //   184	190	193	java/lang/Exception
    //   48	60	198	finally
    //   118	125	228	java/lang/Exception
    //   129	135	233	java/lang/Exception
    //   173	180	238	java/lang/Exception
    //   208	215	243	java/lang/Exception
    //   219	225	248	java/lang/Exception
    //   64	113	253	finally
    //   64	113	258	java/lang/Exception
  }

  // ERROR //
  JSONObject H()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new 211	org/json/JSONObject
    //   7: dup
    //   8: invokespecial 212	org/json/JSONObject:<init>	()V
    //   11: astore_3
    //   12: new 162	java/lang/StringBuffer
    //   15: dup
    //   16: invokespecial 163	java/lang/StringBuffer:<init>	()V
    //   19: astore 4
    //   21: new 162	java/lang/StringBuffer
    //   24: dup
    //   25: invokespecial 163	java/lang/StringBuffer:<init>	()V
    //   28: astore 5
    //   30: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   33: ldc2_w 219
    //   36: ldiv
    //   37: l2i
    //   38: istore 6
    //   40: aload_0
    //   41: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   44: astore 13
    //   46: aconst_null
    //   47: astore_2
    //   48: aconst_null
    //   49: astore_1
    //   50: aload 13
    //   52: ifnull +654 -> 706
    //   55: aload_0
    //   56: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   59: invokevirtual 72	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   62: istore 14
    //   64: aconst_null
    //   65: astore_2
    //   66: aconst_null
    //   67: astore_1
    //   68: iload 14
    //   70: ifeq +636 -> 706
    //   73: new 222	org/json/JSONArray
    //   76: dup
    //   77: invokespecial 223	org/json/JSONArray:<init>	()V
    //   80: astore 15
    //   82: new 222	org/json/JSONArray
    //   85: dup
    //   86: invokespecial 223	org/json/JSONArray:<init>	()V
    //   89: astore 16
    //   91: new 222	org/json/JSONArray
    //   94: dup
    //   95: invokespecial 223	org/json/JSONArray:<init>	()V
    //   98: astore 17
    //   100: new 222	org/json/JSONArray
    //   103: dup
    //   104: invokespecial 223	org/json/JSONArray:<init>	()V
    //   107: astore 18
    //   109: aload_0
    //   110: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   113: astore 19
    //   115: iconst_3
    //   116: anewarray 4	java/lang/Object
    //   119: astore 20
    //   121: aload 20
    //   123: iconst_0
    //   124: iconst_0
    //   125: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: aload 20
    //   131: iconst_1
    //   132: iload 6
    //   134: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: aload 20
    //   140: iconst_2
    //   141: aload_0
    //   142: getfield 58	com/baidu/location/c/f:aW	Lcom/baidu/location/c/d;
    //   145: invokevirtual 182	com/baidu/location/c/d:new	()Lcom/baidu/location/c/e;
    //   148: invokevirtual 233	com/baidu/location/c/e:u	()I
    //   151: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: aastore
    //   155: aload 19
    //   157: ldc 235
    //   159: aload 20
    //   161: invokestatic 239	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   164: aconst_null
    //   165: invokevirtual 193	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   168: astore_2
    //   169: aload_0
    //   170: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   173: astore 21
    //   175: iconst_3
    //   176: anewarray 4	java/lang/Object
    //   179: astore 22
    //   181: aload 22
    //   183: iconst_0
    //   184: iconst_1
    //   185: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: aastore
    //   189: aload 22
    //   191: iconst_1
    //   192: iload 6
    //   194: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: aload 22
    //   200: iconst_2
    //   201: aload_0
    //   202: getfield 58	com/baidu/location/c/f:aW	Lcom/baidu/location/c/d;
    //   205: invokevirtual 182	com/baidu/location/c/d:new	()Lcom/baidu/location/c/e;
    //   208: invokevirtual 241	com/baidu/location/c/e:D	()I
    //   211: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: aastore
    //   215: aload 21
    //   217: ldc 235
    //   219: aload 22
    //   221: invokestatic 239	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   224: aconst_null
    //   225: invokevirtual 193	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   228: astore_1
    //   229: aload_2
    //   230: invokeinterface 198 1 0
    //   235: ifeq +194 -> 429
    //   238: new 243	java/util/HashSet
    //   241: dup
    //   242: invokespecial 244	java/util/HashSet:<init>	()V
    //   245: astore 23
    //   247: aload_2
    //   248: invokeinterface 247 1 0
    //   253: ifne +130 -> 383
    //   256: aload_2
    //   257: iconst_0
    //   258: invokeinterface 251 2 0
    //   263: astore 56
    //   265: aload_2
    //   266: iconst_1
    //   267: invokeinterface 251 2 0
    //   272: astore 57
    //   274: aload 17
    //   276: aload 56
    //   278: invokevirtual 255	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   281: pop
    //   282: aload 23
    //   284: aload 57
    //   286: invokevirtual 259	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   289: pop
    //   290: aload 5
    //   292: invokevirtual 262	java/lang/StringBuffer:length	()I
    //   295: ifle +12 -> 307
    //   298: aload 5
    //   300: ldc_w 264
    //   303: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   306: pop
    //   307: aload 5
    //   309: ldc_w 269
    //   312: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   315: aload 56
    //   317: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   320: ldc_w 269
    //   323: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   326: pop
    //   327: aload_2
    //   328: invokeinterface 272 1 0
    //   333: pop
    //   334: goto -87 -> 247
    //   337: astore 10
    //   339: aload_2
    //   340: ifnull +9 -> 349
    //   343: aload_2
    //   344: invokeinterface 207 1 0
    //   349: aload_1
    //   350: ifnull +9 -> 359
    //   353: aload_1
    //   354: invokeinterface 207 1 0
    //   359: aload_3
    //   360: ldc_w 274
    //   363: invokevirtual 278	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   366: ifne +15 -> 381
    //   369: aload_3
    //   370: ldc_w 280
    //   373: invokevirtual 278	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   376: ifne +5 -> 381
    //   379: aconst_null
    //   380: astore_3
    //   381: aload_3
    //   382: areturn
    //   383: aload 23
    //   385: invokevirtual 283	java/util/HashSet:size	()I
    //   388: anewarray 154	java/lang/String
    //   391: astore 24
    //   393: aload 23
    //   395: aload 24
    //   397: invokevirtual 287	java/util/HashSet:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   400: pop
    //   401: iconst_0
    //   402: istore 26
    //   404: iload 26
    //   406: aload 24
    //   408: arraylength
    //   409: if_icmpge +20 -> 429
    //   412: aload 18
    //   414: aload 24
    //   416: iload 26
    //   418: aaload
    //   419: invokevirtual 255	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   422: pop
    //   423: iinc 26 1
    //   426: goto -22 -> 404
    //   429: aload_1
    //   430: invokeinterface 198 1 0
    //   435: ifeq +173 -> 608
    //   438: new 243	java/util/HashSet
    //   441: dup
    //   442: invokespecial 244	java/util/HashSet:<init>	()V
    //   445: astore 27
    //   447: aload_1
    //   448: invokeinterface 247 1 0
    //   453: ifne +109 -> 562
    //   456: aload_1
    //   457: iconst_0
    //   458: invokeinterface 251 2 0
    //   463: astore 48
    //   465: aload_1
    //   466: iconst_1
    //   467: invokeinterface 251 2 0
    //   472: astore 49
    //   474: aload 15
    //   476: aload 48
    //   478: invokevirtual 255	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   481: pop
    //   482: aload 27
    //   484: aload 49
    //   486: invokevirtual 259	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   489: pop
    //   490: aload 4
    //   492: invokevirtual 262	java/lang/StringBuffer:length	()I
    //   495: ifle +12 -> 507
    //   498: aload 4
    //   500: ldc_w 264
    //   503: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   506: pop
    //   507: aload 4
    //   509: ldc_w 269
    //   512: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   515: aload 48
    //   517: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   520: ldc_w 269
    //   523: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   526: pop
    //   527: aload_1
    //   528: invokeinterface 272 1 0
    //   533: pop
    //   534: goto -87 -> 447
    //   537: astore 7
    //   539: aload_2
    //   540: ifnull +9 -> 549
    //   543: aload_2
    //   544: invokeinterface 207 1 0
    //   549: aload_1
    //   550: ifnull +9 -> 559
    //   553: aload_1
    //   554: invokeinterface 207 1 0
    //   559: aload 7
    //   561: athrow
    //   562: aload 27
    //   564: invokevirtual 283	java/util/HashSet:size	()I
    //   567: anewarray 154	java/lang/String
    //   570: astore 28
    //   572: aload 27
    //   574: aload 28
    //   576: invokevirtual 287	java/util/HashSet:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   579: pop
    //   580: iconst_0
    //   581: istore 30
    //   583: iload 30
    //   585: aload 28
    //   587: arraylength
    //   588: if_icmpge +20 -> 608
    //   591: aload 16
    //   593: aload 28
    //   595: iload 30
    //   597: aaload
    //   598: invokevirtual 255	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   601: pop
    //   602: iinc 30 1
    //   605: goto -22 -> 583
    //   608: aload 17
    //   610: invokevirtual 288	org/json/JSONArray:length	()I
    //   613: ifeq +44 -> 657
    //   616: new 211	org/json/JSONObject
    //   619: dup
    //   620: invokespecial 212	org/json/JSONObject:<init>	()V
    //   623: astore 31
    //   625: aload 31
    //   627: ldc_w 290
    //   630: aload 17
    //   632: invokevirtual 293	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   635: pop
    //   636: aload 31
    //   638: ldc_w 295
    //   641: aload 18
    //   643: invokevirtual 293	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   646: pop
    //   647: aload_3
    //   648: ldc_w 280
    //   651: aload 31
    //   653: invokevirtual 293	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   656: pop
    //   657: aload 15
    //   659: invokevirtual 288	org/json/JSONArray:length	()I
    //   662: ifeq +44 -> 706
    //   665: new 211	org/json/JSONObject
    //   668: dup
    //   669: invokespecial 212	org/json/JSONObject:<init>	()V
    //   672: astore 35
    //   674: aload 35
    //   676: ldc_w 290
    //   679: aload 15
    //   681: invokevirtual 293	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   684: pop
    //   685: aload 35
    //   687: ldc_w 295
    //   690: aload 16
    //   692: invokevirtual 293	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   695: pop
    //   696: aload_3
    //   697: ldc_w 274
    //   700: aload 35
    //   702: invokevirtual 293	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   705: pop
    //   706: aload 5
    //   708: invokevirtual 262	java/lang/StringBuffer:length	()I
    //   711: ifle +52 -> 763
    //   714: getstatic 301	java/util/Locale:US	Ljava/util/Locale;
    //   717: astore 44
    //   719: iconst_2
    //   720: anewarray 4	java/lang/Object
    //   723: astore 45
    //   725: aload 45
    //   727: iconst_0
    //   728: iconst_0
    //   729: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   732: aastore
    //   733: aload 45
    //   735: iconst_1
    //   736: aload 5
    //   738: invokevirtual 171	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   741: aastore
    //   742: aload 44
    //   744: ldc_w 303
    //   747: aload 45
    //   749: invokestatic 306	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   752: astore 46
    //   754: aload_0
    //   755: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   758: aload 46
    //   760: invokevirtual 78	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   763: aload 4
    //   765: invokevirtual 262	java/lang/StringBuffer:length	()I
    //   768: ifle +52 -> 820
    //   771: getstatic 301	java/util/Locale:US	Ljava/util/Locale;
    //   774: astore 41
    //   776: iconst_2
    //   777: anewarray 4	java/lang/Object
    //   780: astore 42
    //   782: aload 42
    //   784: iconst_0
    //   785: iconst_1
    //   786: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   789: aastore
    //   790: aload 42
    //   792: iconst_1
    //   793: aload 4
    //   795: invokevirtual 171	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   798: aastore
    //   799: aload 41
    //   801: ldc_w 303
    //   804: aload 42
    //   806: invokestatic 306	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   809: astore 43
    //   811: aload_0
    //   812: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   815: aload 43
    //   817: invokevirtual 78	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   820: aload_2
    //   821: ifnull +9 -> 830
    //   824: aload_2
    //   825: invokeinterface 207 1 0
    //   830: aload_1
    //   831: ifnull -472 -> 359
    //   834: aload_1
    //   835: invokeinterface 207 1 0
    //   840: goto -481 -> 359
    //   843: astore 39
    //   845: goto -486 -> 359
    //   848: astore 40
    //   850: goto -20 -> 830
    //   853: astore 12
    //   855: goto -506 -> 349
    //   858: astore 11
    //   860: goto -501 -> 359
    //   863: astore 9
    //   865: goto -316 -> 549
    //   868: astore 8
    //   870: goto -311 -> 559
    //
    // Exception table:
    //   from	to	target	type
    //   40	46	337	java/lang/Exception
    //   55	64	337	java/lang/Exception
    //   73	247	337	java/lang/Exception
    //   247	307	337	java/lang/Exception
    //   307	334	337	java/lang/Exception
    //   383	401	337	java/lang/Exception
    //   404	423	337	java/lang/Exception
    //   429	447	337	java/lang/Exception
    //   447	507	337	java/lang/Exception
    //   507	534	337	java/lang/Exception
    //   562	580	337	java/lang/Exception
    //   583	602	337	java/lang/Exception
    //   608	657	337	java/lang/Exception
    //   657	706	337	java/lang/Exception
    //   706	763	337	java/lang/Exception
    //   763	820	337	java/lang/Exception
    //   40	46	537	finally
    //   55	64	537	finally
    //   73	247	537	finally
    //   247	307	537	finally
    //   307	334	537	finally
    //   383	401	537	finally
    //   404	423	537	finally
    //   429	447	537	finally
    //   447	507	537	finally
    //   507	534	537	finally
    //   562	580	537	finally
    //   583	602	537	finally
    //   608	657	537	finally
    //   657	706	537	finally
    //   706	763	537	finally
    //   763	820	537	finally
    //   834	840	843	java/lang/Exception
    //   824	830	848	java/lang/Exception
    //   343	349	853	java/lang/Exception
    //   353	359	858	java/lang/Exception
    //   543	549	863	java/lang/Exception
    //   553	559	868	java/lang/Exception
  }

  // ERROR //
  com.baidu.location.Address jdMethod_do(double paramDouble1, double paramDouble2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: getstatic 313	com/baidu/location/c/f$b:goto	Lcom/baidu/location/c/f$b;
    //   6: aload_0
    //   7: getfield 66	com/baidu/location/c/f:a4	I
    //   10: dload_1
    //   11: dload_3
    //   12: invokestatic 316	com/baidu/location/c/f$b:a	(Lcom/baidu/location/c/f$b;IDD)Ljava/lang/String;
    //   15: astore 73
    //   17: aload_0
    //   18: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   21: aload 73
    //   23: aconst_null
    //   24: invokevirtual 193	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 74
    //   29: aload 74
    //   31: astore 9
    //   33: aload 9
    //   35: invokeinterface 198 1 0
    //   40: istore 77
    //   42: iload 77
    //   44: ifeq +1342 -> 1386
    //   47: ldc2_w 317
    //   50: dstore 79
    //   52: aconst_null
    //   53: astore 81
    //   55: aconst_null
    //   56: astore 82
    //   58: aload 9
    //   60: invokeinterface 247 1 0
    //   65: ifne +103 -> 168
    //   68: aload 9
    //   70: iconst_2
    //   71: invokeinterface 251 2 0
    //   76: astore 84
    //   78: aload 9
    //   80: iconst_3
    //   81: invokeinterface 251 2 0
    //   86: astore 85
    //   88: aload_0
    //   89: dload_3
    //   90: dload_1
    //   91: aload 9
    //   93: iconst_5
    //   94: invokeinterface 322 2 0
    //   99: aload 9
    //   101: iconst_4
    //   102: invokeinterface 322 2 0
    //   107: invokespecial 324	com/baidu/location/c/f:int	(DDDD)D
    //   110: dstore 86
    //   112: dload 86
    //   114: dload 79
    //   116: dcmpg
    //   117: ifge +1254 -> 1371
    //   120: getstatic 313	com/baidu/location/c/f$b:goto	Lcom/baidu/location/c/f$b;
    //   123: invokestatic 327	com/baidu/location/c/f$b:a	(Lcom/baidu/location/c/f$b;)I
    //   126: istore 88
    //   128: dload 86
    //   130: iload 88
    //   132: i2d
    //   133: dcmpg
    //   134: ifgt +1237 -> 1371
    //   137: aload 85
    //   139: astore 10
    //   141: aload 84
    //   143: astore 11
    //   145: aload 9
    //   147: invokeinterface 272 1 0
    //   152: pop
    //   153: dload 86
    //   155: dstore 79
    //   157: aload 10
    //   159: astore 81
    //   161: aload 11
    //   163: astore 82
    //   165: goto -107 -> 58
    //   168: aload 81
    //   170: astore 10
    //   172: aload 82
    //   174: astore 11
    //   176: aload 9
    //   178: ifnull +1182 -> 1360
    //   181: aload 9
    //   183: invokeinterface 207 1 0
    //   188: aload 10
    //   190: astore 12
    //   192: aload 11
    //   194: astore 13
    //   196: aload 12
    //   198: ifnonnull +310 -> 508
    //   201: getstatic 329	com/baidu/location/c/f$b:do	Lcom/baidu/location/c/f$b;
    //   204: aload_0
    //   205: getfield 66	com/baidu/location/c/f:a4	I
    //   208: dload_1
    //   209: dload_3
    //   210: invokestatic 316	com/baidu/location/c/f$b:a	(Lcom/baidu/location/c/f$b;IDD)Ljava/lang/String;
    //   213: astore 55
    //   215: aload_0
    //   216: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   219: aload 55
    //   221: aconst_null
    //   222: invokevirtual 193	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   225: astore 56
    //   227: aload 56
    //   229: astore 49
    //   231: aload 49
    //   233: invokeinterface 198 1 0
    //   238: ifeq +250 -> 488
    //   241: ldc2_w 317
    //   244: dstore 58
    //   246: dload_1
    //   247: dload_3
    //   248: ldc_w 331
    //   251: invokestatic 336	com/baidu/location/Jni:if	(DDLjava/lang/String;)[D
    //   254: astore 60
    //   256: aload 13
    //   258: astore 53
    //   260: aload 49
    //   262: invokeinterface 247 1 0
    //   267: ifne +225 -> 492
    //   270: aload 49
    //   272: iconst_2
    //   273: invokeinterface 251 2 0
    //   278: astore 63
    //   280: aload 49
    //   282: iconst_3
    //   283: invokeinterface 322 2 0
    //   288: aload 49
    //   290: iconst_4
    //   291: invokeinterface 322 2 0
    //   296: ldc_w 331
    //   299: invokestatic 336	com/baidu/location/Jni:if	(DDLjava/lang/String;)[D
    //   302: astore 64
    //   304: aload 49
    //   306: iconst_5
    //   307: invokeinterface 322 2 0
    //   312: aload 49
    //   314: bipush 6
    //   316: invokeinterface 322 2 0
    //   321: ldc_w 331
    //   324: invokestatic 336	com/baidu/location/Jni:if	(DDLjava/lang/String;)[D
    //   327: astore 65
    //   329: aload_0
    //   330: aload 60
    //   332: iconst_0
    //   333: daload
    //   334: aload 60
    //   336: iconst_1
    //   337: daload
    //   338: aload 64
    //   340: iconst_0
    //   341: daload
    //   342: aload 64
    //   344: iconst_1
    //   345: daload
    //   346: aload 65
    //   348: iconst_0
    //   349: daload
    //   350: aload 65
    //   352: iconst_1
    //   353: daload
    //   354: invokespecial 338	com/baidu/location/c/f:if	(DDDDDD)D
    //   357: dstore 66
    //   359: dload 66
    //   361: dload 58
    //   363: dcmpg
    //   364: ifge +985 -> 1349
    //   367: getstatic 329	com/baidu/location/c/f$b:do	Lcom/baidu/location/c/f$b;
    //   370: invokestatic 327	com/baidu/location/c/f$b:a	(Lcom/baidu/location/c/f$b;)I
    //   373: istore 68
    //   375: dload 66
    //   377: iload 68
    //   379: i2d
    //   380: dcmpg
    //   381: ifgt +968 -> 1349
    //   384: dload 66
    //   386: dstore 69
    //   388: aload 63
    //   390: astore 13
    //   392: aload 49
    //   394: invokeinterface 272 1 0
    //   399: pop
    //   400: dload 69
    //   402: dstore 58
    //   404: aload 13
    //   406: astore 53
    //   408: goto -148 -> 260
    //   411: astore 78
    //   413: aload 10
    //   415: astore 12
    //   417: aload 11
    //   419: astore 13
    //   421: goto -225 -> 196
    //   424: astore 8
    //   426: aconst_null
    //   427: astore 9
    //   429: aconst_null
    //   430: astore 10
    //   432: aconst_null
    //   433: astore 11
    //   435: aload 9
    //   437: ifnull +923 -> 1360
    //   440: aload 9
    //   442: invokeinterface 207 1 0
    //   447: aload 10
    //   449: astore 12
    //   451: aload 11
    //   453: astore 13
    //   455: goto -259 -> 196
    //   458: astore 72
    //   460: aload 10
    //   462: astore 12
    //   464: aload 11
    //   466: astore 13
    //   468: goto -272 -> 196
    //   471: astore 6
    //   473: aload 5
    //   475: ifnull +10 -> 485
    //   478: aload 5
    //   480: invokeinterface 207 1 0
    //   485: aload 6
    //   487: athrow
    //   488: aload 13
    //   490: astore 53
    //   492: aload 49
    //   494: ifnull +848 -> 1342
    //   497: aload 49
    //   499: invokeinterface 207 1 0
    //   504: aload 53
    //   506: astore 13
    //   508: getstatic 340	com/baidu/location/c/f$b:a	Lcom/baidu/location/c/f$b;
    //   511: aload_0
    //   512: getfield 66	com/baidu/location/c/f:a4	I
    //   515: dload_1
    //   516: dload_3
    //   517: invokestatic 316	com/baidu/location/c/f$b:a	(Lcom/baidu/location/c/f$b;IDD)Ljava/lang/String;
    //   520: astore 14
    //   522: aconst_null
    //   523: astore 15
    //   525: aload_0
    //   526: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   529: aload 14
    //   531: aconst_null
    //   532: invokevirtual 193	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   535: astore 34
    //   537: aload 34
    //   539: astore 15
    //   541: aload 15
    //   543: invokeinterface 198 1 0
    //   548: ifeq +773 -> 1321
    //   551: aload 15
    //   553: invokeinterface 247 1 0
    //   558: ifne +763 -> 1321
    //   561: aload 15
    //   563: aload 15
    //   565: ldc_w 342
    //   568: invokeinterface 346 2 0
    //   573: invokeinterface 251 2 0
    //   578: astore 37
    //   580: aload 37
    //   582: astore 25
    //   584: aload 15
    //   586: aload 15
    //   588: ldc_w 348
    //   591: invokeinterface 346 2 0
    //   596: invokeinterface 251 2 0
    //   601: astore 39
    //   603: aload 39
    //   605: astore 24
    //   607: aload 15
    //   609: aload 15
    //   611: ldc_w 350
    //   614: invokeinterface 346 2 0
    //   619: invokeinterface 251 2 0
    //   624: astore 41
    //   626: aload 41
    //   628: astore 23
    //   630: aload 15
    //   632: aload 15
    //   634: ldc_w 352
    //   637: invokeinterface 346 2 0
    //   642: invokeinterface 251 2 0
    //   647: astore 43
    //   649: aload 43
    //   651: astore 22
    //   653: aload 15
    //   655: aload 15
    //   657: ldc_w 354
    //   660: invokeinterface 346 2 0
    //   665: invokeinterface 251 2 0
    //   670: astore 45
    //   672: aload 45
    //   674: astore 21
    //   676: aload 15
    //   678: aload 15
    //   680: ldc_w 356
    //   683: invokeinterface 346 2 0
    //   688: invokeinterface 251 2 0
    //   693: astore 47
    //   695: aload 25
    //   697: astore 26
    //   699: aload 24
    //   701: astore 27
    //   703: aload 23
    //   705: astore 28
    //   707: aload 22
    //   709: astore 29
    //   711: aload 21
    //   713: astore 30
    //   715: aload 47
    //   717: astore 31
    //   719: aload 15
    //   721: ifnull +10 -> 731
    //   724: aload 15
    //   726: invokeinterface 207 1 0
    //   731: aload 26
    //   733: ifnull +20 -> 753
    //   736: new 154	java/lang/String
    //   739: dup
    //   740: aload 26
    //   742: invokevirtual 360	java/lang/String:getBytes	()[B
    //   745: invokestatic 365	com/baidu/location/f/b/b:a	([B)[B
    //   748: invokespecial 368	java/lang/String:<init>	([B)V
    //   751: astore 26
    //   753: aload 27
    //   755: ifnull +20 -> 775
    //   758: new 154	java/lang/String
    //   761: dup
    //   762: aload 27
    //   764: invokevirtual 360	java/lang/String:getBytes	()[B
    //   767: invokestatic 365	com/baidu/location/f/b/b:a	([B)[B
    //   770: invokespecial 368	java/lang/String:<init>	([B)V
    //   773: astore 27
    //   775: aload 28
    //   777: ifnull +20 -> 797
    //   780: new 154	java/lang/String
    //   783: dup
    //   784: aload 28
    //   786: invokevirtual 360	java/lang/String:getBytes	()[B
    //   789: invokestatic 365	com/baidu/location/f/b/b:a	([B)[B
    //   792: invokespecial 368	java/lang/String:<init>	([B)V
    //   795: astore 28
    //   797: aload 29
    //   799: ifnull +20 -> 819
    //   802: new 154	java/lang/String
    //   805: dup
    //   806: aload 29
    //   808: invokevirtual 360	java/lang/String:getBytes	()[B
    //   811: invokestatic 365	com/baidu/location/f/b/b:a	([B)[B
    //   814: invokespecial 368	java/lang/String:<init>	([B)V
    //   817: astore 29
    //   819: aload 30
    //   821: ifnull +20 -> 841
    //   824: new 154	java/lang/String
    //   827: dup
    //   828: aload 30
    //   830: invokevirtual 360	java/lang/String:getBytes	()[B
    //   833: invokestatic 365	com/baidu/location/f/b/b:a	([B)[B
    //   836: invokespecial 368	java/lang/String:<init>	([B)V
    //   839: astore 30
    //   841: aload 31
    //   843: ifnull +20 -> 863
    //   846: new 154	java/lang/String
    //   849: dup
    //   850: aload 31
    //   852: invokevirtual 360	java/lang/String:getBytes	()[B
    //   855: invokestatic 365	com/baidu/location/f/b/b:a	([B)[B
    //   858: invokespecial 368	java/lang/String:<init>	([B)V
    //   861: astore 31
    //   863: aload 13
    //   865: ifnull +20 -> 885
    //   868: new 154	java/lang/String
    //   871: dup
    //   872: aload 13
    //   874: invokevirtual 360	java/lang/String:getBytes	()[B
    //   877: invokestatic 365	com/baidu/location/f/b/b:a	([B)[B
    //   880: invokespecial 368	java/lang/String:<init>	([B)V
    //   883: astore 13
    //   885: aload 12
    //   887: ifnull +401 -> 1288
    //   890: new 154	java/lang/String
    //   893: dup
    //   894: aload 12
    //   896: invokevirtual 360	java/lang/String:getBytes	()[B
    //   899: invokestatic 365	com/baidu/location/f/b/b:a	([B)[B
    //   902: invokespecial 368	java/lang/String:<init>	([B)V
    //   905: astore 32
    //   907: new 370	com/baidu/location/Address$Builder
    //   910: dup
    //   911: invokespecial 371	com/baidu/location/Address$Builder:<init>	()V
    //   914: aload 26
    //   916: invokevirtual 374	com/baidu/location/Address$Builder:country	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   919: aload 27
    //   921: invokevirtual 377	com/baidu/location/Address$Builder:countryCode	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   924: aload 28
    //   926: invokevirtual 379	com/baidu/location/Address$Builder:province	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   929: aload 29
    //   931: invokevirtual 381	com/baidu/location/Address$Builder:city	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   934: aload 30
    //   936: invokevirtual 384	com/baidu/location/Address$Builder:cityCode	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   939: aload 31
    //   941: invokevirtual 386	com/baidu/location/Address$Builder:district	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   944: aload 13
    //   946: invokevirtual 389	com/baidu/location/Address$Builder:street	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   949: aload 32
    //   951: invokevirtual 392	com/baidu/location/Address$Builder:streetNumber	(Ljava/lang/String;)Lcom/baidu/location/Address$Builder;
    //   954: invokevirtual 396	com/baidu/location/Address$Builder:build	()Lcom/baidu/location/Address;
    //   957: areturn
    //   958: astore 62
    //   960: aload 53
    //   962: astore 13
    //   964: goto -456 -> 508
    //   967: astore 51
    //   969: aconst_null
    //   970: astore 52
    //   972: aload 13
    //   974: astore 53
    //   976: aload 52
    //   978: ifnull +364 -> 1342
    //   981: aload 52
    //   983: invokeinterface 207 1 0
    //   988: aload 53
    //   990: astore 13
    //   992: goto -484 -> 508
    //   995: astore 54
    //   997: aload 53
    //   999: astore 13
    //   1001: goto -493 -> 508
    //   1004: astore 48
    //   1006: aconst_null
    //   1007: astore 49
    //   1009: aload 49
    //   1011: ifnull +10 -> 1021
    //   1014: aload 49
    //   1016: invokeinterface 207 1 0
    //   1021: aload 48
    //   1023: athrow
    //   1024: astore 20
    //   1026: aconst_null
    //   1027: astore 21
    //   1029: aconst_null
    //   1030: astore 22
    //   1032: aconst_null
    //   1033: astore 23
    //   1035: aconst_null
    //   1036: astore 24
    //   1038: aconst_null
    //   1039: astore 25
    //   1041: aload 15
    //   1043: ifnull +252 -> 1295
    //   1046: aload 15
    //   1048: invokeinterface 207 1 0
    //   1053: aload 25
    //   1055: astore 26
    //   1057: aload 24
    //   1059: astore 27
    //   1061: aload 23
    //   1063: astore 28
    //   1065: aload 22
    //   1067: astore 29
    //   1069: aload 21
    //   1071: astore 30
    //   1073: aconst_null
    //   1074: astore 31
    //   1076: goto -345 -> 731
    //   1079: astore 33
    //   1081: aload 25
    //   1083: astore 26
    //   1085: aload 24
    //   1087: astore 27
    //   1089: aload 23
    //   1091: astore 28
    //   1093: aload 22
    //   1095: astore 29
    //   1097: aload 21
    //   1099: astore 30
    //   1101: aconst_null
    //   1102: astore 31
    //   1104: goto -373 -> 731
    //   1107: astore 16
    //   1109: aconst_null
    //   1110: astore 17
    //   1112: aload 16
    //   1114: astore 18
    //   1116: aload 17
    //   1118: ifnull +10 -> 1128
    //   1121: aload 17
    //   1123: invokeinterface 207 1 0
    //   1128: aload 18
    //   1130: athrow
    //   1131: astore 7
    //   1133: goto -648 -> 485
    //   1136: astore 50
    //   1138: goto -117 -> 1021
    //   1141: astore 36
    //   1143: goto -412 -> 731
    //   1146: astore 19
    //   1148: goto -20 -> 1128
    //   1151: astore 35
    //   1153: aload 15
    //   1155: astore 17
    //   1157: aload 35
    //   1159: astore 18
    //   1161: goto -45 -> 1116
    //   1164: astore 38
    //   1166: aconst_null
    //   1167: astore 21
    //   1169: aconst_null
    //   1170: astore 22
    //   1172: aconst_null
    //   1173: astore 23
    //   1175: aconst_null
    //   1176: astore 24
    //   1178: goto -137 -> 1041
    //   1181: astore 40
    //   1183: aconst_null
    //   1184: astore 21
    //   1186: aconst_null
    //   1187: astore 22
    //   1189: aconst_null
    //   1190: astore 23
    //   1192: goto -151 -> 1041
    //   1195: astore 42
    //   1197: aconst_null
    //   1198: astore 21
    //   1200: aconst_null
    //   1201: astore 22
    //   1203: goto -162 -> 1041
    //   1206: astore 44
    //   1208: aconst_null
    //   1209: astore 21
    //   1211: goto -170 -> 1041
    //   1214: astore 46
    //   1216: goto -175 -> 1041
    //   1219: astore 48
    //   1221: goto -212 -> 1009
    //   1224: astore 57
    //   1226: aload 49
    //   1228: astore 52
    //   1230: aload 13
    //   1232: astore 53
    //   1234: goto -258 -> 976
    //   1237: astore 61
    //   1239: aload 49
    //   1241: astore 52
    //   1243: goto -267 -> 976
    //   1246: astore 76
    //   1248: aload 9
    //   1250: astore 5
    //   1252: aload 76
    //   1254: astore 6
    //   1256: goto -783 -> 473
    //   1259: astore 75
    //   1261: aconst_null
    //   1262: astore 10
    //   1264: aconst_null
    //   1265: astore 11
    //   1267: goto -832 -> 435
    //   1270: astore 89
    //   1272: goto -837 -> 435
    //   1275: astore 83
    //   1277: aload 81
    //   1279: astore 10
    //   1281: aload 82
    //   1283: astore 11
    //   1285: goto -850 -> 435
    //   1288: aload 12
    //   1290: astore 32
    //   1292: goto -385 -> 907
    //   1295: aload 25
    //   1297: astore 26
    //   1299: aload 24
    //   1301: astore 27
    //   1303: aload 23
    //   1305: astore 28
    //   1307: aload 22
    //   1309: astore 29
    //   1311: aload 21
    //   1313: astore 30
    //   1315: aconst_null
    //   1316: astore 31
    //   1318: goto -587 -> 731
    //   1321: aconst_null
    //   1322: astore 31
    //   1324: aconst_null
    //   1325: astore 30
    //   1327: aconst_null
    //   1328: astore 29
    //   1330: aconst_null
    //   1331: astore 28
    //   1333: aconst_null
    //   1334: astore 27
    //   1336: aconst_null
    //   1337: astore 26
    //   1339: goto -620 -> 719
    //   1342: aload 53
    //   1344: astore 13
    //   1346: goto -838 -> 508
    //   1349: aload 53
    //   1351: astore 13
    //   1353: dload 58
    //   1355: dstore 69
    //   1357: goto -965 -> 392
    //   1360: aload 10
    //   1362: astore 12
    //   1364: aload 11
    //   1366: astore 13
    //   1368: goto -1172 -> 196
    //   1371: dload 79
    //   1373: dstore 86
    //   1375: aload 81
    //   1377: astore 10
    //   1379: aload 82
    //   1381: astore 11
    //   1383: goto -1238 -> 145
    //   1386: aconst_null
    //   1387: astore 10
    //   1389: aconst_null
    //   1390: astore 11
    //   1392: goto -1216 -> 176
    //
    // Exception table:
    //   from	to	target	type
    //   181	188	411	java/lang/Exception
    //   3	29	424	java/lang/Exception
    //   440	447	458	java/lang/Exception
    //   3	29	471	finally
    //   497	504	958	java/lang/Exception
    //   201	227	967	java/lang/Exception
    //   981	988	995	java/lang/Exception
    //   201	227	1004	finally
    //   525	537	1024	java/lang/Exception
    //   541	580	1024	java/lang/Exception
    //   1046	1053	1079	java/lang/Exception
    //   525	537	1107	finally
    //   478	485	1131	java/lang/Exception
    //   1014	1021	1136	java/lang/Exception
    //   724	731	1141	java/lang/Exception
    //   1121	1128	1146	java/lang/Exception
    //   541	580	1151	finally
    //   584	603	1151	finally
    //   607	626	1151	finally
    //   630	649	1151	finally
    //   653	672	1151	finally
    //   676	695	1151	finally
    //   584	603	1164	java/lang/Exception
    //   607	626	1181	java/lang/Exception
    //   630	649	1195	java/lang/Exception
    //   653	672	1206	java/lang/Exception
    //   676	695	1214	java/lang/Exception
    //   231	241	1219	finally
    //   246	256	1219	finally
    //   260	359	1219	finally
    //   367	375	1219	finally
    //   392	400	1219	finally
    //   231	241	1224	java/lang/Exception
    //   246	256	1224	java/lang/Exception
    //   392	400	1224	java/lang/Exception
    //   260	359	1237	java/lang/Exception
    //   367	375	1237	java/lang/Exception
    //   33	42	1246	finally
    //   58	112	1246	finally
    //   120	128	1246	finally
    //   145	153	1246	finally
    //   33	42	1259	java/lang/Exception
    //   145	153	1270	java/lang/Exception
    //   58	112	1275	java/lang/Exception
    //   120	128	1275	java/lang/Exception
  }

  // ERROR //
  List jdMethod_if(double paramDouble1, double paramDouble2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 399	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 400	java/util/ArrayList:<init>	()V
    //   10: astore 6
    //   12: getstatic 403	com/baidu/location/c/f$b:char	Lcom/baidu/location/c/f$b;
    //   15: aload_0
    //   16: getfield 66	com/baidu/location/c/f:a4	I
    //   19: dload_1
    //   20: dload_3
    //   21: invokestatic 316	com/baidu/location/c/f$b:a	(Lcom/baidu/location/c/f$b;IDD)Ljava/lang/String;
    //   24: astore 7
    //   26: new 405	java/util/HashMap
    //   29: dup
    //   30: invokespecial 406	java/util/HashMap:<init>	()V
    //   33: astore 8
    //   35: new 399	java/util/ArrayList
    //   38: dup
    //   39: invokespecial 400	java/util/ArrayList:<init>	()V
    //   42: astore 9
    //   44: aload_0
    //   45: getfield 64	com/baidu/location/c/f:a7	Landroid/database/sqlite/SQLiteDatabase;
    //   48: aload 7
    //   50: aconst_null
    //   51: invokevirtual 193	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore 18
    //   56: aload 18
    //   58: astore 11
    //   60: aload 11
    //   62: invokeinterface 198 1 0
    //   67: ifeq +262 -> 329
    //   70: aload 11
    //   72: invokeinterface 247 1 0
    //   77: ifne +252 -> 329
    //   80: aload 11
    //   82: iconst_0
    //   83: invokeinterface 251 2 0
    //   88: astore 22
    //   90: aload 11
    //   92: iconst_2
    //   93: invokeinterface 251 2 0
    //   98: astore 23
    //   100: aload 11
    //   102: iconst_4
    //   103: invokeinterface 322 2 0
    //   108: dstore 24
    //   110: aload 11
    //   112: iconst_5
    //   113: invokeinterface 322 2 0
    //   118: dstore 26
    //   120: aload 11
    //   122: bipush 6
    //   124: invokeinterface 202 2 0
    //   129: istore 28
    //   131: aload_0
    //   132: dload_3
    //   133: dload_1
    //   134: dload 26
    //   136: dload 24
    //   138: invokespecial 324	com/baidu/location/c/f:int	(DDDD)D
    //   141: dstore 29
    //   143: dload 29
    //   145: getstatic 403	com/baidu/location/c/f$b:char	Lcom/baidu/location/c/f$b;
    //   148: invokestatic 327	com/baidu/location/c/f$b:a	(Lcom/baidu/location/c/f$b;)I
    //   151: i2d
    //   152: dcmpg
    //   153: ifge +63 -> 216
    //   156: aload 8
    //   158: new 408	com/baidu/location/Poi
    //   161: dup
    //   162: new 154	java/lang/String
    //   165: dup
    //   166: aload 22
    //   168: invokevirtual 360	java/lang/String:getBytes	()[B
    //   171: invokestatic 365	com/baidu/location/f/b/b:a	([B)[B
    //   174: invokespecial 368	java/lang/String:<init>	([B)V
    //   177: new 154	java/lang/String
    //   180: dup
    //   181: aload 23
    //   183: invokevirtual 360	java/lang/String:getBytes	()[B
    //   186: invokestatic 365	com/baidu/location/f/b/b:a	([B)[B
    //   189: invokespecial 368	java/lang/String:<init>	([B)V
    //   192: dconst_0
    //   193: invokespecial 411	com/baidu/location/Poi:<init>	(Ljava/lang/String;Ljava/lang/String;D)V
    //   196: iload 28
    //   198: dload 29
    //   200: d2f
    //   201: invokestatic 415	java/lang/Math:round	(F)I
    //   204: invokestatic 417	com/baidu/location/c/f:if	(II)I
    //   207: invokestatic 229	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: invokeinterface 422 3 0
    //   215: pop
    //   216: aload 11
    //   218: invokeinterface 272 1 0
    //   223: pop
    //   224: goto -154 -> 70
    //   227: astore 20
    //   229: aload 11
    //   231: ifnull +10 -> 241
    //   234: aload 11
    //   236: invokeinterface 207 1 0
    //   241: aload 9
    //   243: aload 8
    //   245: invokeinterface 426 1 0
    //   250: invokeinterface 432 2 0
    //   255: pop
    //   256: aload 9
    //   258: new 434	com/baidu/location/c/f$1
    //   261: dup
    //   262: aload_0
    //   263: invokespecial 437	com/baidu/location/c/f$1:<init>	(Lcom/baidu/location/c/f;)V
    //   266: invokestatic 443	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   269: aload 9
    //   271: invokeinterface 444 1 0
    //   276: ifle +50 -> 326
    //   279: aload 9
    //   281: iconst_0
    //   282: invokeinterface 448 2 0
    //   287: checkcast 450	java/util/Map$Entry
    //   290: invokeinterface 454 1 0
    //   295: checkcast 408	com/baidu/location/Poi
    //   298: astore 13
    //   300: aload 6
    //   302: new 408	com/baidu/location/Poi
    //   305: dup
    //   306: aload 13
    //   308: invokevirtual 457	com/baidu/location/Poi:getId	()Ljava/lang/String;
    //   311: aload 13
    //   313: invokevirtual 460	com/baidu/location/Poi:getName	()Ljava/lang/String;
    //   316: dconst_1
    //   317: invokespecial 411	com/baidu/location/Poi:<init>	(Ljava/lang/String;Ljava/lang/String;D)V
    //   320: invokeinterface 461 2 0
    //   325: pop
    //   326: aload 6
    //   328: areturn
    //   329: aload 11
    //   331: ifnull -90 -> 241
    //   334: aload 11
    //   336: invokeinterface 207 1 0
    //   341: goto -100 -> 241
    //   344: astore 21
    //   346: goto -105 -> 241
    //   349: astore 16
    //   351: aload 5
    //   353: ifnull +10 -> 363
    //   356: aload 5
    //   358: invokeinterface 207 1 0
    //   363: aload 16
    //   365: athrow
    //   366: astore 15
    //   368: goto -127 -> 241
    //   371: astore 17
    //   373: goto -10 -> 363
    //   376: astore 19
    //   378: aload 11
    //   380: astore 5
    //   382: aload 19
    //   384: astore 16
    //   386: goto -35 -> 351
    //   389: astore 10
    //   391: aconst_null
    //   392: astore 11
    //   394: goto -165 -> 229
    //
    // Exception table:
    //   from	to	target	type
    //   60	70	227	java/lang/Exception
    //   70	216	227	java/lang/Exception
    //   216	224	227	java/lang/Exception
    //   334	341	344	java/lang/Exception
    //   44	56	349	finally
    //   234	241	366	java/lang/Exception
    //   356	363	371	java/lang/Exception
    //   60	70	376	finally
    //   70	216	376	finally
    //   216	224	376	finally
    //   44	56	389	java/lang/Exception
  }

  void jdMethod_if(JSONObject paramJSONObject)
  {
    if ((this.a7 != null) && (this.a7.isOpen()));
    try
    {
      this.a7.beginTransaction();
      b[] arrayOfb = b.values();
      int i = arrayOfb.length;
      j = 0;
      if (j < i)
      {
        b localb = arrayOfb[j];
        if (paramJSONObject.has(b.jdMethod_if(localb)))
        {
          String str1 = "";
          if (paramJSONObject.has(b.jdMethod_do(localb)))
            str1 = paramJSONObject.getString(b.jdMethod_do(localb));
          ArrayList localArrayList = new ArrayList();
          JSONObject localJSONObject = paramJSONObject.getJSONObject(b.jdMethod_if(localb));
          localArrayList.add(b.a(localb, localJSONObject));
          localArrayList.addAll(localb.a(localJSONObject, str1, b.jdMethod_for(localb)));
          Iterator localIterator = localArrayList.iterator();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            this.a7.execSQL(str2);
          }
        }
      }
    }
    catch (Exception localException2)
    {
    }
    finally
    {
      try
      {
        while (true)
        {
          int j;
          this.a7.endTransaction();
          return;
          j++;
        }
        this.a7.setTransactionSuccessful();
        this.aX = -1;
        this.aU = -1;
        try
        {
          this.a7.endTransaction();
          return;
        }
        catch (Exception localException4)
        {
          return;
        }
        localObject = finally;
        try
        {
          this.a7.endTransaction();
          label243: throw localObject;
        }
        catch (Exception localException1)
        {
          break label243;
        }
      }
      catch (Exception localException3)
      {
      }
    }
  }

  private static final class a
  {
    private double a;
    private double jdField_if;

    private a(double paramDouble1, double paramDouble2)
    {
      this.jdField_if = paramDouble1;
      this.a = paramDouble2;
    }
  }

  private static abstract enum b
  {
    private static final int jdField_byte = 50;
    private static final String jdField_new = "INSERT OR REPLACE INTO %s VALUES %s";
    private final int jdField_case;
    private final String jdField_else;
    private final String jdField_if;
    private final int jdField_int;
    private final String jdField_try;

    static
    {
      char = new f.b.4("POI", 3, "RGCPOI", "poi", "poiv", 1000, 5000);
      b[] arrayOfb = new b[4];
      arrayOfb[0] = a;
      arrayOfb[1] = do;
      arrayOfb[2] = goto;
      arrayOfb[3] = char;
      for = arrayOfb;
    }

    private b(String paramString3, String paramInt1, String paramInt2, int arg6, int arg7)
    {
      this.jdField_if = paramString3;
      this.jdField_try = paramInt1;
      this.jdField_else = paramInt2;
      int i;
      this.jdField_case = i;
      int j;
      this.jdField_int = j;
    }

    private String a(int paramInt, double paramDouble1, double paramDouble2)
    {
      HashSet localHashSet = new HashSet();
      localHashSet.add(f.jdMethod_do(paramInt, paramDouble1, paramDouble2));
      double d = 1.414D * this.jdField_case;
      if (this.jdField_case > 0)
        for (int j = 0; j < f.G().length; j++)
        {
          double[] arrayOfDouble = f.jdMethod_do(paramDouble2, paramDouble1, d, f.G()[j]);
          localHashSet.add(f.jdMethod_do(paramInt, arrayOfDouble[1], arrayOfDouble[0]));
        }
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = localHashSet.iterator();
      int i = 1;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (i != 0)
          i = 0;
        while (true)
        {
          localStringBuffer.append("\"").append(str).append("\"");
          break;
          localStringBuffer.append(',');
        }
      }
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.jdField_if;
      arrayOfObject[1] = localStringBuffer.toString();
      return String.format("SELECT * FROM %s WHERE gridkey IN (%s);", arrayOfObject);
    }

    private String a(JSONObject paramJSONObject)
    {
      Iterator localIterator = paramJSONObject.keys();
      StringBuffer localStringBuffer = new StringBuffer();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localStringBuffer.length() != 0)
          localStringBuffer.append(",");
        localStringBuffer.append("\"").append(str).append("\"");
      }
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.jdField_if;
      arrayOfObject[1] = localStringBuffer;
      return String.format(localLocale, "DELETE FROM %s WHERE gridkey IN (%s)", arrayOfObject);
    }

    private static void jdField_if(StringBuffer paramStringBuffer, String paramString1, String paramString2, int paramInt)
    {
      if (paramStringBuffer.length() > 0)
        paramStringBuffer.append(",");
      paramStringBuffer.append("(\"").append(paramString1).append("\",\"").append(paramString2).append("\",").append(paramInt).append(",").append(System.currentTimeMillis() / 86400000L).append(")");
    }

    abstract List a(JSONObject paramJSONObject, String paramString, int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.f
 * JD-Core Version:    0.6.0
 */