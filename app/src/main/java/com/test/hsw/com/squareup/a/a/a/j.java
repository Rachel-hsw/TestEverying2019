package com.squareup.a.a.a;

import b.ab;
import com.squareup.a.aa.a;
import com.squareup.a.ac;
import com.squareup.a.w;
import java.io.IOException;
import java.net.CacheRequest;
import java.net.Proxy;

public final class j
  implements r
{
  private final g b;
  private final d c;

  public j(g paramg, d paramd)
  {
    this.b = paramg;
    this.c = paramd;
  }

  public b.aa a(w paramw)
    throws IOException
  {
    long l = k.a(paramw);
    if (this.b.d)
    {
      if (l > 2147483647L)
        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
      if (l != -1L)
      {
        b(paramw);
        return new n((int)l);
      }
      return new n();
    }
    if ("chunked".equalsIgnoreCase(paramw.a("Transfer-Encoding")))
    {
      b(paramw);
      return this.c.h();
    }
    if (l != -1L)
    {
      b(paramw);
      return this.c.a(l);
    }
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }

  public ab a(CacheRequest paramCacheRequest)
    throws IOException
  {
    if (!this.b.p())
      return this.c.a(paramCacheRequest, 0L);
    if ("chunked".equalsIgnoreCase(this.b.h().b("Transfer-Encoding")))
      return this.c.a(paramCacheRequest, this.b);
    long l = k.a(this.b.h());
    if (l != -1L)
      return this.c.a(paramCacheRequest, l);
    return this.c.a(paramCacheRequest);
  }

  public void a()
    throws IOException
  {
    this.c.d();
  }

  public void a(g paramg)
    throws IOException
  {
    this.c.a(paramg);
  }

  public void a(n paramn)
    throws IOException
  {
    this.c.a(paramn);
  }

  public aa.a b()
    throws IOException
  {
    return this.c.g();
  }

  public void b(w paramw)
    throws IOException
  {
    this.b.b();
    String str = m.a(paramw, this.b.k().d().b().type(), this.b.k().m());
    this.c.a(paramw.e(), str);
  }

  public void c()
    throws IOException
  {
    if (d())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }

  public boolean d()
  {
    if ("close".equalsIgnoreCase(this.b.g().a("Connection")));
    do
      return false;
    while (("close".equalsIgnoreCase(this.b.h().b("Connection"))) || (this.c.c()));
    return true;
  }

  public void e()
    throws IOException
  {
    this.c.i();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.j
 * JD-Core Version:    0.6.0
 */