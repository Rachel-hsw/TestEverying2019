package com.umeng.message.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import org.android.agoo.c.c.d;
import org.android.agoo.c.c.h;

public class bf
{
  private static final String a = "MessageService";
  private static final String b = "message_db";
  private static final String c = "message";
  private static final int d = 1;
  private static final String e = "id";
  private static final String f = "type";
  private static final String g = "message";
  private static final String h = "notify";
  private static final String i = "report";
  private static final String j = "interval";
  private static final String k = "target_time";
  private static final String l = "create_time";
  private static final String m = "state";
  private static final String n = "body_code";
  private static final int o = 1;
  private static final int p;
  private static volatile bf r = null;
  private volatile SQLiteOpenHelper q = null;
  private Context s;

  private bf(Context paramContext)
  {
    this.s = paramContext;
    this.q = new a(paramContext);
  }

  private long a(long paramLong, int paramInt)
  {
    return paramLong + cl.a(1000 * (paramInt * 60));
  }

  public static bf a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (r == null)
        r = new bf(paramContext);
      bf localbf = r;
      return localbf;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  private void a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 8
    //   2: new 82	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   9: ldc 85
    //   11: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 91
    //   20: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 100	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aconst_null
    //   30: astore 9
    //   32: aload_2
    //   33: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +130 -> 166
    //   39: ldc 108
    //   41: astore_2
    //   42: iconst_m1
    //   43: istore 16
    //   45: aload_3
    //   46: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +6 -> 55
    //   52: ldc 108
    //   54: astore_3
    //   55: aload_0
    //   56: getfield 63	com/umeng/message/b/bf:q	Landroid/database/sqlite/SQLiteOpenHelper;
    //   59: invokevirtual 114	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   62: astore 17
    //   64: aload 17
    //   66: astore 9
    //   68: bipush 9
    //   70: anewarray 4	java/lang/Object
    //   73: astore 19
    //   75: aload 19
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: aload 19
    //   82: iconst_1
    //   83: iload 4
    //   85: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: aload 19
    //   91: iconst_2
    //   92: iload 16
    //   94: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: aload 19
    //   100: iconst_3
    //   101: iconst_0
    //   102: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: aload 19
    //   108: iconst_4
    //   109: lload 5
    //   111: invokestatic 125	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: aastore
    //   115: aload 19
    //   117: iconst_5
    //   118: iload 7
    //   120: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: aload 19
    //   126: bipush 6
    //   128: aload_3
    //   129: aastore
    //   130: aload 19
    //   132: bipush 7
    //   134: aload_2
    //   135: aastore
    //   136: aload 19
    //   138: bipush 8
    //   140: iload 8
    //   142: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aastore
    //   146: aload 9
    //   148: ldc 127
    //   150: aload 19
    //   152: invokevirtual 133	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload 9
    //   157: ifnull +8 -> 165
    //   160: aload 9
    //   162: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   165: return
    //   166: aload_2
    //   167: invokevirtual 142	java/lang/String:hashCode	()I
    //   170: istore 21
    //   172: iload 21
    //   174: istore 16
    //   176: goto -131 -> 45
    //   179: astore 14
    //   181: aload 9
    //   183: ifnull -18 -> 165
    //   186: aload 9
    //   188: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   191: return
    //   192: astore 15
    //   194: return
    //   195: astore 10
    //   197: aconst_null
    //   198: astore 11
    //   200: aload 10
    //   202: astore 12
    //   204: aload 11
    //   206: ifnull +8 -> 214
    //   209: aload 11
    //   211: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   214: aload 12
    //   216: athrow
    //   217: astore 20
    //   219: return
    //   220: astore 13
    //   222: goto -8 -> 214
    //   225: astore 18
    //   227: aload 9
    //   229: astore 11
    //   231: aload 18
    //   233: astore 12
    //   235: goto -31 -> 204
    //
    // Exception table:
    //   from	to	target	type
    //   32	39	179	java/lang/Throwable
    //   45	52	179	java/lang/Throwable
    //   55	64	179	java/lang/Throwable
    //   68	155	179	java/lang/Throwable
    //   166	172	179	java/lang/Throwable
    //   186	191	192	java/lang/Throwable
    //   32	39	195	finally
    //   45	52	195	finally
    //   55	64	195	finally
    //   166	172	195	finally
    //   160	165	217	java/lang/Throwable
    //   209	214	220	java/lang/Throwable
    //   68	155	225	finally
  }

  private void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramLong < System.currentTimeMillis())
    {
      ay.c("MessageService", "sendAtTime messageId[" + paramString1 + "] targetTime[" + ce.a(paramLong) + "] <=currentTime[" + ce.a(System.currentTimeMillis()) + "]");
      return;
    }
    long l1 = a(paramLong, paramInt1);
    ay.c("MessageService", "sendAtTime message---->[" + paramString1 + "]serverTime--->[" + ce.a(paramLong) + "," + paramInt1 + " min]targetTime---->[" + ce.a(l1) + "]");
    Bundle localBundle = new Bundle();
    localBundle.putString("body", paramString2);
    localBundle.putString("id", paramString1);
    localBundle.putString("type", paramString3);
    localBundle.putBoolean("local", true);
    localBundle.putString("notify", "" + paramInt2);
    AlarmManager localAlarmManager = (AlarmManager)this.s.getSystemService("alarm");
    Intent localIntent = new Intent();
    localIntent.setAction("org.agoo.android.intent.action.RECEIVE");
    localIntent.setPackage(this.s.getPackageName());
    localIntent.putExtras(localBundle);
    localAlarmManager.set(1, l1, PendingIntent.getBroadcast(this.s, paramString1.hashCode(), localIntent, 134217728));
  }

  public void a()
  {
    a(30);
  }

  // ERROR //
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iload_1
    //   3: bipush 7
    //   5: if_icmple +91 -> 96
    //   8: aload_0
    //   9: getfield 63	com/umeng/message/b/bf:q	Landroid/database/sqlite/SQLiteOpenHelper;
    //   12: invokevirtual 114	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore_2
    //   16: aload_2
    //   17: new 82	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   24: ldc 232
    //   26: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload_1
    //   30: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc 234
    //   35: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 237	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   52: return
    //   53: astore 5
    //   55: ldc 8
    //   57: ldc 239
    //   59: aload 5
    //   61: invokestatic 244	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   64: pop
    //   65: aload_2
    //   66: ifnull -14 -> 52
    //   69: aload_2
    //   70: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   73: return
    //   74: astore 7
    //   76: return
    //   77: astore_3
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   86: aload_3
    //   87: athrow
    //   88: astore 8
    //   90: return
    //   91: astore 4
    //   93: goto -7 -> 86
    //   96: bipush 7
    //   98: istore_1
    //   99: goto -91 -> 8
    //
    // Exception table:
    //   from	to	target	type
    //   8	44	53	java/lang/Throwable
    //   69	73	74	java/lang/Throwable
    //   8	44	77	finally
    //   55	65	77	finally
    //   48	52	88	java/lang/Throwable
    //   82	86	91	java/lang/Throwable
  }

  // ERROR //
  public void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 63	com/umeng/message/b/bf:q	Landroid/database/sqlite/SQLiteOpenHelper;
    //   6: invokevirtual 114	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_2
    //   10: aload_2
    //   11: ldc 246
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: invokevirtual 133	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aload_2
    //   25: ifnull +7 -> 32
    //   28: aload_2
    //   29: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   32: return
    //   33: astore 5
    //   35: ldc 8
    //   37: ldc 239
    //   39: aload 5
    //   41: invokestatic 244	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   44: pop
    //   45: aload_2
    //   46: ifnull -14 -> 32
    //   49: aload_2
    //   50: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   53: return
    //   54: astore 7
    //   56: return
    //   57: astore_3
    //   58: aload_2
    //   59: ifnull +7 -> 66
    //   62: aload_2
    //   63: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   66: aload_3
    //   67: athrow
    //   68: astore 8
    //   70: return
    //   71: astore 4
    //   73: goto -7 -> 66
    //
    // Exception table:
    //   from	to	target	type
    //   2	24	33	java/lang/Throwable
    //   49	53	54	java/lang/Throwable
    //   2	24	57	finally
    //   35	45	57	finally
    //   28	32	68	java/lang/Throwable
    //   62	66	71	java/lang/Throwable
  }

  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(paramString1, paramString2, paramString3, 1, -1L, -1, paramInt);
  }

  // ERROR //
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    // Byte code:
    //   0: aload 4
    //   2: ldc 254
    //   4: invokevirtual 258	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   7: astore 6
    //   9: aload 6
    //   11: arraylength
    //   12: iconst_2
    //   13: if_icmpne +215 -> 228
    //   16: aload 6
    //   18: iconst_0
    //   19: aaload
    //   20: invokestatic 262	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   23: lstore 13
    //   25: lload 13
    //   27: lstore 11
    //   29: aload 6
    //   31: iconst_1
    //   32: aaload
    //   33: invokestatic 266	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   36: istore 16
    //   38: iload 16
    //   40: istore 7
    //   42: lload 11
    //   44: lstore 8
    //   46: lload 8
    //   48: ldc2_w 248
    //   51: lcmp
    //   52: ifeq +18 -> 70
    //   55: iload 7
    //   57: iconst_m1
    //   58: if_icmpeq +12 -> 70
    //   61: lload 8
    //   63: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   66: lcmp
    //   67: ifge +70 -> 137
    //   70: ldc 8
    //   72: new 82	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 268
    //   82: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 270
    //   92: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: lload 8
    //   97: invokestatic 158	com/umeng/message/b/ce:a	(J)Ljava/lang/String;
    //   100: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 160
    //   105: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   111: invokestatic 158	com/umeng/message/b/ce:a	(J)Ljava/lang/String;
    //   114: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 91
    //   119: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 272	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: aload_1
    //   130: aload_2
    //   131: aload_3
    //   132: iload 5
    //   134: invokevirtual 274	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   137: lload 8
    //   139: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   142: lcmp
    //   143: iflt +30 -> 173
    //   146: aload_0
    //   147: aload_1
    //   148: aload_2
    //   149: aload_3
    //   150: iconst_0
    //   151: lload 8
    //   153: iload 7
    //   155: iload 5
    //   157: invokespecial 251	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJII)V
    //   160: aload_0
    //   161: aload_1
    //   162: aload_2
    //   163: aload_3
    //   164: lload 8
    //   166: iload 7
    //   168: iload 5
    //   170: invokespecial 276	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JII)V
    //   173: return
    //   174: astore 10
    //   176: ldc2_w 248
    //   179: lstore 11
    //   181: ldc 8
    //   183: new 82	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 278
    //   193: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 4
    //   198: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 280
    //   204: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 272	com/umeng/message/b/ay:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: iconst_m1
    //   214: istore 7
    //   216: lload 11
    //   218: lstore 8
    //   220: goto -174 -> 46
    //   223: astore 15
    //   225: goto -44 -> 181
    //   228: iconst_m1
    //   229: istore 7
    //   231: ldc2_w 248
    //   234: lstore 8
    //   236: goto -190 -> 46
    //
    // Exception table:
    //   from	to	target	type
    //   16	25	174	java/lang/Throwable
    //   29	38	223	java/lang/Throwable
  }

  // ERROR //
  public boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 63	com/umeng/message/b/bf:q	Landroid/database/sqlite/SQLiteOpenHelper;
    //   6: invokevirtual 114	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 10
    //   11: aload 10
    //   13: astore 5
    //   15: iconst_2
    //   16: anewarray 138	java/lang/String
    //   19: astore 12
    //   21: aload 12
    //   23: iconst_0
    //   24: aload_1
    //   25: aastore
    //   26: aload 12
    //   28: iconst_1
    //   29: new 82	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   36: ldc 108
    //   38: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: iload_2
    //   42: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: aastore
    //   49: aload 5
    //   51: ldc_w 283
    //   54: aload 12
    //   56: invokevirtual 287	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore_3
    //   60: iconst_0
    //   61: istore 8
    //   63: aload_3
    //   64: ifnull +39 -> 103
    //   67: aload_3
    //   68: invokeinterface 293 1 0
    //   73: istore 13
    //   75: iconst_0
    //   76: istore 8
    //   78: iload 13
    //   80: ifeq +23 -> 103
    //   83: aload_3
    //   84: iconst_0
    //   85: invokeinterface 297 2 0
    //   90: istore 14
    //   92: iconst_0
    //   93: istore 8
    //   95: iload 14
    //   97: ifle +6 -> 103
    //   100: iconst_1
    //   101: istore 8
    //   103: aload_3
    //   104: ifnull +9 -> 113
    //   107: aload_3
    //   108: invokeinterface 298 1 0
    //   113: aload 5
    //   115: ifnull +8 -> 123
    //   118: aload 5
    //   120: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   123: iload 8
    //   125: ireturn
    //   126: astore 7
    //   128: aconst_null
    //   129: astore 5
    //   131: aload_3
    //   132: ifnull +9 -> 141
    //   135: aload_3
    //   136: invokeinterface 298 1 0
    //   141: iconst_0
    //   142: istore 8
    //   144: aload 5
    //   146: ifnull -23 -> 123
    //   149: aload 5
    //   151: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore 9
    //   158: iconst_0
    //   159: ireturn
    //   160: astore 4
    //   162: aconst_null
    //   163: astore 5
    //   165: aload_3
    //   166: ifnull +9 -> 175
    //   169: aload_3
    //   170: invokeinterface 298 1 0
    //   175: aload 5
    //   177: ifnull +8 -> 185
    //   180: aload 5
    //   182: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   185: aload 4
    //   187: athrow
    //   188: astore 6
    //   190: goto -5 -> 185
    //   193: astore 4
    //   195: goto -30 -> 165
    //   198: astore 11
    //   200: goto -69 -> 131
    //   203: astore 15
    //   205: iload 8
    //   207: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	126	java/lang/Throwable
    //   135	141	156	java/lang/Throwable
    //   149	154	156	java/lang/Throwable
    //   2	11	160	finally
    //   169	175	188	java/lang/Throwable
    //   180	185	188	java/lang/Throwable
    //   15	60	193	finally
    //   67	75	193	finally
    //   83	92	193	finally
    //   15	60	198	java/lang/Throwable
    //   67	75	198	java/lang/Throwable
    //   83	92	198	java/lang/Throwable
    //   107	113	203	java/lang/Throwable
    //   118	123	203	java/lang/Throwable
  }

  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, null);
  }

  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    boolean bool = TextUtils.isEmpty(paramString3);
    int i1 = 0;
    if (!bool);
    try
    {
      int i2 = Integer.parseInt(paramString3);
      i1 = 0;
      if (i2 >= -1)
      {
        d locald = new d();
        locald.c("mtop.push.msg.report");
        locald.d("1.0");
        locald.a("messageId", paramString1 + "@" + paramString4);
        locald.a("mesgStatus", paramString7);
        if (!TextUtils.isEmpty(paramString8))
          locald.a("del_pack", paramString8);
        if (!TextUtils.isEmpty(paramString5))
          locald.a("trace", paramString5);
        if (!TextUtils.isEmpty(paramString6))
          locald.a("ec", paramString6);
        if (!TextUtils.isEmpty(paramString2))
          locald.a("taskId", paramString2);
        locald.a(org.android.agoo.client.b.getRegistrationId(this.s));
        h localh = new h();
        localh.a(af.f(this.s));
        localh.b(af.j(this.s));
        localh.c(af.G(this.s));
        localh.a(this.s, locald);
        i1 = 1;
      }
      return i1;
    }
    catch (Throwable localThrowable)
    {
      ay.e("MessageService", "[" + paramString3 + "] to Integer error", localThrowable);
    }
    return false;
  }

  // ERROR //
  public void b()
  {
    // Byte code:
    //   0: ldc 8
    //   2: ldc_w 364
    //   5: invokestatic 100	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 63	com/umeng/message/b/bf:q	Landroid/database/sqlite/SQLiteOpenHelper;
    //   12: invokevirtual 114	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 10
    //   17: aload 10
    //   19: astore 7
    //   21: aload 7
    //   23: ldc_w 366
    //   26: invokevirtual 237	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   29: aload 7
    //   31: ldc_w 368
    //   34: iconst_1
    //   35: anewarray 138	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: ldc_w 370
    //   43: aastore
    //   44: invokevirtual 287	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore 13
    //   49: aload 13
    //   51: astore 6
    //   53: aload 6
    //   55: ifnull +103 -> 158
    //   58: aload 6
    //   60: invokeinterface 373 1 0
    //   65: ifeq +93 -> 158
    //   68: aload_0
    //   69: aload 6
    //   71: iconst_0
    //   72: invokeinterface 377 2 0
    //   77: aload 6
    //   79: iconst_1
    //   80: invokeinterface 377 2 0
    //   85: aload 6
    //   87: iconst_2
    //   88: invokeinterface 377 2 0
    //   93: aload 6
    //   95: iconst_3
    //   96: invokeinterface 381 2 0
    //   101: aload 6
    //   103: iconst_4
    //   104: invokeinterface 297 2 0
    //   109: aload 6
    //   111: iconst_5
    //   112: invokeinterface 297 2 0
    //   117: invokespecial 276	com/umeng/message/b/bf:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JII)V
    //   120: goto -62 -> 58
    //   123: astore 15
    //   125: aload 6
    //   127: astore_2
    //   128: aload 7
    //   130: astore_3
    //   131: aload_2
    //   132: ifnull +9 -> 141
    //   135: aload_2
    //   136: invokeinterface 298 1 0
    //   141: aload_3
    //   142: ifnull +7 -> 149
    //   145: aload_3
    //   146: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   149: ldc 8
    //   151: ldc_w 383
    //   154: invokestatic 100	com/umeng/message/b/ay:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: return
    //   158: aload 6
    //   160: ifnull +10 -> 170
    //   163: aload 6
    //   165: invokeinterface 298 1 0
    //   170: aload 7
    //   172: ifnull -23 -> 149
    //   175: aload 7
    //   177: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   180: goto -31 -> 149
    //   183: astore 14
    //   185: goto -36 -> 149
    //   188: astore 5
    //   190: aconst_null
    //   191: astore 6
    //   193: aconst_null
    //   194: astore 7
    //   196: aload 5
    //   198: astore 8
    //   200: aload 6
    //   202: ifnull +10 -> 212
    //   205: aload 6
    //   207: invokeinterface 298 1 0
    //   212: aload 7
    //   214: ifnull +8 -> 222
    //   217: aload 7
    //   219: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   222: aload 8
    //   224: athrow
    //   225: astore 9
    //   227: goto -5 -> 222
    //   230: astore 12
    //   232: aload 12
    //   234: astore 8
    //   236: aconst_null
    //   237: astore 6
    //   239: goto -39 -> 200
    //   242: astore 8
    //   244: goto -44 -> 200
    //   247: astore 4
    //   249: goto -100 -> 149
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_3
    //   257: goto -126 -> 131
    //   260: astore 11
    //   262: aload 7
    //   264: astore_3
    //   265: aconst_null
    //   266: astore_2
    //   267: goto -136 -> 131
    //
    // Exception table:
    //   from	to	target	type
    //   58	120	123	java/lang/Throwable
    //   163	170	183	java/lang/Throwable
    //   175	180	183	java/lang/Throwable
    //   8	17	188	finally
    //   205	212	225	java/lang/Throwable
    //   217	222	225	java/lang/Throwable
    //   21	49	230	finally
    //   58	120	242	finally
    //   135	141	247	java/lang/Throwable
    //   145	149	247	java/lang/Throwable
    //   8	17	252	java/lang/Throwable
    //   21	49	260	java/lang/Throwable
  }

  // ERROR //
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 63	com/umeng/message/b/bf:q	Landroid/database/sqlite/SQLiteOpenHelper;
    //   6: invokevirtual 114	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 9
    //   11: aload 9
    //   13: astore 4
    //   15: aload 4
    //   17: ldc_w 386
    //   20: iconst_1
    //   21: anewarray 138	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: aastore
    //   28: invokevirtual 287	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_2
    //   32: iconst_0
    //   33: istore 7
    //   35: aload_2
    //   36: ifnull +39 -> 75
    //   39: aload_2
    //   40: invokeinterface 293 1 0
    //   45: istore 11
    //   47: iconst_0
    //   48: istore 7
    //   50: iload 11
    //   52: ifeq +23 -> 75
    //   55: aload_2
    //   56: iconst_0
    //   57: invokeinterface 297 2 0
    //   62: istore 12
    //   64: iconst_0
    //   65: istore 7
    //   67: iload 12
    //   69: ifle +6 -> 75
    //   72: iconst_1
    //   73: istore 7
    //   75: aload_2
    //   76: ifnull +9 -> 85
    //   79: aload_2
    //   80: invokeinterface 298 1 0
    //   85: aload 4
    //   87: ifnull +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   95: iload 7
    //   97: ireturn
    //   98: astore 6
    //   100: aconst_null
    //   101: astore 4
    //   103: aload_2
    //   104: ifnull +9 -> 113
    //   107: aload_2
    //   108: invokeinterface 298 1 0
    //   113: iconst_0
    //   114: istore 7
    //   116: aload 4
    //   118: ifnull -23 -> 95
    //   121: aload 4
    //   123: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   126: iconst_0
    //   127: ireturn
    //   128: astore 8
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_3
    //   133: aconst_null
    //   134: astore 4
    //   136: aload_2
    //   137: ifnull +9 -> 146
    //   140: aload_2
    //   141: invokeinterface 298 1 0
    //   146: aload 4
    //   148: ifnull +8 -> 156
    //   151: aload 4
    //   153: invokevirtual 136	android/database/sqlite/SQLiteDatabase:close	()V
    //   156: aload_3
    //   157: athrow
    //   158: astore 5
    //   160: goto -4 -> 156
    //   163: astore_3
    //   164: goto -28 -> 136
    //   167: astore 10
    //   169: goto -66 -> 103
    //   172: astore 13
    //   174: iload 7
    //   176: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	98	java/lang/Throwable
    //   107	113	128	java/lang/Throwable
    //   121	126	128	java/lang/Throwable
    //   2	11	132	finally
    //   140	146	158	java/lang/Throwable
    //   151	156	158	java/lang/Throwable
    //   15	32	163	finally
    //   39	47	163	finally
    //   55	64	163	finally
    //   15	32	167	java/lang/Throwable
    //   39	47	167	java/lang/Throwable
    //   55	64	167	java/lang/Throwable
    //   79	85	172	java/lang/Throwable
    //   90	95	172	java/lang/Throwable
  }

  static class a extends SQLiteOpenHelper
  {
    public a(Context paramContext)
    {
      super("message_db", null, 1);
    }

    private String a()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("create table message");
      localStringBuffer.append("(");
      localStringBuffer.append("id text UNIQUE not null,");
      localStringBuffer.append("state integer,");
      localStringBuffer.append("body_code integer,");
      localStringBuffer.append("report long,");
      localStringBuffer.append("target_time long,");
      localStringBuffer.append("interval integer,");
      localStringBuffer.append("type text,");
      localStringBuffer.append("message text,");
      localStringBuffer.append("notify integer,");
      localStringBuffer.append("create_time date");
      localStringBuffer.append(");");
      return localStringBuffer.toString();
    }

    private String b()
    {
      return "CREATE INDEX body_code_index ON message(body_code)";
    }

    private String c()
    {
      return "CREATE INDEX id_index ON message(id)";
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      if (paramSQLiteDatabase != null);
      try
      {
        paramSQLiteDatabase.execSQL(a());
        paramSQLiteDatabase.execSQL(c());
        paramSQLiteDatabase.execSQL(b());
        return;
      }
      catch (Throwable localThrowable)
      {
        ay.d("MessageService", "messagedbhelper create", localThrowable);
      }
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      if (paramSQLiteDatabase != null);
      try
      {
        paramSQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
        return;
      }
      catch (Throwable localThrowable)
      {
        ay.d("MessageService", "messagedbhelper create", localThrowable);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bf
 * JD-Core Version:    0.6.0
 */