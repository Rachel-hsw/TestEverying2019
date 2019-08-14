package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class t
{
  private static b bZ = l.av();
  private static Context ca = null;
  private static t cb = null;
  volatile int aI = 0;
  private String ab = "";
  private ac bW = null;
  private ac bX = null;
  com.tencent.wxop.stat.b.c bY = null;
  private f be = null;
  private String bq = "";
  private int cc = 0;
  private ConcurrentHashMap<d, String> cd = null;
  private boolean ce = false;
  private HashMap<String, String> cf = new HashMap();

  private t(Context paramContext)
  {
    try
    {
      this.be = new f();
      ca = paramContext.getApplicationContext();
      this.cd = new ConcurrentHashMap();
      this.ab = l.J(paramContext);
      this.bq = ("pri_" + l.J(paramContext));
      this.bW = new ac(ca, this.ab);
      this.bX = new ac(ca, this.bq);
      b(true);
      b(false);
      aj();
      t(ca);
      I();
      an();
      return;
    }
    catch (Throwable localThrowable)
    {
      bZ.b(localThrowable);
    }
  }

  // ERROR //
  private void I()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   4: invokevirtual 139	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc 141
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: invokevirtual 147	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore 4
    //   20: aload 4
    //   22: astore_2
    //   23: aload_2
    //   24: invokeinterface 153 1 0
    //   29: ifeq +115 -> 144
    //   32: aload_2
    //   33: iconst_0
    //   34: invokeinterface 157 2 0
    //   39: istore 5
    //   41: aload_2
    //   42: iconst_1
    //   43: invokeinterface 161 2 0
    //   48: astore 6
    //   50: aload_2
    //   51: iconst_2
    //   52: invokeinterface 161 2 0
    //   57: astore 7
    //   59: aload_2
    //   60: iconst_3
    //   61: invokeinterface 157 2 0
    //   66: istore 8
    //   68: new 163	com/tencent/wxop/stat/ah
    //   71: dup
    //   72: iload 5
    //   74: invokespecial 166	com/tencent/wxop/stat/ah:<init>	(I)V
    //   77: astore 9
    //   79: aload 9
    //   81: iload 5
    //   83: putfield 167	com/tencent/wxop/stat/ah:aI	I
    //   86: aload 9
    //   88: new 169	org/json/JSONObject
    //   91: dup
    //   92: aload 6
    //   94: invokespecial 170	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   97: putfield 174	com/tencent/wxop/stat/ah:df	Lorg/json/JSONObject;
    //   100: aload 9
    //   102: aload 7
    //   104: putfield 177	com/tencent/wxop/stat/ah:c	Ljava/lang/String;
    //   107: aload 9
    //   109: iload 8
    //   111: putfield 180	com/tencent/wxop/stat/ah:L	I
    //   114: getstatic 43	com/tencent/wxop/stat/t:ca	Landroid/content/Context;
    //   117: aload 9
    //   119: invokestatic 186	com/tencent/wxop/stat/c:a	(Landroid/content/Context;Lcom/tencent/wxop/stat/ah;)V
    //   122: goto -99 -> 23
    //   125: astore_1
    //   126: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   129: aload_1
    //   130: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   133: aload_2
    //   134: ifnull +9 -> 143
    //   137: aload_2
    //   138: invokeinterface 189 1 0
    //   143: return
    //   144: aload_2
    //   145: ifnull -2 -> 143
    //   148: aload_2
    //   149: invokeinterface 189 1 0
    //   154: return
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +9 -> 168
    //   162: aload_2
    //   163: invokeinterface 189 1 0
    //   168: aload_3
    //   169: athrow
    //   170: astore_3
    //   171: goto -13 -> 158
    //   174: astore_1
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -51 -> 126
    //
    // Exception table:
    //   from	to	target	type
    //   23	122	125	java/lang/Throwable
    //   0	20	155	finally
    //   23	122	170	finally
    //   126	133	170	finally
    //   0	20	174	java/lang/Throwable
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      if ((this.aI > 0) && (paramInt > 0))
      {
        boolean bool = e.a();
        if (!bool)
          break label26;
      }
      while (true)
      {
        return;
        label26: if (c.k())
          bZ.b("Load " + this.aI + " unsent events");
        ArrayList localArrayList = new ArrayList(paramInt);
        b(localArrayList, paramInt, paramBoolean);
        if (localArrayList.size() <= 0)
          continue;
        if (c.k())
          bZ.b("Peek " + localArrayList.size() + " unsent events.");
        a(localArrayList, 2, paramBoolean);
        ak.Z(ca).b(localArrayList, new aa(this, localArrayList, paramBoolean));
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
        bZ.b(localThrowable);
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  private void a(d paramd, aj paramaj, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 242	com/tencent/wxop/stat/c:s	()I
    //   8: ifle +269 -> 277
    //   11: getstatic 245	com/tencent/wxop/stat/c:ay	I
    //   14: istore 7
    //   16: iload 7
    //   18: ifle +12 -> 30
    //   21: iload_3
    //   22: ifne +8 -> 30
    //   25: iload 4
    //   27: ifeq +383 -> 410
    //   30: aload_0
    //   31: iload_3
    //   32: invokespecial 248	com/tencent/wxop/stat/t:c	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 251	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   42: iload_3
    //   43: ifne +47 -> 90
    //   46: aload_0
    //   47: getfield 65	com/tencent/wxop/stat/t:aI	I
    //   50: invokestatic 242	com/tencent/wxop/stat/c:s	()I
    //   53: if_icmple +37 -> 90
    //   56: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   59: ldc 253
    //   61: invokevirtual 256	com/tencent/wxop/stat/b/b:warn	(Ljava/lang/Object;)V
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 65	com/tencent/wxop/stat/t:aI	I
    //   69: aload_0
    //   70: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   73: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   76: ldc_w 261
    //   79: ldc_w 263
    //   82: aconst_null
    //   83: invokevirtual 267	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   86: isub
    //   87: putfield 65	com/tencent/wxop/stat/t:aI	I
    //   90: new 269	android/content/ContentValues
    //   93: dup
    //   94: invokespecial 270	android/content/ContentValues:<init>	()V
    //   97: astore 16
    //   99: aload_1
    //   100: invokevirtual 275	com/tencent/wxop/stat/a/d:af	()Ljava/lang/String;
    //   103: astore 17
    //   105: invokestatic 197	com/tencent/wxop/stat/c:k	()Z
    //   108: ifeq +27 -> 135
    //   111: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   114: new 96	java/lang/StringBuilder
    //   117: dup
    //   118: ldc_w 277
    //   121: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload 17
    //   126: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 207	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   135: aload 16
    //   137: ldc_w 279
    //   140: aload 17
    //   142: invokestatic 285	com/tencent/wxop/stat/b/r:q	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 16
    //   150: ldc_w 291
    //   153: ldc_w 293
    //   156: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload 16
    //   161: ldc_w 295
    //   164: iconst_1
    //   165: invokestatic 299	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   168: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload 16
    //   173: ldc_w 301
    //   176: aload_1
    //   177: invokevirtual 305	com/tencent/wxop/stat/a/d:ad	()J
    //   180: invokestatic 311	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   183: invokevirtual 314	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   186: aload 5
    //   188: ldc_w 261
    //   191: aconst_null
    //   192: aload 16
    //   194: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   197: lstore 11
    //   199: aload 5
    //   201: invokevirtual 321	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   204: aload 5
    //   206: ifnull +351 -> 557
    //   209: aload 5
    //   211: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   214: lload 11
    //   216: lstore 13
    //   218: lload 13
    //   220: lconst_0
    //   221: lcmp
    //   222: ifle +159 -> 381
    //   225: aload_0
    //   226: iconst_1
    //   227: aload_0
    //   228: getfield 65	com/tencent/wxop/stat/t:aI	I
    //   231: iadd
    //   232: putfield 65	com/tencent/wxop/stat/t:aI	I
    //   235: invokestatic 197	com/tencent/wxop/stat/c:k	()Z
    //   238: ifeq +29 -> 267
    //   241: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   244: new 96	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 326
    //   251: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: aload_1
    //   255: invokevirtual 275	com/tencent/wxop/stat/a/d:af	()Ljava/lang/String;
    //   258: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokevirtual 329	com/tencent/wxop/stat/b/b:e	(Ljava/lang/Object;)V
    //   267: aload_2
    //   268: ifnull +9 -> 277
    //   271: aload_2
    //   272: invokeinterface 334 1 0
    //   277: aload_0
    //   278: monitorexit
    //   279: return
    //   280: astore 18
    //   282: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   285: aload 18
    //   287: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   290: lload 11
    //   292: lstore 13
    //   294: goto -76 -> 218
    //   297: astore 10
    //   299: ldc2_w 335
    //   302: lstore 11
    //   304: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   307: aload 10
    //   309: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   312: aload 5
    //   314: ifnull +243 -> 557
    //   317: aload 5
    //   319: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   322: lload 11
    //   324: lstore 13
    //   326: goto -108 -> 218
    //   329: astore 15
    //   331: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   334: aload 15
    //   336: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   339: lload 11
    //   341: lstore 13
    //   343: goto -125 -> 218
    //   346: astore 8
    //   348: aload 5
    //   350: ifnull +8 -> 358
    //   353: aload 5
    //   355: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   358: aload 8
    //   360: athrow
    //   361: astore 6
    //   363: aload_0
    //   364: monitorexit
    //   365: aload 6
    //   367: athrow
    //   368: astore 9
    //   370: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   373: aload 9
    //   375: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   378: goto -20 -> 358
    //   381: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   384: new 96	java/lang/StringBuilder
    //   387: dup
    //   388: ldc_w 338
    //   391: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload_1
    //   395: invokevirtual 275	com/tencent/wxop/stat/a/d:af	()Ljava/lang/String;
    //   398: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokevirtual 341	com/tencent/wxop/stat/b/b:error	(Ljava/lang/Object;)V
    //   407: goto -130 -> 277
    //   410: getstatic 245	com/tencent/wxop/stat/c:ay	I
    //   413: ifle -136 -> 277
    //   416: invokestatic 197	com/tencent/wxop/stat/c:k	()Z
    //   419: ifeq +83 -> 502
    //   422: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   425: new 96	java/lang/StringBuilder
    //   428: dup
    //   429: ldc_w 343
    //   432: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   435: aload_0
    //   436: getfield 71	com/tencent/wxop/stat/t:cd	Ljava/util/concurrent/ConcurrentHashMap;
    //   439: invokevirtual 344	java/util/concurrent/ConcurrentHashMap:size	()I
    //   442: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc_w 346
    //   448: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: getstatic 245	com/tencent/wxop/stat/c:ay	I
    //   454: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   457: ldc_w 348
    //   460: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_0
    //   464: getfield 65	com/tencent/wxop/stat/t:aI	I
    //   467: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokevirtual 207	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   476: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   479: new 96	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 350
    //   486: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload_1
    //   490: invokevirtual 275	com/tencent/wxop/stat/a/d:af	()Ljava/lang/String;
    //   493: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokevirtual 207	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   502: aload_0
    //   503: getfield 71	com/tencent/wxop/stat/t:cd	Ljava/util/concurrent/ConcurrentHashMap;
    //   506: aload_1
    //   507: ldc 59
    //   509: invokevirtual 353	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   512: pop
    //   513: aload_0
    //   514: getfield 71	com/tencent/wxop/stat/t:cd	Ljava/util/concurrent/ConcurrentHashMap;
    //   517: invokevirtual 344	java/util/concurrent/ConcurrentHashMap:size	()I
    //   520: getstatic 245	com/tencent/wxop/stat/c:ay	I
    //   523: if_icmplt +7 -> 530
    //   526: aload_0
    //   527: invokespecial 356	com/tencent/wxop/stat/t:am	()V
    //   530: aload_2
    //   531: ifnull -254 -> 277
    //   534: aload_0
    //   535: getfield 71	com/tencent/wxop/stat/t:cd	Ljava/util/concurrent/ConcurrentHashMap;
    //   538: invokevirtual 344	java/util/concurrent/ConcurrentHashMap:size	()I
    //   541: ifle +7 -> 548
    //   544: aload_0
    //   545: invokespecial 356	com/tencent/wxop/stat/t:am	()V
    //   548: aload_2
    //   549: invokeinterface 334 1 0
    //   554: goto -277 -> 277
    //   557: lload 11
    //   559: lstore 13
    //   561: goto -343 -> 218
    //
    // Exception table:
    //   from	to	target	type
    //   209	214	280	java/lang/Throwable
    //   30	42	297	java/lang/Throwable
    //   46	90	297	java/lang/Throwable
    //   90	135	297	java/lang/Throwable
    //   135	204	297	java/lang/Throwable
    //   317	322	329	java/lang/Throwable
    //   30	42	346	finally
    //   46	90	346	finally
    //   90	135	346	finally
    //   135	204	346	finally
    //   304	312	346	finally
    //   5	16	361	finally
    //   209	214	361	finally
    //   225	267	361	finally
    //   271	277	361	finally
    //   282	290	361	finally
    //   317	322	361	finally
    //   331	339	361	finally
    //   353	358	361	finally
    //   358	361	361	finally
    //   370	378	361	finally
    //   381	407	361	finally
    //   410	502	361	finally
    //   502	530	361	finally
    //   534	548	361	finally
    //   548	554	361	finally
    //   353	358	368	java/lang/Throwable
  }

  // ERROR //
  private void a(ah paramah)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 174	com/tencent/wxop/stat/ah:df	Lorg/json/JSONObject;
    //   6: invokevirtual 360	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9: astore 8
    //   11: aload 8
    //   13: invokestatic 362	com/tencent/wxop/stat/b/l:t	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 9
    //   18: new 269	android/content/ContentValues
    //   21: dup
    //   22: invokespecial 270	android/content/ContentValues:<init>	()V
    //   25: astore 10
    //   27: aload 10
    //   29: ldc_w 279
    //   32: aload_1
    //   33: getfield 174	com/tencent/wxop/stat/ah:df	Lorg/json/JSONObject;
    //   36: invokevirtual 360	org/json/JSONObject:toString	()Ljava/lang/String;
    //   39: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload 10
    //   44: ldc_w 364
    //   47: aload 9
    //   49: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_1
    //   53: aload 9
    //   55: putfield 177	com/tencent/wxop/stat/ah:c	Ljava/lang/String;
    //   58: aload 10
    //   60: ldc_w 366
    //   63: aload_1
    //   64: getfield 180	com/tencent/wxop/stat/ah:L	I
    //   67: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: invokevirtual 372	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   73: aload_0
    //   74: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   77: invokevirtual 139	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   80: ldc 141
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: invokevirtual 147	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   91: astore 11
    //   93: aload 11
    //   95: astore_3
    //   96: aload_3
    //   97: invokeinterface 153 1 0
    //   102: ifeq +298 -> 400
    //   105: aload_3
    //   106: iconst_0
    //   107: invokeinterface 157 2 0
    //   112: aload_1
    //   113: getfield 167	com/tencent/wxop/stat/ah:aI	I
    //   116: if_icmpne -20 -> 96
    //   119: iconst_1
    //   120: istore 12
    //   122: aload_0
    //   123: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   126: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   129: invokevirtual 251	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   132: iconst_1
    //   133: iload 12
    //   135: if_icmpne +112 -> 247
    //   138: aload_0
    //   139: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   142: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   145: astore 13
    //   147: iconst_1
    //   148: anewarray 374	java/lang/String
    //   151: astore 14
    //   153: aload 14
    //   155: iconst_0
    //   156: aload_1
    //   157: getfield 167	com/tencent/wxop/stat/ah:aI	I
    //   160: invokestatic 299	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   163: aastore
    //   164: aload 13
    //   166: ldc 141
    //   168: aload 10
    //   170: ldc_w 376
    //   173: aload 14
    //   175: invokevirtual 380	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   178: i2l
    //   179: lstore 15
    //   181: lload 15
    //   183: ldc2_w 335
    //   186: lcmp
    //   187: ifne +95 -> 282
    //   190: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   193: new 96	java/lang/StringBuilder
    //   196: dup
    //   197: ldc_w 382
    //   200: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   203: aload 8
    //   205: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokevirtual 385	com/tencent/wxop/stat/b/b:d	(Ljava/lang/Object;)V
    //   214: aload_0
    //   215: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   218: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   221: invokevirtual 321	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   224: aload_3
    //   225: ifnull +9 -> 234
    //   228: aload_3
    //   229: invokeinterface 189 1 0
    //   234: aload_0
    //   235: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   238: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   241: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   244: aload_0
    //   245: monitorexit
    //   246: return
    //   247: aload 10
    //   249: ldc_w 387
    //   252: aload_1
    //   253: getfield 167	com/tencent/wxop/stat/ah:aI	I
    //   256: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: invokevirtual 372	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   262: aload_0
    //   263: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   266: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   269: ldc 141
    //   271: aconst_null
    //   272: aload 10
    //   274: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   277: lstore 15
    //   279: goto -98 -> 181
    //   282: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   285: new 96	java/lang/StringBuilder
    //   288: dup
    //   289: ldc_w 389
    //   292: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   295: aload 8
    //   297: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokevirtual 329	com/tencent/wxop/stat/b/b:e	(Ljava/lang/Object;)V
    //   306: goto -92 -> 214
    //   309: astore_2
    //   310: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   313: aload_2
    //   314: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   317: aload_3
    //   318: ifnull +9 -> 327
    //   321: aload_3
    //   322: invokeinterface 189 1 0
    //   327: aload_0
    //   328: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   331: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   334: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   337: goto -93 -> 244
    //   340: astore 7
    //   342: goto -98 -> 244
    //   345: astore 4
    //   347: aconst_null
    //   348: astore_3
    //   349: aload_3
    //   350: ifnull +9 -> 359
    //   353: aload_3
    //   354: invokeinterface 189 1 0
    //   359: aload_0
    //   360: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   363: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   366: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   369: aload 4
    //   371: athrow
    //   372: astore 6
    //   374: aload_0
    //   375: monitorexit
    //   376: aload 6
    //   378: athrow
    //   379: astore 5
    //   381: goto -12 -> 369
    //   384: astore 4
    //   386: goto -37 -> 349
    //   389: astore_2
    //   390: aconst_null
    //   391: astore_3
    //   392: goto -82 -> 310
    //   395: astore 17
    //   397: goto -153 -> 244
    //   400: iconst_0
    //   401: istore 12
    //   403: goto -281 -> 122
    //
    // Exception table:
    //   from	to	target	type
    //   96	119	309	java/lang/Throwable
    //   122	132	309	java/lang/Throwable
    //   138	181	309	java/lang/Throwable
    //   190	214	309	java/lang/Throwable
    //   214	224	309	java/lang/Throwable
    //   247	279	309	java/lang/Throwable
    //   282	306	309	java/lang/Throwable
    //   327	337	340	java/lang/Exception
    //   2	93	345	finally
    //   228	234	372	finally
    //   234	244	372	finally
    //   321	327	372	finally
    //   327	337	372	finally
    //   353	359	372	finally
    //   359	369	372	finally
    //   369	372	372	finally
    //   359	369	379	java/lang/Exception
    //   96	119	384	finally
    //   122	132	384	finally
    //   138	181	384	finally
    //   190	214	384	finally
    //   214	224	384	finally
    //   247	279	384	finally
    //   282	306	384	finally
    //   310	317	384	finally
    //   2	93	389	java/lang/Throwable
    //   234	244	395	java/lang/Exception
  }

  // ERROR //
  private void a(List<ad> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: invokeinterface 219 1 0
    //   11: istore 6
    //   13: iload 6
    //   15: ifne +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: iload_3
    //   22: ifne +180 -> 202
    //   25: invokestatic 433	com/tencent/wxop/stat/c:p	()I
    //   28: istore 19
    //   30: iload 19
    //   32: istore 8
    //   34: aload_0
    //   35: iload_3
    //   36: invokespecial 248	com/tencent/wxop/stat/t:c	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   39: astore 14
    //   41: aload 14
    //   43: astore 10
    //   45: iload_2
    //   46: iconst_2
    //   47: if_icmpne +167 -> 214
    //   50: new 96	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 435
    //   57: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: iload_2
    //   61: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc_w 437
    //   67: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokestatic 440	com/tencent/wxop/stat/t:b	(Ljava/util/List;)Ljava/lang/String;
    //   74: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 17
    //   82: invokestatic 197	com/tencent/wxop/stat/c:k	()Z
    //   85: ifeq +27 -> 112
    //   88: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   91: new 96	java/lang/StringBuilder
    //   94: dup
    //   95: ldc_w 442
    //   98: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload 17
    //   103: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokevirtual 207	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   112: aload 10
    //   114: invokevirtual 251	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   117: aload 10
    //   119: aload 17
    //   121: invokevirtual 445	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   124: aload 4
    //   126: ifnull +38 -> 164
    //   129: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   132: new 96	java/lang/StringBuilder
    //   135: dup
    //   136: ldc_w 447
    //   139: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: aload 4
    //   144: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 207	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   153: aload 10
    //   155: aload 4
    //   157: invokevirtual 445	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   160: aload_0
    //   161: invokespecial 121	com/tencent/wxop/stat/t:aj	()V
    //   164: aload 10
    //   166: invokevirtual 321	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   169: aload 10
    //   171: ifnull -153 -> 18
    //   174: aload 10
    //   176: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   179: goto -161 -> 18
    //   182: astore 18
    //   184: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   187: aload 18
    //   189: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   192: goto -174 -> 18
    //   195: astore 5
    //   197: aload_0
    //   198: monitorexit
    //   199: aload 5
    //   201: athrow
    //   202: invokestatic 450	com/tencent/wxop/stat/c:n	()I
    //   205: istore 7
    //   207: iload 7
    //   209: istore 8
    //   211: goto -177 -> 34
    //   214: new 96	java/lang/StringBuilder
    //   217: dup
    //   218: ldc_w 435
    //   221: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   224: iload_2
    //   225: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: ldc_w 452
    //   231: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_1
    //   235: invokestatic 440	com/tencent/wxop/stat/t:b	(Ljava/util/List;)Ljava/lang/String;
    //   238: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: astore 15
    //   246: aload_0
    //   247: getfield 69	com/tencent/wxop/stat/t:cc	I
    //   250: iconst_3
    //   251: irem
    //   252: istore 16
    //   254: aconst_null
    //   255: astore 4
    //   257: iload 16
    //   259: ifne +23 -> 282
    //   262: new 96	java/lang/StringBuilder
    //   265: dup
    //   266: ldc_w 454
    //   269: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: iload 8
    //   274: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: astore 4
    //   282: aload_0
    //   283: iconst_1
    //   284: aload_0
    //   285: getfield 69	com/tencent/wxop/stat/t:cc	I
    //   288: iadd
    //   289: putfield 69	com/tencent/wxop/stat/t:cc	I
    //   292: aload 15
    //   294: astore 17
    //   296: goto -214 -> 82
    //   299: astore 12
    //   301: aconst_null
    //   302: astore 10
    //   304: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   307: aload 12
    //   309: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   312: aload 10
    //   314: ifnull -296 -> 18
    //   317: aload 10
    //   319: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   322: goto -304 -> 18
    //   325: astore 13
    //   327: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   330: aload 13
    //   332: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   335: goto -317 -> 18
    //   338: astore 9
    //   340: aconst_null
    //   341: astore 10
    //   343: aload 10
    //   345: ifnull +8 -> 353
    //   348: aload 10
    //   350: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   353: aload 9
    //   355: athrow
    //   356: astore 11
    //   358: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   361: aload 11
    //   363: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   366: goto -13 -> 353
    //   369: astore 9
    //   371: goto -28 -> 343
    //   374: astore 12
    //   376: goto -72 -> 304
    //
    // Exception table:
    //   from	to	target	type
    //   174	179	182	java/lang/Throwable
    //   5	13	195	finally
    //   25	30	195	finally
    //   174	179	195	finally
    //   184	192	195	finally
    //   202	207	195	finally
    //   317	322	195	finally
    //   327	335	195	finally
    //   348	353	195	finally
    //   353	356	195	finally
    //   358	366	195	finally
    //   34	41	299	java/lang/Throwable
    //   317	322	325	java/lang/Throwable
    //   34	41	338	finally
    //   348	353	356	java/lang/Throwable
    //   50	82	369	finally
    //   82	112	369	finally
    //   112	124	369	finally
    //   129	164	369	finally
    //   164	169	369	finally
    //   214	254	369	finally
    //   262	282	369	finally
    //   282	292	369	finally
    //   304	312	369	finally
    //   50	82	374	java/lang/Throwable
    //   82	112	374	java/lang/Throwable
    //   112	124	374	java/lang/Throwable
    //   129	164	374	java/lang/Throwable
    //   164	169	374	java/lang/Throwable
    //   214	254	374	java/lang/Throwable
    //   262	282	374	java/lang/Throwable
    //   282	292	374	java/lang/Throwable
  }

  // ERROR //
  private void a(List<ad> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokeinterface 219 1 0
    //   10: istore 5
    //   12: iload 5
    //   14: ifne +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: invokestatic 197	com/tencent/wxop/stat/c:k	()Z
    //   23: ifeq +41 -> 64
    //   26: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   29: new 96	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 456
    //   36: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokeinterface 219 1 0
    //   45: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc_w 458
    //   51: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_2
    //   55: invokevirtual 409	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokevirtual 207	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   64: new 96	java/lang/StringBuilder
    //   67: dup
    //   68: iconst_3
    //   69: aload_1
    //   70: invokeinterface 219 1 0
    //   75: imul
    //   76: invokespecial 459	java/lang/StringBuilder:<init>	(I)V
    //   79: astore 6
    //   81: aload 6
    //   83: ldc_w 461
    //   86: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: invokeinterface 219 1 0
    //   96: istore 8
    //   98: aload_1
    //   99: invokeinterface 465 1 0
    //   104: astore 9
    //   106: iconst_0
    //   107: istore 10
    //   109: aload 9
    //   111: invokeinterface 470 1 0
    //   116: ifeq +43 -> 159
    //   119: aload 6
    //   121: aload 9
    //   123: invokeinterface 474 1 0
    //   128: checkcast 476	com/tencent/wxop/stat/ad
    //   131: getfield 479	com/tencent/wxop/stat/ad:K	J
    //   134: invokevirtual 482	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: iload 10
    //   140: iload 8
    //   142: iconst_1
    //   143: isub
    //   144: if_icmpeq +214 -> 358
    //   147: aload 6
    //   149: ldc_w 484
    //   152: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: goto +202 -> 358
    //   159: aload 6
    //   161: ldc_w 486
    //   164: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_0
    //   169: iload_2
    //   170: invokespecial 248	com/tencent/wxop/stat/t:c	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   173: astore_3
    //   174: aload_3
    //   175: invokevirtual 251	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   178: aload_3
    //   179: ldc_w 261
    //   182: aload 6
    //   184: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aconst_null
    //   188: invokevirtual 267	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   191: istore 16
    //   193: invokestatic 197	com/tencent/wxop/stat/c:k	()Z
    //   196: ifeq +52 -> 248
    //   199: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   202: new 96	java/lang/StringBuilder
    //   205: dup
    //   206: ldc_w 488
    //   209: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: iload 8
    //   214: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: ldc_w 490
    //   220: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload 6
    //   225: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 492
    //   234: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: iload 16
    //   239: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokevirtual 207	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   248: aload_0
    //   249: aload_0
    //   250: getfield 65	com/tencent/wxop/stat/t:aI	I
    //   253: iload 16
    //   255: isub
    //   256: putfield 65	com/tencent/wxop/stat/t:aI	I
    //   259: aload_3
    //   260: invokevirtual 321	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   263: aload_0
    //   264: invokespecial 121	com/tencent/wxop/stat/t:aj	()V
    //   267: aload_3
    //   268: ifnull -251 -> 17
    //   271: aload_3
    //   272: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   275: goto -258 -> 17
    //   278: astore 17
    //   280: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   283: aload 17
    //   285: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   288: goto -271 -> 17
    //   291: astore 4
    //   293: aload_0
    //   294: monitorexit
    //   295: aload 4
    //   297: athrow
    //   298: astore 14
    //   300: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   303: aload 14
    //   305: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   308: aload_3
    //   309: ifnull -292 -> 17
    //   312: aload_3
    //   313: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   316: goto -299 -> 17
    //   319: astore 15
    //   321: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   324: aload 15
    //   326: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   329: goto -312 -> 17
    //   332: astore 12
    //   334: aload_3
    //   335: ifnull +7 -> 342
    //   338: aload_3
    //   339: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   342: aload 12
    //   344: athrow
    //   345: astore 13
    //   347: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   350: aload 13
    //   352: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   355: goto -13 -> 342
    //   358: iinc 10 1
    //   361: goto -252 -> 109
    //
    // Exception table:
    //   from	to	target	type
    //   271	275	278	java/lang/Throwable
    //   4	12	291	finally
    //   20	64	291	finally
    //   64	106	291	finally
    //   109	138	291	finally
    //   147	156	291	finally
    //   159	168	291	finally
    //   271	275	291	finally
    //   280	288	291	finally
    //   312	316	291	finally
    //   321	329	291	finally
    //   338	342	291	finally
    //   342	345	291	finally
    //   347	355	291	finally
    //   168	248	298	java/lang/Throwable
    //   248	267	298	java/lang/Throwable
    //   312	316	319	java/lang/Throwable
    //   168	248	332	finally
    //   248	267	332	finally
    //   300	308	332	finally
    //   338	342	345	java/lang/Throwable
  }

  public static t ai()
  {
    return cb;
  }

  private void aj()
  {
    this.aI = (ak() + al());
  }

  private int ak()
  {
    return (int)DatabaseUtils.queryNumEntries(this.bW.getReadableDatabase(), "events");
  }

  private int al()
  {
    return (int)DatabaseUtils.queryNumEntries(this.bX.getReadableDatabase(), "events");
  }

  private void am()
  {
    SQLiteDatabase localSQLiteDatabase = null;
    if (this.ce)
      return;
    synchronized (this.cd)
    {
      if (this.cd.size() == 0)
        return;
    }
    this.ce = true;
    if (c.k())
      bZ.b("insert " + this.cd.size() + " events ,numEventsCachedInMemory:" + c.ay + ",numStoredEvents:" + this.aI);
    try
    {
      localSQLiteDatabase = this.bW.getWritableDatabase();
      localSQLiteDatabase.beginTransaction();
      Iterator localIterator = this.cd.entrySet().iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)((Map.Entry)localIterator.next()).getKey();
        ContentValues localContentValues = new ContentValues();
        String str = locald.af();
        if (c.k())
          bZ.b("insert content:" + str);
        localContentValues.put("content", r.q(str));
        localContentValues.put("send_count", "0");
        localContentValues.put("status", Integer.toString(1));
        localContentValues.put("timestamp", Long.valueOf(locald.ad()));
        localSQLiteDatabase.insert("events", null, localContentValues);
        localIterator.remove();
      }
    }
    catch (Throwable localThrowable2)
    {
      bZ.b(localThrowable2);
      if (localSQLiteDatabase != null);
      try
      {
        localSQLiteDatabase.endTransaction();
        aj();
        while (true)
        {
          this.ce = false;
          if (c.k())
            bZ.b("after insert, cacheEventsInMemory.size():" + this.cd.size() + ",numEventsCachedInMemory:" + c.ay + ",numStoredEvents:" + this.aI);
          monitorexit;
          return;
          localSQLiteDatabase.setTransactionSuccessful();
          if (localSQLiteDatabase == null)
            continue;
          try
          {
            localSQLiteDatabase.endTransaction();
            aj();
          }
          catch (Throwable localThrowable4)
          {
            bZ.b(localThrowable4);
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        while (true)
          bZ.b(localThrowable3);
      }
    }
    finally
    {
      if (localSQLiteDatabase == null);
    }
    try
    {
      localSQLiteDatabase.endTransaction();
      aj();
      throw localObject2;
    }
    catch (Throwable localThrowable1)
    {
      while (true)
        bZ.b(localThrowable1);
    }
  }

  // ERROR //
  private void an()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   4: invokevirtual 139	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 525
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 147	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 4
    //   21: aload 4
    //   23: astore_2
    //   24: aload_2
    //   25: invokeinterface 153 1 0
    //   30: ifeq +47 -> 77
    //   33: aload_0
    //   34: getfield 78	com/tencent/wxop/stat/t:cf	Ljava/util/HashMap;
    //   37: aload_2
    //   38: iconst_0
    //   39: invokeinterface 161 2 0
    //   44: aload_2
    //   45: iconst_1
    //   46: invokeinterface 161 2 0
    //   51: invokevirtual 526	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: goto -31 -> 24
    //   58: astore_1
    //   59: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   62: aload_1
    //   63: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   66: aload_2
    //   67: ifnull +9 -> 76
    //   70: aload_2
    //   71: invokeinterface 189 1 0
    //   76: return
    //   77: aload_2
    //   78: ifnull -2 -> 76
    //   81: aload_2
    //   82: invokeinterface 189 1 0
    //   87: return
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +9 -> 101
    //   95: aload_2
    //   96: invokeinterface 189 1 0
    //   101: aload_3
    //   102: athrow
    //   103: astore_3
    //   104: goto -13 -> 91
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_2
    //   110: goto -51 -> 59
    //
    // Exception table:
    //   from	to	target	type
    //   24	55	58	java/lang/Throwable
    //   0	21	88	finally
    //   24	55	103	finally
    //   59	66	103	finally
    //   0	21	107	java/lang/Throwable
  }

  private static String b(List<ad> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(3 * paramList.size());
    localStringBuilder.append("event_id in (");
    int i = paramList.size();
    Iterator localIterator = paramList.iterator();
    for (int j = 0; localIterator.hasNext(); j++)
    {
      localStringBuilder.append(((ad)localIterator.next()).K);
      if (j == i - 1)
        continue;
      localStringBuilder.append(",");
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  // ERROR //
  private void b(List<ad> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifne +230 -> 231
    //   4: aload_0
    //   5: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   8: invokevirtual 139	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore 9
    //   13: iconst_1
    //   14: anewarray 374	java/lang/String
    //   17: astore 10
    //   19: aload 10
    //   21: iconst_0
    //   22: iconst_1
    //   23: invokestatic 299	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   26: aastore
    //   27: aload 9
    //   29: ldc_w 261
    //   32: aconst_null
    //   33: ldc_w 529
    //   36: aload 10
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: iload_2
    //   42: invokestatic 299	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   45: invokevirtual 532	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore 11
    //   50: aload 11
    //   52: astore 7
    //   54: aload 7
    //   56: invokeinterface 153 1 0
    //   61: ifeq +186 -> 247
    //   64: aload 7
    //   66: iconst_0
    //   67: invokeinterface 536 2 0
    //   72: lstore 12
    //   74: aload 7
    //   76: iconst_1
    //   77: invokeinterface 161 2 0
    //   82: astore 14
    //   84: getstatic 538	com/tencent/wxop/stat/c:ad	Z
    //   87: ifne +10 -> 97
    //   90: aload 14
    //   92: invokestatic 539	com/tencent/wxop/stat/b/r:t	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 14
    //   97: aload 7
    //   99: iconst_2
    //   100: invokeinterface 157 2 0
    //   105: istore 15
    //   107: aload 7
    //   109: iconst_3
    //   110: invokeinterface 157 2 0
    //   115: istore 16
    //   117: new 476	com/tencent/wxop/stat/ad
    //   120: dup
    //   121: lload 12
    //   123: aload 14
    //   125: iload 15
    //   127: iload 16
    //   129: invokespecial 542	com/tencent/wxop/stat/ad:<init>	(JLjava/lang/String;II)V
    //   132: astore 17
    //   134: invokestatic 197	com/tencent/wxop/stat/c:k	()Z
    //   137: ifeq +55 -> 192
    //   140: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   143: new 96	java/lang/StringBuilder
    //   146: dup
    //   147: ldc_w 544
    //   150: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: lload 12
    //   155: invokevirtual 482	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   158: ldc_w 546
    //   161: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: iload 16
    //   166: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: ldc_w 548
    //   172: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 7
    //   177: iconst_4
    //   178: invokeinterface 536 2 0
    //   183: invokevirtual 482	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokevirtual 207	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   192: aload_1
    //   193: aload 17
    //   195: invokeinterface 552 2 0
    //   200: pop
    //   201: goto -147 -> 54
    //   204: astore 4
    //   206: aload 7
    //   208: astore 5
    //   210: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   213: aload 4
    //   215: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   218: aload 5
    //   220: ifnull +10 -> 230
    //   223: aload 5
    //   225: invokeinterface 189 1 0
    //   230: return
    //   231: aload_0
    //   232: getfield 55	com/tencent/wxop/stat/t:bX	Lcom/tencent/wxop/stat/ac;
    //   235: invokevirtual 139	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   238: astore 8
    //   240: aload 8
    //   242: astore 9
    //   244: goto -231 -> 13
    //   247: aload 7
    //   249: ifnull -19 -> 230
    //   252: aload 7
    //   254: invokeinterface 189 1 0
    //   259: return
    //   260: astore 6
    //   262: aconst_null
    //   263: astore 7
    //   265: aload 7
    //   267: ifnull +10 -> 277
    //   270: aload 7
    //   272: invokeinterface 189 1 0
    //   277: aload 6
    //   279: athrow
    //   280: astore 6
    //   282: goto -17 -> 265
    //   285: astore 6
    //   287: aload 5
    //   289: astore 7
    //   291: goto -26 -> 265
    //   294: astore 4
    //   296: aconst_null
    //   297: astore 5
    //   299: goto -89 -> 210
    //
    // Exception table:
    //   from	to	target	type
    //   54	97	204	java/lang/Throwable
    //   97	192	204	java/lang/Throwable
    //   192	201	204	java/lang/Throwable
    //   4	13	260	finally
    //   13	50	260	finally
    //   231	240	260	finally
    //   54	97	280	finally
    //   97	192	280	finally
    //   192	201	280	finally
    //   210	218	285	finally
    //   4	13	294	java/lang/Throwable
    //   13	50	294	java/lang/Throwable
    //   231	240	294	java/lang/Throwable
  }

  private void b(boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = null;
    try
    {
      localSQLiteDatabase = c(paramBoolean);
      localSQLiteDatabase.beginTransaction();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(1));
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(2L);
      int i = localSQLiteDatabase.update("events", localContentValues, "status=?", arrayOfString);
      if (c.k())
        bZ.b("update " + i + " unsent events.");
      localSQLiteDatabase.setTransactionSuccessful();
      if (localSQLiteDatabase != null);
      try
      {
        localSQLiteDatabase.endTransaction();
        return;
      }
      catch (Throwable localThrowable4)
      {
        bZ.b(localThrowable4);
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      do
        bZ.b(localThrowable2);
      while (localSQLiteDatabase == null);
      try
      {
        localSQLiteDatabase.endTransaction();
        return;
      }
      catch (Throwable localThrowable3)
      {
        bZ.b(localThrowable3);
        return;
      }
    }
    finally
    {
      if (localSQLiteDatabase == null);
    }
    try
    {
      localSQLiteDatabase.endTransaction();
      throw localObject;
    }
    catch (Throwable localThrowable1)
    {
      while (true)
        bZ.b(localThrowable1);
    }
  }

  private SQLiteDatabase c(boolean paramBoolean)
  {
    if (!paramBoolean)
      return this.bW.getWritableDatabase();
    return this.bX.getWritableDatabase();
  }

  public static t s(Context paramContext)
  {
    if (cb == null)
      monitorenter;
    try
    {
      if (cb == null)
        cb = new t(paramContext);
      return cb;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  final void H()
  {
    if (!c.l())
      return;
    try
    {
      this.be.a(new w(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      bZ.b(localThrowable);
    }
  }

  final void b(int paramInt)
  {
    this.be.a(new ab(this, paramInt));
  }

  final void b(d paramd, aj paramaj, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.be != null)
      this.be.a(new x(this, paramd, paramaj, paramBoolean1, paramBoolean2));
  }

  final void b(ah paramah)
  {
    if (paramah == null)
      return;
    this.be.a(new y(this, paramah));
  }

  final void b(List<ad> paramList, boolean paramBoolean)
  {
    if (this.be != null)
      this.be.a(new u(this, paramList, paramBoolean));
  }

  final void c(List<ad> paramList, boolean paramBoolean)
  {
    if (this.be != null)
      this.be.a(new v(this, paramList, paramBoolean));
  }

  public final int r()
  {
    return this.aI;
  }

  // ERROR //
  public final com.tencent.wxop.stat.b.c t(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/wxop/stat/t:bY	Lcom/tencent/wxop/stat/b/c;
    //   6: ifnull +14 -> 20
    //   9: aload_0
    //   10: getfield 67	com/tencent/wxop/stat/t:bY	Lcom/tencent/wxop/stat/b/c;
    //   13: astore 9
    //   15: aload_0
    //   16: monitorexit
    //   17: aload 9
    //   19: areturn
    //   20: aload_0
    //   21: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   24: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   27: invokevirtual 251	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   30: invokestatic 197	com/tencent/wxop/stat/c:k	()Z
    //   33: ifeq +12 -> 45
    //   36: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   39: ldc_w 594
    //   42: invokevirtual 207	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   45: aload_0
    //   46: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   49: invokevirtual 139	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   52: ldc_w 596
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 532	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 10
    //   67: aload 10
    //   69: astore 4
    //   71: aload 4
    //   73: invokeinterface 153 1 0
    //   78: istore 11
    //   80: iconst_0
    //   81: istore 12
    //   83: iload 11
    //   85: ifeq +362 -> 447
    //   88: aload 4
    //   90: iconst_0
    //   91: invokeinterface 161 2 0
    //   96: astore 13
    //   98: aload 13
    //   100: invokestatic 539	com/tencent/wxop/stat/b/r:t	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 14
    //   105: aload 4
    //   107: iconst_1
    //   108: invokeinterface 157 2 0
    //   113: istore 15
    //   115: aload 4
    //   117: iconst_2
    //   118: invokeinterface 161 2 0
    //   123: astore 16
    //   125: aload 4
    //   127: iconst_3
    //   128: invokeinterface 536 2 0
    //   133: lstore 17
    //   135: invokestatic 601	java/lang/System:currentTimeMillis	()J
    //   138: ldc2_w 602
    //   141: ldiv
    //   142: lstore 19
    //   144: iload 15
    //   146: iconst_1
    //   147: if_icmpeq +746 -> 893
    //   150: lload 17
    //   152: ldc2_w 602
    //   155: lmul
    //   156: invokestatic 605	com/tencent/wxop/stat/b/l:d	(J)Ljava/lang/String;
    //   159: ldc2_w 602
    //   162: lload 19
    //   164: lmul
    //   165: invokestatic 605	com/tencent/wxop/stat/b/l:d	(J)Ljava/lang/String;
    //   168: invokevirtual 608	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +722 -> 893
    //   174: iconst_1
    //   175: istore 21
    //   177: aload 16
    //   179: aload_1
    //   180: invokestatic 611	com/tencent/wxop/stat/b/l:G	(Landroid/content/Context;)Ljava/lang/String;
    //   183: invokevirtual 608	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifne +700 -> 886
    //   189: iload 21
    //   191: iconst_2
    //   192: ior
    //   193: istore 22
    //   195: aload 14
    //   197: ldc_w 484
    //   200: invokevirtual 615	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   203: astore 23
    //   205: aload 23
    //   207: ifnull +444 -> 651
    //   210: aload 23
    //   212: arraylength
    //   213: ifle +438 -> 651
    //   216: aload 23
    //   218: iconst_0
    //   219: aaload
    //   220: astore 43
    //   222: aload 43
    //   224: ifnull +13 -> 237
    //   227: aload 43
    //   229: invokevirtual 618	java/lang/String:length	()I
    //   232: bipush 11
    //   234: if_icmpge +638 -> 872
    //   237: aload_1
    //   238: invokestatic 620	com/tencent/wxop/stat/b/r:b	(Landroid/content/Context;)Ljava/lang/String;
    //   241: astore 44
    //   243: aload 44
    //   245: ifnull +617 -> 862
    //   248: aload 44
    //   250: invokevirtual 618	java/lang/String:length	()I
    //   253: bipush 10
    //   255: if_icmple +607 -> 862
    //   258: iconst_1
    //   259: istore 25
    //   261: goto +639 -> 900
    //   264: aload 23
    //   266: ifnull +401 -> 667
    //   269: aload 23
    //   271: arraylength
    //   272: iconst_2
    //   273: if_icmplt +394 -> 667
    //   276: aload 23
    //   278: iconst_1
    //   279: aaload
    //   280: astore 27
    //   282: new 96	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 621	java/lang/StringBuilder:<init>	()V
    //   289: aload 26
    //   291: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc_w 484
    //   297: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 27
    //   302: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: astore 24
    //   310: aload_0
    //   311: new 623	com/tencent/wxop/stat/b/c
    //   314: dup
    //   315: aload 26
    //   317: aload 27
    //   319: iload 22
    //   321: invokespecial 626	com/tencent/wxop/stat/b/c:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   324: putfield 67	com/tencent/wxop/stat/t:bY	Lcom/tencent/wxop/stat/b/c;
    //   327: new 269	android/content/ContentValues
    //   330: dup
    //   331: invokespecial 270	android/content/ContentValues:<init>	()V
    //   334: astore 29
    //   336: aload 29
    //   338: ldc_w 628
    //   341: aload 24
    //   343: invokestatic 285	com/tencent/wxop/stat/b/r:q	(Ljava/lang/String;)Ljava/lang/String;
    //   346: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload 29
    //   351: ldc_w 630
    //   354: iload 22
    //   356: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: invokevirtual 372	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   362: aload 29
    //   364: ldc_w 632
    //   367: aload_1
    //   368: invokestatic 611	com/tencent/wxop/stat/b/l:G	(Landroid/content/Context;)Ljava/lang/String;
    //   371: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload 29
    //   376: ldc_w 634
    //   379: lload 19
    //   381: invokestatic 311	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   384: invokevirtual 314	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   387: iload 25
    //   389: ifeq +31 -> 420
    //   392: aload_0
    //   393: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   396: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   399: ldc_w 596
    //   402: aload 29
    //   404: ldc_w 636
    //   407: iconst_1
    //   408: anewarray 374	java/lang/String
    //   411: dup
    //   412: iconst_0
    //   413: aload 13
    //   415: aastore
    //   416: invokevirtual 380	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   419: pop
    //   420: iload 22
    //   422: iload 15
    //   424: if_icmpeq +487 -> 911
    //   427: aload_0
    //   428: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   431: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   434: ldc_w 596
    //   437: aconst_null
    //   438: aload 29
    //   440: invokevirtual 639	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   443: pop2
    //   444: goto +467 -> 911
    //   447: iload 12
    //   449: ifne +161 -> 610
    //   452: aload_1
    //   453: invokestatic 641	com/tencent/wxop/stat/b/l:c	(Landroid/content/Context;)Ljava/lang/String;
    //   456: astore 33
    //   458: aload_1
    //   459: invokestatic 644	com/tencent/wxop/stat/b/l:w	(Landroid/content/Context;)Ljava/lang/String;
    //   462: astore 34
    //   464: aload 34
    //   466: ifnull +389 -> 855
    //   469: aload 34
    //   471: invokevirtual 618	java/lang/String:length	()I
    //   474: ifle +381 -> 855
    //   477: new 96	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 621	java/lang/StringBuilder:<init>	()V
    //   484: aload 33
    //   486: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: ldc_w 484
    //   492: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 34
    //   497: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: astore 35
    //   505: invokestatic 601	java/lang/System:currentTimeMillis	()J
    //   508: ldc2_w 602
    //   511: ldiv
    //   512: lstore 36
    //   514: aload_1
    //   515: invokestatic 611	com/tencent/wxop/stat/b/l:G	(Landroid/content/Context;)Ljava/lang/String;
    //   518: astore 38
    //   520: new 269	android/content/ContentValues
    //   523: dup
    //   524: invokespecial 270	android/content/ContentValues:<init>	()V
    //   527: astore 39
    //   529: aload 39
    //   531: ldc_w 628
    //   534: aload 35
    //   536: invokestatic 285	com/tencent/wxop/stat/b/r:q	(Ljava/lang/String;)Ljava/lang/String;
    //   539: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   542: aload 39
    //   544: ldc_w 630
    //   547: iconst_0
    //   548: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   551: invokevirtual 372	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   554: aload 39
    //   556: ldc_w 632
    //   559: aload 38
    //   561: invokevirtual 289	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload 39
    //   566: ldc_w 634
    //   569: lload 36
    //   571: invokestatic 311	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   574: invokevirtual 314	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   577: aload_0
    //   578: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   581: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   584: ldc_w 596
    //   587: aconst_null
    //   588: aload 39
    //   590: invokevirtual 318	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   593: pop2
    //   594: aload_0
    //   595: new 623	com/tencent/wxop/stat/b/c
    //   598: dup
    //   599: aload 33
    //   601: aload 34
    //   603: iconst_0
    //   604: invokespecial 626	com/tencent/wxop/stat/b/c:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   607: putfield 67	com/tencent/wxop/stat/t:bY	Lcom/tencent/wxop/stat/b/c;
    //   610: aload_0
    //   611: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   614: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   617: invokevirtual 321	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   620: aload 4
    //   622: ifnull +10 -> 632
    //   625: aload 4
    //   627: invokeinterface 189 1 0
    //   632: aload_0
    //   633: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   636: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   639: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   642: aload_0
    //   643: getfield 67	com/tencent/wxop/stat/t:bY	Lcom/tencent/wxop/stat/b/c;
    //   646: astore 9
    //   648: goto -633 -> 15
    //   651: aload_1
    //   652: invokestatic 641	com/tencent/wxop/stat/b/l:c	(Landroid/content/Context;)Ljava/lang/String;
    //   655: astore 24
    //   657: iconst_1
    //   658: istore 25
    //   660: aload 24
    //   662: astore 26
    //   664: goto -400 -> 264
    //   667: aload_1
    //   668: invokestatic 644	com/tencent/wxop/stat/b/l:w	(Landroid/content/Context;)Ljava/lang/String;
    //   671: astore 27
    //   673: aload 27
    //   675: ifnull -365 -> 310
    //   678: aload 27
    //   680: invokevirtual 618	java/lang/String:length	()I
    //   683: ifle -373 -> 310
    //   686: new 96	java/lang/StringBuilder
    //   689: dup
    //   690: invokespecial 621	java/lang/StringBuilder:<init>	()V
    //   693: aload 26
    //   695: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 484
    //   701: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 27
    //   706: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: astore 28
    //   714: aload 28
    //   716: astore 24
    //   718: iconst_1
    //   719: istore 25
    //   721: goto -411 -> 310
    //   724: astore 42
    //   726: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   729: aload 42
    //   731: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   734: goto -92 -> 642
    //   737: astore_2
    //   738: aload_0
    //   739: monitorexit
    //   740: aload_2
    //   741: athrow
    //   742: astore 6
    //   744: aconst_null
    //   745: astore 7
    //   747: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   750: aload 6
    //   752: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   755: aload 7
    //   757: ifnull +10 -> 767
    //   760: aload 7
    //   762: invokeinterface 189 1 0
    //   767: aload_0
    //   768: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   771: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   774: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   777: goto -135 -> 642
    //   780: astore 8
    //   782: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   785: aload 8
    //   787: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   790: goto -148 -> 642
    //   793: astore_3
    //   794: aconst_null
    //   795: astore 4
    //   797: aload 4
    //   799: ifnull +10 -> 809
    //   802: aload 4
    //   804: invokeinterface 189 1 0
    //   809: aload_0
    //   810: getfield 53	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   813: invokevirtual 259	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   816: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   819: aload_3
    //   820: athrow
    //   821: astore 5
    //   823: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   826: aload 5
    //   828: invokevirtual 135	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   831: goto -12 -> 819
    //   834: astore_3
    //   835: goto -38 -> 797
    //   838: astore_3
    //   839: aload 7
    //   841: astore 4
    //   843: goto -46 -> 797
    //   846: astore 6
    //   848: aload 4
    //   850: astore 7
    //   852: goto -105 -> 747
    //   855: aload 33
    //   857: astore 35
    //   859: goto -354 -> 505
    //   862: aload 43
    //   864: astore 44
    //   866: iconst_0
    //   867: istore 25
    //   869: goto +31 -> 900
    //   872: aload 14
    //   874: astore 24
    //   876: aload 43
    //   878: astore 26
    //   880: iconst_0
    //   881: istore 25
    //   883: goto -619 -> 264
    //   886: iload 21
    //   888: istore 22
    //   890: goto -695 -> 195
    //   893: iload 15
    //   895: istore 21
    //   897: goto -720 -> 177
    //   900: aload 14
    //   902: astore 24
    //   904: aload 44
    //   906: astore 26
    //   908: goto -644 -> 264
    //   911: iconst_1
    //   912: istore 12
    //   914: goto -467 -> 447
    //
    // Exception table:
    //   from	to	target	type
    //   625	632	724	java/lang/Throwable
    //   632	642	724	java/lang/Throwable
    //   2	15	737	finally
    //   625	632	737	finally
    //   632	642	737	finally
    //   642	648	737	finally
    //   726	734	737	finally
    //   760	767	737	finally
    //   767	777	737	finally
    //   782	790	737	finally
    //   802	809	737	finally
    //   809	819	737	finally
    //   819	821	737	finally
    //   823	831	737	finally
    //   20	45	742	java/lang/Throwable
    //   45	67	742	java/lang/Throwable
    //   760	767	780	java/lang/Throwable
    //   767	777	780	java/lang/Throwable
    //   20	45	793	finally
    //   45	67	793	finally
    //   802	809	821	java/lang/Throwable
    //   809	819	821	java/lang/Throwable
    //   71	80	834	finally
    //   88	144	834	finally
    //   150	174	834	finally
    //   177	189	834	finally
    //   195	205	834	finally
    //   210	222	834	finally
    //   227	237	834	finally
    //   237	243	834	finally
    //   248	258	834	finally
    //   269	310	834	finally
    //   310	387	834	finally
    //   392	420	834	finally
    //   427	444	834	finally
    //   452	464	834	finally
    //   469	505	834	finally
    //   505	610	834	finally
    //   610	620	834	finally
    //   651	657	834	finally
    //   667	673	834	finally
    //   678	714	834	finally
    //   747	755	838	finally
    //   71	80	846	java/lang/Throwable
    //   88	144	846	java/lang/Throwable
    //   150	174	846	java/lang/Throwable
    //   177	189	846	java/lang/Throwable
    //   195	205	846	java/lang/Throwable
    //   210	222	846	java/lang/Throwable
    //   227	237	846	java/lang/Throwable
    //   237	243	846	java/lang/Throwable
    //   248	258	846	java/lang/Throwable
    //   269	310	846	java/lang/Throwable
    //   310	387	846	java/lang/Throwable
    //   392	420	846	java/lang/Throwable
    //   427	444	846	java/lang/Throwable
    //   452	464	846	java/lang/Throwable
    //   469	505	846	java/lang/Throwable
    //   505	610	846	java/lang/Throwable
    //   610	620	846	java/lang/Throwable
    //   651	657	846	java/lang/Throwable
    //   667	673	846	java/lang/Throwable
    //   678	714	846	java/lang/Throwable
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.t
 * JD-Core Version:    0.6.0
 */