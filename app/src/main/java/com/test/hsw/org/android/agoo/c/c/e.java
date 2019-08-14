package org.android.agoo.c.c;

import com.umeng.message.b.ay;
import com.umeng.message.b.cf;
import com.umeng.message.b.co;
import java.io.ByteArrayInputStream;
import java.util.Map;
import org.json.JSONObject;

public class e
{
  public static final String a = "&";
  private static final String b = "MtopRequestHelper";

  private static final long a()
  {
    try
    {
      long l = System.currentTimeMillis() / 1000L;
      return l;
    }
    catch (Throwable localThrowable)
    {
      ay.d("MtopRequestHelper", "getTime", localThrowable);
    }
    return 0L;
  }

  private static final String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8)
    throws Throwable
  {
    try
    {
      String str1 = cf.a(new ByteArrayInputStream(paramString1.getBytes("UTF-8")));
      StringBuffer localStringBuffer = new StringBuffer();
      if ((paramString8 != null) && (!"".equals(paramString8)))
      {
        localStringBuffer.append(paramString8);
        localStringBuffer.append("&");
      }
      localStringBuffer.append(paramString2);
      localStringBuffer.append("&");
      localStringBuffer.append(str1);
      localStringBuffer.append("&");
      localStringBuffer.append(paramString3);
      localStringBuffer.append("&");
      localStringBuffer.append(paramString4);
      localStringBuffer.append("&");
      localStringBuffer.append(paramString5);
      localStringBuffer.append("&");
      localStringBuffer.append(paramString6);
      localStringBuffer.append("&");
      localStringBuffer.append(cf.a(new ByteArrayInputStream(paramString7.getBytes("UTF-8"))));
      localStringBuffer.append("&");
      localStringBuffer.append(paramLong);
      String str2 = cf.a(new ByteArrayInputStream(localStringBuffer.toString().getBytes("UTF-8")));
      return str2;
    }
    catch (Throwable localThrowable)
    {
      ay.d("MtopRequestHelper", "toV3Sign", localThrowable);
    }
    return null;
  }

  private static final String a(Map<String, Object> paramMap)
  {
    try
    {
      String str = new JSONObject(paramMap).toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
      ay.d("MtopRequestHelper", "param2String", localThrowable);
    }
    return null;
  }

  // ERROR //
  public static final org.android.agoo.c.a.d a(android.content.Context paramContext, d paramd)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 86	org/android/agoo/c/a/d
    //   9: dup
    //   10: invokespecial 87	org/android/agoo/c/a/d:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 89
    //   17: aload_1
    //   18: invokevirtual 94	org/android/agoo/c/c/d:f	()Ljava/lang/String;
    //   21: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_2
    //   25: ldc 99
    //   27: aload_1
    //   28: invokevirtual 102	org/android/agoo/c/c/d:g	()Ljava/lang/String;
    //   31: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 104	org/android/agoo/c/c/d:b	()J
    //   38: lstore 4
    //   40: lload 4
    //   42: lconst_0
    //   43: lcmp
    //   44: ifgt +8 -> 52
    //   47: invokestatic 106	org/android/agoo/c/c/e:a	()J
    //   50: lstore 4
    //   52: aload_2
    //   53: ldc 108
    //   55: new 110	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   62: ldc 57
    //   64: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: lload 4
    //   69: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_0
    //   79: ifnull +353 -> 432
    //   82: aload_0
    //   83: invokestatic 123	com/umeng/message/b/cm:a	(Landroid/content/Context;)Ljava/lang/String;
    //   86: astore 6
    //   88: aload_0
    //   89: invokestatic 125	com/umeng/message/b/cm:b	(Landroid/content/Context;)Ljava/lang/String;
    //   92: astore 7
    //   94: aload_2
    //   95: ldc 127
    //   97: aload 6
    //   99: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_2
    //   103: ldc 129
    //   105: aload 7
    //   107: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_2
    //   111: ldc 131
    //   113: aload_1
    //   114: invokevirtual 134	org/android/agoo/c/c/d:e	()Ljava/lang/String;
    //   117: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_2
    //   121: ldc 136
    //   123: aload_1
    //   124: invokevirtual 139	org/android/agoo/c/c/d:k	()Ljava/lang/String;
    //   127: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_1
    //   131: invokevirtual 142	org/android/agoo/c/c/d:c	()Ljava/lang/String;
    //   134: invokestatic 147	com/umeng/message/b/co:a	(Ljava/lang/String;)Z
    //   137: ifne +13 -> 150
    //   140: aload_2
    //   141: ldc 149
    //   143: aload_1
    //   144: invokevirtual 142	org/android/agoo/c/c/d:c	()Ljava/lang/String;
    //   147: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_1
    //   151: invokevirtual 152	org/android/agoo/c/c/d:d	()Ljava/util/Map;
    //   154: astore 8
    //   156: aload 8
    //   158: ifnull +108 -> 266
    //   161: aload 8
    //   163: invokeinterface 158 1 0
    //   168: invokeinterface 164 1 0
    //   173: astore 9
    //   175: aload 9
    //   177: ifnull +89 -> 266
    //   180: aload 9
    //   182: invokeinterface 170 1 0
    //   187: ifeq +79 -> 266
    //   190: aload 9
    //   192: invokeinterface 174 1 0
    //   197: checkcast 176	java/util/Map$Entry
    //   200: astore 14
    //   202: aload 14
    //   204: ifnull -24 -> 180
    //   207: aload 14
    //   209: invokeinterface 179 1 0
    //   214: checkcast 40	java/lang/String
    //   217: invokestatic 147	com/umeng/message/b/co:a	(Ljava/lang/String;)Z
    //   220: ifne -40 -> 180
    //   223: aload 14
    //   225: invokeinterface 182 1 0
    //   230: checkcast 40	java/lang/String
    //   233: invokestatic 147	com/umeng/message/b/co:a	(Ljava/lang/String;)Z
    //   236: ifne -56 -> 180
    //   239: aload_2
    //   240: aload 14
    //   242: invokeinterface 179 1 0
    //   247: checkcast 40	java/lang/String
    //   250: aload 14
    //   252: invokeinterface 182 1 0
    //   257: checkcast 40	java/lang/String
    //   260: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: goto -83 -> 180
    //   266: aload_1
    //   267: invokevirtual 185	org/android/agoo/c/c/d:j	()Ljava/util/Map;
    //   270: invokestatic 187	org/android/agoo/c/c/e:a	(Ljava/util/Map;)Ljava/lang/String;
    //   273: astore 10
    //   275: aload 10
    //   277: invokestatic 147	com/umeng/message/b/co:a	(Ljava/lang/String;)Z
    //   280: ifeq +10 -> 290
    //   283: ldc 11
    //   285: ldc 189
    //   287: invokestatic 191	com/umeng/message/b/ay:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload_1
    //   291: invokevirtual 139	org/android/agoo/c/c/d:k	()Ljava/lang/String;
    //   294: astore 11
    //   296: aload 11
    //   298: invokestatic 147	com/umeng/message/b/co:a	(Ljava/lang/String;)Z
    //   301: ifeq +10 -> 311
    //   304: ldc 11
    //   306: ldc 193
    //   308: invokestatic 191	com/umeng/message/b/ay:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload_1
    //   312: invokevirtual 196	org/android/agoo/c/c/d:l	()Ljava/lang/String;
    //   315: astore 12
    //   317: aload_1
    //   318: invokevirtual 198	org/android/agoo/c/c/d:a	()Z
    //   321: ifeq +48 -> 369
    //   324: aload 11
    //   326: aload 12
    //   328: aload_1
    //   329: invokevirtual 94	org/android/agoo/c/c/d:f	()Ljava/lang/String;
    //   332: aload_1
    //   333: invokevirtual 102	org/android/agoo/c/c/d:g	()Ljava/lang/String;
    //   336: aload 6
    //   338: aload 7
    //   340: lload 4
    //   342: aload 10
    //   344: aload_1
    //   345: invokevirtual 201	org/android/agoo/c/c/d:i	()Ljava/lang/String;
    //   348: invokestatic 203	org/android/agoo/c/c/e:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   351: astore 13
    //   353: aload 10
    //   355: invokestatic 147	com/umeng/message/b/co:a	(Ljava/lang/String;)Z
    //   358: ifne +50 -> 408
    //   361: aload_2
    //   362: ldc 205
    //   364: aload 13
    //   366: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 10
    //   371: invokestatic 147	com/umeng/message/b/co:a	(Ljava/lang/String;)Z
    //   374: ifne +44 -> 418
    //   377: aload_2
    //   378: ldc 207
    //   380: aload 10
    //   382: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload_1
    //   386: invokevirtual 210	org/android/agoo/c/c/d:h	()Ljava/lang/String;
    //   389: invokestatic 147	com/umeng/message/b/co:a	(Ljava/lang/String;)Z
    //   392: ifne +52 -> 444
    //   395: aload_2
    //   396: ldc 212
    //   398: aload_1
    //   399: invokevirtual 210	org/android/agoo/c/c/d:h	()Ljava/lang/String;
    //   402: invokevirtual 97	org/android/agoo/c/a/d:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: goto +39 -> 444
    //   408: ldc 11
    //   410: ldc 214
    //   412: invokestatic 191	com/umeng/message/b/ay:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: goto -46 -> 369
    //   418: ldc 11
    //   420: ldc 189
    //   422: invokestatic 191	com/umeng/message/b/ay:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: goto -40 -> 385
    //   428: astore 15
    //   430: aconst_null
    //   431: areturn
    //   432: aconst_null
    //   433: astore 6
    //   435: aconst_null
    //   436: astore 7
    //   438: goto -344 -> 94
    //   441: astore_3
    //   442: aload_2
    //   443: areturn
    //   444: aload_2
    //   445: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   6	14	428	java/lang/Throwable
    //   14	40	441	java/lang/Throwable
    //   47	52	441	java/lang/Throwable
    //   52	78	441	java/lang/Throwable
    //   82	94	441	java/lang/Throwable
    //   94	150	441	java/lang/Throwable
    //   150	156	441	java/lang/Throwable
    //   161	175	441	java/lang/Throwable
    //   180	202	441	java/lang/Throwable
    //   207	263	441	java/lang/Throwable
    //   266	290	441	java/lang/Throwable
    //   290	311	441	java/lang/Throwable
    //   311	369	441	java/lang/Throwable
    //   369	385	441	java/lang/Throwable
    //   385	405	441	java/lang/Throwable
    //   408	415	441	java/lang/Throwable
    //   418	425	441	java/lang/Throwable
  }

  public static final void a(d paramd, String paramString1, String paramString2)
  {
    try
    {
      if ((!co.a(paramString1)) && (co.a(paramd.k())))
        paramd.g(paramString1);
      if ((!co.a(paramString2)) && (co.a(paramd.l())))
        paramd.h(paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.d("MtopRequestHelper", "checkAppKeyAndAppSecret", localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.c.e
 * JD-Core Version:    0.6.0
 */