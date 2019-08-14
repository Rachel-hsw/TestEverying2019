package com.squareup.a;

import com.squareup.a.a.a.k;
import java.util.Collections;
import java.util.List;

public final class aa
{
  private final w a;
  private final v b;
  private final int c;
  private final String d;
  private final q e;
  private final r f;
  private final ab g;
  private aa h;
  private aa i;
  private final aa j;
  private volatile g k;

  private aa(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama).a();
    this.g = a.g(parama);
    this.h = a.h(parama);
    this.i = a.i(parama);
    this.j = a.j(parama);
  }

  public w a()
  {
    return this.a;
  }

  public String a(String paramString1, String paramString2)
  {
    String str = this.f.a(paramString1);
    if (str != null)
      paramString2 = str;
    return paramString2;
  }

  public List<String> a(String paramString)
  {
    return this.f.c(paramString);
  }

  public v b()
  {
    return this.b;
  }

  public String b(String paramString)
  {
    return a(paramString, null);
  }

  public int c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public q e()
  {
    return this.e;
  }

  public r f()
  {
    return this.f;
  }

  public ab g()
  {
    return this.g;
  }

  public a h()
  {
    return new a(this, null);
  }

  public boolean i()
  {
    switch (this.c)
    {
    case 304:
    case 305:
    case 306:
    default:
      return false;
    case 300:
    case 301:
    case 302:
    case 303:
    case 307:
    }
    return true;
  }

  public aa j()
  {
    return this.h;
  }

  public aa k()
  {
    return this.i;
  }

  public aa l()
  {
    return this.j;
  }

  public List<j> m()
  {
    if (this.c == 401);
    for (String str = "WWW-Authenticate"; ; str = "Proxy-Authenticate")
    {
      return k.b(f(), str);
      if (this.c != 407)
        break;
    }
    return Collections.emptyList();
  }

  public g n()
  {
    g localg1 = this.k;
    if (localg1 != null)
      return localg1;
    g localg2 = g.a(this.f);
    this.k = localg2;
    return localg2;
  }

  public String toString()
  {
    return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.c() + '}';
  }

  public static class a
  {
    private w a;
    private v b;
    private int c = -1;
    private String d;
    private q e;
    private r.a f;
    private ab g;
    private aa h;
    private aa i;
    private aa j;

    public a()
    {
      this.f = new r.a();
    }

    private a(aa paramaa)
    {
      this.a = aa.a(paramaa);
      this.b = aa.b(paramaa);
      this.c = aa.c(paramaa);
      this.d = aa.d(paramaa);
      this.e = aa.e(paramaa);
      this.f = aa.f(paramaa).c();
      this.g = aa.g(paramaa);
      this.h = aa.h(paramaa);
      this.i = aa.i(paramaa);
      this.j = aa.j(paramaa);
    }

    private void a(String paramString, aa paramaa)
    {
      if (aa.g(paramaa) != null)
        throw new IllegalArgumentException(paramString + ".body != null");
      if (aa.h(paramaa) != null)
        throw new IllegalArgumentException(paramString + ".networkResponse != null");
      if (aa.i(paramaa) != null)
        throw new IllegalArgumentException(paramString + ".cacheResponse != null");
      if (aa.j(paramaa) != null)
        throw new IllegalArgumentException(paramString + ".priorResponse != null");
    }

    private void d(aa paramaa)
    {
      if (aa.g(paramaa) != null)
        throw new IllegalArgumentException("priorResponse.body != null");
    }

    public a a(int paramInt)
    {
      this.c = paramInt;
      return this;
    }

    public a a(aa paramaa)
    {
      if (paramaa != null)
        a("networkResponse", paramaa);
      this.h = paramaa;
      return this;
    }

    public a a(ab paramab)
    {
      this.g = paramab;
      return this;
    }

    public a a(q paramq)
    {
      this.e = paramq;
      return this;
    }

    public a a(r paramr)
    {
      this.f = paramr.c();
      return this;
    }

    public a a(v paramv)
    {
      this.b = paramv;
      return this;
    }

    public a a(w paramw)
    {
      this.a = paramw;
      return this;
    }

    public a a(String paramString)
    {
      this.d = paramString;
      return this;
    }

    public a a(String paramString1, String paramString2)
    {
      this.f.b(paramString1, paramString2);
      return this;
    }

    public aa a()
    {
      if (this.a == null)
        throw new IllegalStateException("request == null");
      if (this.b == null)
        throw new IllegalStateException("protocol == null");
      if (this.c < 0)
        throw new IllegalStateException("code < 0: " + this.c);
      return new aa(this, null);
    }

    public a b(aa paramaa)
    {
      if (paramaa != null)
        a("cacheResponse", paramaa);
      this.i = paramaa;
      return this;
    }

    public a b(String paramString)
    {
      this.f.b(paramString);
      return this;
    }

    public a b(String paramString1, String paramString2)
    {
      this.f.a(paramString1, paramString2);
      return this;
    }

    public a c(aa paramaa)
    {
      if (paramaa != null)
        d(paramaa);
      this.j = paramaa;
      return this;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.aa
 * JD-Core Version:    0.6.0
 */