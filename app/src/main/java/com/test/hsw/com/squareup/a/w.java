package com.squareup.a;

import com.squareup.a.a.j;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public final class w
{
  private final URL a;
  private final String b;
  private final r c;
  private final x d;
  private final Object e;
  private volatile URI f;
  private volatile g g;

  private w(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama).a();
    this.d = a.d(parama);
    if (a.e(parama) != null);
    for (Object localObject = a.e(parama); ; localObject = this)
    {
      this.e = localObject;
      return;
    }
  }

  public String a(String paramString)
  {
    return this.c.a(paramString);
  }

  public URL a()
  {
    return this.a;
  }

  public URI b()
    throws IOException
  {
    try
    {
      URI localURI1 = this.f;
      if (localURI1 != null)
        return localURI1;
      URI localURI2 = j.a().a(this.a);
      this.f = localURI2;
      return localURI2;
    }
    catch (URISyntaxException localURISyntaxException)
    {
    }
    throw new IOException(localURISyntaxException.getMessage());
  }

  public List<String> b(String paramString)
  {
    return this.c.c(paramString);
  }

  public String c()
  {
    return this.a.toString();
  }

  public String d()
  {
    return this.b;
  }

  public r e()
  {
    return this.c;
  }

  public x f()
  {
    return this.d;
  }

  public Object g()
  {
    return this.e;
  }

  public a h()
  {
    return new a(this, null);
  }

  public g i()
  {
    g localg1 = this.g;
    if (localg1 != null)
      return localg1;
    g localg2 = g.a(this.c);
    this.g = localg2;
    return localg2;
  }

  public boolean j()
  {
    return a().getProtocol().equals("https");
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Request{method=").append(this.b).append(", url=").append(this.a).append(", tag=");
    if (this.e != this);
    for (Object localObject = this.e; ; localObject = null)
      return localObject + '}';
  }

  public static class a
  {
    private URL a;
    private String b;
    private r.a c;
    private x d;
    private Object e;

    public a()
    {
      this.b = "GET";
      this.c = new r.a();
    }

    private a(w paramw)
    {
      this.a = w.a(paramw);
      this.b = w.b(paramw);
      this.d = w.c(paramw);
      this.e = w.d(paramw);
      this.c = w.e(paramw).c();
    }

    public a a()
    {
      return a("GET", null);
    }

    public a a(r paramr)
    {
      this.c = paramr.c();
      return this;
    }

    public a a(x paramx)
    {
      return a("POST", paramx);
    }

    public a a(Object paramObject)
    {
      this.e = paramObject;
      return this;
    }

    public a a(String paramString)
    {
      try
      {
        a locala = a(new URL(paramString));
        return locala;
      }
      catch (MalformedURLException localMalformedURLException)
      {
      }
      throw new IllegalArgumentException("Malformed URL: " + paramString);
    }

    public a a(String paramString, x paramx)
    {
      if ((paramString == null) || (paramString.length() == 0))
        throw new IllegalArgumentException("method == null || method.length() == 0");
      this.b = paramString;
      this.d = paramx;
      return this;
    }

    public a a(String paramString1, String paramString2)
    {
      this.c.b(paramString1, paramString2);
      return this;
    }

    public a a(URL paramURL)
    {
      if (paramURL == null)
        throw new IllegalArgumentException("url == null");
      this.a = paramURL;
      return this;
    }

    public a b()
    {
      return a("HEAD", null);
    }

    public a b(x paramx)
    {
      return a("PUT", paramx);
    }

    public a b(String paramString)
    {
      this.c.b(paramString);
      return this;
    }

    public a b(String paramString1, String paramString2)
    {
      this.c.a(paramString1, paramString2);
      return this;
    }

    public a c()
    {
      return a("DELETE", null);
    }

    public a c(x paramx)
    {
      return a("PATCH", paramx);
    }

    public w d()
    {
      if (this.a == null)
        throw new IllegalStateException("url == null");
      return new w(this, null);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.w
 * JD-Core Version:    0.6.0
 */