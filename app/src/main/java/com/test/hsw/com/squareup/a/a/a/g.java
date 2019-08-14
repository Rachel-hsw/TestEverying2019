package com.squareup.a.a.a;

import b.q;
import com.squareup.a.a;
import com.squareup.a.a.l;
import com.squareup.a.aa.a;
import com.squareup.a.ac;
import com.squareup.a.r.a;
import com.squareup.a.t;
import com.squareup.a.v;
import com.squareup.a.w;
import com.squareup.a.w.a;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocketFactory;

public final class g
{
  public static final int a = 20;
  private static final com.squareup.a.ab e = new h();
  final t b;
  long c = -1L;
  public final boolean d;
  private com.squareup.a.k f;
  private o g;
  private ac h;
  private final com.squareup.a.aa i;
  private r j;
  private boolean k;
  private final w l;
  private w m;
  private com.squareup.a.aa n;
  private com.squareup.a.aa o;
  private com.squareup.a.aa p;
  private b.aa q;
  private b.h r;
  private b.ab s;
  private b.i t;
  private InputStream u;
  private CacheRequest v;
  private b w;

  public g(t paramt, w paramw, boolean paramBoolean, com.squareup.a.k paramk, o paramo, n paramn, com.squareup.a.aa paramaa)
  {
    this.b = paramt;
    this.l = paramw;
    this.d = paramBoolean;
    this.f = paramk;
    this.g = paramo;
    this.q = paramn;
    this.i = paramaa;
    if (paramk != null)
    {
      com.squareup.a.a.g.a.b(paramk, this);
      this.h = paramk.d();
      return;
    }
    this.h = null;
  }

  private static com.squareup.a.aa a(com.squareup.a.aa paramaa)
  {
    if ((paramaa != null) && (paramaa.g() != null))
      paramaa = paramaa.h().a(null).a();
    return paramaa;
  }

  private static com.squareup.a.r a(com.squareup.a.r paramr1, com.squareup.a.r paramr2)
    throws IOException
  {
    r.a locala = new r.a();
    int i1 = 0;
    int i2 = paramr1.a();
    int i3 = 0;
    if (i1 < i2)
    {
      String str2 = paramr1.a(i1);
      String str3 = paramr1.b(i1);
      if (("Warning".equals(str2)) && (str3.startsWith("1")));
      while (true)
      {
        i1++;
        break;
        if ((k.a(str2)) && (paramr2.a(str2) != null))
          continue;
        locala.a(str2, str3);
      }
    }
    while (i3 < paramr2.a())
    {
      String str1 = paramr2.a(i3);
      if (k.a(str1))
        locala.a(str1, paramr2.b(i3));
      i3++;
    }
    return locala.a();
  }

  private w a(com.squareup.a.k paramk, w paramw)
    throws IOException
  {
    if (!paramk.d().f())
      return null;
    String str1 = paramw.a("User-Agent");
    if (str1 == null)
      str1 = q();
    String str2 = paramw.a().getHost();
    int i1 = l.a(paramw.a());
    if (i1 == l.a("https"));
    for (String str3 = str2; ; str3 = str2 + ":" + i1)
    {
      w.a locala = new w.a().a(new URL("https", str2, i1, "/")).a("Host", str3).a("User-Agent", str1).a("Proxy-Connection", "Keep-Alive");
      String str4 = paramw.a("Proxy-Authorization");
      if (str4 != null)
        locala.a("Proxy-Authorization", str4);
      return locala.d();
    }
  }

  public static String a(URL paramURL)
  {
    if (l.a(paramURL) != l.a(paramURL.getProtocol()))
      return paramURL.getHost() + ":" + paramURL.getPort();
    return paramURL.getHost();
  }

  private void a(b.ab paramab)
    throws IOException
  {
    this.s = paramab;
    if ((this.k) && ("gzip".equalsIgnoreCase(this.p.b("Content-Encoding"))))
    {
      this.p = this.p.h().b("Content-Encoding").b("Content-Length").a();
      this.t = q.a(new b.o(paramab));
      return;
    }
    this.t = q.a(paramab);
  }

  private void a(w paramw)
    throws IOException
  {
    if (this.f != null)
      throw new IllegalStateException();
    String str;
    SSLSocketFactory localSSLSocketFactory;
    if (this.g == null)
    {
      str = paramw.a().getHost();
      if ((str == null) || (str.length() == 0))
        throw new UnknownHostException(paramw.a().toString());
      if (!paramw.j())
        break label333;
      localSSLSocketFactory = this.b.j();
    }
    for (HostnameVerifier localHostnameVerifier = this.b.k(); ; localHostnameVerifier = null)
    {
      this.g = new o(new a(str, l.a(paramw.a()), this.b.i(), localSSLSocketFactory, localHostnameVerifier, this.b.l(), this.b.d(), this.b.q()), paramw.b(), this.b.e(), this.b.m(), com.squareup.a.a.e.a, com.squareup.a.a.g.a.b(this.b));
      this.f = this.g.a(paramw.d());
      com.squareup.a.a.g.a.b(this.f, this);
      if (!com.squareup.a.a.g.a.d(this.f))
      {
        com.squareup.a.a.g.a.a(this.f, this.b.a(), this.b.b(), this.b.c(), a(this.f, paramw));
        if (com.squareup.a.a.g.a.e(this.f))
          com.squareup.a.a.g.a.b(this.b.m(), this.f);
        com.squareup.a.a.g.a.b(this.b).b(this.f.d());
      }
      com.squareup.a.a.g.a.a(this.f, this.b.b(), this.b.c());
      this.h = this.f.d();
      return;
      label333: localSSLSocketFactory = null;
    }
  }

  private static boolean a(com.squareup.a.aa paramaa1, com.squareup.a.aa paramaa2)
  {
    if (paramaa2.c() == 304);
    Date localDate1;
    Date localDate2;
    do
    {
      return true;
      localDate1 = paramaa1.f().b("Last-Modified");
      if (localDate1 == null)
        break;
      localDate2 = paramaa2.f().b("Last-Modified");
    }
    while ((localDate2 != null) && (localDate2.getTime() < localDate1.getTime()));
    return false;
  }

  private w b(w paramw)
    throws IOException
  {
    w.a locala = paramw.h();
    if (paramw.a("User-Agent") == null)
      locala.a("User-Agent", q());
    if (paramw.a("Host") == null)
      locala.a("Host", a(paramw.a()));
    if (((this.f == null) || (this.f.m() != v.a)) && (paramw.a("Connection") == null))
      locala.a("Connection", "Keep-Alive");
    if (paramw.a("Accept-Encoding") == null)
    {
      this.k = true;
      locala.a("Accept-Encoding", "gzip");
    }
    if ((c()) && (paramw.a("Content-Type") == null))
      locala.a("Content-Type", "application/x-www-form-urlencoded");
    CookieHandler localCookieHandler = this.b.f();
    if (localCookieHandler != null)
    {
      Map localMap = k.a(locala.d().e(), null);
      k.a(locala, localCookieHandler.get(paramw.b(), localMap));
    }
    return locala.d();
  }

  private boolean b(IOException paramIOException)
  {
    if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException)));
    for (int i1 = 1; ; i1 = 0)
    {
      boolean bool = paramIOException instanceof ProtocolException;
      if ((i1 != 0) || (bool))
        break;
      return true;
    }
    return false;
  }

  public static String q()
  {
    String str = System.getProperty("http.agent");
    if (str != null)
      return str;
    return "Java" + System.getProperty("java.version");
  }

  private void t()
    throws IOException
  {
    com.squareup.a.a.h localh = com.squareup.a.a.g.a.a(this.b);
    if (localh == null);
    while (true)
    {
      return;
      if (b.a(this.p, this.m))
        break;
      if (!i.a(this.m.d()))
        continue;
      try
      {
        localh.b(this.m);
        return;
      }
      catch (IOException localIOException)
      {
        return;
      }
    }
    this.v = localh.a(a(this.p));
  }

  public g a(IOException paramIOException)
  {
    return a(paramIOException, this.q);
  }

  public g a(IOException paramIOException, b.aa paramaa)
  {
    if ((this.g != null) && (this.f != null))
      this.g.a(this.f, paramIOException);
    if ((paramaa == null) || ((paramaa instanceof n)));
    for (int i1 = 1; ((this.g == null) && (this.f == null)) || ((this.g != null) && (!this.g.a())) || (!b(paramIOException)) || (i1 == 0); i1 = 0)
      return null;
    com.squareup.a.k localk = o();
    return new g(this.b, this.l, this.d, localk, this.g, (n)paramaa, this.i);
  }

  public void a()
    throws IOException
  {
    if (this.w != null);
    while (true)
    {
      return;
      if (this.j != null)
        throw new IllegalStateException();
      w localw = b(this.l);
      com.squareup.a.a.h localh = com.squareup.a.a.g.a.a(this.b);
      com.squareup.a.aa localaa;
      if (localh != null)
        localaa = localh.a(localw);
      while (true)
      {
        this.w = new b.a(System.currentTimeMillis(), localw, localaa).a();
        this.m = this.w.a;
        this.n = this.w.b;
        if (localh != null)
          localh.a(this.w);
        if ((localaa != null) && (this.n == null))
          l.a(localaa.g());
        if (this.m != null)
        {
          if (this.f == null)
            a(this.m);
          if ((com.squareup.a.a.g.a.c(this.f) != this) && (!com.squareup.a.a.g.a.e(this.f)))
          {
            throw new AssertionError();
            localaa = null;
            continue;
          }
          this.j = com.squareup.a.a.g.a.a(this.f, this);
          if ((!c()) || (this.q != null))
            break;
          this.q = this.j.a(localw);
          return;
        }
      }
      if (this.f != null)
      {
        com.squareup.a.a.g.a.a(this.b.m(), this.f);
        this.f = null;
      }
      if (this.n != null);
      for (this.p = this.n.h().a(this.l).c(a(this.i)).b(a(this.n)).a(); this.p.g() != null; this.p = new aa.a().a(this.l).c(a(this.i)).a(v.b).a(504).a("Gateway Timeout").a(e).a())
      {
        a(this.p.g().c());
        return;
      }
    }
  }

  public void a(com.squareup.a.r paramr)
    throws IOException
  {
    CookieHandler localCookieHandler = this.b.f();
    if (localCookieHandler != null)
      localCookieHandler.put(this.l.b(), k.a(paramr, null));
  }

  public void b()
  {
    if (this.c != -1L)
      throw new IllegalStateException();
    this.c = System.currentTimeMillis();
  }

  public boolean b(URL paramURL)
  {
    URL localURL = this.l.a();
    return (localURL.getHost().equals(paramURL.getHost())) && (l.a(localURL) == l.a(paramURL)) && (localURL.getProtocol().equals(paramURL.getProtocol()));
  }

  boolean c()
  {
    return (i.b(this.l.d())) && (!l.a().equals(this.q));
  }

  public b.aa d()
  {
    if (this.w == null)
      throw new IllegalStateException();
    return this.q;
  }

  public b.h e()
  {
    b.h localh1 = this.r;
    if (localh1 != null)
      return localh1;
    b.aa localaa = d();
    if (localaa != null)
    {
      b.h localh2 = q.a(localaa);
      this.r = localh2;
      return localh2;
    }
    return null;
  }

  public boolean f()
  {
    return this.p != null;
  }

  public w g()
  {
    return this.l;
  }

  public com.squareup.a.aa h()
  {
    if (this.p == null)
      throw new IllegalStateException();
    return this.p;
  }

  public b.i i()
  {
    if (this.p == null)
      throw new IllegalStateException();
    return this.t;
  }

  public InputStream j()
  {
    InputStream localInputStream1 = this.u;
    if (localInputStream1 != null)
      return localInputStream1;
    InputStream localInputStream2 = q.a(i()).h();
    this.u = localInputStream2;
    return localInputStream2;
  }

  public com.squareup.a.k k()
  {
    return this.f;
  }

  public ac l()
  {
    return this.h;
  }

  public void m()
    throws IOException
  {
    if ((this.j != null) && (this.f != null))
      this.j.c();
    this.f = null;
  }

  public void n()
  {
    if (this.j != null);
    try
    {
      this.j.a(this);
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public com.squareup.a.k o()
  {
    if (this.r != null)
      l.a(this.r);
    while (this.t == null)
    {
      if (this.f != null)
        l.a(this.f.e());
      this.f = null;
      return null;
      if (this.q == null)
        continue;
      l.a(this.q);
    }
    l.a(this.t);
    l.a(this.u);
    if ((this.j != null) && (this.f != null) && (!this.j.d()))
    {
      l.a(this.f.e());
      this.f = null;
      return null;
    }
    if ((this.f != null) && (!com.squareup.a.a.g.a.a(this.f)))
      this.f = null;
    com.squareup.a.k localk = this.f;
    this.f = null;
    return localk;
  }

  public boolean p()
  {
    if (this.l.d().equals("HEAD"));
    do
    {
      return false;
      int i1 = this.p.c();
      if (((i1 < 100) || (i1 >= 200)) && (i1 != 204) && (i1 != 304))
        return true;
    }
    while ((k.a(this.o) == -1L) && (!"chunked".equalsIgnoreCase(this.o.b("Transfer-Encoding"))));
    return true;
  }

  public void r()
    throws IOException
  {
    if (this.p != null);
    do
    {
      return;
      if ((this.m != null) || (this.n != null))
        continue;
      throw new IllegalStateException("call sendRequest() first!");
    }
    while (this.m == null);
    if ((this.r != null) && (this.r.d().c() > 0L))
      this.r.b();
    if (this.c == -1L)
    {
      if ((k.a(this.m) == -1L) && ((this.q instanceof n)))
      {
        long l1 = ((n)this.q).c();
        this.m = this.m.h().a("Content-Length", Long.toString(l1)).d();
      }
      this.j.b(this.m);
    }
    if (this.q != null)
    {
      if (this.r == null)
        break label476;
      this.r.close();
    }
    while (true)
    {
      if (((this.q instanceof n)) && (!l.a().equals(this.q)))
        this.j.a((n)this.q);
      this.j.a();
      this.o = this.j.b().a(this.m).a(this.f.k()).a(k.b, Long.toString(this.c)).a(k.c, Long.toString(System.currentTimeMillis())).a();
      com.squareup.a.a.g.a.a(this.f, this.o.b());
      a(this.o.f());
      if (this.n == null)
        break label498;
      if (!a(this.n, this.o))
        break label488;
      this.p = this.n.h().a(this.l).c(a(this.i)).a(a(this.n.f(), this.o.f())).b(a(this.n)).a(a(this.o)).a();
      this.j.e();
      m();
      com.squareup.a.a.h localh = com.squareup.a.a.g.a.a(this.b);
      localh.a();
      localh.a(this.n, a(this.p));
      if (this.n.g() == null)
        break;
      a(this.n.g().c());
      return;
      label476: this.q.close();
    }
    label488: l.a(this.n.g());
    label498: this.p = this.o.h().a(this.l).c(a(this.i)).b(a(this.n)).a(a(this.o)).a();
    if (!p())
    {
      this.s = this.j.a(this.v);
      this.t = q.a(this.s);
      return;
    }
    t();
    a(this.j.a(this.v));
  }

  public w s()
    throws IOException
  {
    if (this.p == null)
      throw new IllegalStateException();
    if (l() != null);
    for (Proxy localProxy = l().b(); ; localProxy = this.b.d())
      switch (this.p.c())
      {
      default:
        return null;
      case 407:
      case 401:
      case 307:
      case 300:
      case 301:
      case 302:
      case 303:
      }
    if (localProxy.type() != Proxy.Type.HTTP)
      throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    return k.a(this.b.l(), this.p, localProxy);
    if ((!this.l.d().equals("GET")) && (!this.l.d().equals("HEAD")))
      return null;
    String str = this.p.b("Location");
    if (str == null)
      return null;
    URL localURL = new URL(this.l.a(), str);
    if ((!localURL.getProtocol().equals("https")) && (!localURL.getProtocol().equals("http")))
      return null;
    if ((!localURL.getProtocol().equals(this.l.a().getProtocol())) && (!this.b.n()))
      return null;
    w.a locala = this.l.h();
    if (i.b(this.l.d()))
    {
      locala.a("GET", null);
      locala.b("Transfer-Encoding");
      locala.b("Content-Length");
      locala.b("Content-Type");
    }
    if (!b(localURL))
      locala.b("Authorization");
    return locala.a(localURL).d();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.g
 * JD-Core Version:    0.6.0
 */