package com.squareup.a;

import com.squareup.a.a.l;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a
{
  final Proxy a;
  final String b;
  final int c;
  final SocketFactory d;
  final SSLSocketFactory e;
  final HostnameVerifier f;
  final b g;
  final List<v> h;

  public a(String paramString, int paramInt, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, b paramb, Proxy paramProxy, List<v> paramList)
    throws UnknownHostException
  {
    if (paramString == null)
      throw new NullPointerException("uriHost == null");
    if (paramInt <= 0)
      throw new IllegalArgumentException("uriPort <= 0: " + paramInt);
    if (paramb == null)
      throw new IllegalArgumentException("authenticator == null");
    if (paramList == null)
      throw new IllegalArgumentException("protocols == null");
    this.a = paramProxy;
    this.b = paramString;
    this.c = paramInt;
    this.d = paramSocketFactory;
    this.e = paramSSLSocketFactory;
    this.f = paramHostnameVerifier;
    this.g = paramb;
    this.h = l.a(paramList);
  }

  public String a()
  {
    return this.b;
  }

  public int b()
  {
    return this.c;
  }

  public SocketFactory c()
  {
    return this.d;
  }

  public SSLSocketFactory d()
  {
    return this.e;
  }

  public HostnameVerifier e()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof a;
    int i = 0;
    if (bool1)
    {
      a locala = (a)paramObject;
      boolean bool2 = l.a(this.a, locala.a);
      i = 0;
      if (bool2)
      {
        boolean bool3 = this.b.equals(locala.b);
        i = 0;
        if (bool3)
        {
          int j = this.c;
          int k = locala.c;
          i = 0;
          if (j == k)
          {
            boolean bool4 = l.a(this.e, locala.e);
            i = 0;
            if (bool4)
            {
              boolean bool5 = l.a(this.f, locala.f);
              i = 0;
              if (bool5)
              {
                boolean bool6 = l.a(this.g, locala.g);
                i = 0;
                if (bool6)
                {
                  boolean bool7 = l.a(this.h, locala.h);
                  i = 0;
                  if (bool7)
                    i = 1;
                }
              }
            }
          }
        }
      }
    }
    return i;
  }

  public b f()
  {
    return this.g;
  }

  public List<v> g()
  {
    return this.h;
  }

  public Proxy h()
  {
    return this.a;
  }

  public int hashCode()
  {
    int i = 31 * (31 * (527 + this.b.hashCode()) + this.c);
    int j;
    int k;
    if (this.e != null)
    {
      j = this.e.hashCode();
      k = 31 * (j + i);
      if (this.f == null)
        break label128;
    }
    label128: for (int m = this.f.hashCode(); ; m = 0)
    {
      int n = 31 * (31 * (m + k) + this.g.hashCode());
      Proxy localProxy = this.a;
      int i1 = 0;
      if (localProxy != null)
        i1 = this.a.hashCode();
      return 31 * (n + i1) + this.h.hashCode();
      j = 0;
      break;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a
 * JD-Core Version:    0.6.0
 */