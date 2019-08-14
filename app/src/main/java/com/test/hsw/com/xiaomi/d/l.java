package com.xiaomi.d;

import android.os.SystemClock;
import com.xiaomi.a.a.c.c;
import com.xiaomi.d.c.f.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class l extends a
{
  private int A;
  public Exception n = null;
  protected Socket o;
  String p = null;
  i q;
  g r;
  private String s = null;
  private String t = "";
  private String u;
  private XMPushService v;
  private volatile long w = 0L;
  private volatile long x = 0L;
  private final String y = "<pf><p>t:%1$d</p></pf>";
  private volatile long z = 0L;

  public l(XMPushService paramXMPushService, b paramb)
  {
    super(paramXMPushService, paramb);
    this.v = paramXMPushService;
  }

  private void a(b paramb)
  {
    a(paramb.f(), paramb.e());
  }

  private void a(Exception paramException)
  {
    if (SystemClock.elapsedRealtime() - this.z < 300000L)
    {
      if (com.xiaomi.a.a.e.d.d(this.v))
      {
        this.A = (1 + this.A);
        if (this.A >= 2)
        {
          String str = c();
          c.a("max short conn time reached, sink down current host:" + str);
          a(str, 0L, paramException);
          this.A = 0;
        }
      }
      return;
    }
    this.A = 0;
  }

  // ERROR //
  private void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield 32	com/xiaomi/d/l:n	Ljava/lang/Exception;
    //   7: new 118	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 119	java/util/ArrayList:<init>	()V
    //   14: astore 4
    //   16: new 90	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   23: ldc 121
    //   25: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 124	com/xiaomi/a/a/c/c:e	(Ljava/lang/String;)Ljava/lang/Integer;
    //   38: invokevirtual 129	java/lang/Integer:intValue	()I
    //   41: istore 5
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual 132	com/xiaomi/d/l:c	(Ljava/lang/String;)Lcom/xiaomi/network/b;
    //   48: astore 6
    //   50: iload 5
    //   52: invokestatic 136	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: invokestatic 139	com/xiaomi/a/a/c/c:a	(Ljava/lang/Integer;)V
    //   58: aload 6
    //   60: ifnull +11 -> 71
    //   63: aload 6
    //   65: iconst_1
    //   66: invokevirtual 144	com/xiaomi/network/b:a	(Z)Ljava/util/ArrayList;
    //   69: astore 4
    //   71: aload 4
    //   73: invokevirtual 148	java/util/ArrayList:isEmpty	()Z
    //   76: ifeq +10 -> 86
    //   79: aload 4
    //   81: aload_1
    //   82: invokevirtual 152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   85: pop
    //   86: aload_0
    //   87: lconst_0
    //   88: putfield 50	com/xiaomi/d/l:z	J
    //   91: aload_0
    //   92: getfield 52	com/xiaomi/d/l:v	Lcom/xiaomi/push/service/XMPushService;
    //   95: invokestatic 155	com/xiaomi/a/a/e/d:f	(Landroid/content/Context;)Ljava/lang/String;
    //   98: astore 7
    //   100: new 90	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   107: astore 8
    //   109: aload 4
    //   111: invokevirtual 159	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   114: astore 9
    //   116: aload 9
    //   118: invokeinterface 164 1 0
    //   123: ifeq +592 -> 715
    //   126: aload 9
    //   128: invokeinterface 168 1 0
    //   133: checkcast 170	java/lang/String
    //   136: astore 11
    //   138: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   141: lstore 12
    //   143: aload_0
    //   144: iconst_1
    //   145: aload_0
    //   146: getfield 178	com/xiaomi/d/l:b	I
    //   149: iadd
    //   150: putfield 178	com/xiaomi/d/l:b	I
    //   153: new 90	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   160: ldc 180
    //   162: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 11
    //   167: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 107	com/xiaomi/a/a/c/c:a	(Ljava/lang/String;)V
    //   176: aload_0
    //   177: aload_0
    //   178: invokevirtual 183	com/xiaomi/d/l:u	()Ljava/net/Socket;
    //   181: putfield 185	com/xiaomi/d/l:o	Ljava/net/Socket;
    //   184: aload_0
    //   185: getfield 185	com/xiaomi/d/l:o	Ljava/net/Socket;
    //   188: aconst_null
    //   189: invokevirtual 191	java/net/Socket:bind	(Ljava/net/SocketAddress;)V
    //   192: aload 11
    //   194: iload_2
    //   195: invokestatic 196	com/xiaomi/network/d:b	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   198: astore 21
    //   200: aload_0
    //   201: getfield 185	com/xiaomi/d/l:o	Ljava/net/Socket;
    //   204: aload 21
    //   206: sipush 5000
    //   209: invokevirtual 200	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   212: aload_0
    //   213: getfield 185	com/xiaomi/d/l:o	Ljava/net/Socket;
    //   216: iconst_1
    //   217: invokevirtual 204	java/net/Socket:setTcpNoDelay	(Z)V
    //   220: aload_0
    //   221: aload 11
    //   223: putfield 206	com/xiaomi/d/l:u	Ljava/lang/String;
    //   226: aload_0
    //   227: invokespecial 208	com/xiaomi/d/l:x	()V
    //   230: iconst_1
    //   231: istore 10
    //   233: aload_0
    //   234: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   237: lload 12
    //   239: lsub
    //   240: putfield 210	com/xiaomi/d/l:c	J
    //   243: aload 6
    //   245: ifnull +15 -> 260
    //   248: aload 6
    //   250: aload 11
    //   252: aload_0
    //   253: getfield 210	com/xiaomi/d/l:c	J
    //   256: lconst_0
    //   257: invokevirtual 213	com/xiaomi/network/b:b	(Ljava/lang/String;JJ)V
    //   260: aload_0
    //   261: invokestatic 75	android/os/SystemClock:elapsedRealtime	()J
    //   264: putfield 50	com/xiaomi/d/l:z	J
    //   267: new 90	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   274: ldc 215
    //   276: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 11
    //   281: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 217
    //   286: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_0
    //   290: getfield 210	com/xiaomi/d/l:c	J
    //   293: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 107	com/xiaomi/a/a/c/c:a	(Ljava/lang/String;)V
    //   302: invokestatic 225	com/xiaomi/network/f:a	()Lcom/xiaomi/network/f;
    //   305: invokevirtual 228	com/xiaomi/network/f:h	()V
    //   308: iload 10
    //   310: ifne +371 -> 681
    //   313: new 114	com/xiaomi/d/p
    //   316: dup
    //   317: aload 8
    //   319: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokespecial 230	com/xiaomi/d/p:<init>	(Ljava/lang/String;)V
    //   325: athrow
    //   326: astore 19
    //   328: iload_3
    //   329: istore 10
    //   331: aload 6
    //   333: ifnull +19 -> 352
    //   336: aload 6
    //   338: aload 11
    //   340: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   343: lload 12
    //   345: lsub
    //   346: lconst_0
    //   347: aload 19
    //   349: invokevirtual 233	com/xiaomi/network/b:b	(Ljava/lang/String;JJLjava/lang/Exception;)V
    //   352: aload_0
    //   353: aload 19
    //   355: putfield 32	com/xiaomi/d/l:n	Ljava/lang/Exception;
    //   358: new 90	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   365: ldc 235
    //   367: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 11
    //   372: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 237	com/xiaomi/a/a/c/c:d	(Ljava/lang/String;)V
    //   381: aload 8
    //   383: ldc 239
    //   385: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload 11
    //   390: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc 241
    //   395: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: iload_2
    //   399: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: ldc 246
    //   404: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 19
    //   409: invokevirtual 249	java/io/IOException:getMessage	()Ljava/lang/String;
    //   412: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc 251
    //   417: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: iload 10
    //   423: ifne +27 -> 450
    //   426: aload 11
    //   428: aload_0
    //   429: getfield 32	com/xiaomi/d/l:n	Ljava/lang/Exception;
    //   432: invokestatic 256	com/xiaomi/e/g:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   435: aload 7
    //   437: aload_0
    //   438: getfield 52	com/xiaomi/d/l:v	Lcom/xiaomi/push/service/XMPushService;
    //   441: invokestatic 155	com/xiaomi/a/a/e/d:f	(Landroid/content/Context;)Ljava/lang/String;
    //   444: invokestatic 262	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   447: ifeq -145 -> 302
    //   450: iload 10
    //   452: istore 16
    //   454: iload 16
    //   456: istore_3
    //   457: goto -341 -> 116
    //   460: astore 17
    //   462: iload_3
    //   463: istore 10
    //   465: aload 6
    //   467: ifnull +19 -> 486
    //   470: aload 6
    //   472: aload 11
    //   474: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   477: lload 12
    //   479: lsub
    //   480: lconst_0
    //   481: aload 17
    //   483: invokevirtual 233	com/xiaomi/network/b:b	(Ljava/lang/String;JJLjava/lang/Exception;)V
    //   486: aload_0
    //   487: aload 17
    //   489: putfield 32	com/xiaomi/d/l:n	Ljava/lang/Exception;
    //   492: new 90	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   499: ldc 235
    //   501: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload 11
    //   506: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 237	com/xiaomi/a/a/c/c:d	(Ljava/lang/String;)V
    //   515: aload 8
    //   517: ldc 239
    //   519: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload 11
    //   524: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc 241
    //   529: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: iload_2
    //   533: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: ldc 246
    //   538: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload 17
    //   543: invokevirtual 263	com/xiaomi/d/p:getMessage	()Ljava/lang/String;
    //   546: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc 251
    //   551: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: iload 10
    //   557: ifne -107 -> 450
    //   560: aload 11
    //   562: aload_0
    //   563: getfield 32	com/xiaomi/d/l:n	Ljava/lang/Exception;
    //   566: invokestatic 256	com/xiaomi/e/g:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   569: aload 7
    //   571: aload_0
    //   572: getfield 52	com/xiaomi/d/l:v	Lcom/xiaomi/push/service/XMPushService;
    //   575: invokestatic 155	com/xiaomi/a/a/e/d:f	(Landroid/content/Context;)Ljava/lang/String;
    //   578: invokestatic 262	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   581: ifne -131 -> 450
    //   584: goto -282 -> 302
    //   587: astore 15
    //   589: aload_0
    //   590: new 265	java/lang/Exception
    //   593: dup
    //   594: ldc_w 267
    //   597: aload 15
    //   599: invokespecial 270	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   602: putfield 32	com/xiaomi/d/l:n	Ljava/lang/Exception;
    //   605: aload 15
    //   607: invokestatic 273	com/xiaomi/a/a/c/c:a	(Ljava/lang/Throwable;)V
    //   610: iload_3
    //   611: ifne +98 -> 709
    //   614: aload 11
    //   616: aload_0
    //   617: getfield 32	com/xiaomi/d/l:n	Ljava/lang/Exception;
    //   620: invokestatic 256	com/xiaomi/e/g:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   623: aload 7
    //   625: aload_0
    //   626: getfield 52	com/xiaomi/d/l:v	Lcom/xiaomi/push/service/XMPushService;
    //   629: invokestatic 155	com/xiaomi/a/a/e/d:f	(Landroid/content/Context;)Ljava/lang/String;
    //   632: invokestatic 262	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   635: ifne +74 -> 709
    //   638: iload_3
    //   639: istore 10
    //   641: goto -339 -> 302
    //   644: astore 14
    //   646: iload_3
    //   647: istore 10
    //   649: iload 10
    //   651: ifne +27 -> 678
    //   654: aload 11
    //   656: aload_0
    //   657: getfield 32	com/xiaomi/d/l:n	Ljava/lang/Exception;
    //   660: invokestatic 256	com/xiaomi/e/g:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   663: aload 7
    //   665: aload_0
    //   666: getfield 52	com/xiaomi/d/l:v	Lcom/xiaomi/push/service/XMPushService;
    //   669: invokestatic 155	com/xiaomi/a/a/e/d:f	(Landroid/content/Context;)Ljava/lang/String;
    //   672: invokestatic 262	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   675: ifeq -373 -> 302
    //   678: aload 14
    //   680: athrow
    //   681: return
    //   682: astore 14
    //   684: goto -35 -> 649
    //   687: astore 22
    //   689: aload 22
    //   691: astore 15
    //   693: iload 10
    //   695: istore_3
    //   696: goto -107 -> 589
    //   699: astore 17
    //   701: goto -236 -> 465
    //   704: astore 19
    //   706: goto -375 -> 331
    //   709: iload_3
    //   710: istore 16
    //   712: goto -258 -> 454
    //   715: iload_3
    //   716: istore 10
    //   718: goto -416 -> 302
    //
    // Exception table:
    //   from	to	target	type
    //   153	230	326	java/io/IOException
    //   153	230	460	com/xiaomi/d/p
    //   153	230	587	java/lang/Throwable
    //   153	230	644	finally
    //   589	610	644	finally
    //   233	243	682	finally
    //   248	260	682	finally
    //   260	302	682	finally
    //   336	352	682	finally
    //   352	421	682	finally
    //   470	486	682	finally
    //   486	555	682	finally
    //   233	243	687	java/lang/Throwable
    //   248	260	687	java/lang/Throwable
    //   260	302	687	java/lang/Throwable
    //   233	243	699	com/xiaomi/d/p
    //   248	260	699	com/xiaomi/d/p
    //   260	302	699	com/xiaomi/d/p
    //   233	243	704	java/io/IOException
    //   248	260	704	java/io/IOException
    //   260	302	704	java/io/IOException
  }

  private void a(String paramString, long paramLong, Exception paramException)
  {
    String str = b.b();
    com.xiaomi.network.b localb = com.xiaomi.network.f.a().a(str, false);
    if (localb != null)
    {
      localb.b(paramString, paramLong, 0L, paramException);
      com.xiaomi.network.f.a().h();
    }
  }

  private void x()
  {
    monitorenter;
    try
    {
      y();
      this.q = new i(this);
      this.r = new g(this);
      if (this.l.g())
      {
        a(this.g.c(), null);
        if (this.g.d() != null)
          b(this.g.d(), null);
      }
      this.q.c();
      this.r.b();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void y()
  {
    try
    {
      this.h = new BufferedReader(new InputStreamReader(this.o.getInputStream(), "UTF-8"), 4096);
      this.i = new BufferedWriter(new OutputStreamWriter(this.o.getOutputStream(), "UTF-8"));
      if ((this.h != null) && (this.i != null))
        f();
      return;
    }
    catch (Exception localException)
    {
    }
    throw new p("Error to init reader and writer", localException);
  }

  public void a(int paramInt, Exception paramException)
  {
    this.v.a(new n(this, 2, paramInt, paramException));
  }

  public void a(com.xiaomi.d.c.d paramd)
  {
    if (this.q != null)
    {
      this.q.a(paramd);
      return;
    }
    throw new p("the writer is null.");
  }

  public void a(com.xiaomi.d.c.f paramf, int paramInt, Exception paramException)
  {
    b(paramf, paramInt, paramException);
    if ((paramException != null) && (this.z != 0L))
      a(paramException);
  }

  public void a(an.b paramb)
  {
    monitorenter;
    try
    {
      new k().a(paramb, r(), this);
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

  public void a(String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      com.xiaomi.d.c.f localf = new com.xiaomi.d.c.f(f.b.b);
      localf.l(paramString1);
      localf.n(paramString2);
      if (this.q != null)
        this.q.a(localf);
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

  public void a(com.xiaomi.d.c.d[] paramArrayOfd)
  {
    int i = paramArrayOfd.length;
    for (int j = 0; j < i; j++)
      a(paramArrayOfd[j]);
  }

  // ERROR //
  protected void b(com.xiaomi.d.c.f paramf, int paramInt, Exception paramException)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 409	com/xiaomi/d/l:n	()I
    //   6: istore 5
    //   8: iload 5
    //   10: iconst_2
    //   11: if_icmpne +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_2
    //   19: iload_2
    //   20: aload_3
    //   21: invokevirtual 412	com/xiaomi/d/l:a	(IILjava/lang/Exception;)V
    //   24: aload_0
    //   25: ldc 38
    //   27: putfield 415	com/xiaomi/d/l:j	Ljava/lang/String;
    //   30: aload_0
    //   31: getfield 292	com/xiaomi/d/l:r	Lcom/xiaomi/d/g;
    //   34: ifnull +22 -> 56
    //   37: aload_0
    //   38: getfield 292	com/xiaomi/d/l:r	Lcom/xiaomi/d/g;
    //   41: invokevirtual 416	com/xiaomi/d/g:c	()V
    //   44: aload_0
    //   45: getfield 292	com/xiaomi/d/l:r	Lcom/xiaomi/d/g;
    //   48: invokevirtual 418	com/xiaomi/d/g:d	()V
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 292	com/xiaomi/d/l:r	Lcom/xiaomi/d/g;
    //   56: aload_0
    //   57: getfield 287	com/xiaomi/d/l:q	Lcom/xiaomi/d/i;
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +22 -> 86
    //   67: aload_0
    //   68: getfield 287	com/xiaomi/d/l:q	Lcom/xiaomi/d/i;
    //   71: invokevirtual 419	com/xiaomi/d/i:b	()V
    //   74: aload_0
    //   75: getfield 287	com/xiaomi/d/l:q	Lcom/xiaomi/d/i;
    //   78: invokevirtual 421	com/xiaomi/d/i:a	()V
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 287	com/xiaomi/d/l:q	Lcom/xiaomi/d/i;
    //   86: aload_0
    //   87: getfield 185	com/xiaomi/d/l:o	Ljava/net/Socket;
    //   90: invokevirtual 424	java/net/Socket:close	()V
    //   93: aload_0
    //   94: getfield 337	com/xiaomi/d/l:h	Ljava/io/Reader;
    //   97: astore 8
    //   99: aload 8
    //   101: ifnull +15 -> 116
    //   104: aload_0
    //   105: getfield 337	com/xiaomi/d/l:h	Ljava/io/Reader;
    //   108: invokevirtual 427	java/io/Reader:close	()V
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 337	com/xiaomi/d/l:h	Ljava/io/Reader;
    //   116: aload_0
    //   117: getfield 355	com/xiaomi/d/l:i	Ljava/io/Writer;
    //   120: astore 9
    //   122: aload 9
    //   124: ifnull +15 -> 139
    //   127: aload_0
    //   128: getfield 355	com/xiaomi/d/l:i	Ljava/io/Writer;
    //   131: invokevirtual 430	java/io/Writer:close	()V
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 355	com/xiaomi/d/l:i	Ljava/io/Writer;
    //   139: aload_0
    //   140: lconst_0
    //   141: putfield 42	com/xiaomi/d/l:w	J
    //   144: aload_0
    //   145: lconst_0
    //   146: putfield 44	com/xiaomi/d/l:x	J
    //   149: goto -135 -> 14
    //   152: astore 4
    //   154: aload_0
    //   155: monitorexit
    //   156: aload 4
    //   158: athrow
    //   159: astore 12
    //   161: aload 12
    //   163: invokestatic 273	com/xiaomi/a/a/c/c:a	(Ljava/lang/Throwable;)V
    //   166: goto -92 -> 74
    //   169: astore 10
    //   171: goto -37 -> 134
    //   174: astore 11
    //   176: goto -65 -> 111
    //   179: astore 7
    //   181: goto -88 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   2	8	152	finally
    //   17	56	152	finally
    //   56	62	152	finally
    //   67	74	152	finally
    //   74	86	152	finally
    //   86	93	152	finally
    //   93	99	152	finally
    //   104	111	152	finally
    //   111	116	152	finally
    //   116	122	152	finally
    //   127	134	152	finally
    //   134	139	152	finally
    //   139	149	152	finally
    //   161	166	152	finally
    //   67	74	159	java/io/IOException
    //   127	134	169	java/lang/Throwable
    //   104	111	174	java/lang/Throwable
    //   86	93	179	java/lang/Throwable
  }

  public void b(String paramString)
  {
    this.t = paramString;
  }

  com.xiaomi.network.b c(String paramString)
  {
    com.xiaomi.network.b localb = com.xiaomi.network.f.a().a(paramString, false);
    if (!localb.b())
      com.xiaomi.d.e.i.a(new o(this, paramString));
    this.d = 0;
    try
    {
      byte[] arrayOfByte = InetAddress.getByName(localb.f).getAddress();
      this.d = (0xFF & arrayOfByte[0]);
      this.d |= 0xFF00 & arrayOfByte[1] << 8;
      this.d |= 0xFF0000 & arrayOfByte[2] << 16;
      this.d |= 0xFF000000 & arrayOfByte[3] << 24;
      return localb;
    }
    catch (UnknownHostException localUnknownHostException)
    {
    }
    return localb;
  }

  public String c()
  {
    return this.u;
  }

  public void m()
  {
    if (this.q != null)
    {
      this.q.d();
      long l = System.currentTimeMillis();
      this.v.a(new m(this, 13, l), 15000L);
      return;
    }
    throw new p("the packetwriter is null.");
  }

  public String r()
  {
    return this.j;
  }

  public void s()
  {
    monitorenter;
    try
    {
      if ((h()) || (g()))
        c.a("WARNING: current xmpp has connected");
      while (true)
      {
        return;
        a(0, 0, null);
        a(this.l);
      }
    }
    catch (IOException localIOException)
    {
      throw new p(localIOException);
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public String t()
  {
    String str1;
    String str2;
    if ((this.x == 0L) || (this.w == 0L))
    {
      str1 = "";
      str2 = com.xiaomi.e.g.c();
      if (str2 == null)
        break label109;
    }
    label109: for (String str3 = "<q>" + str2 + "</q>"; ; str3 = "")
    {
      return String.format(this.t, new Object[] { str1, str3 });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(this.x - this.w);
      str1 = String.format("<pf><p>t:%1$d</p></pf>", arrayOfObject);
      break;
    }
  }

  public Socket u()
  {
    return new Socket();
  }

  public void v()
  {
    this.w = SystemClock.uptimeMillis();
  }

  public void w()
  {
    this.x = SystemClock.uptimeMillis();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.l
 * JD-Core Version:    0.6.0
 */