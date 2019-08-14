package com.tencent.wxop.stat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.wxop.stat.b.b;

final class ac extends SQLiteOpenHelper
{
  private String a = "";
  private Context co = null;

  public ac(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 3);
    this.a = paramString;
    this.co = paramContext.getApplicationContext();
    if (c.k())
      t.ao().b("SQLiteOpenHelper " + this.a);
  }

  // ERROR //
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 63
    //   3: aconst_null
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: aconst_null
    //   9: invokevirtual 69	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   12: astore 4
    //   14: aload 4
    //   16: astore_2
    //   17: new 71	android/content/ContentValues
    //   20: dup
    //   21: invokespecial 74	android/content/ContentValues:<init>	()V
    //   24: astore 5
    //   26: aload_2
    //   27: invokeinterface 79 1 0
    //   32: istore 6
    //   34: aconst_null
    //   35: astore 7
    //   37: iload 6
    //   39: ifeq +48 -> 87
    //   42: aload_2
    //   43: iconst_0
    //   44: invokeinterface 83 2 0
    //   49: astore 7
    //   51: aload_2
    //   52: iconst_1
    //   53: invokeinterface 87 2 0
    //   58: pop
    //   59: aload_2
    //   60: iconst_2
    //   61: invokeinterface 83 2 0
    //   66: pop
    //   67: aload_2
    //   68: iconst_3
    //   69: invokeinterface 91 2 0
    //   74: pop2
    //   75: aload 5
    //   77: ldc 93
    //   79: aload 7
    //   81: invokestatic 99	com/tencent/wxop/stat/b/r:q	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokevirtual 103	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 7
    //   89: ifnull +23 -> 112
    //   92: aload_0
    //   93: ldc 63
    //   95: aload 5
    //   97: ldc 105
    //   99: iconst_1
    //   100: anewarray 107	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: aload 7
    //   107: aastore
    //   108: invokevirtual 111	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   111: pop
    //   112: aload_2
    //   113: ifnull +9 -> 122
    //   116: aload_2
    //   117: invokeinterface 114 1 0
    //   122: return
    //   123: astore_3
    //   124: aconst_null
    //   125: astore_2
    //   126: invokestatic 37	com/tencent/wxop/stat/t:ao	()Lcom/tencent/wxop/stat/b/b;
    //   129: aload_3
    //   130: invokevirtual 117	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   133: aload_2
    //   134: ifnull -12 -> 122
    //   137: aload_2
    //   138: invokeinterface 114 1 0
    //   143: return
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_2
    //   147: aload_2
    //   148: ifnull +9 -> 157
    //   151: aload_2
    //   152: invokeinterface 114 1 0
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: goto -13 -> 147
    //   163: astore_3
    //   164: goto -38 -> 126
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	123	java/lang/Throwable
    //   0	14	144	finally
    //   17	34	159	finally
    //   42	87	159	finally
    //   92	112	159	finally
    //   126	133	159	finally
    //   17	34	163	java/lang/Throwable
    //   42	87	163	java/lang/Throwable
    //   92	112	163	java/lang/Throwable
  }

  // ERROR //
  private static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 119
    //   3: aconst_null
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: aconst_null
    //   9: invokevirtual 69	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   12: astore 5
    //   14: aload 5
    //   16: astore 4
    //   18: new 121	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 122	java/util/ArrayList:<init>	()V
    //   25: astore 6
    //   27: aload 4
    //   29: invokeinterface 79 1 0
    //   34: ifeq +75 -> 109
    //   37: aload 6
    //   39: new 124	com/tencent/wxop/stat/ad
    //   42: dup
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 91 2 0
    //   51: aload 4
    //   53: iconst_1
    //   54: invokeinterface 83 2 0
    //   59: aload 4
    //   61: iconst_2
    //   62: invokeinterface 87 2 0
    //   67: aload 4
    //   69: iconst_3
    //   70: invokeinterface 87 2 0
    //   75: invokespecial 127	com/tencent/wxop/stat/ad:<init>	(JLjava/lang/String;II)V
    //   78: invokeinterface 133 2 0
    //   83: pop
    //   84: goto -57 -> 27
    //   87: astore_1
    //   88: aload 4
    //   90: astore_2
    //   91: invokestatic 37	com/tencent/wxop/stat/t:ao	()Lcom/tencent/wxop/stat/b/b;
    //   94: aload_1
    //   95: invokevirtual 117	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   98: aload_2
    //   99: ifnull +9 -> 108
    //   102: aload_2
    //   103: invokeinterface 114 1 0
    //   108: return
    //   109: new 71	android/content/ContentValues
    //   112: dup
    //   113: invokespecial 74	android/content/ContentValues:<init>	()V
    //   116: astore 7
    //   118: aload 6
    //   120: invokeinterface 137 1 0
    //   125: astore 8
    //   127: aload 8
    //   129: invokeinterface 142 1 0
    //   134: ifeq +79 -> 213
    //   137: aload 8
    //   139: invokeinterface 146 1 0
    //   144: checkcast 124	com/tencent/wxop/stat/ad
    //   147: astore 9
    //   149: aload 7
    //   151: ldc 148
    //   153: aload 9
    //   155: getfield 150	com/tencent/wxop/stat/ad:b	Ljava/lang/String;
    //   158: invokestatic 99	com/tencent/wxop/stat/b/r:q	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokevirtual 103	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: iconst_1
    //   165: anewarray 107	java/lang/String
    //   168: astore 10
    //   170: aload 10
    //   172: iconst_0
    //   173: aload 9
    //   175: getfield 154	com/tencent/wxop/stat/ad:K	J
    //   178: invokestatic 159	java/lang/Long:toString	(J)Ljava/lang/String;
    //   181: aastore
    //   182: aload_0
    //   183: ldc 119
    //   185: aload 7
    //   187: ldc 161
    //   189: aload 10
    //   191: invokevirtual 111	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   194: pop
    //   195: goto -68 -> 127
    //   198: astore_3
    //   199: aload 4
    //   201: ifnull +10 -> 211
    //   204: aload 4
    //   206: invokeinterface 114 1 0
    //   211: aload_3
    //   212: athrow
    //   213: aload 4
    //   215: ifnull -107 -> 108
    //   218: aload 4
    //   220: invokeinterface 114 1 0
    //   225: return
    //   226: astore_3
    //   227: aconst_null
    //   228: astore 4
    //   230: goto -31 -> 199
    //   233: astore_3
    //   234: aload_2
    //   235: astore 4
    //   237: goto -38 -> 199
    //   240: astore_1
    //   241: aconst_null
    //   242: astore_2
    //   243: goto -152 -> 91
    //
    // Exception table:
    //   from	to	target	type
    //   18	27	87	java/lang/Throwable
    //   27	84	87	java/lang/Throwable
    //   109	127	87	java/lang/Throwable
    //   127	195	87	java/lang/Throwable
    //   18	27	198	finally
    //   27	84	198	finally
    //   109	127	198	finally
    //   127	195	198	finally
    //   0	14	226	finally
    //   91	98	233	finally
    //   0	14	240	java/lang/Throwable
  }

  public final void close()
  {
    monitorenter;
    try
    {
      super.close();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
    paramSQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    paramSQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
  }

  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    t.ao().debug("upgrade DB from oldVersion " + paramInt1 + " to newVersion " + paramInt2);
    if (paramInt1 == 1)
    {
      paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
    if (paramInt1 == 2)
    {
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.ac
 * JD-Core Version:    0.6.0
 */