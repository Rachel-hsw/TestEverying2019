package com.tencent.open.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class a extends i
  implements Handler.Callback
{
  private b a;
  private FileWriter b;
  private File c;
  private char[] d;
  private volatile g e;
  private volatile g f;
  private volatile g g;
  private volatile g h;
  private volatile boolean i = false;
  private HandlerThread j;
  private Handler k;

  public a(int paramInt, boolean paramBoolean, h paramh, b paramb)
  {
    super(paramInt, paramBoolean, paramh);
    a(paramb);
    this.e = new g();
    this.f = new g();
    this.g = this.e;
    this.h = this.f;
    this.d = new char[paramb.f()];
    paramb.b();
    g();
    this.j = new HandlerThread(paramb.c(), paramb.h());
    if (this.j != null)
      this.j.start();
    if ((this.j.isAlive()) && (this.j.getLooper() != null))
      this.k = new Handler(this.j.getLooper(), this);
  }

  public a(b paramb)
  {
    this(c.c, true, h.a, paramb);
  }

  // ERROR //
  private void f()
  {
    // Byte code:
    //   0: invokestatic 110	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: aload_0
    //   4: getfield 72	com/tencent/open/a/a:j	Landroid/os/HandlerThread;
    //   7: if_acmpeq +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 32	com/tencent/open/a/a:i	Z
    //   15: ifne -5 -> 10
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 32	com/tencent/open/a/a:i	Z
    //   23: aload_0
    //   24: invokespecial 112	com/tencent/open/a/a:i	()V
    //   27: aload_0
    //   28: getfield 48	com/tencent/open/a/a:h	Lcom/tencent/open/a/g;
    //   31: aload_0
    //   32: invokespecial 60	com/tencent/open/a/a:g	()Ljava/io/Writer;
    //   35: aload_0
    //   36: getfield 55	com/tencent/open/a/a:d	[C
    //   39: invokevirtual 115	com/tencent/open/a/g:a	(Ljava/io/Writer;[C)V
    //   42: aload_0
    //   43: getfield 48	com/tencent/open/a/a:h	Lcom/tencent/open/a/g;
    //   46: invokevirtual 116	com/tencent/open/a/g:b	()V
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 32	com/tencent/open/a/a:i	Z
    //   54: return
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 48	com/tencent/open/a/a:h	Lcom/tencent/open/a/g;
    //   60: invokevirtual 116	com/tencent/open/a/g:b	()V
    //   63: goto -14 -> 49
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 48	com/tencent/open/a/a:h	Lcom/tencent/open/a/g;
    //   71: invokevirtual 116	com/tencent/open/a/g:b	()V
    //   74: aload_1
    //   75: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   27	42	55	java/io/IOException
    //   27	42	66	finally
  }

  private Writer g()
  {
    File localFile = c().a();
    if ((localFile != null) && (!localFile.equals(this.c)))
    {
      this.c = localFile;
      h();
    }
    try
    {
      this.b = new FileWriter(this.c, true);
      return this.b;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  private void h()
  {
    try
    {
      if (this.b != null)
      {
        this.b.flush();
        this.b.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  private void i()
  {
    monitorenter;
    try
    {
      if (this.g == this.e)
        this.g = this.f;
      for (this.h = this.e; ; this.h = this.f)
      {
        return;
        this.g = this.e;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a()
  {
    if (this.k.hasMessages(1024))
      this.k.removeMessages(1024);
    this.k.sendEmptyMessage(1024);
  }

  protected void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(e().a(paramInt, paramThread, paramLong, paramString1, paramString2, paramThrowable));
  }

  public void a(b paramb)
  {
    this.a = paramb;
  }

  protected void a(String paramString)
  {
    this.g.a(paramString);
    if (this.g.a() >= c().f())
      a();
  }

  public void b()
  {
    h();
    this.j.quit();
  }

  public b c()
  {
    return this.a;
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 1024:
    }
    while (true)
    {
      return true;
      f();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.a.a
 * JD-Core Version:    0.6.0
 */