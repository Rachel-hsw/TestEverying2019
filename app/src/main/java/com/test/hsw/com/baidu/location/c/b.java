package com.baidu.location.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.o;
import com.baidu.location.e.m;
import com.baidu.location.h.h;
import com.baidu.location.h.j;
import com.baidu.location.h.l;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

public final class b
  implements com.baidu.location.b.f
{
  private static final int ff = 10000;
  private static b fh = null;
  private static final String fj = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata/";
  private static final int fk = 6;
  private static final String fp = "bdcltb09";
  private static final String fu = "wof";
  private static final int fw = 2000;
  private Handler fg = new Handler();
  private double fi = 0.0D;
  private double fl = 0.0D;
  private double fm = 0.0D;
  private String fn = null;
  private boolean fo = false;
  private volatile boolean fq = false;
  private double fr = 0.0D;
  private double fs = 0.0D;
  private String ft = Environment.getExternalStorageDirectory().getPath() + "/baidu/tempdata" + "/ls.db";
  private boolean fv = false;

  private b()
  {
    try
    {
      File localFile1 = new File(fj);
      File localFile2 = new File(this.ft);
      if (!localFile1.exists())
        localFile1.mkdirs();
      if (!localFile2.exists())
        localFile2.createNewFile();
      if (localFile2.exists())
      {
        SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(localFile2, null);
        localSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS bdcltb09(id CHAR(40) PRIMARY KEY,time DOUBLE,tag DOUBLE, type DOUBLE , ac INT);");
        localSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS wof(id CHAR(15) PRIMARY KEY,mktime DOUBLE,time DOUBLE, ac INT, bc INT, cc INT);");
        localSQLiteDatabase.setVersion(1);
        localSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void aY()
  {
    boolean bool1 = true;
    SQLiteDatabase localSQLiteDatabase1;
    try
    {
      SQLiteDatabase localSQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(this.ft, null);
      localSQLiteDatabase1 = localSQLiteDatabase2;
      if (localSQLiteDatabase1 == null)
        return;
    }
    catch (Exception localException1)
    {
      while (true)
        localSQLiteDatabase1 = null;
    }
    while (true)
    {
      long l2;
      try
      {
        long l1 = DatabaseUtils.queryNumEntries(localSQLiteDatabase1, "wof");
        l2 = DatabaseUtils.queryNumEntries(localSQLiteDatabase1, "bdcltb09");
        if (l1 > 10000L)
        {
          bool2 = bool1;
          break label118;
          a locala = new a(null);
          Boolean[] arrayOfBoolean = new Boolean[2];
          arrayOfBoolean[0] = Boolean.valueOf(bool2);
          arrayOfBoolean[1] = Boolean.valueOf(bool1);
          locala.execute(arrayOfBoolean);
          localSQLiteDatabase1.close();
          return;
        }
      }
      catch (Exception localException2)
      {
        return;
      }
      boolean bool2 = false;
      label118: 
      while (l2 <= 10000L)
      {
        bool1 = false;
        break;
      }
      if (bool2)
        continue;
      if (!bool1)
        continue;
    }
  }

  public static b aZ()
  {
    if (fh == null)
      fh = new b();
    return fh;
  }

  private void jdMethod_do(String paramString, List paramList)
  {
    SQLiteDatabase localSQLiteDatabase;
    if ((paramString != null) && (!paramString.equals(this.fn)))
    {
      localSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.ft, null);
      jdMethod_if(paramString, localSQLiteDatabase);
    }
    while (true)
    {
      if (paramList != null)
      {
        if (localSQLiteDatabase == null)
          localSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.ft, null);
        jdMethod_if(paramList, localSQLiteDatabase);
      }
      if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen()))
        localSQLiteDatabase.close();
      return;
      localSQLiteDatabase = null;
    }
  }

  private void jdMethod_if(com.baidu.location.h.f paramf, BDLocation paramBDLocation, SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramBDLocation == null) || (paramBDLocation.getLocType() != 161) || ((!"wf".equals(paramBDLocation.getNetworkLocationType())) && (paramBDLocation.getRadius() >= 300.0F)))
    {
      return;
      break label36;
      break label71;
    }
    label36: 
    while (paramf.kr == null);
    int i = (int)(System.currentTimeMillis() >> 28);
    System.currentTimeMillis();
    Iterator localIterator = paramf.kr.iterator();
    int j = 0;
    label71: 
    while (localIterator.hasNext())
    {
      ScanResult localScanResult = (ScanResult)localIterator.next();
      if (localScanResult.level == 0)
        break;
      int k = j + 1;
      if (k > 6)
        break;
      ContentValues localContentValues = new ContentValues();
      String str = Jni.J(localScanResult.BSSID.replace(":", ""));
      try
      {
        Cursor localCursor = paramSQLiteDatabase.rawQuery("select * from wof where id = \"" + str + "\";", null);
        int n;
        int i1;
        double d1;
        int m;
        double d2;
        if ((localCursor != null) && (localCursor.moveToFirst()))
        {
          double d5 = localCursor.getDouble(1) - 113.2349D;
          double d6 = localCursor.getDouble(2) - 432.12380000000002D;
          int i4 = localCursor.getInt(4);
          n = localCursor.getInt(5);
          i1 = i4;
          d1 = d5;
          m = 1;
          d2 = d6;
          label254: if (localCursor != null)
            localCursor.close();
          if (m != 0)
            break label694;
          localContentValues.put("mktime", Double.valueOf(113.2349D + paramBDLocation.getLongitude()));
          localContentValues.put("time", Double.valueOf(432.12380000000002D + paramBDLocation.getLatitude()));
          localContentValues.put("bc", Integer.valueOf(1));
          localContentValues.put("cc", Integer.valueOf(1));
          localContentValues.put("ac", Integer.valueOf(i));
          localContentValues.put("id", str);
          paramSQLiteDatabase.insert("wof", null, localContentValues);
        }
        do
        {
          float[] arrayOfFloat = new float[1];
          Location.distanceBetween(d2, d1, paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), arrayOfFloat);
          int i2;
          if (arrayOfFloat[0] > 1500.0F)
          {
            i2 = n + 1;
            if ((i2 > 10) && (i2 > i1 * 3))
            {
              localContentValues.put("mktime", Double.valueOf(113.2349D + paramBDLocation.getLongitude()));
              localContentValues.put("time", Double.valueOf(432.12380000000002D + paramBDLocation.getLatitude()));
              localContentValues.put("bc", Integer.valueOf(1));
              localContentValues.put("cc", Integer.valueOf(1));
              localContentValues.put("ac", Integer.valueOf(i));
            }
          }
          try
          {
            while (true)
            {
              int i3 = paramSQLiteDatabase.update("wof", localContentValues, "id = \"" + str + "\"", null);
              if (i3 > 0)
                break;
              break;
              localContentValues.put("cc", Integer.valueOf(i2));
              continue;
              double d3 = (d1 * i1 + paramBDLocation.getLongitude()) / (i1 + 1);
              double d4 = (d2 * i1 + paramBDLocation.getLatitude()) / (i1 + 1);
              localContentValues.put("mktime", Double.valueOf(d3 + 113.2349D));
              localContentValues.put("time", Double.valueOf(d4 + 432.12380000000002D));
              localContentValues.put("bc", Integer.valueOf(i1 + 1));
              localContentValues.put("ac", Integer.valueOf(i));
            }
          }
          catch (Exception localException2)
          {
          }
          d1 = 0.0D;
          d2 = 0.0D;
          m = 0;
          n = 0;
          i1 = 0;
          break label254;
          j = k;
          break;
        }
        while (n != 0);
        j = k;
      }
      catch (Exception localException1)
      {
        break label687;
      }
    }
  }

  // ERROR //
  private void jdMethod_if(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_1
    //   7: aload_0
    //   8: getfield 74	com/baidu/location/c/b:fn	Ljava/lang/String;
    //   11: invokevirtual 178	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 76	com/baidu/location/c/b:fo	Z
    //   23: aload_2
    //   24: new 43	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 356
    //   34: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 274
    //   44: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: aconst_null
    //   51: invokevirtual 278	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore 10
    //   56: aload 10
    //   58: astore_3
    //   59: aload_0
    //   60: aload_1
    //   61: putfield 74	com/baidu/location/c/b:fn	Ljava/lang/String;
    //   64: aload_3
    //   65: invokeinterface 283 1 0
    //   70: ifeq +53 -> 123
    //   73: aload_0
    //   74: aload_3
    //   75: iconst_1
    //   76: invokeinterface 287 2 0
    //   81: ldc2_w 357
    //   84: dsub
    //   85: putfield 82	com/baidu/location/c/b:fs	D
    //   88: aload_0
    //   89: aload_3
    //   90: iconst_2
    //   91: invokeinterface 287 2 0
    //   96: ldc2_w 359
    //   99: dsub
    //   100: putfield 80	com/baidu/location/c/b:fi	D
    //   103: aload_0
    //   104: aload_3
    //   105: iconst_3
    //   106: invokeinterface 287 2 0
    //   111: ldc2_w 361
    //   114: dsub
    //   115: putfield 84	com/baidu/location/c/b:fr	D
    //   118: aload_0
    //   119: iconst_1
    //   120: putfield 76	com/baidu/location/c/b:fo	Z
    //   123: aload_3
    //   124: ifnull -107 -> 17
    //   127: aload_3
    //   128: invokeinterface 296 1 0
    //   133: return
    //   134: astore 12
    //   136: return
    //   137: astore 8
    //   139: aload_3
    //   140: ifnull -123 -> 17
    //   143: aload_3
    //   144: invokeinterface 296 1 0
    //   149: return
    //   150: astore 9
    //   152: return
    //   153: astore 4
    //   155: aconst_null
    //   156: astore 5
    //   158: aload 4
    //   160: astore 6
    //   162: aload 5
    //   164: ifnull +10 -> 174
    //   167: aload 5
    //   169: invokeinterface 296 1 0
    //   174: aload 6
    //   176: athrow
    //   177: astore 7
    //   179: goto -5 -> 174
    //   182: astore 11
    //   184: aload_3
    //   185: astore 5
    //   187: aload 11
    //   189: astore 6
    //   191: goto -29 -> 162
    //
    // Exception table:
    //   from	to	target	type
    //   127	133	134	java/lang/Exception
    //   23	56	137	java/lang/Exception
    //   59	123	137	java/lang/Exception
    //   143	149	150	java/lang/Exception
    //   23	56	153	finally
    //   167	174	177	java/lang/Exception
    //   59	123	182	finally
  }

  private void jdMethod_if(String paramString, h paramh, SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    double d1 = 0.0D;
    if ((!paramh.ds()) || (!m.a9().bf()))
      return;
    System.currentTimeMillis();
    int j = (int)(System.currentTimeMillis() >> 28);
    String str1 = paramh.dA();
    while (true)
    {
      try
      {
        int k;
        String str2;
        while (true)
        {
          JSONObject localJSONObject1 = new JSONObject(paramString);
          k = Integer.parseInt(localJSONObject1.getJSONObject("result").getString("error"));
          if (k != 161)
            break label370;
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject("content");
          if (!localJSONObject2.has("clf"))
            break label417;
          str2 = localJSONObject2.getString("clf");
          if (str2.equals("0"))
          {
            JSONObject localJSONObject3 = localJSONObject2.getJSONObject("point");
            d1 = Double.parseDouble(localJSONObject3.getString("x"));
            d2 = Double.parseDouble(localJSONObject3.getString("y"));
            float f3 = Float.parseFloat(localJSONObject2.getString("radius"));
            f1 = f3;
            if (i != 0)
              break;
            double d3 = d1 + 1235.4322999999999D;
            double d4 = d2 + 2367.3217D;
            float f2 = 4326.0F + f1;
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("time", Double.valueOf(d3));
            localContentValues.put("tag", Float.valueOf(f2));
            localContentValues.put("type", Double.valueOf(d4));
            localContentValues.put("ac", Integer.valueOf(j));
            try
            {
              if (paramSQLiteDatabase.update("bdcltb09", localContentValues, "id = \"" + str1 + "\"", null) > 0)
                break;
              localContentValues.put("id", str1);
              paramSQLiteDatabase.insert("bdcltb09", null, localContentValues);
              return;
            }
            catch (Exception localException2)
            {
              return;
            }
          }
        }
        String[] arrayOfString = str2.split("\\|");
        d1 = Double.parseDouble(arrayOfString[0]);
        d2 = Double.parseDouble(arrayOfString[1]);
        f1 = Float.parseFloat(arrayOfString[2]);
        i = 0;
        continue;
        label370: if (k == 167)
        {
          paramSQLiteDatabase.delete("bdcltb09", "id = \"" + str1 + "\"", null);
          return;
        }
      }
      catch (Exception localException1)
      {
        return;
      }
      label417: i = 1;
      double d2 = d1;
      float f1 = 0.0F;
    }
  }

  // ERROR //
  private void jdMethod_if(List paramList, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: invokestatic 230	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 78	com/baidu/location/c/b:fv	Z
    //   9: aload_1
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: aload_2
    //   15: ifnull -2 -> 13
    //   18: aload_1
    //   19: ifnull -6 -> 13
    //   22: dconst_0
    //   23: dstore 5
    //   25: dconst_0
    //   26: dstore 7
    //   28: bipush 8
    //   30: newarray double
    //   32: astore 9
    //   34: new 448	java/lang/StringBuffer
    //   37: dup
    //   38: invokespecial 449	java/lang/StringBuffer:<init>	()V
    //   41: astore 10
    //   43: aload_1
    //   44: invokeinterface 236 1 0
    //   49: astore 11
    //   51: iconst_0
    //   52: istore 12
    //   54: aload 11
    //   56: invokeinterface 241 1 0
    //   61: ifeq +22 -> 83
    //   64: aload 11
    //   66: invokeinterface 245 1 0
    //   71: checkcast 247	android/net/wifi/ScanResult
    //   74: astore 54
    //   76: iload 12
    //   78: bipush 10
    //   80: if_icmple +175 -> 255
    //   83: aload_2
    //   84: new 43	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 451
    //   94: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 10
    //   99: invokevirtual 452	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   102: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc_w 454
    //   108: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: aconst_null
    //   115: invokevirtual 278	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 20
    //   120: aload 20
    //   122: astore 18
    //   124: aload 18
    //   126: invokeinterface 283 1 0
    //   131: istore 22
    //   133: iconst_0
    //   134: istore 23
    //   136: iconst_0
    //   137: istore 24
    //   139: iconst_0
    //   140: istore 25
    //   142: iconst_0
    //   143: istore 26
    //   145: iload 22
    //   147: ifeq +305 -> 452
    //   150: aload 18
    //   152: invokeinterface 457 1 0
    //   157: ifne +265 -> 422
    //   160: aload 18
    //   162: iconst_1
    //   163: invokeinterface 287 2 0
    //   168: ldc2_w 288
    //   171: dsub
    //   172: dstore 28
    //   174: aload 18
    //   176: iconst_2
    //   177: invokeinterface 287 2 0
    //   182: ldc2_w 290
    //   185: dsub
    //   186: dstore 30
    //   188: aload 18
    //   190: iconst_4
    //   191: invokeinterface 295 2 0
    //   196: istore 32
    //   198: aload 18
    //   200: iconst_5
    //   201: invokeinterface 295 2 0
    //   206: istore 33
    //   208: iload 33
    //   210: bipush 8
    //   212: if_icmple +102 -> 314
    //   215: iload 33
    //   217: iload 32
    //   219: if_icmple +95 -> 314
    //   222: aload 18
    //   224: invokeinterface 460 1 0
    //   229: pop
    //   230: goto -80 -> 150
    //   233: astore 21
    //   235: aload 18
    //   237: astore 14
    //   239: aload 14
    //   241: ifnull -228 -> 13
    //   244: aload 14
    //   246: invokeinterface 296 1 0
    //   251: return
    //   252: astore 15
    //   254: return
    //   255: iload 12
    //   257: ifle +12 -> 269
    //   260: aload 10
    //   262: ldc_w 462
    //   265: invokevirtual 465	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   268: pop
    //   269: iinc 12 1
    //   272: aload 54
    //   274: getfield 256	android/net/wifi/ScanResult:BSSID	Ljava/lang/String;
    //   277: ldc_w 258
    //   280: ldc_w 260
    //   283: invokevirtual 264	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   286: invokestatic 270	com/baidu/location/Jni:J	(Ljava/lang/String;)Ljava/lang/String;
    //   289: astore 55
    //   291: aload 10
    //   293: ldc_w 350
    //   296: invokevirtual 465	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   299: aload 55
    //   301: invokevirtual 465	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   304: ldc_w 350
    //   307: invokevirtual 465	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   310: pop
    //   311: goto -257 -> 54
    //   314: aload_0
    //   315: getfield 76	com/baidu/location/c/b:fo	Z
    //   318: ifeq +150 -> 468
    //   321: iconst_1
    //   322: newarray float
    //   324: astore 51
    //   326: dload 30
    //   328: dload 28
    //   330: aload_0
    //   331: getfield 84	com/baidu/location/c/b:fr	D
    //   334: aload_0
    //   335: getfield 82	com/baidu/location/c/b:fs	D
    //   338: aload 51
    //   340: invokestatic 345	android/location/Location:distanceBetween	(DDDD[F)V
    //   343: aload 51
    //   345: iconst_0
    //   346: faload
    //   347: f2d
    //   348: ldc2_w 466
    //   351: aload_0
    //   352: getfield 80	com/baidu/location/c/b:fi	D
    //   355: dadd
    //   356: dcmpl
    //   357: ifle +31 -> 388
    //   360: aload 18
    //   362: invokeinterface 460 1 0
    //   367: pop
    //   368: goto -218 -> 150
    //   371: astore 17
    //   373: aload 18
    //   375: ifnull +10 -> 385
    //   378: aload 18
    //   380: invokeinterface 296 1 0
    //   385: aload 17
    //   387: athrow
    //   388: iconst_1
    //   389: istore 23
    //   391: dload 5
    //   393: dload 28
    //   395: dadd
    //   396: dstore 5
    //   398: dload 7
    //   400: dload 30
    //   402: dadd
    //   403: dstore 7
    //   405: iinc 24 1
    //   408: iload 25
    //   410: istore 44
    //   412: iload 26
    //   414: istore 45
    //   416: iload 24
    //   418: iconst_4
    //   419: if_icmple +265 -> 684
    //   422: iload 24
    //   424: ifle +28 -> 452
    //   427: aload_0
    //   428: iconst_1
    //   429: putfield 78	com/baidu/location/c/b:fv	Z
    //   432: aload_0
    //   433: dload 5
    //   435: iload 24
    //   437: i2d
    //   438: ddiv
    //   439: putfield 86	com/baidu/location/c/b:fm	D
    //   442: aload_0
    //   443: dload 7
    //   445: iload 24
    //   447: i2d
    //   448: ddiv
    //   449: putfield 88	com/baidu/location/c/b:fl	D
    //   452: aload 18
    //   454: ifnull -441 -> 13
    //   457: aload 18
    //   459: invokeinterface 296 1 0
    //   464: return
    //   465: astore 27
    //   467: return
    //   468: iload 23
    //   470: ifeq +51 -> 521
    //   473: iconst_1
    //   474: newarray float
    //   476: astore 49
    //   478: dload 30
    //   480: dload 28
    //   482: dload 7
    //   484: iload 24
    //   486: i2d
    //   487: ddiv
    //   488: dload 5
    //   490: iload 24
    //   492: i2d
    //   493: ddiv
    //   494: aload 49
    //   496: invokestatic 345	android/location/Location:distanceBetween	(DDDD[F)V
    //   499: aload 49
    //   501: iconst_0
    //   502: faload
    //   503: ldc_w 468
    //   506: fcmpl
    //   507: ifle +240 -> 747
    //   510: aload 18
    //   512: invokeinterface 460 1 0
    //   517: pop
    //   518: goto -368 -> 150
    //   521: iload 26
    //   523: ifne +235 -> 758
    //   526: iload 25
    //   528: iconst_1
    //   529: iadd
    //   530: istore 47
    //   532: aload 9
    //   534: iload 25
    //   536: dload 28
    //   538: dastore
    //   539: iload 47
    //   541: iconst_1
    //   542: iadd
    //   543: istore 48
    //   545: aload 9
    //   547: iload 47
    //   549: dload 30
    //   551: dastore
    //   552: iconst_1
    //   553: istore 45
    //   555: iload 48
    //   557: istore 44
    //   559: goto -143 -> 416
    //   562: iload 34
    //   564: iload 25
    //   566: if_icmpge +220 -> 786
    //   569: iconst_1
    //   570: newarray float
    //   572: astore 35
    //   574: dload 30
    //   576: dload 28
    //   578: aload 9
    //   580: iload 34
    //   582: iconst_1
    //   583: iadd
    //   584: daload
    //   585: aload 9
    //   587: iload 34
    //   589: daload
    //   590: aload 35
    //   592: invokestatic 345	android/location/Location:distanceBetween	(DDDD[F)V
    //   595: aload 35
    //   597: iconst_0
    //   598: faload
    //   599: ldc_w 468
    //   602: fcmpg
    //   603: ifge +125 -> 728
    //   606: iconst_1
    //   607: istore 36
    //   609: dload 5
    //   611: aload 9
    //   613: iload 34
    //   615: daload
    //   616: dadd
    //   617: dstore 37
    //   619: dload 7
    //   621: aload 9
    //   623: iload 34
    //   625: iconst_1
    //   626: iadd
    //   627: daload
    //   628: dadd
    //   629: dstore 39
    //   631: iload 24
    //   633: iconst_1
    //   634: iadd
    //   635: istore 41
    //   637: goto +127 -> 764
    //   640: iload 25
    //   642: bipush 8
    //   644: if_icmpge -222 -> 422
    //   647: iload 25
    //   649: iconst_1
    //   650: iadd
    //   651: istore 42
    //   653: aload 9
    //   655: iload 25
    //   657: dload 28
    //   659: dastore
    //   660: iload 42
    //   662: iconst_1
    //   663: iadd
    //   664: istore 43
    //   666: aload 9
    //   668: iload 42
    //   670: dload 30
    //   672: dastore
    //   673: iload 43
    //   675: istore 44
    //   677: iload 26
    //   679: istore 45
    //   681: goto -265 -> 416
    //   684: aload 18
    //   686: invokeinterface 460 1 0
    //   691: pop
    //   692: iload 44
    //   694: istore 25
    //   696: iload 45
    //   698: istore 26
    //   700: goto -550 -> 150
    //   703: astore 19
    //   705: goto -320 -> 385
    //   708: astore 16
    //   710: aload 16
    //   712: astore 17
    //   714: aconst_null
    //   715: astore 18
    //   717: goto -344 -> 373
    //   720: astore 13
    //   722: aconst_null
    //   723: astore 14
    //   725: goto -486 -> 239
    //   728: iload 23
    //   730: istore 36
    //   732: iload 24
    //   734: istore 41
    //   736: dload 7
    //   738: dstore 39
    //   740: dload 5
    //   742: dstore 37
    //   744: goto +20 -> 764
    //   747: iload 25
    //   749: istore 44
    //   751: iload 26
    //   753: istore 45
    //   755: goto -339 -> 416
    //   758: iconst_0
    //   759: istore 34
    //   761: goto -199 -> 562
    //   764: iinc 34 2
    //   767: dload 39
    //   769: dstore 7
    //   771: dload 37
    //   773: dstore 5
    //   775: iload 36
    //   777: istore 23
    //   779: iload 41
    //   781: istore 24
    //   783: goto -221 -> 562
    //   786: iload 23
    //   788: ifeq -148 -> 640
    //   791: dload 5
    //   793: dload 28
    //   795: dadd
    //   796: dstore 5
    //   798: dload 7
    //   800: dload 30
    //   802: dadd
    //   803: dstore 7
    //   805: iinc 24 1
    //   808: iload 25
    //   810: istore 44
    //   812: iload 26
    //   814: istore 45
    //   816: goto -400 -> 416
    //
    // Exception table:
    //   from	to	target	type
    //   124	133	233	java/lang/Exception
    //   150	208	233	java/lang/Exception
    //   222	230	233	java/lang/Exception
    //   314	368	233	java/lang/Exception
    //   427	452	233	java/lang/Exception
    //   473	518	233	java/lang/Exception
    //   532	539	233	java/lang/Exception
    //   545	552	233	java/lang/Exception
    //   569	606	233	java/lang/Exception
    //   609	631	233	java/lang/Exception
    //   653	660	233	java/lang/Exception
    //   666	673	233	java/lang/Exception
    //   684	692	233	java/lang/Exception
    //   244	251	252	java/lang/Exception
    //   124	133	371	finally
    //   150	208	371	finally
    //   222	230	371	finally
    //   314	368	371	finally
    //   427	452	371	finally
    //   473	518	371	finally
    //   532	539	371	finally
    //   545	552	371	finally
    //   569	606	371	finally
    //   609	631	371	finally
    //   653	660	371	finally
    //   666	673	371	finally
    //   684	692	371	finally
    //   457	464	465	java/lang/Exception
    //   378	385	703	java/lang/Exception
    //   83	120	708	finally
    //   83	120	720	java/lang/Exception
  }

  private String jdMethod_try(boolean paramBoolean)
  {
    double d1 = 0.0D;
    double d3;
    double d2;
    boolean bool;
    int i;
    if (this.fv)
    {
      d3 = this.fm;
      d2 = this.fl;
      d1 = 246.40000000000001D;
      bool = true;
      i = 1;
    }
    while (true)
    {
      if (i != 0)
      {
        if (paramBoolean)
        {
          String str2 = "{\"result\":{\"time\":\"" + com.baidu.location.b.k.ad() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
          Locale localLocale2 = Locale.CHINA;
          Object[] arrayOfObject2 = new Object[4];
          arrayOfObject2[0] = Double.valueOf(d3);
          arrayOfObject2[1] = Double.valueOf(d2);
          arrayOfObject2[2] = Double.valueOf(d1);
          arrayOfObject2[3] = Boolean.valueOf(true);
          return String.format(localLocale2, str2, arrayOfObject2);
          if (this.fo)
          {
            d3 = this.fs;
            d2 = this.fr;
            d1 = this.fi;
            bool = m.a9().bf();
            i = 1;
            continue;
          }
        }
        else
        {
          String str1 = "{\"result\":{\"time\":\"" + com.baidu.location.b.k.ad() + "\",\"error\":\"66\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%f\",\"isCellChanged\":\"%b\"}}";
          Locale localLocale1 = Locale.CHINA;
          Object[] arrayOfObject1 = new Object[4];
          arrayOfObject1[0] = Double.valueOf(d3);
          arrayOfObject1[1] = Double.valueOf(d2);
          arrayOfObject1[2] = Double.valueOf(d1);
          arrayOfObject1[3] = Boolean.valueOf(bool);
          return String.format(localLocale1, str1, arrayOfObject1);
        }
      }
      else
      {
        if (paramBoolean)
          return "{\"result\":{\"time\":\"" + com.baidu.location.b.k.ad() + "\",\"error\":\"67\"}}";
        return "{\"result\":{\"time\":\"" + com.baidu.location.b.k.ad() + "\",\"error\":\"63\"}}";
      }
      d2 = d1;
      d3 = d1;
      bool = false;
      i = 0;
    }
  }

  public void a0()
  {
    this.fg.postDelayed(new b.1(this), 3000L);
  }

  public BDLocation jdMethod_byte(boolean paramBoolean)
  {
    h localh = com.baidu.location.h.c.a().cM();
    String str1 = null;
    if (localh != null)
      str1 = localh.dA();
    com.baidu.location.h.f localf = l.a().c6();
    BDLocation localBDLocation = jdMethod_if(str1, localf.kr, true);
    if ((localBDLocation != null) && (localBDLocation.getLocType() == 66))
    {
      StringBuffer localStringBuffer = new StringBuffer(1024);
      Locale localLocale = Locale.CHINA;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Double.valueOf(localBDLocation.getLatitude());
      arrayOfObject[1] = Double.valueOf(localBDLocation.getLongitude());
      arrayOfObject[2] = Float.valueOf(localBDLocation.getRadius());
      localStringBuffer.append(String.format(localLocale, "&ofl=%f|%f|%f", arrayOfObject));
      if ((localf != null) && (localf.dl() > 0))
      {
        localStringBuffer.append("&wf=");
        localStringBuffer.append(localf.d(15));
      }
      if (localh != null)
        localStringBuffer.append(localh.dx());
      localStringBuffer.append("&uptype=oldoff");
      localStringBuffer.append(com.baidu.location.b.c.N().jdMethod_do(false));
      localStringBuffer.append(com.baidu.location.e.c.bp().bs());
      String str2 = localStringBuffer.toString();
      o.jdMethod_for(o.fe, Jni.H(str2));
    }
    return localBDLocation;
  }

  public BDLocation jdMethod_if(String paramString, List paramList, boolean paramBoolean)
  {
    ExecutorService localExecutorService = Executors.newSingleThreadExecutor();
    FutureTask localFutureTask = (FutureTask)localExecutorService.submit(new b.2(this, paramString, paramList));
    try
    {
      str = (String)localFutureTask.get(2000L, TimeUnit.MILLISECONDS);
      return new BDLocation(str);
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
      {
        localFutureTask.cancel(true);
        localExecutorService.shutdown();
        str = "{\"result\":\"null\"}";
      }
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
      {
        localFutureTask.cancel(true);
        localExecutorService.shutdown();
        str = "{\"result\":\"null\"}";
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
      {
        if (paramBoolean)
          o.aX().j("old offlineLocation Timeout Exception!");
        localFutureTask.cancel(true);
        localExecutorService.shutdown();
        String str = "{\"result\":\"null\"}";
      }
    }
    finally
    {
      localExecutorService.shutdown();
    }
    throw localObject;
  }

  public void jdMethod_if(String paramString, h paramh, com.baidu.location.h.f paramf, BDLocation paramBDLocation)
  {
    if ((!paramh.ds()) || (!m.a9().bf()));
    for (int i = 1; ; i = 0)
    {
      if ((paramBDLocation == null) || (paramBDLocation.getLocType() != 161) || ((!"wf".equals(paramBDLocation.getNetworkLocationType())) && (paramBDLocation.getRadius() >= 300.0F)));
      for (int j = 1; ; j = 0)
      {
        if (paramf.kr == null)
          j = 1;
        if ((i != 0) && (j != 0));
        do
          return;
        while (this.fq);
        this.fq = true;
        new b(null).execute(new Object[] { paramString, paramh, paramf, paramBDLocation });
        return;
      }
    }
  }

  private class a extends AsyncTask
  {
    private a()
    {
    }

    protected Boolean a(Boolean[] paramArrayOfBoolean)
    {
      if (paramArrayOfBoolean.length != 4)
        return Boolean.valueOf(false);
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(b.jdMethod_do(b.this), null);
        localSQLiteDatabase1 = localSQLiteDatabase2;
        if (localSQLiteDatabase1 == null)
          return Boolean.valueOf(false);
        int i = (int)(System.currentTimeMillis() >> 28);
        try
        {
          localSQLiteDatabase1.beginTransaction();
          String str2;
          if (paramArrayOfBoolean[0].booleanValue())
            str2 = "delete from wof where ac < " + (i - 35);
          try
          {
            localSQLiteDatabase1.execSQL(str2);
            if (paramArrayOfBoolean[1].booleanValue())
              str1 = "delete from bdcltb09 where ac is NULL or ac < " + (i - 130);
          }
          catch (Exception localException4)
          {
            try
            {
              String str1;
              localSQLiteDatabase1.execSQL(str1);
              label130: localSQLiteDatabase1.setTransactionSuccessful();
              localSQLiteDatabase1.endTransaction();
              localSQLiteDatabase1.close();
              label142: return Boolean.valueOf(true);
              localException4 = localException4;
            }
            catch (Exception localException3)
            {
              break label130;
            }
          }
        }
        catch (Exception localException2)
        {
          break label142;
        }
      }
      catch (Exception localException1)
      {
        while (true)
          SQLiteDatabase localSQLiteDatabase1 = null;
      }
    }
  }

  private class b extends AsyncTask
  {
    private b()
    {
    }

    protected Boolean a(Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject.length != 4)
      {
        b.jdMethod_if(b.this, false);
        return Boolean.valueOf(false);
      }
      SQLiteDatabase localSQLiteDatabase1;
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = SQLiteDatabase.openOrCreateDatabase(b.jdMethod_do(b.this), null);
        localSQLiteDatabase1 = localSQLiteDatabase2;
        if (localSQLiteDatabase1 == null)
        {
          b.jdMethod_if(b.this, false);
          return Boolean.valueOf(false);
        }
      }
      catch (Exception localException1)
      {
        while (true)
          localSQLiteDatabase1 = null;
      }
      try
      {
        localSQLiteDatabase1.beginTransaction();
        b.jdMethod_if(b.this, (String)paramArrayOfObject[0], (h)paramArrayOfObject[1], localSQLiteDatabase1);
        b.jdMethod_if(b.this, (com.baidu.location.h.f)paramArrayOfObject[2], (BDLocation)paramArrayOfObject[3], localSQLiteDatabase1);
        localSQLiteDatabase1.setTransactionSuccessful();
        localSQLiteDatabase1.endTransaction();
        localSQLiteDatabase1.close();
        label116: b.jdMethod_if(b.this, false);
        return Boolean.valueOf(true);
      }
      catch (Exception localException2)
      {
        break label116;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.b
 * JD-Core Version:    0.6.0
 */