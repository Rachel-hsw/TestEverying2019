package com.squareup.a.a.a;

import b.aa;
import b.ab;
import b.ac;
import b.e;
import b.h;
import b.i;
import com.squareup.a.aa.a;
import com.squareup.a.r;
import com.squareup.a.r.a;
import com.squareup.a.v;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

public final class d
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private static final int g = 6;
  private static final int h = 0;
  private static final int i = 1;
  private static final int j = 2;
  private static final String r = "\r\n";
  private static final byte[] s = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final byte[] t = { 48, 13, 10, 13, 10 };
  private final com.squareup.a.l k;
  private final com.squareup.a.k l;
  private final Socket m;
  private final i n;
  private final h o;
  private int p = 0;
  private int q = 0;

  public d(com.squareup.a.l paraml, com.squareup.a.k paramk, Socket paramSocket)
    throws IOException
  {
    this.k = paraml;
    this.l = paramk;
    this.m = paramSocket;
    this.n = b.q.a(b.q.b(paramSocket));
    this.o = b.q.a(b.q.a(paramSocket));
  }

  public aa a(long paramLong)
  {
    if (this.p != 1)
      throw new IllegalStateException("state: " + this.p);
    this.p = 2;
    return new d(paramLong, null);
  }

  public ab a(CacheRequest paramCacheRequest)
    throws IOException
  {
    if (this.p != 4)
      throw new IllegalStateException("state: " + this.p);
    this.p = 5;
    return new f(paramCacheRequest);
  }

  public ab a(CacheRequest paramCacheRequest, long paramLong)
    throws IOException
  {
    if (this.p != 4)
      throw new IllegalStateException("state: " + this.p);
    this.p = 5;
    return new e(paramCacheRequest, paramLong);
  }

  public ab a(CacheRequest paramCacheRequest, g paramg)
    throws IOException
  {
    if (this.p != 4)
      throw new IllegalStateException("state: " + this.p);
    this.p = 5;
    return new c(paramCacheRequest, paramg);
  }

  public void a()
  {
    this.q = 1;
    if (this.p == 0)
    {
      this.q = 0;
      com.squareup.a.a.g.a.a(this.k, this.l);
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
      this.n.a().a(paramInt1, TimeUnit.MILLISECONDS);
    if (paramInt2 != 0)
      this.o.a().a(paramInt2, TimeUnit.MILLISECONDS);
  }

  public void a(n paramn)
    throws IOException
  {
    if (this.p != 1)
      throw new IllegalStateException("state: " + this.p);
    this.p = 3;
    paramn.a(this.o);
  }

  public void a(r.a parama)
    throws IOException
  {
    while (true)
    {
      String str = this.n.t();
      if (str.length() == 0)
        break;
      com.squareup.a.a.g.a.a(parama, str);
    }
  }

  public void a(r paramr, String paramString)
    throws IOException
  {
    if (this.p != 0)
      throw new IllegalStateException("state: " + this.p);
    this.o.b(paramString).b("\r\n");
    for (int i1 = 0; i1 < paramr.a(); i1++)
      this.o.b(paramr.a(i1)).b(": ").b(paramr.b(i1)).b("\r\n");
    this.o.b("\r\n");
    this.p = 1;
  }

  public void a(Object paramObject)
    throws IOException
  {
    com.squareup.a.a.g.a.a(this.l, paramObject);
  }

  public boolean a(ab paramab, int paramInt)
  {
    try
    {
      int i1 = this.m.getSoTimeout();
      this.m.setSoTimeout(paramInt);
      try
      {
        boolean bool = com.squareup.a.a.l.a(paramab, paramInt);
        return bool;
      }
      finally
      {
        this.m.setSoTimeout(i1);
      }
    }
    catch (IOException localIOException)
    {
    }
    return false;
  }

  public void b()
    throws IOException
  {
    this.q = 2;
    if (this.p == 0)
    {
      this.p = 6;
      this.l.e().close();
    }
  }

  public boolean c()
  {
    return this.p == 6;
  }

  public void d()
    throws IOException
  {
    this.o.b();
  }

  public long e()
  {
    return this.n.d().c();
  }

  public boolean f()
  {
    try
    {
      int i1 = this.m.getSoTimeout();
      try
      {
        this.m.setSoTimeout(1);
        boolean bool = this.n.g();
        return !bool;
      }
      finally
      {
        this.m.setSoTimeout(i1);
      }
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return true;
    }
    catch (IOException localIOException)
    {
    }
    return false;
  }

  public aa.a g()
    throws IOException
  {
    if ((this.p != 1) && (this.p != 3))
      throw new IllegalStateException("state: " + this.p);
    q localq;
    aa.a locala;
    do
    {
      localq = q.a(this.n.t());
      locala = new aa.a().a(localq.c).a(localq.d).a(localq.e);
      r.a locala1 = new r.a();
      a(locala1);
      locala1.a(k.d, localq.c.toString());
      locala.a(locala1.a());
    }
    while (localq.d == 100);
    this.p = 4;
    return locala;
  }

  public aa h()
  {
    if (this.p != 1)
      throw new IllegalStateException("state: " + this.p);
    this.p = 2;
    return new b(null);
  }

  public void i()
    throws IOException
  {
    a(null, 0L);
  }

  private class a
  {
    protected final OutputStream a;
    protected boolean b;
    private final CacheRequest d;

    a(CacheRequest arg2)
      throws IOException
    {
      Object localObject;
      if (localObject != null);
      for (OutputStream localOutputStream = localObject.getBody(); ; localOutputStream = null)
      {
        if (localOutputStream == null)
          localObject = null;
        this.a = localOutputStream;
        this.d = localObject;
        return;
      }
    }

    protected final void a(e parame, long paramLong)
      throws IOException
    {
      if (this.a != null)
        parame.a(this.a, parame.c() - paramLong, paramLong);
    }

    protected final void a(boolean paramBoolean)
      throws IOException
    {
      if (d.b(d.this) != 5)
        throw new IllegalStateException("state: " + d.b(d.this));
      if (this.d != null)
        this.a.close();
      d.a(d.this, 0);
      if ((paramBoolean) && (d.c(d.this) == 1))
      {
        d.b(d.this, 0);
        com.squareup.a.a.g.a.a(d.d(d.this), d.e(d.this));
      }
      do
        return;
      while (d.c(d.this) != 2);
      d.a(d.this, 6);
      d.e(d.this).e();
    }

    protected final void b_()
    {
      if (this.d != null)
        this.d.abort();
      com.squareup.a.a.l.a(d.e(d.this).e());
      d.a(d.this, 6);
    }
  }

  private final class b
    implements aa
  {
    private final byte[] b = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 10 };
    private boolean c;

    private b()
    {
    }

    private void a(long paramLong)
      throws IOException
    {
      int i = 16;
      do
      {
        byte[] arrayOfByte = this.b;
        i--;
        arrayOfByte[i] = d.k()[(int)(0xF & paramLong)];
        paramLong >>>= 4;
      }
      while (paramLong != 0L);
      d.a(d.this).c(this.b, i, this.b.length - i);
    }

    public ac a()
    {
      return d.a(d.this).a();
    }

    public void a(e parame, long paramLong)
      throws IOException
    {
      if (this.c)
        throw new IllegalStateException("closed");
      if (paramLong == 0L)
        return;
      a(paramLong);
      d.a(d.this).a(parame, paramLong);
      d.a(d.this).b("\r\n");
    }

    public void b()
      throws IOException
    {
      monitorenter;
      try
      {
        boolean bool = this.c;
        if (bool);
        while (true)
        {
          return;
          d.a(d.this).b();
        }
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    public void close()
      throws IOException
    {
      monitorenter;
      try
      {
        boolean bool = this.c;
        if (bool);
        while (true)
        {
          return;
          this.c = true;
          d.a(d.this).b(d.j());
          d.a(d.this, 3);
        }
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }
  }

  private class c extends d.a
    implements ab
  {
    private static final int e = -1;
    private int f = -1;
    private boolean g = true;
    private final g h;

    c(CacheRequest paramg, g arg3)
      throws IOException
    {
      super(paramg);
      Object localObject;
      this.h = localObject;
    }

    private void b()
      throws IOException
    {
      if (this.f != -1)
        d.f(d.this).t();
      String str = d.f(d.this).t();
      int i = str.indexOf(";");
      if (i != -1)
        str = str.substring(0, i);
      try
      {
        this.f = Integer.parseInt(str.trim(), 16);
        if (this.f == 0)
        {
          this.g = false;
          r.a locala = new r.a();
          d.this.a(locala);
          this.h.a(locala.a());
          a(true);
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      throw new ProtocolException("Expected a hex chunk size but was " + str);
    }

    public ac a()
    {
      return d.f(d.this).a();
    }

    public long b(e parame, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.b)
        throw new IllegalStateException("closed");
      if (!this.g);
      do
      {
        return -1L;
        if ((this.f != 0) && (this.f != -1))
          break;
        b();
      }
      while (!this.g);
      long l = d.f(d.this).b(parame, Math.min(paramLong, this.f));
      if (l == -1L)
      {
        b_();
        throw new IOException("unexpected end of stream");
      }
      this.f = (int)(this.f - l);
      a(parame, l);
      return l;
    }

    public void close()
      throws IOException
    {
      if (this.b)
        return;
      if ((this.g) && (!d.this.a(this, 100)))
        b_();
      this.b = true;
    }
  }

  private final class d
    implements aa
  {
    private boolean b;
    private long c;

    private d(long arg2)
    {
      Object localObject;
      this.c = localObject;
    }

    public ac a()
    {
      return d.a(d.this).a();
    }

    public void a(e parame, long paramLong)
      throws IOException
    {
      if (this.b)
        throw new IllegalStateException("closed");
      com.squareup.a.a.l.a(parame.c(), 0L, paramLong);
      if (paramLong > this.c)
        throw new ProtocolException("expected " + this.c + " bytes but received " + paramLong);
      d.a(d.this).a(parame, paramLong);
      this.c -= paramLong;
    }

    public void b()
      throws IOException
    {
      if (this.b)
        return;
      d.a(d.this).b();
    }

    public void close()
      throws IOException
    {
      if (this.b)
        return;
      this.b = true;
      if (this.c > 0L)
        throw new ProtocolException("unexpected end of stream");
      d.a(d.this, 3);
    }
  }

  private class e extends d.a
    implements ab
  {
    private long e;

    public e(CacheRequest paramLong, long arg3)
      throws IOException
    {
      super(paramLong);
      Object localObject;
      this.e = localObject;
      if (this.e == 0L)
        a(true);
    }

    public ac a()
    {
      return d.f(d.this).a();
    }

    public long b(e parame, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.b)
        throw new IllegalStateException("closed");
      if (this.e == 0L)
        return -1L;
      long l = d.f(d.this).b(parame, Math.min(this.e, paramLong));
      if (l == -1L)
      {
        b_();
        throw new ProtocolException("unexpected end of stream");
      }
      this.e -= l;
      a(parame, l);
      if (this.e == 0L)
        a(true);
      return l;
    }

    public void close()
      throws IOException
    {
      if (this.b)
        return;
      if ((this.e != 0L) && (!d.this.a(this, 100)))
        b_();
      this.b = true;
    }
  }

  class f extends d.a
    implements ab
  {
    private boolean e;

    f(CacheRequest arg2)
      throws IOException
    {
      super(localCacheRequest);
    }

    public ac a()
    {
      return d.f(d.this).a();
    }

    public long b(e parame, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.b)
        throw new IllegalStateException("closed");
      if (this.e)
        return -1L;
      long l = d.f(d.this).b(parame, paramLong);
      if (l == -1L)
      {
        this.e = true;
        a(false);
        return -1L;
      }
      a(parame, l);
      return l;
    }

    public void close()
      throws IOException
    {
      if (this.b)
        return;
      if (!this.e)
        b_();
      this.b = true;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.d
 * JD-Core Version:    0.6.0
 */