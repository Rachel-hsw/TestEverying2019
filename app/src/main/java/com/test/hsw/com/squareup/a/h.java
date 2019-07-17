package com.squareup.a;

import com.squareup.a.a.a.g;
import com.squareup.a.a.a.n;
import com.squareup.a.a.l;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.URL;

public final class h
{
  volatile boolean a;
  g b;
  private final t c;
  private final p d;
  private int e;
  private boolean f;
  private w g;

  h(t paramt, p paramp, w paramw)
  {
    this.c = paramt;
    this.d = paramp;
    this.g = paramw;
  }

  private aa c()
    throws IOException
  {
    x localx = this.g.f();
    w.a locala;
    n localn;
    if (localx != null)
    {
      s locals = localx.a();
      if (locals == null)
        throw new IllegalStateException("contentType == null");
      locala = this.g.h();
      locala.a("Content-Type", locals.toString());
      long l = localx.b();
      if (l != -1L)
      {
        locala.a("Content-Length", Long.toString(l));
        locala.b("Transfer-Encoding");
        this.g = locala.d();
        localn = null;
      }
    }
    while (true)
    {
      label102: aa localaa;
      k localk;
      for (this.b = new g(this.c, this.g, false, null, null, localn, null); ; this.b = new g(this.c, this.g, false, localk, null, null, localaa))
      {
        w localw;
        while (true)
        {
          if (this.a)
          {
            return null;
            locala.a("Transfer-Encoding", "chunked");
            locala.b("Content-Length");
            break;
            if (!com.squareup.a.a.a.i.b(this.g.d()))
              break label437;
            localn = l.a();
            break label102;
          }
          try
          {
            this.b.a();
            if (this.g.f() != null)
            {
              b.h localh = this.b.e();
              this.g.f().a(localh);
            }
            this.b.r();
            localaa = this.b.h();
            localw = this.b.s();
            if (localw == null)
            {
              this.b.m();
              return localaa.h().a(new b(localaa, this.b.i())).a();
            }
          }
          catch (IOException localIOException)
          {
            g localg = this.b.a(localIOException, null);
            if (localg != null)
            {
              this.b = localg;
              continue;
            }
            throw localIOException;
          }
        }
        if (this.b.h().i())
        {
          int i = 1 + this.e;
          this.e = i;
          if (i > 20)
            throw new ProtocolException("Too many redirects: " + this.e);
        }
        if (!this.b.b(localw.a()))
          this.b.m();
        localk = this.b.o();
        this.g = localw;
      }
      label437: localn = null;
    }
  }

  public aa a()
    throws IOException
  {
    monitorenter;
    try
    {
      if (this.f)
        throw new IllegalStateException("Already Executed");
    }
    finally
    {
      monitorexit;
    }
    this.f = true;
    monitorexit;
    aa localaa = c();
    this.b.m();
    if (localaa == null)
      throw new IOException("Canceled");
    return localaa;
  }

  public void a(i parami)
  {
    monitorenter;
    try
    {
      if (this.f)
        throw new IllegalStateException("Already Executed");
    }
    finally
    {
      monitorexit;
    }
    this.f = true;
    monitorexit;
    this.d.a(new a(parami, null));
  }

  public void b()
  {
    this.a = true;
    if (this.b != null)
      this.b.n();
  }

  final class a extends com.squareup.a.a.i
  {
    private final i b;

    private a(i arg2)
    {
      super(arrayOfObject);
      Object localObject;
      this.b = localObject;
    }

    String a()
    {
      return h.a(h.this).a().getHost();
    }

    w b()
    {
      return h.a(h.this);
    }

    Object c()
    {
      return h.a(h.this).g();
    }

    h d()
    {
      return h.this;
    }

    // ERROR //
    protected void e()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   6: invokestatic 57	com/squareup/a/h:b	(Lcom/squareup/a/h;)Lcom/squareup/a/aa;
      //   9: astore 7
      //   11: aload_0
      //   12: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   15: getfield 60	com/squareup/a/h:a	Z
      //   18: istore 8
      //   20: iload 8
      //   22: ifeq +51 -> 73
      //   25: aload_0
      //   26: getfield 32	com/squareup/a/h$a:b	Lcom/squareup/a/i;
      //   29: aload_0
      //   30: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   33: invokestatic 19	com/squareup/a/h:a	(Lcom/squareup/a/h;)Lcom/squareup/a/w;
      //   36: new 54	java/io/IOException
      //   39: dup
      //   40: ldc 62
      //   42: invokespecial 65	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   45: invokeinterface 70 3 0
      //   50: aload_0
      //   51: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   54: getfield 73	com/squareup/a/h:b	Lcom/squareup/a/a/a/g;
      //   57: invokevirtual 79	com/squareup/a/a/a/g:o	()Lcom/squareup/a/k;
      //   60: pop
      //   61: aload_0
      //   62: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   65: invokestatic 82	com/squareup/a/h:c	(Lcom/squareup/a/h;)Lcom/squareup/a/p;
      //   68: aload_0
      //   69: invokevirtual 87	com/squareup/a/p:b	(Lcom/squareup/a/h$a;)V
      //   72: return
      //   73: aload_0
      //   74: getfield 32	com/squareup/a/h$a:b	Lcom/squareup/a/i;
      //   77: aload 7
      //   79: invokeinterface 90 2 0
      //   84: goto -34 -> 50
      //   87: astore_2
      //   88: iload_1
      //   89: ifeq +26 -> 115
      //   92: aload_0
      //   93: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   96: getfield 73	com/squareup/a/h:b	Lcom/squareup/a/a/a/g;
      //   99: invokevirtual 79	com/squareup/a/a/a/g:o	()Lcom/squareup/a/k;
      //   102: pop
      //   103: aload_0
      //   104: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   107: invokestatic 82	com/squareup/a/h:c	(Lcom/squareup/a/h;)Lcom/squareup/a/p;
      //   110: aload_0
      //   111: invokevirtual 87	com/squareup/a/p:b	(Lcom/squareup/a/h$a;)V
      //   114: return
      //   115: aload_0
      //   116: getfield 32	com/squareup/a/h$a:b	Lcom/squareup/a/i;
      //   119: aload_0
      //   120: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   123: invokestatic 19	com/squareup/a/h:a	(Lcom/squareup/a/h;)Lcom/squareup/a/w;
      //   126: aload_2
      //   127: invokeinterface 70 3 0
      //   132: aload_0
      //   133: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   136: getfield 73	com/squareup/a/h:b	Lcom/squareup/a/a/a/g;
      //   139: invokevirtual 79	com/squareup/a/a/a/g:o	()Lcom/squareup/a/k;
      //   142: pop
      //   143: aload_0
      //   144: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   147: invokestatic 82	com/squareup/a/h:c	(Lcom/squareup/a/h;)Lcom/squareup/a/p;
      //   150: aload_0
      //   151: invokevirtual 87	com/squareup/a/p:b	(Lcom/squareup/a/h$a;)V
      //   154: return
      //   155: astore_3
      //   156: aload_0
      //   157: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   160: getfield 73	com/squareup/a/h:b	Lcom/squareup/a/a/a/g;
      //   163: invokevirtual 79	com/squareup/a/a/a/g:o	()Lcom/squareup/a/k;
      //   166: pop
      //   167: aload_0
      //   168: getfield 12	com/squareup/a/h$a:a	Lcom/squareup/a/h;
      //   171: invokestatic 82	com/squareup/a/h:c	(Lcom/squareup/a/h;)Lcom/squareup/a/p;
      //   174: aload_0
      //   175: invokevirtual 87	com/squareup/a/p:b	(Lcom/squareup/a/h$a;)V
      //   178: aload_3
      //   179: athrow
      //   180: astore_2
      //   181: iconst_0
      //   182: istore_1
      //   183: goto -95 -> 88
      //
      // Exception table:
      //   from	to	target	type
      //   25	50	87	java/io/IOException
      //   73	84	87	java/io/IOException
      //   2	20	155	finally
      //   25	50	155	finally
      //   73	84	155	finally
      //   115	132	155	finally
      //   2	20	180	java/io/IOException
    }
  }

  private static class b extends ab
  {
    private final aa a;
    private final b.i b;

    b(aa paramaa, b.i parami)
    {
      this.a = paramaa;
      this.b = parami;
    }

    public s a()
    {
      String str = this.a.b("Content-Type");
      if (str != null)
        return s.a(str);
      return null;
    }

    public long b()
    {
      return com.squareup.a.a.a.k.a(this.a);
    }

    public b.i c()
    {
      return this.b;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.h
 * JD-Core Version:    0.6.0
 */