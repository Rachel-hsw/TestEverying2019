package com.alipay.sdk.tid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public final class a extends SQLiteOpenHelper
{
  private static final String a = "msp.db";
  private static final int b = 1;
  private WeakReference<Context> c;

  public a(Context paramContext)
  {
    super(paramContext, "msp.db", null, 1);
    this.c = new WeakReference(paramContext);
  }

  // ERROR //
  private java.util.List<String> a()
  {
    // Byte code:
    //   0: new 31	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 34	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual 38	com/alipay/sdk/tid/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 9
    //   14: aload 9
    //   16: astore 6
    //   18: aload 6
    //   20: ldc 40
    //   22: aconst_null
    //   23: invokevirtual 46	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore 12
    //   28: aload 12
    //   30: astore 8
    //   32: aload 8
    //   34: invokeinterface 52 1 0
    //   39: ifeq +89 -> 128
    //   42: aload 8
    //   44: iconst_0
    //   45: invokeinterface 56 2 0
    //   50: astore 14
    //   52: aload 14
    //   54: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne -25 -> 32
    //   60: aload_1
    //   61: iconst_2
    //   62: aload 14
    //   64: aload_0
    //   65: getfield 26	com/alipay/sdk/tid/a:c	Ljava/lang/ref/WeakReference;
    //   68: invokevirtual 66	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   71: checkcast 68	android/content/Context
    //   74: invokestatic 73	com/alipay/sdk/util/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   77: invokestatic 78	com/alipay/sdk/encrypt/b:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: invokeinterface 84 2 0
    //   85: pop
    //   86: goto -54 -> 32
    //   89: astore 13
    //   91: aload 8
    //   93: astore_3
    //   94: aload 6
    //   96: astore 4
    //   98: aload_3
    //   99: ifnull +9 -> 108
    //   102: aload_3
    //   103: invokeinterface 87 1 0
    //   108: aload 4
    //   110: ifnull +16 -> 126
    //   113: aload 4
    //   115: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   118: ifeq +8 -> 126
    //   121: aload 4
    //   123: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   126: aload_1
    //   127: areturn
    //   128: aload 8
    //   130: ifnull +10 -> 140
    //   133: aload 8
    //   135: invokeinterface 87 1 0
    //   140: aload 6
    //   142: ifnull -16 -> 126
    //   145: aload 6
    //   147: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   150: ifeq -24 -> 126
    //   153: aload 6
    //   155: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   158: aload_1
    //   159: areturn
    //   160: astore 5
    //   162: aconst_null
    //   163: astore 6
    //   165: aload 5
    //   167: astore 7
    //   169: aconst_null
    //   170: astore 8
    //   172: aload 8
    //   174: ifnull +10 -> 184
    //   177: aload 8
    //   179: invokeinterface 87 1 0
    //   184: aload 6
    //   186: ifnull +16 -> 202
    //   189: aload 6
    //   191: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   194: ifeq +8 -> 202
    //   197: aload 6
    //   199: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   202: aload 7
    //   204: athrow
    //   205: astore 11
    //   207: aload 11
    //   209: astore 7
    //   211: aconst_null
    //   212: astore 8
    //   214: goto -42 -> 172
    //   217: astore 7
    //   219: goto -47 -> 172
    //   222: astore_2
    //   223: aconst_null
    //   224: astore_3
    //   225: aconst_null
    //   226: astore 4
    //   228: goto -130 -> 98
    //   231: astore 10
    //   233: aload 6
    //   235: astore 4
    //   237: aconst_null
    //   238: astore_3
    //   239: goto -141 -> 98
    //
    // Exception table:
    //   from	to	target	type
    //   32	86	89	java/lang/Exception
    //   8	14	160	finally
    //   18	28	205	finally
    //   32	86	217	finally
    //   8	14	222	java/lang/Exception
    //   18	28	231	java/lang/Exception
  }

  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
    if (localCursor.getCount() <= 14)
      localCursor.close();
    while (true)
    {
      return;
      int j = -14 + localCursor.getCount();
      String[] arrayOfString = new String[j];
      if (localCursor.moveToFirst())
      {
        int k = 0;
        do
        {
          arrayOfString[k] = localCursor.getString(0);
          k++;
        }
        while ((localCursor.moveToNext()) && (j > k));
      }
      localCursor.close();
      while (i < arrayOfString.length)
      {
        if (!TextUtils.isEmpty(arrayOfString[i]))
          a(paramSQLiteDatabase, arrayOfString[i]);
        i++;
      }
    }
  }

  private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      paramSQLiteDatabase.delete("tb_tid", "name=?", new String[] { paramString });
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = 0;
    String str = com.alipay.sdk.encrypt.b.a(1, paramString3, com.alipay.sdk.util.b.c((Context)this.c.get()));
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = e(paramString1, paramString2);
    arrayOfObject[1] = str;
    arrayOfObject[2] = paramString4;
    paramSQLiteDatabase.execSQL("insert into tb_tid (name, tid, key_tid, dt) values (?, ?, ?, datetime('now', 'localtime'))", arrayOfObject);
    Cursor localCursor = paramSQLiteDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
    if (localCursor.getCount() <= 14)
      localCursor.close();
    while (true)
    {
      return;
      int j = -14 + localCursor.getCount();
      String[] arrayOfString = new String[j];
      if (localCursor.moveToFirst())
      {
        int k = 0;
        do
        {
          arrayOfString[k] = localCursor.getString(0);
          k++;
        }
        while ((localCursor.moveToNext()) && (j > k));
      }
      localCursor.close();
      while (i < arrayOfString.length)
      {
        if (!TextUtils.isEmpty(arrayOfString[i]))
          a(paramSQLiteDatabase, arrayOfString[i]);
        i++;
      }
    }
  }

  // ERROR //
  private static boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: anewarray 100	java/lang/String
    //   6: astore 7
    //   8: aload 7
    //   10: iconst_0
    //   11: aload_1
    //   12: aload_2
    //   13: invokestatic 121	com/alipay/sdk/tid/a:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: aastore
    //   17: aload_0
    //   18: ldc 130
    //   20: aload 7
    //   22: invokevirtual 46	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_3
    //   26: aload_3
    //   27: invokeinterface 103 1 0
    //   32: ifeq +85 -> 117
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 134 2 0
    //   42: istore 9
    //   44: iload 9
    //   46: istore 8
    //   48: aload_3
    //   49: ifnull +61 -> 110
    //   52: aload_3
    //   53: invokeinterface 87 1 0
    //   58: iload 8
    //   60: istore 6
    //   62: iload 6
    //   64: ifle +38 -> 102
    //   67: iconst_1
    //   68: ireturn
    //   69: astore 5
    //   71: aload_3
    //   72: ifnull +32 -> 104
    //   75: aload_3
    //   76: invokeinterface 87 1 0
    //   81: iconst_0
    //   82: istore 6
    //   84: goto -22 -> 62
    //   87: astore 4
    //   89: aload_3
    //   90: ifnull +9 -> 99
    //   93: aload_3
    //   94: invokeinterface 87 1 0
    //   99: aload 4
    //   101: athrow
    //   102: iconst_0
    //   103: ireturn
    //   104: iconst_0
    //   105: istore 6
    //   107: goto -45 -> 62
    //   110: iload 8
    //   112: istore 6
    //   114: goto -52 -> 62
    //   117: iconst_0
    //   118: istore 8
    //   120: goto -72 -> 48
    //
    // Exception table:
    //   from	to	target	type
    //   2	44	69	java/lang/Exception
    //   2	44	87	finally
  }

  private void b(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = com.alipay.sdk.encrypt.b.a(1, paramString3, com.alipay.sdk.util.b.c((Context)this.c.get()));
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = str;
    arrayOfObject[1] = paramString4;
    arrayOfObject[2] = e(paramString1, paramString2);
    paramSQLiteDatabase.execSQL("update tb_tid set tid=?, key_tid=?, dt=datetime('now', 'localtime') where name=?", arrayOfObject);
  }

  // ERROR //
  private long d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: lconst_0
    //   3: lstore 4
    //   5: aload_0
    //   6: invokevirtual 38	com/alipay/sdk/tid/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 9
    //   11: aload 9
    //   13: astore 7
    //   15: iconst_1
    //   16: anewarray 100	java/lang/String
    //   19: astore 11
    //   21: aload 11
    //   23: iconst_0
    //   24: aload_1
    //   25: aload_2
    //   26: invokestatic 121	com/alipay/sdk/tid/a:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: aastore
    //   30: aload 7
    //   32: ldc 140
    //   34: aload 11
    //   36: invokevirtual 46	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore_3
    //   40: aload_3
    //   41: invokeinterface 103 1 0
    //   46: ifeq +34 -> 80
    //   49: new 142	java/text/SimpleDateFormat
    //   52: dup
    //   53: ldc 144
    //   55: invokestatic 150	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   58: invokespecial 153	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   61: aload_3
    //   62: iconst_0
    //   63: invokeinterface 56 2 0
    //   68: invokevirtual 157	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   71: invokevirtual 163	java/util/Date:getTime	()J
    //   74: lstore 12
    //   76: lload 12
    //   78: lstore 4
    //   80: aload_3
    //   81: ifnull +9 -> 90
    //   84: aload_3
    //   85: invokeinterface 87 1 0
    //   90: aload 7
    //   92: ifnull +16 -> 108
    //   95: aload 7
    //   97: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   100: ifeq +8 -> 108
    //   103: aload 7
    //   105: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   108: lload 4
    //   110: lreturn
    //   111: astore 8
    //   113: aconst_null
    //   114: astore 7
    //   116: aload_3
    //   117: ifnull +9 -> 126
    //   120: aload_3
    //   121: invokeinterface 87 1 0
    //   126: aload 7
    //   128: ifnull -20 -> 108
    //   131: aload 7
    //   133: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   136: ifeq -28 -> 108
    //   139: aload 7
    //   141: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   144: lload 4
    //   146: lreturn
    //   147: astore 6
    //   149: aconst_null
    //   150: astore 7
    //   152: aload_3
    //   153: ifnull +9 -> 162
    //   156: aload_3
    //   157: invokeinterface 87 1 0
    //   162: aload 7
    //   164: ifnull +16 -> 180
    //   167: aload 7
    //   169: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   172: ifeq +8 -> 180
    //   175: aload 7
    //   177: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   180: aload 6
    //   182: athrow
    //   183: astore 6
    //   185: goto -33 -> 152
    //   188: astore 10
    //   190: goto -74 -> 116
    //
    // Exception table:
    //   from	to	target	type
    //   5	11	111	java/lang/Exception
    //   5	11	147	finally
    //   15	76	183	finally
    //   15	76	188	java/lang/Exception
  }

  private static String e(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }

  // ERROR //
  public final void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 178	com/alipay/sdk/tid/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_3
    //   7: aload_0
    //   8: aload_3
    //   9: aload_1
    //   10: aload_2
    //   11: ldc 180
    //   13: ldc 180
    //   15: invokespecial 182	com/alipay/sdk/tid/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   18: aload_3
    //   19: aload_1
    //   20: aload_2
    //   21: invokestatic 121	com/alipay/sdk/tid/a:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: invokestatic 106	com/alipay/sdk/tid/a:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   27: aload_3
    //   28: ifnull +14 -> 42
    //   31: aload_3
    //   32: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   35: ifeq +7 -> 42
    //   38: aload_3
    //   39: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   42: return
    //   43: astore 5
    //   45: aload_3
    //   46: ifnull -4 -> 42
    //   49: aload_3
    //   50: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   53: ifeq -11 -> 42
    //   56: aload_3
    //   57: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   60: return
    //   61: astore 4
    //   63: aload_3
    //   64: ifnull +14 -> 78
    //   67: aload_3
    //   68: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   71: ifeq +7 -> 78
    //   74: aload_3
    //   75: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   78: aload 4
    //   80: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	27	43	java/lang/Exception
    //   2	27	61	finally
  }

  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    SQLiteDatabase localSQLiteDatabase = null;
    try
    {
      localSQLiteDatabase = getWritableDatabase();
      if (a(localSQLiteDatabase, paramString1, paramString2))
        b(localSQLiteDatabase, paramString1, paramString2, paramString3, paramString4);
      while (true)
      {
        return;
        String str = com.alipay.sdk.encrypt.b.a(1, paramString3, com.alipay.sdk.util.b.c((Context)this.c.get()));
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = e(paramString1, paramString2);
        arrayOfObject[1] = str;
        arrayOfObject[2] = paramString4;
        localSQLiteDatabase.execSQL("insert into tb_tid (name, tid, key_tid, dt) values (?, ?, ?, datetime('now', 'localtime'))", arrayOfObject);
        localCursor = localSQLiteDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
        if (localCursor.getCount() > 14)
          break;
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      Cursor localCursor;
      return;
      int i = -14 + localCursor.getCount();
      String[] arrayOfString = new String[i];
      if (localCursor.moveToFirst())
      {
        int j = 0;
        do
        {
          arrayOfString[j] = localCursor.getString(0);
          j++;
        }
        while ((localCursor.moveToNext()) && (i > j));
      }
      localCursor.close();
      for (int k = 0; k < arrayOfString.length; k++)
      {
        if (TextUtils.isEmpty(arrayOfString[k]))
          continue;
        a(localSQLiteDatabase, arrayOfString[k]);
      }
    }
    finally
    {
      if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen()))
        localSQLiteDatabase.close();
    }
    throw localObject;
  }

  // ERROR //
  public final String b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 38	com/alipay/sdk/tid/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore 9
    //   6: aload 9
    //   8: astore 4
    //   10: iconst_1
    //   11: anewarray 100	java/lang/String
    //   14: astore 12
    //   16: aload 12
    //   18: iconst_0
    //   19: aload_1
    //   20: aload_2
    //   21: invokestatic 121	com/alipay/sdk/tid/a:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: aastore
    //   25: aload 4
    //   27: ldc 187
    //   29: aload 12
    //   31: invokevirtual 46	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 13
    //   36: aload 13
    //   38: astore 6
    //   40: aload 6
    //   42: invokeinterface 103 1 0
    //   47: istore 15
    //   49: aconst_null
    //   50: astore 16
    //   52: iload 15
    //   54: ifeq +17 -> 71
    //   57: aload 6
    //   59: iconst_0
    //   60: invokeinterface 56 2 0
    //   65: astore 17
    //   67: aload 17
    //   69: astore 16
    //   71: aload 6
    //   73: ifnull +10 -> 83
    //   76: aload 6
    //   78: invokeinterface 87 1 0
    //   83: aload 4
    //   85: ifnull +175 -> 260
    //   88: aload 4
    //   90: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   93: ifeq +167 -> 260
    //   96: aload 4
    //   98: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   101: aload 16
    //   103: astore 8
    //   105: aload 8
    //   107: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +24 -> 134
    //   113: iconst_2
    //   114: aload 8
    //   116: aload_0
    //   117: getfield 26	com/alipay/sdk/tid/a:c	Ljava/lang/ref/WeakReference;
    //   120: invokevirtual 66	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   123: checkcast 68	android/content/Context
    //   126: invokestatic 73	com/alipay/sdk/util/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   129: invokestatic 78	com/alipay/sdk/encrypt/b:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 8
    //   134: aload 8
    //   136: areturn
    //   137: astore 7
    //   139: aconst_null
    //   140: astore 6
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 6
    //   147: ifnull +10 -> 157
    //   150: aload 6
    //   152: invokeinterface 87 1 0
    //   157: aload 4
    //   159: ifnull +95 -> 254
    //   162: aload 4
    //   164: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   167: ifeq +87 -> 254
    //   170: aload 4
    //   172: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   175: aconst_null
    //   176: astore 8
    //   178: goto -73 -> 105
    //   181: astore_3
    //   182: aconst_null
    //   183: astore 4
    //   185: aload_3
    //   186: astore 5
    //   188: aconst_null
    //   189: astore 6
    //   191: aload 6
    //   193: ifnull +10 -> 203
    //   196: aload 6
    //   198: invokeinterface 87 1 0
    //   203: aload 4
    //   205: ifnull +16 -> 221
    //   208: aload 4
    //   210: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   213: ifeq +8 -> 221
    //   216: aload 4
    //   218: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   221: aload 5
    //   223: athrow
    //   224: astore 11
    //   226: aload 11
    //   228: astore 5
    //   230: aconst_null
    //   231: astore 6
    //   233: goto -42 -> 191
    //   236: astore 5
    //   238: goto -47 -> 191
    //   241: astore 10
    //   243: aconst_null
    //   244: astore 6
    //   246: goto -101 -> 145
    //   249: astore 14
    //   251: goto -106 -> 145
    //   254: aconst_null
    //   255: astore 8
    //   257: goto -152 -> 105
    //   260: aload 16
    //   262: astore 8
    //   264: goto -159 -> 105
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	137	java/lang/Exception
    //   0	6	181	finally
    //   10	36	224	finally
    //   40	49	236	finally
    //   57	67	236	finally
    //   10	36	241	java/lang/Exception
    //   40	49	249	java/lang/Exception
    //   57	67	249	java/lang/Exception
  }

  // ERROR //
  public final String c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 38	com/alipay/sdk/tid/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore 10
    //   6: aload 10
    //   8: astore 4
    //   10: iconst_1
    //   11: anewarray 100	java/lang/String
    //   14: astore 13
    //   16: aload 13
    //   18: iconst_0
    //   19: aload_1
    //   20: aload_2
    //   21: invokestatic 121	com/alipay/sdk/tid/a:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: aastore
    //   25: aload 4
    //   27: ldc 189
    //   29: aload 13
    //   31: invokevirtual 46	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 14
    //   36: aload 14
    //   38: astore 6
    //   40: aload 6
    //   42: invokeinterface 103 1 0
    //   47: istore 16
    //   49: aconst_null
    //   50: astore 8
    //   52: iload 16
    //   54: ifeq +17 -> 71
    //   57: aload 6
    //   59: iconst_0
    //   60: invokeinterface 56 2 0
    //   65: astore 17
    //   67: aload 17
    //   69: astore 8
    //   71: aload 6
    //   73: ifnull +10 -> 83
    //   76: aload 6
    //   78: invokeinterface 87 1 0
    //   83: aload 4
    //   85: ifnull +16 -> 101
    //   88: aload 4
    //   90: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   93: ifeq +8 -> 101
    //   96: aload 4
    //   98: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   101: aload 8
    //   103: areturn
    //   104: astore 7
    //   106: aconst_null
    //   107: astore 6
    //   109: aconst_null
    //   110: astore 4
    //   112: aload 6
    //   114: ifnull +10 -> 124
    //   117: aload 6
    //   119: invokeinterface 87 1 0
    //   124: aconst_null
    //   125: astore 8
    //   127: aload 4
    //   129: ifnull -28 -> 101
    //   132: aload 4
    //   134: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   137: istore 9
    //   139: aconst_null
    //   140: astore 8
    //   142: iload 9
    //   144: ifeq -43 -> 101
    //   147: aload 4
    //   149: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_3
    //   155: aconst_null
    //   156: astore 4
    //   158: aload_3
    //   159: astore 5
    //   161: aconst_null
    //   162: astore 6
    //   164: aload 6
    //   166: ifnull +10 -> 176
    //   169: aload 6
    //   171: invokeinterface 87 1 0
    //   176: aload 4
    //   178: ifnull +16 -> 194
    //   181: aload 4
    //   183: invokevirtual 90	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   186: ifeq +8 -> 194
    //   189: aload 4
    //   191: invokevirtual 91	android/database/sqlite/SQLiteDatabase:close	()V
    //   194: aload 5
    //   196: athrow
    //   197: astore 12
    //   199: aload 12
    //   201: astore 5
    //   203: aconst_null
    //   204: astore 6
    //   206: goto -42 -> 164
    //   209: astore 5
    //   211: goto -47 -> 164
    //   214: astore 11
    //   216: aconst_null
    //   217: astore 6
    //   219: goto -107 -> 112
    //   222: astore 15
    //   224: goto -112 -> 112
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	104	java/lang/Exception
    //   0	6	154	finally
    //   10	36	197	finally
    //   40	49	209	finally
    //   57	67	209	finally
    //   10	36	214	java/lang/Exception
    //   40	49	222	java/lang/Exception
    //   57	67	222	java/lang/Exception
  }

  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
  }

  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("drop table if exists tb_tid");
    paramSQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.tid.a
 * JD-Core Version:    0.6.0
 */