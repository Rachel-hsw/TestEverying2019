package com.squareup.a.a.a;

import com.squareup.a.a;
import com.squareup.a.a.e;
import com.squareup.a.a.g;
import com.squareup.a.ac;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;

public final class o
{
  public static final String a = "TLSv1";
  public static final String b = "SSLv3";
  private final a c;
  private final URI d;
  private final ProxySelector e;
  private final com.squareup.a.l f;
  private final e g;
  private final com.squareup.a.a.k h;
  private Proxy i;
  private InetSocketAddress j;
  private boolean k;
  private Proxy l;
  private Iterator<Proxy> m;
  private InetAddress[] n;
  private int o;
  private int p;
  private String q;
  private final List<ac> r;

  public o(a parama, URI paramURI, ProxySelector paramProxySelector, com.squareup.a.l paraml, e parame, com.squareup.a.a.k paramk)
  {
    this.c = parama;
    this.d = paramURI;
    this.e = paramProxySelector;
    this.f = paraml;
    this.g = parame;
    this.h = paramk;
    this.r = new LinkedList();
    a(paramURI, parama.h());
  }

  private void a(Proxy paramProxy)
    throws UnknownHostException
  {
    this.n = null;
    Object localObject;
    if (paramProxy.type() == Proxy.Type.DIRECT)
    {
      localObject = this.d.getHost();
      this.p = com.squareup.a.a.l.a(this.d);
    }
    while (true)
    {
      this.n = this.g.a((String)localObject);
      this.o = 0;
      return;
      SocketAddress localSocketAddress = paramProxy.address();
      if (!(localSocketAddress instanceof InetSocketAddress))
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localSocketAddress.getClass());
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)localSocketAddress;
      String str = localInetSocketAddress.getHostName();
      this.p = localInetSocketAddress.getPort();
      localObject = str;
    }
  }

  private void a(URI paramURI, Proxy paramProxy)
  {
    this.k = true;
    if (paramProxy != null)
      this.l = paramProxy;
    List localList;
    do
    {
      return;
      localList = this.e.select(paramURI);
    }
    while (localList == null);
    this.m = localList.iterator();
  }

  private boolean b()
  {
    return this.k;
  }

  private Proxy c()
  {
    if (this.l != null)
    {
      this.k = false;
      return this.l;
    }
    if (this.m != null)
      while (this.m.hasNext())
      {
        Proxy localProxy = (Proxy)this.m.next();
        if (localProxy.type() != Proxy.Type.DIRECT)
          return localProxy;
      }
    this.k = false;
    return Proxy.NO_PROXY;
  }

  private boolean d()
  {
    return this.n != null;
  }

  private InetSocketAddress e()
    throws UnknownHostException
  {
    InetAddress[] arrayOfInetAddress = this.n;
    int i1 = this.o;
    this.o = (i1 + 1);
    InetSocketAddress localInetSocketAddress = new InetSocketAddress(arrayOfInetAddress[i1], this.p);
    if (this.o == this.n.length)
    {
      this.n = null;
      this.o = 0;
    }
    return localInetSocketAddress;
  }

  private void f()
  {
    if (this.c.d() != null);
    for (String str = "TLSv1"; ; str = "SSLv3")
    {
      this.q = str;
      return;
    }
  }

  private boolean g()
  {
    return this.q != null;
  }

  private String h()
  {
    if (this.q == null)
      throw new IllegalStateException("No next TLS version");
    if (this.q.equals("TLSv1"))
    {
      this.q = "SSLv3";
      return "TLSv1";
    }
    if (this.q.equals("SSLv3"))
    {
      this.q = null;
      return "SSLv3";
    }
    throw new AssertionError();
  }

  private boolean i()
  {
    return !this.r.isEmpty();
  }

  private ac j()
  {
    return (ac)this.r.remove(0);
  }

  public com.squareup.a.k a(String paramString)
    throws IOException
  {
    while (true)
    {
      com.squareup.a.k localk = this.f.a(this.c);
      if (localk == null)
        break;
      if ((paramString.equals("GET")) || (g.a.f(localk)))
        return localk;
      localk.e().close();
    }
    if (!g())
    {
      if (!d())
      {
        if (!b())
        {
          if (!i())
            throw new NoSuchElementException();
          return new com.squareup.a.k(this.f, j());
        }
        this.i = c();
        a(this.i);
      }
      this.j = e();
      f();
    }
    String str = h();
    ac localac = new ac(this.c, this.i, this.j, str);
    if (this.h.c(localac))
    {
      this.r.add(localac);
      return a(paramString);
    }
    return new com.squareup.a.k(this.f, localac);
  }

  public void a(com.squareup.a.k paramk, IOException paramIOException)
  {
    if (g.a.b(paramk) > 0);
    while (true)
    {
      return;
      ac localac1 = paramk.d();
      if ((localac1.b().type() != Proxy.Type.DIRECT) && (this.e != null))
        this.e.connectFailed(this.d, localac1.b().address(), paramIOException);
      this.h.a(localac1);
      if (((paramIOException instanceof SSLHandshakeException)) || ((paramIOException instanceof SSLProtocolException)))
        continue;
      while (g())
      {
        ac localac2 = new ac(this.c, this.i, this.j, h());
        this.h.a(localac2);
      }
    }
  }

  public boolean a()
  {
    return (g()) || (d()) || (b()) || (i());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.o
 * JD-Core Version:    0.6.0
 */