package com.squareup.a;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class ac
{
  final a a;
  final Proxy b;
  final InetSocketAddress c;
  final String d;

  public ac(a parama, Proxy paramProxy, InetSocketAddress paramInetSocketAddress, String paramString)
  {
    if (parama == null)
      throw new NullPointerException("address == null");
    if (paramProxy == null)
      throw new NullPointerException("proxy == null");
    if (paramInetSocketAddress == null)
      throw new NullPointerException("inetSocketAddress == null");
    if (paramString == null)
      throw new NullPointerException("tlsVersion == null");
    this.a = parama;
    this.b = paramProxy;
    this.c = paramInetSocketAddress;
    this.d = paramString;
  }

  public a a()
  {
    return this.a;
  }

  public Proxy b()
  {
    return this.b;
  }

  public InetSocketAddress c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  boolean e()
  {
    return !this.d.equals("SSLv3");
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ac;
    int i = 0;
    if (bool1)
    {
      ac localac = (ac)paramObject;
      boolean bool2 = this.a.equals(localac.a);
      i = 0;
      if (bool2)
      {
        boolean bool3 = this.b.equals(localac.b);
        i = 0;
        if (bool3)
        {
          boolean bool4 = this.c.equals(localac.c);
          i = 0;
          if (bool4)
          {
            boolean bool5 = this.d.equals(localac.d);
            i = 0;
            if (bool5)
              i = 1;
          }
        }
      }
    }
    return i;
  }

  public boolean f()
  {
    return (this.a.e != null) && (this.b.type() == Proxy.Type.HTTP);
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode()) + this.d.hashCode();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.ac
 * JD-Core Version:    0.6.0
 */