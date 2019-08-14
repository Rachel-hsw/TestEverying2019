package com.squareup.a;

import com.squareup.a.a.a.d;
import com.squareup.a.a.a.g;
import com.squareup.a.a.a.p;
import com.squareup.a.a.a.r;
import com.squareup.a.a.b.s;
import com.squareup.a.a.b.s.a;
import java.io.IOException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class k
{
  private final l a;
  private final ac b;
  private Socket c;
  private boolean d = false;
  private d e;
  private s f;
  private v g = v.b;
  private long h;
  private q i;
  private int j;
  private Object k;

  public k(l paraml, ac paramac)
  {
    this.a = paraml;
    this.b = paramac;
  }

  private void a(w paramw, int paramInt1, int paramInt2)
    throws IOException
  {
    com.squareup.a.a.j localj = com.squareup.a.a.j.a();
    if (paramw != null)
      b(paramw, paramInt1, paramInt2);
    this.c = this.b.a.e.createSocket(this.c, this.b.a.b, this.b.a.c, true);
    SSLSocket localSSLSocket = (SSLSocket)this.c;
    localj.a(localSSLSocket, this.b.a.b, this.b.d);
    if ((this.b.e()) && (this.b.a.h.size() > 1))
      localj.a(localSSLSocket, this.b.a.h);
    for (int m = 1; ; m = 0)
    {
      localSSLSocket.startHandshake();
      if (!this.b.a.f.verify(this.b.a.b, localSSLSocket.getSession()))
        throw new IOException("Hostname '" + this.b.a.b + "' was not verified");
      this.i = q.a(localSSLSocket.getSession());
      if (m != 0)
      {
        String str = localj.a(localSSLSocket);
        if (str != null)
          this.g = v.a(str);
      }
      if ((this.g == v.c) || (this.g == v.d))
      {
        localSSLSocket.setSoTimeout(0);
        this.f = new s.a(this.b.a.a(), true, this.c).a(this.g).a();
        this.f.g();
        return;
      }
      this.e = new d(this.a, this, this.c);
      return;
    }
  }

  private void b(w paramw, int paramInt1, int paramInt2)
    throws IOException
  {
    d locald = new d(this.a, this, this.c);
    locald.a(paramInt1, paramInt2);
    URL localURL = paramw.a();
    String str = "CONNECT " + localURL.getHost() + ":" + localURL.getPort() + " HTTP/1.1";
    while (true)
    {
      locald.a(paramw.e(), str);
      locald.d();
      aa localaa = locald.g().a(paramw).a();
      locald.i();
      switch (localaa.c())
      {
      default:
        throw new IOException("Unexpected response code for CONNECT: " + localaa.c());
      case 200:
        if (locald.e() <= 0L)
          break;
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407:
        paramw = com.squareup.a.a.a.k.a(this.b.a.g, localaa, this.b.b);
        if (paramw != null)
          continue;
        throw new IOException("Failed to authenticate with proxy");
      }
    }
  }

  r a(g paramg)
    throws IOException
  {
    if (this.f != null)
      return new p(paramg, this.f);
    return new com.squareup.a.a.a.j(paramg, this.e);
  }

  Object a()
  {
    synchronized (this.a)
    {
      Object localObject2 = this.k;
      return localObject2;
    }
  }

  void a(int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.d)
      throw new IllegalStateException("setTimeouts - not connected");
    if (this.e != null)
    {
      this.c.setSoTimeout(paramInt1);
      this.e.a(paramInt1, paramInt2);
    }
  }

  void a(int paramInt1, int paramInt2, int paramInt3, w paramw)
    throws IOException
  {
    if (this.d)
      throw new IllegalStateException("already connected");
    if (this.b.b.type() != Proxy.Type.HTTP)
    {
      this.c = new Socket(this.b.b);
      this.c.setSoTimeout(paramInt2);
      com.squareup.a.a.j.a().a(this.c, this.b.c, paramInt1);
      if (this.b.a.e == null)
        break label125;
      a(paramw, paramInt2, paramInt3);
    }
    while (true)
    {
      this.d = true;
      return;
      this.c = this.b.a.d.createSocket();
      break;
      label125: this.e = new d(this.a, this, this.c);
    }
  }

  void a(v paramv)
  {
    if (paramv == null)
      throw new IllegalArgumentException("protocol == null");
    this.g = paramv;
  }

  void a(Object paramObject)
  {
    if (l())
      return;
    synchronized (this.a)
    {
      if (this.k != null)
        throw new IllegalStateException("Connection already has an owner!");
    }
    this.k = paramObject;
    monitorexit;
  }

  boolean a(long paramLong)
  {
    return j() < System.nanoTime() - paramLong;
  }

  void b(Object paramObject)
    throws IOException
  {
    if (l())
      throw new IllegalStateException();
    synchronized (this.a)
    {
      if (this.k != paramObject)
        return;
      this.k = null;
      this.c.close();
      return;
    }
  }

  boolean b()
  {
    synchronized (this.a)
    {
      if (this.k == null)
        return false;
      this.k = null;
      return true;
    }
  }

  boolean c()
  {
    return this.d;
  }

  public ac d()
  {
    return this.b;
  }

  public Socket e()
  {
    return this.c;
  }

  boolean f()
  {
    return (!this.c.isClosed()) && (!this.c.isInputShutdown()) && (!this.c.isOutputShutdown());
  }

  boolean g()
  {
    if (this.e != null)
      return this.e.f();
    return true;
  }

  void h()
  {
    if (this.f != null)
      throw new IllegalStateException("spdyConnection != null");
    this.h = System.nanoTime();
  }

  boolean i()
  {
    return (this.f == null) || (this.f.c());
  }

  long j()
  {
    if (this.f == null)
      return this.h;
    return this.f.d();
  }

  public q k()
  {
    return this.i;
  }

  boolean l()
  {
    return this.f != null;
  }

  public v m()
  {
    return this.g;
  }

  void n()
  {
    this.j = (1 + this.j);
  }

  int o()
  {
    return this.j;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.k
 * JD-Core Version:    0.6.0
 */