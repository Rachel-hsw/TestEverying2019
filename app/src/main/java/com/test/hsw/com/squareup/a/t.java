package com.squareup.a;

import com.squareup.a.a.a.a;
import com.squareup.a.a.k;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class t
  implements Cloneable
{
  private static SSLSocketFactory a;
  private final k b = new k();
  private p c = new p();
  private Proxy d;
  private List<v> e;
  private ProxySelector f;
  private CookieHandler g;
  private com.squareup.a.a.h h;
  private c i;
  private SocketFactory j;
  private SSLSocketFactory k;
  private HostnameVerifier l;
  private b m;
  private l n;
  private boolean o = true;
  private int p;
  private int q;
  private int r;

  static
  {
    com.squareup.a.a.g.a = new u();
  }

  private SSLSocketFactory t()
  {
    monitorenter;
    try
    {
      SSLSocketFactory localSSLSocketFactory1 = a;
      if (localSSLSocketFactory1 == null);
      try
      {
        SSLContext localSSLContext = SSLContext.getInstance("TLS");
        localSSLContext.init(null, null, null);
        a = localSSLContext.getSocketFactory();
        SSLSocketFactory localSSLSocketFactory2 = a;
        monitorexit;
        return localSSLSocketFactory2;
      }
      catch (GeneralSecurityException localGeneralSecurityException)
      {
        throw new AssertionError();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public int a()
  {
    return this.p;
  }

  public h a(w paramw)
  {
    return new h(r(), this.c, paramw);
  }

  public t a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("timeout < 0");
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    long l1 = paramTimeUnit.toMillis(paramLong);
    if (l1 > 2147483647L)
      throw new IllegalArgumentException("Timeout too large.");
    this.p = (int)l1;
    return this;
  }

  t a(com.squareup.a.a.h paramh)
  {
    this.h = paramh;
    this.i = null;
    return this;
  }

  public t a(b paramb)
  {
    this.m = paramb;
    return this;
  }

  public t a(c paramc)
  {
    this.i = paramc;
    if (paramc != null);
    for (com.squareup.a.a.h localh = paramc.a; ; localh = null)
    {
      this.h = localh;
      return this;
    }
  }

  public t a(l paraml)
  {
    this.n = paraml;
    return this;
  }

  public t a(p paramp)
  {
    if (paramp == null)
      throw new IllegalArgumentException("dispatcher == null");
    this.c = paramp;
    return this;
  }

  public t a(Object paramObject)
  {
    this.c.a(paramObject);
    return this;
  }

  public t a(CookieHandler paramCookieHandler)
  {
    this.g = paramCookieHandler;
    return this;
  }

  public t a(Proxy paramProxy)
  {
    this.d = paramProxy;
    return this;
  }

  public t a(ProxySelector paramProxySelector)
  {
    this.f = paramProxySelector;
    return this;
  }

  public t a(List<v> paramList)
  {
    List localList = com.squareup.a.a.l.a(paramList);
    if (!localList.contains(v.b))
      throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + localList);
    if (localList.contains(null))
      throw new IllegalArgumentException("protocols must not contain null");
    this.e = com.squareup.a.a.l.a(localList);
    return this;
  }

  public t a(SocketFactory paramSocketFactory)
  {
    this.j = paramSocketFactory;
    return this;
  }

  public t a(HostnameVerifier paramHostnameVerifier)
  {
    this.l = paramHostnameVerifier;
    return this;
  }

  public t a(SSLSocketFactory paramSSLSocketFactory)
  {
    this.k = paramSSLSocketFactory;
    return this;
  }

  public t a(boolean paramBoolean)
  {
    this.o = paramBoolean;
    return this;
  }

  public int b()
  {
    return this.q;
  }

  public t b(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("timeout < 0");
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    long l1 = paramTimeUnit.toMillis(paramLong);
    if (l1 > 2147483647L)
      throw new IllegalArgumentException("Timeout too large.");
    this.q = (int)l1;
    return this;
  }

  public int c()
  {
    return this.r;
  }

  public t c(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("timeout < 0");
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    long l1 = paramTimeUnit.toMillis(paramLong);
    if (l1 > 2147483647L)
      throw new IllegalArgumentException("Timeout too large.");
    this.r = (int)l1;
    return this;
  }

  public Proxy d()
  {
    return this.d;
  }

  public ProxySelector e()
  {
    return this.f;
  }

  public CookieHandler f()
  {
    return this.g;
  }

  com.squareup.a.a.h g()
  {
    return this.h;
  }

  public c h()
  {
    return this.i;
  }

  public SocketFactory i()
  {
    return this.j;
  }

  public SSLSocketFactory j()
  {
    return this.k;
  }

  public HostnameVerifier k()
  {
    return this.l;
  }

  public b l()
  {
    return this.m;
  }

  public l m()
  {
    return this.n;
  }

  public boolean n()
  {
    return this.o;
  }

  k o()
  {
    return this.b;
  }

  public p p()
  {
    return this.c;
  }

  public List<v> q()
  {
    return this.e;
  }

  t r()
  {
    t localt = s();
    if (localt.f == null)
      localt.f = ProxySelector.getDefault();
    if (localt.g == null)
      localt.g = CookieHandler.getDefault();
    if (localt.j == null)
      localt.j = SocketFactory.getDefault();
    if (localt.k == null)
      localt.k = t();
    if (localt.l == null)
      localt.l = com.squareup.a.a.c.b.a;
    if (localt.m == null)
      localt.m = a.a;
    if (localt.n == null)
      localt.n = l.b();
    if (localt.e == null)
    {
      v[] arrayOfv = new v[3];
      arrayOfv[0] = v.d;
      arrayOfv[1] = v.c;
      arrayOfv[2] = v.b;
      localt.e = com.squareup.a.a.l.a(arrayOfv);
    }
    return localt;
  }

  public t s()
  {
    try
    {
      t localt = (t)super.clone();
      return localt;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    throw new AssertionError();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.t
 * JD-Core Version:    0.6.0
 */