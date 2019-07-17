package com.baidu.location.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.location.b.b;
import com.baidu.location.b.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

final class a
  implements b
{
  private static final int c = 10000;
  private static final int jdField_char = 1000;
  private static final int d = 2000;
  private static final int e = 4;
  private static final int jdField_else = 30;
  private static final int f = 2;
  private static final double jdField_for = 100.0D;
  private static final int g = 1;
  private static final int h = 0;
  static final int i = 30;
  private static final int jdField_if = 7776000;
  private static final int j = 100000;
  private static final int l = 604800;
  private static final int n = 300;
  private static final int p = 100;
  static final int s = 8;
  private static final int jdField_try = 15552000;
  private static final int u = 1000;
  private static final int v = 604800;
  private static final double w = 300.0D;
  private StringBuffer b;
  private final SQLiteDatabase jdField_byte;
  private int jdField_case;
  private ConcurrentHashMap jdField_do;
  private StringBuffer jdField_goto;
  private double jdField_int;
  private Long k;
  private ConcurrentHashMap jdField_long;
  private boolean m;
  private double jdField_new;
  private final d o;
  private final SQLiteDatabase q;
  private StringBuffer r;
  private HashSet t;
  private final b jdField_void;
  private final b x;

  // ERROR //
  a(d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 78	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 80	com/baidu/location/c/a:o	Lcom/baidu/location/c/d;
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 82	com/baidu/location/c/a:m	Z
    //   14: aload_0
    //   15: new 84	com/baidu/location/c/a$b
    //   18: dup
    //   19: aload_0
    //   20: aload_0
    //   21: iconst_1
    //   22: invokespecial 87	com/baidu/location/c/a$b:<init>	(Lcom/baidu/location/c/a;Lcom/baidu/location/c/a;Z)V
    //   25: putfield 89	com/baidu/location/c/a:jdField_void	Lcom/baidu/location/c/a$b;
    //   28: aload_0
    //   29: new 84	com/baidu/location/c/a$b
    //   32: dup
    //   33: aload_0
    //   34: aload_0
    //   35: iconst_0
    //   36: invokespecial 87	com/baidu/location/c/a$b:<init>	(Lcom/baidu/location/c/a;Lcom/baidu/location/c/a;Z)V
    //   39: putfield 91	com/baidu/location/c/a:x	Lcom/baidu/location/c/a$b;
    //   42: aload_0
    //   43: new 93	java/lang/StringBuffer
    //   46: dup
    //   47: invokespecial 94	java/lang/StringBuffer:<init>	()V
    //   50: putfield 96	com/baidu/location/c/a:b	Ljava/lang/StringBuffer;
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 98	com/baidu/location/c/a:r	Ljava/lang/StringBuffer;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 100	com/baidu/location/c/a:jdField_goto	Ljava/lang/StringBuffer;
    //   63: aload_0
    //   64: new 102	java/util/HashSet
    //   67: dup
    //   68: invokespecial 103	java/util/HashSet:<init>	()V
    //   71: putfield 105	com/baidu/location/c/a:t	Ljava/util/HashSet;
    //   74: aload_0
    //   75: new 107	java/util/concurrent/ConcurrentHashMap
    //   78: dup
    //   79: invokespecial 108	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   82: putfield 110	com/baidu/location/c/a:jdField_long	Ljava/util/concurrent/ConcurrentHashMap;
    //   85: aload_0
    //   86: new 107	java/util/concurrent/ConcurrentHashMap
    //   89: dup
    //   90: invokespecial 108	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   93: putfield 112	com/baidu/location/c/a:jdField_do	Ljava/util/concurrent/ConcurrentHashMap;
    //   96: new 114	java/io/File
    //   99: dup
    //   100: aload_0
    //   101: getfield 80	com/baidu/location/c/a:o	Lcom/baidu/location/c/d;
    //   104: invokevirtual 119	com/baidu/location/c/d:d	()Ljava/io/File;
    //   107: ldc 121
    //   109: invokespecial 124	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   112: astore_2
    //   113: aload_2
    //   114: invokevirtual 128	java/io/File:exists	()Z
    //   117: ifne +8 -> 125
    //   120: aload_2
    //   121: invokevirtual 131	java/io/File:createNewFile	()Z
    //   124: pop
    //   125: aload_2
    //   126: aconst_null
    //   127: invokestatic 137	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/io/File;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   130: astore 12
    //   132: aload 12
    //   134: astore 4
    //   136: aload_0
    //   137: aload 4
    //   139: putfield 139	com/baidu/location/c/a:q	Landroid/database/sqlite/SQLiteDatabase;
    //   142: aload_0
    //   143: getfield 139	com/baidu/location/c/a:q	Landroid/database/sqlite/SQLiteDatabase;
    //   146: ifnull +21 -> 167
    //   149: aload_0
    //   150: getfield 139	com/baidu/location/c/a:q	Landroid/database/sqlite/SQLiteDatabase;
    //   153: ldc 141
    //   155: invokevirtual 145	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   158: aload_0
    //   159: getfield 139	com/baidu/location/c/a:q	Landroid/database/sqlite/SQLiteDatabase;
    //   162: ldc 147
    //   164: invokevirtual 145	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   167: new 114	java/io/File
    //   170: dup
    //   171: aload_0
    //   172: getfield 80	com/baidu/location/c/a:o	Lcom/baidu/location/c/d;
    //   175: invokevirtual 119	com/baidu/location/c/d:d	()Ljava/io/File;
    //   178: ldc 149
    //   180: invokespecial 124	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   183: astore 5
    //   185: aload 5
    //   187: invokevirtual 128	java/io/File:exists	()Z
    //   190: ifne +9 -> 199
    //   193: aload 5
    //   195: invokevirtual 131	java/io/File:createNewFile	()Z
    //   198: pop
    //   199: aload 5
    //   201: aconst_null
    //   202: invokestatic 137	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/io/File;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   205: astore 9
    //   207: aload 9
    //   209: astore 7
    //   211: aload_0
    //   212: aload 7
    //   214: putfield 151	com/baidu/location/c/a:jdField_byte	Landroid/database/sqlite/SQLiteDatabase;
    //   217: aload_0
    //   218: getfield 151	com/baidu/location/c/a:jdField_byte	Landroid/database/sqlite/SQLiteDatabase;
    //   221: ifnull +21 -> 242
    //   224: aload_0
    //   225: getfield 151	com/baidu/location/c/a:jdField_byte	Landroid/database/sqlite/SQLiteDatabase;
    //   228: ldc 153
    //   230: invokevirtual 145	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   233: aload_0
    //   234: getfield 151	com/baidu/location/c/a:jdField_byte	Landroid/database/sqlite/SQLiteDatabase;
    //   237: ldc 155
    //   239: invokevirtual 145	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   242: return
    //   243: astore_3
    //   244: aconst_null
    //   245: astore 4
    //   247: goto -111 -> 136
    //   250: astore 8
    //   252: return
    //   253: astore 6
    //   255: aconst_null
    //   256: astore 7
    //   258: goto -47 -> 211
    //   261: astore 11
    //   263: goto -96 -> 167
    //
    // Exception table:
    //   from	to	target	type
    //   96	125	243	java/lang/Exception
    //   125	132	243	java/lang/Exception
    //   224	242	250	java/lang/Exception
    //   167	199	253	java/lang/Exception
    //   199	207	253	java/lang/Exception
    //   149	167	261	java/lang/Exception
  }

  private double jdField_if(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
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

  private int jdField_if(ArrayList paramArrayList, double paramDouble)
  {
    int i2;
    if (paramArrayList.size() == 0)
    {
      i2 = 0;
      return i2;
    }
    int i1 = 0;
    int i5;
    int i6;
    double d5;
    label113: double d6;
    int i8;
    if (paramArrayList.size() >= 3)
    {
      double d1 = 0.0D;
      double d2 = 0.0D;
      for (int i4 = 0; i4 < paramArrayList.size(); i4++)
      {
        d1 += ((c)paramArrayList.get(i4)).a;
        d2 += ((c)paramArrayList.get(i4)).jdField_do;
      }
      double d3 = d1 / paramArrayList.size();
      double d4 = d2 / paramArrayList.size();
      i5 = 0;
      i6 = -1;
      d5 = -1.0D;
      if (i5 < paramArrayList.size())
      {
        d6 = jdField_if(d4, d3, ((c)paramArrayList.get(i5)).jdField_do, ((c)paramArrayList.get(i5)).a);
        if (d6 <= d5)
          break label246;
        i8 = i5;
      }
    }
    while (true)
    {
      i5++;
      i6 = i8;
      d5 = d6;
      break label113;
      int i3;
      if ((d5 > paramDouble) && (i6 >= 0) && (i6 < paramArrayList.size()))
      {
        int i7 = i1 + 1;
        paramArrayList.remove(i6);
        i3 = 1;
        i2 = i7;
      }
      while (true)
      {
        if (i3 != 1)
          break label244;
        i1 = i2;
        break;
        i2 = i1;
        i3 = 0;
      }
      label244: break;
      label246: i8 = i6;
      d6 = d5;
    }
  }

  // ERROR //
  private BDLocation jdField_if(Long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 82	com/baidu/location/c/a:m	Z
    //   5: iconst_0
    //   6: istore_2
    //   7: dconst_0
    //   8: dstore_3
    //   9: dconst_0
    //   10: dstore 5
    //   12: iconst_0
    //   13: istore 7
    //   15: aload_0
    //   16: getfield 210	com/baidu/location/c/a:k	Ljava/lang/Long;
    //   19: ifnull +84 -> 103
    //   22: aload_0
    //   23: getfield 210	com/baidu/location/c/a:k	Ljava/lang/Long;
    //   26: aload_1
    //   27: invokevirtual 216	java/lang/Long:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +73 -> 103
    //   33: iconst_1
    //   34: istore 7
    //   36: aload_0
    //   37: getfield 218	com/baidu/location/c/a:jdField_new	D
    //   40: dstore_3
    //   41: aload_0
    //   42: getfield 220	com/baidu/location/c/a:jdField_int	D
    //   45: dstore 5
    //   47: aload_0
    //   48: getfield 222	com/baidu/location/c/a:jdField_case	I
    //   51: istore_2
    //   52: iload 7
    //   54: ifeq +377 -> 431
    //   57: new 224	com/baidu/location/BDLocation
    //   60: dup
    //   61: invokespecial 225	com/baidu/location/BDLocation:<init>	()V
    //   64: astore 18
    //   66: aload 18
    //   68: iload_2
    //   69: i2f
    //   70: invokevirtual 229	com/baidu/location/BDLocation:setRadius	(F)V
    //   73: aload 18
    //   75: dload 5
    //   77: invokevirtual 233	com/baidu/location/BDLocation:setLatitude	(D)V
    //   80: aload 18
    //   82: dload_3
    //   83: invokevirtual 236	com/baidu/location/BDLocation:setLongitude	(D)V
    //   86: aload 18
    //   88: ldc 238
    //   90: invokevirtual 241	com/baidu/location/BDLocation:setNetworkLocationType	(Ljava/lang/String;)V
    //   93: aload 18
    //   95: bipush 66
    //   97: invokevirtual 245	com/baidu/location/BDLocation:setLocType	(I)V
    //   100: aload 18
    //   102: areturn
    //   103: aconst_null
    //   104: astore 8
    //   106: getstatic 251	java/util/Locale:US	Ljava/util/Locale;
    //   109: astore 9
    //   111: iconst_3
    //   112: anewarray 4	java/lang/Object
    //   115: astore 10
    //   117: aload 10
    //   119: iconst_0
    //   120: aload_1
    //   121: aastore
    //   122: aload 10
    //   124: iconst_1
    //   125: ldc 42
    //   127: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aastore
    //   131: aload 10
    //   133: iconst_2
    //   134: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   137: ldc2_w 264
    //   140: ldiv
    //   141: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   144: aastore
    //   145: aload 9
    //   147: ldc_w 270
    //   150: aload 10
    //   152: invokestatic 276	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   155: astore 11
    //   157: aload_0
    //   158: getfield 139	com/baidu/location/c/a:q	Landroid/database/sqlite/SQLiteDatabase;
    //   161: aload 11
    //   163: aconst_null
    //   164: invokevirtual 280	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   167: astore 19
    //   169: aload 19
    //   171: astore 8
    //   173: iconst_0
    //   174: istore 7
    //   176: iconst_0
    //   177: istore_2
    //   178: aload 8
    //   180: ifnull +171 -> 351
    //   183: aload 8
    //   185: invokeinterface 285 1 0
    //   190: istore 22
    //   192: iconst_0
    //   193: istore 7
    //   195: iconst_0
    //   196: istore_2
    //   197: iload 22
    //   199: ifeq +152 -> 351
    //   202: aload 8
    //   204: aload 8
    //   206: ldc 238
    //   208: invokeinterface 289 2 0
    //   213: invokeinterface 293 2 0
    //   218: dconst_0
    //   219: dcmpl
    //   220: istore 23
    //   222: iconst_0
    //   223: istore 7
    //   225: iconst_0
    //   226: istore_2
    //   227: iload 23
    //   229: ifle +122 -> 351
    //   232: iconst_1
    //   233: istore 7
    //   235: aload 8
    //   237: aload 8
    //   239: ldc_w 294
    //   242: invokeinterface 289 2 0
    //   247: invokeinterface 293 2 0
    //   252: dstore_3
    //   253: aload 8
    //   255: aload 8
    //   257: ldc_w 296
    //   260: invokeinterface 289 2 0
    //   265: invokeinterface 293 2 0
    //   270: dstore 5
    //   272: aload 8
    //   274: aload 8
    //   276: ldc_w 297
    //   279: invokeinterface 289 2 0
    //   284: invokeinterface 301 2 0
    //   289: istore_2
    //   290: ldc 34
    //   292: aload 8
    //   294: aload 8
    //   296: ldc_w 303
    //   299: invokeinterface 289 2 0
    //   304: invokeinterface 301 2 0
    //   309: iadd
    //   310: i2l
    //   311: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   314: ldc2_w 264
    //   317: ldiv
    //   318: lcmp
    //   319: ifge +132 -> 451
    //   322: aload_0
    //   323: iconst_1
    //   324: putfield 82	com/baidu/location/c/a:m	Z
    //   327: goto +124 -> 451
    //   330: aload_0
    //   331: dload_3
    //   332: putfield 218	com/baidu/location/c/a:jdField_new	D
    //   335: aload_0
    //   336: dload 5
    //   338: putfield 220	com/baidu/location/c/a:jdField_int	D
    //   341: aload_0
    //   342: iload_2
    //   343: putfield 222	com/baidu/location/c/a:jdField_case	I
    //   346: aload_0
    //   347: aload_1
    //   348: putfield 210	com/baidu/location/c/a:k	Ljava/lang/Long;
    //   351: aload 8
    //   353: ifnull -301 -> 52
    //   356: aload 8
    //   358: invokeinterface 306 1 0
    //   363: goto -311 -> 52
    //   366: astore 20
    //   368: goto -316 -> 52
    //   371: sipush 2000
    //   374: iload_2
    //   375: if_icmpge -45 -> 330
    //   378: sipush 2000
    //   381: istore_2
    //   382: goto -52 -> 330
    //   385: astore 16
    //   387: aload 8
    //   389: ifnull -337 -> 52
    //   392: aload 8
    //   394: invokeinterface 306 1 0
    //   399: goto -347 -> 52
    //   402: astore 17
    //   404: goto -352 -> 52
    //   407: astore 12
    //   409: aconst_null
    //   410: astore 13
    //   412: aload 12
    //   414: astore 14
    //   416: aload 13
    //   418: ifnull +10 -> 428
    //   421: aload 13
    //   423: invokeinterface 306 1 0
    //   428: aload 14
    //   430: athrow
    //   431: aconst_null
    //   432: areturn
    //   433: astore 15
    //   435: goto -7 -> 428
    //   438: astore 21
    //   440: aload 8
    //   442: astore 13
    //   444: aload 21
    //   446: astore 14
    //   448: goto -32 -> 416
    //   451: iload_2
    //   452: sipush 300
    //   455: if_icmpge -84 -> 371
    //   458: sipush 300
    //   461: istore_2
    //   462: goto -132 -> 330
    //
    // Exception table:
    //   from	to	target	type
    //   356	363	366	java/lang/Exception
    //   157	169	385	java/lang/Exception
    //   183	192	385	java/lang/Exception
    //   202	222	385	java/lang/Exception
    //   235	327	385	java/lang/Exception
    //   330	351	385	java/lang/Exception
    //   392	399	402	java/lang/Exception
    //   157	169	407	finally
    //   421	428	433	java/lang/Exception
    //   183	192	438	finally
    //   202	222	438	finally
    //   235	327	438	finally
    //   330	351	438	finally
  }

  // ERROR //
  private BDLocation jdField_if(LinkedHashMap paramLinkedHashMap, BDLocation paramBDLocation, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/baidu/location/c/a:b	Ljava/lang/StringBuffer;
    //   4: iconst_0
    //   5: invokevirtual 310	java/lang/StringBuffer:setLength	(I)V
    //   8: dconst_0
    //   9: dstore 4
    //   11: dconst_0
    //   12: dstore 6
    //   14: aload_2
    //   15: ifnull +1322 -> 1337
    //   18: aload_2
    //   19: invokevirtual 314	com/baidu/location/BDLocation:getLatitude	()D
    //   22: dstore 6
    //   24: aload_2
    //   25: invokevirtual 317	com/baidu/location/BDLocation:getLongitude	()D
    //   28: dstore 4
    //   30: iconst_1
    //   31: istore 8
    //   33: new 93	java/lang/StringBuffer
    //   36: dup
    //   37: invokespecial 94	java/lang/StringBuffer:<init>	()V
    //   40: astore 9
    //   42: aload_1
    //   43: invokevirtual 323	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   46: invokeinterface 329 1 0
    //   51: astore 10
    //   53: iconst_0
    //   54: istore 11
    //   56: iconst_1
    //   57: istore 12
    //   59: iload 11
    //   61: aload_1
    //   62: invokevirtual 330	java/util/LinkedHashMap:size	()I
    //   65: bipush 30
    //   67: invokestatic 334	java/lang/Math:min	(II)I
    //   70: if_icmpge +142 -> 212
    //   73: aload 10
    //   75: invokeinterface 340 1 0
    //   80: checkcast 342	java/util/Map$Entry
    //   83: astore 89
    //   85: aload 89
    //   87: invokeinterface 345 1 0
    //   92: checkcast 272	java/lang/String
    //   95: astore 90
    //   97: aload 89
    //   99: invokeinterface 348 1 0
    //   104: checkcast 253	java/lang/Integer
    //   107: astore 91
    //   109: aload 91
    //   111: invokevirtual 351	java/lang/Integer:intValue	()I
    //   114: ifge +14 -> 128
    //   117: aload 91
    //   119: invokevirtual 351	java/lang/Integer:intValue	()I
    //   122: ineg
    //   123: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: astore 91
    //   128: aload 90
    //   130: invokestatic 356	com/baidu/location/Jni:I	(Ljava/lang/String;)Ljava/lang/Long;
    //   133: astore 92
    //   135: aload 92
    //   137: ifnonnull +17 -> 154
    //   140: iload 12
    //   142: istore 97
    //   144: iinc 11 1
    //   147: iload 97
    //   149: istore 12
    //   151: goto -92 -> 59
    //   154: aload_0
    //   155: getfield 112	com/baidu/location/c/a:jdField_do	Ljava/util/concurrent/ConcurrentHashMap;
    //   158: aload 92
    //   160: aload 90
    //   162: invokevirtual 360	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: pop
    //   166: iload 12
    //   168: ifeq +33 -> 201
    //   171: iconst_0
    //   172: istore 12
    //   174: aload_0
    //   175: getfield 110	com/baidu/location/c/a:jdField_long	Ljava/util/concurrent/ConcurrentHashMap;
    //   178: aload 92
    //   180: aload 91
    //   182: invokevirtual 360	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: pop
    //   186: aload 9
    //   188: aload 92
    //   190: invokevirtual 364	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   193: pop
    //   194: iload 12
    //   196: istore 97
    //   198: goto -54 -> 144
    //   201: aload 9
    //   203: bipush 44
    //   205: invokevirtual 367	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   208: pop
    //   209: goto -35 -> 174
    //   212: getstatic 251	java/util/Locale:US	Ljava/util/Locale;
    //   215: astore 13
    //   217: iconst_3
    //   218: anewarray 4	java/lang/Object
    //   221: astore 14
    //   223: aload 14
    //   225: iconst_0
    //   226: aload 9
    //   228: aastore
    //   229: aload 14
    //   231: iconst_1
    //   232: ldc 30
    //   234: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: aastore
    //   238: aload 14
    //   240: iconst_2
    //   241: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   244: ldc2_w 264
    //   247: ldiv
    //   248: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   251: aastore
    //   252: aload 13
    //   254: ldc_w 369
    //   257: aload 14
    //   259: invokestatic 276	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   262: astore 15
    //   264: aload_0
    //   265: getfield 139	com/baidu/location/c/a:q	Landroid/database/sqlite/SQLiteDatabase;
    //   268: aload 15
    //   270: aconst_null
    //   271: invokevirtual 280	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   274: astore 30
    //   276: aload 30
    //   278: astore 28
    //   280: aload 28
    //   282: ifnull +1040 -> 1322
    //   285: aload 28
    //   287: invokeinterface 285 1 0
    //   292: ifeq +1030 -> 1322
    //   295: new 185	java/util/ArrayList
    //   298: dup
    //   299: invokespecial 370	java/util/ArrayList:<init>	()V
    //   302: astore 33
    //   304: aload 28
    //   306: invokeinterface 373 1 0
    //   311: ifne +487 -> 798
    //   314: aload 28
    //   316: iconst_0
    //   317: invokeinterface 377 2 0
    //   322: invokestatic 268	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   325: astore 66
    //   327: aload 28
    //   329: iconst_1
    //   330: invokeinterface 293 2 0
    //   335: dstore 67
    //   337: aload 28
    //   339: iconst_2
    //   340: invokeinterface 293 2 0
    //   345: dstore 69
    //   347: aload 28
    //   349: iconst_3
    //   350: invokeinterface 301 2 0
    //   355: istore 71
    //   357: aload 28
    //   359: iconst_4
    //   360: invokeinterface 293 2 0
    //   365: dstore 72
    //   367: aload 28
    //   369: iconst_5
    //   370: invokeinterface 301 2 0
    //   375: istore 74
    //   377: aload_0
    //   378: getfield 105	com/baidu/location/c/a:t	Ljava/util/HashSet;
    //   381: aload 66
    //   383: invokevirtual 380	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   386: pop
    //   387: iload 74
    //   389: ldc 34
    //   391: iadd
    //   392: i2l
    //   393: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   396: ldc2_w 264
    //   399: ldiv
    //   400: lcmp
    //   401: ifge +85 -> 486
    //   404: aload_0
    //   405: getfield 96	com/baidu/location/c/a:b	Ljava/lang/StringBuffer;
    //   408: invokevirtual 383	java/lang/StringBuffer:length	()I
    //   411: ifle +14 -> 425
    //   414: aload_0
    //   415: getfield 96	com/baidu/location/c/a:b	Ljava/lang/StringBuffer;
    //   418: ldc_w 385
    //   421: invokevirtual 388	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   424: pop
    //   425: aload_0
    //   426: getfield 96	com/baidu/location/c/a:b	Ljava/lang/StringBuffer;
    //   429: astore 84
    //   431: getstatic 251	java/util/Locale:US	Ljava/util/Locale;
    //   434: astore 85
    //   436: iconst_3
    //   437: anewarray 4	java/lang/Object
    //   440: astore 86
    //   442: aload 86
    //   444: iconst_0
    //   445: aload 66
    //   447: aastore
    //   448: aload 86
    //   450: iconst_1
    //   451: aload_0
    //   452: getfield 112	com/baidu/location/c/a:jdField_do	Ljava/util/concurrent/ConcurrentHashMap;
    //   455: aload 66
    //   457: invokevirtual 391	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   460: aastore
    //   461: aload 86
    //   463: iconst_2
    //   464: ldc 32
    //   466: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: aastore
    //   470: aload 84
    //   472: aload 85
    //   474: ldc_w 393
    //   477: aload 86
    //   479: invokestatic 276	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   482: invokevirtual 388	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   485: pop
    //   486: dload 72
    //   488: dconst_0
    //   489: dcmpg
    //   490: ifgt +98 -> 588
    //   493: aload 28
    //   495: invokeinterface 396 1 0
    //   500: pop
    //   501: goto -197 -> 304
    //   504: astore 32
    //   506: aload 28
    //   508: astore 21
    //   510: iconst_0
    //   511: istore 22
    //   513: dconst_0
    //   514: dstore 17
    //   516: dconst_0
    //   517: dstore 19
    //   519: iconst_0
    //   520: istore 23
    //   522: aload 21
    //   524: ifnull +10 -> 534
    //   527: aload 21
    //   529: invokeinterface 306 1 0
    //   534: iload 22
    //   536: ifeq +664 -> 1200
    //   539: new 224	com/baidu/location/BDLocation
    //   542: dup
    //   543: invokespecial 225	com/baidu/location/BDLocation:<init>	()V
    //   546: astore 24
    //   548: aload 24
    //   550: iload 23
    //   552: i2f
    //   553: invokevirtual 229	com/baidu/location/BDLocation:setRadius	(F)V
    //   556: aload 24
    //   558: dload 17
    //   560: invokevirtual 233	com/baidu/location/BDLocation:setLatitude	(D)V
    //   563: aload 24
    //   565: dload 19
    //   567: invokevirtual 236	com/baidu/location/BDLocation:setLongitude	(D)V
    //   570: aload 24
    //   572: ldc_w 398
    //   575: invokevirtual 241	com/baidu/location/BDLocation:setNetworkLocationType	(Ljava/lang/String;)V
    //   578: aload 24
    //   580: bipush 66
    //   582: invokevirtual 245	com/baidu/location/BDLocation:setLocType	(I)V
    //   585: aload 24
    //   587: areturn
    //   588: dload 67
    //   590: dconst_0
    //   591: dcmpg
    //   592: ifle +23 -> 615
    //   595: dload 69
    //   597: dconst_0
    //   598: dcmpg
    //   599: ifle +16 -> 615
    //   602: iload 71
    //   604: ifle +11 -> 615
    //   607: iload 71
    //   609: sipush 1000
    //   612: if_icmplt +31 -> 643
    //   615: aload 28
    //   617: invokeinterface 396 1 0
    //   622: pop
    //   623: goto -319 -> 304
    //   626: astore 27
    //   628: aload 28
    //   630: ifnull +10 -> 640
    //   633: aload 28
    //   635: invokeinterface 306 1 0
    //   640: aload 27
    //   642: athrow
    //   643: iload 8
    //   645: iconst_1
    //   646: if_icmpne +33 -> 679
    //   649: aload_0
    //   650: dload 6
    //   652: dload 4
    //   654: dload 69
    //   656: dload 67
    //   658: invokespecial 204	com/baidu/location/c/a:jdField_if	(DDDD)D
    //   661: ldc2_w 399
    //   664: dcmpl
    //   665: ifle +14 -> 679
    //   668: aload 28
    //   670: invokeinterface 396 1 0
    //   675: pop
    //   676: goto -372 -> 304
    //   679: bipush 100
    //   681: bipush 30
    //   683: aload_0
    //   684: getfield 110	com/baidu/location/c/a:jdField_long	Ljava/util/concurrent/ConcurrentHashMap;
    //   687: aload 66
    //   689: invokevirtual 391	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   692: checkcast 253	java/lang/Integer
    //   695: invokevirtual 351	java/lang/Integer:intValue	()I
    //   698: invokestatic 403	java/lang/Math:max	(II)I
    //   701: invokestatic 334	java/lang/Math:min	(II)I
    //   704: istore 78
    //   706: iload 78
    //   708: bipush 70
    //   710: if_icmple +71 -> 781
    //   713: dconst_1
    //   714: iload 78
    //   716: bipush 70
    //   718: isub
    //   719: i2d
    //   720: ldc2_w 404
    //   723: ddiv
    //   724: dadd
    //   725: dstore 79
    //   727: aload 33
    //   729: new 195	com/baidu/location/c/a$c
    //   732: dup
    //   733: dload 67
    //   735: dload 69
    //   737: dload 79
    //   739: ldc2_w 406
    //   742: ldc2_w 408
    //   745: iload 71
    //   747: i2d
    //   748: invokestatic 411	java/lang/Math:max	(DD)D
    //   751: ldc2_w 412
    //   754: invokestatic 416	java/lang/Math:pow	(DD)D
    //   757: dmul
    //   758: dmul
    //   759: invokestatic 419	java/lang/Math:exp	(D)D
    //   762: aconst_null
    //   763: invokespecial 422	com/baidu/location/c/a$c:<init>	(DDDLcom/baidu/location/c/a$1;)V
    //   766: invokevirtual 423	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   769: pop
    //   770: aload 28
    //   772: invokeinterface 396 1 0
    //   777: pop
    //   778: goto -474 -> 304
    //   781: dconst_1
    //   782: iload 78
    //   784: bipush 70
    //   786: isub
    //   787: i2d
    //   788: ldc2_w 408
    //   791: ddiv
    //   792: dadd
    //   793: dstore 79
    //   795: goto -68 -> 727
    //   798: aload_0
    //   799: aload 33
    //   801: ldc2_w 424
    //   804: invokespecial 427	com/baidu/location/c/a:jdField_if	(Ljava/util/ArrayList;D)I
    //   807: pop
    //   808: dconst_0
    //   809: dstore 35
    //   811: dconst_0
    //   812: dstore 37
    //   814: dconst_0
    //   815: dstore 39
    //   817: iconst_0
    //   818: istore 41
    //   820: aload 33
    //   822: invokevirtual 189	java/util/ArrayList:size	()I
    //   825: istore 42
    //   827: iload 41
    //   829: iload 42
    //   831: if_icmpge +93 -> 924
    //   834: aload 33
    //   836: iload 41
    //   838: invokevirtual 193	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   841: checkcast 195	com/baidu/location/c/a$c
    //   844: astore 43
    //   846: aload 43
    //   848: getfield 429	com/baidu/location/c/a$c:jdField_if	D
    //   851: dconst_0
    //   852: dcmpg
    //   853: ifgt +14 -> 867
    //   856: dload 39
    //   858: dstore 44
    //   860: dload 37
    //   862: dstore 46
    //   864: goto +479 -> 1343
    //   867: dload 35
    //   869: aload 43
    //   871: getfield 198	com/baidu/location/c/a$c:a	D
    //   874: aload 43
    //   876: getfield 429	com/baidu/location/c/a$c:jdField_if	D
    //   879: dmul
    //   880: dadd
    //   881: dstore 48
    //   883: dload 37
    //   885: aload 43
    //   887: getfield 200	com/baidu/location/c/a$c:jdField_do	D
    //   890: aload 43
    //   892: getfield 429	com/baidu/location/c/a$c:jdField_if	D
    //   895: dmul
    //   896: dadd
    //   897: dstore 50
    //   899: aload 43
    //   901: getfield 429	com/baidu/location/c/a$c:jdField_if	D
    //   904: dstore 52
    //   906: dload 52
    //   908: dload 39
    //   910: dadd
    //   911: dstore 44
    //   913: dload 50
    //   915: dstore 46
    //   917: dload 48
    //   919: dstore 35
    //   921: goto +422 -> 1343
    //   924: dload 39
    //   926: dconst_0
    //   927: dcmpl
    //   928: ifle +379 -> 1307
    //   931: dload 35
    //   933: dconst_0
    //   934: dcmpl
    //   935: ifle +372 -> 1307
    //   938: dload 37
    //   940: dconst_0
    //   941: dcmpl
    //   942: ifle +365 -> 1307
    //   945: dload 35
    //   947: dload 39
    //   949: ddiv
    //   950: dstore 19
    //   952: dload 37
    //   954: dload 39
    //   956: ddiv
    //   957: dstore 17
    //   959: iconst_1
    //   960: istore 22
    //   962: fconst_0
    //   963: fstore 61
    //   965: iconst_0
    //   966: istore 62
    //   968: iload 62
    //   970: aload 33
    //   972: invokevirtual 189	java/util/ArrayList:size	()I
    //   975: if_icmpge +54 -> 1029
    //   978: fload 61
    //   980: f2d
    //   981: aload_0
    //   982: dload 19
    //   984: dload 17
    //   986: aload 33
    //   988: iload 62
    //   990: invokevirtual 193	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   993: checkcast 195	com/baidu/location/c/a$c
    //   996: getfield 198	com/baidu/location/c/a$c:a	D
    //   999: aload 33
    //   1001: iload 62
    //   1003: invokevirtual 193	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1006: checkcast 195	com/baidu/location/c/a$c
    //   1009: getfield 200	com/baidu/location/c/a$c:jdField_do	D
    //   1012: invokespecial 204	com/baidu/location/c/a:jdField_if	(DDDD)D
    //   1015: dadd
    //   1016: d2f
    //   1017: fstore 65
    //   1019: iinc 62 1
    //   1022: fload 65
    //   1024: fstore 61
    //   1026: goto -58 -> 968
    //   1029: fload 61
    //   1031: aload 33
    //   1033: invokevirtual 189	java/util/ArrayList:size	()I
    //   1036: i2f
    //   1037: fdiv
    //   1038: invokestatic 433	java/lang/Math:round	(F)I
    //   1041: istore 64
    //   1043: iload 64
    //   1045: bipush 30
    //   1047: if_icmpge +131 -> 1178
    //   1050: iload 22
    //   1052: istore 56
    //   1054: dload 17
    //   1056: dstore 54
    //   1058: bipush 30
    //   1060: istore 57
    //   1062: iload 8
    //   1064: ifne +15 -> 1079
    //   1067: aload 33
    //   1069: invokevirtual 189	java/util/ArrayList:size	()I
    //   1072: iconst_1
    //   1073: if_icmpgt +6 -> 1079
    //   1076: iconst_0
    //   1077: istore 56
    //   1079: aload 33
    //   1081: invokevirtual 189	java/util/ArrayList:size	()I
    //   1084: iload_3
    //   1085: if_icmpge +27 -> 1112
    //   1088: dconst_1
    //   1089: aload 33
    //   1091: invokevirtual 189	java/util/ArrayList:size	()I
    //   1094: i2d
    //   1095: dmul
    //   1096: aload_1
    //   1097: invokevirtual 330	java/util/LinkedHashMap:size	()I
    //   1100: i2d
    //   1101: ddiv
    //   1102: ldc2_w 434
    //   1105: dcmpg
    //   1106: ifge +6 -> 1112
    //   1109: iconst_0
    //   1110: istore 56
    //   1112: iload 8
    //   1114: iconst_1
    //   1115: if_icmpne +162 -> 1277
    //   1118: iload 56
    //   1120: iconst_1
    //   1121: if_icmpne +156 -> 1277
    //   1124: aload_0
    //   1125: dload 6
    //   1127: dload 4
    //   1129: dload 54
    //   1131: dload 19
    //   1133: invokespecial 204	com/baidu/location/c/a:jdField_if	(DDDD)D
    //   1136: dstore 59
    //   1138: dload 59
    //   1140: ldc2_w 399
    //   1143: dcmpl
    //   1144: ifle +133 -> 1277
    //   1147: iconst_0
    //   1148: istore 22
    //   1150: iload 57
    //   1152: istore 23
    //   1154: dload 54
    //   1156: dstore 17
    //   1158: aload 28
    //   1160: ifnull -626 -> 534
    //   1163: aload 28
    //   1165: invokeinterface 306 1 0
    //   1170: goto -636 -> 534
    //   1173: astore 31
    //   1175: goto -641 -> 534
    //   1178: bipush 100
    //   1180: iload 64
    //   1182: if_icmpge +110 -> 1292
    //   1185: iload 22
    //   1187: istore 56
    //   1189: dload 17
    //   1191: dstore 54
    //   1193: bipush 100
    //   1195: istore 57
    //   1197: goto -135 -> 1062
    //   1200: aconst_null
    //   1201: areturn
    //   1202: astore 25
    //   1204: goto -670 -> 534
    //   1207: astore 29
    //   1209: goto -569 -> 640
    //   1212: astore 26
    //   1214: aload 26
    //   1216: astore 27
    //   1218: aconst_null
    //   1219: astore 28
    //   1221: goto -593 -> 628
    //   1224: astore 16
    //   1226: dconst_0
    //   1227: dstore 17
    //   1229: dconst_0
    //   1230: dstore 19
    //   1232: aconst_null
    //   1233: astore 21
    //   1235: iconst_0
    //   1236: istore 22
    //   1238: iconst_0
    //   1239: istore 23
    //   1241: goto -719 -> 522
    //   1244: astore 63
    //   1246: aload 28
    //   1248: astore 21
    //   1250: iconst_0
    //   1251: istore 23
    //   1253: goto -731 -> 522
    //   1256: astore 58
    //   1258: iload 56
    //   1260: istore 22
    //   1262: iload 57
    //   1264: istore 23
    //   1266: dload 54
    //   1268: dstore 17
    //   1270: aload 28
    //   1272: astore 21
    //   1274: goto -752 -> 522
    //   1277: iload 56
    //   1279: istore 22
    //   1281: iload 57
    //   1283: istore 23
    //   1285: dload 54
    //   1287: dstore 17
    //   1289: goto -131 -> 1158
    //   1292: iload 22
    //   1294: istore 56
    //   1296: dload 17
    //   1298: dstore 54
    //   1300: iload 64
    //   1302: istore 57
    //   1304: goto -242 -> 1062
    //   1307: dconst_0
    //   1308: dstore 54
    //   1310: dconst_0
    //   1311: dstore 19
    //   1313: iconst_0
    //   1314: istore 56
    //   1316: iconst_0
    //   1317: istore 57
    //   1319: goto -257 -> 1062
    //   1322: dconst_0
    //   1323: dstore 17
    //   1325: dconst_0
    //   1326: dstore 19
    //   1328: iconst_0
    //   1329: istore 22
    //   1331: iconst_0
    //   1332: istore 23
    //   1334: goto -176 -> 1158
    //   1337: iconst_0
    //   1338: istore 8
    //   1340: goto -1307 -> 33
    //   1343: iinc 41 1
    //   1346: dload 46
    //   1348: dstore 37
    //   1350: dload 44
    //   1352: dstore 39
    //   1354: goto -534 -> 820
    //
    // Exception table:
    //   from	to	target	type
    //   285	304	504	java/lang/Exception
    //   304	425	504	java/lang/Exception
    //   425	486	504	java/lang/Exception
    //   493	501	504	java/lang/Exception
    //   615	623	504	java/lang/Exception
    //   649	676	504	java/lang/Exception
    //   679	706	504	java/lang/Exception
    //   713	727	504	java/lang/Exception
    //   727	778	504	java/lang/Exception
    //   781	795	504	java/lang/Exception
    //   798	808	504	java/lang/Exception
    //   820	827	504	java/lang/Exception
    //   834	856	504	java/lang/Exception
    //   867	906	504	java/lang/Exception
    //   285	304	626	finally
    //   304	425	626	finally
    //   425	486	626	finally
    //   493	501	626	finally
    //   615	623	626	finally
    //   649	676	626	finally
    //   679	706	626	finally
    //   713	727	626	finally
    //   727	778	626	finally
    //   781	795	626	finally
    //   798	808	626	finally
    //   820	827	626	finally
    //   834	856	626	finally
    //   867	906	626	finally
    //   968	1019	626	finally
    //   1029	1043	626	finally
    //   1067	1076	626	finally
    //   1079	1109	626	finally
    //   1124	1138	626	finally
    //   1163	1170	1173	java/lang/Exception
    //   527	534	1202	java/lang/Exception
    //   633	640	1207	java/lang/Exception
    //   264	276	1212	finally
    //   264	276	1224	java/lang/Exception
    //   968	1019	1244	java/lang/Exception
    //   1029	1043	1244	java/lang/Exception
    //   1067	1076	1256	java/lang/Exception
    //   1079	1109	1256	java/lang/Exception
    //   1124	1138	1256	java/lang/Exception
  }

  private void jdField_if(BDLocation paramBDLocation1, BDLocation paramBDLocation2, BDLocation paramBDLocation3, String paramString, Long paramLong)
  {
    String str3;
    String str4;
    if ((paramBDLocation1 != null) && (paramBDLocation1.getLocType() == 161))
      if ((paramBDLocation2 != null) && (paramBDLocation1.getNetworkLocationType().equals("cl")) && (jdField_if(paramBDLocation2.getLatitude(), paramBDLocation2.getLongitude(), paramBDLocation1.getLatitude(), paramBDLocation1.getLongitude()) > 300.0D))
      {
        str3 = String.format(Locale.US, "UPDATE CL SET cl = 0 WHERE id = %d;", new Object[] { paramLong });
        Locale localLocale = Locale.US;
        Object[] arrayOfObject3 = new Object[3];
        arrayOfObject3[0] = paramLong;
        arrayOfObject3[1] = paramString;
        arrayOfObject3[2] = Integer.valueOf(100000);
        str4 = String.format(localLocale, "INSERT OR REPLACE INTO CL VALUES (%d,\"%s\",%d);", arrayOfObject3);
      }
    try
    {
      this.q.execSQL(str3);
      this.jdField_byte.execSQL(str4);
      label139: if ((paramBDLocation3 != null) && (paramBDLocation1.getNetworkLocationType().equals("wf")) && (jdField_if(paramBDLocation3.getLatitude(), paramBDLocation3.getLongitude(), paramBDLocation1.getLatitude(), paramBDLocation1.getLongitude()) > 100.0D));
      try
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = this.r.toString();
        String str1 = String.format("UPDATE AP SET cl = 0 WHERE id In (%s);", arrayOfObject1);
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.jdField_goto.toString();
        String str2 = String.format("INSERT OR REPLACE INTO AP VALUES %s;", arrayOfObject2);
        this.q.execSQL(str1);
        this.jdField_byte.execSQL(str2);
        return;
      }
      catch (Exception localException1)
      {
        return;
      }
    }
    catch (Exception localException2)
    {
      break label139;
    }
  }

  private void jdField_if(String paramString, Long paramLong, BDLocation paramBDLocation)
  {
    String str4;
    if (paramString != null)
    {
      if (paramBDLocation == null)
        break label95;
      str4 = String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", new Object[] { paramLong });
    }
    try
    {
      this.q.execSQL(str4);
      while (true)
      {
        label36: String str3;
        if (this.m)
        {
          Locale localLocale = Locale.US;
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = paramLong;
          arrayOfObject[1] = paramString;
          arrayOfObject[2] = Integer.valueOf(100000);
          str3 = String.format(localLocale, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",%d);", arrayOfObject);
        }
        try
        {
          this.jdField_byte.execSQL(str3);
          return;
          label95: String str1 = String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",0);", new Object[] { paramLong, paramString });
          String str2 = String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", new Object[] { paramLong });
          try
          {
            this.jdField_byte.execSQL(str1);
            this.jdField_byte.execSQL(str2);
          }
          catch (Exception localException1)
          {
          }
        }
        catch (Exception localException2)
        {
          return;
        }
      }
    }
    catch (Exception localException3)
    {
      break label36;
    }
  }

  private void jdField_if(String paramString1, String paramString2, String paramString3)
  {
    b.jdField_if(this.jdField_void, paramString1, paramString2, paramString3);
  }

  private void jdField_if(LinkedHashMap paramLinkedHashMap)
  {
    StringBuffer localStringBuffer1;
    StringBuffer localStringBuffer2;
    Iterator localIterator;
    int i1;
    int i2;
    if ((paramLinkedHashMap != null) && (paramLinkedHashMap.size() > 0))
    {
      this.r = new StringBuffer();
      this.jdField_goto = new StringBuffer();
      localStringBuffer1 = new StringBuffer();
      localStringBuffer2 = new StringBuffer();
      localIterator = this.jdField_long.keySet().iterator();
      i1 = 1;
      i2 = 1;
    }
    while (true)
    {
      if (localIterator.hasNext());
      try
      {
        Long localLong = (Long)localIterator.next();
        int i5;
        int i6;
        if (this.t.contains(localLong))
        {
          if (i2 != 0)
            i2 = 0;
          while (true)
          {
            this.r.append(localLong);
            String str4 = (String)this.jdField_do.get(localLong);
            this.jdField_goto.append('(').append(localLong).append(',').append('"').append(str4).append('"').append(',').append(100000).append(')');
            i5 = i1;
            i6 = i2;
            break;
            this.r.append(',');
            this.jdField_goto.append(',');
          }
        }
        String str5 = (String)this.jdField_do.get(localLong);
        if (i1 != 0)
          i1 = 0;
        while (true)
        {
          localStringBuffer1.append(localLong);
          localStringBuffer2.append('(').append(localLong).append(',').append('"').append(str5).append('"').append(",0)");
          i5 = i1;
          i6 = i2;
          break label480;
          localStringBuffer1.append(',');
          localStringBuffer2.append(',');
          continue;
          try
          {
            Locale localLocale = Locale.US;
            Object[] arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = this.r.toString();
            String str3 = String.format(localLocale, "UPDATE AP SET frequency=frequency+1 WHERE id IN(%s)", arrayOfObject3);
            this.q.execSQL(str3);
            label357: if (this.b.length() > 0)
            {
              if (localStringBuffer2.length() > 0)
                localStringBuffer2.append(",");
              localStringBuffer2.append(this.b);
            }
            try
            {
              Object[] arrayOfObject1 = new Object[1];
              arrayOfObject1[0] = localStringBuffer2.toString();
              String str1 = String.format("INSERT OR IGNORE INTO AP VALUES %s;", arrayOfObject1);
              Object[] arrayOfObject2 = new Object[1];
              arrayOfObject2[0] = localStringBuffer1.toString();
              String str2 = String.format("UPDATE AP SET frequency=frequency+1 WHERE id in (%s);", arrayOfObject2);
              if (localStringBuffer2.length() > 0)
                this.jdField_byte.execSQL(str1);
              if (localStringBuffer1.length() > 0)
                this.jdField_byte.execSQL(str2);
              return;
            }
            catch (Exception localException2)
            {
              return;
            }
          }
          catch (Exception localException1)
          {
            break label357;
          }
        }
        label480: i1 = i5;
        i2 = i6;
      }
      catch (Exception localException3)
      {
        int i3 = i1;
        int i4 = i2;
        i1 = i3;
        i2 = i4;
      }
    }
  }

  private void jdField_if(String[] paramArrayOfString)
  {
    this.o.jdField_new().jdField_int(paramArrayOfString);
  }

  void jdField_do()
  {
    if (this.q != null);
    try
    {
      this.q.close();
      label14: if (this.jdField_byte != null);
      try
      {
        this.jdField_byte.close();
        return;
      }
      catch (Exception localException1)
      {
        return;
      }
    }
    catch (Exception localException2)
    {
      break label14;
    }
  }

  void jdField_for()
  {
    this.x.aH();
  }

  Cursor jdField_if(c.a parama)
  {
    BDLocation localBDLocation1 = new BDLocation();
    localBDLocation1.setLocType(67);
    BDLocation localBDLocation4;
    BDLocation localBDLocation5;
    Double localDouble1;
    Double localDouble2;
    Double localDouble3;
    Double localDouble4;
    int i2;
    int i3;
    label356: int i4;
    label372: Double localDouble5;
    BDLocation localBDLocation2;
    label389: List localList1;
    label536: int i5;
    if (parama.jdField_new)
    {
      String str1 = parama.jdField_for;
      LinkedHashMap localLinkedHashMap = parama.jdField_if;
      int i1 = parama.jdField_do;
      BDLocation localBDLocation3 = parama.jdField_try;
      Long localLong = Long.valueOf(-9223372036854775808L);
      localBDLocation4 = null;
      if (str1 != null)
      {
        SQLiteDatabase localSQLiteDatabase2 = this.q;
        localBDLocation4 = null;
        if (localSQLiteDatabase2 != null)
        {
          localLong = Jni.I(str1);
          localBDLocation4 = null;
          if (localLong != null)
            localBDLocation4 = jdField_if(localLong);
        }
      }
      localBDLocation5 = null;
      if (localLinkedHashMap != null)
      {
        int i7 = localLinkedHashMap.size();
        localBDLocation5 = null;
        if (i7 > 0)
        {
          SQLiteDatabase localSQLiteDatabase1 = this.q;
          localBDLocation5 = null;
          if (localSQLiteDatabase1 != null)
          {
            this.jdField_long.clear();
            this.t.clear();
            this.jdField_do.clear();
            localBDLocation5 = jdField_if(localLinkedHashMap, localBDLocation4, i1);
          }
        }
      }
      localDouble1 = null;
      localDouble2 = null;
      if (localBDLocation4 != null)
      {
        localDouble2 = Double.valueOf(localBDLocation4.getLongitude());
        localDouble1 = Double.valueOf(localBDLocation4.getLatitude());
        double[] arrayOfDouble2 = Jni.jdField_if(localBDLocation4.getLongitude(), localBDLocation4.getLatitude(), "bd09ll2gcj");
        localBDLocation4.setCoorType("gcj");
        localBDLocation4.setLatitude(arrayOfDouble2[1]);
        localBDLocation4.setLongitude(arrayOfDouble2[0]);
        localBDLocation4.setNetworkLocationType("cl");
      }
      localDouble3 = null;
      localDouble4 = null;
      if (localBDLocation5 != null)
      {
        localDouble4 = Double.valueOf(localBDLocation5.getLongitude());
        localDouble3 = Double.valueOf(localBDLocation5.getLatitude());
        double[] arrayOfDouble1 = Jni.jdField_if(localBDLocation5.getLongitude(), localBDLocation5.getLatitude(), "bd09ll2gcj");
        localBDLocation5.setCoorType("gcj");
        localBDLocation5.setLatitude(arrayOfDouble1[1]);
        localBDLocation5.setLongitude(arrayOfDouble1[0]);
        localBDLocation5.setNetworkLocationType("wf");
      }
      if ((localBDLocation4 != null) && (localBDLocation5 == null))
      {
        i2 = 1;
        if (parama.jdField_do <= 0)
          break label810;
        i3 = 1;
        if ((localLinkedHashMap != null) && (localLinkedHashMap.size() > 0))
          break label816;
        i4 = 1;
        if (i3 == 0)
          break label846;
        if (localBDLocation5 == null)
          break label822;
        localDouble5 = localDouble4;
        localBDLocation2 = localBDLocation5;
        if ((parama.jdField_byte) && (this.o.jdField_new().B()) && (localDouble3 != null) && (localDouble5 != null))
          localBDLocation2.setAddr(this.o.l().jdField_do(localDouble5.doubleValue(), localDouble3.doubleValue()));
        if ((i3 != 0) && (parama.jdField_byte) && (localBDLocation2.getAddrStr() == null))
        {
          localDouble3 = null;
          localDouble5 = null;
          i2 = 0;
          localBDLocation2 = localBDLocation1;
        }
        if (((!parama.jdField_int) && (!parama.jdField_char)) || (localDouble3 == null) || (localDouble5 == null))
          break label887;
        List localList2 = this.o.l().jdField_if(localDouble5.doubleValue(), localDouble3.doubleValue());
        if (parama.jdField_int)
          localBDLocation2.setPoiList(localList2);
        localList1 = localList2;
        if ((i3 == 0) || (!parama.jdField_int) || ((localList1 != null) && (localList1.size() > 0)))
          break label880;
        i5 = 0;
        localBDLocation2 = localBDLocation1;
        label568: boolean bool = parama.jdField_char;
        String str2 = null;
        if (bool)
        {
          str2 = null;
          if (localList1 != null)
          {
            int i6 = localList1.size();
            str2 = null;
            if (i6 > 0)
            {
              Locale localLocale = Locale.CHINA;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = ((Poi)localList1.get(0)).getName();
              str2 = String.format(localLocale, "在%s附近", arrayOfObject);
              localBDLocation2.setLocationDescribe(str2);
            }
          }
        }
        if ((i3 != 0) && (parama.jdField_char) && (str2 == null))
        {
          i5 = 0;
          localBDLocation2 = localBDLocation1;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        String str3 = parama.jdField_else;
        String str4 = null;
        if (str3 != null)
        {
          localStringBuffer.append(parama.jdField_else);
          localStringBuffer.append(c.jdField_if(localBDLocation5, localBDLocation4, parama));
          localStringBuffer.append(c.jdField_if(localBDLocation2, i5));
          str4 = localStringBuffer.toString();
        }
        new a.1(this, str1, localLong, localBDLocation4, localBDLocation5, localBDLocation3, str4, localLinkedHashMap).start();
      }
    }
    while (true)
    {
      return c.jdField_if(localBDLocation2);
      if ((localBDLocation4 == null) && (localBDLocation5 != null))
      {
        i2 = 2;
        break;
      }
      i2 = 0;
      if (localBDLocation4 == null)
        break;
      i2 = 0;
      if (localBDLocation5 == null)
        break;
      i2 = 4;
      break;
      label810: i3 = 0;
      break label356;
      label816: i4 = 0;
      break label372;
      label822: if ((i4 != 0) && (localBDLocation4 != null))
      {
        localDouble3 = localDouble1;
        localBDLocation2 = localBDLocation4;
        localDouble5 = localDouble2;
        break label389;
        label846: if (localBDLocation5 != null)
        {
          localDouble5 = localDouble4;
          localBDLocation2 = localBDLocation5;
          break label389;
        }
        if (localBDLocation4 != null)
        {
          localDouble3 = localDouble1;
          localBDLocation2 = localBDLocation4;
          localDouble5 = localDouble2;
          break label389;
          label880: i5 = i2;
          break label568;
          label887: localList1 = null;
          break label536;
        }
      }
      localBDLocation2 = localBDLocation1;
      localDouble3 = null;
      localDouble5 = null;
      break label389;
      localBDLocation2 = localBDLocation1;
    }
  }

  SQLiteDatabase jdField_if()
  {
    return this.jdField_byte;
  }

  private class a extends Thread
  {
    private BDLocation jdField_byte;
    private BDLocation jdField_do;
    private Long jdField_for;
    private String jdField_if;
    private BDLocation jdField_int;
    private String jdField_new;
    private LinkedHashMap jdField_try;

    private a(String paramLong, Long paramBDLocation1, BDLocation paramBDLocation2, BDLocation paramBDLocation3, BDLocation paramString1, String paramLinkedHashMap, LinkedHashMap arg8)
    {
      this.jdField_new = paramLong;
      this.jdField_for = paramBDLocation1;
      this.jdField_byte = paramBDLocation2;
      this.jdField_int = paramBDLocation3;
      this.jdField_do = paramString1;
      this.jdField_if = paramLinkedHashMap;
      Object localObject;
      this.jdField_try = localObject;
    }

    public void run()
    {
      a.jdField_if(a.this, this.jdField_new, this.jdField_for, this.jdField_byte);
      a.jdField_if(a.this, null);
      a.jdField_do(a.this, null);
      a.jdField_if(a.this, this.jdField_try);
      a.jdField_if(a.this, this.jdField_do, this.jdField_byte, this.jdField_int, this.jdField_new, this.jdField_for);
      if (this.jdField_if != null)
        a.jdField_for(a.this).j().jdField_byte(this.jdField_if);
      this.jdField_try = null;
      this.jdField_new = null;
      this.jdField_if = null;
      this.jdField_for = null;
      this.jdField_byte = null;
      this.jdField_int = null;
      this.jdField_do = null;
    }
  }

  private final class b extends m
  {
    private static final String dA = "1";
    private static final String dE = "2";
    private static final int dm = 50;
    private static final String dq = "0";
    private static final long dt = 43200000L;
    private static final int dw = 2;
    private static final String dx = "3";
    private static final long dy = 86400000L;
    private static final int dz = 5;
    private a dB;
    private boolean dC = false;
    private long dD = -1L;
    private long dF = -1L;
    private String dn;
    private long dp = -1L;
    private int dr = 0;
    private String ds;
    private final String du;
    private long dv = -1L;

    b(a paramBoolean, boolean arg3)
    {
      this.dB = paramBoolean;
      int i;
      if (i != 0);
      for (this.du = "load"; ; this.du = "update")
      {
        this.c7 = new ArrayList();
        this.ds = d.ak;
        return;
      }
    }

    private String aA()
    {
      try
      {
        localJSONObject = new JSONObject();
      }
      catch (Exception localException2)
      {
        try
        {
          JSONObject localJSONObject;
          localJSONObject.put("type", "2");
          localJSONObject.put("ver", "1");
          localJSONObject.put("cuid", com.baidu.location.b.c.N().bm);
          localJSONObject.put("prod", com.baidu.location.b.c.bj + ":" + com.baidu.location.b.c.bn);
          this.dp = System.currentTimeMillis();
          while (true)
          {
            label80: String str = null;
            if (localJSONObject != null)
              str = Jni.G(localJSONObject.toString());
            return str;
            localException2 = localException2;
            localJSONObject = null;
          }
        }
        catch (Exception localException1)
        {
          break label80;
        }
      }
    }

    private String aB()
    {
      try
      {
        localJSONObject2 = a.jdMethod_for(a.this).l().H();
        if (localJSONObject2 != null)
          localJSONObject1 = new JSONObject();
      }
      catch (Exception localException1)
      {
        while (true)
        {
          try
          {
            JSONObject localJSONObject2;
            localJSONObject1.put("type", "3");
            localJSONObject1.put("ver", "1");
            localJSONObject1.put("cuid", com.baidu.location.b.c.N().bm);
            localJSONObject1.put("prod", com.baidu.location.b.c.bj + ":" + com.baidu.location.b.c.bn);
            localJSONObject1.put("rgc", localJSONObject2);
            this.dp = System.currentTimeMillis();
            String str = null;
            if (localJSONObject1 == null)
              continue;
            str = Jni.G(localJSONObject1.toString());
            return str;
            localException1 = localException1;
            localJSONObject1 = null;
            continue;
          }
          catch (Exception localException2)
          {
            continue;
          }
          JSONObject localJSONObject1 = null;
        }
      }
    }

    private void aC()
    {
      this.dr = (1 + this.dr);
      this.dD = System.currentTimeMillis();
    }

    private boolean aD()
    {
      if (this.dr < 2)
        return true;
      if (43200000L + this.dD < System.currentTimeMillis())
      {
        this.dr = 0;
        this.dD = -1L;
        return true;
      }
      return false;
    }

    private String aE()
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("type", "0");
        localJSONObject.put("cuid", com.baidu.location.b.c.N().bm);
        localJSONObject.put("ver", "1");
        localJSONObject.put("prod", com.baidu.location.b.c.bj + ":" + com.baidu.location.b.c.bn);
        String str = null;
        if (localJSONObject != null)
          str = Jni.G(localJSONObject.toString());
        return str;
      }
      catch (Exception localException)
      {
        while (true)
          JSONObject localJSONObject = null;
      }
    }

    // ERROR //
    private boolean aF()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: iconst_1
      //   3: istore_2
      //   4: aload_0
      //   5: getfield 48	com/baidu/location/c/a$b:dG	Lcom/baidu/location/c/a;
      //   8: invokestatic 174	com/baidu/location/c/a:do	(Lcom/baidu/location/c/a;)Landroid/database/sqlite/SQLiteDatabase;
      //   11: ldc 176
      //   13: aconst_null
      //   14: invokevirtual 182	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   17: astore 10
      //   19: aload 10
      //   21: astore 4
      //   23: aload_0
      //   24: getfield 48	com/baidu/location/c/a$b:dG	Lcom/baidu/location/c/a;
      //   27: invokestatic 174	com/baidu/location/c/a:do	(Lcom/baidu/location/c/a;)Landroid/database/sqlite/SQLiteDatabase;
      //   30: ldc 184
      //   32: aconst_null
      //   33: invokevirtual 182	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   36: astore_1
      //   37: aload 4
      //   39: ifnull +53 -> 92
      //   42: aload 4
      //   44: invokeinterface 189 1 0
      //   49: ifeq +43 -> 92
      //   52: aload_1
      //   53: ifnull +39 -> 92
      //   56: aload_1
      //   57: invokeinterface 189 1 0
      //   62: ifeq +30 -> 92
      //   65: aload 4
      //   67: iconst_0
      //   68: invokeinterface 193 2 0
      //   73: ifne +17 -> 90
      //   76: aload_1
      //   77: iconst_0
      //   78: invokeinterface 193 2 0
      //   83: istore 14
      //   85: iload 14
      //   87: ifeq +5 -> 92
      //   90: iconst_0
      //   91: istore_2
      //   92: aload 4
      //   94: ifnull +10 -> 104
      //   97: aload 4
      //   99: invokeinterface 196 1 0
      //   104: aload_1
      //   105: ifnull +9 -> 114
      //   108: aload_1
      //   109: invokeinterface 196 1 0
      //   114: iload_2
      //   115: ireturn
      //   116: astore 7
      //   118: aconst_null
      //   119: astore 4
      //   121: aload 4
      //   123: ifnull +10 -> 133
      //   126: aload 4
      //   128: invokeinterface 196 1 0
      //   133: aload_1
      //   134: ifnull -20 -> 114
      //   137: aload_1
      //   138: invokeinterface 196 1 0
      //   143: iload_2
      //   144: ireturn
      //   145: astore 8
      //   147: iload_2
      //   148: ireturn
      //   149: astore_3
      //   150: aconst_null
      //   151: astore 4
      //   153: aload 4
      //   155: ifnull +10 -> 165
      //   158: aload 4
      //   160: invokeinterface 196 1 0
      //   165: aload_1
      //   166: ifnull +9 -> 175
      //   169: aload_1
      //   170: invokeinterface 196 1 0
      //   175: aload_3
      //   176: athrow
      //   177: astore 13
      //   179: goto -75 -> 104
      //   182: astore 12
      //   184: iload_2
      //   185: ireturn
      //   186: astore 9
      //   188: goto -55 -> 133
      //   191: astore 6
      //   193: goto -28 -> 165
      //   196: astore 5
      //   198: goto -23 -> 175
      //   201: astore_3
      //   202: goto -49 -> 153
      //   205: astore 11
      //   207: goto -86 -> 121
      //
      // Exception table:
      //   from	to	target	type
      //   4	19	116	java/lang/Exception
      //   137	143	145	java/lang/Exception
      //   4	19	149	finally
      //   97	104	177	java/lang/Exception
      //   108	114	182	java/lang/Exception
      //   126	133	186	java/lang/Exception
      //   158	165	191	java/lang/Exception
      //   169	175	196	java/lang/Exception
      //   23	37	201	finally
      //   42	52	201	finally
      //   56	85	201	finally
      //   23	37	205	java/lang/Exception
      //   42	52	205	java/lang/Exception
      //   56	85	205	java/lang/Exception
    }

    // ERROR //
    private String aG()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: new 93	org/json/JSONObject
      //   5: dup
      //   6: invokespecial 94	org/json/JSONObject:<init>	()V
      //   9: astore_2
      //   10: new 93	org/json/JSONObject
      //   13: dup
      //   14: invokespecial 94	org/json/JSONObject:<init>	()V
      //   17: astore_3
      //   18: aload_0
      //   19: getfield 48	com/baidu/location/c/a$b:dG	Lcom/baidu/location/c/a;
      //   22: invokestatic 200	com/baidu/location/c/a:int	(Lcom/baidu/location/c/a;)Landroid/database/sqlite/SQLiteDatabase;
      //   25: astore 15
      //   27: iconst_3
      //   28: anewarray 202	java/lang/Object
      //   31: astore 16
      //   33: aload 16
      //   35: iconst_0
      //   36: ldc 204
      //   38: aastore
      //   39: aload 16
      //   41: iconst_1
      //   42: iconst_5
      //   43: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   46: aastore
      //   47: aload 16
      //   49: iconst_2
      //   50: bipush 50
      //   52: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   55: aastore
      //   56: aload 15
      //   58: ldc 212
      //   60: aload 16
      //   62: invokestatic 218	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   65: aconst_null
      //   66: invokevirtual 182	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   69: astore 17
      //   71: aload 17
      //   73: astore 5
      //   75: aload 5
      //   77: ifnull +575 -> 652
      //   80: aload 5
      //   82: invokeinterface 189 1 0
      //   87: ifeq +565 -> 652
      //   90: aload 5
      //   92: invokeinterface 222 1 0
      //   97: istore 37
      //   99: new 224	org/json/JSONArray
      //   102: dup
      //   103: invokespecial 225	org/json/JSONArray:<init>	()V
      //   106: astore 38
      //   108: aload 5
      //   110: invokeinterface 228 1 0
      //   115: ifne +150 -> 265
      //   118: aload 38
      //   120: aload 5
      //   122: iconst_1
      //   123: invokeinterface 232 2 0
      //   128: invokevirtual 235	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
      //   131: pop
      //   132: aload 5
      //   134: invokeinterface 238 1 0
      //   139: pop
      //   140: goto -32 -> 108
      //   143: astore 36
      //   145: aconst_null
      //   146: astore 6
      //   148: aload 6
      //   150: ifnull +10 -> 160
      //   153: aload 6
      //   155: invokeinterface 196 1 0
      //   160: aload 5
      //   162: ifnull +484 -> 646
      //   165: aload 5
      //   167: invokeinterface 196 1 0
      //   172: aload_3
      //   173: astore 7
      //   175: aload 7
      //   177: ifnull +463 -> 640
      //   180: aload 7
      //   182: ldc 240
      //   184: invokevirtual 244	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   187: ifne +453 -> 640
      //   190: aload_0
      //   191: getfield 65	com/baidu/location/c/a$b:dv	J
      //   194: ldc2_w 56
      //   197: lcmp
      //   198: ifeq +18 -> 216
      //   201: ldc2_w 28
      //   204: aload_0
      //   205: getfield 65	com/baidu/location/c/a$b:dv	J
      //   208: ladd
      //   209: invokestatic 139	java/lang/System:currentTimeMillis	()J
      //   212: lcmp
      //   213: ifge +427 -> 640
      //   216: aload 7
      //   218: invokevirtual 140	org/json/JSONObject:toString	()Ljava/lang/String;
      //   221: invokestatic 146	com/baidu/location/Jni:G	(Ljava/lang/String;)Ljava/lang/String;
      //   224: astore 9
      //   226: aload_0
      //   227: invokestatic 139	java/lang/System:currentTimeMillis	()J
      //   230: putfield 65	com/baidu/location/c/a$b:dv	J
      //   233: aload 9
      //   235: astore 8
      //   237: aload 7
      //   239: ifnull +23 -> 262
      //   242: aload 7
      //   244: ldc 240
      //   246: invokevirtual 244	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   249: ifeq +13 -> 262
      //   252: aload 7
      //   254: invokevirtual 140	org/json/JSONObject:toString	()Ljava/lang/String;
      //   257: invokestatic 146	com/baidu/location/Jni:G	(Ljava/lang/String;)Ljava/lang/String;
      //   260: astore 8
      //   262: aload 8
      //   264: areturn
      //   265: aload_2
      //   266: ldc 246
      //   268: aload 38
      //   270: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   273: pop
      //   274: iload 37
      //   276: istore 18
      //   278: aload_0
      //   279: getfield 48	com/baidu/location/c/a$b:dG	Lcom/baidu/location/c/a;
      //   282: invokestatic 200	com/baidu/location/c/a:int	(Lcom/baidu/location/c/a;)Landroid/database/sqlite/SQLiteDatabase;
      //   285: astore 19
      //   287: iconst_3
      //   288: anewarray 202	java/lang/Object
      //   291: astore 20
      //   293: aload 20
      //   295: iconst_0
      //   296: ldc 248
      //   298: aastore
      //   299: aload 20
      //   301: iconst_1
      //   302: iconst_5
      //   303: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   306: aastore
      //   307: aload 20
      //   309: iconst_2
      //   310: bipush 50
      //   312: invokestatic 210	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   315: aastore
      //   316: aload 19
      //   318: ldc 212
      //   320: aload 20
      //   322: invokestatic 218	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   325: aconst_null
      //   326: invokevirtual 182	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   329: astore 21
      //   331: aload 21
      //   333: astore 6
      //   335: iconst_0
      //   336: istore 22
      //   338: aload 6
      //   340: ifnull +82 -> 422
      //   343: aload 6
      //   345: invokeinterface 189 1 0
      //   350: istore 31
      //   352: iconst_0
      //   353: istore 22
      //   355: iload 31
      //   357: ifeq +65 -> 422
      //   360: aload 6
      //   362: invokeinterface 222 1 0
      //   367: istore 22
      //   369: new 224	org/json/JSONArray
      //   372: dup
      //   373: invokespecial 225	org/json/JSONArray:<init>	()V
      //   376: astore 32
      //   378: aload 6
      //   380: invokeinterface 228 1 0
      //   385: ifne +28 -> 413
      //   388: aload 32
      //   390: aload 6
      //   392: iconst_1
      //   393: invokeinterface 232 2 0
      //   398: invokevirtual 235	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
      //   401: pop
      //   402: aload 6
      //   404: invokeinterface 238 1 0
      //   409: pop
      //   410: goto -32 -> 378
      //   413: aload_2
      //   414: ldc 250
      //   416: aload 32
      //   418: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   421: pop
      //   422: aload_3
      //   423: ldc 96
      //   425: ldc 8
      //   427: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   430: pop
      //   431: aload_3
      //   432: ldc 104
      //   434: invokestatic 110	com/baidu/location/b/c:N	()Lcom/baidu/location/b/c;
      //   437: getfield 113	com/baidu/location/b/c:bm	Ljava/lang/String;
      //   440: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   443: pop
      //   444: aload_3
      //   445: ldc 102
      //   447: ldc 8
      //   449: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   452: pop
      //   453: aload_3
      //   454: ldc 115
      //   456: new 117	java/lang/StringBuilder
      //   459: dup
      //   460: invokespecial 118	java/lang/StringBuilder:<init>	()V
      //   463: getstatic 121	com/baidu/location/b/c:bj	Ljava/lang/String;
      //   466: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   469: ldc 127
      //   471: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   474: getstatic 130	com/baidu/location/b/c:bn	Ljava/lang/String;
      //   477: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   480: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   483: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   486: pop
      //   487: iload 18
      //   489: ifne +8 -> 497
      //   492: iload 22
      //   494: ifeq +11 -> 505
      //   497: aload_3
      //   498: ldc 240
      //   500: aload_2
      //   501: invokevirtual 100	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   504: pop
      //   505: aload 6
      //   507: ifnull +10 -> 517
      //   510: aload 6
      //   512: invokeinterface 196 1 0
      //   517: aload 5
      //   519: ifnull +127 -> 646
      //   522: aload 5
      //   524: invokeinterface 196 1 0
      //   529: aload_3
      //   530: astore 7
      //   532: goto -357 -> 175
      //   535: astore 28
      //   537: aload_3
      //   538: astore 7
      //   540: goto -365 -> 175
      //   543: astore 10
      //   545: aload_3
      //   546: astore 7
      //   548: goto -373 -> 175
      //   551: astore 12
      //   553: aconst_null
      //   554: astore 5
      //   556: aload_1
      //   557: ifnull +9 -> 566
      //   560: aload_1
      //   561: invokeinterface 196 1 0
      //   566: aload 5
      //   568: ifnull +10 -> 578
      //   571: aload 5
      //   573: invokeinterface 196 1 0
      //   578: aload 12
      //   580: athrow
      //   581: astore 29
      //   583: goto -66 -> 517
      //   586: astore 11
      //   588: goto -428 -> 160
      //   591: astore 14
      //   593: goto -27 -> 566
      //   596: astore 13
      //   598: goto -20 -> 578
      //   601: astore 12
      //   603: aconst_null
      //   604: astore_1
      //   605: goto -49 -> 556
      //   608: astore 12
      //   610: aload 6
      //   612: astore_1
      //   613: goto -57 -> 556
      //   616: astore 42
      //   618: aconst_null
      //   619: astore_3
      //   620: aconst_null
      //   621: astore 5
      //   623: aconst_null
      //   624: astore 6
      //   626: goto -478 -> 148
      //   629: astore 4
      //   631: aconst_null
      //   632: astore 5
      //   634: aconst_null
      //   635: astore 6
      //   637: goto -489 -> 148
      //   640: aconst_null
      //   641: astore 8
      //   643: goto -406 -> 237
      //   646: aload_3
      //   647: astore 7
      //   649: goto -474 -> 175
      //   652: iconst_0
      //   653: istore 18
      //   655: goto -377 -> 278
      //   658: astore 30
      //   660: goto -512 -> 148
      //
      // Exception table:
      //   from	to	target	type
      //   80	108	143	java/lang/Exception
      //   108	140	143	java/lang/Exception
      //   265	274	143	java/lang/Exception
      //   278	331	143	java/lang/Exception
      //   522	529	535	java/lang/Exception
      //   165	172	543	java/lang/Exception
      //   2	18	551	finally
      //   18	71	551	finally
      //   510	517	581	java/lang/Exception
      //   153	160	586	java/lang/Exception
      //   560	566	591	java/lang/Exception
      //   571	578	596	java/lang/Exception
      //   80	108	601	finally
      //   108	140	601	finally
      //   265	274	601	finally
      //   278	331	601	finally
      //   343	352	608	finally
      //   360	378	608	finally
      //   378	410	608	finally
      //   413	422	608	finally
      //   422	487	608	finally
      //   497	505	608	finally
      //   2	18	616	java/lang/Exception
      //   18	71	629	java/lang/Exception
      //   343	352	658	java/lang/Exception
      //   360	378	658	java/lang/Exception
      //   378	410	658	java/lang/Exception
      //   413	422	658	java/lang/Exception
      //   422	487	658	java/lang/Exception
      //   497	505	658	java/lang/Exception
    }

    private void az()
    {
      this.dn = null;
      if (aF())
      {
        if ((this.dF == -1L) || (86400000L + this.dF <= System.currentTimeMillis()))
          this.dn = aE();
        if ((this.dn == null) && ((this.dp == -1L) || (86400000L + this.dp <= System.currentTimeMillis())))
          if (!a.jdMethod_for(a.this).l().F())
            break label126;
      }
      label126: for (this.dn = aA(); ; this.dn = aB())
      {
        if (this.dn != null)
          ao();
        return;
        this.dn = aG();
        break;
      }
    }

    private void jdMethod_new(String paramString1, String paramString2, String paramString3)
    {
      this.dn = paramString3;
      this.ds = String.format("http://%s/%s", new Object[] { paramString1, paramString2 });
      ao();
    }

    void aH()
    {
      if ((aD()) && (!this.dC))
        a.jdMethod_if(a.this).az();
    }

    public void au()
    {
      this.dC = true;
      this.c5 = this.ds;
      this.c7.clear();
      this.c7.add(new BasicNameValuePair("qt", this.du));
      this.c7.add(new BasicNameValuePair("req", this.dn));
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.c6 != null))
      {
        new a.b.1(this).start();
        return;
      }
      this.dC = false;
      aC();
    }
  }

  private static final class c
  {
    double a;
    double jdField_do;
    double jdField_if;

    private c(double paramDouble1, double paramDouble2, double paramDouble3)
    {
      this.a = paramDouble1;
      this.jdField_do = paramDouble2;
      this.jdField_if = paramDouble3;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.a
 * JD-Core Version:    0.6.0
 */