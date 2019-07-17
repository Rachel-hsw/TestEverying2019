package com.umeng.message.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.c.b.b;
import org.android.agoo.c.b.e;
import org.android.agoo.c.b.h;
import org.android.agoo.c.b.i;
import org.android.agoo.c.b.j;

public abstract class bs
  implements h
{
  protected static final int g = 8192;
  private static final char h = '\r';
  private static final char i = '\n';
  private static final String j = "UTF-8";
  private static final String k = "HttpChunked";
  private static final char[] v = { ' ' };
  protected volatile e a = e.d;
  protected volatile InputStream b = null;
  protected volatile int c = -1;
  protected volatile boolean d = true;
  protected volatile long e = -1L;
  protected volatile Context f;
  private volatile ThreadPoolExecutor l = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
  private volatile j m;
  private volatile Future<?> n = null;
  private volatile Future<?> o = null;
  private volatile String p;
  private volatile int q;
  private volatile String r;
  private volatile int s = -1;
  private volatile Object t = null;
  private AtomicBoolean u = new AtomicBoolean(false);

  public static final char a(byte[] paramArrayOfByte)
  {
    return (char)((0xFF & paramArrayOfByte[0]) << 8 | 0xFF & paramArrayOfByte[1]);
  }

  private final void a(Context paramContext)
  {
    try
    {
      bk localbk = new bk(paramContext);
      if (localbk.a())
      {
        this.p = localbk.d();
        this.q = localbk.e();
        return;
      }
      this.p = null;
      this.q = -1;
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private final void s()
  {
    this.s = -1;
  }

  private final boolean t()
  {
    return (this.a == e.c) || (this.a == e.d);
  }

  @Deprecated
  public final int a(String paramString, byte[] paramArrayOfByte, i parami)
  {
    return -1;
  }

  protected final void a(long paramLong, Map<String, String> paramMap)
  {
    if (this.m != null)
    {
      this.a = e.b;
      this.m.a(this.t, this.s, paramLong, paramMap);
    }
  }

  public final void a(Object paramObject, Context paramContext, String paramString1, Map<String, String> paramMap, long paramLong, j paramj, String paramString2)
  {
    this.f = this.f;
    try
    {
      SharedPreferences.Editor localEditor = this.f.getSharedPreferences("AppStore", 4).edit();
      localEditor.putString("agoo_connect_type", "httpchunk");
      localEditor.commit();
      label45: if (paramj == null)
      {
        ay.c("HttpChunked", "eventHandler == null ");
        return;
      }
      if ((this.a == e.b) || (this.a == e.a))
      {
        ay.c("HttpChunked", "http chunked connect url: [" + paramString1 + "] connectId:[" + c() + "] connecting......");
        return;
      }
      this.t = paramObject;
      a(paramContext);
      this.m = paramj;
      this.a = e.a;
      this.n = this.l.submit(new bt(this, paramString1, paramMap));
      this.o = this.l.submit(new bu(this, paramLong));
      return;
    }
    catch (Throwable localThrowable)
    {
      break label45;
    }
  }

  protected final void a(String paramString)
  {
    this.m.a(this.t, this.s, this.r, paramString.getBytes());
  }

  protected abstract void a(String paramString, Map<String, String> paramMap);

  protected final void a(b paramb, Throwable paramThrowable)
  {
    d();
    a(paramb, new HashMap(), paramThrowable);
  }

  protected final void a(b paramb, Map<String, String> paramMap, Throwable paramThrowable)
  {
    d();
    if (this.m != null)
      this.m.a(this.t, this.s, paramb, paramMap, paramThrowable);
  }

  public final void a(boolean paramBoolean)
  {
    this.u.set(paramBoolean);
  }

  protected final void a(char[] paramArrayOfChar)
  {
    if ((this.m != null) && (paramArrayOfChar.length == 1))
      this.m.a(this.t, 2L);
  }

  public final boolean a()
  {
    return this.u.get();
  }

  protected final void b()
  {
    a(false);
    this.s = new Random().nextInt(10000);
  }

  protected final int c()
  {
    return this.s;
  }

  @Deprecated
  public final void d()
  {
    ay.c("HttpChunked", "http chunked disconnect(" + c() + ")");
    if (t())
    {
      ay.c("HttpChunked", "http chunked connect[" + c() + "] connection has been closed");
      return;
    }
    this.a = e.c;
    try
    {
      j();
      k();
      ay.c("HttpChunked", "http chunked connect[" + c() + "] connection disconnecting");
      g();
      ay.c("HttpChunked", "http chunked connect[" + c() + "] connection disconnected");
      l();
      label167: this.a = e.d;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label167;
    }
  }

  public final void e()
  {
    ay.c("HttpChunked", "http chunked disconnect(" + c() + ")");
    if (t())
    {
      ay.c("HttpChunked", "http chunked connect[" + c() + "] connection has been closed");
      return;
    }
    this.a = e.c;
    this.l.submit(new bv(this));
    this.a = e.d;
  }

  public final e f()
  {
    return this.a;
  }

  protected abstract void g();

  protected abstract void h();

  protected final void i()
  {
    char[] arrayOfChar;
    InputStreamReader localInputStreamReader;
    StringBuffer localStringBuffer;
    int i1;
    int i2;
    try
    {
      arrayOfChar = new char[6];
      localInputStreamReader = new InputStreamReader(this.b, "UTF-8");
      localStringBuffer = new StringBuffer(8192);
      i1 = 0;
      while (true)
      {
        i2 = localInputStreamReader.read();
        if (i2 == -1)
          break label329;
        if (i2 != 32)
          break;
        a(v);
      }
    }
    catch (Throwable localThrowable1)
    {
      if (!a())
      {
        a(true);
        ay.d("HttpChunked", "Throwable connectId:[" + c() + "]==>", localThrowable1);
        a(b.s, localThrowable1);
      }
    }
    label119: return;
    int i5;
    label140: int i3;
    while (true)
      if (i2 == 64)
      {
        int i4 = (char)i2;
        try
        {
          arrayOfChar[0] = i4;
          i5 = 0;
          if (i5 >= 5)
            continue;
          i2 = localInputStreamReader.read();
          arrayOfChar[(i5 + 1)] = (char)i2;
          if (i5 >= 4)
            a(arrayOfChar);
        }
        catch (Throwable localThrowable2)
        {
          ay.d("HttpChunked", "onSysData:[" + c() + "]==>", localThrowable2);
          i3 = i1;
        }
      }
    while (true)
    {
      label217: if (i2 != 10)
      {
        if (i3 == 0)
          break label440;
        localStringBuffer.append('\r');
        i3 = 0;
      }
      while (true)
      {
        label243: i2 = localInputStreamReader.read();
        if (i2 >= 0)
          break label217;
        if (!TextUtils.isEmpty(localStringBuffer.toString()))
        {
          Log.d("HttpChunked", "http msg is comming...........result=" + localStringBuffer.toString());
          a(localStringBuffer.toString());
          localStringBuffer.setLength(0);
          i1 = i3;
          break;
        }
        label329: 
        do
        {
          localStringBuffer.append((char)i2);
          break label243;
          if (this.a != e.b)
            break label119;
          ay.c("HttpChunked", "connectId:[" + c() + "]==>server data is abort");
          if (!a())
          {
            a(true);
            a(b.s, new IOException("connectId:[" + c() + "] server data is abort"));
          }
          d();
          return;
          i1 = i3;
          break;
        }
        while (i2 != 13);
        label440: i3 = 1;
      }
      i5++;
      break label140;
      i3 = i1;
    }
  }

  protected final void j()
  {
    if (this.o != null)
      this.o.cancel(true);
  }

  protected final void k()
  {
    if (this.n != null)
      this.n.cancel(true);
  }

  protected final void l()
  {
    if ((this.m == null) && (t()));
    do
      return;
    while (this.a != e.b);
    this.m.b(this.t, this.s);
  }

  public final String m()
  {
    return this.p;
  }

  public final int n()
  {
    return this.q;
  }

  protected final boolean o()
  {
    return (this.p != null) && (this.q != -1);
  }

  @Deprecated
  public final long p()
  {
    return -1L;
  }

  public final void q()
  {
    try
    {
      this.l.submit(new bw(this));
      if ((this.l != null) && (this.l.isShutdown()))
        this.l.shutdownNow();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void r()
  {
    try
    {
      d();
      ay.c("HttpChunked", "http chunked closing");
      h();
      ay.c("HttpChunked", "http chunked closed");
      s();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bs
 * JD-Core Version:    0.6.0
 */