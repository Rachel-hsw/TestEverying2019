package com.android.volley;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import java.util.concurrent.BlockingQueue;

public class j extends Thread
{
  private final BlockingQueue<o<?>> a;
  private final i b;
  private final b c;
  private final t d;
  private volatile boolean e = false;

  public j(BlockingQueue<o<?>> paramBlockingQueue, i parami, b paramb, t paramt)
  {
    this.a = paramBlockingQueue;
    this.b = parami;
    this.c = paramb;
    this.d = paramt;
  }

  @TargetApi(14)
  private void a(o<?> paramo)
  {
    if (Build.VERSION.SDK_INT >= 14)
      TrafficStats.setThreadStatsTag(paramo.h());
  }

  private void a(o<?> paramo, x paramx)
  {
    x localx = paramo.a(paramx);
    this.d.a(paramo, localx);
  }

  public void a()
  {
    this.e = true;
    interrupt();
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 75	android/os/Process:setThreadPriority	(I)V
    //   5: invokestatic 81	android/os/SystemClock:elapsedRealtime	()J
    //   8: lstore_1
    //   9: aload_0
    //   10: getfield 24	com/android/volley/j:a	Ljava/util/concurrent/BlockingQueue;
    //   13: invokeinterface 87 1 0
    //   18: checkcast 42	com/android/volley/o
    //   21: astore 4
    //   23: aload 4
    //   25: ldc 89
    //   27: invokevirtual 92	com/android/volley/o:a	(Ljava/lang/String;)V
    //   30: aload 4
    //   32: invokevirtual 96	com/android/volley/o:p	()Z
    //   35: ifeq +45 -> 80
    //   38: aload 4
    //   40: ldc 98
    //   42: invokevirtual 100	com/android/volley/o:b	(Ljava/lang/String;)V
    //   45: goto -40 -> 5
    //   48: astore 8
    //   50: aload 8
    //   52: invokestatic 81	android/os/SystemClock:elapsedRealtime	()J
    //   55: lload_1
    //   56: lsub
    //   57: invokevirtual 103	com/android/volley/x:a	(J)V
    //   60: aload_0
    //   61: aload 4
    //   63: aload 8
    //   65: invokespecial 104	com/android/volley/j:a	(Lcom/android/volley/o;Lcom/android/volley/x;)V
    //   68: goto -63 -> 5
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 22	com/android/volley/j:e	Z
    //   76: ifeq -71 -> 5
    //   79: return
    //   80: aload_0
    //   81: aload 4
    //   83: invokespecial 106	com/android/volley/j:a	(Lcom/android/volley/o;)V
    //   86: aload_0
    //   87: getfield 26	com/android/volley/j:b	Lcom/android/volley/i;
    //   90: aload 4
    //   92: invokeinterface 111 2 0
    //   97: astore 9
    //   99: aload 4
    //   101: ldc 113
    //   103: invokevirtual 92	com/android/volley/o:a	(Ljava/lang/String;)V
    //   106: aload 9
    //   108: getfield 117	com/android/volley/l:d	Z
    //   111: ifeq +84 -> 195
    //   114: aload 4
    //   116: invokevirtual 120	com/android/volley/o:A	()Z
    //   119: ifeq +76 -> 195
    //   122: aload 4
    //   124: ldc 122
    //   126: invokevirtual 100	com/android/volley/o:b	(Ljava/lang/String;)V
    //   129: goto -124 -> 5
    //   132: astore 5
    //   134: iconst_1
    //   135: anewarray 124	java/lang/Object
    //   138: astore 6
    //   140: aload 6
    //   142: iconst_0
    //   143: aload 5
    //   145: invokevirtual 128	java/lang/Exception:toString	()Ljava/lang/String;
    //   148: aastore
    //   149: aload 5
    //   151: ldc 130
    //   153: aload 6
    //   155: invokestatic 135	com/android/volley/y:a	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: new 68	com/android/volley/x
    //   161: dup
    //   162: aload 5
    //   164: invokespecial 138	com/android/volley/x:<init>	(Ljava/lang/Throwable;)V
    //   167: astore 7
    //   169: aload 7
    //   171: invokestatic 81	android/os/SystemClock:elapsedRealtime	()J
    //   174: lload_1
    //   175: lsub
    //   176: invokevirtual 103	com/android/volley/x:a	(J)V
    //   179: aload_0
    //   180: getfield 30	com/android/volley/j:d	Lcom/android/volley/t;
    //   183: aload 4
    //   185: aload 7
    //   187: invokeinterface 60 3 0
    //   192: goto -187 -> 5
    //   195: aload 4
    //   197: aload 9
    //   199: invokevirtual 141	com/android/volley/o:a	(Lcom/android/volley/l;)Lcom/android/volley/s;
    //   202: astore 10
    //   204: aload 4
    //   206: ldc 143
    //   208: invokevirtual 92	com/android/volley/o:a	(Ljava/lang/String;)V
    //   211: aload 4
    //   213: invokevirtual 146	com/android/volley/o:v	()Z
    //   216: ifeq +37 -> 253
    //   219: aload 10
    //   221: getfield 151	com/android/volley/s:b	Lcom/android/volley/b$a;
    //   224: ifnull +29 -> 253
    //   227: aload_0
    //   228: getfield 28	com/android/volley/j:c	Lcom/android/volley/b;
    //   231: aload 4
    //   233: invokevirtual 154	com/android/volley/o:m	()Ljava/lang/String;
    //   236: aload 10
    //   238: getfield 151	com/android/volley/s:b	Lcom/android/volley/b$a;
    //   241: invokeinterface 159 3 0
    //   246: aload 4
    //   248: ldc 161
    //   250: invokevirtual 92	com/android/volley/o:a	(Ljava/lang/String;)V
    //   253: aload 4
    //   255: invokevirtual 164	com/android/volley/o:z	()V
    //   258: aload_0
    //   259: getfield 30	com/android/volley/j:d	Lcom/android/volley/t;
    //   262: aload 4
    //   264: aload 10
    //   266: invokeinterface 167 3 0
    //   271: goto -266 -> 5
    //
    // Exception table:
    //   from	to	target	type
    //   23	45	48	com/android/volley/x
    //   80	129	48	com/android/volley/x
    //   195	253	48	com/android/volley/x
    //   253	271	48	com/android/volley/x
    //   9	23	71	java/lang/InterruptedException
    //   23	45	132	java/lang/Exception
    //   80	129	132	java/lang/Exception
    //   195	253	132	java/lang/Exception
    //   253	271	132	java/lang/Exception
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.j
 * JD-Core Version:    0.6.0
 */