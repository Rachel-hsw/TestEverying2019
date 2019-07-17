package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.b.a;
import com.android.volley.i;
import com.android.volley.o;
import com.android.volley.v;
import com.android.volley.x;
import com.android.volley.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class c
  implements i
{
  protected static final boolean a = y.b;
  private static int d = 3000;
  private static int e = 4096;
  protected final j b;
  protected final d c;

  public c(j paramj)
  {
    this(paramj, new d(e));
  }

  public c(j paramj, d paramd)
  {
    this.b = paramj;
    this.c = paramd;
  }

  protected static Map<String, String> a(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfHeader.length)
        return localTreeMap;
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
    }
  }

  private void a(long paramLong, o<?> paramo, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    Object[] arrayOfObject;
    if ((a) || (paramLong > d))
    {
      arrayOfObject = new Object[5];
      arrayOfObject[0] = paramo;
      arrayOfObject[1] = Long.valueOf(paramLong);
      if (paramArrayOfByte == null)
        break label91;
    }
    label91: for (Object localObject = Integer.valueOf(paramArrayOfByte.length); ; localObject = "null")
    {
      arrayOfObject[2] = localObject;
      arrayOfObject[3] = Integer.valueOf(paramStatusLine.getStatusCode());
      arrayOfObject[4] = Integer.valueOf(paramo.y().b());
      y.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", arrayOfObject);
      return;
    }
  }

  private static void a(String paramString, o<?> paramo, x paramx)
    throws x
  {
    com.android.volley.u localu = paramo.y();
    int i = paramo.x();
    try
    {
      localu.a(paramx);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(i);
      paramo.a(String.format("%s-retry [timeout=%s]", arrayOfObject2));
      return;
    }
    catch (x localx)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramString;
      arrayOfObject1[1] = Integer.valueOf(i);
      paramo.a(String.format("%s-timeout-giveup [timeout=%s]", arrayOfObject1));
    }
    throw localx;
  }

  private void a(Map<String, String> paramMap, b.a parama)
  {
    if (parama == null);
    do
    {
      return;
      if (parama.b == null)
        continue;
      paramMap.put("If-None-Match", parama.b);
    }
    while (parama.d <= 0L);
    paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(parama.d)));
  }

  private byte[] a(HttpEntity paramHttpEntity)
    throws IOException, v
  {
    u localu = new u(this.c, (int)paramHttpEntity.getContentLength());
    byte[] arrayOfByte1 = null;
    InputStream localInputStream;
    try
    {
      localInputStream = paramHttpEntity.getContent();
      arrayOfByte1 = null;
      if (localInputStream == null)
        throw new v();
    }
    finally
    {
    }
    try
    {
      paramHttpEntity.consumeContent();
      this.c.a(arrayOfByte1);
      localu.close();
      throw localObject;
      arrayOfByte1 = this.c.a(1024);
      while (true)
      {
        int i = localInputStream.read(arrayOfByte1);
        byte[] arrayOfByte2;
        if (i == -1)
          arrayOfByte2 = localu.toByteArray();
        try
        {
          paramHttpEntity.consumeContent();
          this.c.a(arrayOfByte1);
          localu.close();
          return arrayOfByte2;
          localu.write(arrayOfByte1, 0, i);
        }
        catch (IOException localIOException2)
        {
          while (true)
            y.a("Error occured when calling consumingContent", new Object[0]);
        }
      }
    }
    catch (IOException localIOException1)
    {
      while (true)
        y.a("Error occured when calling consumingContent", new Object[0]);
    }
  }

  // ERROR //
  public com.android.volley.l a(o<?> paramo)
    throws x
  {
    // Byte code:
    //   0: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: invokestatic 218	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   10: astore 5
    //   12: new 220	java/util/HashMap
    //   15: dup
    //   16: invokespecial 221	java/util/HashMap:<init>	()V
    //   19: astore 6
    //   21: aload_0
    //   22: aload 6
    //   24: aload_1
    //   25: invokevirtual 225	com/android/volley/o:n	()Lcom/android/volley/b$a;
    //   28: invokespecial 227	com/android/volley/toolbox/c:a	(Ljava/util/Map;Lcom/android/volley/b$a;)V
    //   31: aload_0
    //   32: getfield 41	com/android/volley/toolbox/c:b	Lcom/android/volley/toolbox/j;
    //   35: aload_1
    //   36: aload 6
    //   38: invokeinterface 232 3 0
    //   43: astore 16
    //   45: aload 16
    //   47: invokeinterface 238 1 0
    //   52: astore 17
    //   54: aload 17
    //   56: invokeinterface 88 1 0
    //   61: istore 18
    //   63: aload 16
    //   65: invokeinterface 242 1 0
    //   70: invokestatic 244	com/android/volley/toolbox/c:a	([Lorg/apache/http/Header;)Ljava/util/Map;
    //   73: astore 5
    //   75: iload 18
    //   77: sipush 304
    //   80: if_icmpne +515 -> 595
    //   83: aload_1
    //   84: invokevirtual 225	com/android/volley/o:n	()Lcom/android/volley/b$a;
    //   87: astore 19
    //   89: aload 19
    //   91: ifnonnull +23 -> 114
    //   94: new 246	com/android/volley/l
    //   97: dup
    //   98: sipush 304
    //   101: aconst_null
    //   102: aload 5
    //   104: iconst_1
    //   105: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   108: lload_2
    //   109: lsub
    //   110: invokespecial 249	com/android/volley/l:<init>	(I[BLjava/util/Map;ZJ)V
    //   113: areturn
    //   114: aload 19
    //   116: getfield 253	com/android/volley/b$a:g	Ljava/util/Map;
    //   119: aload 5
    //   121: invokeinterface 257 2 0
    //   126: new 246	com/android/volley/l
    //   129: dup
    //   130: sipush 304
    //   133: aload 19
    //   135: getfield 260	com/android/volley/b$a:a	[B
    //   138: aload 19
    //   140: getfield 253	com/android/volley/b$a:g	Ljava/util/Map;
    //   143: iconst_1
    //   144: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   147: lload_2
    //   148: lsub
    //   149: invokespecial 249	com/android/volley/l:<init>	(I[BLjava/util/Map;ZJ)V
    //   152: areturn
    //   153: aload_1
    //   154: aload 5
    //   156: ldc_w 262
    //   159: invokeinterface 266 2 0
    //   164: checkcast 48	java/lang/String
    //   167: invokevirtual 268	com/android/volley/o:c	(Ljava/lang/String;)V
    //   170: aload 16
    //   172: invokeinterface 272 1 0
    //   177: ifnull +77 -> 254
    //   180: aload_0
    //   181: aload 16
    //   183: invokeinterface 272 1 0
    //   188: invokespecial 274	com/android/volley/toolbox/c:a	(Lorg/apache/http/HttpEntity;)[B
    //   191: astore 24
    //   193: aload 24
    //   195: astore 20
    //   197: aload_0
    //   198: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   201: lload_2
    //   202: lsub
    //   203: aload_1
    //   204: aload 20
    //   206: aload 17
    //   208: invokespecial 276	com/android/volley/toolbox/c:a	(JLcom/android/volley/o;[BLorg/apache/http/StatusLine;)V
    //   211: iload 18
    //   213: sipush 200
    //   216: if_icmplt +11 -> 227
    //   219: iload 18
    //   221: sipush 299
    //   224: if_icmple +38 -> 262
    //   227: new 152	java/io/IOException
    //   230: dup
    //   231: invokespecial 277	java/io/IOException:<init>	()V
    //   234: athrow
    //   235: astore 15
    //   237: ldc_w 279
    //   240: aload_1
    //   241: new 281	com/android/volley/w
    //   244: dup
    //   245: invokespecial 282	com/android/volley/w:<init>	()V
    //   248: invokestatic 284	com/android/volley/toolbox/c:a	(Ljava/lang/String;Lcom/android/volley/o;Lcom/android/volley/x;)V
    //   251: goto -247 -> 4
    //   254: iconst_0
    //   255: newarray byte
    //   257: astore 20
    //   259: goto -62 -> 197
    //   262: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   265: lload_2
    //   266: lsub
    //   267: lstore 21
    //   269: new 246	com/android/volley/l
    //   272: dup
    //   273: iload 18
    //   275: aload 20
    //   277: aload 5
    //   279: iconst_0
    //   280: lload 21
    //   282: invokespecial 249	com/android/volley/l:<init>	(I[BLjava/util/Map;ZJ)V
    //   285: astore 23
    //   287: aload 23
    //   289: areturn
    //   290: astore 14
    //   292: ldc_w 286
    //   295: aload_1
    //   296: new 281	com/android/volley/w
    //   299: dup
    //   300: invokespecial 282	com/android/volley/w:<init>	()V
    //   303: invokestatic 284	com/android/volley/toolbox/c:a	(Ljava/lang/String;Lcom/android/volley/o;Lcom/android/volley/x;)V
    //   306: goto -302 -> 4
    //   309: astore 13
    //   311: new 288	java/lang/RuntimeException
    //   314: dup
    //   315: new 290	java/lang/StringBuilder
    //   318: dup
    //   319: ldc_w 292
    //   322: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: aload_1
    //   326: invokevirtual 297	com/android/volley/o:j	()Ljava/lang/String;
    //   329: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: aload 13
    //   337: invokespecial 307	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   340: athrow
    //   341: astore 7
    //   343: aconst_null
    //   344: astore 8
    //   346: aload 4
    //   348: ifnull +124 -> 472
    //   351: aload 4
    //   353: invokeinterface 238 1 0
    //   358: invokeinterface 88 1 0
    //   363: istore 9
    //   365: iload 9
    //   367: sipush 301
    //   370: if_icmpeq +11 -> 381
    //   373: iload 9
    //   375: sipush 302
    //   378: if_icmpne +104 -> 482
    //   381: iconst_2
    //   382: anewarray 4	java/lang/Object
    //   385: astore 10
    //   387: aload 10
    //   389: iconst_0
    //   390: aload_1
    //   391: invokevirtual 310	com/android/volley/o:k	()Ljava/lang/String;
    //   394: aastore
    //   395: aload 10
    //   397: iconst_1
    //   398: aload_1
    //   399: invokevirtual 297	com/android/volley/o:j	()Ljava/lang/String;
    //   402: aastore
    //   403: ldc_w 312
    //   406: aload 10
    //   408: invokestatic 314	com/android/volley/y:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: aload 8
    //   413: ifnull +148 -> 561
    //   416: new 246	com/android/volley/l
    //   419: dup
    //   420: iload 9
    //   422: aload 8
    //   424: aload 5
    //   426: iconst_0
    //   427: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   430: lload_2
    //   431: lsub
    //   432: invokespecial 249	com/android/volley/l:<init>	(I[BLjava/util/Map;ZJ)V
    //   435: astore 11
    //   437: iload 9
    //   439: sipush 401
    //   442: if_icmpeq +11 -> 453
    //   445: iload 9
    //   447: sipush 403
    //   450: if_icmpne +66 -> 516
    //   453: ldc_w 316
    //   456: aload_1
    //   457: new 318	com/android/volley/a
    //   460: dup
    //   461: aload 11
    //   463: invokespecial 321	com/android/volley/a:<init>	(Lcom/android/volley/l;)V
    //   466: invokestatic 284	com/android/volley/toolbox/c:a	(Ljava/lang/String;Lcom/android/volley/o;Lcom/android/volley/x;)V
    //   469: goto -465 -> 4
    //   472: new 323	com/android/volley/m
    //   475: dup
    //   476: aload 7
    //   478: invokespecial 326	com/android/volley/m:<init>	(Ljava/lang/Throwable;)V
    //   481: athrow
    //   482: iconst_2
    //   483: anewarray 4	java/lang/Object
    //   486: astore 12
    //   488: aload 12
    //   490: iconst_0
    //   491: iload 9
    //   493: invokestatic 82	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   496: aastore
    //   497: aload 12
    //   499: iconst_1
    //   500: aload_1
    //   501: invokevirtual 297	com/android/volley/o:j	()Ljava/lang/String;
    //   504: aastore
    //   505: ldc_w 328
    //   508: aload 12
    //   510: invokestatic 314	com/android/volley/y:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   513: goto -102 -> 411
    //   516: iload 9
    //   518: sipush 301
    //   521: if_icmpeq +11 -> 532
    //   524: iload 9
    //   526: sipush 302
    //   529: if_icmpne +22 -> 551
    //   532: ldc_w 330
    //   535: aload_1
    //   536: new 318	com/android/volley/a
    //   539: dup
    //   540: aload 11
    //   542: invokespecial 321	com/android/volley/a:<init>	(Lcom/android/volley/l;)V
    //   545: invokestatic 284	com/android/volley/toolbox/c:a	(Ljava/lang/String;Lcom/android/volley/o;Lcom/android/volley/x;)V
    //   548: goto -544 -> 4
    //   551: new 154	com/android/volley/v
    //   554: dup
    //   555: aload 11
    //   557: invokespecial 331	com/android/volley/v:<init>	(Lcom/android/volley/l;)V
    //   560: athrow
    //   561: new 333	com/android/volley/k
    //   564: dup
    //   565: aconst_null
    //   566: invokespecial 334	com/android/volley/k:<init>	(Lcom/android/volley/l;)V
    //   569: athrow
    //   570: astore 7
    //   572: aload 16
    //   574: astore 4
    //   576: aconst_null
    //   577: astore 8
    //   579: goto -233 -> 346
    //   582: astore 7
    //   584: aload 20
    //   586: astore 8
    //   588: aload 16
    //   590: astore 4
    //   592: goto -246 -> 346
    //   595: iload 18
    //   597: sipush 301
    //   600: if_icmpeq -447 -> 153
    //   603: iload 18
    //   605: sipush 302
    //   608: if_icmpne -438 -> 170
    //   611: goto -458 -> 153
    //
    // Exception table:
    //   from	to	target	type
    //   12	45	235	java/net/SocketTimeoutException
    //   45	75	235	java/net/SocketTimeoutException
    //   83	89	235	java/net/SocketTimeoutException
    //   94	114	235	java/net/SocketTimeoutException
    //   114	153	235	java/net/SocketTimeoutException
    //   153	170	235	java/net/SocketTimeoutException
    //   170	193	235	java/net/SocketTimeoutException
    //   197	211	235	java/net/SocketTimeoutException
    //   227	235	235	java/net/SocketTimeoutException
    //   254	259	235	java/net/SocketTimeoutException
    //   262	287	235	java/net/SocketTimeoutException
    //   12	45	290	org/apache/http/conn/ConnectTimeoutException
    //   45	75	290	org/apache/http/conn/ConnectTimeoutException
    //   83	89	290	org/apache/http/conn/ConnectTimeoutException
    //   94	114	290	org/apache/http/conn/ConnectTimeoutException
    //   114	153	290	org/apache/http/conn/ConnectTimeoutException
    //   153	170	290	org/apache/http/conn/ConnectTimeoutException
    //   170	193	290	org/apache/http/conn/ConnectTimeoutException
    //   197	211	290	org/apache/http/conn/ConnectTimeoutException
    //   227	235	290	org/apache/http/conn/ConnectTimeoutException
    //   254	259	290	org/apache/http/conn/ConnectTimeoutException
    //   262	287	290	org/apache/http/conn/ConnectTimeoutException
    //   12	45	309	java/net/MalformedURLException
    //   45	75	309	java/net/MalformedURLException
    //   83	89	309	java/net/MalformedURLException
    //   94	114	309	java/net/MalformedURLException
    //   114	153	309	java/net/MalformedURLException
    //   153	170	309	java/net/MalformedURLException
    //   170	193	309	java/net/MalformedURLException
    //   197	211	309	java/net/MalformedURLException
    //   227	235	309	java/net/MalformedURLException
    //   254	259	309	java/net/MalformedURLException
    //   262	287	309	java/net/MalformedURLException
    //   12	45	341	java/io/IOException
    //   45	75	570	java/io/IOException
    //   83	89	570	java/io/IOException
    //   94	114	570	java/io/IOException
    //   114	153	570	java/io/IOException
    //   153	170	570	java/io/IOException
    //   170	193	570	java/io/IOException
    //   254	259	570	java/io/IOException
    //   197	211	582	java/io/IOException
    //   227	235	582	java/io/IOException
    //   262	287	582	java/io/IOException
  }

  protected void a(String paramString1, String paramString2, long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = Long.valueOf(l - paramLong);
    arrayOfObject[2] = paramString2;
    y.a("HTTP ERROR(%s) %d ms to fetch %s", arrayOfObject);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.c
 * JD-Core Version:    0.6.0
 */